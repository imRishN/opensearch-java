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

package org.opensearch.client.opensearch._types.aggregations;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.util.ObjectBuilder;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// typedef: _types.aggregations.PercentilesBucketAggregation
public final class PercentilesBucketAggregation extends PipelineAggregationBase {
	@Nullable
	private final List<Number> percents;

	// ---------------------------------------------------------------------------------------------

	protected PercentilesBucketAggregation(Builder builder) {
		super(builder);
		this.percents = builder.percents;

	}

	/**
	 * API name: {@code percents}
	 */
	@Nullable
	public List<Number> percents() {
		return this.percents;
	}

	protected void toJsonpInternal(JsonGenerator generator, JsonpMapper mapper) {
		super.toJsonpInternal(generator, mapper);
		if (this.percents != null) {

			generator.writeKey("percents");
			generator.writeStartArray();
			for (Number item0 : this.percents) {
				generator.write(item0.doubleValue());

			}
			generator.writeEnd();

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link PercentilesBucketAggregation}.
	 */
	public static class Builder extends PipelineAggregationBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<PercentilesBucketAggregation> {
		@Nullable
		private List<Number> percents;

		/**
		 * API name: {@code percents}
		 */
		public Builder percents(@Nullable List<Number> value) {
			this.percents = value;
			return this;
		}

		/**
		 * API name: {@code percents}
		 */
		public Builder percents(Number... value) {
			this.percents = Arrays.asList(value);
			return this;
		}

		/**
		 * Add a value to {@link #percents(List)}, creating the list if needed.
		 */
		public Builder addPercents(Number value) {
			if (this.percents == null) {
				this.percents = new ArrayList<>();
			}
			this.percents.add(value);
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link PercentilesBucketAggregation}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public PercentilesBucketAggregation build() {

			return new PercentilesBucketAggregation(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for PercentilesBucketAggregation
	 */
	public static final JsonpDeserializer<PercentilesBucketAggregation> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, PercentilesBucketAggregation::setupPercentilesBucketAggregationDeserializer);

	protected static void setupPercentilesBucketAggregationDeserializer(
			DelegatingDeserializer<PercentilesBucketAggregation.Builder> op) {
		PipelineAggregationBase.setupPipelineAggregationBaseDeserializer(op);
		op.add(Builder::percents, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.numberDeserializer()),
				"percents");

	}

}
