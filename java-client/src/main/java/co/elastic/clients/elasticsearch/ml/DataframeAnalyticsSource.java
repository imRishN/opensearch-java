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

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package co.elastic.clients.elasticsearch.ml;

import co.elastic.clients.elasticsearch._types.mapping.RuntimeField;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.json.DelegatingDeserializer;
import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.JsonpSerializable;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.util.MapBuilder;
import co.elastic.clients.util.ModelTypeHelper;
import co.elastic.clients.util.ObjectBuilder;
import co.elastic.clients.util.ObjectBuilderBase;
import jakarta.json.JsonValue;
import jakarta.json.stream.JsonGenerator;
import java.lang.String;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: ml._types.DataframeAnalyticsSource
@JsonpDeserializable
public class DataframeAnalyticsSource implements JsonpSerializable {
	private final List<String> index;

	@Nullable
	private final Query query;

	private final Map<String, RuntimeField> runtimeMappings;

	@Nullable
	private final JsonValue /* ml._types.DataframeAnalysisAnalyzedFields */ source;

	// ---------------------------------------------------------------------------------------------

	private DataframeAnalyticsSource(Builder builder) {

		this.index = ModelTypeHelper.unmodifiableRequired(builder.index, this, "index");
		this.query = builder.query;
		this.runtimeMappings = ModelTypeHelper.unmodifiable(builder.runtimeMappings);
		this.source = builder.source;

	}

