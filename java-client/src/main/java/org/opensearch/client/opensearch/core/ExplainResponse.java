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

package org.opensearch.client.opensearch.core;

import org.opensearch.client.opensearch._types.InlineGet;
import org.opensearch.client.opensearch.core.explain.ExplanationDetail;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.JsonpSerializer;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.util.ModelTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;

import java.lang.Boolean;
import java.lang.String;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.annotation.Nullable;

// typedef: _global.explain.Response

public class ExplainResponse<TDocument> implements JsonpSerializable {
	private final String index;

	@Nullable
	private final String type;

	private final String id;

	private final boolean matched;

	@Nullable
	private final ExplanationDetail explanation;

	@Nullable
	private final InlineGet<TDocument> get;

	@Nullable
	private final JsonpSerializer<TDocument> tDocumentSerializer;

	// ---------------------------------------------------------------------------------------------

	private ExplainResponse(Builder<TDocument> builder) {

		this.index = ModelTypeHelper.requireNonNull(builder.index, this, "index");
		this.type = builder.type;
		this.id = ModelTypeHelper.requireNonNull(builder.id, this, "id");
		this.matched = ModelTypeHelper.requireNonNull(builder.matched, this, "matched");
		this.explanation = builder.explanation;
		this.get = builder.get;
		this.tDocumentSerializer = builder.tDocumentSerializer;

	}

	public static <TDocument> ExplainResponse<TDocument> of(
			Function<Builder<TDocument>, ObjectBuilder<ExplainResponse<TDocument>>> fn) {
		return fn.apply(new Builder<>()).build();
	}

	/**
	 * Required - API name: {@code _index}
	 */
	public final String index() {
		return this.index;
	}

	/**
	 * API name: {@code _type}
	 */
	@Nullable
	public final String type() {
		return this.type;
	}

	/**
	 * Required - API name: {@code _id}
	 */
	public final String id() {
		return this.id;
	}

	/**
	 * Required - API name: {@code matched}
	 */
	public final boolean matched() {
		return this.matched;
	}

	/**
	 * API name: {@code explanation}
	 */
	@Nullable
	public final ExplanationDetail explanation() {
		return this.explanation;
	}

	/**
	 * API name: {@code get}
	 */
	@Nullable
	public final InlineGet<TDocument> get() {
		return this.get;
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

		generator.writeKey("_index");
		generator.write(this.index);

		if (this.type != null) {
			generator.writeKey("_type");
			generator.write(this.type);

		}
		generator.writeKey("_id");
		generator.write(this.id);

		generator.writeKey("matched");
		generator.write(this.matched);

		if (this.explanation != null) {
			generator.writeKey("explanation");
			this.explanation.serialize(generator, mapper);

		}
		if (this.get != null) {
			generator.writeKey("get");
			this.get.serialize(generator, mapper);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ExplainResponse}.
	 */
	public static class Builder<TDocument> extends ObjectBuilderBase
			implements
				ObjectBuilder<ExplainResponse<TDocument>> {
		private String index;

		@Nullable
		private String type;

		private String id;

		private Boolean matched;

		@Nullable
		private ExplanationDetail explanation;

		@Nullable
		private InlineGet<TDocument> get;

		@Nullable
		private JsonpSerializer<TDocument> tDocumentSerializer;

		/**
		 * Required - API name: {@code _index}
		 */
		public final Builder<TDocument> index(String value) {
			this.index = value;
			return this;
		}

		/**
		 * API name: {@code _type}
		 */
		public final Builder<TDocument> type(@Nullable String value) {
			this.type = value;
			return this;
		}

		/**
		 * Required - API name: {@code _id}
		 */
		public final Builder<TDocument> id(String value) {
			this.id = value;
			return this;
		}

		/**
		 * Required - API name: {@code matched}
		 */
		public final Builder<TDocument> matched(boolean value) {
			this.matched = value;
			return this;
		}

		/**
		 * API name: {@code explanation}
		 */
		public final Builder<TDocument> explanation(@Nullable ExplanationDetail value) {
			this.explanation = value;
			return this;
		}

		/**
		 * API name: {@code explanation}
		 */
		public final Builder<TDocument> explanation(
				Function<ExplanationDetail.Builder, ObjectBuilder<ExplanationDetail>> fn) {
			return this.explanation(fn.apply(new ExplanationDetail.Builder()).build());
		}

		/**
		 * API name: {@code get}
		 */
		public final Builder<TDocument> get(@Nullable InlineGet<TDocument> value) {
			this.get = value;
			return this;
		}

		/**
		 * API name: {@code get}
		 */
		public final Builder<TDocument> get(
				Function<InlineGet.Builder<TDocument>, ObjectBuilder<InlineGet<TDocument>>> fn) {
			return this.get(fn.apply(new InlineGet.Builder<TDocument>()).build());
		}

		/**
		 * Serializer for TDocument. If not set, an attempt will be made to find a
		 * serializer from the JSON context.
		 */
		public final Builder<TDocument> tDocumentSerializer(@Nullable JsonpSerializer<TDocument> value) {
			this.tDocumentSerializer = value;
			return this;
		}

		/**
		 * Builds a {@link ExplainResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ExplainResponse<TDocument> build() {
			_checkSingleUse();

			return new ExplainResponse<TDocument>(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Create a json deserializer for ExplainResponse
	 */
	public static <TDocument> JsonpDeserializer<ExplainResponse<TDocument>> createExplainResponseDeserializer(
			JsonpDeserializer<TDocument> tDocumentDeserializer) {
		return ObjectBuilderDeserializer.createForObject((Supplier<Builder<TDocument>>) Builder::new,
				op -> ExplainResponse.setupExplainResponseDeserializer(op, tDocumentDeserializer));
	};

	protected static <TDocument> void setupExplainResponseDeserializer(
			DelegatingDeserializer<ExplainResponse.Builder<TDocument>> op,
			JsonpDeserializer<TDocument> tDocumentDeserializer) {

		op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "_index");
		op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "_type");
		op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "_id");
		op.add(Builder::matched, JsonpDeserializer.booleanDeserializer(), "matched");
		op.add(Builder::explanation, ExplanationDetail._DESERIALIZER, "explanation");
		op.add(Builder::get, InlineGet.createInlineGetDeserializer(tDocumentDeserializer), "get");

	}

}
