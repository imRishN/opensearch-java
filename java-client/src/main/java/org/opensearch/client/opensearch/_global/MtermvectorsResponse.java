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

package org.opensearch.client.opensearch._global;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.client.opensearch._global.mtermvectors.TermVectorsResult;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ToJsonp;
import org.opensearch.client.util.ObjectBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

// typedef: _global.mtermvectors.Response
public final class MtermvectorsResponse implements ToJsonp {
	private final List<TermVectorsResult> docs;

	// ---------------------------------------------------------------------------------------------

	protected MtermvectorsResponse(Builder builder) {

		this.docs = Objects.requireNonNull(builder.docs, "docs");

	}

	/**
	 * API name: {@code docs}
	 */
	public List<TermVectorsResult> docs() {
		return this.docs;
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

		generator.writeKey("docs");
		generator.writeStartArray();
		for (TermVectorsResult item0 : this.docs) {
			item0.toJsonp(generator, mapper);

		}
		generator.writeEnd();

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link MtermvectorsResponse}.
	 */
	public static class Builder implements ObjectBuilder<MtermvectorsResponse> {
		private List<TermVectorsResult> docs;

		/**
		 * API name: {@code docs}
		 */
		public Builder docs(List<TermVectorsResult> value) {
			this.docs = value;
			return this;
		}

		/**
		 * API name: {@code docs}
		 */
		public Builder docs(TermVectorsResult... value) {
			this.docs = Arrays.asList(value);
			return this;
		}

		/**
		 * Add a value to {@link #docs(List)}, creating the list if needed.
		 */
		public Builder addDocs(TermVectorsResult value) {
			if (this.docs == null) {
				this.docs = new ArrayList<>();
			}
			this.docs.add(value);
			return this;
		}

		/**
		 * Set {@link #docs(List)} to a singleton list.
		 */
		public Builder docs(Function<TermVectorsResult.Builder, ObjectBuilder<TermVectorsResult>> fn) {
			return this.docs(fn.apply(new TermVectorsResult.Builder()).build());
		}

		/**
		 * Add a value to {@link #docs(List)}, creating the list if needed.
		 */
		public Builder addDocs(Function<TermVectorsResult.Builder, ObjectBuilder<TermVectorsResult>> fn) {
			return this.addDocs(fn.apply(new TermVectorsResult.Builder()).build());
		}

		/**
		 * Builds a {@link MtermvectorsResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public MtermvectorsResponse build() {

			return new MtermvectorsResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for MtermvectorsResponse
	 */
	public static final JsonpDeserializer<MtermvectorsResponse> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, MtermvectorsResponse::setupMtermvectorsResponseDeserializer);

	protected static void setupMtermvectorsResponseDeserializer(
			DelegatingDeserializer<MtermvectorsResponse.Builder> op) {

		op.add(Builder::docs, JsonpDeserializer.arrayDeserializer(TermVectorsResult.DESERIALIZER), "docs");

	}

}
