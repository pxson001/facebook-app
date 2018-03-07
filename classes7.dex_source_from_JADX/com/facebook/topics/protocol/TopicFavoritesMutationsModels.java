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
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.topics.protocol.TopicFavoritesMutationsParsers.SetOfFavoritesMutationFragmentParser;
import com.facebook.topics.protocol.TopicFavoritesMutationsParsers.SetOfFavoritesMutationFragmentParser.TopicsParser;
import com.facebook.topics.protocol.TopicFavoritesMutationsParsers.SingleFavoriteMutationFragmentParser;
import com.facebook.topics.protocol.TopicFavoritesMutationsParsers.SingleFavoriteMutationFragmentParser.TopicParser;
import com.facebook.topics.protocol.TopicFavoritesMutationsParsers.VideoChannelSetPinStateMutationParser;
import com.facebook.topics.protocol.TopicFavoritesMutationsParsers.VideoChannelSetPinStateMutationParser.VideoChannelParser;
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

/* compiled from: extra_questions */
public class TopicFavoritesMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -517864089)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_questions */
    public final class SetOfFavoritesMutationFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<TopicsModel> f14992d;

        /* compiled from: extra_questions */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SetOfFavoritesMutationFragmentModel.class, new Deserializer());
            }

            public Object m18861a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SetOfFavoritesMutationFragmentParser.m18912a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object setOfFavoritesMutationFragmentModel = new SetOfFavoritesMutationFragmentModel();
                ((BaseModel) setOfFavoritesMutationFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (setOfFavoritesMutationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) setOfFavoritesMutationFragmentModel).a();
                }
                return setOfFavoritesMutationFragmentModel;
            }
        }

        /* compiled from: extra_questions */
        public class Serializer extends JsonSerializer<SetOfFavoritesMutationFragmentModel> {
            public final void m18862a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SetOfFavoritesMutationFragmentModel setOfFavoritesMutationFragmentModel = (SetOfFavoritesMutationFragmentModel) obj;
                if (setOfFavoritesMutationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(setOfFavoritesMutationFragmentModel.m18875a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    setOfFavoritesMutationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = setOfFavoritesMutationFragmentModel.w_();
                int u_ = setOfFavoritesMutationFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("topics");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        TopicsParser.m18910a(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SetOfFavoritesMutationFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 292773573)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: extra_questions */
        public final class TopicsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f14990d;
            private boolean f14991e;

            /* compiled from: extra_questions */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TopicsModel.class, new Deserializer());
                }

                public Object m18863a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TopicsParser.m18911b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object topicsModel = new TopicsModel();
                    ((BaseModel) topicsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (topicsModel instanceof Postprocessable) {
                        return ((Postprocessable) topicsModel).a();
                    }
                    return topicsModel;
                }
            }

            /* compiled from: extra_questions */
            public class Serializer extends JsonSerializer<TopicsModel> {
                public final void m18864a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TopicsModel topicsModel = (TopicsModel) obj;
                    if (topicsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(topicsModel.m18868a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        topicsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TopicsParser.m18910a(topicsModel.w_(), topicsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TopicsModel.class, new Serializer());
                }
            }

            public TopicsModel() {
                super(2);
            }

            public final void m18872a(String str, ConsistencyTuple consistencyTuple) {
                if ("is_favorited".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m18867k());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m18873a(String str, Object obj, boolean z) {
                if ("is_favorited".equals(str)) {
                    m18865a(((Boolean) obj).booleanValue());
                }
            }

            @Nullable
            private String m18866j() {
                this.f14990d = super.a(this.f14990d, 0);
                return this.f14990d;
            }

            private boolean m18867k() {
                a(0, 1);
                return this.f14991e;
            }

            private void m18865a(boolean z) {
                this.f14991e = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, z);
                }
            }

            @Nullable
            public final String m18870a() {
                return m18866j();
            }

            public final int jK_() {
                return 218987185;
            }

            public final GraphQLVisitableModel m18869a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m18868a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m18866j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f14991e);
                i();
                return flatBufferBuilder.d();
            }

            public final void m18871a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f14991e = mutableFlatBuffer.a(i, 1);
            }
        }

        public SetOfFavoritesMutationFragmentModel() {
            super(1);
        }

        @Nonnull
        private ImmutableList<TopicsModel> m18874a() {
            this.f14992d = super.a(this.f14992d, 0, TopicsModel.class);
            return (ImmutableList) this.f14992d;
        }

        public final int jK_() {
            return 316281172;
        }

        public final GraphQLVisitableModel m18876a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18874a() != null) {
                Builder a = ModelHelper.a(m18874a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (SetOfFavoritesMutationFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14992d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18875a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18874a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -717642238)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_questions */
    public final class SingleFavoriteMutationFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private TopicModel f14995d;

        /* compiled from: extra_questions */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SingleFavoriteMutationFragmentModel.class, new Deserializer());
            }

            public Object m18877a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SingleFavoriteMutationFragmentParser.m18915a(jsonParser);
                Object singleFavoriteMutationFragmentModel = new SingleFavoriteMutationFragmentModel();
                ((BaseModel) singleFavoriteMutationFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (singleFavoriteMutationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) singleFavoriteMutationFragmentModel).a();
                }
                return singleFavoriteMutationFragmentModel;
            }
        }

        /* compiled from: extra_questions */
        public class Serializer extends JsonSerializer<SingleFavoriteMutationFragmentModel> {
            public final void m18878a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SingleFavoriteMutationFragmentModel singleFavoriteMutationFragmentModel = (SingleFavoriteMutationFragmentModel) obj;
                if (singleFavoriteMutationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(singleFavoriteMutationFragmentModel.m18891a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    singleFavoriteMutationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = singleFavoriteMutationFragmentModel.w_();
                int u_ = singleFavoriteMutationFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("topic");
                    TopicParser.m18914a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SingleFavoriteMutationFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 292773573)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: extra_questions */
        public final class TopicModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f14993d;
            private boolean f14994e;

            /* compiled from: extra_questions */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TopicModel.class, new Deserializer());
                }

                public Object m18879a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TopicParser.m18913a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object topicModel = new TopicModel();
                    ((BaseModel) topicModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (topicModel instanceof Postprocessable) {
                        return ((Postprocessable) topicModel).a();
                    }
                    return topicModel;
                }
            }

            /* compiled from: extra_questions */
            public class Serializer extends JsonSerializer<TopicModel> {
                public final void m18880a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TopicModel topicModel = (TopicModel) obj;
                    if (topicModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(topicModel.m18884a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        topicModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TopicParser.m18914a(topicModel.w_(), topicModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TopicModel.class, new Serializer());
                }
            }

            public TopicModel() {
                super(2);
            }

            public final void m18888a(String str, ConsistencyTuple consistencyTuple) {
                if ("is_favorited".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m18883k());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m18889a(String str, Object obj, boolean z) {
                if ("is_favorited".equals(str)) {
                    m18881a(((Boolean) obj).booleanValue());
                }
            }

            @Nullable
            private String m18882j() {
                this.f14993d = super.a(this.f14993d, 0);
                return this.f14993d;
            }

            private boolean m18883k() {
                a(0, 1);
                return this.f14994e;
            }

            private void m18881a(boolean z) {
                this.f14994e = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, z);
                }
            }

            @Nullable
            public final String m18886a() {
                return m18882j();
            }

            public final int jK_() {
                return 218987185;
            }

            public final GraphQLVisitableModel m18885a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m18884a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m18882j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f14994e);
                i();
                return flatBufferBuilder.d();
            }

            public final void m18887a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f14994e = mutableFlatBuffer.a(i, 1);
            }
        }

        public SingleFavoriteMutationFragmentModel() {
            super(1);
        }

        @Nullable
        private TopicModel m18890a() {
            this.f14995d = (TopicModel) super.a(this.f14995d, 0, TopicModel.class);
            return this.f14995d;
        }

        public final int jK_() {
            return 1226697608;
        }

        public final GraphQLVisitableModel m18892a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18890a() != null) {
                TopicModel topicModel = (TopicModel) graphQLModelMutatingVisitor.b(m18890a());
                if (m18890a() != topicModel) {
                    graphQLVisitableModel = (SingleFavoriteMutationFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14995d = topicModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18891a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18890a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -249969597)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_questions */
    public final class VideoChannelSetPinStateMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private VideoChannelModel f14999d;

        /* compiled from: extra_questions */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(VideoChannelSetPinStateMutationModel.class, new Deserializer());
            }

            public Object m18893a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = VideoChannelSetPinStateMutationParser.m18918a(jsonParser);
                Object videoChannelSetPinStateMutationModel = new VideoChannelSetPinStateMutationModel();
                ((BaseModel) videoChannelSetPinStateMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (videoChannelSetPinStateMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) videoChannelSetPinStateMutationModel).a();
                }
                return videoChannelSetPinStateMutationModel;
            }
        }

        /* compiled from: extra_questions */
        public class Serializer extends JsonSerializer<VideoChannelSetPinStateMutationModel> {
            public final void m18894a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                VideoChannelSetPinStateMutationModel videoChannelSetPinStateMutationModel = (VideoChannelSetPinStateMutationModel) obj;
                if (videoChannelSetPinStateMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(videoChannelSetPinStateMutationModel.m18908a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    videoChannelSetPinStateMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = videoChannelSetPinStateMutationModel.w_();
                int u_ = videoChannelSetPinStateMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("video_channel");
                    VideoChannelParser.m18917a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(VideoChannelSetPinStateMutationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2119024809)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: extra_questions */
        public final class VideoChannelModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f14996d;
            @Nullable
            private String f14997e;
            private boolean f14998f;

            /* compiled from: extra_questions */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VideoChannelModel.class, new Deserializer());
                }

                public Object m18895a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VideoChannelParser.m18916a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object videoChannelModel = new VideoChannelModel();
                    ((BaseModel) videoChannelModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (videoChannelModel instanceof Postprocessable) {
                        return ((Postprocessable) videoChannelModel).a();
                    }
                    return videoChannelModel;
                }
            }

            /* compiled from: extra_questions */
            public class Serializer extends JsonSerializer<VideoChannelModel> {
                public final void m18896a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VideoChannelModel videoChannelModel = (VideoChannelModel) obj;
                    if (videoChannelModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(videoChannelModel.m18901a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        videoChannelModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VideoChannelParser.m18917a(videoChannelModel.w_(), videoChannelModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(VideoChannelModel.class, new Serializer());
                }
            }

            public VideoChannelModel() {
                super(3);
            }

            public final void m18905a(String str, ConsistencyTuple consistencyTuple) {
                if ("video_channel_is_viewer_pinned".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m18900l());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m18906a(String str, Object obj, boolean z) {
                if ("video_channel_is_viewer_pinned".equals(str)) {
                    m18897a(((Boolean) obj).booleanValue());
                }
            }

            @Nullable
            private GraphQLObjectType m18898j() {
                if (this.b != null && this.f14996d == null) {
                    this.f14996d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f14996d;
            }

            @Nullable
            private String m18899k() {
                this.f14997e = super.a(this.f14997e, 1);
                return this.f14997e;
            }

            private boolean m18900l() {
                a(0, 2);
                return this.f14998f;
            }

            private void m18897a(boolean z) {
                this.f14998f = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, z);
                }
            }

            @Nullable
            public final String m18903a() {
                return m18899k();
            }

            public final int jK_() {
                return 756114472;
            }

            public final GraphQLVisitableModel m18902a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m18901a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m18898j());
                int b = flatBufferBuilder.b(m18899k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.a(2, this.f14998f);
                i();
                return flatBufferBuilder.d();
            }

            public final void m18904a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f14998f = mutableFlatBuffer.a(i, 2);
            }
        }

        public VideoChannelSetPinStateMutationModel() {
            super(1);
        }

        @Nullable
        private VideoChannelModel m18907a() {
            this.f14999d = (VideoChannelModel) super.a(this.f14999d, 0, VideoChannelModel.class);
            return this.f14999d;
        }

        public final int jK_() {
            return 1791598071;
        }

        public final GraphQLVisitableModel m18909a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18907a() != null) {
                VideoChannelModel videoChannelModel = (VideoChannelModel) graphQLModelMutatingVisitor.b(m18907a());
                if (m18907a() != videoChannelModel) {
                    graphQLVisitableModel = (VideoChannelSetPinStateMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14999d = videoChannelModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18908a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18907a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
