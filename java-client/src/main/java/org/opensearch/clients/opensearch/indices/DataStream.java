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

package org.opensearch.clients.opensearch.indices;

import org.opensearch.clients.json.JsonpDeserializable;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.JsonpSerializable;
import org.opensearch.clients.json.ObjectBuilderDeserializer;
import org.opensearch.clients.json.ObjectDeserializer;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.lang.Boolean;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: indices._types.DataStream

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/indices/_types/DataStream.ts#L20-L22">API
 *      specification</a>
 */
@JsonpDeserializable
public class DataStream implements JsonpSerializable {
	@Nullable
	private final Boolean hidden;

	// ---------------------------------------------------------------------------------------------

	private DataStream(Builder builder) {

		this.hidden = builder.hidden;

	}

	public static DataStream of(Function<Builder, ObjectBuilder<DataStream>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * API name: {@code hidden}
	 */
	@Nullable
	public final Boolean hidden() {
		return this.hidden;
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

		if (this.hidden != null) {
			generator.writeKey("hidden");
			generator.write(this.hidden);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link DataStream}.
	 */

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<DataStream> {
		@Nullable
		private Boolean hidden;

		/**
		 * API name: {@code hidden}
		 */
		public final Builder hidden(@Nullable Boolean value) {
			this.hidden = value;
			return this;
		}

		/**
		 * Builds a {@link DataStream}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public DataStream build() {
			_checkSingleUse();

			return new DataStream(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link DataStream}
	 */
	public static final JsonpDeserializer<DataStream> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			DataStream::setupDataStreamDeserializer);

	protected static void setupDataStreamDeserializer(ObjectDeserializer<DataStream.Builder> op) {

		op.add(Builder::hidden, JsonpDeserializer.booleanDeserializer(), "hidden");

	}

}