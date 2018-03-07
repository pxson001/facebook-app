package com.facebook.pages.common.protocol.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLAdproLimitResetPeriod;
import com.facebook.graphql.enums.GraphQLBoostedActionStatus;
import com.facebook.graphql.enums.GraphQLBoostedComponentStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPageActivityFeedType;
import com.facebook.graphql.enums.GraphQLPageCallToActionType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLParsers.FetchPageActivityQueryParser;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLParsers.FetchPageActivityQueryParser.ActivityAdminInfoParser;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLParsers.FetchPageActivityQueryParser.ActivityAdminInfoParser.AllDraftPostsParser;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLParsers.FetchPageActivityQueryParser.ActivityAdminInfoParser.AllScheduledPostsParser;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLParsers.FetchPageActivityQueryParser.ActivityAdminInfoParser.BoostedLocalAwarenessPromotionsParser;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLParsers.FetchPageActivityQueryParser.ActivityAdminInfoParser.BoostedLocalAwarenessPromotionsParser.NodesParser;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLParsers.FetchPageActivityQueryParser.ActivityAdminInfoParser.BoostedPageLikePromotionInfoParser;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLParsers.FetchPageActivityQueryParser.ActivityAdminInfoParser.PageContactUsLeadsParser;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLParsers.FetchPageActivityQueryParser.ActivityAdminInfoParser.PageInsightsSummaryParser;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLParsers.FetchPageActivityQueryParser.ActivityFeedsParser;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLParsers.FetchPageActivityQueryParser.PageCallToActionParser;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLParsers.FetchPageActivityQueryParser.PageCallToActionParser.CtaAdminInfoParser;
import com.facebook.pages.data.graphql.notificationcounts.FetchNotificationCountsGraphQLModels$PageNotificationCountsModel.AdminInfoModel;
import com.facebook.pages.data.graphql.notificationcounts.FetchNotificationCountsGraphQLModels$PageNotificationCountsModel.PageLikersModel;
import com.facebook.pages.data.graphql.notificationcounts.FetchNotificationCountsGraphQLParsers.PageNotificationCountsParser.AdminInfoParser;
import com.facebook.pages.data.graphql.notificationcounts.FetchNotificationCountsGraphQLParsers.PageNotificationCountsParser.PageLikersParser;
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

