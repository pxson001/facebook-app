package com.facebook.api.graphql.reactions;

import com.facebook.api.graphql.reactions.FetchReactorsGraphQLParsers.DefaultFeedbackReactorsFieldsParser;
import com.facebook.api.graphql.reactions.FetchReactorsGraphQLParsers.DefaultReactorsEdgeFieldsParser;
import com.facebook.api.graphql.reactions.FetchReactorsGraphQLParsers.DefaultReactorsEdgeFieldsParser.FeedbackReactionInfoParser;
import com.facebook.api.graphql.reactions.FetchReactorsGraphQLParsers.DefaultReactorsEdgeFieldsParser.NodeParser;
import com.facebook.api.graphql.reactions.FetchReactorsGraphQLParsers.DefaultReactorsProfileFieldsParser;
import com.facebook.api.graphql.reactions.FetchReactorsGraphQLParsers.DefaultReactorsProfileFieldsParser.MutualFriendsParser;
import com.facebook.api.graphql.reactions.FetchReactorsGraphQLParsers.ReactorsOfFeedbackFieldParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
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

/* compiled from: android_place_tips */
public class FetchReactorsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 709796552)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_tips */
    public final class DefaultFeedbackReactorsFieldsModel extends BaseModel implements GraphQLVisitableModel {
        private int f9762d;
        @Nullable
        private List<DefaultReactorsEdgeFieldsModel> f9763e;
        @Nullable
        private DefaultPageInfoFieldsModel f9764f;

        /* compiled from: android_place_tips */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultFeedbackReactorsFieldsModel.class, new Deserializer());
            }

            public Object m16920a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(DefaultFeedbackReactorsFieldsParser.m16981a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object defaultFeedbackReactorsFieldsModel = new DefaultFeedbackReactorsFieldsModel();
                ((BaseModel) defaultFeedbackReactorsFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (defaultFeedbackReactorsFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultFeedbackReactorsFieldsModel).a();
                }
                return defaultFeedbackReactorsFieldsModel;
            }
        }

        /* compiled from: android_place_tips */
        public class Serializer extends JsonSerializer<DefaultFeedbackReactorsFieldsModel> {
            public final void m16921a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                DefaultFeedbackReactorsFieldsModel defaultFeedbackReactorsFieldsModel = (DefaultFeedbackReactorsFieldsModel) obj;
                if (defaultFeedbackReactorsFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultFeedbackReactorsFieldsModel.m16925a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultFeedbackReactorsFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                DefaultFeedbackReactorsFieldsParser.m16982a(defaultFeedbackReactorsFieldsModel.w_(), defaultFeedbackReactorsFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(DefaultFeedbackReactorsFieldsModel.class, new Serializer());
            }
        }

        public DefaultFeedbackReactorsFieldsModel() {
            super(3);
        }

        public final int m16924a() {
            a(0, 0);
            return this.f9762d;
        }

        public final void m16927a(int i) {
            this.f9762d = i;
            if (this.b != null && this.b.d) {
                this.b.b(this.c, 0, i);
            }
        }

        @Nonnull
        private ImmutableList<DefaultReactorsEdgeFieldsModel> m16922j() {
            this.f9763e = super.a(this.f9763e, 1, DefaultReactorsEdgeFieldsModel.class);
            return (ImmutableList) this.f9763e;
        }

        @Nullable
        private DefaultPageInfoFieldsModel m16923k() {
            this.f9764f = (DefaultPageInfoFieldsModel) super.a(this.f9764f, 2, DefaultPageInfoFieldsModel.class);
            return this.f9764f;
        }

        public final int jK_() {
            return 256909871;
        }

        public final GraphQLVisitableModel m16926a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
            h();
            if (m16922j() != null) {
                Builder a = ModelHelper.a(m16922j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    DefaultFeedbackReactorsFieldsModel defaultFeedbackReactorsFieldsModel = (DefaultFeedbackReactorsFieldsModel) ModelHelper.a(null, this);
                    defaultFeedbackReactorsFieldsModel.f9763e = a.b();
                    graphQLVisitableModel = defaultFeedbackReactorsFieldsModel;
                    if (m16923k() != null) {
                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m16923k());
                        if (m16923k() != defaultPageInfoFieldsModel) {
                            graphQLVisitableModel = (DefaultFeedbackReactorsFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9764f = defaultPageInfoFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m16923k() != null) {
                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m16923k());
                if (m16923k() != defaultPageInfoFieldsModel) {
                    graphQLVisitableModel = (DefaultFeedbackReactorsFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9764f = defaultPageInfoFieldsModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m16925a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16922j());
            int a2 = ModelHelper.a(flatBufferBuilder, m16923k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f9762d, 0);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16928a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9762d = mutableFlatBuffer.a(i, 0, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1805314663)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_tips */
    public final class DefaultReactorsEdgeFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FeedbackReactionInfoModel f9773d;
        @Nullable
        private NodeModel f9774e;

        /* compiled from: android_place_tips */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultReactorsEdgeFieldsModel.class, new Deserializer());
            }

            public Object m16929a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(DefaultReactorsEdgeFieldsParser.m16987b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object defaultReactorsEdgeFieldsModel = new DefaultReactorsEdgeFieldsModel();
                ((BaseModel) defaultReactorsEdgeFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (defaultReactorsEdgeFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultReactorsEdgeFieldsModel).a();
                }
                return defaultReactorsEdgeFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 224127441)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_tips */
        public final class FeedbackReactionInfoModel extends BaseModel implements GraphQLVisitableModel {
            private int f9765d;

            /* compiled from: android_place_tips */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FeedbackReactionInfoModel.class, new Deserializer());
                }

                public Object m16930a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FeedbackReactionInfoParser.m16983a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object feedbackReactionInfoModel = new FeedbackReactionInfoModel();
                    ((BaseModel) feedbackReactionInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (feedbackReactionInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) feedbackReactionInfoModel).a();
                    }
                    return feedbackReactionInfoModel;
                }
            }

            /* compiled from: android_place_tips */
            public class Serializer extends JsonSerializer<FeedbackReactionInfoModel> {
                public final void m16931a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FeedbackReactionInfoModel feedbackReactionInfoModel = (FeedbackReactionInfoModel) obj;
                    if (feedbackReactionInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(feedbackReactionInfoModel.m16932a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        feedbackReactionInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FeedbackReactionInfoParser.m16984a(feedbackReactionInfoModel.w_(), feedbackReactionInfoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FeedbackReactionInfoModel.class, new Serializer());
                }
            }

            public FeedbackReactionInfoModel() {
                super(1);
            }

            public final int jK_() {
                return -1654469956;
            }

            public final GraphQLVisitableModel m16933a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16932a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f9765d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m16934a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9765d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -101355996)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_tips */
        public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f9766d;
            @Nullable
            private GraphQLFriendshipStatus f9767e;
            @Nullable
            private String f9768f;
            private boolean f9769g;
            @Nullable
            private MutualFriendsModel f9770h;
            @Nullable
            private String f9771i;
            @Nullable
            private DefaultImageFieldsModel f9772j;

            /* compiled from: android_place_tips */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                }

                public Object m16935a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NodeParser.m16985a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object nodeModel = new NodeModel();
                    ((BaseModel) nodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (nodeModel instanceof Postprocessable) {
                        return ((Postprocessable) nodeModel).a();
                    }
                    return nodeModel;
                }
            }

            /* compiled from: android_place_tips */
            public class Serializer extends JsonSerializer<NodeModel> {
                public final void m16936a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NodeModel nodeModel = (NodeModel) obj;
                    if (nodeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(nodeModel.m16944a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NodeParser.m16986a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(NodeModel.class, new Serializer());
                }
            }

            public NodeModel() {
                super(7);
            }

            public final void m16948a(String str, ConsistencyTuple consistencyTuple) {
                if ("friendship_status".equals(str)) {
                    consistencyTuple.a = m16939k();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m16949a(String str, Object obj, boolean z) {
                if ("friendship_status".equals(str)) {
                    m16937a((GraphQLFriendshipStatus) obj);
                }
            }

            @Nullable
            private GraphQLObjectType m16938j() {
                if (this.b != null && this.f9766d == null) {
                    this.f9766d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f9766d;
            }

            @Nullable
            private GraphQLFriendshipStatus m16939k() {
                this.f9767e = (GraphQLFriendshipStatus) super.b(this.f9767e, 1, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f9767e;
            }

            private void m16937a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
                this.f9767e = graphQLFriendshipStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
                }
            }

            @Nullable
            private String m16940l() {
                this.f9768f = super.a(this.f9768f, 2);
                return this.f9768f;
            }

            @Nullable
            private MutualFriendsModel m16941m() {
                this.f9770h = (MutualFriendsModel) super.a(this.f9770h, 4, MutualFriendsModel.class);
                return this.f9770h;
            }

            @Nullable
            private String m16942n() {
                this.f9771i = super.a(this.f9771i, 5);
                return this.f9771i;
            }

            @Nullable
            private DefaultImageFieldsModel m16943o() {
                this.f9772j = (DefaultImageFieldsModel) super.a(this.f9772j, 6, DefaultImageFieldsModel.class);
                return this.f9772j;
            }

            @Nullable
            public final String m16946a() {
                return m16940l();
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m16945a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16941m() != null) {
                    MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) graphQLModelMutatingVisitor.b(m16941m());
                    if (m16941m() != mutualFriendsModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9770h = mutualFriendsModel;
                    }
                }
                if (m16943o() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16943o());
                    if (m16943o() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9772j = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16944a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16938j());
                int a2 = flatBufferBuilder.a(m16939k());
                int b = flatBufferBuilder.b(m16940l());
                int a3 = ModelHelper.a(flatBufferBuilder, m16941m());
                int b2 = flatBufferBuilder.b(m16942n());
                int a4 = ModelHelper.a(flatBufferBuilder, m16943o());
                flatBufferBuilder.c(7);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.a(3, this.f9769g);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, b2);
                flatBufferBuilder.b(6, a4);
                i();
                return flatBufferBuilder.d();
            }

            public final void m16947a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9769g = mutableFlatBuffer.a(i, 3);
            }
        }

        /* compiled from: android_place_tips */
        public class Serializer extends JsonSerializer<DefaultReactorsEdgeFieldsModel> {
            public final void m16950a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                DefaultReactorsEdgeFieldsModel defaultReactorsEdgeFieldsModel = (DefaultReactorsEdgeFieldsModel) obj;
                if (defaultReactorsEdgeFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultReactorsEdgeFieldsModel.m16953a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultReactorsEdgeFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                DefaultReactorsEdgeFieldsParser.m16988b(defaultReactorsEdgeFieldsModel.w_(), defaultReactorsEdgeFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(DefaultReactorsEdgeFieldsModel.class, new Serializer());
            }
        }

        public DefaultReactorsEdgeFieldsModel() {
            super(2);
        }

        @Nullable
        private FeedbackReactionInfoModel m16951a() {
            this.f9773d = (FeedbackReactionInfoModel) super.a(this.f9773d, 0, FeedbackReactionInfoModel.class);
            return this.f9773d;
        }

        @Nullable
        private NodeModel m16952j() {
            this.f9774e = (NodeModel) super.a(this.f9774e, 1, NodeModel.class);
            return this.f9774e;
        }

        public final int jK_() {
            return 717758926;
        }

        public final GraphQLVisitableModel m16954a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16951a() != null) {
                FeedbackReactionInfoModel feedbackReactionInfoModel = (FeedbackReactionInfoModel) graphQLModelMutatingVisitor.b(m16951a());
                if (m16951a() != feedbackReactionInfoModel) {
                    graphQLVisitableModel = (DefaultReactorsEdgeFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9773d = feedbackReactionInfoModel;
                }
            }
            if (m16952j() != null) {
                NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m16952j());
                if (m16952j() != nodeModel) {
                    graphQLVisitableModel = (DefaultReactorsEdgeFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9774e = nodeModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16953a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16951a());
            int a2 = ModelHelper.a(flatBufferBuilder, m16952j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1253000409)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_tips */
    public final class DefaultReactorsProfileFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f9776d;
        @Nullable
        private GraphQLFriendshipStatus f9777e;
        @Nullable
        private String f9778f;
        @Nullable
        private MutualFriendsModel f9779g;
        @Nullable
        private String f9780h;
        @Nullable
        private DefaultImageFieldsModel f9781i;

        /* compiled from: android_place_tips */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultReactorsProfileFieldsModel.class, new Deserializer());
            }

            public Object m16955a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = DefaultReactorsProfileFieldsParser.m16991a(jsonParser);
                Object defaultReactorsProfileFieldsModel = new DefaultReactorsProfileFieldsModel();
                ((BaseModel) defaultReactorsProfileFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (defaultReactorsProfileFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultReactorsProfileFieldsModel).a();
                }
                return defaultReactorsProfileFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_place_tips */
        public final class MutualFriendsModel extends BaseModel implements GraphQLVisitableModel {
            private int f9775d;

            /* compiled from: android_place_tips */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MutualFriendsModel.class, new Deserializer());
                }

                public Object m16956a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MutualFriendsParser.m16989a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mutualFriendsModel = new MutualFriendsModel();
                    ((BaseModel) mutualFriendsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (mutualFriendsModel instanceof Postprocessable) {
                        return ((Postprocessable) mutualFriendsModel).a();
                    }
                    return mutualFriendsModel;
                }
            }

            /* compiled from: android_place_tips */
            public class Serializer extends JsonSerializer<MutualFriendsModel> {
                public final void m16957a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) obj;
                    if (mutualFriendsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mutualFriendsModel.m16958a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutualFriendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MutualFriendsParser.m16990a(mutualFriendsModel.w_(), mutualFriendsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MutualFriendsModel.class, new Serializer());
                }
            }

            public MutualFriendsModel() {
                super(1);
            }

            public final int jK_() {
                return 1532278911;
            }

            public final GraphQLVisitableModel m16959a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16958a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f9775d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m16960a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9775d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: android_place_tips */
        public class Serializer extends JsonSerializer<DefaultReactorsProfileFieldsModel> {
            public final void m16961a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                DefaultReactorsProfileFieldsModel defaultReactorsProfileFieldsModel = (DefaultReactorsProfileFieldsModel) obj;
                if (defaultReactorsProfileFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultReactorsProfileFieldsModel.m16969a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultReactorsProfileFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = defaultReactorsProfileFieldsModel.w_();
                int u_ = defaultReactorsProfileFieldsModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("friendship_status");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 1));
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                int g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("mutual_friends");
                    MutualFriendsParser.m16990a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 4) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 4));
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(DefaultReactorsProfileFieldsModel.class, new Serializer());
            }
        }

        public DefaultReactorsProfileFieldsModel() {
            super(6);
        }

        public final void m16972a(String str, ConsistencyTuple consistencyTuple) {
            if ("friendship_status".equals(str)) {
                consistencyTuple.a = m16964k();
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
                return;
            }
            consistencyTuple.a();
        }

        public final void m16973a(String str, Object obj, boolean z) {
            if ("friendship_status".equals(str)) {
                m16962a((GraphQLFriendshipStatus) obj);
            }
        }

        @Nullable
        private GraphQLObjectType m16963j() {
            if (this.b != null && this.f9776d == null) {
                this.f9776d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f9776d;
        }

        @Nullable
        private GraphQLFriendshipStatus m16964k() {
            this.f9777e = (GraphQLFriendshipStatus) super.b(this.f9777e, 1, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f9777e;
        }

        private void m16962a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
            this.f9777e = graphQLFriendshipStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
            }
        }

        @Nullable
        private String m16965l() {
            this.f9778f = super.a(this.f9778f, 2);
            return this.f9778f;
        }

        @Nullable
        private MutualFriendsModel m16966m() {
            this.f9779g = (MutualFriendsModel) super.a(this.f9779g, 3, MutualFriendsModel.class);
            return this.f9779g;
        }

        @Nullable
        private String m16967n() {
            this.f9780h = super.a(this.f9780h, 4);
            return this.f9780h;
        }

        @Nullable
        private DefaultImageFieldsModel m16968o() {
            this.f9781i = (DefaultImageFieldsModel) super.a(this.f9781i, 5, DefaultImageFieldsModel.class);
            return this.f9781i;
        }

        @Nullable
        public final String m16971a() {
            return m16965l();
        }

        public final int jK_() {
            return 1355227529;
        }

        public final GraphQLVisitableModel m16970a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16966m() != null) {
                MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) graphQLModelMutatingVisitor.b(m16966m());
                if (m16966m() != mutualFriendsModel) {
                    graphQLVisitableModel = (DefaultReactorsProfileFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9779g = mutualFriendsModel;
                }
            }
            if (m16968o() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16968o());
                if (m16968o() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (DefaultReactorsProfileFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9781i = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16969a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16963j());
            int a2 = flatBufferBuilder.a(m16964k());
            int b = flatBufferBuilder.b(m16965l());
            int a3 = ModelHelper.a(flatBufferBuilder, m16966m());
            int b2 = flatBufferBuilder.b(m16967n());
            int a4 = ModelHelper.a(flatBufferBuilder, m16968o());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, a4);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 541786456)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_tips */
    public final class ReactorsOfFeedbackFieldModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private DefaultFeedbackReactorsFieldsModel f9782d;

        /* compiled from: android_place_tips */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactorsOfFeedbackFieldModel.class, new Deserializer());
            }

            public Object m16974a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactorsOfFeedbackFieldParser.m16992a(jsonParser);
                Object reactorsOfFeedbackFieldModel = new ReactorsOfFeedbackFieldModel();
                ((BaseModel) reactorsOfFeedbackFieldModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactorsOfFeedbackFieldModel instanceof Postprocessable) {
                    return ((Postprocessable) reactorsOfFeedbackFieldModel).a();
                }
                return reactorsOfFeedbackFieldModel;
            }
        }

        /* compiled from: android_place_tips */
        public class Serializer extends JsonSerializer<ReactorsOfFeedbackFieldModel> {
            public final void m16975a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactorsOfFeedbackFieldModel reactorsOfFeedbackFieldModel = (ReactorsOfFeedbackFieldModel) obj;
                if (reactorsOfFeedbackFieldModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactorsOfFeedbackFieldModel.m16977a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactorsOfFeedbackFieldModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactorsOfFeedbackFieldModel.w_();
                int u_ = reactorsOfFeedbackFieldModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("reactors");
                    DefaultFeedbackReactorsFieldsParser.m16982a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactorsOfFeedbackFieldModel.class, new Serializer());
            }
        }

        public ReactorsOfFeedbackFieldModel() {
            super(1);
        }

        public final void m16979a(String str, ConsistencyTuple consistencyTuple) {
            if ("reactors.count".equals(str)) {
                DefaultFeedbackReactorsFieldsModel a = m16976a();
                if (a != null) {
                    consistencyTuple.a = Integer.valueOf(a.m16924a());
                    consistencyTuple.b = a.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            }
            consistencyTuple.a();
        }

        public final void m16980a(String str, Object obj, boolean z) {
            if ("reactors.count".equals(str)) {
                DefaultFeedbackReactorsFieldsModel a = m16976a();
                if (a == null) {
                    return;
                }
                if (z) {
                    a = (DefaultFeedbackReactorsFieldsModel) a.clone();
                    a.m16927a(((Integer) obj).intValue());
                    this.f9782d = a;
                    return;
                }
                a.m16927a(((Integer) obj).intValue());
            }
        }

        @Nullable
        private DefaultFeedbackReactorsFieldsModel m16976a() {
            this.f9782d = (DefaultFeedbackReactorsFieldsModel) super.a(this.f9782d, 0, DefaultFeedbackReactorsFieldsModel.class);
            return this.f9782d;
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m16978a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16976a() != null) {
                DefaultFeedbackReactorsFieldsModel defaultFeedbackReactorsFieldsModel = (DefaultFeedbackReactorsFieldsModel) graphQLModelMutatingVisitor.b(m16976a());
                if (m16976a() != defaultFeedbackReactorsFieldsModel) {
                    graphQLVisitableModel = (ReactorsOfFeedbackFieldModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9782d = defaultFeedbackReactorsFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16977a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16976a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
