/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

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

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

package org.opensearch.client.opensearch.integTest;

import jakarta.json.Json;
import jakarta.json.JsonValue;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.jsonb.JsonbJsonpMapper;
import org.opensearch.client.opensearch._types.aggregations.HistogramAggregate;
import org.opensearch.client.opensearch.cat.NodesResponse;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.client.opensearch.core.IndexResponse;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.core.bulk.OperationType;
import org.opensearch.client.opensearch.indices.CreateIndexResponse;
import org.opensearch.client.opensearch.indices.GetIndexResponse;
import org.opensearch.client.opensearch.indices.IndexState;
import org.opensearch.client.opensearch.model.ModelTestCase;
import org.opensearch.client.transport.BooleanResponse;

import java.io.IOException;
import java.util.Map;

public class RequestsTest extends OpenSearchRestHighLevelClientTestCase {

    private static final JsonpMapper mapper = new JsonbJsonpMapper();

    public void testCount() throws Exception {
        // Tests that a no-parameter method exists for endpoints that only have optional properties
        assertTrue(highLevelClient().count().count() >= 0);
    }

    public void testIndexCreation() throws Exception {
        // Ping the server
        assertTrue(highLevelClient().ping().value());

        // Create an index...
        final CreateIndexResponse createResponse = highLevelClient().indices().create(b -> b.index("my-index"));
        assertTrue(createResponse.acknowledged());
        assertTrue(createResponse.shardsAcknowledged());

        // Find info about it, using the async client
        GetIndexResponse response = highLevelClient().indices().get(b -> b.index("my-index"));
        Map<String, IndexState> indices = response.result();
        assertEquals(1, indices.size());
        assertNotNull(indices.get("my-index"));
    }

    public void testDataIngestion() throws Exception {

        String index = "ingest-test";

        // Create an index
        CreateIndexResponse createIndexResponse = highLevelClient().indices().create(b -> b
                .index(index)
        );

        assertEquals(index, createIndexResponse.index());

        // Check that it actually exists. Example of a boolean response
        BooleanResponse existsResponse = highLevelClient().indices().exists(b -> b.index(index));
        assertTrue(existsResponse.value());

        // Ingest some data
        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        String docId = highLevelClient().index(b -> b
                .index(index)
                .id("my/Id") // test with url-unsafe string
                .document(appData)
                .refresh(JsonValue.TRUE) // Make it visible for search
        ).id();

        assertEquals("my/Id", docId);

        // Query by id
        AppData esData = highLevelClient().get(b -> b
                        .index(index)
                        .id(docId)
                , AppData.class
        ).source();

        assertEquals(1337, esData.getIntValue());
        assertEquals("foo", esData.getMsg());

        // Search
        SearchResponse<AppData> search = highLevelClient().search(b -> b
                        .index(index)
                , AppData.class
        );

        long hits = search.hits().total().value();
        assertEquals(1, hits);

        esData = search.hits().hits().get(0).source();
        assertEquals(1337, esData.getIntValue());
        assertEquals("foo", esData.getMsg());
    }


    public void testCatRequest() throws IOException {
        // Cat requests should have the "format=json" added by the transport
        NodesResponse nodes = highLevelClient().cat().nodes(_0 -> _0);
        System.out.println(ModelTestCase.toJson(nodes, mapper));

        assertEquals(1, nodes.valueBody().size());
        assertEquals("*", nodes.valueBody().get(0).master());
    }


    public void testBulkRequest() throws IOException {
        AppData appData = new AppData();
        appData.setIntValue(42);
        appData.setMsg("Some message");

        BulkResponse bulk = highLevelClient().bulk(_0 -> _0
                .operations(_1 -> _1
                        .create(_2 -> _2
                                .index("foo")
                                .id("abc")
                                .document(appData)
                        ))
//                .operations(_1 -> _1
//                        .create(_2 -> _2
//                                .index("foo")
//                                .id("def")
//                                .document(appData)
//                        ))
        );

        assertFalse(bulk.errors());
        assertEquals(1, bulk.items().size());
        assertEquals(OperationType.Create, bulk.items().get(0).operationType());
        assertEquals("foo", bulk.items().get(0).index());
        assertEquals(1L, bulk.items().get(0).version().longValue());
//        assertEquals("foo", bulk.items().get(1).index());
//        assertEquals(1L, bulk.items().get(1).version().longValue());
    }


