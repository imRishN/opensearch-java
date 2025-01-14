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

package org.opensearch.client.opensearch._types.query_dsl;

import jakarta.json.JsonValue;
import jakarta.json.stream.JsonGenerator;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.util.ObjectBuilder;

import java.util.Objects;

// typedef: _types.query_dsl.ScriptScoreFunction
public final class ScriptScoreFunction extends ScoreFunctionBase {
	private final JsonValue script;

	// ---------------------------------------------------------------------------------------------

	protected ScriptScoreFunction(Builder builder) {
		super(builder);
		this.script = Objects.requireNonNull(builder.script, "script");

	}

	/**
	 * API name: {@code script}
	 */
	public JsonValue script() {
		return this.script;
	}

	protected void toJsonpInternal(JsonGenerator generator, JsonpMapper mapper) {
		super.toJsonpInternal(generator, mapper);

		generator.writeKey("script");
		generator.write(this.script);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ScriptScoreFunction}.
	 */
	public static class Builder extends ScoreFunctionBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<ScriptScoreFunction> {
		private JsonValue script;

		/**
		 * API name: {@code script}
		 */
		public Builder script(JsonValue value) {
			this.script = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link ScriptScoreFunction}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ScriptScoreFunction build() {

			return new ScriptScoreFunction(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for ScriptScoreFunction
	 */
	public static final JsonpDeserializer<ScriptScoreFunction> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, ScriptScoreFunction::setupScriptScoreFunctionDeserializer);

	protected static void setupScriptScoreFunctionDeserializer(DelegatingDeserializer<ScriptScoreFunction.Builder> op) {
		ScoreFunctionBase.setupScoreFunctionBaseDeserializer(op);
		op.add(Builder::script, JsonpDeserializer.jsonValueDeserializer(), "script");

	}

}
