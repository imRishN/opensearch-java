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

package org.opensearch.client.opensearch._types.mapping;

import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.lang.Integer;
import java.lang.String;
import java.util.function.Function;

// typedef: _types.mapping.DenseVectorIndexOptions

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/_types/mapping/DenseVectorIndexOptions.ts#L22-L26">API
 *      specification</a>
 */
@JsonpDeserializable
public class DenseVectorIndexOptions implements JsonpSerializable {
	private final String type;

	private final int m;

	private final int efConstruction;

	// ---------------------------------------------------------------------------------------------

	private DenseVectorIndexOptions(Builder builder) {

		this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
		this.m = ApiTypeHelper.requireNonNull(builder.m, this, "m");
		this.efConstruction = ApiTypeHelper.requireNonNull(builder.efConstruction, this, "efConstruction");

	}

	public static DenseVectorIndexOptions of(Function<Builder, ObjectBuilder<DenseVectorIndexOptions>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code type}
	 */
	public final String type() {
		return this.type;
	}

	/**
	 * Required - API name: {@code m}
	 */
	public final int m() {
		return this.m;
	}

	/**
	 * Required - API name: {@code ef_construction}
	 */
	public final int efConstruction() {
		return this.efConstruction;
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

		generator.writeKey("type");
		generator.write(this.type);

		generator.writeKey("m");
		generator.write(this.m);

		generator.writeKey("ef_construction");
		generator.write(this.efConstruction);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link DenseVectorIndexOptions}.
	 */

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<DenseVectorIndexOptions> {
		private String type;

		private Integer m;

		private Integer efConstruction;

		/**
		 * Required - API name: {@code type}
		 */
		public final Builder type(String value) {
			this.type = value;
			return this;
		}

		/**
		 * Required - API name: {@code m}
		 */
		public final Builder m(int value) {
			this.m = value;
			return this;
		}

		/**
		 * Required - API name: {@code ef_construction}
		 */
		public final Builder efConstruction(int value) {
			this.efConstruction = value;
			return this;
		}

		/**
		 * Builds a {@link DenseVectorIndexOptions}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public DenseVectorIndexOptions build() {
			_checkSingleUse();

			return new DenseVectorIndexOptions(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link DenseVectorIndexOptions}
	 */
	public static final JsonpDeserializer<DenseVectorIndexOptions> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, DenseVectorIndexOptions::setupDenseVectorIndexOptionsDeserializer);

	protected static void setupDenseVectorIndexOptionsDeserializer(
			ObjectDeserializer<DenseVectorIndexOptions.Builder> op) {

		op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
		op.add(Builder::m, JsonpDeserializer.integerDeserializer(), "m");
		op.add(Builder::efConstruction, JsonpDeserializer.integerDeserializer(), "ef_construction");

	}

}