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

package org.opensearch.client.opensearch.api.snapshot;

import org.opensearch.client.RequestOptions;
import org.opensearch.client.base.ApiClient;
import org.opensearch.client.base.Transport;
import org.opensearch.client.opensearch.snapshot.CleanupRepositoryRequest;
import org.opensearch.client.opensearch.snapshot.CleanupRepositoryResponse;
import org.opensearch.client.opensearch.snapshot.CloneRequest;
import org.opensearch.client.opensearch.snapshot.CloneResponse;
import org.opensearch.client.opensearch.snapshot.CreateRepositoryRequest;
import org.opensearch.client.opensearch.snapshot.CreateRepositoryResponse;
import org.opensearch.client.opensearch.snapshot.CreateRequest;
import org.opensearch.client.opensearch.snapshot.CreateResponse;
import org.opensearch.client.opensearch.snapshot.DeleteRepositoryRequest;
import org.opensearch.client.opensearch.snapshot.DeleteRepositoryResponse;
import org.opensearch.client.opensearch.snapshot.DeleteRequest;
import org.opensearch.client.opensearch.snapshot.DeleteResponse;
import org.opensearch.client.opensearch.snapshot.GetRepositoryRequest;
import org.opensearch.client.opensearch.snapshot.GetRepositoryResponse;
import org.opensearch.client.opensearch.snapshot.GetRequest;
import org.opensearch.client.opensearch.snapshot.GetResponse;
import org.opensearch.client.opensearch.snapshot.RestoreRequest;
import org.opensearch.client.opensearch.snapshot.RestoreResponse;
import org.opensearch.client.opensearch.snapshot.StatusRequest;
import org.opensearch.client.opensearch.snapshot.StatusResponse;
import org.opensearch.client.opensearch.snapshot.VerifyRepositoryRequest;
import org.opensearch.client.opensearch.snapshot.VerifyRepositoryResponse;
import org.opensearch.client.util.ObjectBuilder;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * Client for the snapshot namespace.
 */
public class SnapshotAsyncClient extends ApiClient<SnapshotAsyncClient> {

	public SnapshotAsyncClient(Transport transport) {
		super(transport, null);
	}

	public SnapshotAsyncClient(Transport transport, RequestOptions options) {
		super(transport, options);
	}

	// ----- Endpoint: snapshot.cleanup_repository

	/**
	 * Removes stale data from repository.
	 *
	 */

