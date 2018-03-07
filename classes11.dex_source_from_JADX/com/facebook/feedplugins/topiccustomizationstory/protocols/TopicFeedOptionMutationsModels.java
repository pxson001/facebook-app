package com.facebook.feedplugins.topiccustomizationstory.protocols;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLModels.TrueTopicFeedOptionFragmentModel;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLParsers.TrueTopicFeedOptionFragmentParser;
import com.facebook.feedplugins.topiccustomizationstory.protocols.TopicFeedOptionMutationsParsers.TopicFeedOptionDeselectMutationParser;
import com.facebook.feedplugins.topiccustomizationstory.protocols.TopicFeedOptionMutationsParsers.TopicFeedOptionSelectMutationParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: android.net.ProxyProperties */
public class TopicFeedOptionMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2089010673)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android.net.ProxyProperties */
    public final class TopicFeedOptionDeselectMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<TrueTopicFeedOptionFragmentModel> f9981d;

        /* compiled from: android.net.ProxyProperties */
        public final class Builder {
            @Nullable
            public ImmutableList<TrueTopicFeedOptionFragmentModel> f9980a;
        }

        /* compiled from: android.net.ProxyProperties */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TopicFeedOptionDeselectMutationModel.class, new Deserializer());
            }

            public Object m10333a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TopicFeedOptionDeselectMutationParser.m10343a(jsonParser);
                Object topicFeedOptionDeselectMutationModel = new TopicFeedOptionDeselectMutationModel();
                ((BaseModel) topicFeedOptionDeselectMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (topicFeedOptionDeselectMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) topicFeedOptionDeselectMutationModel).a();
                }
                return topicFeedOptionDeselectMutationModel;
            }
        }

        /* compiled from: android.net.ProxyProperties */
        public class Serializer extends JsonSerializer<TopicFeedOptionDeselectMutationModel> {
            public final void m10334a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TopicFeedOptionDeselectMutationModel topicFeedOptionDeselectMutationModel = (TopicFeedOptionDeselectMutationModel) obj;
                if (topicFeedOptionDeselectMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(topicFeedOptionDeselectMutationModel.m10336a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    topicFeedOptionDeselectMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = topicFeedOptionDeselectMutationModel.w_();
                int u_ = topicFeedOptionDeselectMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("options");
                    TrueTopicFeedOptionFragmentParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TopicFeedOptionDeselectMutationModel.class, new Serializer());
            }
        }

        public TopicFeedOptionDeselectMutationModel() {
            super(1);
        }

        public TopicFeedOptionDeselectMutationModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nonnull
        private ImmutableList<TrueTopicFeedOptionFragmentModel> m10335a() {
            this.f9981d = super.a(this.f9981d, 0, TrueTopicFeedOptionFragmentModel.class);
            return (ImmutableList) this.f9981d;
        }

        public final int jK_() {
            return 2136286990;
        }

        public final GraphQLVisitableModel m10337a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10335a() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m10335a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (TopicFeedOptionDeselectMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9981d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10336a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10335a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2089010673)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android.net.ProxyProperties */
    public final class TopicFeedOptionSelectMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<TrueTopicFeedOptionFragmentModel> f9983d;

        /* compiled from: android.net.ProxyProperties */
        public final class Builder {
            @Nullable
            public ImmutableList<TrueTopicFeedOptionFragmentModel> f9982a;
        }

        /* compiled from: android.net.ProxyProperties */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TopicFeedOptionSelectMutationModel.class, new Deserializer());
            }

            public Object m10338a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TopicFeedOptionSelectMutationParser.m10344a(jsonParser);
                Object topicFeedOptionSelectMutationModel = new TopicFeedOptionSelectMutationModel();
                ((BaseModel) topicFeedOptionSelectMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (topicFeedOptionSelectMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) topicFeedOptionSelectMutationModel).a();
                }
                return topicFeedOptionSelectMutationModel;
            }
        }

        /* compiled from: android.net.ProxyProperties */
        public class Serializer extends JsonSerializer<TopicFeedOptionSelectMutationModel> {
            public final void m10339a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TopicFeedOptionSelectMutationModel topicFeedOptionSelectMutationModel = (TopicFeedOptionSelectMutationModel) obj;
                if (topicFeedOptionSelectMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(topicFeedOptionSelectMutationModel.m10341a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    topicFeedOptionSelectMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = topicFeedOptionSelectMutationModel.w_();
                int u_ = topicFeedOptionSelectMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("options");
                    TrueTopicFeedOptionFragmentParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TopicFeedOptionSelectMutationModel.class, new Serializer());
            }
        }

        public TopicFeedOptionSelectMutationModel() {
            super(1);
        }

        public TopicFeedOptionSelectMutationModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nonnull
        private ImmutableList<TrueTopicFeedOptionFragmentModel> m10340a() {
            this.f9983d = super.a(this.f9983d, 0, TrueTopicFeedOptionFragmentModel.class);
            return (ImmutableList) this.f9983d;
        }

        public final int jK_() {
            return -1040879505;
        }

        public final GraphQLVisitableModel m10342a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10340a() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m10340a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (TopicFeedOptionSelectMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9983d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10341a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10340a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
