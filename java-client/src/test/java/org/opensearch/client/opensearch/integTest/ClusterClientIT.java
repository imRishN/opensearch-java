/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import org.opensearch.client.json.JsonData;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch._types.Health;
import org.opensearch.client.opensearch._types.Level;
import org.opensearch.client.opensearch._types.OpensearchException;
import org.opensearch.client.opensearch.cluster.GetSettingsRequest;
import org.opensearch.client.opensearch.cluster.GetSettingsResponse;
import org.opensearch.client.opensearch.cluster.HealthRequest;
import org.opensearch.client.opensearch.cluster.HealthResponse;
import org.opensearch.client.opensearch.cluster.PutSettingsRequest;
import org.opensearch.client.opensearch.cluster.PutSettingsResponse;
import org.opensearch.client.opensearch.cluster.health.IndexHealthStats;
import org.opensearch.client.opensearch.cluster.health.ShardHealthStats;
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
import org.opensearch.common.settings.Settings;
import org.opensearch.indices.recovery.RecoverySettings;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.emptyMap;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

public class ClusterClientIT extends OpenSearchRestHighLevelClientTestCase {

    public void testClusterPutSettings() throws IOException {
        OpenSearchClient openSearchClient = highLevelClient();

        final String transientSettingKey = RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey();
        String[] transientSettingKeySplit = transientSettingKey.split("\\.");
        final String transientSettingValue = "10b";

        final String persistentSettingKey = EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey();
        String[] persistentSettingKeySplit = persistentSettingKey.split("\\.");
        final String persistentSettingValue = EnableAllocationDecider.Allocation.NONE.name();

        Map<String, JsonData> transientSettingsMap = new HashMap<>();
        Map<String, JsonData> persistentSettingsMap = new HashMap<>();

        transientSettingsMap.put(transientSettingKey, JsonData.of(transientSettingValue));
        persistentSettingsMap.put(persistentSettingKey, JsonData.of(persistentSettingValue));

        PutSettingsRequest request = new PutSettingsRequest.Builder()
                .persistent(persistentSettingsMap)
                .transient_(transientSettingsMap)
                .build();
        PutSettingsResponse response = openSearchClient.cluster().putSettings(request);

        assertTrue(response.acknowledged());
        assertThat(response.transient_().get(transientSettingKeySplit[0]), notNullValue());
        assertThat(response.transient_().get(persistentSettingKeySplit[0]), nullValue());
        assertEquals(
                response.transient_().get(transientSettingKeySplit[0]).toJson().asJsonObject()
                        .getJsonObject("recovery")
                        .getString("max_bytes_per_sec"),
                transientSettingValue
        );
        assertThat(response.persistent().get(transientSettingKeySplit[0]), nullValue());
        assertThat(response.persistent().get(persistentSettingKeySplit[0]), notNullValue());
        assertEquals(
                response.persistent().get(persistentSettingKeySplit[0]).toJson().asJsonObject()
                        .getJsonObject("routing")
                        .getJsonObject("allocation")
                        .getString("enable"),
                persistentSettingValue
        );
    }

    public void testClusterUpdateSettingNonExistent() throws IOException {
        OpenSearchClient openSearchClient = highLevelClient();
        String setting = "no_idea_what_you_are_talking_about";
        int value = 10;

        Map<String, JsonData> transientSettingsMap = new HashMap<>();
        transientSettingsMap.put(setting, JsonData.of(value));

        PutSettingsRequest request = new PutSettingsRequest.Builder()
                .transient_(transientSettingsMap)
                .build();
        try {
            openSearchClient.cluster().putSettings(request);
            fail();
        } catch (OpensearchException e) {
            assertNotNull(e);
            assertEquals(e.response().status(), 400);
            assertEquals(
                    e.getMessage(),
                    "[illegal_argument_exception] transient setting [no_idea_what_you_are_talking_about], not recognized"
            );
        }
    }

    public void testClusterGetSettings() throws IOException {
        OpenSearchClient openSearchClient = highLevelClient();

        final String transientSettingKey = RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey();
        final String transientSettingValue = "10b";

        final String persistentSettingKey = EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey();
        final String persistentSettingValue = EnableAllocationDecider.Allocation.NONE.name();

        Map<String, JsonData> transientSettingsMap = new HashMap<>();
        Map<String, JsonData> persistentSettingsMap = new HashMap<>();

        transientSettingsMap.put(transientSettingKey, JsonData.of(transientSettingValue));
        persistentSettingsMap.put(persistentSettingKey, JsonData.of(persistentSettingValue));

        PutSettingsRequest request = new PutSettingsRequest.Builder()
                .persistent(persistentSettingsMap)
                .transient_(transientSettingsMap)
                .build();
        openSearchClient.cluster().putSettings(request);

        GetSettingsResponse getSettingsResponse = openSearchClient.cluster().getSettings(new GetSettingsRequest.Builder().build());
        //TODO - compare actual and expected result
        assertEquals(1, getSettingsResponse.persistent().size());
        assertEquals(1, getSettingsResponse.transient_().size());
        assertEquals(0, getSettingsResponse.defaults().size());
    }

