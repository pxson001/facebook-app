package com.facebook.facecastdisplay.protocol;

import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLInterfaces.BaseFeedbackFields;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLInterfaces.BaseFeedbackFields.ViewerActsAsPage;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.BaseFeedbackFieldsModel.ViewerActsAsPageModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLInterfaces.SimpleReactionsFeedbackFields;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ReactionsCountFieldsModel.TopReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.SimpleReactionsFeedbackFieldsModel.ReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsFeedbackFieldsModel.SupportedReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ImportantReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ViewerActsAsPersonModel;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.FeedbackLiveVideoCommentCoreFragmentParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.FeedbackLiveVideoCommentCoreFragmentParser.FeedbackParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.FeedbackLiveVideoCommentCoreFragmentParser.NotableLikersParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.FeedbackLiveVideoCommentCoreFragmentParser.NotableLikersParser.EdgesParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.FeedbackLiveVideoNewestCommentStreamHeadFragmentParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.FeedbackLiveVideoNewestCommentStreamInitialFragmentParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.FeedbackLiveVideoNewestCommentStreamNeckFragmentParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.FeedbackLiveVideoVODBackfillCommentsFragmentParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.FeedbackLiveVideoVODCommentsFragmentParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.FetchLiveSubscriptionQueryParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.FetchLiveSubscriptionQueryParser.OwnerParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.FetchLiveVideoAnnouncementsQueryParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.FetchLiveVideoAnnouncementsQueryParser.AnnouncementsParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.FetchLiveVideoInvitedFriendsParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.FetchLiveVideoInvitedFriendsParser.AlreadyInvitedLiveViewersParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.FetchLiveVideoNewestCommentsHeadQueryParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.FetchLiveVideoNewestCommentsInitialQueryParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.FetchLiveVideoNewestCommentsNeckQueryParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.FetchLiveVideoRecentInviteesParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.FetchLiveVideoRecentInviteesParser.RecentLiveViewerInviteesParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.FetchLiveVideoRecentInviteesParser.RecentLiveViewerInviteesParser.EdgesParser.NodeParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.FetchLiveVideoVODBackfillCommentsQueryParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.FetchLiveVideoVODCommentsQueryParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.LiveBlingBarFeedbackQueryParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.LiveBlingbarFeedbackParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.LiveBlingbarFeedbackParser.CommentsParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.LiveBlingbarFeedbackParser.LikersParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.LiveBlingbarFeedbackParser.ResharesParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.LiveEventAuthorParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.LiveNotableLikedCommentsQueryParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.LiveNotableLikedCommentsQueryParser.FeedbackParser.NotableLikedCommentsParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.LiveVideoTopLevelCommentsParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.LiveVideoTopLevelCommentsSubscriptionParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.LiveVideoVODVideoTimestampedCommentsParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.LiveVideoViewersCollectionFragmentParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.LiveVideoViewersQueryParser;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryParsers.VideoAnnouncementFragmentParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLLiveVideoSubscriptionStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesWithAggregatedRangesFieldsModel;
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

