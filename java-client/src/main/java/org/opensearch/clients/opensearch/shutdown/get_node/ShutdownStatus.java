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

package org.opensearch.clients.opensearch.shutdown.get_node;

import org.opensearch.clients.json.JsonEnum;
import org.opensearch.clients.json.JsonpDeserializable;

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/shutdown/get_node/ShutdownGetNodeResponse.ts#L45-L50">API
 *      specification</a>
 */
@JsonpDeserializable
public enum ShutdownStatus implements JsonEnum {
	NotStarted("not_started"),

	InProgress("in_progress"),

	Stalled("stalled"),

	Complete("complete"),

	;

	private final String jsonValue;

	ShutdownStatus(String jsonValue) {
		this.jsonValue = jsonValue;
	}

	public String jsonValue() {
		return this.jsonValue;
	}

	public static final JsonEnum.Deserializer<ShutdownStatus> _DESERIALIZER = new JsonEnum.Deserializer<>(
			ShutdownStatus.values());
}