/* compiled from: setPredictedTopics */
public class FetchPageActivityGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -436644446)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: setPredictedTopics */
    public final class FetchPageActivityQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f1802d;
        @Nullable
        private ActivityAdminInfoModel f1803e;
        @Nullable
        private List<ActivityFeedsModel> f1804f;
        @Nullable
        private AdminInfoModel f1805g;
        @Nullable
        private String f1806h;
        @Nullable
        private PageCallToActionModel f1807i;
        @Nullable
        private PageLikersModel f1808j;
        private boolean f1809k;
        private boolean f1810l;
        private boolean f1811m;
        private boolean f1812n;
        private boolean f1813o;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1765727639)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: setPredictedTopics */
        public final class ActivityAdminInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private AllDraftPostsModel f1787d;
            @Nullable
            private AllScheduledPostsModel f1788e;
            @Nullable
            private String f1789f;
            @Nullable
            private BoostedLocalAwarenessPromotionsModel f1790g;
            @Nullable
            private BoostedPageLikePromotionInfoModel f1791h;
            @Nullable
            private String f1792i;
            private boolean f1793j;
            private boolean f1794k;
            @Nullable
            private PageContactUsLeadsModel f1795l;
            @Nullable
            private PageInsightsSummaryModel f1796m;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: setPredictedTopics */
            public final class AllDraftPostsModel extends BaseModel implements GraphQLVisitableModel {
                private int f1771d;

                /* compiled from: setPredictedTopics */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AllDraftPostsModel.class, new Deserializer());
                    }

                    public Object m2689a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AllDraftPostsParser.m2786a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object allDraftPostsModel = new AllDraftPostsModel();
                        ((BaseModel) allDraftPostsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (allDraftPostsModel instanceof Postprocessable) {
                            return ((Postprocessable) allDraftPostsModel).a();
                        }
                        return allDraftPostsModel;
                    }
                }

                /* compiled from: setPredictedTopics */
                public class Serializer extends JsonSerializer<AllDraftPostsModel> {
                    public final void m2690a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AllDraftPostsModel allDraftPostsModel = (AllDraftPostsModel) obj;
                        if (allDraftPostsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(allDraftPostsModel.m2692a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            allDraftPostsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AllDraftPostsParser.m2787a(allDraftPostsModel.w_(), allDraftPostsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(AllDraftPostsModel.class, new Serializer());
                    }
                }

                public AllDraftPostsModel() {
                    super(1);
                }

                public final int m2691a() {
                    a(0, 0);
                    return this.f1771d;
                }

                public final int jK_() {
                    return -1445101999;
                }

                public final GraphQLVisitableModel m2693a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2692a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f1771d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m2694a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f1771d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: setPredictedTopics */
            public final class AllScheduledPostsModel extends BaseModel implements GraphQLVisitableModel {
                private int f1772d;

                /* compiled from: setPredictedTopics */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AllScheduledPostsModel.class, new Deserializer());
                    }

                    public Object m2695a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AllScheduledPostsParser.m2788a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object allScheduledPostsModel = new AllScheduledPostsModel();
                        ((BaseModel) allScheduledPostsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (allScheduledPostsModel instanceof Postprocessable) {
                            return ((Postprocessable) allScheduledPostsModel).a();
                        }
                        return allScheduledPostsModel;
                    }
                }

                /* compiled from: setPredictedTopics */
                public class Serializer extends JsonSerializer<AllScheduledPostsModel> {
                    public final void m2696a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AllScheduledPostsModel allScheduledPostsModel = (AllScheduledPostsModel) obj;
                        if (allScheduledPostsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(allScheduledPostsModel.m2698a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            allScheduledPostsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AllScheduledPostsParser.m2789a(allScheduledPostsModel.w_(), allScheduledPostsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(AllScheduledPostsModel.class, new Serializer());
                    }
                }

                public AllScheduledPostsModel() {
                    super(1);
                }

                public final int m2697a() {
                    a(0, 0);
                    return this.f1772d;
                }

                public final int jK_() {
                    return 1175143749;
                }

                public final GraphQLVisitableModel m2699a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2698a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f1772d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m2700a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f1772d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1433920637)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: setPredictedTopics */
            public final class BoostedLocalAwarenessPromotionsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<NodesModel> f1774d;

                /* compiled from: setPredictedTopics */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(BoostedLocalAwarenessPromotionsModel.class, new Deserializer());
                    }

                    public Object m2701a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(BoostedLocalAwarenessPromotionsParser.m2792a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object boostedLocalAwarenessPromotionsModel = new BoostedLocalAwarenessPromotionsModel();
                        ((BaseModel) boostedLocalAwarenessPromotionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (boostedLocalAwarenessPromotionsModel instanceof Postprocessable) {
                            return ((Postprocessable) boostedLocalAwarenessPromotionsModel).a();
                        }
                        return boostedLocalAwarenessPromotionsModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1776418157)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: setPredictedTopics */
                public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private GraphQLBoostedComponentStatus f1773d;

                    /* compiled from: setPredictedTopics */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                        }

                        public Object m2702a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodesParser.m2791b(jsonParser, flatBufferBuilder));
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

                    /* compiled from: setPredictedTopics */
                    public class Serializer extends JsonSerializer<NodesModel> {
                        public final void m2703a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodesModel nodesModel = (NodesModel) obj;
                            if (nodesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodesModel.m2704a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodesParser.m2790a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(NodesModel.class, new Serializer());
                        }
                    }

                    public NodesModel() {
                        super(1);
                    }

                    @Nullable
                    public final GraphQLBoostedComponentStatus m2705a() {
                        this.f1773d = (GraphQLBoostedComponentStatus) super.b(this.f1773d, 0, GraphQLBoostedComponentStatus.class, GraphQLBoostedComponentStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f1773d;
                    }

                    public final int jK_() {
                        return -47218757;
                    }

                    public final GraphQLVisitableModel m2706a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m2704a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = flatBufferBuilder.a(m2705a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: setPredictedTopics */
                public class Serializer extends JsonSerializer<BoostedLocalAwarenessPromotionsModel> {
                    public final void m2707a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        BoostedLocalAwarenessPromotionsModel boostedLocalAwarenessPromotionsModel = (BoostedLocalAwarenessPromotionsModel) obj;
                        if (boostedLocalAwarenessPromotionsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(boostedLocalAwarenessPromotionsModel.m2708a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            boostedLocalAwarenessPromotionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        BoostedLocalAwarenessPromotionsParser.m2793a(boostedLocalAwarenessPromotionsModel.w_(), boostedLocalAwarenessPromotionsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(BoostedLocalAwarenessPromotionsModel.class, new Serializer());
                    }
                }

                public BoostedLocalAwarenessPromotionsModel() {
                    super(1);
                }

                @Nonnull
                public final ImmutableList<NodesModel> m2710a() {
                    this.f1774d = super.a(this.f1774d, 0, NodesModel.class);
                    return (ImmutableList) this.f1774d;
                }

                public final int jK_() {
                    return -187331336;
                }

                public final GraphQLVisitableModel m2709a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m2710a() != null) {
                        Builder a = ModelHelper.a(m2710a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (BoostedLocalAwarenessPromotionsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f1774d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m2708a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m2710a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -891388526)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: setPredictedTopics */
            public final class BoostedPageLikePromotionInfoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLBoostedActionStatus f1775d;
                @Nullable
                private String f1776e;
                private boolean f1777f;
                private int f1778g;
                private int f1779h;
                @Nullable
                private GraphQLAdproLimitResetPeriod f1780i;
                @Nullable
                private String f1781j;
                private long f1782k;
                private long f1783l;

                /* compiled from: setPredictedTopics */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(BoostedPageLikePromotionInfoModel.class, new Deserializer());
                    }

                    public Object m2711a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(BoostedPageLikePromotionInfoParser.m2794a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object boostedPageLikePromotionInfoModel = new BoostedPageLikePromotionInfoModel();
                        ((BaseModel) boostedPageLikePromotionInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (boostedPageLikePromotionInfoModel instanceof Postprocessable) {
                            return ((Postprocessable) boostedPageLikePromotionInfoModel).a();
                        }
                        return boostedPageLikePromotionInfoModel;
                    }
                }

                /* compiled from: setPredictedTopics */
                public class Serializer extends JsonSerializer<BoostedPageLikePromotionInfoModel> {
                    public final void m2712a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        BoostedPageLikePromotionInfoModel boostedPageLikePromotionInfoModel = (BoostedPageLikePromotionInfoModel) obj;
                        if (boostedPageLikePromotionInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(boostedPageLikePromotionInfoModel.m2713a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            boostedPageLikePromotionInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        BoostedPageLikePromotionInfoParser.m2795a(boostedPageLikePromotionInfoModel.w_(), boostedPageLikePromotionInfoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(BoostedPageLikePromotionInfoModel.class, new Serializer());
                    }
                }

                public BoostedPageLikePromotionInfoModel() {
                    super(9);
                }

                @Nullable
                public final GraphQLBoostedActionStatus m2714a() {
                    this.f1775d = (GraphQLBoostedActionStatus) super.b(this.f1775d, 0, GraphQLBoostedActionStatus.class, GraphQLBoostedActionStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f1775d;
                }

                @Nullable
                public final String m2717b() {
                    this.f1776e = super.a(this.f1776e, 1);
                    return this.f1776e;
                }

                public final boolean m2718c() {
                    a(0, 2);
                    return this.f1777f;
                }

                public final int m2719d() {
                    a(0, 3);
                    return this.f1778g;
                }

                public final int mU_() {
                    a(0, 4);
                    return this.f1779h;
                }

                @Nullable
                public final GraphQLAdproLimitResetPeriod m2720g() {
                    this.f1780i = (GraphQLAdproLimitResetPeriod) super.b(this.f1780i, 5, GraphQLAdproLimitResetPeriod.class, GraphQLAdproLimitResetPeriod.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f1780i;
                }

                @Nullable
                public final String mV_() {
                    this.f1781j = super.a(this.f1781j, 6);
                    return this.f1781j;
                }

                public final long mW_() {
                    a(0, 7);
                    return this.f1782k;
                }

                public final long m2721j() {
                    a(1, 0);
                    return this.f1783l;
                }

                public final int jK_() {
                    return 1766999096;
                }

                public final GraphQLVisitableModel m2715a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2713a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = flatBufferBuilder.a(m2714a());
                    int b = flatBufferBuilder.b(m2717b());
                    int a2 = flatBufferBuilder.a(m2720g());
                    int b2 = flatBufferBuilder.b(mV_());
                    flatBufferBuilder.c(9);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.a(2, this.f1777f);
                    flatBufferBuilder.a(3, this.f1778g, 0);
                    flatBufferBuilder.a(4, this.f1779h, 0);
                    flatBufferBuilder.b(5, a2);
                    flatBufferBuilder.b(6, b2);
                    flatBufferBuilder.a(7, this.f1782k, 0);
                    flatBufferBuilder.a(8, this.f1783l, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m2716a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f1777f = mutableFlatBuffer.a(i, 2);
                    this.f1778g = mutableFlatBuffer.a(i, 3, 0);
                    this.f1779h = mutableFlatBuffer.a(i, 4, 0);
                    this.f1782k = mutableFlatBuffer.a(i, 7, 0);
                    this.f1783l = mutableFlatBuffer.a(i, 8, 0);
                }
            }

            /* compiled from: setPredictedTopics */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ActivityAdminInfoModel.class, new Deserializer());
                }

                public Object m2722a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ActivityAdminInfoParser.m2800a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object activityAdminInfoModel = new ActivityAdminInfoModel();
                    ((BaseModel) activityAdminInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (activityAdminInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) activityAdminInfoModel).a();
                    }
                    return activityAdminInfoModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: setPredictedTopics */
            public final class PageContactUsLeadsModel extends BaseModel implements GraphQLVisitableModel {
                private int f1784d;

                /* compiled from: setPredictedTopics */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageContactUsLeadsModel.class, new Deserializer());
                    }

                    public Object m2723a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PageContactUsLeadsParser.m2796a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pageContactUsLeadsModel = new PageContactUsLeadsModel();
                        ((BaseModel) pageContactUsLeadsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (pageContactUsLeadsModel instanceof Postprocessable) {
                            return ((Postprocessable) pageContactUsLeadsModel).a();
                        }
                        return pageContactUsLeadsModel;
                    }
                }

                /* compiled from: setPredictedTopics */
                public class Serializer extends JsonSerializer<PageContactUsLeadsModel> {
                    public final void m2724a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageContactUsLeadsModel pageContactUsLeadsModel = (PageContactUsLeadsModel) obj;
                        if (pageContactUsLeadsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageContactUsLeadsModel.m2726a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageContactUsLeadsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PageContactUsLeadsParser.m2797a(pageContactUsLeadsModel.w_(), pageContactUsLeadsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PageContactUsLeadsModel.class, new Serializer());
                    }
                }

                public PageContactUsLeadsModel() {
                    super(1);
                }

                public final int m2725a() {
                    a(0, 0);
                    return this.f1784d;
                }

                public final int jK_() {
                    return 1400270310;
                }

                public final GraphQLVisitableModel m2727a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2726a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f1784d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m2728a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f1784d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1089353365)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: setPredictedTopics */
            public final class PageInsightsSummaryModel extends BaseModel implements GraphQLVisitableModel {
                private int f1785d;
                private int f1786e;

                /* compiled from: setPredictedTopics */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageInsightsSummaryModel.class, new Deserializer());
                    }

                    public Object m2729a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PageInsightsSummaryParser.m2798a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pageInsightsSummaryModel = new PageInsightsSummaryModel();
                        ((BaseModel) pageInsightsSummaryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (pageInsightsSummaryModel instanceof Postprocessable) {
                            return ((Postprocessable) pageInsightsSummaryModel).a();
                        }
                        return pageInsightsSummaryModel;
                    }
                }

                /* compiled from: setPredictedTopics */
                public class Serializer extends JsonSerializer<PageInsightsSummaryModel> {
                    public final void m2730a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageInsightsSummaryModel pageInsightsSummaryModel = (PageInsightsSummaryModel) obj;
                        if (pageInsightsSummaryModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageInsightsSummaryModel.m2732a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageInsightsSummaryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PageInsightsSummaryParser.m2799a(pageInsightsSummaryModel.w_(), pageInsightsSummaryModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PageInsightsSummaryModel.class, new Serializer());
                    }
                }

                public PageInsightsSummaryModel() {
                    super(2);
                }

                public final int m2731a() {
                    a(0, 0);
                    return this.f1785d;
                }

                public final int m2735b() {
                    a(0, 1);
                    return this.f1786e;
                }

                public final int jK_() {
                    return 545478812;
                }

                public final GraphQLVisitableModel m2733a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2732a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f1785d, 0);
                    flatBufferBuilder.a(1, this.f1786e, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m2734a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f1785d = mutableFlatBuffer.a(i, 0, 0);
                    this.f1786e = mutableFlatBuffer.a(i, 1, 0);
                }
            }

            /* compiled from: setPredictedTopics */
            public class Serializer extends JsonSerializer<ActivityAdminInfoModel> {
                public final void m2736a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ActivityAdminInfoModel activityAdminInfoModel = (ActivityAdminInfoModel) obj;
                    if (activityAdminInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(activityAdminInfoModel.m2741a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        activityAdminInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ActivityAdminInfoParser.m2801a(activityAdminInfoModel.w_(), activityAdminInfoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ActivityAdminInfoModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ AllDraftPostsModel m2743a() {
                return m2737n();
            }

            @Nullable
            public final /* synthetic */ AllScheduledPostsModel m2745b() {
                return m2738o();
            }

            @Nullable
            public final /* synthetic */ BoostedPageLikePromotionInfoModel m2746c() {
                return m2739p();
            }

            @Nullable
            public final /* synthetic */ PageInsightsSummaryModel m2748g() {
                return m2740q();
            }

            public ActivityAdminInfoModel() {
                super(10);
            }

            @Nullable
            private AllDraftPostsModel m2737n() {
                this.f1787d = (AllDraftPostsModel) super.a(this.f1787d, 0, AllDraftPostsModel.class);
                return this.f1787d;
            }

            @Nullable
            private AllScheduledPostsModel m2738o() {
                this.f1788e = (AllScheduledPostsModel) super.a(this.f1788e, 1, AllScheduledPostsModel.class);
                return this.f1788e;
            }

            @Nullable
            public final String m2749j() {
                this.f1789f = super.a(this.f1789f, 2);
                return this.f1789f;
            }

            @Nullable
            public final BoostedLocalAwarenessPromotionsModel m2750k() {
                this.f1790g = (BoostedLocalAwarenessPromotionsModel) super.a(this.f1790g, 3, BoostedLocalAwarenessPromotionsModel.class);
                return this.f1790g;
            }

            @Nullable
            private BoostedPageLikePromotionInfoModel m2739p() {
                this.f1791h = (BoostedPageLikePromotionInfoModel) super.a(this.f1791h, 4, BoostedPageLikePromotionInfoModel.class);
                return this.f1791h;
            }

            @Nullable
            public final String m2747d() {
                this.f1792i = super.a(this.f1792i, 5);
                return this.f1792i;
            }

            public final boolean mT_() {
                a(0, 6);
                return this.f1793j;
            }

            public final boolean m2751l() {
                a(0, 7);
                return this.f1794k;
            }

            @Nullable
            public final PageContactUsLeadsModel m2752m() {
                this.f1795l = (PageContactUsLeadsModel) super.a(this.f1795l, 8, PageContactUsLeadsModel.class);
                return this.f1795l;
            }

            @Nullable
            private PageInsightsSummaryModel m2740q() {
                this.f1796m = (PageInsightsSummaryModel) super.a(this.f1796m, 9, PageInsightsSummaryModel.class);
                return this.f1796m;
            }

            public final int jK_() {
                return 888797870;
            }

            public final GraphQLVisitableModel m2742a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2737n() != null) {
                    AllDraftPostsModel allDraftPostsModel = (AllDraftPostsModel) graphQLModelMutatingVisitor.b(m2737n());
                    if (m2737n() != allDraftPostsModel) {
                        graphQLVisitableModel = (ActivityAdminInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1787d = allDraftPostsModel;
                    }
                }
                if (m2738o() != null) {
                    AllScheduledPostsModel allScheduledPostsModel = (AllScheduledPostsModel) graphQLModelMutatingVisitor.b(m2738o());
                    if (m2738o() != allScheduledPostsModel) {
                        graphQLVisitableModel = (ActivityAdminInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1788e = allScheduledPostsModel;
                    }
                }
                if (m2750k() != null) {
                    BoostedLocalAwarenessPromotionsModel boostedLocalAwarenessPromotionsModel = (BoostedLocalAwarenessPromotionsModel) graphQLModelMutatingVisitor.b(m2750k());
                    if (m2750k() != boostedLocalAwarenessPromotionsModel) {
                        graphQLVisitableModel = (ActivityAdminInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1790g = boostedLocalAwarenessPromotionsModel;
                    }
                }
                if (m2739p() != null) {
                    BoostedPageLikePromotionInfoModel boostedPageLikePromotionInfoModel = (BoostedPageLikePromotionInfoModel) graphQLModelMutatingVisitor.b(m2739p());
                    if (m2739p() != boostedPageLikePromotionInfoModel) {
                        graphQLVisitableModel = (ActivityAdminInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1791h = boostedPageLikePromotionInfoModel;
                    }
                }
                if (m2752m() != null) {
                    PageContactUsLeadsModel pageContactUsLeadsModel = (PageContactUsLeadsModel) graphQLModelMutatingVisitor.b(m2752m());
                    if (m2752m() != pageContactUsLeadsModel) {
                        graphQLVisitableModel = (ActivityAdminInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1795l = pageContactUsLeadsModel;
                    }
                }
                if (m2740q() != null) {
                    PageInsightsSummaryModel pageInsightsSummaryModel = (PageInsightsSummaryModel) graphQLModelMutatingVisitor.b(m2740q());
                    if (m2740q() != pageInsightsSummaryModel) {
                        graphQLVisitableModel = (ActivityAdminInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1796m = pageInsightsSummaryModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2741a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2737n());
                int a2 = ModelHelper.a(flatBufferBuilder, m2738o());
                int b = flatBufferBuilder.b(m2749j());
                int a3 = ModelHelper.a(flatBufferBuilder, m2750k());
                int a4 = ModelHelper.a(flatBufferBuilder, m2739p());
                int b2 = flatBufferBuilder.b(m2747d());
                int a5 = ModelHelper.a(flatBufferBuilder, m2752m());
                int a6 = ModelHelper.a(flatBufferBuilder, m2740q());
                flatBufferBuilder.c(10);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, a3);
                flatBufferBuilder.b(4, a4);
                flatBufferBuilder.b(5, b2);
                flatBufferBuilder.a(6, this.f1793j);
                flatBufferBuilder.a(7, this.f1794k);
                flatBufferBuilder.b(8, a5);
                flatBufferBuilder.b(9, a6);
                i();
                return flatBufferBuilder.d();
            }

            public final void m2744a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1793j = mutableFlatBuffer.a(i, 6);
                this.f1794k = mutableFlatBuffer.a(i, 7);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 276257607)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: setPredictedTopics */
        public final class ActivityFeedsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLPageActivityFeedType f1797d;
            private int f1798e;

            /* compiled from: setPredictedTopics */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ActivityFeedsModel.class, new Deserializer());
                }

                public Object m2753a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ActivityFeedsParser.m2804b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object activityFeedsModel = new ActivityFeedsModel();
                    ((BaseModel) activityFeedsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (activityFeedsModel instanceof Postprocessable) {
                        return ((Postprocessable) activityFeedsModel).a();
                    }
                    return activityFeedsModel;
                }
            }

            /* compiled from: setPredictedTopics */
            public class Serializer extends JsonSerializer<ActivityFeedsModel> {
                public final void m2754a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ActivityFeedsModel activityFeedsModel = (ActivityFeedsModel) obj;
                    if (activityFeedsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(activityFeedsModel.m2755a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        activityFeedsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ActivityFeedsParser.m2803a(activityFeedsModel.w_(), activityFeedsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ActivityFeedsModel.class, new Serializer());
                }
            }

            public ActivityFeedsModel() {
                super(2);
            }

            @Nullable
            public final GraphQLPageActivityFeedType m2756a() {
                this.f1797d = (GraphQLPageActivityFeedType) super.b(this.f1797d, 0, GraphQLPageActivityFeedType.class, GraphQLPageActivityFeedType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f1797d;
            }

            public final int m2759b() {
                a(0, 1);
                return this.f1798e;
            }

            public final int jK_() {
                return -293549668;
            }

            public final GraphQLVisitableModel m2757a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2755a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m2756a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f1798e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m2758a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1798e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        /* compiled from: setPredictedTopics */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchPageActivityQueryModel.class, new Deserializer());
            }

            public Object m2760a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FetchPageActivityQueryParser.m2809a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fetchPageActivityQueryModel = new FetchPageActivityQueryModel();
                ((BaseModel) fetchPageActivityQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fetchPageActivityQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchPageActivityQueryModel).a();
                }
                return fetchPageActivityQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1402460044)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: setPredictedTopics */
        public final class PageCallToActionModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private CtaAdminInfoModel f1800d;
            @Nullable
            private GraphQLPageCallToActionType f1801e;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -6483680)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: setPredictedTopics */
            public final class CtaAdminInfoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f1799d;

                /* compiled from: setPredictedTopics */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CtaAdminInfoModel.class, new Deserializer());
                    }

                    public Object m2761a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CtaAdminInfoParser.m2805a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object ctaAdminInfoModel = new CtaAdminInfoModel();
                        ((BaseModel) ctaAdminInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (ctaAdminInfoModel instanceof Postprocessable) {
                            return ((Postprocessable) ctaAdminInfoModel).a();
                        }
                        return ctaAdminInfoModel;
                    }
                }

                /* compiled from: setPredictedTopics */
                public class Serializer extends JsonSerializer<CtaAdminInfoModel> {
                    public final void m2762a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CtaAdminInfoModel ctaAdminInfoModel = (CtaAdminInfoModel) obj;
                        if (ctaAdminInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ctaAdminInfoModel.m2764a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            ctaAdminInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CtaAdminInfoParser.m2806a(ctaAdminInfoModel.w_(), ctaAdminInfoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(CtaAdminInfoModel.class, new Serializer());
                    }
                }

                public CtaAdminInfoModel() {
                    super(1);
                }

                @Nullable
                private String m2763a() {
                    this.f1799d = super.a(this.f1799d, 0);
                    return this.f1799d;
                }

                public final int jK_() {
                    return 609433823;
                }

                public final GraphQLVisitableModel m2765a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2764a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m2763a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: setPredictedTopics */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageCallToActionModel.class, new Deserializer());
                }

                public Object m2766a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageCallToActionParser.m2807a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageCallToActionModel = new PageCallToActionModel();
                    ((BaseModel) pageCallToActionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageCallToActionModel instanceof Postprocessable) {
                        return ((Postprocessable) pageCallToActionModel).a();
                    }
                    return pageCallToActionModel;
                }
            }

            /* compiled from: setPredictedTopics */
            public class Serializer extends JsonSerializer<PageCallToActionModel> {
                public final void m2767a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageCallToActionModel pageCallToActionModel = (PageCallToActionModel) obj;
                    if (pageCallToActionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageCallToActionModel.m2768a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageCallToActionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageCallToActionParser.m2808a(pageCallToActionModel.w_(), pageCallToActionModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PageCallToActionModel.class, new Serializer());
                }
            }

            public PageCallToActionModel() {
                super(2);
            }

            @Nullable
            public final CtaAdminInfoModel m2770a() {
                this.f1800d = (CtaAdminInfoModel) super.a(this.f1800d, 0, CtaAdminInfoModel.class);
                return this.f1800d;
            }

            @Nullable
            public final GraphQLPageCallToActionType m2771j() {
                this.f1801e = (GraphQLPageCallToActionType) super.b(this.f1801e, 1, GraphQLPageCallToActionType.class, GraphQLPageCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f1801e;
            }

            public final int jK_() {
                return 133279070;
            }

            public final GraphQLVisitableModel m2769a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2770a() != null) {
                    CtaAdminInfoModel ctaAdminInfoModel = (CtaAdminInfoModel) graphQLModelMutatingVisitor.b(m2770a());
                    if (m2770a() != ctaAdminInfoModel) {
                        graphQLVisitableModel = (PageCallToActionModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1800d = ctaAdminInfoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2768a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2770a());
                int a2 = flatBufferBuilder.a(m2771j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: setPredictedTopics */
        public class Serializer extends JsonSerializer<FetchPageActivityQueryModel> {
            public final void m2772a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchPageActivityQueryModel fetchPageActivityQueryModel = (FetchPageActivityQueryModel) obj;
                if (fetchPageActivityQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchPageActivityQueryModel.m2775a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchPageActivityQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchPageActivityQueryModel.w_();
                int u_ = fetchPageActivityQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("activity_admin_info");
                    ActivityAdminInfoParser.m2801a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("activity_feeds");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        ActivityFeedsParser.m2803a(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("admin_info");
                    AdminInfoParser.m3732a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 4) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 4));
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("page_call_to_action");
                    PageCallToActionParser.m2808a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 6);
                if (g != 0) {
                    jsonGenerator.a("page_likers");
                    PageLikersParser.m3734a(mutableFlatBuffer, g, jsonGenerator);
                }
                boolean a = mutableFlatBuffer.a(u_, 7);
                if (a) {
                    jsonGenerator.a("should_show_recent_activity_entry_point");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 8);
                if (a) {
                    jsonGenerator.a("should_show_recent_checkins_entry_point");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 9);
                if (a) {
                    jsonGenerator.a("should_show_recent_mentions_entry_point");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 10);
                if (a) {
                    jsonGenerator.a("should_show_recent_reviews_entry_point");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 11);
                if (a) {
                    jsonGenerator.a("should_show_recent_shares_entry_point");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchPageActivityQueryModel.class, new Serializer());
            }
        }

        public FetchPageActivityQueryModel() {
            super(12);
        }

        public final void m2779a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m2780a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m2773o() {
            if (this.b != null && this.f1802d == null) {
                this.f1802d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f1802d;
        }

        @Nullable
        public final ActivityAdminInfoModel m2781j() {
            this.f1803e = (ActivityAdminInfoModel) super.a(this.f1803e, 1, ActivityAdminInfoModel.class);
            return this.f1803e;
        }

        @Nonnull
        public final ImmutableList<ActivityFeedsModel> m2782k() {
            this.f1804f = super.a(this.f1804f, 2, ActivityFeedsModel.class);
            return (ImmutableList) this.f1804f;
        }

        @Nullable
        public final AdminInfoModel m2783l() {
            this.f1805g = (AdminInfoModel) super.a(this.f1805g, 3, AdminInfoModel.class);
            return this.f1805g;
        }

        @Nullable
        private String m2774p() {
            this.f1806h = super.a(this.f1806h, 4);
            return this.f1806h;
        }

        @Nullable
        public final PageCallToActionModel m2784m() {
            this.f1807i = (PageCallToActionModel) super.a(this.f1807i, 5, PageCallToActionModel.class);
            return this.f1807i;
        }

        @Nullable
        public final PageLikersModel m2785n() {
            this.f1808j = (PageLikersModel) super.a(this.f1808j, 6, PageLikersModel.class);
            return this.f1808j;
        }

        @Nullable
        public final String m2777a() {
            return m2774p();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m2776a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2781j() != null) {
                ActivityAdminInfoModel activityAdminInfoModel = (ActivityAdminInfoModel) graphQLModelMutatingVisitor.b(m2781j());
                if (m2781j() != activityAdminInfoModel) {
                    graphQLVisitableModel = (FetchPageActivityQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1803e = activityAdminInfoModel;
                }
            }
            if (m2782k() != null) {
                Builder a = ModelHelper.a(m2782k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    FetchPageActivityQueryModel fetchPageActivityQueryModel = (FetchPageActivityQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    fetchPageActivityQueryModel.f1804f = a.b();
                    graphQLVisitableModel = fetchPageActivityQueryModel;
                }
            }
            if (m2783l() != null) {
                AdminInfoModel adminInfoModel = (AdminInfoModel) graphQLModelMutatingVisitor.b(m2783l());
                if (m2783l() != adminInfoModel) {
                    graphQLVisitableModel = (FetchPageActivityQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1805g = adminInfoModel;
                }
            }
            if (m2784m() != null) {
                PageCallToActionModel pageCallToActionModel = (PageCallToActionModel) graphQLModelMutatingVisitor.b(m2784m());
                if (m2784m() != pageCallToActionModel) {
                    graphQLVisitableModel = (FetchPageActivityQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1807i = pageCallToActionModel;
                }
            }
            if (m2785n() != null) {
                PageLikersModel pageLikersModel = (PageLikersModel) graphQLModelMutatingVisitor.b(m2785n());
                if (m2785n() != pageLikersModel) {
                    graphQLVisitableModel = (FetchPageActivityQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1808j = pageLikersModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2775a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2773o());
            int a2 = ModelHelper.a(flatBufferBuilder, m2781j());
            int a3 = ModelHelper.a(flatBufferBuilder, m2782k());
            int a4 = ModelHelper.a(flatBufferBuilder, m2783l());
            int b = flatBufferBuilder.b(m2774p());
            int a5 = ModelHelper.a(flatBufferBuilder, m2784m());
            int a6 = ModelHelper.a(flatBufferBuilder, m2785n());
            flatBufferBuilder.c(12);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, b);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, a6);
            flatBufferBuilder.a(7, this.f1809k);
            flatBufferBuilder.a(8, this.f1810l);
            flatBufferBuilder.a(9, this.f1811m);
            flatBufferBuilder.a(10, this.f1812n);
            flatBufferBuilder.a(11, this.f1813o);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2778a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1809k = mutableFlatBuffer.a(i, 7);
            this.f1810l = mutableFlatBuffer.a(i, 8);
            this.f1811m = mutableFlatBuffer.a(i, 9);
            this.f1812n = mutableFlatBuffer.a(i, 10);
            this.f1813o = mutableFlatBuffer.a(i, 11);
        }
    }
}