/* compiled from: stickeroff_input_height */
public class FetchLiveVideoEventsQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1099519352)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: stickeroff_input_height */
    public final class FeedbackLiveVideoCommentCoreFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        private int f3089d;
        @Nullable
        private LiveEventAuthorModel f3090e;
        @Nullable
        private DefaultTextWithEntitiesWithAggregatedRangesFieldsModel f3091f;
        @Nullable
        private FeedbackModel f3092g;
        @Nullable
        private String f3093h;
        private boolean f3094i;
        @Nullable
        private NotableLikersModel f3095j;

        /* compiled from: stickeroff_input_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeedbackLiveVideoCommentCoreFragmentModel.class, new Deserializer());
            }

            public Object m3498a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FeedbackLiveVideoCommentCoreFragmentParser.m3928a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object feedbackLiveVideoCommentCoreFragmentModel = new FeedbackLiveVideoCommentCoreFragmentModel();
                ((BaseModel) feedbackLiveVideoCommentCoreFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (feedbackLiveVideoCommentCoreFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) feedbackLiveVideoCommentCoreFragmentModel).a();
                }
                return feedbackLiveVideoCommentCoreFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -658419788)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: stickeroff_input_height */
        public final class FeedbackModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            private boolean f3083d;
            private boolean f3084e;
            @Nullable
            private String f3085f;
            @Nullable
            private String f3086g;

            /* compiled from: stickeroff_input_height */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FeedbackModel.class, new Deserializer());
                }

                public Object m3499a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FeedbackParser.m3922a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object feedbackModel = new FeedbackModel();
                    ((BaseModel) feedbackModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (feedbackModel instanceof Postprocessable) {
                        return ((Postprocessable) feedbackModel).a();
                    }
                    return feedbackModel;
                }
            }

            /* compiled from: stickeroff_input_height */
            public class Serializer extends JsonSerializer<FeedbackModel> {
                public final void m3500a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FeedbackModel feedbackModel = (FeedbackModel) obj;
                    if (feedbackModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(feedbackModel.m3503a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        feedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FeedbackParser.m3923a(feedbackModel.w_(), feedbackModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FeedbackModel.class, new Serializer());
                }
            }

            public FeedbackModel() {
                super(4);
            }

            public final void m3507a(String str, ConsistencyTuple consistencyTuple) {
                if ("can_viewer_like".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m3509j());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 0;
                } else if ("does_viewer_like".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m3510k());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                } else {
                    consistencyTuple.a();
                }
            }

            public final void m3508a(String str, Object obj, boolean z) {
                if ("can_viewer_like".equals(str)) {
                    m3501a(((Boolean) obj).booleanValue());
                } else if ("does_viewer_like".equals(str)) {
                    m3502b(((Boolean) obj).booleanValue());
                }
            }

            public final boolean m3509j() {
                a(0, 0);
                return this.f3083d;
            }

            private void m3501a(boolean z) {
                this.f3083d = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 0, z);
                }
            }

            public final boolean m3510k() {
                a(0, 1);
                return this.f3084e;
            }

            private void m3502b(boolean z) {
                this.f3084e = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, z);
                }
            }

            @Nullable
            public final String m3511l() {
                this.f3085f = super.a(this.f3085f, 2);
                return this.f3085f;
            }

            @Nullable
            public final String m3512m() {
                this.f3086g = super.a(this.f3086g, 3);
                return this.f3086g;
            }

            @Nullable
            public final String m3505a() {
                return m3512m();
            }

            public final int jK_() {
                return -126857307;
            }

            public final GraphQLVisitableModel m3504a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m3503a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m3511l());
                int b2 = flatBufferBuilder.b(m3512m());
                flatBufferBuilder.c(4);
                flatBufferBuilder.a(0, this.f3083d);
                flatBufferBuilder.a(1, this.f3084e);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, b2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m3506a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f3083d = mutableFlatBuffer.a(i, 0);
                this.f3084e = mutableFlatBuffer.a(i, 1);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 104080006)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: stickeroff_input_height */
        public final class NotableLikersModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f3088d;

            /* compiled from: stickeroff_input_height */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NotableLikersModel.class, new Deserializer());
                }

                public Object m3513a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NotableLikersParser.m3926a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object notableLikersModel = new NotableLikersModel();
                    ((BaseModel) notableLikersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (notableLikersModel instanceof Postprocessable) {
                        return ((Postprocessable) notableLikersModel).a();
                    }
                    return notableLikersModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1414622125)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: stickeroff_input_height */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private LiveEventAuthorModel f3087d;

                /* compiled from: stickeroff_input_height */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m3514a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m3924b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object edgesModel = new EdgesModel();
                        ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (edgesModel instanceof Postprocessable) {
                            return ((Postprocessable) edgesModel).a();
                        }
                        return edgesModel;
                    }
                }

                /* compiled from: stickeroff_input_height */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m3515a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m3516a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m3925b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                public final LiveEventAuthorModel m3517a() {
                    this.f3087d = (LiveEventAuthorModel) super.a(this.f3087d, 0, LiveEventAuthorModel.class);
                    return this.f3087d;
                }

                public final int jK_() {
                    return 1654345826;
                }

                public final GraphQLVisitableModel m3518a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m3517a() != null) {
                        LiveEventAuthorModel liveEventAuthorModel = (LiveEventAuthorModel) graphQLModelMutatingVisitor.b(m3517a());
                        if (m3517a() != liveEventAuthorModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f3087d = liveEventAuthorModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m3516a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m3517a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: stickeroff_input_height */
            public class Serializer extends JsonSerializer<NotableLikersModel> {
                public final void m3519a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NotableLikersModel notableLikersModel = (NotableLikersModel) obj;
                    if (notableLikersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(notableLikersModel.m3520a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        notableLikersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NotableLikersParser.m3927a(notableLikersModel.w_(), notableLikersModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(NotableLikersModel.class, new Serializer());
                }
            }

            public NotableLikersModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m3522a() {
                this.f3088d = super.a(this.f3088d, 0, EdgesModel.class);
                return (ImmutableList) this.f3088d;
            }

            public final int jK_() {
                return -794619453;
            }

            public final GraphQLVisitableModel m3521a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m3522a() != null) {
                    Builder a = ModelHelper.a(m3522a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (NotableLikersModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f3088d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m3520a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m3522a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Serializer extends JsonSerializer<FeedbackLiveVideoCommentCoreFragmentModel> {
            public final void m3523a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FeedbackLiveVideoCommentCoreFragmentModel feedbackLiveVideoCommentCoreFragmentModel = (FeedbackLiveVideoCommentCoreFragmentModel) obj;
                if (feedbackLiveVideoCommentCoreFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(feedbackLiveVideoCommentCoreFragmentModel.m3525a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    feedbackLiveVideoCommentCoreFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FeedbackLiveVideoCommentCoreFragmentParser.m3929a(feedbackLiveVideoCommentCoreFragmentModel.w_(), feedbackLiveVideoCommentCoreFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FeedbackLiveVideoCommentCoreFragmentModel.class, new Serializer());
            }
        }

        public FeedbackLiveVideoCommentCoreFragmentModel() {
            super(7);
        }

        public final int m3529j() {
            a(0, 0);
            return this.f3089d;
        }

        @Nullable
        public final LiveEventAuthorModel m3530k() {
            this.f3090e = (LiveEventAuthorModel) super.a(this.f3090e, 1, LiveEventAuthorModel.class);
            return this.f3090e;
        }

        @Nullable
        public final DefaultTextWithEntitiesWithAggregatedRangesFieldsModel m3531l() {
            this.f3091f = (DefaultTextWithEntitiesWithAggregatedRangesFieldsModel) super.a(this.f3091f, 2, DefaultTextWithEntitiesWithAggregatedRangesFieldsModel.class);
            return this.f3091f;
        }

        @Nullable
        public final FeedbackModel m3532m() {
            this.f3092g = (FeedbackModel) super.a(this.f3092g, 3, FeedbackModel.class);
            return this.f3092g;
        }

        @Nullable
        private String m3524o() {
            this.f3093h = super.a(this.f3093h, 4);
            return this.f3093h;
        }

        @Nullable
        public final NotableLikersModel m3533n() {
            this.f3095j = (NotableLikersModel) super.a(this.f3095j, 6, NotableLikersModel.class);
            return this.f3095j;
        }

        @Nullable
        public final String m3527a() {
            return m3524o();
        }

        public final int jK_() {
            return -1679915457;
        }

        public final GraphQLVisitableModel m3526a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3530k() != null) {
                LiveEventAuthorModel liveEventAuthorModel = (LiveEventAuthorModel) graphQLModelMutatingVisitor.b(m3530k());
                if (m3530k() != liveEventAuthorModel) {
                    graphQLVisitableModel = (FeedbackLiveVideoCommentCoreFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3090e = liveEventAuthorModel;
                }
            }
            if (m3531l() != null) {
                DefaultTextWithEntitiesWithAggregatedRangesFieldsModel defaultTextWithEntitiesWithAggregatedRangesFieldsModel = (DefaultTextWithEntitiesWithAggregatedRangesFieldsModel) graphQLModelMutatingVisitor.b(m3531l());
                if (m3531l() != defaultTextWithEntitiesWithAggregatedRangesFieldsModel) {
                    graphQLVisitableModel = (FeedbackLiveVideoCommentCoreFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3091f = defaultTextWithEntitiesWithAggregatedRangesFieldsModel;
                }
            }
            if (m3532m() != null) {
                FeedbackModel feedbackModel = (FeedbackModel) graphQLModelMutatingVisitor.b(m3532m());
                if (m3532m() != feedbackModel) {
                    graphQLVisitableModel = (FeedbackLiveVideoCommentCoreFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3092g = feedbackModel;
                }
            }
            if (m3533n() != null) {
                NotableLikersModel notableLikersModel = (NotableLikersModel) graphQLModelMutatingVisitor.b(m3533n());
                if (m3533n() != notableLikersModel) {
                    graphQLVisitableModel = (FeedbackLiveVideoCommentCoreFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3095j = notableLikersModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3525a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3530k());
            int a2 = ModelHelper.a(flatBufferBuilder, m3531l());
            int a3 = ModelHelper.a(flatBufferBuilder, m3532m());
            int b = flatBufferBuilder.b(m3524o());
            int a4 = ModelHelper.a(flatBufferBuilder, m3533n());
            flatBufferBuilder.c(7);
            flatBufferBuilder.a(0, this.f3089d, 0);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, b);
            flatBufferBuilder.a(5, this.f3094i);
            flatBufferBuilder.b(6, a4);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3528a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3089d = mutableFlatBuffer.a(i, 0, 0);
            this.f3094i = mutableFlatBuffer.a(i, 5);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -16383433)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: stickeroff_input_height */
    public final class FeedbackLiveVideoNewestCommentStreamHeadFragmentModel extends BaseModel implements BaseFeedbackFields, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        private boolean f3096d;
        private boolean f3097e;
        private boolean f3098f;
        private boolean f3099g;
        private boolean f3100h;
        private boolean f3101i;
        private boolean f3102j;
        @Nullable
        private String f3103k;
        private boolean f3104l;
        @Nullable
        private String f3105m;
        private boolean f3106n;
        @Nullable
        private String f3107o;
        @Nullable
        private String f3108p;
        @Nullable
        private LiveVideoTopLevelCommentsModel f3109q;
        @Nullable
        private ViewerActsAsPageModel f3110r;

        /* compiled from: stickeroff_input_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeedbackLiveVideoNewestCommentStreamHeadFragmentModel.class, new Deserializer());
            }

            public Object m3534a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FeedbackLiveVideoNewestCommentStreamHeadFragmentParser.m3930a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object feedbackLiveVideoNewestCommentStreamHeadFragmentModel = new FeedbackLiveVideoNewestCommentStreamHeadFragmentModel();
                ((BaseModel) feedbackLiveVideoNewestCommentStreamHeadFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (feedbackLiveVideoNewestCommentStreamHeadFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) feedbackLiveVideoNewestCommentStreamHeadFragmentModel).a();
                }
                return feedbackLiveVideoNewestCommentStreamHeadFragmentModel;
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Serializer extends JsonSerializer<FeedbackLiveVideoNewestCommentStreamHeadFragmentModel> {
            public final void m3535a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FeedbackLiveVideoNewestCommentStreamHeadFragmentModel feedbackLiveVideoNewestCommentStreamHeadFragmentModel = (FeedbackLiveVideoNewestCommentStreamHeadFragmentModel) obj;
                if (feedbackLiveVideoNewestCommentStreamHeadFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(feedbackLiveVideoNewestCommentStreamHeadFragmentModel.m3541a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    feedbackLiveVideoNewestCommentStreamHeadFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FeedbackLiveVideoNewestCommentStreamHeadFragmentParser.m3931a(feedbackLiveVideoNewestCommentStreamHeadFragmentModel.w_(), feedbackLiveVideoNewestCommentStreamHeadFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FeedbackLiveVideoNewestCommentStreamHeadFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ViewerActsAsPage m3557p() {
            return m3540r();
        }

        public FeedbackLiveVideoNewestCommentStreamHeadFragmentModel() {
            super(15);
        }

        public final void m3545a(String str, ConsistencyTuple consistencyTuple) {
            if ("can_viewer_comment".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m3548c());
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
            } else if ("can_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(bU_());
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
            } else if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m3552k());
                consistencyTuple.b = u_();
                consistencyTuple.c = 8;
            } else if ("is_viewer_subscribed".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m3554m());
                consistencyTuple.b = u_();
                consistencyTuple.c = 10;
            } else {
                if ("top_level_comments.count".equals(str)) {
                    LiveVideoTopLevelCommentsModel q = m3558q();
                    if (q != null) {
                        consistencyTuple.a = Integer.valueOf(q.m3857a());
                        consistencyTuple.b = q.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                }
                consistencyTuple.a();
            }
        }

        public final void m3546a(String str, Object obj, boolean z) {
            if ("can_viewer_comment".equals(str)) {
                m3536a(((Boolean) obj).booleanValue());
            } else if ("can_viewer_like".equals(str)) {
                m3537b(((Boolean) obj).booleanValue());
            } else if ("does_viewer_like".equals(str)) {
                m3538c(((Boolean) obj).booleanValue());
            } else if ("is_viewer_subscribed".equals(str)) {
                m3539d(((Boolean) obj).booleanValue());
            } else if ("top_level_comments.count".equals(str)) {
                LiveVideoTopLevelCommentsModel q = m3558q();
                if (q == null) {
                    return;
                }
                if (z) {
                    q = (LiveVideoTopLevelCommentsModel) q.clone();
                    q.m3860a(((Integer) obj).intValue());
                    this.f3109q = q;
                    return;
                }
                q.m3860a(((Integer) obj).intValue());
            }
        }

        public final boolean m3547b() {
            a(0, 0);
            return this.f3096d;
        }

        public final boolean m3548c() {
            a(0, 1);
            return this.f3097e;
        }

        private void m3536a(boolean z) {
            this.f3097e = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, z);
            }
        }

        public final boolean m3549d() {
            a(0, 2);
            return this.f3098f;
        }

        public final boolean bT_() {
            a(0, 3);
            return this.f3099g;
        }

        public final boolean m3550g() {
            a(0, 4);
            return this.f3100h;
        }

        public final boolean bU_() {
            a(0, 5);
            return this.f3101i;
        }

        private void m3537b(boolean z) {
            this.f3101i = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, z);
            }
        }

        public final boolean bV_() {
            a(0, 6);
            return this.f3102j;
        }

        @Nullable
        public final String m3551j() {
            this.f3103k = super.a(this.f3103k, 7);
            return this.f3103k;
        }

        public final boolean m3552k() {
            a(1, 0);
            return this.f3104l;
        }

        private void m3538c(boolean z) {
            this.f3104l = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 8, z);
            }
        }

        @Nullable
        public final String m3553l() {
            this.f3105m = super.a(this.f3105m, 9);
            return this.f3105m;
        }

        public final boolean m3554m() {
            a(1, 2);
            return this.f3106n;
        }

        private void m3539d(boolean z) {
            this.f3106n = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 10, z);
            }
        }

        @Nullable
        public final String m3555n() {
            this.f3107o = super.a(this.f3107o, 11);
            return this.f3107o;
        }

        @Nullable
        public final String m3556o() {
            this.f3108p = super.a(this.f3108p, 12);
            return this.f3108p;
        }

        @Nullable
        public final LiveVideoTopLevelCommentsModel m3558q() {
            this.f3109q = (LiveVideoTopLevelCommentsModel) super.a(this.f3109q, 13, LiveVideoTopLevelCommentsModel.class);
            return this.f3109q;
        }

        @Nullable
        private ViewerActsAsPageModel m3540r() {
            this.f3110r = (ViewerActsAsPageModel) super.a(this.f3110r, 14, ViewerActsAsPageModel.class);
            return this.f3110r;
        }

        @Nullable
        public final String m3543a() {
            return m3555n();
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m3542a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3558q() != null) {
                LiveVideoTopLevelCommentsModel liveVideoTopLevelCommentsModel = (LiveVideoTopLevelCommentsModel) graphQLModelMutatingVisitor.b(m3558q());
                if (m3558q() != liveVideoTopLevelCommentsModel) {
                    graphQLVisitableModel = (FeedbackLiveVideoNewestCommentStreamHeadFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3109q = liveVideoTopLevelCommentsModel;
                }
            }
            if (m3540r() != null) {
                ViewerActsAsPageModel viewerActsAsPageModel = (ViewerActsAsPageModel) graphQLModelMutatingVisitor.b(m3540r());
                if (m3540r() != viewerActsAsPageModel) {
                    graphQLVisitableModel = (FeedbackLiveVideoNewestCommentStreamHeadFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3110r = viewerActsAsPageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3541a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m3551j());
            int b2 = flatBufferBuilder.b(m3553l());
            int b3 = flatBufferBuilder.b(m3555n());
            int b4 = flatBufferBuilder.b(m3556o());
            int a = ModelHelper.a(flatBufferBuilder, m3558q());
            int a2 = ModelHelper.a(flatBufferBuilder, m3540r());
            flatBufferBuilder.c(15);
            flatBufferBuilder.a(0, this.f3096d);
            flatBufferBuilder.a(1, this.f3097e);
            flatBufferBuilder.a(2, this.f3098f);
            flatBufferBuilder.a(3, this.f3099g);
            flatBufferBuilder.a(4, this.f3100h);
            flatBufferBuilder.a(5, this.f3101i);
            flatBufferBuilder.a(6, this.f3102j);
            flatBufferBuilder.b(7, b);
            flatBufferBuilder.a(8, this.f3104l);
            flatBufferBuilder.b(9, b2);
            flatBufferBuilder.a(10, this.f3106n);
            flatBufferBuilder.b(11, b3);
            flatBufferBuilder.b(12, b4);
            flatBufferBuilder.b(13, a);
            flatBufferBuilder.b(14, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3544a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3096d = mutableFlatBuffer.a(i, 0);
            this.f3097e = mutableFlatBuffer.a(i, 1);
            this.f3098f = mutableFlatBuffer.a(i, 2);
            this.f3099g = mutableFlatBuffer.a(i, 3);
            this.f3100h = mutableFlatBuffer.a(i, 4);
            this.f3101i = mutableFlatBuffer.a(i, 5);
            this.f3102j = mutableFlatBuffer.a(i, 6);
            this.f3104l = mutableFlatBuffer.a(i, 8);
            this.f3106n = mutableFlatBuffer.a(i, 10);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -16383433)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: stickeroff_input_height */
    public final class FeedbackLiveVideoNewestCommentStreamInitialFragmentModel extends BaseModel implements BaseFeedbackFields, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        private boolean f3111d;
        private boolean f3112e;
        private boolean f3113f;
        private boolean f3114g;
        private boolean f3115h;
        private boolean f3116i;
        private boolean f3117j;
        @Nullable
        private String f3118k;
        private boolean f3119l;
        @Nullable
        private String f3120m;
        private boolean f3121n;
        @Nullable
        private String f3122o;
        @Nullable
        private String f3123p;
        @Nullable
        private LiveVideoTopLevelCommentsModel f3124q;
        @Nullable
        private ViewerActsAsPageModel f3125r;

        /* compiled from: stickeroff_input_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeedbackLiveVideoNewestCommentStreamInitialFragmentModel.class, new Deserializer());
            }

            public Object m3559a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FeedbackLiveVideoNewestCommentStreamInitialFragmentParser.m3932a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object feedbackLiveVideoNewestCommentStreamInitialFragmentModel = new FeedbackLiveVideoNewestCommentStreamInitialFragmentModel();
                ((BaseModel) feedbackLiveVideoNewestCommentStreamInitialFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (feedbackLiveVideoNewestCommentStreamInitialFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) feedbackLiveVideoNewestCommentStreamInitialFragmentModel).a();
                }
                return feedbackLiveVideoNewestCommentStreamInitialFragmentModel;
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Serializer extends JsonSerializer<FeedbackLiveVideoNewestCommentStreamInitialFragmentModel> {
            public final void m3560a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FeedbackLiveVideoNewestCommentStreamInitialFragmentModel feedbackLiveVideoNewestCommentStreamInitialFragmentModel = (FeedbackLiveVideoNewestCommentStreamInitialFragmentModel) obj;
                if (feedbackLiveVideoNewestCommentStreamInitialFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(feedbackLiveVideoNewestCommentStreamInitialFragmentModel.m3566a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    feedbackLiveVideoNewestCommentStreamInitialFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FeedbackLiveVideoNewestCommentStreamInitialFragmentParser.m3933a(feedbackLiveVideoNewestCommentStreamInitialFragmentModel.w_(), feedbackLiveVideoNewestCommentStreamInitialFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FeedbackLiveVideoNewestCommentStreamInitialFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ViewerActsAsPage m3582p() {
            return m3565r();
        }

        public FeedbackLiveVideoNewestCommentStreamInitialFragmentModel() {
            super(15);
        }

        public final void m3570a(String str, ConsistencyTuple consistencyTuple) {
            if ("can_viewer_comment".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m3573c());
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
            } else if ("can_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(bU_());
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
            } else if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m3577k());
                consistencyTuple.b = u_();
                consistencyTuple.c = 8;
            } else if ("is_viewer_subscribed".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m3579m());
                consistencyTuple.b = u_();
                consistencyTuple.c = 10;
            } else {
                if ("top_level_comments.count".equals(str)) {
                    LiveVideoTopLevelCommentsModel q = m3583q();
                    if (q != null) {
                        consistencyTuple.a = Integer.valueOf(q.m3857a());
                        consistencyTuple.b = q.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                }
                consistencyTuple.a();
            }
        }

        public final void m3571a(String str, Object obj, boolean z) {
            if ("can_viewer_comment".equals(str)) {
                m3561a(((Boolean) obj).booleanValue());
            } else if ("can_viewer_like".equals(str)) {
                m3562b(((Boolean) obj).booleanValue());
            } else if ("does_viewer_like".equals(str)) {
                m3563c(((Boolean) obj).booleanValue());
            } else if ("is_viewer_subscribed".equals(str)) {
                m3564d(((Boolean) obj).booleanValue());
            } else if ("top_level_comments.count".equals(str)) {
                LiveVideoTopLevelCommentsModel q = m3583q();
                if (q == null) {
                    return;
                }
                if (z) {
                    q = (LiveVideoTopLevelCommentsModel) q.clone();
                    q.m3860a(((Integer) obj).intValue());
                    this.f3124q = q;
                    return;
                }
                q.m3860a(((Integer) obj).intValue());
            }
        }

        public final boolean m3572b() {
            a(0, 0);
            return this.f3111d;
        }

        public final boolean m3573c() {
            a(0, 1);
            return this.f3112e;
        }

        private void m3561a(boolean z) {
            this.f3112e = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, z);
            }
        }

        public final boolean m3574d() {
            a(0, 2);
            return this.f3113f;
        }

        public final boolean bT_() {
            a(0, 3);
            return this.f3114g;
        }

        public final boolean m3575g() {
            a(0, 4);
            return this.f3115h;
        }

        public final boolean bU_() {
            a(0, 5);
            return this.f3116i;
        }

        private void m3562b(boolean z) {
            this.f3116i = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, z);
            }
        }

        public final boolean bV_() {
            a(0, 6);
            return this.f3117j;
        }

        @Nullable
        public final String m3576j() {
            this.f3118k = super.a(this.f3118k, 7);
            return this.f3118k;
        }

        public final boolean m3577k() {
            a(1, 0);
            return this.f3119l;
        }

        private void m3563c(boolean z) {
            this.f3119l = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 8, z);
            }
        }

        @Nullable
        public final String m3578l() {
            this.f3120m = super.a(this.f3120m, 9);
            return this.f3120m;
        }

        public final boolean m3579m() {
            a(1, 2);
            return this.f3121n;
        }

        private void m3564d(boolean z) {
            this.f3121n = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 10, z);
            }
        }

        @Nullable
        public final String m3580n() {
            this.f3122o = super.a(this.f3122o, 11);
            return this.f3122o;
        }

        @Nullable
        public final String m3581o() {
            this.f3123p = super.a(this.f3123p, 12);
            return this.f3123p;
        }

        @Nullable
        public final LiveVideoTopLevelCommentsModel m3583q() {
            this.f3124q = (LiveVideoTopLevelCommentsModel) super.a(this.f3124q, 13, LiveVideoTopLevelCommentsModel.class);
            return this.f3124q;
        }

        @Nullable
        private ViewerActsAsPageModel m3565r() {
            this.f3125r = (ViewerActsAsPageModel) super.a(this.f3125r, 14, ViewerActsAsPageModel.class);
            return this.f3125r;
        }

        @Nullable
        public final String m3568a() {
            return m3580n();
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m3567a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3583q() != null) {
                LiveVideoTopLevelCommentsModel liveVideoTopLevelCommentsModel = (LiveVideoTopLevelCommentsModel) graphQLModelMutatingVisitor.b(m3583q());
                if (m3583q() != liveVideoTopLevelCommentsModel) {
                    graphQLVisitableModel = (FeedbackLiveVideoNewestCommentStreamInitialFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3124q = liveVideoTopLevelCommentsModel;
                }
            }
            if (m3565r() != null) {
                ViewerActsAsPageModel viewerActsAsPageModel = (ViewerActsAsPageModel) graphQLModelMutatingVisitor.b(m3565r());
                if (m3565r() != viewerActsAsPageModel) {
                    graphQLVisitableModel = (FeedbackLiveVideoNewestCommentStreamInitialFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3125r = viewerActsAsPageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3566a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m3576j());
            int b2 = flatBufferBuilder.b(m3578l());
            int b3 = flatBufferBuilder.b(m3580n());
            int b4 = flatBufferBuilder.b(m3581o());
            int a = ModelHelper.a(flatBufferBuilder, m3583q());
            int a2 = ModelHelper.a(flatBufferBuilder, m3565r());
            flatBufferBuilder.c(15);
            flatBufferBuilder.a(0, this.f3111d);
            flatBufferBuilder.a(1, this.f3112e);
            flatBufferBuilder.a(2, this.f3113f);
            flatBufferBuilder.a(3, this.f3114g);
            flatBufferBuilder.a(4, this.f3115h);
            flatBufferBuilder.a(5, this.f3116i);
            flatBufferBuilder.a(6, this.f3117j);
            flatBufferBuilder.b(7, b);
            flatBufferBuilder.a(8, this.f3119l);
            flatBufferBuilder.b(9, b2);
            flatBufferBuilder.a(10, this.f3121n);
            flatBufferBuilder.b(11, b3);
            flatBufferBuilder.b(12, b4);
            flatBufferBuilder.b(13, a);
            flatBufferBuilder.b(14, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3569a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3111d = mutableFlatBuffer.a(i, 0);
            this.f3112e = mutableFlatBuffer.a(i, 1);
            this.f3113f = mutableFlatBuffer.a(i, 2);
            this.f3114g = mutableFlatBuffer.a(i, 3);
            this.f3115h = mutableFlatBuffer.a(i, 4);
            this.f3116i = mutableFlatBuffer.a(i, 5);
            this.f3117j = mutableFlatBuffer.a(i, 6);
            this.f3119l = mutableFlatBuffer.a(i, 8);
            this.f3121n = mutableFlatBuffer.a(i, 10);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -16383433)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: stickeroff_input_height */
    public final class FeedbackLiveVideoNewestCommentStreamNeckFragmentModel extends BaseModel implements BaseFeedbackFields, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        private boolean f3126d;
        private boolean f3127e;
        private boolean f3128f;
        private boolean f3129g;
        private boolean f3130h;
        private boolean f3131i;
        private boolean f3132j;
        @Nullable
        private String f3133k;
        private boolean f3134l;
        @Nullable
        private String f3135m;
        private boolean f3136n;
        @Nullable
        private String f3137o;
        @Nullable
        private String f3138p;
        @Nullable
        private LiveVideoTopLevelCommentsModel f3139q;
        @Nullable
        private ViewerActsAsPageModel f3140r;

        /* compiled from: stickeroff_input_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeedbackLiveVideoNewestCommentStreamNeckFragmentModel.class, new Deserializer());
            }

            public Object m3584a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FeedbackLiveVideoNewestCommentStreamNeckFragmentParser.m3934a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object feedbackLiveVideoNewestCommentStreamNeckFragmentModel = new FeedbackLiveVideoNewestCommentStreamNeckFragmentModel();
                ((BaseModel) feedbackLiveVideoNewestCommentStreamNeckFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (feedbackLiveVideoNewestCommentStreamNeckFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) feedbackLiveVideoNewestCommentStreamNeckFragmentModel).a();
                }
                return feedbackLiveVideoNewestCommentStreamNeckFragmentModel;
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Serializer extends JsonSerializer<FeedbackLiveVideoNewestCommentStreamNeckFragmentModel> {
            public final void m3585a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FeedbackLiveVideoNewestCommentStreamNeckFragmentModel feedbackLiveVideoNewestCommentStreamNeckFragmentModel = (FeedbackLiveVideoNewestCommentStreamNeckFragmentModel) obj;
                if (feedbackLiveVideoNewestCommentStreamNeckFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(feedbackLiveVideoNewestCommentStreamNeckFragmentModel.m3591a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    feedbackLiveVideoNewestCommentStreamNeckFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FeedbackLiveVideoNewestCommentStreamNeckFragmentParser.m3935a(feedbackLiveVideoNewestCommentStreamNeckFragmentModel.w_(), feedbackLiveVideoNewestCommentStreamNeckFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FeedbackLiveVideoNewestCommentStreamNeckFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ViewerActsAsPage m3607p() {
            return m3590r();
        }

        public FeedbackLiveVideoNewestCommentStreamNeckFragmentModel() {
            super(15);
        }

        public final void m3595a(String str, ConsistencyTuple consistencyTuple) {
            if ("can_viewer_comment".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m3598c());
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
            } else if ("can_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(bU_());
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
            } else if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m3602k());
                consistencyTuple.b = u_();
                consistencyTuple.c = 8;
            } else if ("is_viewer_subscribed".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m3604m());
                consistencyTuple.b = u_();
                consistencyTuple.c = 10;
            } else {
                if ("top_level_comments.count".equals(str)) {
                    LiveVideoTopLevelCommentsModel q = m3608q();
                    if (q != null) {
                        consistencyTuple.a = Integer.valueOf(q.m3857a());
                        consistencyTuple.b = q.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                }
                consistencyTuple.a();
            }
        }

        public final void m3596a(String str, Object obj, boolean z) {
            if ("can_viewer_comment".equals(str)) {
                m3586a(((Boolean) obj).booleanValue());
            } else if ("can_viewer_like".equals(str)) {
                m3587b(((Boolean) obj).booleanValue());
            } else if ("does_viewer_like".equals(str)) {
                m3588c(((Boolean) obj).booleanValue());
            } else if ("is_viewer_subscribed".equals(str)) {
                m3589d(((Boolean) obj).booleanValue());
            } else if ("top_level_comments.count".equals(str)) {
                LiveVideoTopLevelCommentsModel q = m3608q();
                if (q == null) {
                    return;
                }
                if (z) {
                    q = (LiveVideoTopLevelCommentsModel) q.clone();
                    q.m3860a(((Integer) obj).intValue());
                    this.f3139q = q;
                    return;
                }
                q.m3860a(((Integer) obj).intValue());
            }
        }

        public final boolean m3597b() {
            a(0, 0);
            return this.f3126d;
        }

        public final boolean m3598c() {
            a(0, 1);
            return this.f3127e;
        }

        private void m3586a(boolean z) {
            this.f3127e = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, z);
            }
        }

        public final boolean m3599d() {
            a(0, 2);
            return this.f3128f;
        }

        public final boolean bT_() {
            a(0, 3);
            return this.f3129g;
        }

        public final boolean m3600g() {
            a(0, 4);
            return this.f3130h;
        }

        public final boolean bU_() {
            a(0, 5);
            return this.f3131i;
        }

        private void m3587b(boolean z) {
            this.f3131i = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, z);
            }
        }

        public final boolean bV_() {
            a(0, 6);
            return this.f3132j;
        }

        @Nullable
        public final String m3601j() {
            this.f3133k = super.a(this.f3133k, 7);
            return this.f3133k;
        }

        public final boolean m3602k() {
            a(1, 0);
            return this.f3134l;
        }

        private void m3588c(boolean z) {
            this.f3134l = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 8, z);
            }
        }

        @Nullable
        public final String m3603l() {
            this.f3135m = super.a(this.f3135m, 9);
            return this.f3135m;
        }

        public final boolean m3604m() {
            a(1, 2);
            return this.f3136n;
        }

        private void m3589d(boolean z) {
            this.f3136n = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 10, z);
            }
        }

        @Nullable
        public final String m3605n() {
            this.f3137o = super.a(this.f3137o, 11);
            return this.f3137o;
        }

        @Nullable
        public final String m3606o() {
            this.f3138p = super.a(this.f3138p, 12);
            return this.f3138p;
        }

        @Nullable
        public final LiveVideoTopLevelCommentsModel m3608q() {
            this.f3139q = (LiveVideoTopLevelCommentsModel) super.a(this.f3139q, 13, LiveVideoTopLevelCommentsModel.class);
            return this.f3139q;
        }

        @Nullable
        private ViewerActsAsPageModel m3590r() {
            this.f3140r = (ViewerActsAsPageModel) super.a(this.f3140r, 14, ViewerActsAsPageModel.class);
            return this.f3140r;
        }

        @Nullable
        public final String m3593a() {
            return m3605n();
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m3592a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3608q() != null) {
                LiveVideoTopLevelCommentsModel liveVideoTopLevelCommentsModel = (LiveVideoTopLevelCommentsModel) graphQLModelMutatingVisitor.b(m3608q());
                if (m3608q() != liveVideoTopLevelCommentsModel) {
                    graphQLVisitableModel = (FeedbackLiveVideoNewestCommentStreamNeckFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3139q = liveVideoTopLevelCommentsModel;
                }
            }
            if (m3590r() != null) {
                ViewerActsAsPageModel viewerActsAsPageModel = (ViewerActsAsPageModel) graphQLModelMutatingVisitor.b(m3590r());
                if (m3590r() != viewerActsAsPageModel) {
                    graphQLVisitableModel = (FeedbackLiveVideoNewestCommentStreamNeckFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3140r = viewerActsAsPageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3591a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m3601j());
            int b2 = flatBufferBuilder.b(m3603l());
            int b3 = flatBufferBuilder.b(m3605n());
            int b4 = flatBufferBuilder.b(m3606o());
            int a = ModelHelper.a(flatBufferBuilder, m3608q());
            int a2 = ModelHelper.a(flatBufferBuilder, m3590r());
            flatBufferBuilder.c(15);
            flatBufferBuilder.a(0, this.f3126d);
            flatBufferBuilder.a(1, this.f3127e);
            flatBufferBuilder.a(2, this.f3128f);
            flatBufferBuilder.a(3, this.f3129g);
            flatBufferBuilder.a(4, this.f3130h);
            flatBufferBuilder.a(5, this.f3131i);
            flatBufferBuilder.a(6, this.f3132j);
            flatBufferBuilder.b(7, b);
            flatBufferBuilder.a(8, this.f3134l);
            flatBufferBuilder.b(9, b2);
            flatBufferBuilder.a(10, this.f3136n);
            flatBufferBuilder.b(11, b3);
            flatBufferBuilder.b(12, b4);
            flatBufferBuilder.b(13, a);
            flatBufferBuilder.b(14, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3594a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3126d = mutableFlatBuffer.a(i, 0);
            this.f3127e = mutableFlatBuffer.a(i, 1);
            this.f3128f = mutableFlatBuffer.a(i, 2);
            this.f3129g = mutableFlatBuffer.a(i, 3);
            this.f3130h = mutableFlatBuffer.a(i, 4);
            this.f3131i = mutableFlatBuffer.a(i, 5);
            this.f3132j = mutableFlatBuffer.a(i, 6);
            this.f3134l = mutableFlatBuffer.a(i, 8);
            this.f3136n = mutableFlatBuffer.a(i, 10);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1369110730)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: stickeroff_input_height */
    public final class FeedbackLiveVideoVODBackfillCommentsFragmentModel extends BaseModel implements BaseFeedbackFields, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        private boolean f3141d;
        private boolean f3142e;
        private boolean f3143f;
        private boolean f3144g;
        private boolean f3145h;
        private boolean f3146i;
        private boolean f3147j;
        @Nullable
        private String f3148k;
        private boolean f3149l;
        @Nullable
        private String f3150m;
        private boolean f3151n;
        @Nullable
        private String f3152o;
        @Nullable
        private String f3153p;
        @Nullable
        private LiveVideoVODVideoTimestampedCommentsModel f3154q;
        @Nullable
        private ViewerActsAsPageModel f3155r;

        /* compiled from: stickeroff_input_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeedbackLiveVideoVODBackfillCommentsFragmentModel.class, new Deserializer());
            }

            public Object m3609a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FeedbackLiveVideoVODBackfillCommentsFragmentParser.m3936a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object feedbackLiveVideoVODBackfillCommentsFragmentModel = new FeedbackLiveVideoVODBackfillCommentsFragmentModel();
                ((BaseModel) feedbackLiveVideoVODBackfillCommentsFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (feedbackLiveVideoVODBackfillCommentsFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) feedbackLiveVideoVODBackfillCommentsFragmentModel).a();
                }
                return feedbackLiveVideoVODBackfillCommentsFragmentModel;
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Serializer extends JsonSerializer<FeedbackLiveVideoVODBackfillCommentsFragmentModel> {
            public final void m3610a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FeedbackLiveVideoVODBackfillCommentsFragmentModel feedbackLiveVideoVODBackfillCommentsFragmentModel = (FeedbackLiveVideoVODBackfillCommentsFragmentModel) obj;
                if (feedbackLiveVideoVODBackfillCommentsFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(feedbackLiveVideoVODBackfillCommentsFragmentModel.m3616a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    feedbackLiveVideoVODBackfillCommentsFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FeedbackLiveVideoVODBackfillCommentsFragmentParser.m3937a(feedbackLiveVideoVODBackfillCommentsFragmentModel.w_(), feedbackLiveVideoVODBackfillCommentsFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FeedbackLiveVideoVODBackfillCommentsFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ViewerActsAsPage m3632p() {
            return m3615r();
        }

        public FeedbackLiveVideoVODBackfillCommentsFragmentModel() {
            super(15);
        }

        public final void m3620a(String str, ConsistencyTuple consistencyTuple) {
            if ("can_viewer_comment".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m3623c());
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
            } else if ("can_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(bU_());
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
            } else if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m3627k());
                consistencyTuple.b = u_();
                consistencyTuple.c = 8;
            } else if ("is_viewer_subscribed".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m3629m());
                consistencyTuple.b = u_();
                consistencyTuple.c = 10;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m3621a(String str, Object obj, boolean z) {
            if ("can_viewer_comment".equals(str)) {
                m3611a(((Boolean) obj).booleanValue());
            } else if ("can_viewer_like".equals(str)) {
                m3612b(((Boolean) obj).booleanValue());
            } else if ("does_viewer_like".equals(str)) {
                m3613c(((Boolean) obj).booleanValue());
            } else if ("is_viewer_subscribed".equals(str)) {
                m3614d(((Boolean) obj).booleanValue());
            }
        }

        public final boolean m3622b() {
            a(0, 0);
            return this.f3141d;
        }

        public final boolean m3623c() {
            a(0, 1);
            return this.f3142e;
        }

        private void m3611a(boolean z) {
            this.f3142e = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, z);
            }
        }

        public final boolean m3624d() {
            a(0, 2);
            return this.f3143f;
        }

        public final boolean bT_() {
            a(0, 3);
            return this.f3144g;
        }

        public final boolean m3625g() {
            a(0, 4);
            return this.f3145h;
        }

        public final boolean bU_() {
            a(0, 5);
            return this.f3146i;
        }

        private void m3612b(boolean z) {
            this.f3146i = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, z);
            }
        }

        public final boolean bV_() {
            a(0, 6);
            return this.f3147j;
        }

        @Nullable
        public final String m3626j() {
            this.f3148k = super.a(this.f3148k, 7);
            return this.f3148k;
        }

        public final boolean m3627k() {
            a(1, 0);
            return this.f3149l;
        }

        private void m3613c(boolean z) {
            this.f3149l = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 8, z);
            }
        }

        @Nullable
        public final String m3628l() {
            this.f3150m = super.a(this.f3150m, 9);
            return this.f3150m;
        }

        public final boolean m3629m() {
            a(1, 2);
            return this.f3151n;
        }

        private void m3614d(boolean z) {
            this.f3151n = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 10, z);
            }
        }

        @Nullable
        public final String m3630n() {
            this.f3152o = super.a(this.f3152o, 11);
            return this.f3152o;
        }

        @Nullable
        public final String m3631o() {
            this.f3153p = super.a(this.f3153p, 12);
            return this.f3153p;
        }

        @Nullable
        public final LiveVideoVODVideoTimestampedCommentsModel m3633q() {
            this.f3154q = (LiveVideoVODVideoTimestampedCommentsModel) super.a(this.f3154q, 13, LiveVideoVODVideoTimestampedCommentsModel.class);
            return this.f3154q;
        }

        @Nullable
        private ViewerActsAsPageModel m3615r() {
            this.f3155r = (ViewerActsAsPageModel) super.a(this.f3155r, 14, ViewerActsAsPageModel.class);
            return this.f3155r;
        }

        @Nullable
        public final String m3618a() {
            return m3630n();
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m3617a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3633q() != null) {
                LiveVideoVODVideoTimestampedCommentsModel liveVideoVODVideoTimestampedCommentsModel = (LiveVideoVODVideoTimestampedCommentsModel) graphQLModelMutatingVisitor.b(m3633q());
                if (m3633q() != liveVideoVODVideoTimestampedCommentsModel) {
                    graphQLVisitableModel = (FeedbackLiveVideoVODBackfillCommentsFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3154q = liveVideoVODVideoTimestampedCommentsModel;
                }
            }
            if (m3615r() != null) {
                ViewerActsAsPageModel viewerActsAsPageModel = (ViewerActsAsPageModel) graphQLModelMutatingVisitor.b(m3615r());
                if (m3615r() != viewerActsAsPageModel) {
                    graphQLVisitableModel = (FeedbackLiveVideoVODBackfillCommentsFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3155r = viewerActsAsPageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3616a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m3626j());
            int b2 = flatBufferBuilder.b(m3628l());
            int b3 = flatBufferBuilder.b(m3630n());
            int b4 = flatBufferBuilder.b(m3631o());
            int a = ModelHelper.a(flatBufferBuilder, m3633q());
            int a2 = ModelHelper.a(flatBufferBuilder, m3615r());
            flatBufferBuilder.c(15);
            flatBufferBuilder.a(0, this.f3141d);
            flatBufferBuilder.a(1, this.f3142e);
            flatBufferBuilder.a(2, this.f3143f);
            flatBufferBuilder.a(3, this.f3144g);
            flatBufferBuilder.a(4, this.f3145h);
            flatBufferBuilder.a(5, this.f3146i);
            flatBufferBuilder.a(6, this.f3147j);
            flatBufferBuilder.b(7, b);
            flatBufferBuilder.a(8, this.f3149l);
            flatBufferBuilder.b(9, b2);
            flatBufferBuilder.a(10, this.f3151n);
            flatBufferBuilder.b(11, b3);
            flatBufferBuilder.b(12, b4);
            flatBufferBuilder.b(13, a);
            flatBufferBuilder.b(14, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3619a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3141d = mutableFlatBuffer.a(i, 0);
            this.f3142e = mutableFlatBuffer.a(i, 1);
            this.f3143f = mutableFlatBuffer.a(i, 2);
            this.f3144g = mutableFlatBuffer.a(i, 3);
            this.f3145h = mutableFlatBuffer.a(i, 4);
            this.f3146i = mutableFlatBuffer.a(i, 5);
            this.f3147j = mutableFlatBuffer.a(i, 6);
            this.f3149l = mutableFlatBuffer.a(i, 8);
            this.f3151n = mutableFlatBuffer.a(i, 10);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1369110730)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: stickeroff_input_height */
    public final class FeedbackLiveVideoVODCommentsFragmentModel extends BaseModel implements BaseFeedbackFields, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        private boolean f3156d;
        private boolean f3157e;
        private boolean f3158f;
        private boolean f3159g;
        private boolean f3160h;
        private boolean f3161i;
        private boolean f3162j;
        @Nullable
        private String f3163k;
        private boolean f3164l;
        @Nullable
        private String f3165m;
        private boolean f3166n;
        @Nullable
        private String f3167o;
        @Nullable
        private String f3168p;
        @Nullable
        private LiveVideoVODVideoTimestampedCommentsModel f3169q;
        @Nullable
        private ViewerActsAsPageModel f3170r;

        /* compiled from: stickeroff_input_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeedbackLiveVideoVODCommentsFragmentModel.class, new Deserializer());
            }

            public Object m3634a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FeedbackLiveVideoVODCommentsFragmentParser.m3938a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object feedbackLiveVideoVODCommentsFragmentModel = new FeedbackLiveVideoVODCommentsFragmentModel();
                ((BaseModel) feedbackLiveVideoVODCommentsFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (feedbackLiveVideoVODCommentsFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) feedbackLiveVideoVODCommentsFragmentModel).a();
                }
                return feedbackLiveVideoVODCommentsFragmentModel;
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Serializer extends JsonSerializer<FeedbackLiveVideoVODCommentsFragmentModel> {
            public final void m3635a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FeedbackLiveVideoVODCommentsFragmentModel feedbackLiveVideoVODCommentsFragmentModel = (FeedbackLiveVideoVODCommentsFragmentModel) obj;
                if (feedbackLiveVideoVODCommentsFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(feedbackLiveVideoVODCommentsFragmentModel.m3641a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    feedbackLiveVideoVODCommentsFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FeedbackLiveVideoVODCommentsFragmentParser.m3939a(feedbackLiveVideoVODCommentsFragmentModel.w_(), feedbackLiveVideoVODCommentsFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FeedbackLiveVideoVODCommentsFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ViewerActsAsPage m3657p() {
            return m3640r();
        }

        public FeedbackLiveVideoVODCommentsFragmentModel() {
            super(15);
        }

        public final void m3645a(String str, ConsistencyTuple consistencyTuple) {
            if ("can_viewer_comment".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m3648c());
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
            } else if ("can_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(bU_());
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
            } else if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m3652k());
                consistencyTuple.b = u_();
                consistencyTuple.c = 8;
            } else if ("is_viewer_subscribed".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m3654m());
                consistencyTuple.b = u_();
                consistencyTuple.c = 10;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m3646a(String str, Object obj, boolean z) {
            if ("can_viewer_comment".equals(str)) {
                m3636a(((Boolean) obj).booleanValue());
            } else if ("can_viewer_like".equals(str)) {
                m3637b(((Boolean) obj).booleanValue());
            } else if ("does_viewer_like".equals(str)) {
                m3638c(((Boolean) obj).booleanValue());
            } else if ("is_viewer_subscribed".equals(str)) {
                m3639d(((Boolean) obj).booleanValue());
            }
        }

        public final boolean m3647b() {
            a(0, 0);
            return this.f3156d;
        }

        public final boolean m3648c() {
            a(0, 1);
            return this.f3157e;
        }

        private void m3636a(boolean z) {
            this.f3157e = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, z);
            }
        }

        public final boolean m3649d() {
            a(0, 2);
            return this.f3158f;
        }

        public final boolean bT_() {
            a(0, 3);
            return this.f3159g;
        }

        public final boolean m3650g() {
            a(0, 4);
            return this.f3160h;
        }

        public final boolean bU_() {
            a(0, 5);
            return this.f3161i;
        }

        private void m3637b(boolean z) {
            this.f3161i = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, z);
            }
        }

        public final boolean bV_() {
            a(0, 6);
            return this.f3162j;
        }

        @Nullable
        public final String m3651j() {
            this.f3163k = super.a(this.f3163k, 7);
            return this.f3163k;
        }

        public final boolean m3652k() {
            a(1, 0);
            return this.f3164l;
        }

        private void m3638c(boolean z) {
            this.f3164l = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 8, z);
            }
        }

        @Nullable
        public final String m3653l() {
            this.f3165m = super.a(this.f3165m, 9);
            return this.f3165m;
        }

        public final boolean m3654m() {
            a(1, 2);
            return this.f3166n;
        }

        private void m3639d(boolean z) {
            this.f3166n = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 10, z);
            }
        }

        @Nullable
        public final String m3655n() {
            this.f3167o = super.a(this.f3167o, 11);
            return this.f3167o;
        }

        @Nullable
        public final String m3656o() {
            this.f3168p = super.a(this.f3168p, 12);
            return this.f3168p;
        }

        @Nullable
        public final LiveVideoVODVideoTimestampedCommentsModel m3658q() {
            this.f3169q = (LiveVideoVODVideoTimestampedCommentsModel) super.a(this.f3169q, 13, LiveVideoVODVideoTimestampedCommentsModel.class);
            return this.f3169q;
        }

        @Nullable
        private ViewerActsAsPageModel m3640r() {
            this.f3170r = (ViewerActsAsPageModel) super.a(this.f3170r, 14, ViewerActsAsPageModel.class);
            return this.f3170r;
        }

        @Nullable
        public final String m3643a() {
            return m3655n();
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m3642a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3658q() != null) {
                LiveVideoVODVideoTimestampedCommentsModel liveVideoVODVideoTimestampedCommentsModel = (LiveVideoVODVideoTimestampedCommentsModel) graphQLModelMutatingVisitor.b(m3658q());
                if (m3658q() != liveVideoVODVideoTimestampedCommentsModel) {
                    graphQLVisitableModel = (FeedbackLiveVideoVODCommentsFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3169q = liveVideoVODVideoTimestampedCommentsModel;
                }
            }
            if (m3640r() != null) {
                ViewerActsAsPageModel viewerActsAsPageModel = (ViewerActsAsPageModel) graphQLModelMutatingVisitor.b(m3640r());
                if (m3640r() != viewerActsAsPageModel) {
                    graphQLVisitableModel = (FeedbackLiveVideoVODCommentsFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3170r = viewerActsAsPageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3641a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m3651j());
            int b2 = flatBufferBuilder.b(m3653l());
            int b3 = flatBufferBuilder.b(m3655n());
            int b4 = flatBufferBuilder.b(m3656o());
            int a = ModelHelper.a(flatBufferBuilder, m3658q());
            int a2 = ModelHelper.a(flatBufferBuilder, m3640r());
            flatBufferBuilder.c(15);
            flatBufferBuilder.a(0, this.f3156d);
            flatBufferBuilder.a(1, this.f3157e);
            flatBufferBuilder.a(2, this.f3158f);
            flatBufferBuilder.a(3, this.f3159g);
            flatBufferBuilder.a(4, this.f3160h);
            flatBufferBuilder.a(5, this.f3161i);
            flatBufferBuilder.a(6, this.f3162j);
            flatBufferBuilder.b(7, b);
            flatBufferBuilder.a(8, this.f3164l);
            flatBufferBuilder.b(9, b2);
            flatBufferBuilder.a(10, this.f3166n);
            flatBufferBuilder.b(11, b3);
            flatBufferBuilder.b(12, b4);
            flatBufferBuilder.b(13, a);
            flatBufferBuilder.b(14, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3644a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3156d = mutableFlatBuffer.a(i, 0);
            this.f3157e = mutableFlatBuffer.a(i, 1);
            this.f3158f = mutableFlatBuffer.a(i, 2);
            this.f3159g = mutableFlatBuffer.a(i, 3);
            this.f3160h = mutableFlatBuffer.a(i, 4);
            this.f3161i = mutableFlatBuffer.a(i, 5);
            this.f3162j = mutableFlatBuffer.a(i, 6);
            this.f3164l = mutableFlatBuffer.a(i, 8);
            this.f3166n = mutableFlatBuffer.a(i, 10);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1820105747)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: stickeroff_input_height */
    public final class FetchLiveSubscriptionQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f3179d;
        @Nullable
        private OwnerModel f3180e;
        private boolean f3181f;

        /* compiled from: stickeroff_input_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchLiveSubscriptionQueryModel.class, new Deserializer());
            }

            public Object m3659a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchLiveSubscriptionQueryParser.m3942a(jsonParser);
                Object fetchLiveSubscriptionQueryModel = new FetchLiveSubscriptionQueryModel();
                ((BaseModel) fetchLiveSubscriptionQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchLiveSubscriptionQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchLiveSubscriptionQueryModel).a();
                }
                return fetchLiveSubscriptionQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -367165889)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: stickeroff_input_height */
        public final class OwnerModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f3175d;
            @Nullable
            private String f3176e;
            @Nullable
            private GraphQLLiveVideoSubscriptionStatus f3177f;
            @Nullable
            private String f3178g;

            /* compiled from: stickeroff_input_height */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f3171a;
                @Nullable
                public String f3172b;
                @Nullable
                public GraphQLLiveVideoSubscriptionStatus f3173c;
                @Nullable
                public String f3174d;
            }

            /* compiled from: stickeroff_input_height */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OwnerModel.class, new Deserializer());
                }

                public Object m3660a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OwnerParser.m3940a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object ownerModel = new OwnerModel();
                    ((BaseModel) ownerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (ownerModel instanceof Postprocessable) {
                        return ((Postprocessable) ownerModel).a();
                    }
                    return ownerModel;
                }
            }

            /* compiled from: stickeroff_input_height */
            public class Serializer extends JsonSerializer<OwnerModel> {
                public final void m3661a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OwnerModel ownerModel = (OwnerModel) obj;
                    if (ownerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ownerModel.m3664a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        ownerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OwnerParser.m3941a(ownerModel.w_(), ownerModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OwnerModel.class, new Serializer());
                }
            }

            public OwnerModel() {
                super(4);
            }

            public OwnerModel(MutableFlatBuffer mutableFlatBuffer) {
                super(4);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m3667a(String str, ConsistencyTuple consistencyTuple) {
                if ("live_video_subscription_status".equals(str)) {
                    consistencyTuple.a = m3670k();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m3668a(String str, Object obj, boolean z) {
                if ("live_video_subscription_status".equals(str)) {
                    m3662a((GraphQLLiveVideoSubscriptionStatus) obj);
                }
            }

            @Nullable
            private GraphQLObjectType m3663m() {
                if (this.b != null && this.f3175d == null) {
                    this.f3175d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f3175d;
            }

            @Nullable
            public final String m3669j() {
                this.f3176e = super.a(this.f3176e, 1);
                return this.f3176e;
            }

            @Nullable
            public final GraphQLLiveVideoSubscriptionStatus m3670k() {
                this.f3177f = (GraphQLLiveVideoSubscriptionStatus) super.b(this.f3177f, 2, GraphQLLiveVideoSubscriptionStatus.class, GraphQLLiveVideoSubscriptionStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f3177f;
            }

            private void m3662a(GraphQLLiveVideoSubscriptionStatus graphQLLiveVideoSubscriptionStatus) {
                this.f3177f = graphQLLiveVideoSubscriptionStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, graphQLLiveVideoSubscriptionStatus != null ? graphQLLiveVideoSubscriptionStatus.name() : null);
                }
            }

            @Nullable
            public final String m3671l() {
                this.f3178g = super.a(this.f3178g, 3);
                return this.f3178g;
            }

            @Nullable
            public final String m3666a() {
                return m3669j();
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m3665a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m3664a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m3663m());
                int b = flatBufferBuilder.b(m3669j());
                int a2 = flatBufferBuilder.a(m3670k());
                int b2 = flatBufferBuilder.b(m3671l());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Serializer extends JsonSerializer<FetchLiveSubscriptionQueryModel> {
            public final void m3672a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchLiveSubscriptionQueryModel fetchLiveSubscriptionQueryModel = (FetchLiveSubscriptionQueryModel) obj;
                if (fetchLiveSubscriptionQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchLiveSubscriptionQueryModel.m3673a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchLiveSubscriptionQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchLiveSubscriptionQueryModel.w_();
                int u_ = fetchLiveSubscriptionQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("owner");
                    OwnerParser.m3941a(mutableFlatBuffer, g, jsonGenerator);
                }
                boolean a = mutableFlatBuffer.a(u_, 2);
                if (a) {
                    jsonGenerator.a("should_show_live_subscribe");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchLiveSubscriptionQueryModel.class, new Serializer());
            }
        }

        public FetchLiveSubscriptionQueryModel() {
            super(3);
        }

        @Nullable
        public final String m3677j() {
            this.f3179d = super.a(this.f3179d, 0);
            return this.f3179d;
        }

        @Nullable
        public final OwnerModel m3678k() {
            this.f3180e = (OwnerModel) super.a(this.f3180e, 1, OwnerModel.class);
            return this.f3180e;
        }

        public final boolean m3679l() {
            a(0, 2);
            return this.f3181f;
        }

        @Nullable
        public final String m3675a() {
            return m3677j();
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m3674a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3678k() != null) {
                OwnerModel ownerModel = (OwnerModel) graphQLModelMutatingVisitor.b(m3678k());
                if (m3678k() != ownerModel) {
                    graphQLVisitableModel = (FetchLiveSubscriptionQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3180e = ownerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3673a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m3677j());
            int a = ModelHelper.a(flatBufferBuilder, m3678k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.a(2, this.f3181f);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3676a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3181f = mutableFlatBuffer.a(i, 2);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -342195512)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: stickeroff_input_height */
    public final class FetchLiveVideoAnnouncementsQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private AnnouncementsModel f3183d;
        @Nullable
        private String f3184e;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1388925245)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: stickeroff_input_height */
        public final class AnnouncementsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<VideoAnnouncementFragmentModel> f3182d;

            /* compiled from: stickeroff_input_height */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AnnouncementsModel.class, new Deserializer());
                }

                public Object m3680a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AnnouncementsParser.m3943a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object announcementsModel = new AnnouncementsModel();
                    ((BaseModel) announcementsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (announcementsModel instanceof Postprocessable) {
                        return ((Postprocessable) announcementsModel).a();
                    }
                    return announcementsModel;
                }
            }

            /* compiled from: stickeroff_input_height */
            public class Serializer extends JsonSerializer<AnnouncementsModel> {
                public final void m3681a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AnnouncementsModel announcementsModel = (AnnouncementsModel) obj;
                    if (announcementsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(announcementsModel.m3682a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        announcementsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AnnouncementsParser.m3944a(announcementsModel.w_(), announcementsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AnnouncementsModel.class, new Serializer());
                }
            }

            public AnnouncementsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<VideoAnnouncementFragmentModel> m3684a() {
                this.f3182d = super.a(this.f3182d, 0, VideoAnnouncementFragmentModel.class);
                return (ImmutableList) this.f3182d;
            }

            public final int jK_() {
                return 853677359;
            }

            public final GraphQLVisitableModel m3683a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m3684a() != null) {
                    Builder a = ModelHelper.a(m3684a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (AnnouncementsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f3182d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m3682a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m3684a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchLiveVideoAnnouncementsQueryModel.class, new Deserializer());
            }

            public Object m3685a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchLiveVideoAnnouncementsQueryParser.m3945a(jsonParser);
                Object fetchLiveVideoAnnouncementsQueryModel = new FetchLiveVideoAnnouncementsQueryModel();
                ((BaseModel) fetchLiveVideoAnnouncementsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchLiveVideoAnnouncementsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchLiveVideoAnnouncementsQueryModel).a();
                }
                return fetchLiveVideoAnnouncementsQueryModel;
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Serializer extends JsonSerializer<FetchLiveVideoAnnouncementsQueryModel> {
            public final void m3686a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchLiveVideoAnnouncementsQueryModel fetchLiveVideoAnnouncementsQueryModel = (FetchLiveVideoAnnouncementsQueryModel) obj;
                if (fetchLiveVideoAnnouncementsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchLiveVideoAnnouncementsQueryModel.m3688a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchLiveVideoAnnouncementsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchLiveVideoAnnouncementsQueryModel.w_();
                int u_ = fetchLiveVideoAnnouncementsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("announcements");
                    AnnouncementsParser.m3944a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchLiveVideoAnnouncementsQueryModel.class, new Serializer());
            }
        }

        public FetchLiveVideoAnnouncementsQueryModel() {
            super(2);
        }

        @Nullable
        public final AnnouncementsModel m3691j() {
            this.f3183d = (AnnouncementsModel) super.a(this.f3183d, 0, AnnouncementsModel.class);
            return this.f3183d;
        }

        @Nullable
        private String m3687k() {
            this.f3184e = super.a(this.f3184e, 1);
            return this.f3184e;
        }

        @Nullable
        public final String m3690a() {
            return m3687k();
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m3689a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3691j() != null) {
                AnnouncementsModel announcementsModel = (AnnouncementsModel) graphQLModelMutatingVisitor.b(m3691j());
                if (m3691j() != announcementsModel) {
                    graphQLVisitableModel = (FetchLiveVideoAnnouncementsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3183d = announcementsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3688a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3691j());
            int b = flatBufferBuilder.b(m3687k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -449719389)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: stickeroff_input_height */
    public final class FetchLiveVideoInvitedFriendsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<AlreadyInvitedLiveViewersModel> f3186d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: stickeroff_input_height */
        public final class AlreadyInvitedLiveViewersModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f3185d;

            /* compiled from: stickeroff_input_height */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AlreadyInvitedLiveViewersModel.class, new Deserializer());
                }

                public Object m3692a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AlreadyInvitedLiveViewersParser.m3947b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object alreadyInvitedLiveViewersModel = new AlreadyInvitedLiveViewersModel();
                    ((BaseModel) alreadyInvitedLiveViewersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (alreadyInvitedLiveViewersModel instanceof Postprocessable) {
                        return ((Postprocessable) alreadyInvitedLiveViewersModel).a();
                    }
                    return alreadyInvitedLiveViewersModel;
                }
            }

            /* compiled from: stickeroff_input_height */
            public class Serializer extends JsonSerializer<AlreadyInvitedLiveViewersModel> {
                public final void m3693a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AlreadyInvitedLiveViewersModel alreadyInvitedLiveViewersModel = (AlreadyInvitedLiveViewersModel) obj;
                    if (alreadyInvitedLiveViewersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(alreadyInvitedLiveViewersModel.m3694a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        alreadyInvitedLiveViewersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AlreadyInvitedLiveViewersParser.m3946a(alreadyInvitedLiveViewersModel.w_(), alreadyInvitedLiveViewersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AlreadyInvitedLiveViewersModel.class, new Serializer());
                }
            }

            public AlreadyInvitedLiveViewersModel() {
                super(1);
            }

            public final void m3697a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m3698a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m3699j() {
                this.f3185d = super.a(this.f3185d, 0);
                return this.f3185d;
            }

            @Nullable
            public final String m3696a() {
                return m3699j();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m3695a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m3694a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m3699j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchLiveVideoInvitedFriendsModel.class, new Deserializer());
            }

            public Object m3700a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FetchLiveVideoInvitedFriendsParser.m3948a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fetchLiveVideoInvitedFriendsModel = new FetchLiveVideoInvitedFriendsModel();
                ((BaseModel) fetchLiveVideoInvitedFriendsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fetchLiveVideoInvitedFriendsModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchLiveVideoInvitedFriendsModel).a();
                }
                return fetchLiveVideoInvitedFriendsModel;
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Serializer extends JsonSerializer<FetchLiveVideoInvitedFriendsModel> {
            public final void m3701a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchLiveVideoInvitedFriendsModel fetchLiveVideoInvitedFriendsModel = (FetchLiveVideoInvitedFriendsModel) obj;
                if (fetchLiveVideoInvitedFriendsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchLiveVideoInvitedFriendsModel.m3702a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchLiveVideoInvitedFriendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchLiveVideoInvitedFriendsModel.w_();
                int u_ = fetchLiveVideoInvitedFriendsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("already_invited_live_viewers");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        AlreadyInvitedLiveViewersParser.m3946a(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchLiveVideoInvitedFriendsModel.class, new Serializer());
            }
        }

        public FetchLiveVideoInvitedFriendsModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<AlreadyInvitedLiveViewersModel> m3704a() {
            this.f3186d = super.a(this.f3186d, 0, AlreadyInvitedLiveViewersModel.class);
            return (ImmutableList) this.f3186d;
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m3703a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3704a() != null) {
                Builder a = ModelHelper.a(m3704a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (FetchLiveVideoInvitedFriendsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3186d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3702a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3704a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 938550987)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: stickeroff_input_height */
    public final class FetchLiveVideoNewestCommentsHeadQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private FeedbackLiveVideoNewestCommentStreamHeadFragmentModel f3187d;
        @Nullable
        private String f3188e;

        /* compiled from: stickeroff_input_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchLiveVideoNewestCommentsHeadQueryModel.class, new Deserializer());
            }

            public Object m3705a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchLiveVideoNewestCommentsHeadQueryParser.m3949a(jsonParser);
                Object fetchLiveVideoNewestCommentsHeadQueryModel = new FetchLiveVideoNewestCommentsHeadQueryModel();
                ((BaseModel) fetchLiveVideoNewestCommentsHeadQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchLiveVideoNewestCommentsHeadQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchLiveVideoNewestCommentsHeadQueryModel).a();
                }
                return fetchLiveVideoNewestCommentsHeadQueryModel;
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Serializer extends JsonSerializer<FetchLiveVideoNewestCommentsHeadQueryModel> {
            public final void m3706a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchLiveVideoNewestCommentsHeadQueryModel fetchLiveVideoNewestCommentsHeadQueryModel = (FetchLiveVideoNewestCommentsHeadQueryModel) obj;
                if (fetchLiveVideoNewestCommentsHeadQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchLiveVideoNewestCommentsHeadQueryModel.m3708a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchLiveVideoNewestCommentsHeadQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchLiveVideoNewestCommentsHeadQueryModel.w_();
                int u_ = fetchLiveVideoNewestCommentsHeadQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    FeedbackLiveVideoNewestCommentStreamHeadFragmentParser.m3931a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchLiveVideoNewestCommentsHeadQueryModel.class, new Serializer());
            }
        }

        public FetchLiveVideoNewestCommentsHeadQueryModel() {
            super(2);
        }

        @Nullable
        public final FeedbackLiveVideoNewestCommentStreamHeadFragmentModel m3711j() {
            this.f3187d = (FeedbackLiveVideoNewestCommentStreamHeadFragmentModel) super.a(this.f3187d, 0, FeedbackLiveVideoNewestCommentStreamHeadFragmentModel.class);
            return this.f3187d;
        }

        @Nullable
        private String m3707k() {
            this.f3188e = super.a(this.f3188e, 1);
            return this.f3188e;
        }

        @Nullable
        public final String m3710a() {
            return m3707k();
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m3709a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3711j() != null) {
                FeedbackLiveVideoNewestCommentStreamHeadFragmentModel feedbackLiveVideoNewestCommentStreamHeadFragmentModel = (FeedbackLiveVideoNewestCommentStreamHeadFragmentModel) graphQLModelMutatingVisitor.b(m3711j());
                if (m3711j() != feedbackLiveVideoNewestCommentStreamHeadFragmentModel) {
                    graphQLVisitableModel = (FetchLiveVideoNewestCommentsHeadQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3187d = feedbackLiveVideoNewestCommentStreamHeadFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3708a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3711j());
            int b = flatBufferBuilder.b(m3707k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1605735322)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: stickeroff_input_height */
    public final class FetchLiveVideoNewestCommentsInitialQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private FeedbackLiveVideoNewestCommentStreamInitialFragmentModel f3189d;
        @Nullable
        private String f3190e;

        /* compiled from: stickeroff_input_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchLiveVideoNewestCommentsInitialQueryModel.class, new Deserializer());
            }

            public Object m3712a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchLiveVideoNewestCommentsInitialQueryParser.m3950a(jsonParser);
                Object fetchLiveVideoNewestCommentsInitialQueryModel = new FetchLiveVideoNewestCommentsInitialQueryModel();
                ((BaseModel) fetchLiveVideoNewestCommentsInitialQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchLiveVideoNewestCommentsInitialQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchLiveVideoNewestCommentsInitialQueryModel).a();
                }
                return fetchLiveVideoNewestCommentsInitialQueryModel;
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Serializer extends JsonSerializer<FetchLiveVideoNewestCommentsInitialQueryModel> {
            public final void m3713a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchLiveVideoNewestCommentsInitialQueryModel fetchLiveVideoNewestCommentsInitialQueryModel = (FetchLiveVideoNewestCommentsInitialQueryModel) obj;
                if (fetchLiveVideoNewestCommentsInitialQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchLiveVideoNewestCommentsInitialQueryModel.m3715a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchLiveVideoNewestCommentsInitialQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchLiveVideoNewestCommentsInitialQueryModel.w_();
                int u_ = fetchLiveVideoNewestCommentsInitialQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    FeedbackLiveVideoNewestCommentStreamInitialFragmentParser.m3933a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchLiveVideoNewestCommentsInitialQueryModel.class, new Serializer());
            }
        }

        public FetchLiveVideoNewestCommentsInitialQueryModel() {
            super(2);
        }

        @Nullable
        public final FeedbackLiveVideoNewestCommentStreamInitialFragmentModel m3718j() {
            this.f3189d = (FeedbackLiveVideoNewestCommentStreamInitialFragmentModel) super.a(this.f3189d, 0, FeedbackLiveVideoNewestCommentStreamInitialFragmentModel.class);
            return this.f3189d;
        }

        @Nullable
        private String m3714k() {
            this.f3190e = super.a(this.f3190e, 1);
            return this.f3190e;
        }

        @Nullable
        public final String m3717a() {
            return m3714k();
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m3716a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3718j() != null) {
                FeedbackLiveVideoNewestCommentStreamInitialFragmentModel feedbackLiveVideoNewestCommentStreamInitialFragmentModel = (FeedbackLiveVideoNewestCommentStreamInitialFragmentModel) graphQLModelMutatingVisitor.b(m3718j());
                if (m3718j() != feedbackLiveVideoNewestCommentStreamInitialFragmentModel) {
                    graphQLVisitableModel = (FetchLiveVideoNewestCommentsInitialQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3189d = feedbackLiveVideoNewestCommentStreamInitialFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3715a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3718j());
            int b = flatBufferBuilder.b(m3714k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1205548763)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: stickeroff_input_height */
    public final class FetchLiveVideoNewestCommentsNeckQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private FeedbackLiveVideoNewestCommentStreamNeckFragmentModel f3191d;
        @Nullable
        private String f3192e;

        /* compiled from: stickeroff_input_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchLiveVideoNewestCommentsNeckQueryModel.class, new Deserializer());
            }

            public Object m3719a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchLiveVideoNewestCommentsNeckQueryParser.m3951a(jsonParser);
                Object fetchLiveVideoNewestCommentsNeckQueryModel = new FetchLiveVideoNewestCommentsNeckQueryModel();
                ((BaseModel) fetchLiveVideoNewestCommentsNeckQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchLiveVideoNewestCommentsNeckQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchLiveVideoNewestCommentsNeckQueryModel).a();
                }
                return fetchLiveVideoNewestCommentsNeckQueryModel;
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Serializer extends JsonSerializer<FetchLiveVideoNewestCommentsNeckQueryModel> {
            public final void m3720a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchLiveVideoNewestCommentsNeckQueryModel fetchLiveVideoNewestCommentsNeckQueryModel = (FetchLiveVideoNewestCommentsNeckQueryModel) obj;
                if (fetchLiveVideoNewestCommentsNeckQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchLiveVideoNewestCommentsNeckQueryModel.m3722a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchLiveVideoNewestCommentsNeckQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchLiveVideoNewestCommentsNeckQueryModel.w_();
                int u_ = fetchLiveVideoNewestCommentsNeckQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    FeedbackLiveVideoNewestCommentStreamNeckFragmentParser.m3935a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchLiveVideoNewestCommentsNeckQueryModel.class, new Serializer());
            }
        }

        public FetchLiveVideoNewestCommentsNeckQueryModel() {
            super(2);
        }

        @Nullable
        public final FeedbackLiveVideoNewestCommentStreamNeckFragmentModel m3725j() {
            this.f3191d = (FeedbackLiveVideoNewestCommentStreamNeckFragmentModel) super.a(this.f3191d, 0, FeedbackLiveVideoNewestCommentStreamNeckFragmentModel.class);
            return this.f3191d;
        }

        @Nullable
        private String m3721k() {
            this.f3192e = super.a(this.f3192e, 1);
            return this.f3192e;
        }

        @Nullable
        public final String m3724a() {
            return m3721k();
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m3723a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3725j() != null) {
                FeedbackLiveVideoNewestCommentStreamNeckFragmentModel feedbackLiveVideoNewestCommentStreamNeckFragmentModel = (FeedbackLiveVideoNewestCommentStreamNeckFragmentModel) graphQLModelMutatingVisitor.b(m3725j());
                if (m3725j() != feedbackLiveVideoNewestCommentStreamNeckFragmentModel) {
                    graphQLVisitableModel = (FetchLiveVideoNewestCommentsNeckQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3191d = feedbackLiveVideoNewestCommentStreamNeckFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3722a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3725j());
            int b = flatBufferBuilder.b(m3721k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 991346537)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: stickeroff_input_height */
    public final class FetchLiveVideoRecentInviteesModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private RecentLiveViewerInviteesModel f3196d;

        /* compiled from: stickeroff_input_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchLiveVideoRecentInviteesModel.class, new Deserializer());
            }

            public Object m3726a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchLiveVideoRecentInviteesParser.m3958a(jsonParser);
                Object fetchLiveVideoRecentInviteesModel = new FetchLiveVideoRecentInviteesModel();
                ((BaseModel) fetchLiveVideoRecentInviteesModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchLiveVideoRecentInviteesModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchLiveVideoRecentInviteesModel).a();
                }
                return fetchLiveVideoRecentInviteesModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1984495649)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: stickeroff_input_height */
        public final class RecentLiveViewerInviteesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f3195d;

            /* compiled from: stickeroff_input_height */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RecentLiveViewerInviteesModel.class, new Deserializer());
                }

                public Object m3727a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RecentLiveViewerInviteesParser.m3956a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object recentLiveViewerInviteesModel = new RecentLiveViewerInviteesModel();
                    ((BaseModel) recentLiveViewerInviteesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (recentLiveViewerInviteesModel instanceof Postprocessable) {
                        return ((Postprocessable) recentLiveViewerInviteesModel).a();
                    }
                    return recentLiveViewerInviteesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1025500510)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: stickeroff_input_height */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f3194d;

                /* compiled from: stickeroff_input_height */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m3728a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(RecentLiveViewerInviteesParser.EdgesParser.m3954b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object edgesModel = new EdgesModel();
                        ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (edgesModel instanceof Postprocessable) {
                            return ((Postprocessable) edgesModel).a();
                        }
                        return edgesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1801334754)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: stickeroff_input_height */
                public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private String f3193d;

                    /* compiled from: stickeroff_input_height */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m3729a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m3952a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: stickeroff_input_height */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m3730a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m3731a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m3953a(nodeModel.w_(), nodeModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(1);
                    }

                    public final void m3734a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m3735a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    public final String m3736j() {
                        this.f3193d = super.a(this.f3193d, 0);
                        return this.f3193d;
                    }

                    @Nullable
                    public final String m3733a() {
                        return m3736j();
                    }

                    public final int jK_() {
                        return 2645995;
                    }

                    public final GraphQLVisitableModel m3732a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m3731a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m3736j());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: stickeroff_input_height */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m3737a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m3738a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        RecentLiveViewerInviteesParser.EdgesParser.m3955b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                public final NodeModel m3739a() {
                    this.f3194d = (NodeModel) super.a(this.f3194d, 0, NodeModel.class);
                    return this.f3194d;
                }

                public final int jK_() {
                    return -150507155;
                }

                public final GraphQLVisitableModel m3740a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m3739a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m3739a());
                        if (m3739a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f3194d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m3738a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m3739a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: stickeroff_input_height */
            public class Serializer extends JsonSerializer<RecentLiveViewerInviteesModel> {
                public final void m3741a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RecentLiveViewerInviteesModel recentLiveViewerInviteesModel = (RecentLiveViewerInviteesModel) obj;
                    if (recentLiveViewerInviteesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(recentLiveViewerInviteesModel.m3742a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        recentLiveViewerInviteesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RecentLiveViewerInviteesParser.m3957a(recentLiveViewerInviteesModel.w_(), recentLiveViewerInviteesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RecentLiveViewerInviteesModel.class, new Serializer());
                }
            }

            public RecentLiveViewerInviteesModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m3744a() {
                this.f3195d = super.a(this.f3195d, 0, EdgesModel.class);
                return (ImmutableList) this.f3195d;
            }

            public final int jK_() {
                return 1469513358;
            }

            public final GraphQLVisitableModel m3743a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m3744a() != null) {
                    Builder a = ModelHelper.a(m3744a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (RecentLiveViewerInviteesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f3195d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m3742a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m3744a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Serializer extends JsonSerializer<FetchLiveVideoRecentInviteesModel> {
            public final void m3745a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchLiveVideoRecentInviteesModel fetchLiveVideoRecentInviteesModel = (FetchLiveVideoRecentInviteesModel) obj;
                if (fetchLiveVideoRecentInviteesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchLiveVideoRecentInviteesModel.m3746a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchLiveVideoRecentInviteesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchLiveVideoRecentInviteesModel.w_();
                int u_ = fetchLiveVideoRecentInviteesModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("recent_live_viewer_invitees");
                    RecentLiveViewerInviteesParser.m3957a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchLiveVideoRecentInviteesModel.class, new Serializer());
            }
        }

        public FetchLiveVideoRecentInviteesModel() {
            super(1);
        }

        public final void m3749a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m3750a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final RecentLiveViewerInviteesModel m3747a() {
            this.f3196d = (RecentLiveViewerInviteesModel) super.a(this.f3196d, 0, RecentLiveViewerInviteesModel.class);
            return this.f3196d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m3748a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3747a() != null) {
                RecentLiveViewerInviteesModel recentLiveViewerInviteesModel = (RecentLiveViewerInviteesModel) graphQLModelMutatingVisitor.b(m3747a());
                if (m3747a() != recentLiveViewerInviteesModel) {
                    graphQLVisitableModel = (FetchLiveVideoRecentInviteesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3196d = recentLiveViewerInviteesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3746a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3747a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1173398125)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: stickeroff_input_height */
    public final class FetchLiveVideoVODBackfillCommentsQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private FeedbackLiveVideoVODBackfillCommentsFragmentModel f3197d;
        @Nullable
        private String f3198e;

        /* compiled from: stickeroff_input_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchLiveVideoVODBackfillCommentsQueryModel.class, new Deserializer());
            }

            public Object m3751a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchLiveVideoVODBackfillCommentsQueryParser.m3959a(jsonParser);
                Object fetchLiveVideoVODBackfillCommentsQueryModel = new FetchLiveVideoVODBackfillCommentsQueryModel();
                ((BaseModel) fetchLiveVideoVODBackfillCommentsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchLiveVideoVODBackfillCommentsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchLiveVideoVODBackfillCommentsQueryModel).a();
                }
                return fetchLiveVideoVODBackfillCommentsQueryModel;
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Serializer extends JsonSerializer<FetchLiveVideoVODBackfillCommentsQueryModel> {
            public final void m3752a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchLiveVideoVODBackfillCommentsQueryModel fetchLiveVideoVODBackfillCommentsQueryModel = (FetchLiveVideoVODBackfillCommentsQueryModel) obj;
                if (fetchLiveVideoVODBackfillCommentsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchLiveVideoVODBackfillCommentsQueryModel.m3754a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchLiveVideoVODBackfillCommentsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchLiveVideoVODBackfillCommentsQueryModel.w_();
                int u_ = fetchLiveVideoVODBackfillCommentsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    FeedbackLiveVideoVODBackfillCommentsFragmentParser.m3937a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchLiveVideoVODBackfillCommentsQueryModel.class, new Serializer());
            }
        }

        public FetchLiveVideoVODBackfillCommentsQueryModel() {
            super(2);
        }

        @Nullable
        public final FeedbackLiveVideoVODBackfillCommentsFragmentModel m3757j() {
            this.f3197d = (FeedbackLiveVideoVODBackfillCommentsFragmentModel) super.a(this.f3197d, 0, FeedbackLiveVideoVODBackfillCommentsFragmentModel.class);
            return this.f3197d;
        }

        @Nullable
        private String m3753k() {
            this.f3198e = super.a(this.f3198e, 1);
            return this.f3198e;
        }

        @Nullable
        public final String m3756a() {
            return m3753k();
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m3755a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3757j() != null) {
                FeedbackLiveVideoVODBackfillCommentsFragmentModel feedbackLiveVideoVODBackfillCommentsFragmentModel = (FeedbackLiveVideoVODBackfillCommentsFragmentModel) graphQLModelMutatingVisitor.b(m3757j());
                if (m3757j() != feedbackLiveVideoVODBackfillCommentsFragmentModel) {
                    graphQLVisitableModel = (FetchLiveVideoVODBackfillCommentsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3197d = feedbackLiveVideoVODBackfillCommentsFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3754a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3757j());
            int b = flatBufferBuilder.b(m3753k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1168501673)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: stickeroff_input_height */
    public final class FetchLiveVideoVODCommentsQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private FeedbackLiveVideoVODCommentsFragmentModel f3199d;
        @Nullable
        private String f3200e;

        /* compiled from: stickeroff_input_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchLiveVideoVODCommentsQueryModel.class, new Deserializer());
            }

            public Object m3758a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchLiveVideoVODCommentsQueryParser.m3960a(jsonParser);
                Object fetchLiveVideoVODCommentsQueryModel = new FetchLiveVideoVODCommentsQueryModel();
                ((BaseModel) fetchLiveVideoVODCommentsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchLiveVideoVODCommentsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchLiveVideoVODCommentsQueryModel).a();
                }
                return fetchLiveVideoVODCommentsQueryModel;
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Serializer extends JsonSerializer<FetchLiveVideoVODCommentsQueryModel> {
            public final void m3759a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchLiveVideoVODCommentsQueryModel fetchLiveVideoVODCommentsQueryModel = (FetchLiveVideoVODCommentsQueryModel) obj;
                if (fetchLiveVideoVODCommentsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchLiveVideoVODCommentsQueryModel.m3761a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchLiveVideoVODCommentsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchLiveVideoVODCommentsQueryModel.w_();
                int u_ = fetchLiveVideoVODCommentsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    FeedbackLiveVideoVODCommentsFragmentParser.m3939a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchLiveVideoVODCommentsQueryModel.class, new Serializer());
            }
        }

        public FetchLiveVideoVODCommentsQueryModel() {
            super(2);
        }

        @Nullable
        public final FeedbackLiveVideoVODCommentsFragmentModel m3764j() {
            this.f3199d = (FeedbackLiveVideoVODCommentsFragmentModel) super.a(this.f3199d, 0, FeedbackLiveVideoVODCommentsFragmentModel.class);
            return this.f3199d;
        }

        @Nullable
        private String m3760k() {
            this.f3200e = super.a(this.f3200e, 1);
            return this.f3200e;
        }

        @Nullable
        public final String m3763a() {
            return m3760k();
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m3762a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3764j() != null) {
                FeedbackLiveVideoVODCommentsFragmentModel feedbackLiveVideoVODCommentsFragmentModel = (FeedbackLiveVideoVODCommentsFragmentModel) graphQLModelMutatingVisitor.b(m3764j());
                if (m3764j() != feedbackLiveVideoVODCommentsFragmentModel) {
                    graphQLVisitableModel = (FetchLiveVideoVODCommentsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3199d = feedbackLiveVideoVODCommentsFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3761a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3764j());
            int b = flatBufferBuilder.b(m3760k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -187878186)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: stickeroff_input_height */
    public final class LiveBlingBarFeedbackQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private LiveBlingbarFeedbackModel f3201d;

        /* compiled from: stickeroff_input_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LiveBlingBarFeedbackQueryModel.class, new Deserializer());
            }

            public Object m3765a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = LiveBlingBarFeedbackQueryParser.m3961a(jsonParser);
                Object liveBlingBarFeedbackQueryModel = new LiveBlingBarFeedbackQueryModel();
                ((BaseModel) liveBlingBarFeedbackQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (liveBlingBarFeedbackQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) liveBlingBarFeedbackQueryModel).a();
                }
                return liveBlingBarFeedbackQueryModel;
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Serializer extends JsonSerializer<LiveBlingBarFeedbackQueryModel> {
            public final void m3766a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LiveBlingBarFeedbackQueryModel liveBlingBarFeedbackQueryModel = (LiveBlingBarFeedbackQueryModel) obj;
                if (liveBlingBarFeedbackQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(liveBlingBarFeedbackQueryModel.m3767a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    liveBlingBarFeedbackQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = liveBlingBarFeedbackQueryModel.w_();
                int u_ = liveBlingBarFeedbackQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    LiveBlingbarFeedbackParser.m3969a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LiveBlingBarFeedbackQueryModel.class, new Serializer());
            }
        }

        public LiveBlingBarFeedbackQueryModel() {
            super(1);
        }

        @Nullable
        public final LiveBlingbarFeedbackModel m3768a() {
            this.f3201d = (LiveBlingbarFeedbackModel) super.a(this.f3201d, 0, LiveBlingbarFeedbackModel.class);
            return this.f3201d;
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m3769a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3768a() != null) {
                LiveBlingbarFeedbackModel liveBlingbarFeedbackModel = (LiveBlingbarFeedbackModel) graphQLModelMutatingVisitor.b(m3768a());
                if (m3768a() != liveBlingbarFeedbackModel) {
                    graphQLVisitableModel = (LiveBlingBarFeedbackQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3201d = liveBlingbarFeedbackModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3767a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3768a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1004859757)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: stickeroff_input_height */
    public final class LiveBlingbarFeedbackModel extends BaseModel implements SimpleReactionsFeedbackFields, GraphQLVisitableConsistentModel {
        private boolean f3205d;
        @Nullable
        private CommentsModel f3206e;
        private boolean f3207f;
        @Nullable
        private ImportantReactorsModel f3208g;
        @Nullable
        private LikersModel f3209h;
        @Nullable
        private ReactorsModel f3210i;
        @Nullable
        private ResharesModel f3211j;
        @Nullable
        private List<SupportedReactionsModel> f3212k;
        @Nullable
        private TopReactionsModel f3213l;
        @Nullable
        private ViewerActsAsPersonModel f3214m;
        private int f3215n;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: stickeroff_input_height */
        public final class CommentsModel extends BaseModel implements GraphQLVisitableModel {
            private int f3202d;

            /* compiled from: stickeroff_input_height */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CommentsModel.class, new Deserializer());
                }

                public Object m3770a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CommentsParser.m3962a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object commentsModel = new CommentsModel();
                    ((BaseModel) commentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (commentsModel instanceof Postprocessable) {
                        return ((Postprocessable) commentsModel).a();
                    }
                    return commentsModel;
                }
            }

            /* compiled from: stickeroff_input_height */
            public class Serializer extends JsonSerializer<CommentsModel> {
                public final void m3771a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CommentsModel commentsModel = (CommentsModel) obj;
                    if (commentsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(commentsModel.m3773a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        commentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CommentsParser.m3963a(commentsModel.w_(), commentsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(CommentsModel.class, new Serializer());
                }
            }

            public CommentsModel() {
                super(1);
            }

            public final int m3772a() {
                a(0, 0);
                return this.f3202d;
            }

            public final void m3775a(int i) {
                this.f3202d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public final int jK_() {
                return -100920302;
            }

            public final GraphQLVisitableModel m3774a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m3773a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f3202d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m3776a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f3202d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LiveBlingbarFeedbackModel.class, new Deserializer());
            }

            public Object m3777a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LiveBlingbarFeedbackParser.m3968a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object liveBlingbarFeedbackModel = new LiveBlingbarFeedbackModel();
                ((BaseModel) liveBlingbarFeedbackModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (liveBlingbarFeedbackModel instanceof Postprocessable) {
                    return ((Postprocessable) liveBlingbarFeedbackModel).a();
                }
                return liveBlingbarFeedbackModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: stickeroff_input_height */
        public final class LikersModel extends BaseModel implements GraphQLVisitableModel {
            private int f3203d;

            /* compiled from: stickeroff_input_height */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LikersModel.class, new Deserializer());
                }

                public Object m3778a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LikersParser.m3964a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object likersModel = new LikersModel();
                    ((BaseModel) likersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (likersModel instanceof Postprocessable) {
                        return ((Postprocessable) likersModel).a();
                    }
                    return likersModel;
                }
            }

            /* compiled from: stickeroff_input_height */
            public class Serializer extends JsonSerializer<LikersModel> {
                public final void m3779a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LikersModel likersModel = (LikersModel) obj;
                    if (likersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(likersModel.m3781a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        likersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LikersParser.m3965a(likersModel.w_(), likersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(LikersModel.class, new Serializer());
                }
            }

            public LikersModel() {
                super(1);
            }

            public final int m3780a() {
                a(0, 0);
                return this.f3203d;
            }

            public final void m3783a(int i) {
                this.f3203d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public final int jK_() {
                return 733369288;
            }

            public final GraphQLVisitableModel m3782a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m3781a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f3203d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m3784a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f3203d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: stickeroff_input_height */
        public final class ResharesModel extends BaseModel implements GraphQLVisitableModel {
            private int f3204d;

            /* compiled from: stickeroff_input_height */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ResharesModel.class, new Deserializer());
                }

                public Object m3785a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ResharesParser.m3966a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object resharesModel = new ResharesModel();
                    ((BaseModel) resharesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (resharesModel instanceof Postprocessable) {
                        return ((Postprocessable) resharesModel).a();
                    }
                    return resharesModel;
                }
            }

            /* compiled from: stickeroff_input_height */
            public class Serializer extends JsonSerializer<ResharesModel> {
                public final void m3786a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ResharesModel resharesModel = (ResharesModel) obj;
                    if (resharesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(resharesModel.m3788a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        resharesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ResharesParser.m3967a(resharesModel.w_(), resharesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ResharesModel.class, new Serializer());
                }
            }

            public ResharesModel() {
                super(1);
            }

            public final int m3787a() {
                a(0, 0);
                return this.f3204d;
            }

            public final void m3790a(int i) {
                this.f3204d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public final int jK_() {
                return -1260671207;
            }

            public final GraphQLVisitableModel m3789a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m3788a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f3204d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m3791a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f3204d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Serializer extends JsonSerializer<LiveBlingbarFeedbackModel> {
            public final void m3792a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LiveBlingbarFeedbackModel liveBlingbarFeedbackModel = (LiveBlingbarFeedbackModel) obj;
                if (liveBlingbarFeedbackModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(liveBlingbarFeedbackModel.m3801a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    liveBlingbarFeedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LiveBlingbarFeedbackParser.m3969a(liveBlingbarFeedbackModel.w_(), liveBlingbarFeedbackModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(LiveBlingbarFeedbackModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ CommentsModel m3807b() {
            return m3794m();
        }

        @Nullable
        public final /* synthetic */ ImportantReactorsModel m3809d() {
            return m3795n();
        }

        @Nullable
        public final /* synthetic */ ResharesModel fi_() {
            return m3798q();
        }

        @Nullable
        public final /* synthetic */ LikersModel fj_() {
            return m3796o();
        }

        @Nullable
        public final /* synthetic */ ReactorsModel m3810g() {
            return m3797p();
        }

        @Nullable
        public final /* synthetic */ TopReactionsModel m3811j() {
            return m3799r();
        }

        @Nullable
        public final /* synthetic */ ViewerActsAsPersonModel m3812k() {
            return m3800s();
        }

        public LiveBlingbarFeedbackModel() {
            super(11);
        }

        public final void m3804a(String str, ConsistencyTuple consistencyTuple) {
            if ("comments.count".equals(str)) {
                CommentsModel m = m3794m();
                if (m != null) {
                    consistencyTuple.a = Integer.valueOf(m.m3772a());
                    consistencyTuple.b = m.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            } else if ("likers.count".equals(str)) {
                LikersModel o = m3796o();
                if (o != null) {
                    consistencyTuple.a = Integer.valueOf(o.m3780a());
                    consistencyTuple.b = o.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            } else if ("reactors.count".equals(str)) {
                ReactorsModel p = m3797p();
                if (p != null) {
                    consistencyTuple.a = Integer.valueOf(p.a());
                    consistencyTuple.b = p.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            } else if ("reshares.count".equals(str)) {
                ResharesModel q = m3798q();
                if (q != null) {
                    consistencyTuple.a = Integer.valueOf(q.m3787a());
                    consistencyTuple.b = q.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            } else if ("viewer_feedback_reaction_key".equals(str)) {
                consistencyTuple.a = Integer.valueOf(m3813l());
                consistencyTuple.b = u_();
                consistencyTuple.c = 10;
                return;
            }
            consistencyTuple.a();
        }

        public final void m3805a(String str, Object obj, boolean z) {
            if ("comments.count".equals(str)) {
                CommentsModel m = m3794m();
                if (m == null) {
                    return;
                }
                if (z) {
                    m = (CommentsModel) m.clone();
                    m.m3775a(((Integer) obj).intValue());
                    this.f3206e = m;
                    return;
                }
                m.m3775a(((Integer) obj).intValue());
            } else if ("likers.count".equals(str)) {
                LikersModel o = m3796o();
                if (o == null) {
                    return;
                }
                if (z) {
                    o = (LikersModel) o.clone();
                    o.m3783a(((Integer) obj).intValue());
                    this.f3209h = o;
                    return;
                }
                o.m3783a(((Integer) obj).intValue());
            } else if ("reactors.count".equals(str)) {
                ReactorsModel p = m3797p();
                if (p == null) {
                    return;
                }
                if (z) {
                    p = (ReactorsModel) p.clone();
                    p.a(((Integer) obj).intValue());
                    this.f3210i = p;
                    return;
                }
                p.a(((Integer) obj).intValue());
            } else if ("reshares.count".equals(str)) {
                ResharesModel q = m3798q();
                if (q == null) {
                    return;
                }
                if (z) {
                    q = (ResharesModel) q.clone();
                    q.m3790a(((Integer) obj).intValue());
                    this.f3211j = q;
                    return;
                }
                q.m3790a(((Integer) obj).intValue());
            } else if ("viewer_feedback_reaction_key".equals(str)) {
                m3793a(((Integer) obj).intValue());
            }
        }

        public final boolean m3806a() {
            a(0, 0);
            return this.f3205d;
        }

        @Nullable
        private CommentsModel m3794m() {
            this.f3206e = (CommentsModel) super.a(this.f3206e, 1, CommentsModel.class);
            return this.f3206e;
        }

        public final boolean m3808c() {
            a(0, 2);
            return this.f3207f;
        }

        @Nullable
        private ImportantReactorsModel m3795n() {
            this.f3208g = (ImportantReactorsModel) super.a(this.f3208g, 3, ImportantReactorsModel.class);
            return this.f3208g;
        }

        @Nullable
        private LikersModel m3796o() {
            this.f3209h = (LikersModel) super.a(this.f3209h, 4, LikersModel.class);
            return this.f3209h;
        }

        @Nullable
        private ReactorsModel m3797p() {
            this.f3210i = (ReactorsModel) super.a(this.f3210i, 5, ReactorsModel.class);
            return this.f3210i;
        }

        @Nullable
        private ResharesModel m3798q() {
            this.f3211j = (ResharesModel) super.a(this.f3211j, 6, ResharesModel.class);
            return this.f3211j;
        }

        @Nonnull
        public final ImmutableList<SupportedReactionsModel> fh_() {
            this.f3212k = super.a(this.f3212k, 7, SupportedReactionsModel.class);
            return (ImmutableList) this.f3212k;
        }

        @Nullable
        private TopReactionsModel m3799r() {
            this.f3213l = (TopReactionsModel) super.a(this.f3213l, 8, TopReactionsModel.class);
            return this.f3213l;
        }

        @Nullable
        private ViewerActsAsPersonModel m3800s() {
            this.f3214m = (ViewerActsAsPersonModel) super.a(this.f3214m, 9, ViewerActsAsPersonModel.class);
            return this.f3214m;
        }

        public final int m3813l() {
            a(1, 2);
            return this.f3215n;
        }

        private void m3793a(int i) {
            this.f3215n = i;
            if (this.b != null && this.b.d) {
                this.b.b(this.c, 10, i);
            }
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m3802a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3794m() != null) {
                CommentsModel commentsModel = (CommentsModel) graphQLModelMutatingVisitor.b(m3794m());
                if (m3794m() != commentsModel) {
                    graphQLVisitableModel = (LiveBlingbarFeedbackModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3206e = commentsModel;
                }
            }
            if (m3795n() != null) {
                ImportantReactorsModel importantReactorsModel = (ImportantReactorsModel) graphQLModelMutatingVisitor.b(m3795n());
                if (m3795n() != importantReactorsModel) {
                    graphQLVisitableModel = (LiveBlingbarFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3208g = importantReactorsModel;
                }
            }
            if (m3796o() != null) {
                LikersModel likersModel = (LikersModel) graphQLModelMutatingVisitor.b(m3796o());
                if (m3796o() != likersModel) {
                    graphQLVisitableModel = (LiveBlingbarFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3209h = likersModel;
                }
            }
            if (m3797p() != null) {
                ReactorsModel reactorsModel = (ReactorsModel) graphQLModelMutatingVisitor.b(m3797p());
                if (m3797p() != reactorsModel) {
                    graphQLVisitableModel = (LiveBlingbarFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3210i = reactorsModel;
                }
            }
            if (m3798q() != null) {
                ResharesModel resharesModel = (ResharesModel) graphQLModelMutatingVisitor.b(m3798q());
                if (m3798q() != resharesModel) {
                    graphQLVisitableModel = (LiveBlingbarFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3211j = resharesModel;
                }
            }
            if (fh_() != null) {
                Builder a = ModelHelper.a(fh_(), graphQLModelMutatingVisitor);
                if (a != null) {
                    LiveBlingbarFeedbackModel liveBlingbarFeedbackModel = (LiveBlingbarFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    liveBlingbarFeedbackModel.f3212k = a.b();
                    graphQLVisitableModel = liveBlingbarFeedbackModel;
                }
            }
            if (m3799r() != null) {
                TopReactionsModel topReactionsModel = (TopReactionsModel) graphQLModelMutatingVisitor.b(m3799r());
                if (m3799r() != topReactionsModel) {
                    graphQLVisitableModel = (LiveBlingbarFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3213l = topReactionsModel;
                }
            }
            if (m3800s() != null) {
                ViewerActsAsPersonModel viewerActsAsPersonModel = (ViewerActsAsPersonModel) graphQLModelMutatingVisitor.b(m3800s());
                if (m3800s() != viewerActsAsPersonModel) {
                    graphQLVisitableModel = (LiveBlingbarFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3214m = viewerActsAsPersonModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3801a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3794m());
            int a2 = ModelHelper.a(flatBufferBuilder, m3795n());
            int a3 = ModelHelper.a(flatBufferBuilder, m3796o());
            int a4 = ModelHelper.a(flatBufferBuilder, m3797p());
            int a5 = ModelHelper.a(flatBufferBuilder, m3798q());
            int a6 = ModelHelper.a(flatBufferBuilder, fh_());
            int a7 = ModelHelper.a(flatBufferBuilder, m3799r());
            int a8 = ModelHelper.a(flatBufferBuilder, m3800s());
            flatBufferBuilder.c(11);
            flatBufferBuilder.a(0, this.f3205d);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.a(2, this.f3207f);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.b(7, a6);
            flatBufferBuilder.b(8, a7);
            flatBufferBuilder.b(9, a8);
            flatBufferBuilder.a(10, this.f3215n, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3803a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3205d = mutableFlatBuffer.a(i, 0);
            this.f3207f = mutableFlatBuffer.a(i, 2);
            this.f3215n = mutableFlatBuffer.a(i, 10, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1069500188)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: stickeroff_input_height */
    public final class LiveEventAuthorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f3216d;
        private boolean f3217e;
        @Nullable
        private String f3218f;

        /* compiled from: stickeroff_input_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LiveEventAuthorModel.class, new Deserializer());
            }

            public Object m3814a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LiveEventAuthorParser.m3970a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object liveEventAuthorModel = new LiveEventAuthorModel();
                ((BaseModel) liveEventAuthorModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (liveEventAuthorModel instanceof Postprocessable) {
                    return ((Postprocessable) liveEventAuthorModel).a();
                }
                return liveEventAuthorModel;
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Serializer extends JsonSerializer<LiveEventAuthorModel> {
            public final void m3815a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LiveEventAuthorModel liveEventAuthorModel = (LiveEventAuthorModel) obj;
                if (liveEventAuthorModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(liveEventAuthorModel.m3816a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    liveEventAuthorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LiveEventAuthorParser.m3971a(liveEventAuthorModel.w_(), liveEventAuthorModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(LiveEventAuthorModel.class, new Serializer());
            }
        }

        public LiveEventAuthorModel() {
            super(3);
        }

        public final void m3820a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m3821a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final String m3822j() {
            this.f3216d = super.a(this.f3216d, 0);
            return this.f3216d;
        }

        public final boolean m3823k() {
            a(0, 1);
            return this.f3217e;
        }

        @Nullable
        public final String m3824l() {
            this.f3218f = super.a(this.f3218f, 2);
            return this.f3218f;
        }

        @Nullable
        public final String m3818a() {
            return m3822j();
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m3817a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m3816a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m3822j());
            int b2 = flatBufferBuilder.b(m3824l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f3217e);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3819a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3217e = mutableFlatBuffer.a(i, 1);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 806713075)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: stickeroff_input_height */
    public final class LiveNotableLikedCommentsQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private FeedbackModel f3223d;
        @Nullable
        private String f3224e;

        /* compiled from: stickeroff_input_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LiveNotableLikedCommentsQueryModel.class, new Deserializer());
            }

            public Object m3825a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = LiveNotableLikedCommentsQueryParser.m3978a(jsonParser);
                Object liveNotableLikedCommentsQueryModel = new LiveNotableLikedCommentsQueryModel();
                ((BaseModel) liveNotableLikedCommentsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (liveNotableLikedCommentsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) liveNotableLikedCommentsQueryModel).a();
                }
                return liveNotableLikedCommentsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 392976265)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: stickeroff_input_height */
        public final class FeedbackModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private String f3221d;
            @Nullable
            private NotableLikedCommentsModel f3222e;

            /* compiled from: stickeroff_input_height */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FeedbackModel.class, new Deserializer());
                }

                public Object m3826a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LiveNotableLikedCommentsQueryParser.FeedbackParser.m3976a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object feedbackModel = new FeedbackModel();
                    ((BaseModel) feedbackModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (feedbackModel instanceof Postprocessable) {
                        return ((Postprocessable) feedbackModel).a();
                    }
                    return feedbackModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -237709013)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: stickeroff_input_height */
            public final class NotableLikedCommentsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<EdgesModel> f3220d;

                /* compiled from: stickeroff_input_height */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NotableLikedCommentsModel.class, new Deserializer());
                    }

                    public Object m3827a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NotableLikedCommentsParser.m3974a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object notableLikedCommentsModel = new NotableLikedCommentsModel();
                        ((BaseModel) notableLikedCommentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (notableLikedCommentsModel instanceof Postprocessable) {
                            return ((Postprocessable) notableLikedCommentsModel).a();
                        }
                        return notableLikedCommentsModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1938730508)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: stickeroff_input_height */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private FeedbackLiveVideoCommentCoreFragmentModel f3219d;

                    /* compiled from: stickeroff_input_height */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                        }

                        public Object m3828a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NotableLikedCommentsParser.EdgesParser.m3972b(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object edgesModel = new EdgesModel();
                            ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (edgesModel instanceof Postprocessable) {
                                return ((Postprocessable) edgesModel).a();
                            }
                            return edgesModel;
                        }
                    }

                    /* compiled from: stickeroff_input_height */
                    public class Serializer extends JsonSerializer<EdgesModel> {
                        public final void m3829a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EdgesModel edgesModel = (EdgesModel) obj;
                            if (edgesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(edgesModel.m3830a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NotableLikedCommentsParser.EdgesParser.m3973b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(EdgesModel.class, new Serializer());
                        }
                    }

                    public EdgesModel() {
                        super(1);
                    }

                    @Nullable
                    public final FeedbackLiveVideoCommentCoreFragmentModel m3831a() {
                        this.f3219d = (FeedbackLiveVideoCommentCoreFragmentModel) super.a(this.f3219d, 0, FeedbackLiveVideoCommentCoreFragmentModel.class);
                        return this.f3219d;
                    }

                    public final int jK_() {
                        return 869168913;
                    }

                    public final GraphQLVisitableModel m3832a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m3831a() != null) {
                            FeedbackLiveVideoCommentCoreFragmentModel feedbackLiveVideoCommentCoreFragmentModel = (FeedbackLiveVideoCommentCoreFragmentModel) graphQLModelMutatingVisitor.b(m3831a());
                            if (m3831a() != feedbackLiveVideoCommentCoreFragmentModel) {
                                graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f3219d = feedbackLiveVideoCommentCoreFragmentModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m3830a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m3831a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: stickeroff_input_height */
                public class Serializer extends JsonSerializer<NotableLikedCommentsModel> {
                    public final void m3833a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NotableLikedCommentsModel notableLikedCommentsModel = (NotableLikedCommentsModel) obj;
                        if (notableLikedCommentsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(notableLikedCommentsModel.m3834a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            notableLikedCommentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NotableLikedCommentsParser.m3975a(notableLikedCommentsModel.w_(), notableLikedCommentsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NotableLikedCommentsModel.class, new Serializer());
                    }
                }

                public NotableLikedCommentsModel() {
                    super(1);
                }

                @Nonnull
                public final ImmutableList<EdgesModel> m3836a() {
                    this.f3220d = super.a(this.f3220d, 0, EdgesModel.class);
                    return (ImmutableList) this.f3220d;
                }

                public final int jK_() {
                    return 96745778;
                }

                public final GraphQLVisitableModel m3835a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m3836a() != null) {
                        Builder a = ModelHelper.a(m3836a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (NotableLikedCommentsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f3220d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m3834a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m3836a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: stickeroff_input_height */
            public class Serializer extends JsonSerializer<FeedbackModel> {
                public final void m3837a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FeedbackModel feedbackModel = (FeedbackModel) obj;
                    if (feedbackModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(feedbackModel.m3839a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        feedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LiveNotableLikedCommentsQueryParser.FeedbackParser.m3977a(feedbackModel.w_(), feedbackModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FeedbackModel.class, new Serializer());
                }
            }

            public FeedbackModel() {
                super(2);
            }

            public final void m3842a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m3843a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m3838j() {
                this.f3221d = super.a(this.f3221d, 0);
                return this.f3221d;
            }

            @Nullable
            public final NotableLikedCommentsModel m3840a() {
                this.f3222e = (NotableLikedCommentsModel) super.a(this.f3222e, 1, NotableLikedCommentsModel.class);
                return this.f3222e;
            }

            public final int jK_() {
                return -126857307;
            }

            public final GraphQLVisitableModel m3841a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m3840a() != null) {
                    NotableLikedCommentsModel notableLikedCommentsModel = (NotableLikedCommentsModel) graphQLModelMutatingVisitor.b(m3840a());
                    if (m3840a() != notableLikedCommentsModel) {
                        graphQLVisitableModel = (FeedbackModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f3222e = notableLikedCommentsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m3839a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m3838j());
                int a = ModelHelper.a(flatBufferBuilder, m3840a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Serializer extends JsonSerializer<LiveNotableLikedCommentsQueryModel> {
            public final void m3844a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LiveNotableLikedCommentsQueryModel liveNotableLikedCommentsQueryModel = (LiveNotableLikedCommentsQueryModel) obj;
                if (liveNotableLikedCommentsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(liveNotableLikedCommentsQueryModel.m3846a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    liveNotableLikedCommentsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = liveNotableLikedCommentsQueryModel.w_();
                int u_ = liveNotableLikedCommentsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    LiveNotableLikedCommentsQueryParser.FeedbackParser.m3977a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LiveNotableLikedCommentsQueryModel.class, new Serializer());
            }
        }

        public LiveNotableLikedCommentsQueryModel() {
            super(2);
        }

        @Nullable
        public final FeedbackModel m3849j() {
            this.f3223d = (FeedbackModel) super.a(this.f3223d, 0, FeedbackModel.class);
            return this.f3223d;
        }

        @Nullable
        private String m3845k() {
            this.f3224e = super.a(this.f3224e, 1);
            return this.f3224e;
        }

        @Nullable
        public final String m3848a() {
            return m3845k();
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m3847a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3849j() != null) {
                FeedbackModel feedbackModel = (FeedbackModel) graphQLModelMutatingVisitor.b(m3849j());
                if (m3849j() != feedbackModel) {
                    graphQLVisitableModel = (LiveNotableLikedCommentsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3223d = feedbackModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3846a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3849j());
            int b = flatBufferBuilder.b(m3845k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 53296212)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: stickeroff_input_height */
    public final class LiveVideoTopLevelCommentsModel extends BaseModel implements GraphQLVisitableModel {
        private int f3226d;
        @Nullable
        private List<EdgesModel> f3227e;
        @Nullable
        private DefaultPageInfoFieldsModel f3228f;

        /* compiled from: stickeroff_input_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LiveVideoTopLevelCommentsModel.class, new Deserializer());
            }

            public Object m3850a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LiveVideoTopLevelCommentsParser.m3981a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object liveVideoTopLevelCommentsModel = new LiveVideoTopLevelCommentsModel();
                ((BaseModel) liveVideoTopLevelCommentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (liveVideoTopLevelCommentsModel instanceof Postprocessable) {
                    return ((Postprocessable) liveVideoTopLevelCommentsModel).a();
                }
                return liveVideoTopLevelCommentsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1938730508)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: stickeroff_input_height */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private FeedbackLiveVideoCommentCoreFragmentModel f3225d;

            /* compiled from: stickeroff_input_height */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                }

                public Object m3851a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LiveVideoTopLevelCommentsParser.EdgesParser.m3979b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object edgesModel = new EdgesModel();
                    ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (edgesModel instanceof Postprocessable) {
                        return ((Postprocessable) edgesModel).a();
                    }
                    return edgesModel;
                }
            }

            /* compiled from: stickeroff_input_height */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m3852a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EdgesModel edgesModel = (EdgesModel) obj;
                    if (edgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(edgesModel.m3853a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LiveVideoTopLevelCommentsParser.EdgesParser.m3980b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EdgesModel.class, new Serializer());
                }
            }

            public EdgesModel() {
                super(1);
            }

            @Nullable
            public final FeedbackLiveVideoCommentCoreFragmentModel m3854a() {
                this.f3225d = (FeedbackLiveVideoCommentCoreFragmentModel) super.a(this.f3225d, 0, FeedbackLiveVideoCommentCoreFragmentModel.class);
                return this.f3225d;
            }

            public final int jK_() {
                return 2146326208;
            }

            public final GraphQLVisitableModel m3855a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m3854a() != null) {
                    FeedbackLiveVideoCommentCoreFragmentModel feedbackLiveVideoCommentCoreFragmentModel = (FeedbackLiveVideoCommentCoreFragmentModel) graphQLModelMutatingVisitor.b(m3854a());
                    if (m3854a() != feedbackLiveVideoCommentCoreFragmentModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f3225d = feedbackLiveVideoCommentCoreFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m3853a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m3854a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Serializer extends JsonSerializer<LiveVideoTopLevelCommentsModel> {
            public final void m3856a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LiveVideoTopLevelCommentsModel liveVideoTopLevelCommentsModel = (LiveVideoTopLevelCommentsModel) obj;
                if (liveVideoTopLevelCommentsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(liveVideoTopLevelCommentsModel.m3858a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    liveVideoTopLevelCommentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LiveVideoTopLevelCommentsParser.m3982a(liveVideoTopLevelCommentsModel.w_(), liveVideoTopLevelCommentsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(LiveVideoTopLevelCommentsModel.class, new Serializer());
            }
        }

        public LiveVideoTopLevelCommentsModel() {
            super(3);
        }

        public final int m3857a() {
            a(0, 0);
            return this.f3226d;
        }

        public final void m3860a(int i) {
            this.f3226d = i;
            if (this.b != null && this.b.d) {
                this.b.b(this.c, 0, i);
            }
        }

        @Nonnull
        public final ImmutableList<EdgesModel> m3862j() {
            this.f3227e = super.a(this.f3227e, 1, EdgesModel.class);
            return (ImmutableList) this.f3227e;
        }

        @Nullable
        public final DefaultPageInfoFieldsModel m3863k() {
            this.f3228f = (DefaultPageInfoFieldsModel) super.a(this.f3228f, 2, DefaultPageInfoFieldsModel.class);
            return this.f3228f;
        }

        public final int jK_() {
            return 899897761;
        }

        public final GraphQLVisitableModel m3859a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
            h();
            if (m3862j() != null) {
                Builder a = ModelHelper.a(m3862j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    LiveVideoTopLevelCommentsModel liveVideoTopLevelCommentsModel = (LiveVideoTopLevelCommentsModel) ModelHelper.a(null, this);
                    liveVideoTopLevelCommentsModel.f3227e = a.b();
                    graphQLVisitableModel = liveVideoTopLevelCommentsModel;
                    if (m3863k() != null) {
                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m3863k());
                        if (m3863k() != defaultPageInfoFieldsModel) {
                            graphQLVisitableModel = (LiveVideoTopLevelCommentsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f3228f = defaultPageInfoFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m3863k() != null) {
                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m3863k());
                if (m3863k() != defaultPageInfoFieldsModel) {
                    graphQLVisitableModel = (LiveVideoTopLevelCommentsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3228f = defaultPageInfoFieldsModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m3858a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3862j());
            int a2 = ModelHelper.a(flatBufferBuilder, m3863k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f3226d, 0);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3861a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3226d = mutableFlatBuffer.a(i, 0, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1923310313)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: stickeroff_input_height */
    public final class LiveVideoTopLevelCommentsSubscriptionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FeedbackLiveVideoCommentCoreFragmentModel f3229d;

        /* compiled from: stickeroff_input_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LiveVideoTopLevelCommentsSubscriptionModel.class, new Deserializer());
            }

            public Object m3864a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = LiveVideoTopLevelCommentsSubscriptionParser.m3983a(jsonParser);
                Object liveVideoTopLevelCommentsSubscriptionModel = new LiveVideoTopLevelCommentsSubscriptionModel();
                ((BaseModel) liveVideoTopLevelCommentsSubscriptionModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (liveVideoTopLevelCommentsSubscriptionModel instanceof Postprocessable) {
                    return ((Postprocessable) liveVideoTopLevelCommentsSubscriptionModel).a();
                }
                return liveVideoTopLevelCommentsSubscriptionModel;
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Serializer extends JsonSerializer<LiveVideoTopLevelCommentsSubscriptionModel> {
            public final void m3865a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LiveVideoTopLevelCommentsSubscriptionModel liveVideoTopLevelCommentsSubscriptionModel = (LiveVideoTopLevelCommentsSubscriptionModel) obj;
                if (liveVideoTopLevelCommentsSubscriptionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(liveVideoTopLevelCommentsSubscriptionModel.m3866a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    liveVideoTopLevelCommentsSubscriptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = liveVideoTopLevelCommentsSubscriptionModel.w_();
                int u_ = liveVideoTopLevelCommentsSubscriptionModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("comment");
                    FeedbackLiveVideoCommentCoreFragmentParser.m3929a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LiveVideoTopLevelCommentsSubscriptionModel.class, new Serializer());
            }
        }

        public LiveVideoTopLevelCommentsSubscriptionModel() {
            super(1);
        }

        @Nullable
        public final FeedbackLiveVideoCommentCoreFragmentModel m3867a() {
            this.f3229d = (FeedbackLiveVideoCommentCoreFragmentModel) super.a(this.f3229d, 0, FeedbackLiveVideoCommentCoreFragmentModel.class);
            return this.f3229d;
        }

        public final int jK_() {
            return -1953087374;
        }

        public final GraphQLVisitableModel m3868a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3867a() != null) {
                FeedbackLiveVideoCommentCoreFragmentModel feedbackLiveVideoCommentCoreFragmentModel = (FeedbackLiveVideoCommentCoreFragmentModel) graphQLModelMutatingVisitor.b(m3867a());
                if (m3867a() != feedbackLiveVideoCommentCoreFragmentModel) {
                    graphQLVisitableModel = (LiveVideoTopLevelCommentsSubscriptionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3229d = feedbackLiveVideoCommentCoreFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3866a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3867a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -431234955)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: stickeroff_input_height */
    public final class LiveVideoVODVideoTimestampedCommentsModel extends BaseModel implements GraphQLVisitableModel {
        private int f3240d;
        @Nullable
        private List<EdgesModel> f3241e;

        /* compiled from: stickeroff_input_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LiveVideoVODVideoTimestampedCommentsModel.class, new Deserializer());
            }

            public Object m3869a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LiveVideoVODVideoTimestampedCommentsParser.m3988a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object liveVideoVODVideoTimestampedCommentsModel = new LiveVideoVODVideoTimestampedCommentsModel();
                ((BaseModel) liveVideoVODVideoTimestampedCommentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (liveVideoVODVideoTimestampedCommentsModel instanceof Postprocessable) {
                    return ((Postprocessable) liveVideoVODVideoTimestampedCommentsModel).a();
                }
                return liveVideoVODVideoTimestampedCommentsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -440881017)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: stickeroff_input_height */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private NodeModel f3239d;

            /* compiled from: stickeroff_input_height */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                }

                public Object m3870a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LiveVideoVODVideoTimestampedCommentsParser.EdgesParser.m3986b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object edgesModel = new EdgesModel();
                    ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (edgesModel instanceof Postprocessable) {
                        return ((Postprocessable) edgesModel).a();
                    }
                    return edgesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1639799239)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: stickeroff_input_height */
            public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                private int f3230d;
                @Nullable
                private LiveEventAuthorModel f3231e;
                @Nullable
                private DefaultTextWithEntitiesWithAggregatedRangesFieldsModel f3232f;
                @Nullable
                private FeedbackModel f3233g;
                @Nullable
                private String f3234h;
                private boolean f3235i;
                @Nullable
                private NotableLikersModel f3236j;
                private int f3237k;
                private boolean f3238l;

                /* compiled from: stickeroff_input_height */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                    }

                    public Object m3871a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(LiveVideoVODVideoTimestampedCommentsParser.EdgesParser.NodeParser.m3984a(jsonParser, flatBufferBuilder));
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

                /* compiled from: stickeroff_input_height */
                public class Serializer extends JsonSerializer<NodeModel> {
                    public final void m3872a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodeModel nodeModel = (NodeModel) obj;
                        if (nodeModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodeModel.m3875a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        LiveVideoVODVideoTimestampedCommentsParser.EdgesParser.NodeParser.m3985a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodeModel.class, new Serializer());
                    }
                }

                public NodeModel() {
                    super(9);
                }

                @Nullable
                public final LiveEventAuthorModel m3879j() {
                    this.f3231e = (LiveEventAuthorModel) super.a(this.f3231e, 1, LiveEventAuthorModel.class);
                    return this.f3231e;
                }

                @Nullable
                public final DefaultTextWithEntitiesWithAggregatedRangesFieldsModel m3880k() {
                    this.f3232f = (DefaultTextWithEntitiesWithAggregatedRangesFieldsModel) super.a(this.f3232f, 2, DefaultTextWithEntitiesWithAggregatedRangesFieldsModel.class);
                    return this.f3232f;
                }

                @Nullable
                public final FeedbackModel m3881l() {
                    this.f3233g = (FeedbackModel) super.a(this.f3233g, 3, FeedbackModel.class);
                    return this.f3233g;
                }

                @Nullable
                private String m3873o() {
                    this.f3234h = super.a(this.f3234h, 4);
                    return this.f3234h;
                }

                @Nullable
                private NotableLikersModel m3874p() {
                    this.f3236j = (NotableLikersModel) super.a(this.f3236j, 6, NotableLikersModel.class);
                    return this.f3236j;
                }

                public final int m3882m() {
                    a(0, 7);
                    return this.f3237k;
                }

                public final boolean m3883n() {
                    a(1, 0);
                    return this.f3238l;
                }

                @Nullable
                public final String m3877a() {
                    return m3873o();
                }

                public final int jK_() {
                    return -1679915457;
                }

                public final GraphQLVisitableModel m3876a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m3879j() != null) {
                        LiveEventAuthorModel liveEventAuthorModel = (LiveEventAuthorModel) graphQLModelMutatingVisitor.b(m3879j());
                        if (m3879j() != liveEventAuthorModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f3231e = liveEventAuthorModel;
                        }
                    }
                    if (m3880k() != null) {
                        DefaultTextWithEntitiesWithAggregatedRangesFieldsModel defaultTextWithEntitiesWithAggregatedRangesFieldsModel = (DefaultTextWithEntitiesWithAggregatedRangesFieldsModel) graphQLModelMutatingVisitor.b(m3880k());
                        if (m3880k() != defaultTextWithEntitiesWithAggregatedRangesFieldsModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f3232f = defaultTextWithEntitiesWithAggregatedRangesFieldsModel;
                        }
                    }
                    if (m3881l() != null) {
                        FeedbackModel feedbackModel = (FeedbackModel) graphQLModelMutatingVisitor.b(m3881l());
                        if (m3881l() != feedbackModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f3233g = feedbackModel;
                        }
                    }
                    if (m3874p() != null) {
                        NotableLikersModel notableLikersModel = (NotableLikersModel) graphQLModelMutatingVisitor.b(m3874p());
                        if (m3874p() != notableLikersModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f3236j = notableLikersModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m3875a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m3879j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m3880k());
                    int a3 = ModelHelper.a(flatBufferBuilder, m3881l());
                    int b = flatBufferBuilder.b(m3873o());
                    int a4 = ModelHelper.a(flatBufferBuilder, m3874p());
                    flatBufferBuilder.c(9);
                    flatBufferBuilder.a(0, this.f3230d, 0);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.b(3, a3);
                    flatBufferBuilder.b(4, b);
                    flatBufferBuilder.a(5, this.f3235i);
                    flatBufferBuilder.b(6, a4);
                    flatBufferBuilder.a(7, this.f3237k, 0);
                    flatBufferBuilder.a(8, this.f3238l);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m3878a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f3230d = mutableFlatBuffer.a(i, 0, 0);
                    this.f3235i = mutableFlatBuffer.a(i, 5);
                    this.f3237k = mutableFlatBuffer.a(i, 7, 0);
                    this.f3238l = mutableFlatBuffer.a(i, 8);
                }
            }

            /* compiled from: stickeroff_input_height */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m3884a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EdgesModel edgesModel = (EdgesModel) obj;
                    if (edgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(edgesModel.m3885a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LiveVideoVODVideoTimestampedCommentsParser.EdgesParser.m3987b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EdgesModel.class, new Serializer());
                }
            }

            public EdgesModel() {
                super(1);
            }

            @Nullable
            public final NodeModel m3886a() {
                this.f3239d = (NodeModel) super.a(this.f3239d, 0, NodeModel.class);
                return this.f3239d;
            }

            public final int jK_() {
                return -1254582325;
            }

            public final GraphQLVisitableModel m3887a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m3886a() != null) {
                    NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m3886a());
                    if (m3886a() != nodeModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f3239d = nodeModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m3885a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m3886a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Serializer extends JsonSerializer<LiveVideoVODVideoTimestampedCommentsModel> {
            public final void m3888a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LiveVideoVODVideoTimestampedCommentsModel liveVideoVODVideoTimestampedCommentsModel = (LiveVideoVODVideoTimestampedCommentsModel) obj;
                if (liveVideoVODVideoTimestampedCommentsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(liveVideoVODVideoTimestampedCommentsModel.m3889a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    liveVideoVODVideoTimestampedCommentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LiveVideoVODVideoTimestampedCommentsParser.m3989a(liveVideoVODVideoTimestampedCommentsModel.w_(), liveVideoVODVideoTimestampedCommentsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(LiveVideoVODVideoTimestampedCommentsModel.class, new Serializer());
            }
        }

        public LiveVideoVODVideoTimestampedCommentsModel() {
            super(2);
        }

        @Nonnull
        public final ImmutableList<EdgesModel> m3891a() {
            this.f3241e = super.a(this.f3241e, 1, EdgesModel.class);
            return (ImmutableList) this.f3241e;
        }

        public final int jK_() {
            return -2040699284;
        }

        public final GraphQLVisitableModel m3890a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3891a() != null) {
                Builder a = ModelHelper.a(m3891a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (LiveVideoVODVideoTimestampedCommentsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3241e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3889a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3891a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f3240d, 0);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3892a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3240d = mutableFlatBuffer.a(i, 0, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -305740741)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: stickeroff_input_height */
    public final class LiveVideoViewersCollectionFragmentModel extends BaseModel implements GraphQLVisitableModel {
        private int f3243d;
        @Nullable
        private List<EdgesModel> f3244e;

        /* compiled from: stickeroff_input_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LiveVideoViewersCollectionFragmentModel.class, new Deserializer());
            }

            public Object m3893a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LiveVideoViewersCollectionFragmentParser.m3992a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object liveVideoViewersCollectionFragmentModel = new LiveVideoViewersCollectionFragmentModel();
                ((BaseModel) liveVideoViewersCollectionFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (liveVideoViewersCollectionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) liveVideoViewersCollectionFragmentModel).a();
                }
                return liveVideoViewersCollectionFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1414622125)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: stickeroff_input_height */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private LiveEventAuthorModel f3242d;

            /* compiled from: stickeroff_input_height */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                }

                public Object m3894a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LiveVideoViewersCollectionFragmentParser.EdgesParser.m3990b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object edgesModel = new EdgesModel();
                    ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (edgesModel instanceof Postprocessable) {
                        return ((Postprocessable) edgesModel).a();
                    }
                    return edgesModel;
                }
            }

            /* compiled from: stickeroff_input_height */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m3895a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EdgesModel edgesModel = (EdgesModel) obj;
                    if (edgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(edgesModel.m3896a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LiveVideoViewersCollectionFragmentParser.EdgesParser.m3991b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EdgesModel.class, new Serializer());
                }
            }

            public EdgesModel() {
                super(1);
            }

            @Nullable
            public final LiveEventAuthorModel m3897a() {
                this.f3242d = (LiveEventAuthorModel) super.a(this.f3242d, 0, LiveEventAuthorModel.class);
                return this.f3242d;
            }

            public final int jK_() {
                return -2130898001;
            }

            public final GraphQLVisitableModel m3898a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m3897a() != null) {
                    LiveEventAuthorModel liveEventAuthorModel = (LiveEventAuthorModel) graphQLModelMutatingVisitor.b(m3897a());
                    if (m3897a() != liveEventAuthorModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f3242d = liveEventAuthorModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m3896a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m3897a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Serializer extends JsonSerializer<LiveVideoViewersCollectionFragmentModel> {
            public final void m3899a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LiveVideoViewersCollectionFragmentModel liveVideoViewersCollectionFragmentModel = (LiveVideoViewersCollectionFragmentModel) obj;
                if (liveVideoViewersCollectionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(liveVideoViewersCollectionFragmentModel.m3901a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    liveVideoViewersCollectionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LiveVideoViewersCollectionFragmentParser.m3993a(liveVideoViewersCollectionFragmentModel.w_(), liveVideoViewersCollectionFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(LiveVideoViewersCollectionFragmentModel.class, new Serializer());
            }
        }

        public LiveVideoViewersCollectionFragmentModel() {
            super(2);
        }

        public final int m3900a() {
            a(0, 0);
            return this.f3243d;
        }

        @Nonnull
        public final ImmutableList<EdgesModel> m3904j() {
            this.f3244e = super.a(this.f3244e, 1, EdgesModel.class);
            return (ImmutableList) this.f3244e;
        }

        public final int jK_() {
            return 715548496;
        }

        public final GraphQLVisitableModel m3902a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3904j() != null) {
                Builder a = ModelHelper.a(m3904j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (LiveVideoViewersCollectionFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3244e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3901a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3904j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f3243d, 0);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3903a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3243d = mutableFlatBuffer.a(i, 0, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2045335765)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: stickeroff_input_height */
    public final class LiveVideoViewersQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f3245d;
        @Nullable
        private LiveVideoViewersCollectionFragmentModel f3246e;

        /* compiled from: stickeroff_input_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LiveVideoViewersQueryModel.class, new Deserializer());
            }

            public Object m3905a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = LiveVideoViewersQueryParser.m3994a(jsonParser);
                Object liveVideoViewersQueryModel = new LiveVideoViewersQueryModel();
                ((BaseModel) liveVideoViewersQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (liveVideoViewersQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) liveVideoViewersQueryModel).a();
                }
                return liveVideoViewersQueryModel;
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Serializer extends JsonSerializer<LiveVideoViewersQueryModel> {
            public final void m3906a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LiveVideoViewersQueryModel liveVideoViewersQueryModel = (LiveVideoViewersQueryModel) obj;
                if (liveVideoViewersQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(liveVideoViewersQueryModel.m3908a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    liveVideoViewersQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = liveVideoViewersQueryModel.w_();
                int u_ = liveVideoViewersQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("live_video_viewers");
                    LiveVideoViewersCollectionFragmentParser.m3993a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LiveVideoViewersQueryModel.class, new Serializer());
            }
        }

        public LiveVideoViewersQueryModel() {
            super(2);
        }

        @Nullable
        private String m3907k() {
            this.f3245d = super.a(this.f3245d, 0);
            return this.f3245d;
        }

        @Nullable
        public final LiveVideoViewersCollectionFragmentModel m3911j() {
            this.f3246e = (LiveVideoViewersCollectionFragmentModel) super.a(this.f3246e, 1, LiveVideoViewersCollectionFragmentModel.class);
            return this.f3246e;
        }

        @Nullable
        public final String m3910a() {
            return m3907k();
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m3909a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3911j() != null) {
                LiveVideoViewersCollectionFragmentModel liveVideoViewersCollectionFragmentModel = (LiveVideoViewersCollectionFragmentModel) graphQLModelMutatingVisitor.b(m3911j());
                if (m3911j() != liveVideoViewersCollectionFragmentModel) {
                    graphQLVisitableModel = (LiveVideoViewersQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3246e = liveVideoViewersCollectionFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3908a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m3907k());
            int a = ModelHelper.a(flatBufferBuilder, m3911j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 21794670)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: stickeroff_input_height */
    public final class VideoAnnouncementFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f3247d;
        @Nullable
        private String f3248e;
        private int f3249f;
        @Nullable
        private String f3250g;
        @Nullable
        private String f3251h;

        /* compiled from: stickeroff_input_height */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(VideoAnnouncementFragmentModel.class, new Deserializer());
            }

            public Object m3912a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(VideoAnnouncementFragmentParser.m3996b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object videoAnnouncementFragmentModel = new VideoAnnouncementFragmentModel();
                ((BaseModel) videoAnnouncementFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (videoAnnouncementFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) videoAnnouncementFragmentModel).a();
                }
                return videoAnnouncementFragmentModel;
            }
        }

        /* compiled from: stickeroff_input_height */
        public class Serializer extends JsonSerializer<VideoAnnouncementFragmentModel> {
            public final void m3913a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                VideoAnnouncementFragmentModel videoAnnouncementFragmentModel = (VideoAnnouncementFragmentModel) obj;
                if (videoAnnouncementFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(videoAnnouncementFragmentModel.m3914a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    videoAnnouncementFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                VideoAnnouncementFragmentParser.m3995a(videoAnnouncementFragmentModel.w_(), videoAnnouncementFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(VideoAnnouncementFragmentModel.class, new Serializer());
            }
        }

        public VideoAnnouncementFragmentModel() {
            super(5);
        }

        @Nullable
        public final String m3916a() {
            this.f3247d = super.a(this.f3247d, 0);
            return this.f3247d;
        }

        @Nullable
        public final String m3918j() {
            this.f3248e = super.a(this.f3248e, 1);
            return this.f3248e;
        }

        public final int m3919k() {
            a(0, 2);
            return this.f3249f;
        }

        @Nullable
        public final String m3920l() {
            this.f3250g = super.a(this.f3250g, 3);
            return this.f3250g;
        }

        @Nullable
        public final String m3921m() {
            this.f3251h = super.a(this.f3251h, 4);
            return this.f3251h;
        }

        public final int jK_() {
            return 1376654658;
        }

        public final GraphQLVisitableModel m3915a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m3914a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m3916a());
            int b2 = flatBufferBuilder.b(m3918j());
            int b3 = flatBufferBuilder.b(m3920l());
            int b4 = flatBufferBuilder.b(m3921m());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.a(2, this.f3249f, 0);
            flatBufferBuilder.b(3, b3);
            flatBufferBuilder.b(4, b4);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3917a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3249f = mutableFlatBuffer.a(i, 2, 0);
        }
    }
}
