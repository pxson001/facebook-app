package com.facebook.topics.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.topics.protocol.UserTopicMutationsParsers.TopicHideUserMutationResponseFragmentParser;
import com.facebook.topics.protocol.UserTopicMutationsParsers.TopicUnhideUserMutationResponseFragmentParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: extra_media_items */
public class UserTopicMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_media_items */
    public final class TopicHideUserMutationResponseFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f15048d;

        /* compiled from: extra_media_items */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TopicHideUserMutationResponseFragmentModel.class, new Deserializer());
            }

            public Object m19031a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TopicHideUserMutationResponseFragmentParser.m19041a(jsonParser);
                Object topicHideUserMutationResponseFragmentModel = new TopicHideUserMutationResponseFragmentModel();
                ((BaseModel) topicHideUserMutationResponseFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (topicHideUserMutationResponseFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) topicHideUserMutationResponseFragmentModel).a();
                }
                return topicHideUserMutationResponseFragmentModel;
            }
        }

        /* compiled from: extra_media_items */
        public class Serializer extends JsonSerializer<TopicHideUserMutationResponseFragmentModel> {
            public final void m19032a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TopicHideUserMutationResponseFragmentModel topicHideUserMutationResponseFragmentModel = (TopicHideUserMutationResponseFragmentModel) obj;
                if (topicHideUserMutationResponseFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(topicHideUserMutationResponseFragmentModel.m19034a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    topicHideUserMutationResponseFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = topicHideUserMutationResponseFragmentModel.w_();
                int u_ = topicHideUserMutationResponseFragmentModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TopicHideUserMutationResponseFragmentModel.class, new Serializer());
            }
        }

        public TopicHideUserMutationResponseFragmentModel() {
            super(1);
        }

        @Nullable
        private String m19033a() {
            this.f15048d = super.a(this.f15048d, 0);
            return this.f15048d;
        }

        public final int jK_() {
            return 1236496401;
        }

        public final GraphQLVisitableModel m19035a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m19034a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m19033a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_media_items */
    public final class TopicUnhideUserMutationResponseFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f15049d;

        /* compiled from: extra_media_items */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TopicUnhideUserMutationResponseFragmentModel.class, new Deserializer());
            }

            public Object m19036a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TopicUnhideUserMutationResponseFragmentParser.m19042a(jsonParser);
                Object topicUnhideUserMutationResponseFragmentModel = new TopicUnhideUserMutationResponseFragmentModel();
                ((BaseModel) topicUnhideUserMutationResponseFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (topicUnhideUserMutationResponseFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) topicUnhideUserMutationResponseFragmentModel).a();
                }
                return topicUnhideUserMutationResponseFragmentModel;
            }
        }

        /* compiled from: extra_media_items */
        public class Serializer extends JsonSerializer<TopicUnhideUserMutationResponseFragmentModel> {
            public final void m19037a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TopicUnhideUserMutationResponseFragmentModel topicUnhideUserMutationResponseFragmentModel = (TopicUnhideUserMutationResponseFragmentModel) obj;
                if (topicUnhideUserMutationResponseFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(topicUnhideUserMutationResponseFragmentModel.m19039a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    topicUnhideUserMutationResponseFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = topicUnhideUserMutationResponseFragmentModel.w_();
                int u_ = topicUnhideUserMutationResponseFragmentModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TopicUnhideUserMutationResponseFragmentModel.class, new Serializer());
            }
        }

        public TopicUnhideUserMutationResponseFragmentModel() {
            super(1);
        }

        @Nullable
        private String m19038a() {
            this.f15049d = super.a(this.f15049d, 0);
            return this.f15049d;
        }

        public final int jK_() {
            return 426462488;
        }

        public final GraphQLVisitableModel m19040a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m19039a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m19038a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
