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

package org.opensearch.clients.elasticsearch._types.aggregations;

import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ObjectDeserializer;
import jakarta.json.stream.JsonGenerator;
import javax.annotation.Nullable;

// typedef: _types.aggregations.FormatMetricAggregationBase

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/_types/aggregations/metric.ts#L40-L42">API
 *      specification</a>
 */

public abstract class FormatMetricAggregationBase extends MetricAggregationBase {
	@Nullable
	private final String format;

	// ---------------------------------------------------------------------------------------------

	protected FormatMetricAggregationBase(AbstractBuilder<?> builder) {
		super(builder);

		this.format = builder.format;

	}

	/**
	 * API name: {@code format}
	 */
	@Nullable
	public final String format() {
		return this.format;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		super.serializeInternal(generator, mapper);
		if (this.format != null) {
			generator.writeKey("format");
			generator.write(this.format);

		}

	}

	protected abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>>
			extends
				MetricAggregationBase.AbstractBuilder<BuilderT> {
		@Nullable
		private String format;

		/**
		 * API name: {@code format}
		 */
		public final BuilderT format(@Nullable String value) {
			this.format = value;
			return self();
		}

	}

	// ---------------------------------------------------------------------------------------------
	protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupFormatMetricAggregationBaseDeserializer(
			ObjectDeserializer<BuilderT> op) {
		MetricAggregationBase.setupMetricAggregationBaseDeserializer(op);
		op.add(AbstractBuilder::format, JsonpDeserializer.stringDeserializer(), "format");

	}

}
