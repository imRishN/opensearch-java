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

package org.opensearch.client.opensearch.nodes.info;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ToJsonp;
import org.opensearch.client.util.ObjectBuilder;

import java.util.Objects;

// typedef: nodes.info.NodeInfoScript
public final class NodeInfoScript implements ToJsonp {
	private final String allowedTypes;

	private final String disableMaxCompilationsRate;

	// ---------------------------------------------------------------------------------------------

	protected NodeInfoScript(Builder builder) {

		this.allowedTypes = Objects.requireNonNull(builder.allowedTypes, "allowed_types");
		this.disableMaxCompilationsRate = Objects.requireNonNull(builder.disableMaxCompilationsRate,
				"disable_max_compilations_rate");

	}

	/**
	 * API name: {@code allowed_types}
	 */
	public String allowedTypes() {
		return this.allowedTypes;
	}

	/**
	 * API name: {@code disable_max_compilations_rate}
	 */
	public String disableMaxCompilationsRate() {
		return this.disableMaxCompilationsRate;
	}

	/**
	 * Serialize this object to JSON.
	 */
	public void toJsonp(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartObject();
		toJsonpInternal(generator, mapper);
		generator.writeEnd();
	}

	protected void toJsonpInternal(JsonGenerator generator, JsonpMapper mapper) {

		generator.writeKey("allowed_types");
		generator.write(this.allowedTypes);

		generator.writeKey("disable_max_compilations_rate");
		generator.write(this.disableMaxCompilationsRate);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link NodeInfoScript}.
	 */
	public static class Builder implements ObjectBuilder<NodeInfoScript> {
		private String allowedTypes;

		private String disableMaxCompilationsRate;

		/**
		 * API name: {@code allowed_types}
		 */
		public Builder allowedTypes(String value) {
			this.allowedTypes = value;
			return this;
		}

		/**
		 * API name: {@code disable_max_compilations_rate}
		 */
		public Builder disableMaxCompilationsRate(String value) {
			this.disableMaxCompilationsRate = value;
			return this;
		}

		/**
		 * Builds a {@link NodeInfoScript}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public NodeInfoScript build() {

			return new NodeInfoScript(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for NodeInfoScript
	 */
	public static final JsonpDeserializer<NodeInfoScript> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, NodeInfoScript::setupNodeInfoScriptDeserializer);

	protected static void setupNodeInfoScriptDeserializer(DelegatingDeserializer<NodeInfoScript.Builder> op) {

		op.add(Builder::allowedTypes, JsonpDeserializer.stringDeserializer(), "allowed_types");
		op.add(Builder::disableMaxCompilationsRate, JsonpDeserializer.stringDeserializer(),
				"disable_max_compilations_rate");

	}

}