	public CompletableFuture<CleanupRepositoryResponse> cleanupRepository(CleanupRepositoryRequest request)
			throws IOException {
		return this.transport.performRequestAsync(request, CleanupRepositoryRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Removes stale data from repository.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<CleanupRepositoryResponse> cleanupRepository(
			Function<CleanupRepositoryRequest.Builder, ObjectBuilder<CleanupRepositoryRequest>> fn) throws IOException {
		return cleanupRepository(fn.apply(new CleanupRepositoryRequest.Builder()).build());
	}

	// ----- Endpoint: snapshot.clone

	/**
	 * Clones indices from one snapshot into another snapshot in the same
	 * repository.
	 *
	 */

	public CompletableFuture<CloneResponse> clone(CloneRequest request) throws IOException {
		return this.transport.performRequestAsync(request, CloneRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Clones indices from one snapshot into another snapshot in the same
	 * repository.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<CloneResponse> clone(Function<CloneRequest.Builder, ObjectBuilder<CloneRequest>> fn)
			throws IOException {
		return clone(fn.apply(new CloneRequest.Builder()).build());
	}

	// ----- Endpoint: snapshot.create

	/**
	 * Creates a snapshot in a repository.
	 *
	 */

	public CompletableFuture<CreateResponse> create(CreateRequest request) throws IOException {
		return this.transport.performRequestAsync(request, CreateRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Creates a snapshot in a repository.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<CreateResponse> create(
			Function<CreateRequest.Builder, ObjectBuilder<CreateRequest>> fn) throws IOException {
		return create(fn.apply(new CreateRequest.Builder()).build());
	}

	// ----- Endpoint: snapshot.create_repository

	/**
	 * Creates a repository.
	 *
	 */

	public CompletableFuture<CreateRepositoryResponse> createRepository(CreateRepositoryRequest request)
			throws IOException {
		return this.transport.performRequestAsync(request, CreateRepositoryRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Creates a repository.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<CreateRepositoryResponse> createRepository(
			Function<CreateRepositoryRequest.Builder, ObjectBuilder<CreateRepositoryRequest>> fn) throws IOException {
		return createRepository(fn.apply(new CreateRepositoryRequest.Builder()).build());
	}

	// ----- Endpoint: snapshot.delete

	/**
	 * Deletes a snapshot.
	 *
	 */

	public CompletableFuture<DeleteResponse> delete(DeleteRequest request) throws IOException {
		return this.transport.performRequestAsync(request, DeleteRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Deletes a snapshot.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<DeleteResponse> delete(
			Function<DeleteRequest.Builder, ObjectBuilder<DeleteRequest>> fn) throws IOException {
		return delete(fn.apply(new DeleteRequest.Builder()).build());
	}

	// ----- Endpoint: snapshot.delete_repository

	/**
	 * Deletes a repository.
	 *
	 */

	public CompletableFuture<DeleteRepositoryResponse> deleteRepository(DeleteRepositoryRequest request)
			throws IOException {
		return this.transport.performRequestAsync(request, DeleteRepositoryRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Deletes a repository.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<DeleteRepositoryResponse> deleteRepository(
			Function<DeleteRepositoryRequest.Builder, ObjectBuilder<DeleteRepositoryRequest>> fn) throws IOException {
		return deleteRepository(fn.apply(new DeleteRepositoryRequest.Builder()).build());
	}

	// ----- Endpoint: snapshot.get

	/**
	 * Returns information about a snapshot.
	 *
	 */

	public CompletableFuture<GetResponse> get(GetRequest request) throws IOException {
		return this.transport.performRequestAsync(request, GetRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information about a snapshot.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<GetResponse> get(Function<GetRequest.Builder, ObjectBuilder<GetRequest>> fn)
			throws IOException {
		return get(fn.apply(new GetRequest.Builder()).build());
	}

	// ----- Endpoint: snapshot.get_repository

	/**
	 * Returns information about a repository.
	 *
	 */

	public CompletableFuture<GetRepositoryResponse> getRepository(GetRepositoryRequest request) throws IOException {
		return this.transport.performRequestAsync(request, GetRepositoryRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information about a repository.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<GetRepositoryResponse> getRepository(
			Function<GetRepositoryRequest.Builder, ObjectBuilder<GetRepositoryRequest>> fn) throws IOException {
		return getRepository(fn.apply(new GetRepositoryRequest.Builder()).build());
	}

	// ----- Endpoint: snapshot.restore

	/**
	 * Restores a snapshot.
	 *
	 */

	public CompletableFuture<RestoreResponse> restore(RestoreRequest request) throws IOException {
		return this.transport.performRequestAsync(request, RestoreRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Restores a snapshot.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<RestoreResponse> restore(
			Function<RestoreRequest.Builder, ObjectBuilder<RestoreRequest>> fn) throws IOException {
		return restore(fn.apply(new RestoreRequest.Builder()).build());
	}

	// ----- Endpoint: snapshot.status

	/**
	 * Returns information about the status of a snapshot.
	 *
	 */

	public CompletableFuture<StatusResponse> status(StatusRequest request) throws IOException {
		return this.transport.performRequestAsync(request, StatusRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information about the status of a snapshot.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<StatusResponse> status(
			Function<StatusRequest.Builder, ObjectBuilder<StatusRequest>> fn) throws IOException {
		return status(fn.apply(new StatusRequest.Builder()).build());
	}

	// ----- Endpoint: snapshot.verify_repository

	/**
	 * Verifies a repository.
	 *
	 */

	public CompletableFuture<VerifyRepositoryResponse> verifyRepository(VerifyRepositoryRequest request)
			throws IOException {
		return this.transport.performRequestAsync(request, VerifyRepositoryRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Verifies a repository.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CompletableFuture<VerifyRepositoryResponse> verifyRepository(
			Function<VerifyRepositoryRequest.Builder, ObjectBuilder<VerifyRepositoryRequest>> fn) throws IOException {
		return verifyRepository(fn.apply(new VerifyRepositoryRequest.Builder()).build());
	}

	// ----- Misc

	/**
	 * Creates a new {@link #SnapshotAsyncClient} with specific request options.
	 */
	@Override
	public SnapshotAsyncClient withRequestOptions(@Nullable RequestOptions options) {
		return new SnapshotAsyncClient(transport, options);
	}

	/**
	 * Creates a new {@link #SnapshotAsyncClient} with specific request options,
	 * inheriting existing options.
	 *
	 * @param fn
	 *            a function taking an options builder initialized with the current
	 *            request options, or initialized with default values.
	 */
	public SnapshotAsyncClient withRequestOptions(Function<RequestOptions.Builder, RequestOptions.Builder> fn) {
		RequestOptions.Builder builder = requestOptions == null
				? RequestOptions.DEFAULT.toBuilder()
				: requestOptions.toBuilder();

		return withRequestOptions(fn.apply(builder).build());
	}
}
