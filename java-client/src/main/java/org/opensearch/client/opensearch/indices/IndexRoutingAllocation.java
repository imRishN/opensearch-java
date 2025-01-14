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

package org.opensearch.client.opensearch.indices;

import jakarta.json.JsonValue;
import jakarta.json.stream.JsonGenerator;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ToJsonp;
import org.opensearch.client.util.ObjectBuilder;

import javax.annotation.Nullable;
import java.util.function.Function;

// typedef: indices._types.IndexRoutingAllocation
public final class IndexRoutingAllocation implements ToJsonp {
	@Nullable
	private final JsonValue enable;

	@Nullable
	private final IndexRoutingAllocationInclude include;

	@Nullable
	private final IndexRoutingAllocationInitialRecovery initialRecovery;

	@Nullable
	private final IndexRoutingAllocationDisk disk;

	// ---------------------------------------------------------------------------------------------

	protected IndexRoutingAllocation(Builder builder) {

		this.enable = builder.enable;
		this.include = builder.include;
		this.initialRecovery = builder.initialRecovery;
		this.disk = builder.disk;

	}

	/**
	 * API name: {@code enable}
	 */
	@Nullable
	public JsonValue enable() {
		return this.enable;
	}

	/**
	 * API name: {@code include}
	 */
	@Nullable
	public IndexRoutingAllocationInclude include() {
		return this.include;
	}

	/**
	 * API name: {@code initial_recovery}
	 */
	@Nullable
	public IndexRoutingAllocationInitialRecovery initialRecovery() {
		return this.initialRecovery;
	}

	/**
	 * API name: {@code disk}
	 */
	@Nullable
	public IndexRoutingAllocationDisk disk() {
		return this.disk;
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

		if (this.enable != null) {

			generator.writeKey("enable");
			generator.write(this.enable);

		}
		if (this.include != null) {

			generator.writeKey("include");
			this.include.toJsonp(generator, mapper);

		}
		if (this.initialRecovery != null) {

			generator.writeKey("initial_recovery");
			this.initialRecovery.toJsonp(generator, mapper);

		}
		if (this.disk != null) {

			generator.writeKey("disk");
			this.disk.toJsonp(generator, mapper);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link IndexRoutingAllocation}.
	 */
	public static class Builder implements ObjectBuilder<IndexRoutingAllocation> {
		@Nullable
		private JsonValue enable;

		@Nullable
		private IndexRoutingAllocationInclude include;

		@Nullable
		private IndexRoutingAllocationInitialRecovery initialRecovery;

		@Nullable
		private IndexRoutingAllocationDisk disk;

		/**
		 * API name: {@code enable}
		 */
		public Builder enable(@Nullable JsonValue value) {
			this.enable = value;
			return this;
		}

		/**
		 * API name: {@code include}
		 */
		public Builder include(@Nullable IndexRoutingAllocationInclude value) {
			this.include = value;
			return this;
		}

		/**
		 * API name: {@code include}
		 */
		public Builder include(
				Function<IndexRoutingAllocationInclude.Builder, ObjectBuilder<IndexRoutingAllocationInclude>> fn) {
			return this.include(fn.apply(new IndexRoutingAllocationInclude.Builder()).build());
		}

		/**
		 * API name: {@code initial_recovery}
		 */
		public Builder initialRecovery(@Nullable IndexRoutingAllocationInitialRecovery value) {
			this.initialRecovery = value;
			return this;
		}

		/**
		 * API name: {@code initial_recovery}
		 */
		public Builder initialRecovery(
				Function<IndexRoutingAllocationInitialRecovery.Builder, ObjectBuilder<IndexRoutingAllocationInitialRecovery>> fn) {
			return this.initialRecovery(fn.apply(new IndexRoutingAllocationInitialRecovery.Builder()).build());
		}

		/**
		 * API name: {@code disk}
		 */
		public Builder disk(@Nullable IndexRoutingAllocationDisk value) {
			this.disk = value;
			return this;
		}

		/**
		 * API name: {@code disk}
		 */
		public Builder disk(
				Function<IndexRoutingAllocationDisk.Builder, ObjectBuilder<IndexRoutingAllocationDisk>> fn) {
			return this.disk(fn.apply(new IndexRoutingAllocationDisk.Builder()).build());
		}

		/**
		 * Builds a {@link IndexRoutingAllocation}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public IndexRoutingAllocation build() {

			return new IndexRoutingAllocation(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for IndexRoutingAllocation
	 */
	public static final JsonpDeserializer<IndexRoutingAllocation> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, IndexRoutingAllocation::setupIndexRoutingAllocationDeserializer);

	protected static void setupIndexRoutingAllocationDeserializer(
			DelegatingDeserializer<IndexRoutingAllocation.Builder> op) {

		op.add(Builder::enable, JsonpDeserializer.jsonValueDeserializer(), "enable");
		op.add(Builder::include, IndexRoutingAllocationInclude.DESERIALIZER, "include");
		op.add(Builder::initialRecovery, IndexRoutingAllocationInitialRecovery.DESERIALIZER, "initial_recovery");
		op.add(Builder::disk, IndexRoutingAllocationDisk.DESERIALIZER, "disk");

	}

}
