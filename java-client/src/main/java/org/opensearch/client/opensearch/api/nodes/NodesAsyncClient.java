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

package org.opensearch.client.opensearch.api.nodes;

import org.opensearch.client.RequestOptions;
import org.opensearch.client.base.ApiClient;
import org.opensearch.client.base.Transport;
import org.opensearch.client.opensearch.nodes.HotThreadsRequest;
import org.opensearch.client.opensearch.nodes.HotThreadsResponse;
import org.opensearch.client.opensearch.nodes.InfoRequest;
import org.opensearch.client.opensearch.nodes.InfoResponse;
import org.opensearch.client.opensearch.nodes.ReloadSecureSettingsRequest;
import org.opensearch.client.opensearch.nodes.ReloadSecureSettingsResponse;
import org.opensearch.client.opensearch.nodes.StatsRequest;
import org.opensearch.client.opensearch.nodes.StatsResponse;
import org.opensearch.client.opensearch.nodes.UsageRequest;
import org.opensearch.client.opensearch.nodes.UsageResponse;
import org.opensearch.client.util.ObjectBuilder;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * Client for the nodes namespace.
 */
public class NodesAsyncClient extends ApiClient<NodesAsyncClient> {

	public NodesAsyncClient(Transport transport) {
		super(transport, null);
	}

	public NodesAsyncClient(Transport transport, RequestOptions options) {
		super(transport, options);
	}

	// ----- Endpoint: nodes.hot_threads

	/**
	 * Returns information about hot threads on each node in the cluster.
	 *
	 */

	public CompletableFuture<HotThreadsResponse> hotThreads(HotThreadsRequest request) throws IOException {
		return this.transport.performRequestAsync(request, HotThreadsRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information about hot threads on each node in the cluster.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<HotThreadsResponse> hotThreads(
			Function<HotThreadsRequest.Builder, ObjectBuilder<HotThreadsRequest>> fn) throws IOException {
		return hotThreads(fn.apply(new HotThreadsRequest.Builder()).build());
	}

	// ----- Endpoint: nodes.info

	/**
	 * Returns information about nodes in the cluster.
	 *
	 */

	public CompletableFuture<InfoResponse> info(InfoRequest request) throws IOException {
		return this.transport.performRequestAsync(request, InfoRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information about nodes in the cluster.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<InfoResponse> info(Function<InfoRequest.Builder, ObjectBuilder<InfoRequest>> fn)
			throws IOException {
		return info(fn.apply(new InfoRequest.Builder()).build());
	}

	// ----- Endpoint: nodes.reload_secure_settings

	/**
	 * Reloads secure settings.
	 *
	 */

	public CompletableFuture<ReloadSecureSettingsResponse> reloadSecureSettings(ReloadSecureSettingsRequest request)
			throws IOException {
		return this.transport.performRequestAsync(request, ReloadSecureSettingsRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Reloads secure settings.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<ReloadSecureSettingsResponse> reloadSecureSettings(
			Function<ReloadSecureSettingsRequest.Builder, ObjectBuilder<ReloadSecureSettingsRequest>> fn)
			throws IOException {
		return reloadSecureSettings(fn.apply(new ReloadSecureSettingsRequest.Builder()).build());
	}

	// ----- Endpoint: nodes.stats

	/**
	 * Returns statistical information about nodes in the cluster.
	 *
	 */

	public CompletableFuture<StatsResponse> stats(StatsRequest request) throws IOException {
		return this.transport.performRequestAsync(request, StatsRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns statistical information about nodes in the cluster.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<StatsResponse> stats(Function<StatsRequest.Builder, ObjectBuilder<StatsRequest>> fn)
			throws IOException {
		return stats(fn.apply(new StatsRequest.Builder()).build());
	}

	// ----- Endpoint: nodes.usage

	/**
	 * Returns low-level information about REST actions usage on nodes.
	 *
	 */

	public CompletableFuture<UsageResponse> usage(UsageRequest request) throws IOException {
		return this.transport.performRequestAsync(request, UsageRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns low-level information about REST actions usage on nodes.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<UsageResponse> usage(Function<UsageRequest.Builder, ObjectBuilder<UsageRequest>> fn)
			throws IOException {
		return usage(fn.apply(new UsageRequest.Builder()).build());
	}

	// ----- Misc

	/**
	 * Creates a new {@link #NodesAsyncClient} with specific request options.
	 */
	@Override
	public NodesAsyncClient withRequestOptions(@Nullable RequestOptions options) {
		return new NodesAsyncClient(transport, options);
	}

	/**
	 * Creates a new {@link #NodesAsyncClient} with specific request options,
	 * inheriting existing options.
	 *
	 * @param fn
	 *            a function taking an options builder initialized with the current
	 *            request options, or initialized with default values.
	 */
	public NodesAsyncClient withRequestOptions(Function<RequestOptions.Builder, RequestOptions.Builder> fn) {
		RequestOptions.Builder builder = requestOptions == null
				? RequestOptions.DEFAULT.toBuilder()
				: requestOptions.toBuilder();

		return withRequestOptions(fn.apply(builder).build());
	}
}
