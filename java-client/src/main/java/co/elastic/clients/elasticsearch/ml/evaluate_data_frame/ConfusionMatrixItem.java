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

package co.elastic.clients.elasticsearch.ml.evaluate_data_frame;

import co.elastic.clients.json.DelegatingDeserializer;
import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.JsonpSerializable;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.util.ModelTypeHelper;
import co.elastic.clients.util.ObjectBuilder;
import co.elastic.clients.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: ml.evaluate_data_frame.ConfusionMatrixItem
@JsonpDeserializable
public class ConfusionMatrixItem implements JsonpSerializable {
	private final String actualClass;

	private final int actualClassDocCount;

	private final List<ConfusionMatrixPrediction> predictedClasses;

	private final int otherPredictedClassDocCount;

	// ---------------------------------------------------------------------------------------------

	private ConfusionMatrixItem(Builder builder) {

		this.actualClass = ModelTypeHelper.requireNonNull(builder.actualClass, this, "actualClass");
		this.actualClassDocCount = ModelTypeHelper.requireNonNull(builder.actualClassDocCount, this,
				"actualClassDocCount");
		this.predictedClasses = ModelTypeHelper.unmodifiableRequired(builder.predictedClasses, this,
				"predictedClasses");
		this.otherPredictedClassDocCount = ModelTypeHelper.requireNonNull(builder.otherPredictedClassDocCount, this,
				"otherPredictedClassDocCount");

	}

	public static ConfusionMatrixItem of(Function<Builder, ObjectBuilder<ConfusionMatrixItem>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code actual_class}
	 */
	public final String actualClass() {
		return this.actualClass;
	}

	/**
	 * Required - API name: {@code actual_class_doc_count}
	 */
	public final int actualClassDocCount() {
		return this.actualClassDocCount;
	}

	/**
	 * Required - API name: {@code predicted_classes}
	 */
	public final List<ConfusionMatrixPrediction> predictedClasses() {
		return this.predictedClasses;
	}

	/**
	 * Required - API name: {@code other_predicted_class_doc_count}
	 */
	public final int otherPredictedClassDocCount() {
		return this.otherPredictedClassDocCount;
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

		generator.writeKey("actual_class");
		generator.write(this.actualClass);

		generator.writeKey("actual_class_doc_count");
		generator.write(this.actualClassDocCount);

		if (ModelTypeHelper.isDefined(this.predictedClasses)) {
			generator.writeKey("predicted_classes");
			generator.writeStartArray();
			for (ConfusionMatrixPrediction item0 : this.predictedClasses) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}
		generator.writeKey("other_predicted_class_doc_count");
		generator.write(this.otherPredictedClassDocCount);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ConfusionMatrixItem}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<ConfusionMatrixItem> {
		private String actualClass;

		private Integer actualClassDocCount;

		private List<ConfusionMatrixPrediction> predictedClasses;

		private Integer otherPredictedClassDocCount;

		/**
		 * Required - API name: {@code actual_class}
		 */
		public final Builder actualClass(String value) {
			this.actualClass = value;
			return this;
		}

		/**
		 * Required - API name: {@code actual_class_doc_count}
		 */
		public final Builder actualClassDocCount(int value) {
			this.actualClassDocCount = value;
			return this;
		}

		/**
		 * Required - API name: {@code predicted_classes}
		 */
		public final Builder predictedClasses(List<ConfusionMatrixPrediction> value) {
			this.predictedClasses = value;
			return this;
		}

		/**
		 * Required - API name: {@code predicted_classes}
		 */
		public final Builder predictedClasses(ConfusionMatrixPrediction... value) {
			this.predictedClasses = Arrays.asList(value);
			return this;
		}

		/**
		 * Required - API name: {@code predicted_classes}
		 */
		@SafeVarargs
		public final Builder predictedClasses(
				Function<ConfusionMatrixPrediction.Builder, ObjectBuilder<ConfusionMatrixPrediction>>... fns) {
			this.predictedClasses = new ArrayList<>(fns.length);
			for (Function<ConfusionMatrixPrediction.Builder, ObjectBuilder<ConfusionMatrixPrediction>> fn : fns) {
				this.predictedClasses.add(fn.apply(new ConfusionMatrixPrediction.Builder()).build());
			}
			return this;
		}

		/**
		 * Required - API name: {@code other_predicted_class_doc_count}
		 */
		public final Builder otherPredictedClassDocCount(int value) {
			this.otherPredictedClassDocCount = value;
			return this;
		}

		/**
		 * Builds a {@link ConfusionMatrixItem}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ConfusionMatrixItem build() {
			_checkSingleUse();

			return new ConfusionMatrixItem(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link ConfusionMatrixItem}
	 */
	public static final JsonpDeserializer<ConfusionMatrixItem> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, ConfusionMatrixItem::setupConfusionMatrixItemDeserializer, Builder::build);

	protected static void setupConfusionMatrixItemDeserializer(DelegatingDeserializer<ConfusionMatrixItem.Builder> op) {

		op.add(Builder::actualClass, JsonpDeserializer.stringDeserializer(), "actual_class");
		op.add(Builder::actualClassDocCount, JsonpDeserializer.integerDeserializer(), "actual_class_doc_count");
		op.add(Builder::predictedClasses, JsonpDeserializer.arrayDeserializer(ConfusionMatrixPrediction._DESERIALIZER),
				"predicted_classes");
		op.add(Builder::otherPredictedClassDocCount, JsonpDeserializer.integerDeserializer(),
				"other_predicted_class_doc_count");

	}

}