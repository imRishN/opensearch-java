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

package org.opensearch.clients.opensearch.indices;

import org.opensearch.clients.json.JsonpDeserializer;

// typedef: indices.exists_alias.Response

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/indices/exists_alias/IndicesExistsAliasResponse.ts#L22-L24">API
 *      specification</a>
 */

public class ExistsAliasResponse {
	public ExistsAliasResponse() {
	}

	/**
	 * Singleton instance for {@link ExistsAliasResponse}.
	 */
	public static final ExistsAliasResponse _INSTANCE = new ExistsAliasResponse();

	public static final JsonpDeserializer<ExistsAliasResponse> _DESERIALIZER = JsonpDeserializer
			.fixedValue(ExistsAliasResponse._INSTANCE);

}
