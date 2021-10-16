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

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.cluster;

import org.opensearch.client.json.JsonpDeserializer;

// typedef: cluster.delete_voting_config_exclusions.Response

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/cluster/delete_voting_config_exclusions/ClusterDeleteVotingConfigExclusionsResponse.ts#L22-L24">API
 *      specification</a>
 */

public class DeleteVotingConfigExclusionsResponse {
	public DeleteVotingConfigExclusionsResponse() {
	}

	/**
	 * Singleton instance for {@link DeleteVotingConfigExclusionsResponse}.
	 */
	public static final DeleteVotingConfigExclusionsResponse _INSTANCE = new DeleteVotingConfigExclusionsResponse();

	public static final JsonpDeserializer<DeleteVotingConfigExclusionsResponse> _DESERIALIZER = JsonpDeserializer
			.fixedValue(DeleteVotingConfigExclusionsResponse._INSTANCE);

}