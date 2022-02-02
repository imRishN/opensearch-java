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

package org.opensearch.clients.elasticsearch.cluster.stats;

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
import java.util.function.Function;

// typedef: cluster.stats.NodePackagingType

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/cluster/stats/types.ts#L272-L276">API
 *      specification</a>
 */
@JsonpDeserializable
public class NodePackagingType implements JsonpSerializable {
	private final int count;

	private final String flavor;

	private final String type;

	// ---------------------------------------------------------------------------------------------

	private NodePackagingType(Builder builder) {

		this.count = ApiTypeHelper.requireNonNull(builder.count, this, "count");
		this.flavor = ApiTypeHelper.requireNonNull(builder.flavor, this, "flavor");
		this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");

	}

	public static NodePackagingType of(Function<Builder, ObjectBuilder<NodePackagingType>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code count}
	 */
	public final int count() {
		return this.count;
	}

	/**
	 * Required - API name: {@code flavor}
	 */
	public final String flavor() {
		return this.flavor;
	}

	/**
	 * Required - API name: {@code type}
	 */
	public final String type() {
		return this.type;
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

		generator.writeKey("count");
		generator.write(this.count);

		generator.writeKey("flavor");
		generator.write(this.flavor);

		generator.writeKey("type");
		generator.write(this.type);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link NodePackagingType}.
	 */

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<NodePackagingType> {
		private Integer count;

		private String flavor;

		private String type;

		/**
		 * Required - API name: {@code count}
		 */
		public final Builder count(int value) {
			this.count = value;
			return this;
		}

		/**
		 * Required - API name: {@code flavor}
		 */
		public final Builder flavor(String value) {
			this.flavor = value;
			return this;
		}

		/**
		 * Required - API name: {@code type}
		 */
		public final Builder type(String value) {
			this.type = value;
			return this;
		}

		/**
		 * Builds a {@link NodePackagingType}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public NodePackagingType build() {
			_checkSingleUse();

			return new NodePackagingType(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link NodePackagingType}
	 */
	public static final JsonpDeserializer<NodePackagingType> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, NodePackagingType::setupNodePackagingTypeDeserializer);

	protected static void setupNodePackagingTypeDeserializer(ObjectDeserializer<NodePackagingType.Builder> op) {

		op.add(Builder::count, JsonpDeserializer.integerDeserializer(), "count");
		op.add(Builder::flavor, JsonpDeserializer.stringDeserializer(), "flavor");
		op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");

	}

}
