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

package org.opensearch.client.opensearch.cat;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.client.opensearch.cat.thread_pool.ThreadPoolRecord;
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

// typedef: cat.thread_pool.Response
public final class ThreadPoolResponse implements ToJsonp {
	private final List<ThreadPoolRecord> value;

	// ---------------------------------------------------------------------------------------------

	protected ThreadPoolResponse(Builder builder) {

		this.value = Objects.requireNonNull(builder.value, "value");

	}

	/**
	 * Response value.
	 *
	 * API name: {@code value}
	 */
	public List<ThreadPoolRecord> value() {
		return this.value;
	}

	/**
	 * Serialize this value to JSON.
	 */
	public void toJsonp(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartArray();
		for (ThreadPoolRecord item0 : this.value) {
			item0.toJsonp(generator, mapper);

		}
		generator.writeEnd();

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ThreadPoolResponse}.
	 */
	public static class Builder implements ObjectBuilder<ThreadPoolResponse> {
		private List<ThreadPoolRecord> value;

		/**
		 * Response value.
		 *
		 * API name: {@code value}
		 */
		public Builder value(List<ThreadPoolRecord> value) {
			this.value = value;
			return this;
		}

		/**
		 * Response value.
		 *
		 * API name: {@code value}
		 */
		public Builder value(ThreadPoolRecord... value) {
			this.value = Arrays.asList(value);
			return this;
		}

		/**
		 * Add a value to {@link #value(List)}, creating the list if needed.
		 */
		public Builder addValue(ThreadPoolRecord value) {
			if (this.value == null) {
				this.value = new ArrayList<>();
			}
			this.value.add(value);
			return this;
		}

		/**
		 * Set {@link #value(List)} to a singleton list.
		 */
		public Builder value(Function<ThreadPoolRecord.Builder, ObjectBuilder<ThreadPoolRecord>> fn) {
			return this.value(fn.apply(new ThreadPoolRecord.Builder()).build());
		}

		/**
		 * Add a value to {@link #value(List)}, creating the list if needed.
		 */
		public Builder addValue(Function<ThreadPoolRecord.Builder, ObjectBuilder<ThreadPoolRecord>> fn) {
			return this.addValue(fn.apply(new ThreadPoolRecord.Builder()).build());
		}

		/**
		 * Builds a {@link ThreadPoolResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ThreadPoolResponse build() {

			return new ThreadPoolResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for ThreadPoolResponse
	 */
	public static final JsonpDeserializer<ThreadPoolResponse> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, ThreadPoolResponse::setupThreadPoolResponseDeserializer);

	protected static void setupThreadPoolResponseDeserializer(DelegatingDeserializer<ThreadPoolResponse.Builder> op) {

		op.add(Builder::value, JsonpDeserializer.arrayDeserializer(ThreadPoolRecord.DESERIALIZER), "value");

	}

}
