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
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.topics.protocol.TopicClassificationQueryParsers.TopicClassificationQueryParser;
import com.facebook.topics.protocol.TopicClassificationQueryParsers.TopicClassificationQueryParser.PredictedFeedTopicsParser;
import com.facebook.topics.protocol.TopicClassificationQueryParsers.TopicClassificationQueryParser.PredictedFeedTopicsParser.FeedTopicParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: extra_text */
public class TopicClassificationQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1478550149)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_text */
    public final class TopicClassificationQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<PredictedFeedTopicsModel> f14989d;

        /* compiled from: extra_text */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TopicClassificationQueryModel.class, new Deserializer());
            }

            public Object m18832a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TopicClassificationQueryParser.m18858a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object topicClassificationQueryModel = new TopicClassificationQueryModel();
                ((BaseModel) topicClassificationQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (topicClassificationQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) topicClassificationQueryModel).a();
                }
                return topicClassificationQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1928076844)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: extra_text */
        public final class PredictedFeedTopicsModel extends BaseModel implements GraphQLVisitableModel {
            private double f14986d;
            @Nullable
            private String f14987e;
            @Nullable
            private FeedTopicModel f14988f;

            /* compiled from: extra_text */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PredictedFeedTopicsModel.class, new Deserializer());
                }

                public Object m18833a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PredictedFeedTopicsParser.m18856b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object predictedFeedTopicsModel = new PredictedFeedTopicsModel();
                    ((BaseModel) predictedFeedTopicsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (predictedFeedTopicsModel instanceof Postprocessable) {
                        return ((Postprocessable) predictedFeedTopicsModel).a();
                    }
                    return predictedFeedTopicsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1185712657)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: extra_text */
            public final class FeedTopicModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f14984d;
                @Nullable
                private String f14985e;

                /* compiled from: extra_text */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(FeedTopicModel.class, new Deserializer());
                    }

                    public Object m18834a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FeedTopicParser.m18854a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object feedTopicModel = new FeedTopicModel();
                        ((BaseModel) feedTopicModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (feedTopicModel instanceof Postprocessable) {
                            return ((Postprocessable) feedTopicModel).a();
                        }
                        return feedTopicModel;
                    }
                }

                /* compiled from: extra_text */
                public class Serializer extends JsonSerializer<FeedTopicModel> {
                    public final void m18835a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        FeedTopicModel feedTopicModel = (FeedTopicModel) obj;
                        if (feedTopicModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(feedTopicModel.m18836a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            feedTopicModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FeedTopicParser.m18855a(feedTopicModel.w_(), feedTopicModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(FeedTopicModel.class, new Serializer());
                    }
                }

                public FeedTopicModel() {
                    super(2);
                }

                public final void m18839a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m18840a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final String m18841b() {
                    this.f14984d = super.a(this.f14984d, 0);
                    return this.f14984d;
                }

                @Nullable
                public final String m18842c() {
                    this.f14985e = super.a(this.f14985e, 1);
                    return this.f14985e;
                }

                @Nullable
                public final String m18838a() {
                    return m18841b();
                }

                public final int jK_() {
                    return 218987185;
                }

                public final GraphQLVisitableModel m18837a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m18836a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m18841b());
                    int b2 = flatBufferBuilder.b(m18842c());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: extra_text */
            public class Serializer extends JsonSerializer<PredictedFeedTopicsModel> {
                public final void m18843a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PredictedFeedTopicsModel predictedFeedTopicsModel = (PredictedFeedTopicsModel) obj;
                    if (predictedFeedTopicsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(predictedFeedTopicsModel.m18845a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        predictedFeedTopicsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PredictedFeedTopicsParser.m18857b(predictedFeedTopicsModel.w_(), predictedFeedTopicsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PredictedFeedTopicsModel.class, new Serializer());
                }
            }

            public PredictedFeedTopicsModel() {
                super(3);
            }

            public final double m18844a() {
                a(0, 0);
                return this.f14986d;
            }

            @Nullable
            public final String m18848j() {
                this.f14987e = super.a(this.f14987e, 1);
                return this.f14987e;
            }

            @Nullable
            public final FeedTopicModel m18849k() {
                this.f14988f = (FeedTopicModel) super.a(this.f14988f, 2, FeedTopicModel.class);
                return this.f14988f;
            }

            public final int jK_() {
                return -844329831;
            }

            public final GraphQLVisitableModel m18846a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m18849k() != null) {
                    FeedTopicModel feedTopicModel = (FeedTopicModel) graphQLModelMutatingVisitor.b(m18849k());
                    if (m18849k() != feedTopicModel) {
                        graphQLVisitableModel = (PredictedFeedTopicsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f14988f = feedTopicModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m18845a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m18848j());
                int a = ModelHelper.a(flatBufferBuilder, m18849k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f14986d, 0.0d);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m18847a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f14986d = mutableFlatBuffer.a(i, 0, 0.0d);
            }
        }

        /* compiled from: extra_text */
        public class Serializer extends JsonSerializer<TopicClassificationQueryModel> {
            public final void m18850a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TopicClassificationQueryModel topicClassificationQueryModel = (TopicClassificationQueryModel) obj;
                if (topicClassificationQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(topicClassificationQueryModel.m18851a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    topicClassificationQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = topicClassificationQueryModel.w_();
                int u_ = topicClassificationQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("predicted_feed_topics");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        PredictedFeedTopicsParser.m18857b(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TopicClassificationQueryModel.class, new Serializer());
            }
        }

        public TopicClassificationQueryModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<PredictedFeedTopicsModel> m18853a() {
            this.f14989d = super.a(this.f14989d, 0, PredictedFeedTopicsModel.class);
            return (ImmutableList) this.f14989d;
        }

        public final int jK_() {
            return 1318437024;
        }

        public final GraphQLVisitableModel m18852a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18853a() != null) {
                Builder a = ModelHelper.a(m18853a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (TopicClassificationQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14989d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18851a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18853a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
