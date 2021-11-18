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

package org.opensearch.clients.opensearch.nodes;

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

import java.lang.Long;
import java.lang.String;
import javax.annotation.Nullable;

// typedef: nodes._types.MemoryStats
@JsonpDeserializable
public class MemoryStats implements JsonpSerializable {
	@Nullable
	private final String resident;

	@Nullable
	private final Long residentInBytes;

	@Nullable
	private final String share;

	@Nullable
	private final Long shareInBytes;

	@Nullable
	private final String totalVirtual;

	@Nullable
	private final Long totalVirtualInBytes;

	private final long totalInBytes;

	private final long freeInBytes;

	private final long usedInBytes;

	// ---------------------------------------------------------------------------------------------

	protected MemoryStats(AbstractBuilder<?> builder) {

		this.resident = builder.resident;
		this.residentInBytes = builder.residentInBytes;
		this.share = builder.share;
		this.shareInBytes = builder.shareInBytes;
		this.totalVirtual = builder.totalVirtual;
		this.totalVirtualInBytes = builder.totalVirtualInBytes;
		this.totalInBytes = ModelTypeHelper.requireNonNull(builder.totalInBytes, this, "totalInBytes");
		this.freeInBytes = ModelTypeHelper.requireNonNull(builder.freeInBytes, this, "freeInBytes");
		this.usedInBytes = ModelTypeHelper.requireNonNull(builder.usedInBytes, this, "usedInBytes");

	}

	/**
	 * API name: {@code resident}
	 */
	@Nullable
	public final String resident() {
		return this.resident;
	}

	/**
	 * API name: {@code resident_in_bytes}
	 */
	@Nullable
	public final Long residentInBytes() {
		return this.residentInBytes;
	}

	/**
	 * API name: {@code share}
	 */
	@Nullable
	public final String share() {
		return this.share;
	}

	/**
	 * API name: {@code share_in_bytes}
	 */
	@Nullable
	public final Long shareInBytes() {
		return this.shareInBytes;
	}

	/**
	 * API name: {@code total_virtual}
	 */
	@Nullable
	public final String totalVirtual() {
		return this.totalVirtual;
	}

	/**
	 * API name: {@code total_virtual_in_bytes}
	 */
	@Nullable
	public final Long totalVirtualInBytes() {
		return this.totalVirtualInBytes;
	}

	/**
	 * Required - API name: {@code total_in_bytes}
	 */
	public final long totalInBytes() {
		return this.totalInBytes;
	}

	/**
	 * Required - API name: {@code free_in_bytes}
	 */
	public final long freeInBytes() {
		return this.freeInBytes;
	}

	/**
	 * Required - API name: {@code used_in_bytes}
	 */
	public final long usedInBytes() {
		return this.usedInBytes;
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

		if (this.resident != null) {
			generator.writeKey("resident");
			generator.write(this.resident);

		}
		if (this.residentInBytes != null) {
			generator.writeKey("resident_in_bytes");
			generator.write(this.residentInBytes);

		}
		if (this.share != null) {
			generator.writeKey("share");
			generator.write(this.share);

		}
		if (this.shareInBytes != null) {
			generator.writeKey("share_in_bytes");
			generator.write(this.shareInBytes);

		}
		if (this.totalVirtual != null) {
			generator.writeKey("total_virtual");
			generator.write(this.totalVirtual);

		}
		if (this.totalVirtualInBytes != null) {
			generator.writeKey("total_virtual_in_bytes");
			generator.write(this.totalVirtualInBytes);

		}
		generator.writeKey("total_in_bytes");
		generator.write(this.totalInBytes);

		generator.writeKey("free_in_bytes");
		generator.write(this.freeInBytes);

		generator.writeKey("used_in_bytes");
		generator.write(this.usedInBytes);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link MemoryStats}.
	 */
	public static class Builder extends MemoryStats.AbstractBuilder<Builder> implements ObjectBuilder<MemoryStats> {
		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link MemoryStats}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public MemoryStats build() {
			_checkSingleUse();

			return new MemoryStats(this);
		}
	}

	protected abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>>
			extends
            ObjectBuilderBase {
		@Nullable
		private String resident;

		@Nullable
		private Long residentInBytes;

		@Nullable
		private String share;

		@Nullable
		private Long shareInBytes;

		@Nullable
		private String totalVirtual;

		@Nullable
		private Long totalVirtualInBytes;

		private Long totalInBytes;

		private Long freeInBytes;

		private Long usedInBytes;

		/**
		 * API name: {@code resident}
		 */
		public final BuilderT resident(@Nullable String value) {
			this.resident = value;
			return self();
		}

		/**
		 * API name: {@code resident_in_bytes}
		 */
		public final BuilderT residentInBytes(@Nullable Long value) {
			this.residentInBytes = value;
			return self();
		}

		/**
		 * API name: {@code share}
		 */
		public final BuilderT share(@Nullable String value) {
			this.share = value;
			return self();
		}

		/**
		 * API name: {@code share_in_bytes}
		 */
		public final BuilderT shareInBytes(@Nullable Long value) {
			this.shareInBytes = value;
			return self();
		}

		/**
		 * API name: {@code total_virtual}
		 */
		public final BuilderT totalVirtual(@Nullable String value) {
			this.totalVirtual = value;
			return self();
		}

		/**
		 * API name: {@code total_virtual_in_bytes}
		 */
		public final BuilderT totalVirtualInBytes(@Nullable Long value) {
			this.totalVirtualInBytes = value;
			return self();
		}

		/**
		 * Required - API name: {@code total_in_bytes}
		 */
		public final BuilderT totalInBytes(long value) {
			this.totalInBytes = value;
			return self();
		}

		/**
		 * Required - API name: {@code free_in_bytes}
		 */
		public final BuilderT freeInBytes(long value) {
			this.freeInBytes = value;
			return self();
		}

		/**
		 * Required - API name: {@code used_in_bytes}
		 */
		public final BuilderT usedInBytes(long value) {
			this.usedInBytes = value;
			return self();
		}

		protected abstract BuilderT self();

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link MemoryStats}
	 */
	public static final JsonpDeserializer<MemoryStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			MemoryStats::setupMemoryStatsDeserializer, Builder::build);

	protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupMemoryStatsDeserializer(
			DelegatingDeserializer<BuilderT> op) {

		op.add(AbstractBuilder::resident, JsonpDeserializer.stringDeserializer(), "resident");
		op.add(AbstractBuilder::residentInBytes, JsonpDeserializer.longDeserializer(), "resident_in_bytes");
		op.add(AbstractBuilder::share, JsonpDeserializer.stringDeserializer(), "share");
		op.add(AbstractBuilder::shareInBytes, JsonpDeserializer.longDeserializer(), "share_in_bytes");
		op.add(AbstractBuilder::totalVirtual, JsonpDeserializer.stringDeserializer(), "total_virtual");
		op.add(AbstractBuilder::totalVirtualInBytes, JsonpDeserializer.longDeserializer(), "total_virtual_in_bytes");
		op.add(AbstractBuilder::totalInBytes, JsonpDeserializer.longDeserializer(), "total_in_bytes");
		op.add(AbstractBuilder::freeInBytes, JsonpDeserializer.longDeserializer(), "free_in_bytes");
		op.add(AbstractBuilder::usedInBytes, JsonpDeserializer.longDeserializer(), "used_in_bytes");

	}

}