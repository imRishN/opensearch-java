/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import jakarta.json.JsonValue;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.opensearch.client.opensearch._types.Result;
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.client.opensearch.core.GetResponse;
import org.opensearch.client.opensearch.core.IndexResponse;
import org.opensearch.client.opensearch.core.bulk.Operation;
import org.opensearch.client.opensearch.core.bulk.ResponseItem;
import org.opensearch.client.opensearch.indices.CreateIndexResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CrudIT extends OpenSearchRestHighLevelClientTestCase {

//    public void testDelete() throws IOException {
////        {
////            // Testing index deletion
////            String index1 = "my-index";
////            CreateIndexResponse createIndexResponse = highLevelClient().indices().create(b -> b.index(index1));
////            assertEquals(index1, createIndexResponse.index());
////            assertTrue(createIndexResponse.acknowledged());
////            assertTrue(createIndexResponse.shardsAcknowledged());
////            DeleteIndexResponse deleteIndexResponse = highLevelClient().indices().delete(b -> b.index(index1));
////            assertTrue(deleteIndexResponse.acknowledged());
////        }
//
//        {
//            // Testing doc deletion after data ingestion
//            String docId = "id";
//            String index = "my-index1";
//            highLevelClient().indices().create(b -> b.index(index));
//
////            String id = highLevelClient().index(b -> b
////                    .index(index)
////                    .id(docId)
////                    .document(Collections.singletonMap("foo", "bar")))
////                    .id();
////
////            assertEquals(id, docId);
//
////            DeleteResponse deleteResponse = highLevelClient().delete(d -> d.id(docId).index(index));
////            assertEquals(deleteResponse.index(), index);
////            assertEquals(deleteResponse.id(), docId);
////            assertEquals(deleteResponse.type(), "_doc");
////            assertEquals(deleteResponse.result().jsonValue(), Result.Deleted.jsonValue());
//
//            //TODO Expected - OpensearchException
//            String docIdTemp = "does_not_exist";
//            OpensearchException ex = assertThrows(OpensearchException.class, () -> {
//                DeleteResponse delResponse = highLevelClient().delete(d -> d.index(index).id(docIdTemp));
//            });
//
//            assertNotNull(ex);
//
////            // Testing deletion of non existing document
////            String docIdTemp = "does_not_exist";
////            DeleteResponse deleteResponseDocNotExist = highLevelClient().delete(d -> d.id(docIdTemp).index(index));
////            assertEquals(index, deleteResponseDocNotExist.index());
////            assertEquals("_doc", deleteResponseDocNotExist.type());
////            assertEquals(docIdTemp, deleteResponseDocNotExist.id());
////            assertEquals(Result.NotFound.jsonValue(), deleteResponseDocNotExist.result().jsonValue());
//
//        }
//        {
//            // Testing version conflict
//            String docId = "version_conflict";
//            String index = "my-index-version-conflict";
//            highLevelClient().indices().create(b -> b.index(index));
//
//            highLevelClient().index(b -> b
//                    .index(index)
//                    .id(docId)
//                    .document(Collections.singletonMap("foo", "bar")));
//
//            OpensearchException ex = expectThrows(
//                    OpensearchException.class,
//                    () -> highLevelClient().delete(d -> d.id(docId).index(index).ifSeqNo(2L).ifPrimaryTerm(2L))
//            );
//            assertNotNull(ex);
//
//
////            DeleteRequest deleteRequest = new DeleteRequest("index", docId).setIfSeqNo(2).setIfPrimaryTerm(2);
////            OpenSearchException exception = expectThrows(
////                    OpenSearchException.class,
////                    () -> execute(deleteRequest, highLevelClient()::delete, highLevelClient()::deleteAsync)
////            );
////            assertEquals(RestStatus.CONFLICT, exception.status());
////            assertEquals(
////                    "OpenSearch exception [type=version_conflict_engine_exception, reason=["
////                            + docId
////                            + "]: "
////                            + "version conflict,
////                            required seqNo [2], primary term [2].
////                            current document has seqNo [3] and primary term [1]]",
////                    exception.getMessage()
////            );
////            assertEquals("index", exception.getMetadata("opensearch.index").get(0));
//        }
////        {
////            // Testing version type
////            String docId = "version_type";
////            highLevelClient().index(
////                    new IndexRequest("index").id(docId)
////                            .source(Collections.singletonMap("foo", "bar"))
////                            .versionType(VersionType.EXTERNAL)
////                            .version(12),
////                    RequestOptions.DEFAULT
////            );
////            DeleteRequest deleteRequest = new DeleteRequest("index", docId).versionType(VersionType.EXTERNAL).version(13);
////            DeleteResponse deleteResponse = execute(deleteRequest, highLevelClient()::delete, highLevelClient()::deleteAsync);
////            assertEquals("index", deleteResponse.getIndex());
////            assertEquals("_doc", deleteResponse.getType());
////            assertEquals(docId, deleteResponse.getId());
////            assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
////        }
////        {
////            // Testing version type with a wrong version
////            String docId = "wrong_version";
////            highLevelClient().index(
////                    new IndexRequest("index").id(docId)
////                            .source(Collections.singletonMap("foo", "bar"))
////                            .versionType(VersionType.EXTERNAL)
////                            .version(12),
////                    RequestOptions.DEFAULT
////            );
////            OpenSearchStatusException exception = expectThrows(OpenSearchStatusException.class, () -> {
////                DeleteRequest deleteRequest = new DeleteRequest("index", docId).versionType(VersionType.EXTERNAL).version(10);
////                execute(deleteRequest, highLevelClient()::delete, highLevelClient()::deleteAsync);
////            });
////            assertEquals(RestStatus.CONFLICT, exception.status());
////            assertEquals(
////                    "OpenSearch exception [type=version_conflict_engine_exception, reason=["
////                            + docId
////                            + "]: version conflict, current version [12] is higher or equal to the one provided [10]]",
////                    exception.getMessage()
////            );
////            assertEquals("index", exception.getMetadata("opensearch.index").get(0));
////        }
////        {
////            // Testing routing
////            String docId = "routing";
////            highLevelClient().index(
////                    new IndexRequest("index").id(docId).source(Collections.singletonMap("foo", "bar")).routing("foo"),
////                    RequestOptions.DEFAULT
////            );
////            DeleteRequest deleteRequest = new DeleteRequest("index", docId).routing("foo");
////            DeleteResponse deleteResponse = execute(deleteRequest, highLevelClient()::delete, highLevelClient()::deleteAsync);
////            assertEquals("index", deleteResponse.getIndex());
////            assertEquals("_doc", deleteResponse.getType());
////            assertEquals(docId, deleteResponse.getId());
////            assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
////        }
//    }

    //
//    public void testDeleteWithTypes() throws IOException {
//        String docId = "id";
//        IndexRequest indexRequest = new IndexRequest("index", "type", docId);
//        indexRequest.source(Collections.singletonMap("foo", "bar"));
//        execute(
//                indexRequest,
//                highLevelClient()::index,
//                highLevelClient()::indexAsync,
//                expectWarnings(RestIndexAction.TYPES_DEPRECATION_MESSAGE)
//        );
//
//        DeleteRequest deleteRequest = new DeleteRequest("index", "type", docId);
//        DeleteResponse deleteResponse = execute(
//                deleteRequest,
//                highLevelClient()::delete,
//                highLevelClient()::deleteAsync,
//                expectWarnings(RestDeleteAction.TYPES_DEPRECATION_MESSAGE)
//        );
//
//        assertEquals("index", deleteResponse.getIndex());
//        assertEquals("type", deleteResponse.getType());
//        assertEquals(docId, deleteResponse.getId());
//        assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
//    }
//
    public void testExists() throws IOException {
        assertFalse(highLevelClient().indices().exists(b -> b.index("index")).value());
        String index = "ingest-test";
        // Create an index
        CreateIndexResponse createIndexResponse = highLevelClient().indices().create(b -> b
                .index(index)
        );
        assertEquals(index, createIndexResponse.index());

        // Check that it actually exists. Example of a boolean response
        assertTrue(highLevelClient().indices().exists(b -> b.index(index)).value());

        highLevelClient().index(b -> b
                .index(index)
                .id("id")
                .document(Collections.singletonMap("foo", "bar"))
                .refresh(JsonValue.TRUE));

        assertTrue(highLevelClient().exists(b -> b.index(index).id("id")).value());
        assertFalse(highLevelClient().exists(b -> b.index(index).id("random_id")).value());
        assertFalse(highLevelClient().exists(b -> b.index(index).id("random_id").version(1L)).value());
    }

    //
//    // used deprecated API existsSource(GetRequest, RequestOptions)
//    // see test `testSourceExists` with new API tests
//    public void testDeprecatedSourceExists() throws IOException {
//        {
//            GetRequest getRequest = new GetRequest("index", "id");
//            assertFalse(execute(getRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));
//        }
//        IndexRequest index = new IndexRequest("index").id("id");
//        index.source("{\"field1\":\"value1\",\"field2\":\"value2\"}", XContentType.JSON);
//        index.setRefreshPolicy(RefreshPolicy.IMMEDIATE);
//        highLevelClient().index(index, RequestOptions.DEFAULT);
//        {
//            GetRequest getRequest = new GetRequest("index", "id");
//            assertTrue(execute(getRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));
//        }
//        {
//            GetRequest getRequest = new GetRequest("index", "does_not_exist");
//            assertFalse(execute(getRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));
//        }
//        {
//            GetRequest getRequest = new GetRequest("index", "does_not_exist").version(1);
//            assertFalse(execute(getRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));
//        }
//    }
//
//    public void testSourceExists() throws IOException {
//        {
//            GetSourceRequest getRequest = new GetSourceRequest("index", "id");
//            assertFalse(execute(getRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));
//        }
//        IndexRequest index = new IndexRequest("index").id("id");
//        index.source("{\"field1\":\"value1\",\"field2\":\"value2\"}", XContentType.JSON);
//        index.setRefreshPolicy(RefreshPolicy.IMMEDIATE);
//        highLevelClient().index(index, RequestOptions.DEFAULT);
//        {
//            GetSourceRequest getRequest = new GetSourceRequest("index", "id");
//            assertTrue(execute(getRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));
//        }
//        {
//            GetSourceRequest getRequest = new GetSourceRequest("index", "does_not_exist");
//            assertFalse(execute(getRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));
//        }
//    }
//
//    public void testSourceDoesNotExist() throws IOException {
//        final String noSourceIndex = "no_source";
//        {
//            // Prepare
//            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
//            String mapping = "\"_source\": {\"enabled\": false}";
//            createIndex(noSourceIndex, settings, mapping);
//            assertEquals(
//                    RestStatus.OK,
//                    highLevelClient().bulk(
//                            new BulkRequest().add(
//                                    new IndexRequest(noSourceIndex).id("1").source(Collections.singletonMap("foo", 1), XContentType.JSON)
//                            )
//                                    .add(new IndexRequest(noSourceIndex).id("2")
//                                    .source(Collections.singletonMap("foo", 2), XContentType.JSON))
//                                    .setRefreshPolicy(RefreshPolicy.IMMEDIATE),
//                            RequestOptions.DEFAULT
//                    ).status()
//            );
//        }
//        {
//            GetRequest getRequest = new GetRequest(noSourceIndex, "1");
//            assertTrue(execute(getRequest, highLevelClient()::exists, highLevelClient()::existsAsync));
//            // used deprecated API existsSource(GetRequest, RequestOptions)
//            assertFalse(execute(getRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));
//            // used new API existsSource(GetSourceRequest, RequestOptions)
//            GetSourceRequest getSourceRequest = new GetSourceRequest(noSourceIndex, "1");
//            assertFalse(execute(getSourceRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));
//        }
//    }
//
//    public void testGet() throws IOException {
//
//        {
//            OpensearchException exception = expectThrows(
//                    OpensearchException.class,
//                    () -> highLevelClient().get(new GetRequest.Builder().index("index").id("id").build(), String.class)
//            );
//            assertEquals(404, exception.status());
//            assertEquals("[index_not_found_exception] no such index [index]", exception.getMessage());
//            assertEquals(Json.createValue("index"), exception.error().metadata().get("index").toJson());
//        }
//
////        String document = "{\"field1\":\"value1\",\"field2\":\"value2\"}";
//        AppData appData = new AppData();
//        appData.setIntValue(1337);
//        appData.setMsg("foo");
//
//        highLevelClient().index(b -> b.index("index").id("id").document(appData).refresh(JsonValue.TRUE));
////        IndexRequest index = new IndexRequest("index").id("id");
////        String document = "{\"field1\":\"value1\",\"field2\":\"value2\"}";
////        index.source(document, XContentType.JSON);
////        index.setRefreshPolicy(RefreshPolicy.IMMEDIATE);
////        highLevelClient().index(index, RequestOptions.DEFAULT);
//        {
//            OpensearchException exception = expectThrows(
//                    OpensearchException.class,
//                    () -> highLevelClient().get(b -> b.index("index").id("id").version(2L), String.class)
//            );
//            assertEquals(409, exception.status());
//            assertEquals(
//                    "OpenSearch exception [type=version_conflict_engine_exception, "
//                            + "reason=[id]: "
//                            + "version conflict, current version [1] is different than the one provided [2]]",
//                    exception.getMessage()
//            );
//            assertEquals(Json.createValue("index"), exception.error().metadata().get("index").toJson());
//        }
//        {
//            GetRequest getRequest = new GetRequest("index", "id");
//            if (randomBoolean()) {
//                getRequest.version(1L);
//            }
//            GetResponse getResponse = execute(getRequest, highLevelClient()::get, highLevelClient()::getAsync);
//            assertEquals("index", getResponse.getIndex());
//            assertEquals("_doc", getResponse.getType());
//            assertEquals("id", getResponse.getId());
//            assertTrue(getResponse.isExists());
//            assertFalse(getResponse.isSourceEmpty());
//            assertEquals(1L, getResponse.getVersion());
//            assertEquals(document, getResponse.getSourceAsString());
//        }
//        {
//            GetRequest getRequest = new GetRequest("index", "does_not_exist");
//            GetResponse getResponse = execute(getRequest, highLevelClient()::get, highLevelClient()::getAsync);
//            assertEquals("index", getResponse.getIndex());
//            assertEquals("_doc", getResponse.getType());
//            assertEquals("does_not_exist", getResponse.getId());
//            assertFalse(getResponse.isExists());
//            assertEquals(-1, getResponse.getVersion());
//            assertTrue(getResponse.isSourceEmpty());
//            assertNull(getResponse.getSourceAsString());
//        }
//        {
//            GetRequest getRequest = new GetRequest("index", "id");
//            getRequest.fetchSourceContext(new FetchSourceContext(false, Strings.EMPTY_ARRAY, Strings.EMPTY_ARRAY));
//            GetResponse getResponse = execute(getRequest, highLevelClient()::get, highLevelClient()::getAsync);
//            assertEquals("index", getResponse.getIndex());
//            assertEquals("_doc", getResponse.getType());
//            assertEquals("id", getResponse.getId());
//            assertTrue(getResponse.isExists());
//            assertTrue(getResponse.isSourceEmpty());
//            assertEquals(1L, getResponse.getVersion());
//            assertNull(getResponse.getSourceAsString());
//        }
//        {
//            GetRequest getRequest = new GetRequest("index", "id");
//            if (randomBoolean()) {
//                getRequest.fetchSourceContext(new FetchSourceContext(true, new String[]{"field1"}, Strings.EMPTY_ARRAY));
//            } else {
//                getRequest.fetchSourceContext(new FetchSourceContext(true, Strings.EMPTY_ARRAY, new String[]{"field2"}));
//            }
//            GetResponse getResponse = execute(getRequest, highLevelClient()::get, highLevelClient()::getAsync);
//            assertEquals("index", getResponse.getIndex());
//            assertEquals("_doc", getResponse.getType());
//            assertEquals("id", getResponse.getId());
//            assertTrue(getResponse.isExists());
//            assertFalse(getResponse.isSourceEmpty());
//            assertEquals(1L, getResponse.getVersion());
//            Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
//            assertEquals(1, sourceAsMap.size());
//            assertEquals("value1", sourceAsMap.get("field1"));
//        }
//    }
//
//    public void testGetWithTypes() throws IOException {
//        String document = "{\"field\":\"value\"}";
//        IndexRequest indexRequest = new IndexRequest("index", "type", "id");
//        indexRequest.source(document, XContentType.JSON);
//        indexRequest.setRefreshPolicy(RefreshPolicy.IMMEDIATE);
//        execute(
//                indexRequest,
//                highLevelClient()::index,
//                highLevelClient()::indexAsync,
//                expectWarnings(RestIndexAction.TYPES_DEPRECATION_MESSAGE)
//        );
//
//        GetRequest getRequest = new GetRequest("index", "type", "id");
//        GetResponse getResponse = execute(
//                getRequest,
//                highLevelClient()::get,
//                highLevelClient()::getAsync,
//                expectWarnings(RestGetAction.TYPES_DEPRECATION_MESSAGE)
//        );
//
//        assertEquals("index", getResponse.getIndex());
//        assertEquals("type", getResponse.getType());
//        assertEquals("id", getResponse.getId());
//
//        assertTrue(getResponse.isExists());
//        assertFalse(getResponse.isSourceEmpty());
//        assertEquals(1L, getResponse.getVersion());
//        assertEquals(document, getResponse.getSourceAsString());
//    }
//
//    public void testMultiGet() throws IOException {
//        {
//            MultiGetRequest multiGetRequest = new MultiGetRequest();
//            multiGetRequest.add("index", "id1");
//            multiGetRequest.add("index", "id2");
//            MultiGetResponse response = execute(multiGetRequest, highLevelClient()::mget, highLevelClient()::mgetAsync);
//            assertEquals(2, response.getResponses().length);
//
//            assertTrue(response.getResponses()[0].isFailed());
//            assertNull(response.getResponses()[0].getResponse());
//            assertEquals("id1", response.getResponses()[0].getFailure().getId());
//            assertNull(response.getResponses()[0].getFailure().getType());
//            assertEquals("index", response.getResponses()[0].getFailure().getIndex());
//            assertEquals(
//                    "OpenSearch exception [type=index_not_found_exception, reason=no such index [index]]",
//                    response.getResponses()[0].getFailure().getFailure().getMessage()
//            );
//
//            assertTrue(response.getResponses()[1].isFailed());
//            assertNull(response.getResponses()[1].getResponse());
//            assertEquals("id2", response.getResponses()[1].getId());
//            assertNull(response.getResponses()[1].getType());
//            assertEquals("index", response.getResponses()[1].getIndex());
//            assertEquals(
//                    "OpenSearch exception [type=index_not_found_exception, reason=no such index [index]]",
//                    response.getResponses()[1].getFailure().getFailure().getMessage()
//            );
//        }
//        BulkRequest bulk = new BulkRequest();
//        bulk.setRefreshPolicy(RefreshPolicy.IMMEDIATE);
//        IndexRequest index = new IndexRequest("index").id("id1");
//        index.source("{\"field\":\"value1\"}", XContentType.JSON);
//        bulk.add(index);
//        index = new IndexRequest("index").id("id2");
//        index.source("{\"field\":\"value2\"}", XContentType.JSON);
//        bulk.add(index);
//        highLevelClient().bulk(bulk, RequestOptions.DEFAULT);
//        {
//            MultiGetRequest multiGetRequest = new MultiGetRequest();
//            multiGetRequest.add("index", "id1");
//            multiGetRequest.add("index", "id2");
//            MultiGetResponse response = execute(multiGetRequest, highLevelClient()::mget, highLevelClient()::mgetAsync);
//            assertEquals(2, response.getResponses().length);
//
//            assertFalse(response.getResponses()[0].isFailed());
//            assertNull(response.getResponses()[0].getFailure());
//            assertEquals("id1", response.getResponses()[0].getId());
//            assertEquals("_doc", response.getResponses()[0].getType());
//            assertEquals("index", response.getResponses()[0].getIndex());
//            assertEquals(Collections.singletonMap("field", "value1"), response.getResponses()[0].getResponse().getSource());
//
//            assertFalse(response.getResponses()[1].isFailed());
//            assertNull(response.getResponses()[1].getFailure());
//            assertEquals("id2", response.getResponses()[1].getId());
//            assertEquals("_doc", response.getResponses()[1].getType());
//            assertEquals("index", response.getResponses()[1].getIndex());
//            assertEquals(Collections.singletonMap("field", "value2"), response.getResponses()[1].getResponse().getSource());
//        }
//    }
//
//    public void testMultiGetWithTypes() throws IOException {
//        BulkRequest bulk = new BulkRequest();
//        bulk.setRefreshPolicy(RefreshPolicy.IMMEDIATE);
//        bulk.add(new IndexRequest("index", "type", "id1").source("{\"field\":\"value1\"}", XContentType.JSON));
//        bulk.add(new IndexRequest("index", "type", "id2").source("{\"field\":\"value2\"}", XContentType.JSON));
//
//        highLevelClient().bulk(bulk, expectWarnings(RestBulkAction.TYPES_DEPRECATION_MESSAGE));
//        MultiGetRequest multiGetRequest = new MultiGetRequest();
//        multiGetRequest.add("index", "id1");
//        multiGetRequest.add("index", "type", "id2");
//
//        MultiGetResponse response = execute(
//                multiGetRequest,
//                highLevelClient()::mget,
//                highLevelClient()::mgetAsync,
//                expectWarnings(RestMultiGetAction.TYPES_DEPRECATION_MESSAGE)
//        );
//        assertEquals(2, response.getResponses().length);
//
//        GetResponse firstResponse = response.getResponses()[0].getResponse();
//        assertEquals("index", firstResponse.getIndex());
//        assertEquals("type", firstResponse.getType());
//        assertEquals("id1", firstResponse.getId());
//
//        GetResponse secondResponse = response.getResponses()[1].getResponse();
//        assertEquals("index", secondResponse.getIndex());
//        assertEquals("type", secondResponse.getType());
//        assertEquals("id2", secondResponse.getId());
//    }
//
//    public void testGetSource() throws IOException {
//        {
//            GetSourceRequest getRequest = new GetSourceRequest("index", "id");
//            OpenSearchException exception = expectThrows(
//                    OpenSearchException.class,
//                    () -> execute(getRequest, highLevelClient()::getSource, highLevelClient()::getSourceAsync)
//            );
//            assertEquals(RestStatus.NOT_FOUND, exception.status());
//            assertEquals("OpenSearch exception [type=index_not_found_exception, reason=no such index [index]]", exception.getMessage());
//            assertEquals("index", exception.getMetadata("opensearch.index").get(0));
//        }
//        IndexRequest index = new IndexRequest("index").id("id");
//        String document = "{\"field1\":\"value1\",\"field2\":\"value2\"}";
//        index.source(document, XContentType.JSON);
//        index.setRefreshPolicy(RefreshPolicy.IMMEDIATE);
//        highLevelClient().index(index, RequestOptions.DEFAULT);
//        {
//            GetSourceRequest getRequest = new GetSourceRequest("index", "id");
//            GetSourceResponse response = execute(getRequest, highLevelClient()::getSource, highLevelClient()::getSourceAsync);
//            Map<String, Object> expectedResponse = new HashMap<>();
//            expectedResponse.put("field1", "value1");
//            expectedResponse.put("field2", "value2");
//            assertEquals(expectedResponse, response.getSource());
//        }
//        {
//            GetSourceRequest getRequest = new GetSourceRequest("index", "does_not_exist");
//            OpenSearchException exception = expectThrows(
//                    OpenSearchException.class,
//                    () -> execute(getRequest, highLevelClient()::getSource, highLevelClient()::getSourceAsync)
//            );
//            assertEquals(RestStatus.NOT_FOUND, exception.status());
//            assertEquals(
//                    "OpenSearch exception [type=resource_not_found_exception,
//                    " + "reason=Document not found [index]/[_doc]/[does_not_exist]]",
//                    exception.getMessage()
//            );
//        }
//        {
//            GetSourceRequest getRequest = new GetSourceRequest("index", "id");
//            getRequest.fetchSourceContext(new FetchSourceContext(true, Strings.EMPTY_ARRAY, Strings.EMPTY_ARRAY));
//            GetSourceResponse response = execute(getRequest, highLevelClient()::getSource, highLevelClient()::getSourceAsync);
//            Map<String, Object> expectedResponse = new HashMap<>();
//            expectedResponse.put("field1", "value1");
//            expectedResponse.put("field2", "value2");
//            assertEquals(expectedResponse, response.getSource());
//        }
//        {
//            GetSourceRequest getRequest = new GetSourceRequest("index", "id");
//            getRequest.fetchSourceContext(new FetchSourceContext(true, new String[]{"field1"}, Strings.EMPTY_ARRAY));
//            GetSourceResponse response = execute(getRequest, highLevelClient()::getSource, highLevelClient()::getSourceAsync);
//            Map<String, Object> expectedResponse = new HashMap<>();
//            expectedResponse.put("field1", "value1");
//            assertEquals(expectedResponse, response.getSource());
//        }
//        {
//            GetSourceRequest getRequest = new GetSourceRequest("index", "id");
//            getRequest.fetchSourceContext(new FetchSourceContext(true, Strings.EMPTY_ARRAY, new String[]{"field1"}));
//            GetSourceResponse response = execute(getRequest, highLevelClient()::getSource, highLevelClient()::getSourceAsync);
//            Map<String, Object> expectedResponse = new HashMap<>();
//            expectedResponse.put("field2", "value2");
//            assertEquals(expectedResponse, response.getSource());
//        }
//        {
//            GetSourceRequest getRequest = new GetSourceRequest("index", "id");
//            getRequest.fetchSourceContext(new FetchSourceContext(false));
//            OpenSearchException exception = expectThrows(
//                    OpenSearchException.class,
//                    () -> execute(getRequest, highLevelClient()::getSource, highLevelClient()::getSourceAsync)
//            );
//            assertEquals(
//                    "OpenSearch exception [type=action_request_validation_exception, "
//                            + "reason=Validation Failed: 1: fetching source can not be disabled;]",
//                    exception.getMessage()
//            );
//        }
//    }
//
//    public void testIndex() throws IOException {
//        final XContentType xContentType = randomFrom(XContentType.values());
//        {
//            IndexRequest indexRequest = new IndexRequest("index");
//            indexRequest.source(XContentBuilder.builder(xContentType.xContent()).startObject().field("test", "test").endObject());
//
//            IndexResponse indexResponse = execute(indexRequest, highLevelClient()::index, highLevelClient()::indexAsync);
//            assertEquals(RestStatus.CREATED, indexResponse.status());
//            assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());
//            assertEquals("index", indexResponse.getIndex());
//            assertEquals("_doc", indexResponse.getType());
//            assertTrue(Strings.hasLength(indexResponse.getId()));
//            assertEquals(1L, indexResponse.getVersion());
//            assertNotNull(indexResponse.getShardId());
//            assertEquals(-1, indexResponse.getShardId().getId());
//            assertEquals("index", indexResponse.getShardId().getIndexName());
//            assertEquals("index", indexResponse.getShardId().getIndex().getName());
//            assertEquals("_na_", indexResponse.getShardId().getIndex().getUUID());
//            assertNotNull(indexResponse.getShardInfo());
//            assertEquals(0, indexResponse.getShardInfo().getFailed());
//            assertTrue(indexResponse.getShardInfo().getSuccessful() > 0);
//            assertTrue(indexResponse.getShardInfo().getTotal() > 0);
//        }
//        {
//            IndexRequest indexRequest = new IndexRequest("index").id("id");
//            indexRequest.source(XContentBuilder.builder(xContentType.xContent()).startObject().field("version", 1).endObject());
//
//            IndexResponse indexResponse = execute(indexRequest, highLevelClient()::index, highLevelClient()::indexAsync);
//            assertEquals(RestStatus.CREATED, indexResponse.status());
//            assertEquals("index", indexResponse.getIndex());
//            assertEquals("_doc", indexResponse.getType());
//            assertEquals("id", indexResponse.getId());
//            assertEquals(1L, indexResponse.getVersion());
//
//            indexRequest = new IndexRequest("index").id("id");
//            indexRequest.source(XContentBuilder.builder(xContentType.xContent()).startObject().field("version", 2).endObject());
//
//            indexResponse = execute(indexRequest, highLevelClient()::index, highLevelClient()::indexAsync);
//            assertEquals(RestStatus.OK, indexResponse.status());
//            assertEquals("index", indexResponse.getIndex());
//            assertEquals("_doc", indexResponse.getType());
//            assertEquals("id", indexResponse.getId());
//            assertEquals(2L, indexResponse.getVersion());
//
//            OpenSearchStatusException exception = expectThrows(OpenSearchStatusException.class, () -> {
//                IndexRequest wrongRequest = new IndexRequest("index").id("id");
//                wrongRequest.source(XContentBuilder.builder(xContentType.xContent()).startObject().field("field", "test").endObject());
//                wrongRequest.setIfSeqNo(1L).setIfPrimaryTerm(5L);
//
//                execute(wrongRequest, highLevelClient()::index, highLevelClient()::indexAsync);
//            });
//            assertEquals(RestStatus.CONFLICT, exception.status());
//            assertEquals(
//                    "OpenSearch exception [type=version_conflict_engine_exception, reason=[id]: "
//                            + "version conflict, required seqNo [1], primary term [5].
//                            current document has seqNo [2] and primary term [1]]",
//                    exception.getMessage()
//            );
//            assertEquals("index", exception.getMetadata("opensearch.index").get(0));
//        }
//        {
//            OpenSearchStatusException exception = expectThrows(OpenSearchStatusException.class, () -> {
//                IndexRequest indexRequest = new IndexRequest("index").id("missing_pipeline");
//                indexRequest.source(XContentBuilder.builder(xContentType.xContent()).startObject().field("field", "test").endObject());
//                indexRequest.setPipeline("missing");
//
//                execute(indexRequest, highLevelClient()::index, highLevelClient()::indexAsync);
//            });
//
//            assertEquals(RestStatus.BAD_REQUEST, exception.status());
//            assertEquals(
//                    "OpenSearch exception [type=illegal_argument_exception, " + "reason=pipeline with id [missing] does not exist]",
//                    exception.getMessage()
//            );
//        }
//        {
//            OpenSearchStatusException exception = expectThrows(OpenSearchStatusException.class, () -> {
//                IndexRequest indexRequest = new IndexRequest("index").id("missing_alias").setRequireAlias(true);
//                indexRequest.source(XContentBuilder.builder(xContentType.xContent()).startObject().field("field", "test").endObject());
//
//                execute(indexRequest, highLevelClient()::index, highLevelClient()::indexAsync);
//            });
//
//            assertEquals(RestStatus.NOT_FOUND, exception.status());
//            assertEquals(
//                    "OpenSearch exception [type=index_not_found_exception, reason=no such index [index]"
//                            + " and [require_alias] request flag is [true] and [index] is not an alias]",
//                    exception.getMessage()
//            );
//        }
//        {
//            IndexRequest indexRequest = new IndexRequest("index").id("external_version_type");
//            indexRequest.source(XContentBuilder.builder(xContentType.xContent()).startObject().field("field", "test").endObject());
//            indexRequest.version(12L);
//            indexRequest.versionType(VersionType.EXTERNAL);
//
//            IndexResponse indexResponse = execute(indexRequest, highLevelClient()::index, highLevelClient()::indexAsync);
//            assertEquals(RestStatus.CREATED, indexResponse.status());
//            assertEquals("index", indexResponse.getIndex());
//            assertEquals("_doc", indexResponse.getType());
//            assertEquals("external_version_type", indexResponse.getId());
//            assertEquals(12L, indexResponse.getVersion());
//        }
//        {
//            final IndexRequest indexRequest = new IndexRequest("index").id("with_create_op_type");
//            indexRequest.source(XContentBuilder.builder(xContentType.xContent()).startObject().field("field", "test").endObject());
//            indexRequest.opType(DocWriteRequest.OpType.CREATE);
//
//            IndexResponse indexResponse = execute(indexRequest, highLevelClient()::index, highLevelClient()::indexAsync);
//            assertEquals(RestStatus.CREATED, indexResponse.status());
//            assertEquals("index", indexResponse.getIndex());
//            assertEquals("_doc", indexResponse.getType());
//            assertEquals("with_create_op_type", indexResponse.getId());
//
//            OpenSearchStatusException exception = expectThrows(
//                    OpenSearchStatusException.class,
//                    () -> {
//                        execute(indexRequest, highLevelClient()::index, highLevelClient()::indexAsync);
//                    }
//            );
//
//            assertEquals(RestStatus.CONFLICT, exception.status());
//            assertEquals(
//                    "OpenSearch exception [type=version_conflict_engine_exception, reason=[with_create_op_type]: "
//                            + "version conflict, document already exists (current version [1])]",
//                    exception.getMessage()
//            );
//        }
//    }
//
//    public void testIndexWithTypes() throws IOException {
//        final XContentType xContentType = randomFrom(XContentType.values());
//        IndexRequest indexRequest = new IndexRequest("index", "some_type", "some_id");
//        indexRequest.source(XContentBuilder.builder(xContentType.xContent()).startObject().field("test", "test").endObject());
//        IndexResponse indexResponse = execute(
//                indexRequest,
//                highLevelClient()::index,
//                highLevelClient()::indexAsync,
//                expectWarnings(RestIndexAction.TYPES_DEPRECATION_MESSAGE)
//        );
//        assertEquals(RestStatus.CREATED, indexResponse.status());
//        assertEquals("index", indexResponse.getIndex());
//        assertEquals("some_type", indexResponse.getType());
//        assertEquals("some_id", indexResponse.getId());
//    }
//
//    public void testUpdate() throws IOException {
//        {
//            UpdateRequest updateRequest = new UpdateRequest("index", "does_not_exist");
//            updateRequest.doc(singletonMap("field", "value"), randomFrom(XContentType.values()));
//
//            OpenSearchStatusException exception = expectThrows(
//                    OpenSearchStatusException.class,
//                    () -> execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync)
//            );
//            assertEquals(RestStatus.NOT_FOUND, exception.status());
//            assertEquals(
//                    "OpenSearch exception [type=document_missing_exception, reason=[_doc][does_not_exist]: document missing]",
//                    exception.getMessage()
//            );
//        }
//        {
//            IndexRequest indexRequest = new IndexRequest("index").id("id");
//            indexRequest.source(singletonMap("field", "value"));
//            IndexResponse indexResponse = highLevelClient().index(indexRequest, RequestOptions.DEFAULT);
//            assertEquals(RestStatus.CREATED, indexResponse.status());
//
//            long lastUpdateSeqNo;
//            long lastUpdatePrimaryTerm;
//            {
//                UpdateRequest updateRequest = new UpdateRequest("index", "id");
//                updateRequest.doc(singletonMap("field", "updated"), randomFrom(XContentType.values()));
//                final UpdateResponse updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
//                assertEquals(RestStatus.OK, updateResponse.status());
//                assertEquals(indexResponse.getVersion() + 1, updateResponse.getVersion());
//                lastUpdateSeqNo = updateResponse.getSeqNo();
//                lastUpdatePrimaryTerm = updateResponse.getPrimaryTerm();
//                assertThat(lastUpdateSeqNo, greaterThanOrEqualTo(0L));
//                assertThat(lastUpdatePrimaryTerm, greaterThanOrEqualTo(1L));
//            }
//
//            {
//                final UpdateRequest updateRequest = new UpdateRequest("index", "id");
//                updateRequest.doc(singletonMap("field", "with_seq_no_conflict"), randomFrom(XContentType.values()));
//                if (randomBoolean()) {
//                    updateRequest.setIfSeqNo(lastUpdateSeqNo + 1);
//                    updateRequest.setIfPrimaryTerm(lastUpdatePrimaryTerm);
//                } else {
//                    updateRequest.setIfSeqNo(lastUpdateSeqNo + (randomBoolean() ? 0 : 1));
//                    updateRequest.setIfPrimaryTerm(lastUpdatePrimaryTerm + 1);
//                }
//                OpenSearchStatusException exception = expectThrows(
//                        OpenSearchStatusException.class,
//                        () -> execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync)
//                );
//                assertEquals(exception.toString(), RestStatus.CONFLICT, exception.status());
//                assertThat(exception.getMessage(), containsString("OpenSearch exception [type=version_conflict_engine_exception"));
//            }
//            {
//                final UpdateRequest updateRequest = new UpdateRequest("index", "id");
//                updateRequest.doc(singletonMap("field", "with_seq_no"), randomFrom(XContentType.values()));
//                updateRequest.setIfSeqNo(lastUpdateSeqNo);
//                updateRequest.setIfPrimaryTerm(lastUpdatePrimaryTerm);
//                final UpdateResponse updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
//                assertEquals(RestStatus.OK, updateResponse.status());
//                assertEquals(lastUpdateSeqNo + 1, updateResponse.getSeqNo());
//                assertEquals(lastUpdatePrimaryTerm, updateResponse.getPrimaryTerm());
//            }
//        }
//        {
//            IndexRequest indexRequest = new IndexRequest("index").id("with_script");
//            indexRequest.source(singletonMap("counter", 12));
//            IndexResponse indexResponse = highLevelClient().index(indexRequest, RequestOptions.DEFAULT);
//            assertEquals(RestStatus.CREATED, indexResponse.status());
//
//            UpdateRequest updateRequest = new UpdateRequest("index", "with_script");
//            Script script = new Script(ScriptType.INLINE, "painless", "ctx._source.counter += params.count", singletonMap("count", 8));
//            updateRequest.script(script);
//            updateRequest.fetchSource(true);
//
//            UpdateResponse updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
//            assertEquals(RestStatus.OK, updateResponse.status());
//            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
//            assertEquals(2L, updateResponse.getVersion());
//            assertEquals(20, updateResponse.getGetResult().sourceAsMap().get("counter"));
//
//        }
//        {
//            IndexRequest indexRequest = new IndexRequest("index").id("with_doc");
//            indexRequest.source("field_1", "one", "field_3", "three");
//            indexRequest.version(12L);
//            indexRequest.versionType(VersionType.EXTERNAL);
//            IndexResponse indexResponse = highLevelClient().index(indexRequest, RequestOptions.DEFAULT);
//            assertEquals(RestStatus.CREATED, indexResponse.status());
//            assertEquals(12L, indexResponse.getVersion());
//
//            UpdateRequest updateRequest = new UpdateRequest("index", "with_doc");
//            updateRequest.doc(singletonMap("field_2", "two"), randomFrom(XContentType.values()));
//            updateRequest.fetchSource("field_*", "field_3");
//
//            UpdateResponse updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
//            assertEquals(RestStatus.OK, updateResponse.status());
//            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
//            assertEquals(13L, updateResponse.getVersion());
//            GetResult getResult = updateResponse.getGetResult();
//            assertEquals(13L, updateResponse.getVersion());
//            Map<String, Object> sourceAsMap = getResult.sourceAsMap();
//            assertEquals("one", sourceAsMap.get("field_1"));
//            assertEquals("two", sourceAsMap.get("field_2"));
//            assertFalse(sourceAsMap.containsKey("field_3"));
//        }
//        {
//            IndexRequest indexRequest = new IndexRequest("index").id("noop");
//            indexRequest.source("field", "value");
//            IndexResponse indexResponse = highLevelClient().index(indexRequest, RequestOptions.DEFAULT);
//            assertEquals(RestStatus.CREATED, indexResponse.status());
//            assertEquals(1L, indexResponse.getVersion());
//
//            UpdateRequest updateRequest = new UpdateRequest("index", "noop");
//            updateRequest.doc(singletonMap("field", "value"), randomFrom(XContentType.values()));
//
//            UpdateResponse updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
//            assertEquals(RestStatus.OK, updateResponse.status());
//            assertEquals(DocWriteResponse.Result.NOOP, updateResponse.getResult());
//            assertEquals(1L, updateResponse.getVersion());
//
//            updateRequest.detectNoop(false);
//
//            updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
//            assertEquals(RestStatus.OK, updateResponse.status());
//            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
//            assertEquals(2L, updateResponse.getVersion());
//        }
//        {
//            UpdateRequest updateRequest = new UpdateRequest("index", "with_upsert");
//            updateRequest.upsert(singletonMap("doc_status", "created"));
//            updateRequest.doc(singletonMap("doc_status", "updated"));
//            updateRequest.fetchSource(true);
//
//            UpdateResponse updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
//            assertEquals(RestStatus.CREATED, updateResponse.status());
//            assertEquals("index", updateResponse.getIndex());
//            assertEquals("_doc", updateResponse.getType());
//            assertEquals("with_upsert", updateResponse.getId());
//            GetResult getResult = updateResponse.getGetResult();
//            assertEquals(1L, updateResponse.getVersion());
//            assertEquals("created", getResult.sourceAsMap().get("doc_status"));
//        }
//        {
//            UpdateRequest updateRequest = new UpdateRequest("index", "with_doc_as_upsert");
//            updateRequest.doc(singletonMap("field", "initialized"));
//            updateRequest.fetchSource(true);
//            updateRequest.docAsUpsert(true);
//
//            UpdateResponse updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
//            assertEquals(RestStatus.CREATED, updateResponse.status());
//            assertEquals("index", updateResponse.getIndex());
//            assertEquals("_doc", updateResponse.getType());
//            assertEquals("with_doc_as_upsert", updateResponse.getId());
//            GetResult getResult = updateResponse.getGetResult();
//            assertEquals(1L, updateResponse.getVersion());
//            assertEquals("initialized", getResult.sourceAsMap().get("field"));
//        }
//        {
//            UpdateRequest updateRequest = new UpdateRequest("index", "with_scripted_upsert");
//            updateRequest.fetchSource(true);
//            updateRequest.script(new Script(ScriptType.INLINE, "painless", "ctx._source.level = params.test", singletonMap("test", "C")));
//            updateRequest.scriptedUpsert(true);
//            updateRequest.upsert(singletonMap("level", "A"));
//
//            UpdateResponse updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
//            assertEquals(RestStatus.CREATED, updateResponse.status());
//            assertEquals("index", updateResponse.getIndex());
//            assertEquals("_doc", updateResponse.getType());
//            assertEquals("with_scripted_upsert", updateResponse.getId());
//
//            GetResult getResult = updateResponse.getGetResult();
//            assertEquals(1L, updateResponse.getVersion());
//            assertEquals("C", getResult.sourceAsMap().get("level"));
//        }
//        {
//            IllegalStateException exception = expectThrows(IllegalStateException.class, () -> {
//                UpdateRequest updateRequest = new UpdateRequest("index", "id");
//                updateRequest.doc(new IndexRequest().source(Collections.singletonMap("field", "doc"), XContentType.JSON));
//                updateRequest.upsert(new IndexRequest().source(Collections.singletonMap("field", "upsert"), XContentType.YAML));
//                execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
//            });
//            assertEquals(
//                    "Update request cannot have different content types for doc [JSON] and upsert [YAML] documents",
//                    exception.getMessage()
//            );
//        }
//        {
//            OpenSearchException exception = expectThrows(OpenSearchException.class, () -> {
//                UpdateRequest updateRequest = new UpdateRequest("index", "require_alias").setRequireAlias(true);
//                updateRequest.doc(new IndexRequest().source(Collections.singletonMap("field", "doc"), XContentType.JSON));
//                execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
//            });
//            assertEquals(RestStatus.NOT_FOUND, exception.status());
//            assertEquals(
//                    "OpenSearch exception [type=index_not_found_exception,
//                    reason=no such index [index] and [require_alias] request flag is [true] and [index] is not an alias]",
//                    exception.getMessage()
//            );
//        }
//    }
//
//    public void testUpdateWithTypes() throws IOException {
//        IndexRequest indexRequest = new IndexRequest("index", "type", "id");
//        indexRequest.source(singletonMap("field", "value"));
//        IndexResponse indexResponse = execute(
//                indexRequest,
//                highLevelClient()::index,
//                highLevelClient()::indexAsync,
//                expectWarnings(RestIndexAction.TYPES_DEPRECATION_MESSAGE)
//        );
//
//        UpdateRequest updateRequest = new UpdateRequest("index", "type", "id");
//        updateRequest.doc(singletonMap("field", "updated"), randomFrom(XContentType.values()));
//        UpdateResponse updateResponse = execute(
//                updateRequest,
//                highLevelClient()::update,
//                highLevelClient()::updateAsync,
//                expectWarnings(RestUpdateAction.TYPES_DEPRECATION_MESSAGE)
//        );
//
//        assertEquals(RestStatus.OK, updateResponse.status());
//        assertEquals(indexResponse.getVersion() + 1, updateResponse.getVersion());
//    }
//
    public void testBulk() throws IOException {
        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");
        int nbItems = randomIntBetween(10, 100);
        boolean[] errors = new boolean[nbItems];

        BulkRequest.Builder bulkRequestBuilder = new BulkRequest.Builder();
        List<Operation> opsList = new ArrayList<>();

        for (int i = 0; i < nbItems; i++) {
            String id = String.valueOf(i);
            boolean erroneous = randomBoolean();
            errors[i] = erroneous;
            //TODO - Serialization issue with update operation
            String opType = randomFrom(Operation.DELETE, Operation.INDEX,Operation.CREATE/*, Operation.UPDATE*/);
            if (opType.equals(Operation.DELETE)) {
                if (!erroneous) {
                    assertEquals(
                            Result.Created,
                            highLevelClient().index(b -> b.index("index").id(id).document(appData)).result()
                    );
                }
                Operation op = new Operation.Builder().delete(o -> o
                        .index("index")
                        .id(id)
                ).build();
                opsList.add(op);

            } else {
                appData.setIntValue(i);
                appData.setMsg("id");
                if (opType.equals(Operation.INDEX)) {
                    Operation op = new Operation.Builder().index(o -> o
                            .index("index")
                            .id(id)
                            .document(appData)
                            .ifSeqNo(erroneous ? 12L : null)
                            .ifPrimaryTerm(erroneous ? 12L : null)
                    ).build();
                    opsList.add(op);

                } else if (opType.equals(Operation.CREATE)) {
                    Operation op = new Operation.Builder().create(o -> o
                            .index("index")
                            .id(id)
                            .document(appData)

                    ).build();
                    opsList.add(op);

                    if (erroneous) {
                        assertEquals(Result.Created, highLevelClient().index(b -> b.index("index").id(id).document(appData)).result());
                    }

                } else if (opType.equals(Operation.UPDATE)) {
                    Operation op = new Operation.Builder().update(o -> o
                            .index("index")
                            .id(id)
                            .document(Collections.singletonMap("key", "value"))
                    ).build();
                    opsList.add(op);
                    if (!erroneous) {
                        assertEquals(
                                Result.Created,
                                highLevelClient().index(b -> b.index("index").id(id).document(appData)).result()
                        );
                    }
                }
            }
        }
        BulkRequest bulkRequest = bulkRequestBuilder.operations(opsList).build();

        BulkResponse bulkResponse = highLevelClient().bulk(bulkRequest);
        assertTrue(bulkResponse.took() > 0);
        assertEquals(nbItems, bulkResponse.items().size());

        validateBulkResponses(nbItems, errors, bulkResponse, bulkRequest);
    }

    private void validateBulkResponses(int nbItems, boolean[] errors, BulkResponse bulkResponse, BulkRequest bulkRequest) {
        for (int i = 0; i < nbItems; i++) {
            ResponseItem bulkItemResponse = bulkResponse.items().get(i);

            assertEquals("index", bulkItemResponse.index());
            assertEquals("_doc", bulkItemResponse.type());
            assertEquals(String.valueOf(i), bulkItemResponse.id());

            String requestOpType = bulkRequest.operations().get(i)._type();
            if (requestOpType.equals(Operation.INDEX) || requestOpType.equals(Operation.CREATE)) {
                assertEquals(errors[i] ? 409 : 201, bulkItemResponse.status());
            } else if (requestOpType.equals(Operation.UPDATE)) {
                assertEquals(errors[i]? Result.NotFound.jsonValue() : Result.Updated.jsonValue(), bulkItemResponse.result());
                assertEquals(errors[i] ? 404 : 200, bulkItemResponse.status());
            } else if (requestOpType.equals(Operation.DELETE)) {
                assertEquals(errors[i]? Result.NotFound.jsonValue() : Result.Deleted.jsonValue(), bulkItemResponse.result());
                assertEquals(errors[i] ? 404 : 200, bulkItemResponse.status());
            }
        }
    }

    public void testUrlEncode() throws IOException {
        String indexPattern = "<logstash-{now/M}>";
        String expectedIndex = "logstash-"
                + DateTimeFormat.forPattern("YYYY.MM.dd").print(new DateTime(DateTimeZone.UTC).monthOfYear().roundFloorCopy());
        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");
        {
            IndexResponse response = highLevelClient().index(b -> b.index(indexPattern).id("id#1").document(appData));
            assertEquals(expectedIndex, response.index());
            assertEquals("_doc", response.type());
            assertEquals("id#1", response.id());
        }
        {
            GetResponse<AppData> getResponse = highLevelClient().get(b -> b
                    .index(indexPattern).id("id#1"), AppData.class);
            assertTrue(getResponse.found());
            assertEquals(expectedIndex, getResponse.index());
            assertEquals("_doc", getResponse.type());
            assertEquals("id#1", getResponse.id());
        }

        String docId = "this/is/the/id";
        {
            IndexResponse indexResponse = highLevelClient().index(b -> b.index("index").id(docId).document(appData));
            assertEquals("index", indexResponse.index());
            assertEquals("_doc", indexResponse.type());
            assertEquals(docId, indexResponse.id());
        }
        {
            GetResponse<AppData> getResponse = highLevelClient().get(b -> b
                    .index("index").id(docId), AppData.class);
            assertTrue(getResponse.found());
            assertEquals("index", getResponse.index());
            assertEquals("_doc", getResponse.type());
            assertEquals(docId, getResponse.id());
        }

        assertTrue(highLevelClient().indices().exists(b -> b.index(indexPattern, "index")).value());
    }

    public void testParamsEncode() throws IOException {
        String routing = "test";
        {
            String id = "id";
            AppData appData = new AppData();
            appData.setIntValue(1337);
            appData.setMsg("foo");
            IndexResponse response = highLevelClient().index(b -> b.index("index").id(id).document(appData).routing(routing));
            assertEquals("index", response.index());
            assertEquals("_doc", response.type());
            assertEquals(id, response.id());
        }
        {
            GetResponse<AppData> getResponse = highLevelClient().get(b -> b
                    .index("index").id("id").routing(routing), AppData.class);
            assertTrue(getResponse.found());
            assertEquals("index", getResponse.index());
            assertEquals("_doc", getResponse.type());
            assertEquals("id", getResponse.id());
            assertEquals(routing, getResponse.routing());
        }
    }

    public void testGetIdWithPlusSign() throws Exception {
        String id = "id+id";
        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        {
            IndexResponse indexResponse = highLevelClient().index(b -> b
                    .index("index").id(id).document(appData));
            assertEquals("index", indexResponse.index());
            assertEquals(id, indexResponse.id());
        }
        {
            GetResponse<AppData> getResponse = highLevelClient().get(b -> b
                    .index("index").id(id), AppData.class);
            assertTrue(getResponse.found());
            assertEquals("index", getResponse.index());
            assertEquals(id, getResponse.id());
        }
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
}
