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

package org.opensearch.clients.opensearch.nodes.info;

import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.JsonpSerializable;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ObjectDeserializer;
import org.opensearch.clients.util.ApiTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.lang.String;
import java.util.function.Function;

// typedef: nodes.info.NodeInfoSearchRemote

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/nodes/info/types.ts#L275-L277">API
 *      specification</a>
 */
@JsonpDeserializable
public class NodeInfoSearchRemote implements JsonpSerializable {
	private final String connect;

	// ---------------------------------------------------------------------------------------------

	private NodeInfoSearchRemote(Builder builder) {

		this.connect = ApiTypeHelper.requireNonNull(builder.connect, this, "connect");

	}

	public static NodeInfoSearchRemote of(Function<Builder, ObjectBuilder<NodeInfoSearchRemote>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code connect}
	 */
	public final String connect() {
		return this.connect;
	}

	/**
	 * Serialize this object to JSON.
	 */
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartObject();
		serializeInternal(generator, mapper);
		generator.writeEnd();
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		generator.writeKey("connect");
		generator.write(this.connect);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link NodeInfoSearchRemote}.
	 */

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<NodeInfoSearchRemote> {
		private String connect;

		/**
		 * Required - API name: {@code connect}
		 */
		public final Builder connect(String value) {
			this.connect = value;
			return this;
		}

		/**
		 * Builds a {@link NodeInfoSearchRemote}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public NodeInfoSearchRemote build() {
			_checkSingleUse();

			return new NodeInfoSearchRemote(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link NodeInfoSearchRemote}
	 */
	public static final JsonpDeserializer<NodeInfoSearchRemote> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, NodeInfoSearchRemote::setupNodeInfoSearchRemoteDeserializer);

	protected static void setupNodeInfoSearchRemoteDeserializer(ObjectDeserializer<NodeInfoSearchRemote.Builder> op) {

		op.add(Builder::connect, JsonpDeserializer.stringDeserializer(), "connect");

	}

}