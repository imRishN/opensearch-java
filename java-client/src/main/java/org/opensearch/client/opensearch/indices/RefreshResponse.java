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

import org.opensearch.client.opensearch._types.ShardsOperationResponseBase;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ObjectBuilder;

import java.util.function.Function;

// typedef: indices.refresh.Response

/**
 *
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/indices/refresh/IndicesRefreshResponse.ts#L22-L22">API
 *      specification</a>
 */
@JsonpDeserializable
public class RefreshResponse extends ShardsOperationResponseBase {
	// ---------------------------------------------------------------------------------------------

	private RefreshResponse(Builder builder) {
		super(builder);

	}

	public static RefreshResponse of(Function<Builder, ObjectBuilder<RefreshResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link RefreshResponse}.
	 */

	public static class Builder extends ShardsOperationResponseBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<RefreshResponse> {
		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link RefreshResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public RefreshResponse build() {
			_checkSingleUse();

			return new RefreshResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link RefreshResponse}
	 */
	public static final JsonpDeserializer<RefreshResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			RefreshResponse::setupRefreshResponseDeserializer);

	protected static void setupRefreshResponseDeserializer(ObjectDeserializer<RefreshResponse.Builder> op) {
		ShardsOperationResponseBase.setupShardsOperationResponseBaseDeserializer(op);

	}

}