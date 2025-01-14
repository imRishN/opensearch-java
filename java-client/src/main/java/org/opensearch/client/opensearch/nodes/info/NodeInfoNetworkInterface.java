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

package org.opensearch.client.opensearch.nodes.info;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.client.json.DelegatingDeserializer;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ToJsonp;
import org.opensearch.client.util.ObjectBuilder;

import java.util.Objects;

// typedef: nodes.info.NodeInfoNetworkInterface
public final class NodeInfoNetworkInterface implements ToJsonp {
	private final String address;

	private final String macAddress;

	private final String name;

	// ---------------------------------------------------------------------------------------------

	protected NodeInfoNetworkInterface(Builder builder) {

		this.address = Objects.requireNonNull(builder.address, "address");
		this.macAddress = Objects.requireNonNull(builder.macAddress, "mac_address");
		this.name = Objects.requireNonNull(builder.name, "name");

	}

	/**
	 * API name: {@code address}
	 */
	public String address() {
		return this.address;
	}

	/**
	 * API name: {@code mac_address}
	 */
	public String macAddress() {
		return this.macAddress;
	}

	/**
	 * API name: {@code name}
	 */
	public String name() {
		return this.name;
	}

	/**
	 * Serialize this object to JSON.
	 */
	public void toJsonp(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartObject();
		toJsonpInternal(generator, mapper);
		generator.writeEnd();
	}

	protected void toJsonpInternal(JsonGenerator generator, JsonpMapper mapper) {

		generator.writeKey("address");
		generator.write(this.address);

		generator.writeKey("mac_address");
		generator.write(this.macAddress);

		generator.writeKey("name");
		generator.write(this.name);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link NodeInfoNetworkInterface}.
	 */
	public static class Builder implements ObjectBuilder<NodeInfoNetworkInterface> {
		private String address;

		private String macAddress;

		private String name;

		/**
		 * API name: {@code address}
		 */
		public Builder address(String value) {
			this.address = value;
			return this;
		}

		/**
		 * API name: {@code mac_address}
		 */
		public Builder macAddress(String value) {
			this.macAddress = value;
			return this;
		}

		/**
		 * API name: {@code name}
		 */
		public Builder name(String value) {
			this.name = value;
			return this;
		}

		/**
		 * Builds a {@link NodeInfoNetworkInterface}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public NodeInfoNetworkInterface build() {

			return new NodeInfoNetworkInterface(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for NodeInfoNetworkInterface
	 */
	public static final JsonpDeserializer<NodeInfoNetworkInterface> DESERIALIZER = ObjectBuilderDeserializer
			.createForObject(Builder::new, NodeInfoNetworkInterface::setupNodeInfoNetworkInterfaceDeserializer);

	protected static void setupNodeInfoNetworkInterfaceDeserializer(
			DelegatingDeserializer<NodeInfoNetworkInterface.Builder> op) {

		op.add(Builder::address, JsonpDeserializer.stringDeserializer(), "address");
		op.add(Builder::macAddress, JsonpDeserializer.stringDeserializer(), "mac_address");
		op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");

	}

}