	public static DataframeAnalyticsSource of(Function<Builder, ObjectBuilder<DataframeAnalyticsSource>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - Index or indices on which to perform the analysis. It can be a
	 * single index or index pattern as well as an array of indices or patterns.
	 * NOTE: If your source indices contain documents with the same IDs, only the
	 * document that is indexed last appears in the destination index.
	 * <p>
	 * API name: {@code index}
	 */
	public final List<String> index() {
		return this.index;
	}

	/**
	 * The Elasticsearch query domain-specific language (DSL). This value
	 * corresponds to the query object in an Elasticsearch search POST body. All the
	 * options that are supported by Elasticsearch can be used, as this object is
	 * passed verbatim to Elasticsearch. By default, this property has the following
	 * value: {&quot;match_all&quot;: {}}.
	 * <p>
	 * API name: {@code query}
	 */
	@Nullable
	public final Query query() {
		return this.query;
	}

	/**
	 * Definitions of runtime fields that will become part of the mapping of the
	 * destination index.
	 * <p>
	 * API name: {@code runtime_mappings}
	 */
	public final Map<String, RuntimeField> runtimeMappings() {
		return this.runtimeMappings;
	}

	/**
	 * Specify <code>includes</code> and/or `excludes patterns to select which
	 * fields will be present in the destination. Fields that are excluded cannot be
	 * included in the analysis.
	 * <p>
	 * API name: {@code _source}
	 */
	@Nullable
	public final JsonValue /* ml._types.DataframeAnalysisAnalyzedFields */ source() {
		return this.source;
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

		if (ModelTypeHelper.isDefined(this.index)) {
			generator.writeKey("index");
			generator.writeStartArray();
			for (String item0 : this.index) {
				generator.write(item0);

			}
			generator.writeEnd();

		}
		if (this.query != null) {
			generator.writeKey("query");
			this.query.serialize(generator, mapper);

		}
		if (ModelTypeHelper.isDefined(this.runtimeMappings)) {
			generator.writeKey("runtime_mappings");
			generator.writeStartObject();
			for (Map.Entry<String, RuntimeField> item0 : this.runtimeMappings.entrySet()) {
				generator.writeKey(item0.getKey());
				item0.getValue().serialize(generator, mapper);

			}
			generator.writeEnd();

		}
		if (this.source != null) {
			generator.writeKey("_source");
			generator.write(this.source);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link DataframeAnalyticsSource}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<DataframeAnalyticsSource> {
		private List<String> index;

		@Nullable
		private Query query;

		@Nullable
		private Map<String, RuntimeField> runtimeMappings;

		@Nullable
		private JsonValue /* ml._types.DataframeAnalysisAnalyzedFields */ source;

		/**
		 * Required - Index or indices on which to perform the analysis. It can be a
		 * single index or index pattern as well as an array of indices or patterns.
		 * NOTE: If your source indices contain documents with the same IDs, only the
		 * document that is indexed last appears in the destination index.
		 * <p>
		 * API name: {@code index}
		 */
		public final Builder index(List<String> value) {
			this.index = value;
			return this;
		}

		/**
		 * Required - Index or indices on which to perform the analysis. It can be a
		 * single index or index pattern as well as an array of indices or patterns.
		 * NOTE: If your source indices contain documents with the same IDs, only the
		 * document that is indexed last appears in the destination index.
		 * <p>
		 * API name: {@code index}
		 */
		public final Builder index(String... value) {
			this.index = Arrays.asList(value);
			return this;
		}

		/**
		 * The Elasticsearch query domain-specific language (DSL). This value
		 * corresponds to the query object in an Elasticsearch search POST body. All the
		 * options that are supported by Elasticsearch can be used, as this object is
		 * passed verbatim to Elasticsearch. By default, this property has the following
		 * value: {&quot;match_all&quot;: {}}.
		 * <p>
		 * API name: {@code query}
		 */
		public final Builder query(@Nullable Query value) {
			this.query = value;
			return this;
		}

		/**
		 * The Elasticsearch query domain-specific language (DSL). This value
		 * corresponds to the query object in an Elasticsearch search POST body. All the
		 * options that are supported by Elasticsearch can be used, as this object is
		 * passed verbatim to Elasticsearch. By default, this property has the following
		 * value: {&quot;match_all&quot;: {}}.
		 * <p>
		 * API name: {@code query}
		 */
		public final Builder query(Function<Query.Builder, ObjectBuilder<Query>> fn) {
			return this.query(fn.apply(new Query.Builder()).build());
		}

		/**
		 * Definitions of runtime fields that will become part of the mapping of the
		 * destination index.
		 * <p>
		 * API name: {@code runtime_mappings}
		 */
		public final Builder runtimeMappings(@Nullable Map<String, RuntimeField> value) {
			this.runtimeMappings = value;
			return this;
		}

		/**
		 * Set {@link #runtimeMappings(Map)} to a singleton map.
		 */
		public Builder runtimeMappings(String key, Function<RuntimeField.Builder, ObjectBuilder<RuntimeField>> fn) {
			return this.runtimeMappings(Collections.singletonMap(key, fn.apply(new RuntimeField.Builder()).build()));
		}

		public final Builder runtimeMappings(
				Function<MapBuilder<String, RuntimeField, RuntimeField.Builder>, ObjectBuilder<Map<String, RuntimeField>>> fn) {
			return runtimeMappings(fn.apply(new MapBuilder<>(RuntimeField.Builder::new)).build());
		}

		/**
		 * Specify <code>includes</code> and/or `excludes patterns to select which
		 * fields will be present in the destination. Fields that are excluded cannot be
		 * included in the analysis.
		 * <p>
		 * API name: {@code _source}
		 */
		public final Builder source(@Nullable JsonValue /* ml._types.DataframeAnalysisAnalyzedFields */ value) {
			this.source = value;
			return this;
		}

		/**
		 * Builds a {@link DataframeAnalyticsSource}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public DataframeAnalyticsSource build() {
			_checkSingleUse();

			return new DataframeAnalyticsSource(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link DataframeAnalyticsSource}
	 */
	public static final JsonpDeserializer<DataframeAnalyticsSource> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, DataframeAnalyticsSource::setupDataframeAnalyticsSourceDeserializer, Builder::build);

	protected static void setupDataframeAnalyticsSourceDeserializer(
			DelegatingDeserializer<DataframeAnalyticsSource.Builder> op) {

		op.add(Builder::index, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "index");
		op.add(Builder::query, Query._DESERIALIZER, "query");
		op.add(Builder::runtimeMappings, JsonpDeserializer.stringMapDeserializer(RuntimeField._DESERIALIZER),
				"runtime_mappings");
		op.add(Builder::source, JsonpDeserializer.jsonValueDeserializer(), "_source");

	}

}