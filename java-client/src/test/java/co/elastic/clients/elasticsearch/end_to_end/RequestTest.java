/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package co.elastic.clients.elasticsearch.end_to_end;

import co.elastic.clients.elasticsearch.ElasticsearchAsyncClient;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch._types.aggregations.HistogramAggregate;
import co.elastic.clients.elasticsearch.cat.NodesResponse;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.bulk.OperationType;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import co.elastic.clients.elasticsearch.indices.DiskUsageResponse;
import co.elastic.clients.elasticsearch.indices.GetIndexResponse;
import co.elastic.clients.elasticsearch.indices.IndexState;
import co.elastic.clients.elasticsearch.model.ModelTestCase;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.jsonb.JsonbJsonpMapper;
import co.elastic.clients.transport.BooleanResponse;
import co.elastic.clients.transport.Header;
import co.elastic.clients.transport.Transport;
import co.elastic.clients.transport.TransportOptions;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import jakarta.json.Json;
import jakarta.json.JsonValue;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.ResponseException;
import org.elasticsearch.client.RestClient;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testcontainers.elasticsearch.ElasticsearchContainer;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class RequestTest extends Assert {

    private static ElasticsearchContainer container;
    private static final JsonpMapper mapper = new JsonbJsonpMapper();
    private static RestClient restClient;
    private static Transport transport;
    private static ElasticsearchClient client;

    @BeforeClass
    public static void setup() {
        container = new ElasticsearchContainer("docker.elastic.co/elasticsearch/elasticsearch:7.15.1")
            .withEnv("ES_JAVA_OPTS", "-Xms256m -Xmx256m")
            .withStartupTimeout(Duration.ofSeconds(30))
            .withPassword("changeme");
        container.start();

        BasicCredentialsProvider credsProv = new BasicCredentialsProvider();
        credsProv.setCredentials(
            AuthScope.ANY, new UsernamePasswordCredentials("elastic", "changeme")
        );
        restClient = RestClient.builder(new HttpHost("localhost", container.getMappedPort(9200)))
            .setHttpClientConfigCallback(hc -> hc.setDefaultCredentialsProvider(credsProv))
            .build();
        transport = new RestClientTransport(restClient, mapper);
        client = new ElasticsearchClient(transport);
    }

    @AfterClass
    public static void tearDown() {
        if (container != null) {
            container.stop();
        }
    }

    @Test
    public void testCount() throws Exception {
        // Tests that a no-parameter method exists for endpoints that only have optional properties
        assertTrue(client.count().count() >= 0);
    }

    @Test
    public void testIndexCreation() throws Exception {
        ElasticsearchAsyncClient asyncClient = new ElasticsearchAsyncClient(transport);

        // Ping the server
        assertTrue(client.ping().value());

        // Create an index...
        final CreateIndexResponse createResponse = client.indices().create(b -> b.index("my-index"));
        assertTrue(createResponse.acknowledged());
        assertTrue(createResponse.shardsAcknowledged());

        // Find info about it, using the async client
        CompletableFuture<GetIndexResponse> futureResponse = asyncClient.indices().get(b -> b.index("my-index"));
        GetIndexResponse response = futureResponse.get(10, TimeUnit.SECONDS);

        Map<String, IndexState> indices = response.result();

        assertEquals(1, indices.size());
        assertNotNull(indices.get("my-index"));
    }

    @Test
    public void testDataIngestion() throws Exception {

        String index = "ingest-test";

        // Create an index
        CreateIndexResponse createIndexResponse = client.indices().create(b -> b
            .index(index)
        );

        assertEquals(index, createIndexResponse.index());

        // Check that it actually exists. Example of a boolean response
        BooleanResponse existsResponse = client.indices().exists(b -> b.index(index));
        assertTrue(existsResponse.value());

        // Ingest some data
        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        String docId = client.index(b -> b
            .index(index)
            .id("my/Id") // test with url-unsafe string
            .document(appData)
            .refresh(JsonValue.TRUE) // Make it visible for search
        ).id();

        assertEquals("my/Id", docId);

        // Query by id
        AppData esData = client.get(b -> b
                .index(index)
                .id(docId)
            , AppData.class
        ).source();

        assertEquals(1337, esData.getIntValue());
        assertEquals("foo", esData.getMsg());

        // Search, adding some request options
        TransportOptions options = TransportOptions.DEFAULT.toBuilder()
                .withHeader(
                        Header.raw("x-super-header", "bar"))
                .build();

        SearchResponse<AppData> search = new ElasticsearchClient(
            ((RestClientTransport) client._transport()).withRequestOptions(options)
        )
            .search(b -> b
                .index(index)
                , AppData.class
        );

        long hits = search.hits().total().value();
        assertEquals(1, hits);

        esData = search.hits().hits().get(0).source();
        assertEquals(1337, esData.getIntValue());
        assertEquals("foo", esData.getMsg());
    }

    @Test
    public void testCatRequest() throws IOException {
        // Cat requests should have the "format=json" added by the transport
        NodesResponse nodes = client.cat().nodes(_0 -> _0);
        System.out.println(ModelTestCase.toJson(nodes, mapper));

        assertEquals(1, nodes.valueBody().size());
        assertEquals("*", nodes.valueBody().get(0).master());
    }

    @Test
    public void testBulkRequest() throws IOException {
        AppData appData = new AppData();
        appData.setIntValue(42);
        appData.setMsg("Some message");

        BulkResponse bulk = client.bulk(_0 -> _0
            .operations(_1 -> _1
                .create(_2 -> _2
                    .index("foo")
                    .id("abc")
                    .document(appData)
                ), _1 -> _1
                .create(_2 -> _2
                    .index("foo")
                    .id("def")
                    .document(appData)
                )
            )
        );

        assertFalse(bulk.errors());
        assertEquals(2, bulk.items().size());
        assertEquals(OperationType.Create, bulk.items().get(0).operationType());
        assertEquals("foo", bulk.items().get(0).index());
        assertEquals(1L, bulk.items().get(0).version().longValue());
        assertEquals("foo", bulk.items().get(1).index());
        assertEquals(1L, bulk.items().get(1).version().longValue());
    }

    @Test
    public void testRefresh() throws IOException {
        AppData appData = new AppData();
        appData.setIntValue(42);
        appData.setMsg("Some message");

        IndexResponse ir = client.index(_0 -> _0
            .index("test")
            .id("1")
            .document(appData)
            .refresh(Json.createValue("wait_for"))
        );

        assertEquals("1", ir.id());
    }

    @Test public void errorResponse() throws Exception {
        BooleanResponse exists = client.exists(_0 -> _0.index("doesnotexist").id("reallynot"));
        assertFalse(exists.value());

        try {
            GetResponse<String> response = client.get(
                _0 -> _0.index("doesnotexist").id("reallynot"), String.class
            );
        } catch(ElasticsearchException ex) {
            assertEquals(404, ex.status());
            assertEquals("index_not_found_exception", ex.error().type());
            assertEquals("doesnotexist", ex.error().metadata().get("index").to(String.class));
        }

        try {
            ElasticsearchAsyncClient aClient = new ElasticsearchAsyncClient(transport);
            GetResponse<String> response = aClient.get(
                _0 -> _0.index("doesnotexist").id("reallynot"), String.class
            ).get();
        } catch(ExecutionException ee) {
            ElasticsearchException ex = ((ElasticsearchException) ee.getCause());
            assertEquals(404, ex.status());
            assertEquals("index_not_found_exception", ex.error().type());
        }
    }

    @Test
    public void testSearchScroll() {
        // https://github.com/elastic/elasticsearch-java/issues/36
        assertThrows(ResponseException.class, () ->
            client.clearScroll(b -> b.scrollId("DXF1ZXJ5QW5kRmV0Y2gBAAAAAAAAAD4WYm9laVYtZndUQlNsdDcwakFMNjU1QQ=="))
        );

        assertThrows(ResponseException.class, () ->
            client.closePointInTime(b -> b.id(
            "46ToAwMDaWR5BXV1aWQyKwZub2RlXzMAAAAAAAAAACoBYwADaWR4BXV1aWQxAgZub2RlXzEAAAAAAAAAAAEBY" +
                "QADaWR5BXV1aWQyKgZub2RlXzIAAAAAAAAAAAwBYgACBXV1aWQyAAAFdXVpZDEAAQltYXRjaF9hbGw_gAAAAA=="))
        );
    }

    @Test
    public void testSearchAggregation() throws IOException {

        client.create(_1 -> _1.index("products").id("A").document(new Product(5)).refresh(Json.createValue("true")));
        client.create(_1 -> _1.index("products").id("B").document(new Product(15)).refresh(Json.createValue("true")));
        client.create(_1 -> _1.index("products").id("C").document(new Product(25)).refresh(Json.createValue("true")));

        SearchResponse<Product> searchResponse = client.search(_1 -> _1
            .index("products")
            .size(0)
            .aggregations("prices", _2 -> _2
                .histogram(_3 -> _3
                    .field("price")
                    .interval(10.0)
                )
                .aggregations("average", _3 -> _3
                    .avg(_4 -> _4
                        .field("price")
                    )
                )
            )
            , Product.class
        );

        HistogramAggregate prices = searchResponse.aggregations().get("prices").histogram();
        assertEquals(3, prices.buckets().size());
        assertEquals(1, prices.buckets().get(0).docCount());
        assertEquals(5.0, prices.buckets().get(0).aggregations().get("average").avg().value(), 0.01);

        // We've set "size" to zero
        assertEquals(0, searchResponse.hits().hits().size());

    }

    @Test
    public void testValueBodyResponse() throws Exception {
        DiskUsageResponse resp = client.indices().diskUsage(b -> b
            .index("*")
            .allowNoIndices(true)
            .runExpensiveTasks(true)
        );

        assertNotNull(resp.valueBody().toJson().asJsonObject().get("_shards"));
    }

    public static class AppData {
        private int intValue;
        private String msg;

        public int getIntValue() {
            return intValue;
        }

        public void setIntValue(int intValue) {
            this.intValue = intValue;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    public static class Product {
        public double price;

        public Product() {}
        public Product(double price) {
            this.price = price;
        }

        public double getPrice() {
            return this.price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}