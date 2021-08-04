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
import org.opensearch.clients.json.JsonpSerializable;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.util.ModelTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.lang.Boolean;
import java.util.function.Function;

// typedef: _types.aggregations.ChiSquareHeuristic
@JsonpDeserializable
public class ChiSquareHeuristic implements JsonpSerializable {
	private final boolean backgroundIsSuperset;

	private final boolean includeNegatives;

	// ---------------------------------------------------------------------------------------------

	private ChiSquareHeuristic(Builder builder) {

		this.backgroundIsSuperset = ModelTypeHelper.requireNonNull(builder.backgroundIsSuperset, this,
				"backgroundIsSuperset");
		this.includeNegatives = ModelTypeHelper.requireNonNull(builder.includeNegatives, this, "includeNegatives");

	}

	public static ChiSquareHeuristic of(Function<Builder, ObjectBuilder<ChiSquareHeuristic>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code background_is_superset}
	 */
	public final boolean backgroundIsSuperset() {
		return this.backgroundIsSuperset;
	}

	/**
	 * Required - API name: {@code include_negatives}
	 */
	public final boolean includeNegatives() {
		return this.includeNegatives;
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

		generator.writeKey("background_is_superset");
		generator.write(this.backgroundIsSuperset);

		generator.writeKey("include_negatives");
		generator.write(this.includeNegatives);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ChiSquareHeuristic}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<ChiSquareHeuristic> {
		private Boolean backgroundIsSuperset;

		private Boolean includeNegatives;

		/**
		 * Required - API name: {@code background_is_superset}
		 */
		public final Builder backgroundIsSuperset(boolean value) {
			this.backgroundIsSuperset = value;
			return this;
		}

		/**
		 * Required - API name: {@code include_negatives}
		 */
		public final Builder includeNegatives(boolean value) {
			this.includeNegatives = value;
			return this;
		}

		/**
		 * Builds a {@link ChiSquareHeuristic}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ChiSquareHeuristic build() {
			_checkSingleUse();

			return new ChiSquareHeuristic(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link ChiSquareHeuristic}
	 */
	public static final JsonpDeserializer<ChiSquareHeuristic> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, ChiSquareHeuristic::setupChiSquareHeuristicDeserializer, Builder::build);

	protected static void setupChiSquareHeuristicDeserializer(DelegatingDeserializer<ChiSquareHeuristic.Builder> op) {

		op.add(Builder::backgroundIsSuperset, JsonpDeserializer.booleanDeserializer(), "background_is_superset");
		op.add(Builder::includeNegatives, JsonpDeserializer.booleanDeserializer(), "include_negatives");

	}

}
