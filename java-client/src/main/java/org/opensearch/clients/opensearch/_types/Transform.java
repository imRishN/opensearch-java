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

package org.opensearch.clients.opensearch._types;

import org.opensearch.clients.json.JsonEnum;
import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.JsonpSerializable;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ObjectDeserializer;
import org.opensearch.clients.util.ApiTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;
import org.opensearch.clients.util.TaggedUnion;
import org.opensearch.clients.util.TaggedUnionUtils;
import jakarta.json.stream.JsonGenerator;
import java.lang.Object;
import java.util.function.Function;

// typedef: _types.TransformContainer

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/_types/Transform.ts#L27-L34">API
 *      specification</a>
 */
@JsonpDeserializable
public class Transform implements TaggedUnion<Transform.Kind, Object>, JsonpSerializable {

	/**
	 * {@link Transform} variant kinds.
	 */
	/**
	 * {@link Transform} variant kinds.
	 */

	public enum Kind implements JsonEnum {
		Chain("chain"),

		Script("script"),

		Search("search"),

		;

		private final String jsonValue;

		Kind(String jsonValue) {
			this.jsonValue = jsonValue;
		}

		public String jsonValue() {
			return this.jsonValue;
		}

	}

	private final Kind _kind;
	private final Object _value;

	@Override
	public final Kind _kind() {
		return _kind;
	}

	@Override
	public final Object _get() {
		return _value;
	}

	public Transform(TransformVariant value) {

		this._kind = ApiTypeHelper.requireNonNull(value._transformKind(), this, "<variant kind>");
		this._value = ApiTypeHelper.requireNonNull(value, this, "<variant value>");

	}

	private Transform(Builder builder) {

		this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
		this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");

	}

	public static Transform of(Function<Builder, ObjectBuilder<Transform>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Is this variant instance of kind {@code chain}?
	 */
	public boolean isChain() {
		return _kind == Kind.Chain;
	}

	/**
	 * Get the {@code chain} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the {@code chain} kind.
	 */
	public ChainTransform chain() {
		return TaggedUnionUtils.get(this, Kind.Chain);
	}

	/**
	 * Is this variant instance of kind {@code script}?
	 */
	public boolean isScript() {
		return _kind == Kind.Script;
	}

	/**
	 * Get the {@code script} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the {@code script} kind.
	 */
	public ScriptTransform script() {
		return TaggedUnionUtils.get(this, Kind.Script);
	}

	/**
	 * Is this variant instance of kind {@code search}?
	 */
	public boolean isSearch() {
		return _kind == Kind.Search;
	}

	/**
	 * Get the {@code search} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the {@code search} kind.
	 */
	public SearchTransform search() {
		return TaggedUnionUtils.get(this, Kind.Search);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {

		generator.writeStartObject();

		generator.writeKey(_kind.jsonValue());
		if (_value instanceof JsonpSerializable) {
			((JsonpSerializable) _value).serialize(generator, mapper);
		}

		generator.writeEnd();

	}

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<Transform> {
		private Kind _kind;
		private Object _value;

		public ObjectBuilder<Transform> chain(ChainTransform v) {
			this._kind = Kind.Chain;
			this._value = v;
			return this;
		}

		public ObjectBuilder<Transform> chain(Function<ChainTransform.Builder, ObjectBuilder<ChainTransform>> fn) {
			return this.chain(fn.apply(new ChainTransform.Builder()).build());
		}

		public ObjectBuilder<Transform> script(ScriptTransform v) {
			this._kind = Kind.Script;
			this._value = v;
			return this;
		}

		public ObjectBuilder<Transform> script(Function<ScriptTransform.Builder, ObjectBuilder<ScriptTransform>> fn) {
			return this.script(fn.apply(new ScriptTransform.Builder()).build());
		}

		public ObjectBuilder<Transform> search(SearchTransform v) {
			this._kind = Kind.Search;
			this._value = v;
			return this;
		}

		public ObjectBuilder<Transform> search(Function<SearchTransform.Builder, ObjectBuilder<SearchTransform>> fn) {
			return this.search(fn.apply(new SearchTransform.Builder()).build());
		}

		public Transform build() {
			_checkSingleUse();
			return new Transform(this);
		}

	}

	protected static void setupTransformDeserializer(ObjectDeserializer<Builder> op) {

		op.add(Builder::chain, ChainTransform._DESERIALIZER, "chain");
		op.add(Builder::script, ScriptTransform._DESERIALIZER, "script");
		op.add(Builder::search, SearchTransform._DESERIALIZER, "search");

	}

	public static final JsonpDeserializer<Transform> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			Transform::setupTransformDeserializer, Builder::build);
}