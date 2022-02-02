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

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.clients.elasticsearch.cat;

import org.opensearch.clients.elasticsearch._types.ErrorResponse;
import org.opensearch.clients.transport.Endpoint;
import org.opensearch.clients.transport.endpoints.SimpleEndpoint;

import java.util.HashMap;
import java.util.Map;

// typedef: cat.repositories.Request

/**
 * Returns information about snapshot repositories registered in the cluster.
 * 
 */

public class RepositoriesRequest extends CatRequestBase {
	public RepositoriesRequest() {
	}

	/**
	 * Singleton instance for {@link RepositoriesRequest}.
	 */
	public static final RepositoriesRequest _INSTANCE = new RepositoriesRequest();

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code cat.repositories}".
	 */
	public static final Endpoint<RepositoriesRequest, RepositoriesResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
			"es/cat.repositories",

			// Request method
			request -> {
				return "GET";

			},

			// Request path
			request -> {
				return "/_cat/repositories";

			},

			// Request parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				params.put("format", "json");
				return params;

			}, SimpleEndpoint.emptyMap(), false, RepositoriesResponse._DESERIALIZER);
}