    public void testClusterGetSettingsWithDefault() throws IOException {
        OpenSearchClient openSearchClient = highLevelClient();

        final String transientSettingKey = RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey();
        final String transientSettingValue = "10b";

        final String persistentSettingKey = EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey();
        final String persistentSettingValue = EnableAllocationDecider.Allocation.NONE.name();

        Map<String, JsonData> transientSettingsMap = new HashMap<>();
        Map<String, JsonData> persistentSettingsMap = new HashMap<>();

        transientSettingsMap.put(transientSettingKey, JsonData.of(transientSettingValue));
        persistentSettingsMap.put(persistentSettingKey, JsonData.of(persistentSettingValue));

        PutSettingsRequest request = new PutSettingsRequest.Builder()
                .persistent(persistentSettingsMap)
                .transient_(transientSettingsMap)
                .build();
        openSearchClient.cluster().putSettings(request);

        GetSettingsResponse getSettingsResponse = openSearchClient.cluster().getSettings(new GetSettingsRequest.Builder()
                .includeDefaults(true).build());

        assertEquals(1, getSettingsResponse.persistent().size());
        assertEquals(1, getSettingsResponse.transient_().size());
        assertTrue(getSettingsResponse.defaults().size()>0);
    }

    public void testClusterHealthGreen() throws IOException {
        OpenSearchClient openSearchClient = highLevelClient();
        HealthRequest request = new HealthRequest.Builder()
                .timeout("5s")
                .level(Level.Cluster)
                .build();
        HealthResponse response = openSearchClient.cluster().health(request);
        assertNotNull(response);
        assertFalse(response.timedOut());
//        assertEquals(response.status(), Health.Green);
    }

    public void testClusterHealthYellowClusterLevel() throws IOException {
        OpenSearchClient openSearchClient = highLevelClient();
        createIndex("index", Settings.EMPTY);
        createIndex("index2", Settings.EMPTY);
        HealthRequest request = new HealthRequest.Builder().timeout("5s").build();
        HealthResponse response = openSearchClient.cluster().health(request);
        assertThat(response.indices().size(), equalTo(0));
    }

    public void testClusterHealthYellowIndicesLevel() throws IOException {
        OpenSearchClient openSearchClient = highLevelClient();
        String firstIndex = "index";
        String secondIndex = "index2";
        // including another index that we do not assert on, to ensure that we are not
        // accidentally asserting on entire cluster state
        String ignoredIndex = "tasks";
        createIndex(firstIndex, Settings.EMPTY);
        createIndex(secondIndex, Settings.EMPTY);
        if (randomBoolean()) {
            createIndex(ignoredIndex, Settings.EMPTY);
        }
        HealthRequest request = new HealthRequest.Builder()
                .index(firstIndex, secondIndex)
                .timeout("5s")
                .level(Level.Indices)
                .build();
        HealthResponse response = openSearchClient.cluster().health(request);
        assertYellowShards(response);
        assertEquals(response.indices().size(), 2);
        for (Map.Entry<String, IndexHealthStats> entry : response.indices().entrySet()) {
            assertYellowIndex(entry.getKey(), entry.getValue(), true);
        }
    }

    private static void assertYellowShards(HealthResponse response) {
        assertNotNull(response);
        assertFalse(response.timedOut());
        assertEquals(response.status(), Health.Yellow);
        assertEquals(response.activePrimaryShards(), 2);
        assertEquals(response.numberOfDataNodes(), 1);
        assertEquals(response.numberOfNodes(), 1);
        assertEquals(response.activeShards(), 2);
        assertEquals(response.delayedUnassignedShards(),0);
        assertEquals(response.initializingShards(), 0);
        assertEquals(response.unassignedShards(), 2);
    }

