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

package org.opensearch.clients.opensearch.indices;

import org.opensearch.clients.opensearch._types.ErrorResponse;
import org.opensearch.clients.opensearch._types.ExpandWildcardOptions;
import org.opensearch.clients.opensearch._types.RequestBase;
import org.opensearch.clients.transport.Endpoint;
import org.opensearch.clients.transport.SimpleEndpoint;
import org.opensearch.clients.util.ModelTypeHelper;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;

import java.lang.String;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

// typedef: indices.get_data_stream.Request

public class GetDataStreamRequest extends RequestBase {
	private final List<ExpandWildcardOptions> expandWildcards;

	private final List<String> name;

	// ---------------------------------------------------------------------------------------------

	private GetDataStreamRequest(Builder builder) {

		this.expandWildcards = ModelTypeHelper.unmodifiable(builder.expandWildcards);
		this.name = ModelTypeHelper.unmodifiable(builder.name);

	}

	public static GetDataStreamRequest of(Function<Builder, ObjectBuilder<GetDataStreamRequest>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Whether wildcard expressions should get expanded to open or closed indices
	 * (default: open)
	 * <p>
	 * API name: {@code expand_wildcards}
	 */
	public final List<ExpandWildcardOptions> expandWildcards() {
		return this.expandWildcards;
	}

	/**
	 * A comma-separated list of data streams to get; use <code>*</code> to get all
	 * data streams
	 * <p>
	 * API name: {@code name}
	 */
	public final List<String> name() {
		return this.name;
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link GetDataStreamRequest}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<GetDataStreamRequest> {
		@Nullable
		private List<ExpandWildcardOptions> expandWildcards;

		@Nullable
		private List<String> name;

		/**
		 * Whether wildcard expressions should get expanded to open or closed indices
		 * (default: open)
		 * <p>
		 * API name: {@code expand_wildcards}
		 */
		public final Builder expandWildcards(@Nullable List<ExpandWildcardOptions> value) {
			this.expandWildcards = value;
			return this;
		}

		/**
		 * Whether wildcard expressions should get expanded to open or closed indices
		 * (default: open)
		 * <p>
		 * API name: {@code expand_wildcards}
		 */
		public final Builder expandWildcards(ExpandWildcardOptions... value) {
			this.expandWildcards = Arrays.asList(value);
			return this;
		}

		/**
		 * A comma-separated list of data streams to get; use <code>*</code> to get all
		 * data streams
		 * <p>
		 * API name: {@code name}
		 */
		public final Builder name(@Nullable List<String> value) {
			this.name = value;
			return this;
		}

		/**
		 * A comma-separated list of data streams to get; use <code>*</code> to get all
		 * data streams
		 * <p>
		 * API name: {@code name}
		 */
		public final Builder name(String... value) {
			this.name = Arrays.asList(value);
			return this;
		}

		/**
		 * Builds a {@link GetDataStreamRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public GetDataStreamRequest build() {
			_checkSingleUse();

			return new GetDataStreamRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code indices.get_data_stream}".
	 */
	public static final Endpoint<GetDataStreamRequest, GetDataStreamResponse, ErrorResponse> ENDPOINT = new SimpleEndpoint<>(
			// Request method
			request -> {
				return "GET";

			},

			// Request path
			request -> {
				final int _name = 1 << 0;

				int propsSet = 0;

				if (ModelTypeHelper.isDefined(request.name()))
					propsSet |= _name;

				if (propsSet == 0) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_data_stream");
					return buf.toString();
				}
				if (propsSet == (_name)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_data_stream");
					buf.append("/");
					SimpleEndpoint.pathEncode(request.name.stream().map(v -> v).collect(Collectors.joining(",")), buf);
					return buf.toString();
				}
				throw SimpleEndpoint.noPathTemplateFound("path");

			},

			// Request parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				if (ModelTypeHelper.isDefined(request.expandWildcards)) {
					params.put("expand_wildcards",
							request.expandWildcards.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")));
				}
				return params;

			}, SimpleEndpoint.emptyMap(), false, GetDataStreamResponse._DESERIALIZER);
}
