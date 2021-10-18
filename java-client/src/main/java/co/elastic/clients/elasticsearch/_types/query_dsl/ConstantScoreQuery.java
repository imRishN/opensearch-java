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

package co.elastic.clients.elasticsearch._types.query_dsl;

import co.elastic.clients.json.DelegatingDeserializer;
import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: _types.query_dsl.ConstantScoreQuery
@JsonpDeserializable
public final class ConstantScoreQuery extends QueryBase implements QueryVariant {
	private final Query filter;

	// ---------------------------------------------------------------------------------------------

	public ConstantScoreQuery(Builder builder) {
		super(builder);

		this.filter = Objects.requireNonNull(builder.filter, "filter");

	}

	public ConstantScoreQuery(Function<Builder, Builder> fn) {
		this(fn.apply(new Builder()));
	}

	/**
	 * {@link Query} variant type
	 */
	@Override
	public String _variantType() {
		return "constant_score";
	}

	/**
	 * Required - API name: {@code filter}
	 */
	public Query filter() {
		return this.filter;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		super.serializeInternal(generator, mapper);

		generator.writeKey("filter");
		this.filter.serialize(generator, mapper);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ConstantScoreQuery}.
	 */
	public static class Builder extends QueryBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<ConstantScoreQuery> {
		private Query filter;

		/**
		 * Required - API name: {@code filter}
		 */
		public Builder filter(Query value) {
			this.filter = value;
			return this;
		}

		/**
		 * Required - API name: {@code filter}
		 */
		public Builder filter(Function<Query.Builder, ObjectBuilder<Query>> fn) {
			return this.filter(fn.apply(new Query.Builder()).build());
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link ConstantScoreQuery}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ConstantScoreQuery build() {

			return new ConstantScoreQuery(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link ConstantScoreQuery}
	 */
	public static final JsonpDeserializer<ConstantScoreQuery> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, ConstantScoreQuery::setupConstantScoreQueryDeserializer, Builder::build);

	protected static void setupConstantScoreQueryDeserializer(DelegatingDeserializer<ConstantScoreQuery.Builder> op) {
		QueryBase.setupQueryBaseDeserializer(op);
		op.add(Builder::filter, Query._DESERIALIZER, "filter");

	}

}