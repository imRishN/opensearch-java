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

package org.opensearch.client.opensearch.ingest;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.util.ObjectBuilder;

import javax.annotation.Nullable;
import java.util.Objects;

// typedef: ingest._types.GsubProcessor
public final class GsubProcessor extends ProcessorBase {
	private final String field;

	@Nullable
	private final Boolean ignoreMissing;

	private final String pattern;

	private final String replacement;

	@Nullable
	private final String targetField;

	// ---------------------------------------------------------------------------------------------

	protected GsubProcessor(Builder builder) {
		super(builder);
		this.field = Objects.requireNonNull(builder.field, "field");
		this.ignoreMissing = builder.ignoreMissing;
		this.pattern = Objects.requireNonNull(builder.pattern, "pattern");
		this.replacement = Objects.requireNonNull(builder.replacement, "replacement");
		this.targetField = builder.targetField;

	}

	/**
	 * API name: {@code field}
	 */
	public String field() {
		return this.field;
	}

	/**
	 * API name: {@code ignore_missing}
	 */
	@Nullable
	public Boolean ignoreMissing() {
		return this.ignoreMissing;
	}

	/**
	 * API name: {@code pattern}
	 */
	public String pattern() {
		return this.pattern;
	}

	/**
	 * API name: {@code replacement}
	 */
	public String replacement() {
		return this.replacement;
	}

	/**
	 * API name: {@code target_field}
	 */
	@Nullable
	public String targetField() {
		return this.targetField;
	}

	protected void toJsonpInternal(JsonGenerator generator, JsonpMapper mapper) {
		super.toJsonpInternal(generator, mapper);

		generator.writeKey("field");
		generator.write(this.field);

		if (this.ignoreMissing != null) {

			generator.writeKey("ignore_missing");
			generator.write(this.ignoreMissing);

		}

		generator.writeKey("pattern");
		generator.write(this.pattern);

		generator.writeKey("replacement");
		generator.write(this.replacement);

		if (this.targetField != null) {

			generator.writeKey("target_field");
			generator.write(this.targetField);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link GsubProcessor}.
	 */
	public static class Builder extends ProcessorBase.AbstractBuilder<Builder> implements ObjectBuilder<GsubProcessor> {
		private String field;

		@Nullable
		private Boolean ignoreMissing;

		private String pattern;

		private String replacement;

		@Nullable
		private String targetField;

		/**
		 * API name: {@code field}
		 */
		public Builder field(String value) {
			this.field = value;
			return this;
		}

		/**
		 * API name: {@code ignore_missing}
		 */
		public Builder ignoreMissing(@Nullable Boolean value) {
			this.ignoreMissing = value;
			return this;
		}

		/**
		 * API name: {@code pattern}
		 */
		public Builder pattern(String value) {
			this.pattern = value;
			return this;
		}

		/**
		 * API name: {@code replacement}
		 */
		public Builder replacement(String value) {
			this.replacement = value;
			return this;
		}

		/**
		 * API name: {@code target_field}
		 */
		public Builder targetField(@Nullable String value) {
			this.targetField = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link GsubProcessor}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public GsubProcessor build() {

			return new GsubProcessor(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for GsubProcessor
	 */
	public static final JsonpDeserializer<GsubProcessor> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, GsubProcessor::setupGsubProcessorDeserializer);

	protected static void setupGsubProcessorDeserializer(DelegatingDeserializer<GsubProcessor.Builder> op) {
		ProcessorBase.setupProcessorBaseDeserializer(op);
		op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
		op.add(Builder::ignoreMissing, JsonpDeserializer.booleanDeserializer(), "ignore_missing");
		op.add(Builder::pattern, JsonpDeserializer.stringDeserializer(), "pattern");
		op.add(Builder::replacement, JsonpDeserializer.stringDeserializer(), "replacement");
		op.add(Builder::targetField, JsonpDeserializer.stringDeserializer(), "target_field");

	}

}
