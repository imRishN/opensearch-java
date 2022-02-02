/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.opensearch.client.opensearch._types.OpensearchException;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch._types.Result;
import org.opensearch.client.opensearch.core.*;
import org.opensearch.client.opensearch.core.bulk.BulkOperation;
import org.opensearch.client.opensearch.core.bulk.BulkResponseItem;
import org.opensearch.client.opensearch.indices.CreateIndexResponse;
import org.opensearch.client.opensearch.indices.DeleteIndexResponse;
import org.opensearch.client.transport.endpoints.BooleanResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CrudIT extends OpenSearchRestHighLevelClientTestCase {

    public void testDelete() throws IOException {
        {
            // Testing index deletion
            String index1 = "my-index";
            CreateIndexResponse createIndexResponse = highLevelClient().indices().create(b -> b.index(index1));
            assertEquals(index1, createIndexResponse.index());
            assertTrue(createIndexResponse.acknowledged());
            assertTrue(createIndexResponse.shardsAcknowledged());
            DeleteIndexResponse deleteIndexResponse = highLevelClient().indices().delete(b -> b.index(index1));
            assertTrue(deleteIndexResponse.acknowledged());
        }

        {
            // Testing doc deletion after data ingestion
            String docId = "id";
            String index = "my-index1";
            highLevelClient().indices().create(b -> b.index(index));

            String id = highLevelClient().index(b -> b
                    .index(index)
                    .id(docId)
                    .document(Collections.singletonMap("foo", "bar")))
                    .id();
            assertEquals(id, docId);

            DeleteResponse deleteResponse = highLevelClient().delete(d -> d.id(docId).index(index));
            assertEquals(deleteResponse.index(), index);
            assertEquals(deleteResponse.id(), docId);
            assertEquals(deleteResponse.type(), "_doc");
            assertEquals(deleteResponse.result(), Result.Deleted);

            String docIdTemp = "does_not_exist";
            DeleteResponse deleteResponseDocNotExist = highLevelClient().delete(d -> d.id(docIdTemp).index(index));
            assertEquals(deleteResponseDocNotExist.index(), index);
            assertEquals(deleteResponseDocNotExist.id(), docIdTemp);
            assertEquals(deleteResponseDocNotExist.type(), "_doc");
            assertEquals(deleteResponseDocNotExist.result(), Result.NotFound);

        }
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
//            DeleteRequest deleteRequest = new DeleteRequest.Builder()
//                    .index("index")
//                    .id(docId)
//                    .ifSeqNo(2L)
//                    .ifPrimaryTerm(2L)
//                    .build();
//            OpensearchException exception = expectThrows(
//                    OpensearchException.class,
//                    () -> highLevelClient().delete(deleteRequest));
//
//            assertEquals(409, exception.status());
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
//        {
//            // Testing version type
//            String docId = "version_type";
//            highLevelClient().index(
//                    new IndexRequest("index").id(docId)
//                            .source(Collections.singletonMap("foo", "bar"))
//                            .versionType(VersionType.EXTERNAL)
//                            .version(12),
//                    RequestOptions.DEFAULT
//            );
//            DeleteRequest deleteRequest = new DeleteRequest("index", docId).versionType(VersionType.EXTERNAL).version(13);
//            DeleteResponse deleteResponse = execute(deleteRequest, highLevelClient()::delete, highLevelClient()::deleteAsync);
//            assertEquals("index", deleteResponse.getIndex());
//            assertEquals("_doc", deleteResponse.getType());
//            assertEquals(docId, deleteResponse.getId());
//            assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
//        }
//        {
//            // Testing version type with a wrong version
//            String docId = "wrong_version";
//            highLevelClient().index(
//                    new IndexRequest("index").id(docId)
//                            .source(Collections.singletonMap("foo", "bar"))
//                            .versionType(VersionType.EXTERNAL)
//                            .version(12),
//                    RequestOptions.DEFAULT
//            );
//            OpenSearchStatusException exception = expectThrows(OpenSearchStatusException.class, () -> {
//                DeleteRequest deleteRequest = new DeleteRequest("index", docId).versionType(VersionType.EXTERNAL).version(10);
//                execute(deleteRequest, highLevelClient()::delete, highLevelClient()::deleteAsync);
//            });
//            assertEquals(RestStatus.CONFLICT, exception.status());
//            assertEquals(
//                    "OpenSearch exception [type=version_conflict_engine_exception, reason=["
//                            + docId
//                            + "]: version conflict, current version [12] is higher or equal to the one provided [10]]",
//                    exception.getMessage()
//            );
//            assertEquals("index", exception.getMetadata("opensearch.index").get(0));
//        }
//        {
//            // Testing routing
//            String docId = "routing";
//            highLevelClient().index(
//                    new IndexRequest("index").id(docId).source(Collections.singletonMap("foo", "bar")).routing("foo"),
//                    RequestOptions.DEFAULT
//            );
//            DeleteRequest deleteRequest = new DeleteRequest("index", docId).routing("foo");
//            DeleteResponse deleteResponse = execute(deleteRequest, highLevelClient()::delete, highLevelClient()::deleteAsync);
//            assertEquals("index", deleteResponse.getIndex());
//            assertEquals("_doc", deleteResponse.getType());
//            assertEquals(docId, deleteResponse.getId());
//            assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
//        }
    }

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
                .refresh(Refresh.True));

        assertTrue(highLevelClient().exists(b -> b.index(index).id("id")).value());
        assertFalse(highLevelClient().exists(b -> b.index(index).id("random_id")).value());
        assertFalse(highLevelClient().exists(b -> b.index(index).id("random_id").version(1L)).value());
    }

    public void testSourceExists() throws IOException {
        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        {
            ExistsSourceRequest request = new ExistsSourceRequest.Builder()
                    .index("index")
                    .id("id")
                    .build();
            BooleanResponse response = highLevelClient().existsSource(request);
            assertFalse(response.value());
        }
        highLevelClient().index(b -> b
                .index("index")
                .id("id")
                .refresh(Refresh.True)
                .document(appData));
        {
            ExistsSourceRequest request = new ExistsSourceRequest.Builder()
                    .index("index")
                    .id("id")
                    .build();
            BooleanResponse response = highLevelClient().existsSource(request);
            assertTrue(response.value());
        }
        {
            ExistsSourceRequest request = new ExistsSourceRequest.Builder()
                    .index("index")
                    .id("does_not_exist")
                    .build();
            BooleanResponse response = highLevelClient().existsSource(request);
            assertFalse(response.value());
        }
    }

    public void testGet() throws IOException {

        {
            OpensearchException exception = expectThrows(
                    OpensearchException.class,
                    () -> highLevelClient().get(new GetRequest.Builder().index("index").id("id").build(), String.class)
            );
            assertEquals(404, exception.status());
            assertEquals("Request failed: [index_not_found_exception] no such index [index]", exception.getMessage());
        }

        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        highLevelClient().index(b -> b.index("index").id("id").document(appData).refresh(Refresh.True));

        {
            GetResponse<AppData> getResponse = highLevelClient().get(b -> b
                            .index("index")
                            .id("id")
                            .version(1L)
                    , AppData.class
            );
            assertEquals("index", getResponse.index());
            assertEquals("_doc", getResponse.type());
            assertEquals("id", getResponse.id());
            assertTrue(getResponse.found());
            assertEquals(java.util.Optional.of(1L), java.util.Optional.of(getResponse.version()));
            assertEquals(appData.getIntValue(), getResponse.source().getIntValue());
            assertEquals(appData.getMsg(), getResponse.source().getMsg());
        }
        {
            GetResponse<AppData> getResponse = highLevelClient().get(b -> b
                            .index("index")
                            .id("does_not_exist")
                    , AppData.class
            );
            assertEquals("index", getResponse.index());
            assertEquals("_doc", getResponse.type());
            assertEquals("does_not_exist", getResponse.id());
            assertFalse(getResponse.found());
            assertNull(getResponse.version());
            assertNull(getResponse.source());
        }
    }

    public void testGetWithTypes() throws IOException {
        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        highLevelClient().index(b -> b
                .index("index")
                .type("type")
                .id("id")
                .document(appData)
                .refresh(Refresh.True));

        GetResponse<AppData> getResponse = highLevelClient().get(b -> b
                        .index("index")
                        .id("id")
                        .type("type")
                , AppData.class
        );

        assertEquals("index", getResponse.index());
        assertEquals("type", getResponse.type());
        assertEquals("id", getResponse.id());

        assertTrue(getResponse.found());
        assertEquals(java.util.Optional.of(1L), java.util.Optional.of(getResponse.version()));
        assertEquals(appData.getMsg(), getResponse.source().getMsg());
    }

    public void testMultiGet() throws IOException {
        {
            AppData appData = new AppData();
            appData.setIntValue(1337);
            appData.setMsg("foo");

            List<String> ids = new ArrayList<>();
            ids.add("id1");
            ids.add("id2");
            MgetResponse<AppData> response = highLevelClient().mget(b -> b
                            .index("index")
                            .ids(ids)
                    , AppData.class
            );
            assertEquals(2, response.docs().size());

            assertTrue(response.docs().get(0).isFailure());
            assertEquals("id1", response.docs().get(0).failure().id());
            assertNull(response.docs().get(0).failure().type());
            assertEquals("index", response.docs().get(0).failure().index());
            assertEquals(
                    "no such index [index]",
                    response.docs().get(0).failure().error().reason()
            );
            assertTrue(response.docs().get(1).isFailure());
            assertEquals("id2", response.docs().get(1).failure().id());
            assertNull(response.docs().get(1).failure().type());
            assertEquals("index", response.docs().get(1).failure().index());
            assertEquals(
                    "no such index [index]",
                    response.docs().get(1).failure().error().reason()
            );
        }
    }

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

    public void testUpdate() throws Exception {
        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        AppData updatedAppData = new AppData();
        appData.setIntValue(3333);
        appData.setMsg("bar");

        {
            UpdateRequest<AppData, AppData> updateRequest = new UpdateRequest.Builder<AppData, AppData>()
                    .index("index")
                    .id("does_not_exist")
                    .doc(appData)
                    .build();
            try {
                highLevelClient().update(updateRequest, AppData.class);
            } catch (OpensearchException e) {
                assertEquals(
                        "Request failed: [document_missing_exception] [_doc][does_not_exist]: document missing",
                        e.getMessage()
                );
                assertEquals(404, e.status());
            }
        }
        {
            IndexRequest<AppData> indexRequest = new IndexRequest.Builder<AppData>()
                    .index("index")
                    .id("id")
                    .document(appData)
                    .build();
            IndexResponse indexResponse = highLevelClient().index(indexRequest);
            assertEquals(Result.Created, indexResponse.result());

            long lastUpdateSeqNo;
            long lastUpdatePrimaryTerm;
            {
                UpdateRequest<AppData, AppData> updateRequest = new UpdateRequest.Builder<AppData, AppData>()
                        .index("index")
                        .id("id")
                        .doc(updatedAppData)
                        .build();
                UpdateResponse<AppData> updateResponse = highLevelClient().update(updateRequest, AppData.class);
                assertEquals(Result.Updated, updateResponse.result());
                assertEquals(indexResponse.version() + 1, updateResponse.version());
                lastUpdateSeqNo = updateResponse.seqNo();
                lastUpdatePrimaryTerm = updateResponse.primaryTerm();
                assertTrue(lastUpdateSeqNo >= 0L);
                assertTrue(lastUpdatePrimaryTerm >= 1L);
            }

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
        }
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
    }

    public void testUpdateWithTypes() throws IOException {

        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        AppData updatedAppData = new AppData();
        appData.setIntValue(3333);
        appData.setMsg("bar");

        IndexRequest<AppData> indexRequest = new IndexRequest.Builder<AppData>()
                .index("index")
                .id("id")
                .type("type")
                .document(appData)
                .build();
        IndexResponse indexResponse = highLevelClient().index(indexRequest);

        UpdateRequest<AppData, AppData> updateRequest = new UpdateRequest.Builder<AppData, AppData>()
                .index("index")
                .id("id")
                .type("type")
                .doc(updatedAppData)
                .build();
        UpdateResponse<AppData> updateResponse = highLevelClient().update(updateRequest, AppData.class);

        assertEquals(Result.Updated, updateResponse.result());
        assertEquals(indexResponse.version() + 1, updateResponse.version());
    }

    public void testBulk() throws IOException {
        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");
        int nbItems = randomIntBetween(10, 100);
        boolean[] errors = new boolean[nbItems];

        List<BulkOperation> opsList = new ArrayList<>();

        for (int i = 0; i < nbItems; i++) {
            String id = String.valueOf(i);
            boolean erroneous = randomBoolean();
            errors[i] = erroneous;
            BulkOperation.Kind opType = randomFrom(BulkOperation.Kind.Delete, BulkOperation.Kind.Index,
                    BulkOperation.Kind.Create/*, BulkOperation.Kind.Update*/);
            if (opType.equals(BulkOperation.Kind.Delete)) {
                if (!erroneous) {
                    assertEquals(
                            Result.Created,
                            highLevelClient().index(b -> b.index("index").id(id).document(appData)).result()
                    );
                }
                BulkOperation op = new BulkOperation.Builder().delete(d -> d.index("index").id(id)).build();
                opsList.add(op);
            } else {
                appData.setIntValue(i);
                appData.setMsg("id");
                if (opType.equals(BulkOperation.Kind.Index)) {
                    BulkOperation op = new BulkOperation.Builder().index(b -> b
                            .index("index")
                            .id(id)
                            .document(appData)
                            .ifSeqNo(erroneous ? 12L : null)
                            .ifPrimaryTerm(erroneous ? 12L : null)).build();
                    opsList.add(op);

                } else if (opType.equals(BulkOperation.Kind.Create)) {
                    BulkOperation op = new BulkOperation.Builder().create(o -> o
                            .index("index")
                            .id(id)
                            .document(appData)
                    ).build();
                    opsList.add(op);

                    if (erroneous) {
                        assertEquals(Result.Created, highLevelClient().index(b -> b.
                                index("index").id(id).document(appData)).result());
                    }

                } else if (opType.equals(BulkOperation.Kind.Update)) {
                    BulkOperation op = new BulkOperation.Builder().update(o -> o
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
        BulkRequest bulkRequest = new BulkRequest.Builder().operations(opsList).build();

        BulkResponse bulkResponse = highLevelClient().bulk(bulkRequest);
        assertTrue(bulkResponse.took() > 0);
        assertEquals(nbItems, bulkResponse.items().size());

        validateBulkResponses(nbItems, errors, bulkResponse, bulkRequest);
    }

    private void validateBulkResponses(int nbItems, boolean[] errors, BulkResponse bulkResponse, BulkRequest bulkRequest) {
        for (int i = 0; i < nbItems; i++) {
            BulkResponseItem bulkResponseItem = bulkResponse.items().get(i);

            assertEquals("index", bulkResponseItem.index());
            assertEquals("_doc", bulkResponseItem.type());
            assertEquals(String.valueOf(i), bulkResponseItem.id());

            BulkOperation bulkOperation = bulkRequest.operations().get(i);
            if (bulkOperation.isIndex() || bulkOperation.isCreate()) {
                assertEquals(errors[i] ? 409 : 201, bulkResponseItem.status());
            } else if (bulkOperation.isUpdate()) {
                assertEquals(errors[i] ? Result.NotFound.jsonValue() : Result.Updated.jsonValue(), bulkResponseItem.result());
                assertEquals(errors[i] ? 404 : 200, bulkResponseItem.status());
            } else if (bulkOperation.isDelete()) {
                assertEquals(errors[i] ? Result.NotFound.jsonValue() : Result.Deleted.jsonValue(), bulkResponseItem.result());
                assertEquals(errors[i] ? 404 : 200, bulkResponseItem.status());
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