    public void testRefresh() throws IOException {
        AppData appData = new AppData();
        appData.setIntValue(42);
        appData.setMsg("Some message");

        IndexResponse ir = highLevelClient().index(_0 -> _0
                .index("test")
                .id("1")
                .document(appData)
                .refresh(Json.createValue("wait_for"))
        );
        assertEquals("1", ir.id());
    }

//    public void testErrorResponse() throws Exception {
//        BooleanResponse exists = highLevelClient().exists(_0 -> _0.index("doesnotexist").id("reallynot"));
//        assertFalse(exists.value());
//
//        OpensearchException ex = assertThrows(OpensearchException.class, () -> {
//            GetResponse<String> response = highLevelClient().get(
//                    _0 -> _0.index("doesnotexist").id("reallynot"), String.class
//            );
//        });
//
//        assertEquals(404, ex.status());
//        assertEquals("index_not_found_exception", ex.error().type());
//        assertEquals("doesnotexist", ex.error().metadata().get("index").to(String.class));
//
//        ExecutionException ee = assertThrows(ExecutionException.class, () -> {
//
//            GetResponse<String> response = highLevelClient().get(
//                    _0 -> _0.index("doesnotexist").id("reallynot"), String.class
//            );
//        });
//
//        ex = ((OpensearchException) ee.getCause());
//        assertEquals(404, ex.status());
//        assertEquals("index_not_found_exception", ex.error().type());
//    }

    public void testSearchAggregation() throws IOException {

        highLevelClient().create(_1 -> _1.index("products").id("A").document(new Product(5)).refresh(JsonValue.TRUE));
        highLevelClient().create(_1 -> _1.index("products").id("B").document(new Product(15)).refresh(JsonValue.TRUE));
        highLevelClient().create(_1 -> _1.index("products").id("C").document(new Product(25)).refresh(JsonValue.TRUE));

        SearchResponse<Product> searchResponse = highLevelClient().search(_1 -> _1
                        .index("products")
                        .size(0)
                        .aggregations(
                                "prices", _3 -> _3
                                        .histogram(_4 -> _4
                                                .field("price")
                                                .interval(10.0)
                                        ).aggregations(
                                                "average", _5 -> _5
                                                        .avg(_6 -> _6.field("price"))
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

//    TODO - fix get mapping response
//    public void testGetMapping() throws Exception {
//        String index = "testindex";
//
//        Map<String, Property> fields = Collections.singletonMap("keyword", Property.of(p -> p.keyword(k -> k.ignoreAbove(256))));
//        Property text = Property.of(p -> p.text(t -> t.fields(fields)));
//
//        highLevelClient().indices().create(c -> c
//                .index(index)
//                .mappings(m -> m
//                        .properties(Collections.singletonMap("id", text))
//                        .properties("name", p -> p
//                                .object(o -> o
//                                        .properties(Collections.singletonMap("first", text))
//                                        .properties(Collections.singletonMap("last", text))
//                                )
//                        )
//                )
//        );
//
//        GetMappingResponse mr = highLevelClient().indices().getMapping(new GetMappingRequest.Builder().index(index).build());
//
//        assertNotNull(mr.result().get(index));
//        assertNotNull(mr.result().get(index).mappings().properties().get("name").object());
//    }

//    public void testValueBodyResponse() throws Exception {
//        DiskUsageResponse resp = highLevelClient().indices().diskUsage(b -> b
//                .index("*")
//                .allowNoIndices(true)
//                .runExpensiveTasks(true)
//        );
//
//        assertNotNull(resp.valueBody().toJson().asJsonObject().get("_shards"));
//    }

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

        public Product() {
        }

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
