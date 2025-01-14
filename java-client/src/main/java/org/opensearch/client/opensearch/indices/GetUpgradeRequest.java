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

import org.opensearch.client.base.OpenSearchError;
import org.opensearch.client.base.Endpoint;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.util.ObjectBuilder;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.Objects;

// typedef: indices.get_upgrade.Request
public final class GetUpgradeRequest extends RequestBase {
	private final String stub;

	@Nullable
	private final String index;

	// ---------------------------------------------------------------------------------------------

	protected GetUpgradeRequest(Builder builder) {

		this.stub = Objects.requireNonNull(builder.stub, "stub");
		this.index = builder.index;

	}

	/**
	 * API name: {@code stub}
	 */
	public String stub() {
		return this.stub;
	}

	/**
	 * Auto generated - missing in the input spec
	 *
	 * API name: {@code index}
	 */
	@Nullable
	public String index() {
		return this.index;
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link GetUpgradeRequest}.
	 */
	public static class Builder implements ObjectBuilder<GetUpgradeRequest> {
		private String stub;

		@Nullable
		private String index;

		/**
		 * API name: {@code stub}
		 */
		public Builder stub(String value) {
			this.stub = value;
			return this;
		}

		/**
		 * Auto generated - missing in the input spec
		 *
		 * API name: {@code index}
		 */
		public Builder index(@Nullable String value) {
			this.index = value;
			return this;
		}

		/**
		 * Builds a {@link GetUpgradeRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public GetUpgradeRequest build() {

			return new GetUpgradeRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code indices.get_upgrade}".
	 */
	public static final Endpoint<GetUpgradeRequest, GetUpgradeResponse, OpenSearchError> ENDPOINT = new Endpoint.Simple<>(
			// Request method
			request -> {
				return "GET";

			},

			// Request path
			request -> {
				final int _stub = 1 << 0;
				final int _index = 1 << 1;

				int propsSet = 0;

				if (request.stub() != null)
					propsSet |= _stub;
				if (request.index() != null)
					propsSet |= _index;

				if (propsSet == 0) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_upgrade");
					return buf.toString();
				}
				if (propsSet == (_index)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/");
					buf.append(request.index);
					buf.append("/_upgrade");
					return buf.toString();
				}
				throw Endpoint.Simple.noPathTemplateFound("path");

			},

			// Request parameters
			request -> {
				return Collections.emptyMap();

			}, Endpoint.Simple.emptyMap(), false, GetUpgradeResponse.DESERIALIZER);
}
