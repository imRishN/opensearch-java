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

package co.elastic.clients.elasticsearch.transform;

import co.elastic.clients.ApiClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch._types.ErrorResponse;
import co.elastic.clients.transport.Endpoint;
import co.elastic.clients.transport.EndpointWithResponseMapperAttr;
import co.elastic.clients.transport.Transport;
import co.elastic.clients.transport.TransportOptions;
import co.elastic.clients.util.ObjectBuilder;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import javax.annotation.Nullable;

/**
 * Client for the transform namespace.
 */
public class ElasticsearchTransformAsyncClient extends ApiClient<ElasticsearchTransformAsyncClient> {

	public ElasticsearchTransformAsyncClient(Transport transport) {
		super(transport, null);
	}

	public ElasticsearchTransformAsyncClient(Transport transport, @Nullable TransportOptions transportOptions) {
		super(transport, transportOptions);
	}

	@Override
	public ElasticsearchTransformAsyncClient withTransportOptions(@Nullable TransportOptions transportOptions) {
		return new ElasticsearchTransformAsyncClient(this.transport, transportOptions);
	}

	// ----- Endpoint: transform.delete_transform

	/**
	 * Deletes an existing transform.
	 * 
	 * @see <a href=
	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/delete-transform.html">Documentation
	 *      on elastic.co</a>
	 */

	public CompletableFuture<DeleteTransformResponse> deleteTransform(DeleteTransformRequest request)
			throws IOException, ElasticsearchException {
		@SuppressWarnings("unchecked")
		Endpoint<DeleteTransformRequest, DeleteTransformResponse, ErrorResponse> endpoint = (Endpoint<DeleteTransformRequest, DeleteTransformResponse, ErrorResponse>) DeleteTransformRequest._ENDPOINT;

		return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
	}

	/**
	 * Deletes an existing transform.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link DeleteTransformRequest}
	 * @see <a href=
	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/delete-transform.html">Documentation
	 *      on elastic.co</a>
	 */

	public final CompletableFuture<DeleteTransformResponse> deleteTransform(
			Function<DeleteTransformRequest.Builder, ObjectBuilder<DeleteTransformRequest>> fn)
			throws IOException, ElasticsearchException {
		return deleteTransform(fn.apply(new DeleteTransformRequest.Builder()).build());
	}

	// ----- Endpoint: transform.get_transform

	/**
	 * Retrieves configuration information for transforms.
	 * 
	 * @see <a href=
	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/get-transform.html">Documentation
	 *      on elastic.co</a>
	 */

	public CompletableFuture<GetTransformResponse> getTransform(GetTransformRequest request)
			throws IOException, ElasticsearchException {
		@SuppressWarnings("unchecked")
		Endpoint<GetTransformRequest, GetTransformResponse, ErrorResponse> endpoint = (Endpoint<GetTransformRequest, GetTransformResponse, ErrorResponse>) GetTransformRequest._ENDPOINT;

		return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
	}

	/**
	 * Retrieves configuration information for transforms.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link GetTransformRequest}
	 * @see <a href=
	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/get-transform.html">Documentation
	 *      on elastic.co</a>
	 */

	public final CompletableFuture<GetTransformResponse> getTransform(
			Function<GetTransformRequest.Builder, ObjectBuilder<GetTransformRequest>> fn)
			throws IOException, ElasticsearchException {
		return getTransform(fn.apply(new GetTransformRequest.Builder()).build());
	}

	/**
	 * Retrieves configuration information for transforms.
	 * 
	 * @see <a href=
	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/get-transform.html">Documentation
	 *      on elastic.co</a>
	 */

	public CompletableFuture<GetTransformResponse> getTransform() throws IOException, ElasticsearchException {
		return this.transport.performRequestAsync(new GetTransformRequest.Builder().build(),
				GetTransformRequest._ENDPOINT, this.transportOptions);
	}

	// ----- Endpoint: transform.get_transform_stats

	/**
	 * Retrieves usage information for transforms.
	 * 
	 * @see <a href=
	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/get-transform-stats.html">Documentation
	 *      on elastic.co</a>
	 */

	public CompletableFuture<GetTransformStatsResponse> getTransformStats(GetTransformStatsRequest request)
			throws IOException, ElasticsearchException {
		@SuppressWarnings("unchecked")
		Endpoint<GetTransformStatsRequest, GetTransformStatsResponse, ErrorResponse> endpoint = (Endpoint<GetTransformStatsRequest, GetTransformStatsResponse, ErrorResponse>) GetTransformStatsRequest._ENDPOINT;

		return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
	}

	/**
	 * Retrieves usage information for transforms.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link GetTransformStatsRequest}
	 * @see <a href=
	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/get-transform-stats.html">Documentation
	 *      on elastic.co</a>
	 */

	public final CompletableFuture<GetTransformStatsResponse> getTransformStats(
			Function<GetTransformStatsRequest.Builder, ObjectBuilder<GetTransformStatsRequest>> fn)
			throws IOException, ElasticsearchException {
		return getTransformStats(fn.apply(new GetTransformStatsRequest.Builder()).build());
	}

	// ----- Endpoint: transform.preview_transform

	/**
	 * Previews a transform.
	 * 
	 * @see <a href=
	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/preview-transform.html">Documentation
	 *      on elastic.co</a>
	 */

