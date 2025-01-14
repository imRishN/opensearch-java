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

import jakarta.json.stream.JsonGenerator;
import org.opensearch.client.opensearch.indices.resolve_index.ResolveIndexAliasItem;
import org.opensearch.client.opensearch.indices.resolve_index.ResolveIndexItem;
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

// typedef: indices.resolve_index.Response
public final class ResolveIndexResponse implements ToJsonp {
	private final List<ResolveIndexItem> indices;

	private final List<ResolveIndexAliasItem> aliases;

	// ---------------------------------------------------------------------------------------------

	protected ResolveIndexResponse(Builder builder) {

		this.indices = Objects.requireNonNull(builder.indices, "indices");
		this.aliases = Objects.requireNonNull(builder.aliases, "aliases");

	}

	/**
	 * API name: {@code indices}
	 */
	public List<ResolveIndexItem> indices() {
		return this.indices;
	}

	/**
	 * API name: {@code aliases}
	 */
	public List<ResolveIndexAliasItem> aliases() {
		return this.aliases;
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

		generator.writeKey("indices");
		generator.writeStartArray();
		for (ResolveIndexItem item0 : this.indices) {
			item0.toJsonp(generator, mapper);

		}
		generator.writeEnd();

		generator.writeKey("aliases");
		generator.writeStartArray();
		for (ResolveIndexAliasItem item0 : this.aliases) {
			item0.toJsonp(generator, mapper);

		}
		generator.writeEnd();

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ResolveIndexResponse}.
	 */
	public static class Builder implements ObjectBuilder<ResolveIndexResponse> {
		private List<ResolveIndexItem> indices;

		private List<ResolveIndexAliasItem> aliases;

		/**
		 * API name: {@code indices}
		 */
		public Builder indices(List<ResolveIndexItem> value) {
			this.indices = value;
			return this;
		}

		/**
		 * API name: {@code indices}
		 */
		public Builder indices(ResolveIndexItem... value) {
			this.indices = Arrays.asList(value);
			return this;
		}

		/**
		 * Add a value to {@link #indices(List)}, creating the list if needed.
		 */
		public Builder addIndices(ResolveIndexItem value) {
			if (this.indices == null) {
				this.indices = new ArrayList<>();
			}
			this.indices.add(value);
			return this;
		}

		/**
		 * Set {@link #indices(List)} to a singleton list.
		 */
		public Builder indices(Function<ResolveIndexItem.Builder, ObjectBuilder<ResolveIndexItem>> fn) {
			return this.indices(fn.apply(new ResolveIndexItem.Builder()).build());
		}

		/**
		 * Add a value to {@link #indices(List)}, creating the list if needed.
		 */
		public Builder addIndices(Function<ResolveIndexItem.Builder, ObjectBuilder<ResolveIndexItem>> fn) {
			return this.addIndices(fn.apply(new ResolveIndexItem.Builder()).build());
		}

		/**
		 * API name: {@code aliases}
		 */
		public Builder aliases(List<ResolveIndexAliasItem> value) {
			this.aliases = value;
			return this;
		}

		/**
		 * API name: {@code aliases}
		 */
		public Builder aliases(ResolveIndexAliasItem... value) {
			this.aliases = Arrays.asList(value);
			return this;
		}

		/**
		 * Add a value to {@link #aliases(List)}, creating the list if needed.
		 */
		public Builder addAliases(ResolveIndexAliasItem value) {
			if (this.aliases == null) {
				this.aliases = new ArrayList<>();
			}
			this.aliases.add(value);
			return this;
		}

		/**
		 * Set {@link #aliases(List)} to a singleton list.
		 */
		public Builder aliases(Function<ResolveIndexAliasItem.Builder, ObjectBuilder<ResolveIndexAliasItem>> fn) {
			return this.aliases(fn.apply(new ResolveIndexAliasItem.Builder()).build());
		}

		/**
		 * Add a value to {@link #aliases(List)}, creating the list if needed.
		 */
		public Builder addAliases(Function<ResolveIndexAliasItem.Builder, ObjectBuilder<ResolveIndexAliasItem>> fn) {
			return this.addAliases(fn.apply(new ResolveIndexAliasItem.Builder()).build());
		}

		/**
		 * Builds a {@link ResolveIndexResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ResolveIndexResponse build() {

			return new ResolveIndexResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for ResolveIndexResponse
	 */
	public static final JsonpDeserializer<ResolveIndexResponse> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, ResolveIndexResponse::setupResolveIndexResponseDeserializer);

	protected static void setupResolveIndexResponseDeserializer(
			DelegatingDeserializer<ResolveIndexResponse.Builder> op) {

		op.add(Builder::indices, JsonpDeserializer.arrayDeserializer(ResolveIndexItem.DESERIALIZER), "indices");
		op.add(Builder::aliases, JsonpDeserializer.arrayDeserializer(ResolveIndexAliasItem.DESERIALIZER), "aliases");

	}

}