    public void testClusterHealthYellowSpecificIndex() throws IOException {
        OpenSearchClient openSearchClient = highLevelClient();
        createIndex("index", Settings.EMPTY);
        createIndex("index2", Settings.EMPTY);
        HealthRequest request = new HealthRequest.Builder()
                .index("index")
                .timeout("5s")
                .level(Level.Shards)
                .build();
        HealthResponse response = openSearchClient.cluster().health(request);

        assertNotNull(response);
        assertFalse(response.timedOut());
        assertEquals(response.status(), Health.Yellow);
        assertEquals(response.activePrimaryShards(), 1);
        assertEquals(response.numberOfDataNodes(), 1);
        assertEquals(response.numberOfNodes(), 1);
        assertEquals(response.activeShards(), 1);
        assertEquals(response.delayedUnassignedShards(), 0);
        assertEquals(response.initializingShards(), 0);
        assertEquals(response.unassignedShards(), 1);
        assertEquals(response.indices().size(), 1);
        Map.Entry<String, IndexHealthStats> index = response.indices().entrySet().iterator().next();
        assertYellowIndex(index.getKey(), index.getValue(), false);
    }

    private static void assertYellowIndex(String indexName, IndexHealthStats indexHealth, boolean emptyShards) {
        assertNotNull(indexHealth);
        assertEquals(indexHealth.activePrimaryShards(),1);
        assertEquals(indexHealth.activeShards(), 1);
        assertEquals(indexHealth.numberOfReplicas(), 1);
        assertEquals(indexHealth.initializingShards(), 0);
        assertEquals(indexHealth.unassignedShards(), 1);
        assertEquals(indexHealth.relocatingShards(), 0);
        assertEquals(indexHealth.status(), Health.Yellow);
        if (emptyShards) {
            assertEquals(indexHealth.shards().size(), 0);
        } else {
            assertEquals(indexHealth.shards().size(), 1);
            for (Map.Entry<String, ShardHealthStats> entry : indexHealth.shards().entrySet()) {
                assertYellowShard(entry.getKey(), entry.getValue());
            }
        }
    }
//
    private static void assertYellowShard(String shardId, ShardHealthStats shardHealth) {
        assertNotNull(shardHealth);
        assertEquals(shardHealth.status(), Health.Yellow);
        assertEquals(shardHealth.activeShards(), 1);
        assertEquals(shardHealth.initializingShards(), 0);
        assertEquals(shardHealth.unassignedShards(), 1);
        assertEquals(shardHealth.relocatingShards(), 0);
    }

