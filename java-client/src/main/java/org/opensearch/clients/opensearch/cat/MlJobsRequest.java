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

package org.opensearch.clients.opensearch.cat;

import org.opensearch.clients.opensearch._types.Bytes;
import org.opensearch.clients.opensearch._types.ErrorResponse;
import org.opensearch.clients.transport.Endpoint;
import org.opensearch.clients.transport.endpoints.SimpleEndpoint;
import org.opensearch.clients.util.ObjectBuilder;
import org.opensearch.clients.util.ObjectBuilderBase;

import java.lang.Boolean;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: cat.ml_jobs.Request

/**
 * Gets configuration and usage information about anomaly detection jobs.
 * 
 * @see <a href=
 *      "https://github.com/elastic/elasticsearch-specification/tree/98036c3/specification/cat/ml_jobs/CatJobsRequest.ts#L23-L39">API
 *      specification</a>
 */

public class MlJobsRequest extends CatRequestBase {
	@Nullable
	private final Boolean allowNoJobs;

	@Nullable
	private final Bytes bytes;

	@Nullable
	private final String jobId;

	// ---------------------------------------------------------------------------------------------

	private MlJobsRequest(Builder builder) {

		this.allowNoJobs = builder.allowNoJobs;
		this.bytes = builder.bytes;
		this.jobId = builder.jobId;

	}

	public static MlJobsRequest of(Function<Builder, ObjectBuilder<MlJobsRequest>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Whether to ignore if a wildcard expression matches no jobs. (This includes
	 * <code>_all</code> string or when no jobs have been specified)
	 * <p>
	 * API name: {@code allow_no_jobs}
	 * 
	 * @deprecated 7.10.0 Use <code>allow_no_match</code> instead.
	 */
	@Deprecated
	@Nullable
	public final Boolean allowNoJobs() {
		return this.allowNoJobs;
	}

	/**
	 * The unit in which to display byte values
	 * <p>
	 * API name: {@code bytes}
	 */
	@Nullable
	public final Bytes bytes() {
		return this.bytes;
	}

	/**
	 * The ID of the jobs stats to fetch
	 * <p>
	 * API name: {@code job_id}
	 */
	@Nullable
	public final String jobId() {
		return this.jobId;
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link MlJobsRequest}.
	 */

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<MlJobsRequest> {
		@Nullable
		private Boolean allowNoJobs;

		@Nullable
		private Bytes bytes;

		@Nullable
		private String jobId;

		/**
		 * Whether to ignore if a wildcard expression matches no jobs. (This includes
		 * <code>_all</code> string or when no jobs have been specified)
		 * <p>
		 * API name: {@code allow_no_jobs}
		 * 
		 * @deprecated 7.10.0 Use <code>allow_no_match</code> instead.
		 */
		@Deprecated
		public final Builder allowNoJobs(@Nullable Boolean value) {
			this.allowNoJobs = value;
			return this;
		}

		/**
		 * The unit in which to display byte values
		 * <p>
		 * API name: {@code bytes}
		 */
		public final Builder bytes(@Nullable Bytes value) {
			this.bytes = value;
			return this;
		}

		/**
		 * The ID of the jobs stats to fetch
		 * <p>
		 * API name: {@code job_id}
		 */
		public final Builder jobId(@Nullable String value) {
			this.jobId = value;
			return this;
		}

		/**
		 * Builds a {@link MlJobsRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public MlJobsRequest build() {
			_checkSingleUse();

			return new MlJobsRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code cat.ml_jobs}".
	 */
	public static final Endpoint<MlJobsRequest, MlJobsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
			"es/cat.ml_jobs",

			// Request method
			request -> {
				return "GET";

			},

			// Request path
			request -> {
				final int _jobId = 1 << 0;

				int propsSet = 0;

				if (request.jobId() != null)
					propsSet |= _jobId;

				if (propsSet == 0) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_cat");
					buf.append("/ml");
					buf.append("/anomaly_detectors");
					return buf.toString();
				}
				if (propsSet == (_jobId)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_cat");
					buf.append("/ml");
					buf.append("/anomaly_detectors");
					buf.append("/");
					SimpleEndpoint.pathEncode(request.jobId, buf);
					return buf.toString();
				}
				throw SimpleEndpoint.noPathTemplateFound("path");

			},

			// Request parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				params.put("format", "json");
				if (request.allowNoJobs != null) {
					params.put("allow_no_jobs", String.valueOf(request.allowNoJobs));
				}
				if (request.bytes != null) {
					params.put("bytes", request.bytes.jsonValue());
				}
				return params;

			}, SimpleEndpoint.emptyMap(), false, MlJobsResponse._DESERIALIZER);
}
