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

package org.opensearch.clients.opensearch._types.mapping;

import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ObjectDeserializer;
import org.opensearch.clients.util.ApiTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: _types.mapping.DenseVectorProperty

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/_types/mapping/complex.ts#L50-L56">API
 *      specification</a>
 */
@JsonpDeserializable
public class DenseVectorProperty extends PropertyBase implements PropertyVariant {
	private final int dims;

	@Nullable
	private final String similarity;

	@Nullable
	private final Boolean index;

	@Nullable
	private final DenseVectorIndexOptions indexOptions;

	// ---------------------------------------------------------------------------------------------

	private DenseVectorProperty(Builder builder) {
		super(builder);

		this.dims = ApiTypeHelper.requireNonNull(builder.dims, this, "dims");
		this.similarity = builder.similarity;
		this.index = builder.index;
		this.indexOptions = builder.indexOptions;

	}

	public static DenseVectorProperty of(Function<Builder, ObjectBuilder<DenseVectorProperty>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Property variant kind.
	 */
	@Override
	public Property.Kind _propertyKind() {
		return Property.Kind.DenseVector;
	}

	/**
	 * Required - API name: {@code dims}
	 */
	public final int dims() {
		return this.dims;
	}

	/**
	 * API name: {@code similarity}
	 */
	@Nullable
	public final String similarity() {
		return this.similarity;
	}

	/**
	 * API name: {@code index}
	 */
	@Nullable
	public final Boolean index() {
		return this.index;
	}

	/**
	 * API name: {@code index_options}
	 */
	@Nullable
	public final DenseVectorIndexOptions indexOptions() {
		return this.indexOptions;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		generator.write("type", "dense_vector");
		super.serializeInternal(generator, mapper);
		generator.writeKey("dims");
		generator.write(this.dims);

		if (this.similarity != null) {
			generator.writeKey("similarity");
			generator.write(this.similarity);

		}
		if (this.index != null) {
			generator.writeKey("index");
			generator.write(this.index);

		}
		if (this.indexOptions != null) {
			generator.writeKey("index_options");
			this.indexOptions.serialize(generator, mapper);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link DenseVectorProperty}.
	 */

	public static class Builder extends PropertyBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<DenseVectorProperty> {
		private Integer dims;

		@Nullable
		private String similarity;

		@Nullable
		private Boolean index;

		@Nullable
		private DenseVectorIndexOptions indexOptions;

		/**
		 * Required - API name: {@code dims}
		 */
		public final Builder dims(int value) {
			this.dims = value;
			return this;
		}

		/**
		 * API name: {@code similarity}
		 */
		public final Builder similarity(@Nullable String value) {
			this.similarity = value;
			return this;
		}

		/**
		 * API name: {@code index}
		 */
		public final Builder index(@Nullable Boolean value) {
			this.index = value;
			return this;
		}

		/**
		 * API name: {@code index_options}
		 */
		public final Builder indexOptions(@Nullable DenseVectorIndexOptions value) {
			this.indexOptions = value;
			return this;
		}

		/**
		 * API name: {@code index_options}
		 */
		public final Builder indexOptions(
				Function<DenseVectorIndexOptions.Builder, ObjectBuilder<DenseVectorIndexOptions>> fn) {
			return this.indexOptions(fn.apply(new DenseVectorIndexOptions.Builder()).build());
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link DenseVectorProperty}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public DenseVectorProperty build() {
			_checkSingleUse();

			return new DenseVectorProperty(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link DenseVectorProperty}
	 */
	public static final JsonpDeserializer<DenseVectorProperty> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, DenseVectorProperty::setupDenseVectorPropertyDeserializer);

	protected static void setupDenseVectorPropertyDeserializer(ObjectDeserializer<DenseVectorProperty.Builder> op) {
		PropertyBase.setupPropertyBaseDeserializer(op);
		op.add(Builder::dims, JsonpDeserializer.integerDeserializer(), "dims");
		op.add(Builder::similarity, JsonpDeserializer.stringDeserializer(), "similarity");
		op.add(Builder::index, JsonpDeserializer.booleanDeserializer(), "index");
		op.add(Builder::indexOptions, DenseVectorIndexOptions._DESERIALIZER, "index_options");

		op.ignore("type");
	}

}