    private static void assertNoIndices(HealthResponse response) {
        assertEquals(response.indices(), emptyMap());
        assertEquals(response.activePrimaryShards(), 0);
        assertEquals(response.numberOfDataNodes(), 1);
        assertEquals(response.numberOfNodes(), 1);
        assertEquals(response.activeShards(), 0);
        assertEquals(response.delayedUnassignedShards(), 0);
        assertEquals(response.initializingShards(), 0);
        assertEquals(response.unassignedShards(), 0);
    }

//    public void testClusterHealthNotFoundIndex() throws IOException {
//        OpenSearchClient openSearchClient = highLevelClient();
//        createIndex("index", Settings.EMPTY);
//        HealthRequest request = new HealthRequest.Builder().index("notexisted-index").timeout("5s").build();
//        try {
//            HealthResponse response = openSearchClient.cluster().health(request);
//            assertNotNull(response);
//            assertTrue(response.timedOut());
//            assertEquals(response.status(), Health.Red);
//            assertNoIndices(response);
//        } catch (ResponseException e) {
//            assertNotNull(e);
//        }
//    }
//
//    public void testRemoteInfo() throws Exception {
//        String clusterAlias = "local_cluster";
//        setupRemoteClusterConfig(clusterAlias);
//
//        ClusterGetSettingsRequest settingsRequest = new ClusterGetSettingsRequest();
//        settingsRequest.includeDefaults(true);
//        ClusterGetSettingsResponse settingsResponse = highLevelClient().cluster().getSettings(settingsRequest, RequestOptions.DEFAULT);
//
//        List<String> seeds = SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS.getConcreteSettingForNamespace(clusterAlias)
//                .get(settingsResponse.getTransientSettings());
//        int connectionsPerCluster = SniffConnectionStrategy.REMOTE_CONNECTIONS_PER_CLUSTER.get(settingsResponse.getTransientSettings());
//        TimeValue initialConnectionTimeout = RemoteClusterService.REMOTE_INITIAL_CONNECTION_TIMEOUT_SETTING.get(
//                settingsResponse.getTransientSettings()
//        );
//        boolean skipUnavailable = RemoteClusterService.REMOTE_CLUSTER_SKIP_UNAVAILABLE.getConcreteSettingForNamespace(clusterAlias)
//                .get(settingsResponse.getTransientSettings());
//
//        RemoteInfoRequest request = new RemoteInfoRequest();
//        RemoteInfoResponse response = execute(
//                request,
//                highLevelClient().cluster()::remoteInfo,
//                highLevelClient().cluster()::remoteInfoAsync
//        );
//
//        assertThat(response, notNullValue());
//        assertThat(response.getInfos().size(), equalTo(1));
//        RemoteConnectionInfo info = response.getInfos().get(0);
//        assertThat(info.getClusterAlias(), equalTo(clusterAlias));
//        assertThat(info.getInitialConnectionTimeoutString(), equalTo(initialConnectionTimeout.toString()));
//        assertThat(info.isSkipUnavailable(), equalTo(skipUnavailable));
//        assertThat(info.getModeInfo().modeName(), equalTo(SniffModeInfo.NAME));
//        assertThat(info.getModeInfo().isConnected(), equalTo(true));
//        SniffModeInfo sniffModeInfo = (SniffModeInfo) info.getModeInfo();
//        assertThat(sniffModeInfo.getMaxConnectionsPerCluster(), equalTo(connectionsPerCluster));
//        assertThat(sniffModeInfo.getNumNodesConnected(), equalTo(1));
//        assertThat(sniffModeInfo.getSeedNodes(), equalTo(seeds));
//    }

//    public void testComponentTemplates() throws Exception {
//        String templateName = "my-template";
//        Settings settings = Settings.builder().put("index.number_of_shards", 1).build();
//        CompressedXContent mappings = new CompressedXContent("{\"properties\":{\"host_name\":{\"type\":\"keyword\"}}}");
//        AliasMetadata alias = AliasMetadata.builder("alias").writeIndex(true).build();
//        Template template = new Template(settings, mappings, Collections.singletonMap("alias", alias));
//        ComponentTemplate componentTemplate = new ComponentTemplate(template, 1L, new HashMap<>());
//        PutComponentTemplateRequest putComponentTemplateRequest = new PutComponentTemplateRequest().name(templateName)
//                .create(true)
//                .componentTemplate(componentTemplate);
//
//        AcknowledgedResponse response = execute(
//                putComponentTemplateRequest,
//                highLevelClient().cluster()::putComponentTemplate,
//                highLevelClient().cluster()::putComponentTemplateAsync
//        );
//        assertThat(response.isAcknowledged(), equalTo(true));
//
//        ComponentTemplatesExistRequest componentTemplatesExistRequest = new ComponentTemplatesExistRequest(templateName);
//        boolean exist = execute(
//                componentTemplatesExistRequest,
//                highLevelClient().cluster()::existsComponentTemplate,
//                highLevelClient().cluster()::existsComponentTemplateAsync
//        );
//
//        assertTrue(exist);
//
//        GetComponentTemplatesRequest getComponentTemplatesRequest = new GetComponentTemplatesRequest(templateName);
//        GetComponentTemplatesResponse getResponse = execute(
//                getComponentTemplatesRequest,
//                highLevelClient().cluster()::getComponentTemplate,
//                highLevelClient().cluster()::getComponentTemplateAsync
//        );
//
//        assertThat(getResponse.getComponentTemplates().size(), equalTo(1));
//        assertThat(getResponse.getComponentTemplates().containsKey(templateName), equalTo(true));
//        assertThat(getResponse.getComponentTemplates().get(templateName), equalTo(componentTemplate));
//
//        DeleteComponentTemplateRequest deleteComponentTemplateRequest = new DeleteComponentTemplateRequest(templateName);
//        response = execute(
//                deleteComponentTemplateRequest,
//                highLevelClient().cluster()::deleteComponentTemplate,
//                highLevelClient().cluster()::deleteComponentTemplateAsync
//        );
//        assertThat(response.isAcknowledged(), equalTo(true));
//
//        OpenSearchStatusException statusException = expectThrows(
//                OpenSearchStatusException.class,
//                () -> execute(
//                        getComponentTemplatesRequest,
//                        highLevelClient().cluster()::getComponentTemplate,
//                        highLevelClient().cluster()::getComponentTemplateAsync
//                )
//        );
//
//        assertThat(statusException.status(), equalTo(RestStatus.NOT_FOUND));
//
//        exist = execute(
//                componentTemplatesExistRequest,
//                highLevelClient().cluster()::existsComponentTemplate,
//                highLevelClient().cluster()::existsComponentTemplateAsync
//        );
//
//        assertFalse(exist);
//    }
}
