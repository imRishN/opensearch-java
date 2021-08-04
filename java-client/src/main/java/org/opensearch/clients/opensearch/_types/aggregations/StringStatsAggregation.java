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

package org.opensearch.clients.opensearch._types.aggregations;

import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.lang.Boolean;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: _types.aggregations.StringStatsAggregation
@JsonpDeserializable
public class StringStatsAggregation extends MetricAggregationBase implements AggregationVariant {
	@Nullable
	private final Boolean showDistribution;

	// ---------------------------------------------------------------------------------------------

	private StringStatsAggregation(Builder builder) {
		super(builder);

		this.showDistribution = builder.showDistribution;

	}

	public static StringStatsAggregation of(Function<Builder, ObjectBuilder<StringStatsAggregation>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * {@link Aggregation} variant type
	 */
	@Override
	public String _variantType() {
		return "string_stats";
	}

	/**
	 * API name: {@code show_distribution}
	 */
	@Nullable
	public final Boolean showDistribution() {
		return this.showDistribution;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		super.serializeInternal(generator, mapper);
		if (this.showDistribution != null) {
			generator.writeKey("show_distribution");
			generator.write(this.showDistribution);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link StringStatsAggregation}.
	 */
	public static class Builder extends MetricAggregationBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<StringStatsAggregation> {
		@Nullable
		private Boolean showDistribution;

		/**
		 * API name: {@code show_distribution}
		 */
		public final Builder showDistribution(@Nullable Boolean value) {
			this.showDistribution = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link StringStatsAggregation}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public StringStatsAggregation build() {
			_checkSingleUse();

			return new StringStatsAggregation(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link StringStatsAggregation}
	 */
	public static final JsonpDeserializer<StringStatsAggregation> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, StringStatsAggregation::setupStringStatsAggregationDeserializer, Builder::build);

	protected static void setupStringStatsAggregationDeserializer(
			DelegatingDeserializer<StringStatsAggregation.Builder> op) {
		MetricAggregationBase.setupMetricAggregationBaseDeserializer(op);
		op.add(Builder::showDistribution, JsonpDeserializer.booleanDeserializer(), "show_distribution");

	}

}
