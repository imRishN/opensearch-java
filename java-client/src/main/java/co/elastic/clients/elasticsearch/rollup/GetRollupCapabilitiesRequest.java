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

package co.elastic.clients.elasticsearch.rollup;

import co.elastic.clients.base.ElasticsearchError;
import co.elastic.clients.base.Endpoint;
import co.elastic.clients.elasticsearch._types.RequestBase;
import co.elastic.clients.json.JsonpObjectBuilderParser;
import co.elastic.clients.json.JsonpObjectParser;
import co.elastic.clients.json.JsonpValueParser;
import co.elastic.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.lang.String;
import java.util.Collections;
import javax.annotation.Nullable;

// typedef: rollup.get_rollup_capabilities.Request
public final class GetRollupCapabilitiesRequest extends RequestBase {
	@Nullable
	private final String id;

	// ---------------------------------------------------------------------------------------------

	protected GetRollupCapabilitiesRequest(Builder builder) {

		this.id = builder.id;

	}

	/**
	 * API name: {@code id}
	 */
	@Nullable
	public String id() {
		return this.id;
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link GetRollupCapabilitiesRequest}.
	 */
	public static class Builder implements ObjectBuilder<GetRollupCapabilitiesRequest> {
		@Nullable
		private String id;

		/**
		 * API name: {@code id}
		 */
		public Builder id(@Nullable String value) {
			this.id = value;
			return this;
		}

		/**
		 * Builds a {@link GetRollupCapabilitiesRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public GetRollupCapabilitiesRequest build() {

			return new GetRollupCapabilitiesRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code rollup.get_rollup_caps}".
	 */
	public static final Endpoint<GetRollupCapabilitiesRequest, GetRollupCapabilitiesResponse, ElasticsearchError> ENDPOINT = new Endpoint.Simple<>(
			// Request method
			request -> {
				final int id = 1 << 0;

				int propsSet = 0;

				if (request.id() != null)
					propsSet |= id;

				if (propsSet == (0 | 0 | id))
					return "GET";
				if (propsSet == (0 | 0))
					return "GET";
				throw Endpoint.Simple.noPathTemplateFound("method");

			},

			// Request path
			request -> {
				final int id = 1 << 0;

				int propsSet = 0;

				if (request.id() != null)
					propsSet |= id;

				if (propsSet == (0 | 0 | id)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_rollup");
					buf.append("/data");
					buf.append("/");
					buf.append(request.id);
					return buf.toString();
				}
				if (propsSet == (0 | 0)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_rollup");
					buf.append("/data");
					return buf.toString();
				}
				throw Endpoint.Simple.noPathTemplateFound("path");

			},

			// Request parameters
			request -> {
				return Collections.emptyMap();

			}, Endpoint.Simple.emptyMap(), false, GetRollupCapabilitiesResponse.JSONP_PARSER);
}