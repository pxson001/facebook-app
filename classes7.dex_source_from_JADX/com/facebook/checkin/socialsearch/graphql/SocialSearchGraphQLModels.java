package com.facebook.checkin.socialsearch.graphql;

import com.facebook.api.graphql.actor.NewsFeedActorGraphQLModels.DefaultProfileFieldsModel;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLParsers.PlaceListDetailsParser;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLParsers.PlaceListDetailsParser.ListItemsParser;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLParsers.PlaceListDetailsParser.ListItemsParser.NodesParser;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLParsers.PlaceListDetailsParser.ListItemsParser.NodesParser.RecommendingCommentsParser;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLParsers.PlaceRecommendationPageFieldsParser;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLParsers.RecommendingCommentFieldsParser;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLParsers.RecommendingCommentFieldsParser.BodyParser;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLParsers.StoryConversionDetailsParser;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLParsers.StoryConversionDetailsParser.PlaceRecommendationInfoParser;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLParsers.StoryConversionDetailsParser.PlaceRecommendationInfoParser.PlaceEntitiesParser;
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
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultLocationFieldsModel;
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

/* compiled from: unhide topic from user failed */
public class SocialSearchGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1374564539)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: unhide topic from user failed */
    public final class PlaceListDetailsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f1108d;
        @Nullable
        private ListItemsModel f1109e;
        @Nullable
        private String f1110f;

        /* compiled from: unhide topic from user failed */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PlaceListDetailsModel.class, new Deserializer());
            }

            public Object m1092a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PlaceListDetailsParser.m1224a(jsonParser);
                Object placeListDetailsModel = new PlaceListDetailsModel();
                ((BaseModel) placeListDetailsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (placeListDetailsModel instanceof Postprocessable) {
                    return ((Postprocessable) placeListDetailsModel).a();
                }
                return placeListDetailsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -618194095)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: unhide topic from user failed */
        public final class ListItemsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f1107d;

            /* compiled from: unhide topic from user failed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ListItemsModel.class, new Deserializer());
                }

                public Object m1093a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ListItemsParser.m1222a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object listItemsModel = new ListItemsModel();
                    ((BaseModel) listItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (listItemsModel instanceof Postprocessable) {
                        return ((Postprocessable) listItemsModel).a();
                    }
                    return listItemsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 286532111)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: unhide topic from user failed */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private String f1104d;
                @Nullable
                private PlaceRecommendationPageFieldsModel f1105e;
                @Nullable
                private RecommendingCommentsModel f1106f;

                /* compiled from: unhide topic from user failed */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m1094a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m1220b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1287584299)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: unhide topic from user failed */
                public final class RecommendingCommentsModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<RecommendingCommentFieldsModel> f1103d;

                    /* compiled from: unhide topic from user failed */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(RecommendingCommentsModel.class, new Deserializer());
                        }

                        public Object m1095a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(RecommendingCommentsParser.m1218a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object recommendingCommentsModel = new RecommendingCommentsModel();
                            ((BaseModel) recommendingCommentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (recommendingCommentsModel instanceof Postprocessable) {
                                return ((Postprocessable) recommendingCommentsModel).a();
                            }
                            return recommendingCommentsModel;
                        }
                    }

                    /* compiled from: unhide topic from user failed */
                    public class Serializer extends JsonSerializer<RecommendingCommentsModel> {
                        public final void m1096a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            RecommendingCommentsModel recommendingCommentsModel = (RecommendingCommentsModel) obj;
                            if (recommendingCommentsModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(recommendingCommentsModel.m1098a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                recommendingCommentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            RecommendingCommentsParser.m1219a(recommendingCommentsModel.w_(), recommendingCommentsModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(RecommendingCommentsModel.class, new Serializer());
                        }
                    }

                    public RecommendingCommentsModel() {
                        super(1);
                    }

                    @Nonnull
                    private ImmutableList<RecommendingCommentFieldsModel> m1097a() {
                        this.f1103d = super.a(this.f1103d, 0, RecommendingCommentFieldsModel.class);
                        return (ImmutableList) this.f1103d;
                    }

                    public final int jK_() {
                        return -1143816053;
                    }

                    public final GraphQLVisitableModel m1099a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m1097a() != null) {
                            Builder a = ModelHelper.a(m1097a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (RecommendingCommentsModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f1103d = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m1098a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m1097a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: unhide topic from user failed */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m1100a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m1103a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m1221b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(3);
                }

                @Nullable
                private String m1101k() {
                    this.f1104d = super.a(this.f1104d, 0);
                    return this.f1104d;
                }

                @Nullable
                public final PlaceRecommendationPageFieldsModel m1106j() {
                    this.f1105e = (PlaceRecommendationPageFieldsModel) super.a(this.f1105e, 1, PlaceRecommendationPageFieldsModel.class);
                    return this.f1105e;
                }

                @Nullable
                private RecommendingCommentsModel m1102l() {
                    this.f1106f = (RecommendingCommentsModel) super.a(this.f1106f, 2, RecommendingCommentsModel.class);
                    return this.f1106f;
                }

                @Nullable
                public final String m1105a() {
                    return m1101k();
                }

                public final int jK_() {
                    return 2113705688;
                }

                public final GraphQLVisitableModel m1104a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m1106j() != null) {
                        PlaceRecommendationPageFieldsModel placeRecommendationPageFieldsModel = (PlaceRecommendationPageFieldsModel) graphQLModelMutatingVisitor.b(m1106j());
                        if (m1106j() != placeRecommendationPageFieldsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f1105e = placeRecommendationPageFieldsModel;
                        }
                    }
                    if (m1102l() != null) {
                        RecommendingCommentsModel recommendingCommentsModel = (RecommendingCommentsModel) graphQLModelMutatingVisitor.b(m1102l());
                        if (m1102l() != recommendingCommentsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f1106f = recommendingCommentsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m1103a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m1101k());
                    int a = ModelHelper.a(flatBufferBuilder, m1106j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m1102l());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: unhide topic from user failed */
            public class Serializer extends JsonSerializer<ListItemsModel> {
                public final void m1107a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ListItemsModel listItemsModel = (ListItemsModel) obj;
                    if (listItemsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(listItemsModel.m1108a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        listItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ListItemsParser.m1223a(listItemsModel.w_(), listItemsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ListItemsModel.class, new Serializer());
                }
            }

            public ListItemsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m1110a() {
                this.f1107d = super.a(this.f1107d, 0, NodesModel.class);
                return (ImmutableList) this.f1107d;
            }

            public final int jK_() {
                return 614558686;
            }

            public final GraphQLVisitableModel m1109a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1110a() != null) {
                    Builder a = ModelHelper.a(m1110a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ListItemsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1107d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1108a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1110a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: unhide topic from user failed */
        public class Serializer extends JsonSerializer<PlaceListDetailsModel> {
            public final void m1111a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PlaceListDetailsModel placeListDetailsModel = (PlaceListDetailsModel) obj;
                if (placeListDetailsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(placeListDetailsModel.m1114a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    placeListDetailsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = placeListDetailsModel.w_();
                int u_ = placeListDetailsModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("list_items");
                    ListItemsParser.m1223a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("place_list_title");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PlaceListDetailsModel.class, new Serializer());
            }
        }

        public PlaceListDetailsModel() {
            super(3);
        }

        @Nullable
        private String m1112k() {
            this.f1108d = super.a(this.f1108d, 0);
            return this.f1108d;
        }

        @Nullable
        public final ListItemsModel m1117j() {
            this.f1109e = (ListItemsModel) super.a(this.f1109e, 1, ListItemsModel.class);
            return this.f1109e;
        }

        @Nullable
        private String m1113l() {
            this.f1110f = super.a(this.f1110f, 2);
            return this.f1110f;
        }

        @Nullable
        public final String m1116a() {
            return m1112k();
        }

        public final int jK_() {
            return -499039707;
        }

        public final GraphQLVisitableModel m1115a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1117j() != null) {
                ListItemsModel listItemsModel = (ListItemsModel) graphQLModelMutatingVisitor.b(m1117j());
                if (m1117j() != listItemsModel) {
                    graphQLVisitableModel = (PlaceListDetailsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1109e = listItemsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1114a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m1112k());
            int a = ModelHelper.a(flatBufferBuilder, m1117j());
            int b2 = flatBufferBuilder.b(m1113l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1137390974)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: unhide topic from user failed */
    public final class PlaceRecommendationPageFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f1111d;
        @Nullable
        private DefaultLocationFieldsModel f1112e;
        @Nullable
        private String f1113f;

        /* compiled from: unhide topic from user failed */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PlaceRecommendationPageFieldsModel.class, new Deserializer());
            }

            public Object m1118a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PlaceRecommendationPageFieldsParser.m1225a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object placeRecommendationPageFieldsModel = new PlaceRecommendationPageFieldsModel();
                ((BaseModel) placeRecommendationPageFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (placeRecommendationPageFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) placeRecommendationPageFieldsModel).a();
                }
                return placeRecommendationPageFieldsModel;
            }
        }

        /* compiled from: unhide topic from user failed */
        public class Serializer extends JsonSerializer<PlaceRecommendationPageFieldsModel> {
            public final void m1119a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PlaceRecommendationPageFieldsModel placeRecommendationPageFieldsModel = (PlaceRecommendationPageFieldsModel) obj;
                if (placeRecommendationPageFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(placeRecommendationPageFieldsModel.m1121a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    placeRecommendationPageFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PlaceRecommendationPageFieldsParser.m1226a(placeRecommendationPageFieldsModel.w_(), placeRecommendationPageFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PlaceRecommendationPageFieldsModel.class, new Serializer());
            }
        }

        public PlaceRecommendationPageFieldsModel() {
            super(3);
        }

        public final void m1124a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m1125a(String str, Object obj, boolean z) {
        }

        @Nullable
        private String m1120l() {
            this.f1111d = super.a(this.f1111d, 0);
            return this.f1111d;
        }

        @Nullable
        public final DefaultLocationFieldsModel m1126j() {
            this.f1112e = (DefaultLocationFieldsModel) super.a(this.f1112e, 1, DefaultLocationFieldsModel.class);
            return this.f1112e;
        }

        @Nullable
        public final String m1127k() {
            this.f1113f = super.a(this.f1113f, 2);
            return this.f1113f;
        }

        @Nullable
        public final String m1123a() {
            return m1120l();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m1122a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1126j() != null) {
                DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m1126j());
                if (m1126j() != defaultLocationFieldsModel) {
                    graphQLVisitableModel = (PlaceRecommendationPageFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1112e = defaultLocationFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1121a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m1120l());
            int a = ModelHelper.a(flatBufferBuilder, m1126j());
            int b2 = flatBufferBuilder.b(m1127k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -31114660)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: unhide topic from user failed */
    public final class RecommendingCommentFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private DefaultProfileFieldsModel f1115d;
        @Nullable
        private BodyModel f1116e;
        @Nullable
        private String f1117f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: unhide topic from user failed */
        public final class BodyModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1114d;

            /* compiled from: unhide topic from user failed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(BodyModel.class, new Deserializer());
                }

                public Object m1128a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BodyParser.m1227a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object bodyModel = new BodyModel();
                    ((BaseModel) bodyModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (bodyModel instanceof Postprocessable) {
                        return ((Postprocessable) bodyModel).a();
                    }
                    return bodyModel;
                }
            }

            /* compiled from: unhide topic from user failed */
            public class Serializer extends JsonSerializer<BodyModel> {
                public final void m1129a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    BodyModel bodyModel = (BodyModel) obj;
                    if (bodyModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(bodyModel.m1131a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        bodyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BodyParser.m1228a(bodyModel.w_(), bodyModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(BodyModel.class, new Serializer());
                }
            }

            public BodyModel() {
                super(1);
            }

            @Nullable
            private String m1130a() {
                this.f1114d = super.a(this.f1114d, 0);
                return this.f1114d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m1132a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1131a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1130a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: unhide topic from user failed */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RecommendingCommentFieldsModel.class, new Deserializer());
            }

            public Object m1133a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RecommendingCommentFieldsParser.m1229b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object recommendingCommentFieldsModel = new RecommendingCommentFieldsModel();
                ((BaseModel) recommendingCommentFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (recommendingCommentFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) recommendingCommentFieldsModel).a();
                }
                return recommendingCommentFieldsModel;
            }
        }

        /* compiled from: unhide topic from user failed */
        public class Serializer extends JsonSerializer<RecommendingCommentFieldsModel> {
            public final void m1134a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RecommendingCommentFieldsModel recommendingCommentFieldsModel = (RecommendingCommentFieldsModel) obj;
                if (recommendingCommentFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(recommendingCommentFieldsModel.m1138a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    recommendingCommentFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RecommendingCommentFieldsParser.m1230b(recommendingCommentFieldsModel.w_(), recommendingCommentFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(RecommendingCommentFieldsModel.class, new Serializer());
            }
        }

        public RecommendingCommentFieldsModel() {
            super(3);
        }

        @Nullable
        private DefaultProfileFieldsModel m1135j() {
            this.f1115d = (DefaultProfileFieldsModel) super.a(this.f1115d, 0, DefaultProfileFieldsModel.class);
            return this.f1115d;
        }

        @Nullable
        private BodyModel m1136k() {
            this.f1116e = (BodyModel) super.a(this.f1116e, 1, BodyModel.class);
            return this.f1116e;
        }

        @Nullable
        private String m1137l() {
            this.f1117f = super.a(this.f1117f, 2);
            return this.f1117f;
        }

        @Nullable
        public final String m1140a() {
            return m1137l();
        }

        public final int jK_() {
            return -1679915457;
        }

        public final GraphQLVisitableModel m1139a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1135j() != null) {
                DefaultProfileFieldsModel defaultProfileFieldsModel = (DefaultProfileFieldsModel) graphQLModelMutatingVisitor.b(m1135j());
                if (m1135j() != defaultProfileFieldsModel) {
                    graphQLVisitableModel = (RecommendingCommentFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1115d = defaultProfileFieldsModel;
                }
            }
            if (m1136k() != null) {
                BodyModel bodyModel = (BodyModel) graphQLModelMutatingVisitor.b(m1136k());
                if (m1136k() != bodyModel) {
                    graphQLVisitableModel = (RecommendingCommentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1116e = bodyModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1138a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1135j());
            int a2 = ModelHelper.a(flatBufferBuilder, m1136k());
            int b = flatBufferBuilder.b(m1137l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -467537342)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: unhide topic from user failed */
    public final class StoryConversionDetailsModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private PlaceRecommendationInfoModel f1122d;

        /* compiled from: unhide topic from user failed */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StoryConversionDetailsModel.class, new Deserializer());
            }

            public Object m1141a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = StoryConversionDetailsParser.m1235a(jsonParser);
                Object storyConversionDetailsModel = new StoryConversionDetailsModel();
                ((BaseModel) storyConversionDetailsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (storyConversionDetailsModel instanceof Postprocessable) {
                    return ((Postprocessable) storyConversionDetailsModel).a();
                }
                return storyConversionDetailsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1160668499)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: unhide topic from user failed */
        public final class PlaceRecommendationInfoModel extends BaseModel implements GraphQLVisitableModel {
            private double f1120d;
            @Nullable
            private List<PlaceEntitiesModel> f1121e;

            /* compiled from: unhide topic from user failed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PlaceRecommendationInfoModel.class, new Deserializer());
                }

                public Object m1142a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlaceRecommendationInfoParser.m1233a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object placeRecommendationInfoModel = new PlaceRecommendationInfoModel();
                    ((BaseModel) placeRecommendationInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (placeRecommendationInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) placeRecommendationInfoModel).a();
                    }
                    return placeRecommendationInfoModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1185712657)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: unhide topic from user failed */
            public final class PlaceEntitiesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f1118d;
                @Nullable
                private String f1119e;

                /* compiled from: unhide topic from user failed */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PlaceEntitiesModel.class, new Deserializer());
                    }

                    public Object m1143a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PlaceEntitiesParser.m1232b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object placeEntitiesModel = new PlaceEntitiesModel();
                        ((BaseModel) placeEntitiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (placeEntitiesModel instanceof Postprocessable) {
                            return ((Postprocessable) placeEntitiesModel).a();
                        }
                        return placeEntitiesModel;
                    }
                }

                /* compiled from: unhide topic from user failed */
                public class Serializer extends JsonSerializer<PlaceEntitiesModel> {
                    public final void m1144a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PlaceEntitiesModel placeEntitiesModel = (PlaceEntitiesModel) obj;
                        if (placeEntitiesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(placeEntitiesModel.m1145a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            placeEntitiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PlaceEntitiesParser.m1231a(placeEntitiesModel.w_(), placeEntitiesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PlaceEntitiesModel.class, new Serializer());
                    }
                }

                public PlaceEntitiesModel() {
                    super(2);
                }

                public final void m1148a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m1149a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final String m1150j() {
                    this.f1118d = super.a(this.f1118d, 0);
                    return this.f1118d;
                }

                @Nullable
                public final String m1151k() {
                    this.f1119e = super.a(this.f1119e, 1);
                    return this.f1119e;
                }

                @Nullable
                public final String m1147a() {
                    return m1150j();
                }

                public final int jK_() {
                    return 2479791;
                }

                public final GraphQLVisitableModel m1146a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m1145a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m1150j());
                    int b2 = flatBufferBuilder.b(m1151k());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: unhide topic from user failed */
            public class Serializer extends JsonSerializer<PlaceRecommendationInfoModel> {
                public final void m1152a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PlaceRecommendationInfoModel placeRecommendationInfoModel = (PlaceRecommendationInfoModel) obj;
                    if (placeRecommendationInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(placeRecommendationInfoModel.m1153a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        placeRecommendationInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlaceRecommendationInfoParser.m1234a(placeRecommendationInfoModel.w_(), placeRecommendationInfoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PlaceRecommendationInfoModel.class, new Serializer());
                }
            }

            public PlaceRecommendationInfoModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<PlaceEntitiesModel> m1155a() {
                this.f1121e = super.a(this.f1121e, 1, PlaceEntitiesModel.class);
                return (ImmutableList) this.f1121e;
            }

            public final int jK_() {
                return -248522226;
            }

            public final GraphQLVisitableModel m1154a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1155a() != null) {
                    Builder a = ModelHelper.a(m1155a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PlaceRecommendationInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1121e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1153a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1155a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f1120d, 0.0d);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m1156a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1120d = mutableFlatBuffer.a(i, 0, 0.0d);
            }
        }

        /* compiled from: unhide topic from user failed */
        public class Serializer extends JsonSerializer<StoryConversionDetailsModel> {
            public final void m1157a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                StoryConversionDetailsModel storyConversionDetailsModel = (StoryConversionDetailsModel) obj;
                if (storyConversionDetailsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(storyConversionDetailsModel.m1158a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    storyConversionDetailsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = storyConversionDetailsModel.w_();
                int u_ = storyConversionDetailsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("place_recommendation_info");
                    PlaceRecommendationInfoParser.m1234a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(StoryConversionDetailsModel.class, new Serializer());
            }
        }

        public StoryConversionDetailsModel() {
            super(1);
        }

        public final void m1161a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m1162a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final PlaceRecommendationInfoModel m1159a() {
            this.f1122d = (PlaceRecommendationInfoModel) super.a(this.f1122d, 0, PlaceRecommendationInfoModel.class);
            return this.f1122d;
        }

        public final int jK_() {
            return 80218325;
        }

        public final GraphQLVisitableModel m1160a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1159a() != null) {
                PlaceRecommendationInfoModel placeRecommendationInfoModel = (PlaceRecommendationInfoModel) graphQLModelMutatingVisitor.b(m1159a());
                if (m1159a() != placeRecommendationInfoModel) {
                    graphQLVisitableModel = (StoryConversionDetailsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1122d = placeRecommendationInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1158a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1159a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