	public <TTransform> CompletableFuture<PreviewTransformResponse<TTransform>> previewTransform(
			PreviewTransformRequest request, Class<TTransform> tTransformClass)
			throws IOException, ElasticsearchException {
		@SuppressWarnings("unchecked")
		Endpoint<PreviewTransformRequest, PreviewTransformResponse<TTransform>, ErrorResponse> endpoint = (Endpoint<PreviewTransformRequest, PreviewTransformResponse<TTransform>, ErrorResponse>) PreviewTransformRequest._ENDPOINT;
		endpoint = new EndpointWithResponseMapperAttr<>(endpoint,
				"co.elastic.clients:Deserializer:transform.preview_transform.TTransform",
				getDeserializer(tTransformClass));

		return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
	}

	/**
	 * Previews a transform.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link PreviewTransformRequest}
	 * @see <a href=
	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/preview-transform.html">Documentation
	 *      on elastic.co</a>
	 */

	public final <TTransform> CompletableFuture<PreviewTransformResponse<TTransform>> previewTransform(
			Function<PreviewTransformRequest.Builder, ObjectBuilder<PreviewTransformRequest>> fn,
			Class<TTransform> tTransformClass) throws IOException, ElasticsearchException {
		return previewTransform(fn.apply(new PreviewTransformRequest.Builder()).build(), tTransformClass);
	}

	// ----- Endpoint: transform.put_transform

	/**
	 * Instantiates a transform.
	 * 
	 * @see <a href=
	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/put-transform.html">Documentation
	 *      on elastic.co</a>
	 */

	public CompletableFuture<PutTransformResponse> putTransform(PutTransformRequest request)
			throws IOException, ElasticsearchException {
		@SuppressWarnings("unchecked")
		Endpoint<PutTransformRequest, PutTransformResponse, ErrorResponse> endpoint = (Endpoint<PutTransformRequest, PutTransformResponse, ErrorResponse>) PutTransformRequest._ENDPOINT;

		return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
	}

	/**
	 * Instantiates a transform.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link PutTransformRequest}
	 * @see <a href=
	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/put-transform.html">Documentation
	 *      on elastic.co</a>
	 */

	public final CompletableFuture<PutTransformResponse> putTransform(
			Function<PutTransformRequest.Builder, ObjectBuilder<PutTransformRequest>> fn)
			throws IOException, ElasticsearchException {
		return putTransform(fn.apply(new PutTransformRequest.Builder()).build());
	}

	// ----- Endpoint: transform.start_transform

	/**
	 * Starts one or more transforms.
	 * 
	 * @see <a href=
	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/start-transform.html">Documentation
	 *      on elastic.co</a>
	 */

	public CompletableFuture<StartTransformResponse> startTransform(StartTransformRequest request)
			throws IOException, ElasticsearchException {
		@SuppressWarnings("unchecked")
		Endpoint<StartTransformRequest, StartTransformResponse, ErrorResponse> endpoint = (Endpoint<StartTransformRequest, StartTransformResponse, ErrorResponse>) StartTransformRequest._ENDPOINT;

		return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
	}

	/**
	 * Starts one or more transforms.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link StartTransformRequest}
	 * @see <a href=
	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/start-transform.html">Documentation
	 *      on elastic.co</a>
	 */

	public final CompletableFuture<StartTransformResponse> startTransform(
			Function<StartTransformRequest.Builder, ObjectBuilder<StartTransformRequest>> fn)
			throws IOException, ElasticsearchException {
		return startTransform(fn.apply(new StartTransformRequest.Builder()).build());
	}

	// ----- Endpoint: transform.stop_transform

	/**
	 * Stops one or more transforms.
	 * 
	 * @see <a href=
	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/stop-transform.html">Documentation
	 *      on elastic.co</a>
	 */

	public CompletableFuture<StopTransformResponse> stopTransform(StopTransformRequest request)
			throws IOException, ElasticsearchException {
		@SuppressWarnings("unchecked")
		Endpoint<StopTransformRequest, StopTransformResponse, ErrorResponse> endpoint = (Endpoint<StopTransformRequest, StopTransformResponse, ErrorResponse>) StopTransformRequest._ENDPOINT;

		return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
	}

	/**
	 * Stops one or more transforms.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link StopTransformRequest}
	 * @see <a href=
	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/stop-transform.html">Documentation
	 *      on elastic.co</a>
	 */

	public final CompletableFuture<StopTransformResponse> stopTransform(
			Function<StopTransformRequest.Builder, ObjectBuilder<StopTransformRequest>> fn)
			throws IOException, ElasticsearchException {
		return stopTransform(fn.apply(new StopTransformRequest.Builder()).build());
	}

	// ----- Endpoint: transform.update_transform

	/**
	 * Updates certain properties of a transform.
	 * 
	 * @see <a href=
	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/update-transform.html">Documentation
	 *      on elastic.co</a>
	 */

	public CompletableFuture<UpdateTransformResponse> updateTransform(UpdateTransformRequest request)
			throws IOException, ElasticsearchException {
		@SuppressWarnings("unchecked")
		Endpoint<UpdateTransformRequest, UpdateTransformResponse, ErrorResponse> endpoint = (Endpoint<UpdateTransformRequest, UpdateTransformResponse, ErrorResponse>) UpdateTransformRequest._ENDPOINT;

		return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
	}

	/**
	 * Updates certain properties of a transform.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link UpdateTransformRequest}
	 * @see <a href=
	 *      "https://www.elastic.co/guide/en/elasticsearch/reference/current/update-transform.html">Documentation
	 *      on elastic.co</a>
	 */

	public final CompletableFuture<UpdateTransformResponse> updateTransform(
			Function<UpdateTransformRequest.Builder, ObjectBuilder<UpdateTransformRequest>> fn)
			throws IOException, ElasticsearchException {
		return updateTransform(fn.apply(new UpdateTransformRequest.Builder()).build());
	}

}