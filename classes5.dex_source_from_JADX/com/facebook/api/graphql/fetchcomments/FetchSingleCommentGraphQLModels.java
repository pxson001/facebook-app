package com.facebook.api.graphql.fetchcomments;

import com.facebook.api.graphql.comments.NewsFeedCommentsGraphQLModels.TopLevelCommentsConnectionFragmentModel;
import com.facebook.api.graphql.feed.NewsFeedDefaultsCommentsGraphQLModels.CommentFragmentWithoutFeedbackModel.AttachmentsModel;
import com.facebook.api.graphql.feed.NewsFeedDefaultsCommentsGraphQLModels.CommentFragmentWithoutFeedbackOrAttachmentModel.AuthorModel;
import com.facebook.api.graphql.feed.NewsFeedDefaultsCommentsGraphQLModels.CommentFragmentWithoutFeedbackOrAttachmentModel.BodyMarkdownHtmlModel;
import com.facebook.api.graphql.feed.NewsFeedDefaultsCommentsGraphQLModels.CommentFragmentWithoutFeedbackOrAttachmentModel.EditHistoryModel;
import com.facebook.api.graphql.feed.NewsFeedDefaultsCommentsGraphQLModels.CommentTranslatabilityFragmentModel.TranslatabilityForViewerModel;
import com.facebook.api.graphql.feedback.C0963x86c33d71;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLInterfaces.BaseFeedbackFields;
import com.facebook.api.graphql.fetchcomments.FetchSingleCommentGraphQLParsers.FetchSingleCommentQueryParser;
import com.facebook.api.graphql.fetchcomments.FetchSingleCommentGraphQLParsers.FetchSingleCommentQueryParser.FeedbackParser;
import com.facebook.api.graphql.fetchcomments.FetchSingleCommentGraphQLParsers.FetchSingleCommentQueryParser.FeedbackParser.LikersParser;
import com.facebook.api.graphql.fetchcomments.FetchSingleCommentGraphQLParsers.FetchSingleCommentQueryParser.FeedbackParser.SeenByParser;
import com.facebook.api.graphql.fetchcomments.FetchSingleCommentGraphQLParsers.FetchSingleCommentQueryParser.FeedbackParser.ViewerActsAsPageParser;
import com.facebook.api.graphql.fetchcomments.FetchSingleCommentGraphQLParsers.FetchSingleCommentQueryParser.PermalinkTitleParser;
import com.facebook.api.graphql.fetchcomments.FetchSingleCommentGraphQLParsers.FetchSingleCommentQueryParser.PermalinkTitleParser.RangesParser;
import com.facebook.api.graphql.fetchcomments.FetchSingleCommentGraphQLParsers.FetchSingleCommentQueryParser.PermalinkTitleParser.RangesParser.EntityParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLInterfaces.SimpleReactionsFeedbackFields;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ReactionsCountFieldsModel.TopReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.SimpleReactionsFeedbackFieldsModel.ReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsFeedbackFieldsModel.SupportedReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ImportantReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ViewerActsAsPersonModel;
import com.facebook.api.graphql.textwithentities.NewsFeedTextWithEntitiesGraphQLModels.DefaultTextWithEntitiesWithRangesFieldsModel;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
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

/* compiled from: animation_speed */
public class FetchSingleCommentGraphQLModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1616336867)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: animation_speed */
    public final class FetchSingleCommentQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private List<AttachmentsModel> f9612d;
        @Nullable
        private AuthorModel f9613e;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f9614f;
        @Nullable
        private BodyMarkdownHtmlModel f9615g;
        private boolean f9616h;
        private boolean f9617i;
        private long f9618j;
        @Nullable
        private EditHistoryModel f9619k;
        @Nullable
        private FeedbackModel f9620l;
        @Nullable
        private String f9621m;
        private boolean f9622n;
        private boolean f9623o;
        private boolean f9624p;
        @Nullable
        private PermalinkTitleModel f9625q;
        @Nullable
        private TranslatabilityForViewerModel f9626r;

        /* compiled from: animation_speed */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchSingleCommentQueryModel.class, new Deserializer());
            }

            public Object m16388a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FetchSingleCommentQueryParser.m16501a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fetchSingleCommentQueryModel = new FetchSingleCommentQueryModel();
                ((BaseModel) fetchSingleCommentQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fetchSingleCommentQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchSingleCommentQueryModel).a();
                }
                return fetchSingleCommentQueryModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 112680890)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: animation_speed */
        public final class FeedbackModel extends BaseModel implements BaseFeedbackFields, SimpleReactionsFeedbackFields, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private TopLevelCommentsConnectionFragmentModel f9575A;
            @Nullable
            private TopReactionsModel f9576B;
            @Nullable
            private ViewerActsAsPageModel f9577C;
            @Nullable
            private ViewerActsAsPersonModel f9578D;
            @Nullable
            private DefaultTextWithEntitiesWithRangesFieldsModel f9579E;
            private int f9580F;
            @Nullable
            private DefaultTextWithEntitiesWithRangesFieldsModel f9581G;
            private boolean f9582d;
            private boolean f9583e;
            private boolean f9584f;
            private boolean f9585g;
            private boolean f9586h;
            private boolean f9587i;
            private boolean f9588j;
            private boolean f9589k;
            @Nullable
            private DefaultTextWithEntitiesLongFieldsModel f9590l;
            @Nullable
            private String f9591m;
            private boolean f9592n;
            private boolean f9593o;
            private boolean f9594p;
            @Nullable
            private String f9595q;
            @Nullable
            private ImportantReactorsModel f9596r;
            private boolean f9597s;
            @Nullable
            private String f9598t;
            @Nullable
            private DefaultTextWithEntitiesWithRangesFieldsModel f9599u;
            @Nullable
            private LikersModel f9600v;
            @Nullable
            private ReactorsModel f9601w;
            @Nullable
            private String f9602x;
            @Nullable
            private SeenByModel f9603y;
            @Nullable
            private List<SupportedReactionsModel> f9604z;

            /* compiled from: animation_speed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FeedbackModel.class, new Deserializer());
                }

                public Object m16389a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FeedbackParser.m16493a(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: animation_speed */
            public final class LikersModel extends BaseModel implements GraphQLVisitableModel {
                private int f9570d;

                /* compiled from: animation_speed */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(LikersModel.class, new Deserializer());
                    }

                    public Object m16390a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(LikersParser.m16487a(jsonParser, flatBufferBuilder));
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

                /* compiled from: animation_speed */
                public class Serializer extends JsonSerializer<LikersModel> {
                    public final void m16391a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        LikersModel likersModel = (LikersModel) obj;
                        if (likersModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(likersModel.m16393a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            likersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        LikersParser.m16488a(likersModel.w_(), likersModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(LikersModel.class, new Serializer());
                    }
                }

                public LikersModel() {
                    super(1);
                }

                public final int m16392a() {
                    a(0, 0);
                    return this.f9570d;
                }

                public final void m16395a(int i) {
                    this.f9570d = i;
                    if (this.b != null && this.b.d) {
                        this.b.b(this.c, 0, i);
                    }
                }

                public final int jK_() {
                    return 733369288;
                }

                public final GraphQLVisitableModel m16394a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16393a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f9570d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m16396a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f9570d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: animation_speed */
            public final class SeenByModel extends BaseModel implements GraphQLVisitableModel {
                private int f9571d;

                /* compiled from: animation_speed */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(SeenByModel.class, new Deserializer());
                    }

                    public Object m16397a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(SeenByParser.m16489a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object seenByModel = new SeenByModel();
                        ((BaseModel) seenByModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (seenByModel instanceof Postprocessable) {
                            return ((Postprocessable) seenByModel).a();
                        }
                        return seenByModel;
                    }
                }

                /* compiled from: animation_speed */
                public class Serializer extends JsonSerializer<SeenByModel> {
                    public final void m16398a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        SeenByModel seenByModel = (SeenByModel) obj;
                        if (seenByModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(seenByModel.m16400a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            seenByModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        SeenByParser.m16490a(seenByModel.w_(), seenByModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(SeenByModel.class, new Serializer());
                    }
                }

                public SeenByModel() {
                    super(1);
                }

                public final int m16399a() {
                    a(0, 0);
                    return this.f9571d;
                }

                public final void m16402a(int i) {
                    this.f9571d = i;
                    if (this.b != null && this.b.d) {
                        this.b.b(this.c, 0, i);
                    }
                }

                public final int jK_() {
                    return -752571184;
                }

                public final GraphQLVisitableModel m16401a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16400a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f9571d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m16403a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f9571d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: animation_speed */
            public class Serializer extends JsonSerializer<FeedbackModel> {
                public final void m16404a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FeedbackModel feedbackModel = (FeedbackModel) obj;
                    if (feedbackModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(feedbackModel.m16437a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        feedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FeedbackParser.m16494a(feedbackModel.w_(), feedbackModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FeedbackModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 2106355611)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: animation_speed */
            public final class ViewerActsAsPageModel extends BaseModel implements C0963x86c33d71, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f9572d;
                @Nullable
                private String f9573e;
                @Nullable
                private DefaultImageFieldsModel f9574f;

                /* compiled from: animation_speed */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ViewerActsAsPageModel.class, new Deserializer());
                    }

                    public Object m16405a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ViewerActsAsPageParser.m16491a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object viewerActsAsPageModel = new ViewerActsAsPageModel();
                        ((BaseModel) viewerActsAsPageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (viewerActsAsPageModel instanceof Postprocessable) {
                            return ((Postprocessable) viewerActsAsPageModel).a();
                        }
                        return viewerActsAsPageModel;
                    }
                }

                /* compiled from: animation_speed */
                public class Serializer extends JsonSerializer<ViewerActsAsPageModel> {
                    public final void m16406a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ViewerActsAsPageModel viewerActsAsPageModel = (ViewerActsAsPageModel) obj;
                        if (viewerActsAsPageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(viewerActsAsPageModel.m16408a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            viewerActsAsPageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ViewerActsAsPageParser.m16492a(viewerActsAsPageModel.w_(), viewerActsAsPageModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(ViewerActsAsPageModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ DefaultImageFields mo1113d() {
                    return m16407j();
                }

                public ViewerActsAsPageModel() {
                    super(3);
                }

                public final void m16411a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m16412a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final String mo1111b() {
                    this.f9572d = super.a(this.f9572d, 0);
                    return this.f9572d;
                }

                @Nullable
                public final String mo1112c() {
                    this.f9573e = super.a(this.f9573e, 1);
                    return this.f9573e;
                }

                @Nullable
                private DefaultImageFieldsModel m16407j() {
                    this.f9574f = (DefaultImageFieldsModel) super.a(this.f9574f, 2, DefaultImageFieldsModel.class);
                    return this.f9574f;
                }

                @Nullable
                public final String m16410a() {
                    return mo1111b();
                }

                public final int jK_() {
                    return 2479791;
                }

                public final GraphQLVisitableModel m16409a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m16407j() != null) {
                        DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16407j());
                        if (m16407j() != defaultImageFieldsModel) {
                            graphQLVisitableModel = (ViewerActsAsPageModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f9574f = defaultImageFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m16408a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(mo1111b());
                    int b2 = flatBufferBuilder.b(mo1112c());
                    int a = ModelHelper.a(flatBufferBuilder, m16407j());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.b(2, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @Nullable
            public final /* synthetic */ C0963x86c33d71 m16453p() {
                return m16416A();
            }

            public FeedbackModel() {
                super(30);
            }

            public final void m16441a(String str, ConsistencyTuple consistencyTuple) {
                if ("can_viewer_comment".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m16444c());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                } else if ("can_viewer_like".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(bU_());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 5;
                } else if ("does_viewer_like".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m16448k());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 11;
                } else if ("have_comments_been_disabled".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m16428r());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 12;
                } else if ("is_viewer_subscribed".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m16450m());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 15;
                } else {
                    if ("likers.count".equals(str)) {
                        LikersModel u = m16431u();
                        if (u != null) {
                            consistencyTuple.a = Integer.valueOf(u.m16392a());
                            consistencyTuple.b = u.u_();
                            consistencyTuple.c = 0;
                            return;
                        }
                    } else if ("reactors.count".equals(str)) {
                        ReactorsModel v = m16432v();
                        if (v != null) {
                            consistencyTuple.a = Integer.valueOf(v.m17067a());
                            consistencyTuple.b = v.u_();
                            consistencyTuple.c = 0;
                            return;
                        }
                    } else if ("seen_by.count".equals(str)) {
                        SeenByModel w = m16433w();
                        if (w != null) {
                            consistencyTuple.a = Integer.valueOf(w.m16399a());
                            consistencyTuple.b = w.u_();
                            consistencyTuple.c = 0;
                            return;
                        }
                    } else if ("top_level_comments.count".equals(str)) {
                        r0 = m16435y();
                        if (r0 != null) {
                            consistencyTuple.a = Integer.valueOf(r0.m15673a());
                            consistencyTuple.b = r0.u_();
                            consistencyTuple.c = 0;
                            return;
                        }
                    } else if ("top_level_comments.total_count".equals(str)) {
                        r0 = m16435y();
                        if (r0 != null) {
                            consistencyTuple.a = Integer.valueOf(r0.m15679j());
                            consistencyTuple.b = r0.u_();
                            consistencyTuple.c = 3;
                            return;
                        }
                    } else if ("viewer_feedback_reaction_key".equals(str)) {
                        consistencyTuple.a = Integer.valueOf(m16419D());
                        consistencyTuple.b = u_();
                        consistencyTuple.c = 28;
                        return;
                    }
                    consistencyTuple.a();
                }
            }

            public final void m16442a(String str, Object obj, boolean z) {
                if ("can_viewer_comment".equals(str)) {
                    m16422a(((Boolean) obj).booleanValue());
                } else if ("can_viewer_like".equals(str)) {
                    m16423b(((Boolean) obj).booleanValue());
                } else if ("does_viewer_like".equals(str)) {
                    m16424c(((Boolean) obj).booleanValue());
                } else if ("have_comments_been_disabled".equals(str)) {
                    m16425d(((Boolean) obj).booleanValue());
                } else if ("is_viewer_subscribed".equals(str)) {
                    m16426e(((Boolean) obj).booleanValue());
                } else if ("likers.count".equals(str)) {
                    LikersModel u = m16431u();
                    if (u == null) {
                        return;
                    }
                    if (z) {
                        u = (LikersModel) u.clone();
                        u.m16395a(((Integer) obj).intValue());
                        this.f9600v = u;
                        return;
                    }
                    u.m16395a(((Integer) obj).intValue());
                } else if ("reactors.count".equals(str)) {
                    ReactorsModel v = m16432v();
                    if (v == null) {
                        return;
                    }
                    if (z) {
                        v = (ReactorsModel) v.clone();
                        v.m17070a(((Integer) obj).intValue());
                        this.f9601w = v;
                        return;
                    }
                    v.m17070a(((Integer) obj).intValue());
                } else if ("seen_by.count".equals(str)) {
                    SeenByModel w = m16433w();
                    if (w == null) {
                        return;
                    }
                    if (z) {
                        w = (SeenByModel) w.clone();
                        w.m16402a(((Integer) obj).intValue());
                        this.f9603y = w;
                        return;
                    }
                    w.m16402a(((Integer) obj).intValue());
                } else if ("top_level_comments.count".equals(str)) {
                    r0 = m16435y();
                    if (r0 == null) {
                        return;
                    }
                    if (z) {
                        r0 = (TopLevelCommentsConnectionFragmentModel) r0.clone();
                        r0.m15676a(((Integer) obj).intValue());
                        this.f9575A = r0;
                        return;
                    }
                    r0.m15676a(((Integer) obj).intValue());
                } else if ("top_level_comments.total_count".equals(str)) {
                    r0 = m16435y();
                    if (r0 == null) {
                        return;
                    }
                    if (z) {
                        r0 = (TopLevelCommentsConnectionFragmentModel) r0.clone();
                        r0.m15678b(((Integer) obj).intValue());
                        this.f9575A = r0;
                        return;
                    }
                    r0.m15678b(((Integer) obj).intValue());
                } else if ("viewer_feedback_reaction_key".equals(str)) {
                    m16421a(((Integer) obj).intValue());
                }
            }

            public final boolean m16443b() {
                a(0, 0);
                return this.f9582d;
            }

            public final boolean m16444c() {
                a(0, 1);
                return this.f9583e;
            }

            private void m16422a(boolean z) {
                this.f9583e = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, z);
                }
            }

            public final boolean m16445d() {
                a(0, 2);
                return this.f9584f;
            }

            public final boolean bT_() {
                a(0, 3);
                return this.f9585g;
            }

            public final boolean m16446g() {
                a(0, 4);
                return this.f9586h;
            }

            public final boolean bU_() {
                a(0, 5);
                return this.f9587i;
            }

            private void m16423b(boolean z) {
                this.f9587i = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 5, z);
                }
            }

            public final boolean bV_() {
                a(0, 7);
                return this.f9589k;
            }

            @Nullable
            private DefaultTextWithEntitiesLongFieldsModel m16427q() {
                this.f9590l = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f9590l, 8, DefaultTextWithEntitiesLongFieldsModel.class);
                return this.f9590l;
            }

            @Nullable
            public final String m16447j() {
                this.f9591m = super.a(this.f9591m, 9);
                return this.f9591m;
            }

            public final boolean m16448k() {
                a(1, 3);
                return this.f9593o;
            }

            private void m16424c(boolean z) {
                this.f9593o = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 11, z);
                }
            }

            private boolean m16428r() {
                a(1, 4);
                return this.f9594p;
            }

            private void m16425d(boolean z) {
                this.f9594p = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 12, z);
                }
            }

            @Nullable
            public final String m16449l() {
                this.f9595q = super.a(this.f9595q, 13);
                return this.f9595q;
            }

            @Nullable
            private ImportantReactorsModel m16429s() {
                this.f9596r = (ImportantReactorsModel) super.a(this.f9596r, 14, ImportantReactorsModel.class);
                return this.f9596r;
            }

            public final boolean m16450m() {
                a(1, 7);
                return this.f9597s;
            }

            private void m16426e(boolean z) {
                this.f9597s = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 15, z);
                }
            }

            @Nullable
            public final String m16451n() {
                this.f9598t = super.a(this.f9598t, 16);
                return this.f9598t;
            }

            @Nullable
            private DefaultTextWithEntitiesWithRangesFieldsModel m16430t() {
                this.f9599u = (DefaultTextWithEntitiesWithRangesFieldsModel) super.a(this.f9599u, 17, DefaultTextWithEntitiesWithRangesFieldsModel.class);
                return this.f9599u;
            }

            @Nullable
            private LikersModel m16431u() {
                this.f9600v = (LikersModel) super.a(this.f9600v, 18, LikersModel.class);
                return this.f9600v;
            }

            @Nullable
            private ReactorsModel m16432v() {
                this.f9601w = (ReactorsModel) super.a(this.f9601w, 19, ReactorsModel.class);
                return this.f9601w;
            }

            @Nullable
            public final String m16452o() {
                this.f9602x = super.a(this.f9602x, 20);
                return this.f9602x;
            }

            @Nullable
            private SeenByModel m16433w() {
                this.f9603y = (SeenByModel) super.a(this.f9603y, 21, SeenByModel.class);
                return this.f9603y;
            }

            @Nonnull
            private ImmutableList<SupportedReactionsModel> m16434x() {
                this.f9604z = super.a(this.f9604z, 22, SupportedReactionsModel.class);
                return (ImmutableList) this.f9604z;
            }

            @Nullable
            private TopLevelCommentsConnectionFragmentModel m16435y() {
                this.f9575A = (TopLevelCommentsConnectionFragmentModel) super.a(this.f9575A, 23, TopLevelCommentsConnectionFragmentModel.class);
                return this.f9575A;
            }

            @Nullable
            private TopReactionsModel m16436z() {
                this.f9576B = (TopReactionsModel) super.a(this.f9576B, 24, TopReactionsModel.class);
                return this.f9576B;
            }

            @Nullable
            private ViewerActsAsPageModel m16416A() {
                this.f9577C = (ViewerActsAsPageModel) super.a(this.f9577C, 25, ViewerActsAsPageModel.class);
                return this.f9577C;
            }

            @Nullable
            private ViewerActsAsPersonModel m16417B() {
                this.f9578D = (ViewerActsAsPersonModel) super.a(this.f9578D, 26, ViewerActsAsPersonModel.class);
                return this.f9578D;
            }

            @Nullable
            private DefaultTextWithEntitiesWithRangesFieldsModel m16418C() {
                this.f9579E = (DefaultTextWithEntitiesWithRangesFieldsModel) super.a(this.f9579E, 27, DefaultTextWithEntitiesWithRangesFieldsModel.class);
                return this.f9579E;
            }

            private int m16419D() {
                a(3, 4);
                return this.f9580F;
            }

            private void m16421a(int i) {
                this.f9580F = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 28, i);
                }
            }

            @Nullable
            private DefaultTextWithEntitiesWithRangesFieldsModel m16420E() {
                this.f9581G = (DefaultTextWithEntitiesWithRangesFieldsModel) super.a(this.f9581G, 29, DefaultTextWithEntitiesWithRangesFieldsModel.class);
                return this.f9581G;
            }

            @Nullable
            public final String m16439a() {
                return m16451n();
            }

            public final int jK_() {
                return -126857307;
            }

            public final GraphQLVisitableModel m16438a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                DefaultTextWithEntitiesWithRangesFieldsModel defaultTextWithEntitiesWithRangesFieldsModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16427q() != null) {
                    DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m16427q());
                    if (m16427q() != defaultTextWithEntitiesLongFieldsModel) {
                        graphQLVisitableModel = (FeedbackModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9590l = defaultTextWithEntitiesLongFieldsModel;
                    }
                }
                if (m16429s() != null) {
                    ImportantReactorsModel importantReactorsModel = (ImportantReactorsModel) graphQLModelMutatingVisitor.b(m16429s());
                    if (m16429s() != importantReactorsModel) {
                        graphQLVisitableModel = (FeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9596r = importantReactorsModel;
                    }
                }
                if (m16430t() != null) {
                    defaultTextWithEntitiesWithRangesFieldsModel = (DefaultTextWithEntitiesWithRangesFieldsModel) graphQLModelMutatingVisitor.b(m16430t());
                    if (m16430t() != defaultTextWithEntitiesWithRangesFieldsModel) {
                        graphQLVisitableModel = (FeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9599u = defaultTextWithEntitiesWithRangesFieldsModel;
                    }
                }
                if (m16431u() != null) {
                    LikersModel likersModel = (LikersModel) graphQLModelMutatingVisitor.b(m16431u());
                    if (m16431u() != likersModel) {
                        graphQLVisitableModel = (FeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9600v = likersModel;
                    }
                }
                if (m16432v() != null) {
                    ReactorsModel reactorsModel = (ReactorsModel) graphQLModelMutatingVisitor.b(m16432v());
                    if (m16432v() != reactorsModel) {
                        graphQLVisitableModel = (FeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9601w = reactorsModel;
                    }
                }
                if (m16433w() != null) {
                    SeenByModel seenByModel = (SeenByModel) graphQLModelMutatingVisitor.b(m16433w());
                    if (m16433w() != seenByModel) {
                        graphQLVisitableModel = (FeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9603y = seenByModel;
                    }
                }
                if (m16434x() != null) {
                    Builder a = ModelHelper.a(m16434x(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        FeedbackModel feedbackModel = (FeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                        feedbackModel.f9604z = a.b();
                        graphQLVisitableModel = feedbackModel;
                    }
                }
                if (m16435y() != null) {
                    TopLevelCommentsConnectionFragmentModel topLevelCommentsConnectionFragmentModel = (TopLevelCommentsConnectionFragmentModel) graphQLModelMutatingVisitor.b(m16435y());
                    if (m16435y() != topLevelCommentsConnectionFragmentModel) {
                        graphQLVisitableModel = (FeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9575A = topLevelCommentsConnectionFragmentModel;
                    }
                }
                if (m16436z() != null) {
                    TopReactionsModel topReactionsModel = (TopReactionsModel) graphQLModelMutatingVisitor.b(m16436z());
                    if (m16436z() != topReactionsModel) {
                        graphQLVisitableModel = (FeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9576B = topReactionsModel;
                    }
                }
                if (m16416A() != null) {
                    ViewerActsAsPageModel viewerActsAsPageModel = (ViewerActsAsPageModel) graphQLModelMutatingVisitor.b(m16416A());
                    if (m16416A() != viewerActsAsPageModel) {
                        graphQLVisitableModel = (FeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9577C = viewerActsAsPageModel;
                    }
                }
                if (m16417B() != null) {
                    ViewerActsAsPersonModel viewerActsAsPersonModel = (ViewerActsAsPersonModel) graphQLModelMutatingVisitor.b(m16417B());
                    if (m16417B() != viewerActsAsPersonModel) {
                        graphQLVisitableModel = (FeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9578D = viewerActsAsPersonModel;
                    }
                }
                if (m16418C() != null) {
                    defaultTextWithEntitiesWithRangesFieldsModel = (DefaultTextWithEntitiesWithRangesFieldsModel) graphQLModelMutatingVisitor.b(m16418C());
                    if (m16418C() != defaultTextWithEntitiesWithRangesFieldsModel) {
                        graphQLVisitableModel = (FeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9579E = defaultTextWithEntitiesWithRangesFieldsModel;
                    }
                }
                if (m16420E() != null) {
                    defaultTextWithEntitiesWithRangesFieldsModel = (DefaultTextWithEntitiesWithRangesFieldsModel) graphQLModelMutatingVisitor.b(m16420E());
                    if (m16420E() != defaultTextWithEntitiesWithRangesFieldsModel) {
                        graphQLVisitableModel = (FeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9581G = defaultTextWithEntitiesWithRangesFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16437a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16427q());
                int b = flatBufferBuilder.b(m16447j());
                int b2 = flatBufferBuilder.b(m16449l());
                int a2 = ModelHelper.a(flatBufferBuilder, m16429s());
                int b3 = flatBufferBuilder.b(m16451n());
                int a3 = ModelHelper.a(flatBufferBuilder, m16430t());
                int a4 = ModelHelper.a(flatBufferBuilder, m16431u());
                int a5 = ModelHelper.a(flatBufferBuilder, m16432v());
                int b4 = flatBufferBuilder.b(m16452o());
                int a6 = ModelHelper.a(flatBufferBuilder, m16433w());
                int a7 = ModelHelper.a(flatBufferBuilder, m16434x());
                int a8 = ModelHelper.a(flatBufferBuilder, m16435y());
                int a9 = ModelHelper.a(flatBufferBuilder, m16436z());
                int a10 = ModelHelper.a(flatBufferBuilder, m16416A());
                int a11 = ModelHelper.a(flatBufferBuilder, m16417B());
                int a12 = ModelHelper.a(flatBufferBuilder, m16418C());
                int a13 = ModelHelper.a(flatBufferBuilder, m16420E());
                flatBufferBuilder.c(30);
                flatBufferBuilder.a(0, this.f9582d);
                flatBufferBuilder.a(1, this.f9583e);
                flatBufferBuilder.a(2, this.f9584f);
                flatBufferBuilder.a(3, this.f9585g);
                flatBufferBuilder.a(4, this.f9586h);
                flatBufferBuilder.a(5, this.f9587i);
                flatBufferBuilder.a(6, this.f9588j);
                flatBufferBuilder.a(7, this.f9589k);
                flatBufferBuilder.b(8, a);
                flatBufferBuilder.b(9, b);
                flatBufferBuilder.a(10, this.f9592n);
                flatBufferBuilder.a(11, this.f9593o);
                flatBufferBuilder.a(12, this.f9594p);
                flatBufferBuilder.b(13, b2);
                flatBufferBuilder.b(14, a2);
                flatBufferBuilder.a(15, this.f9597s);
                flatBufferBuilder.b(16, b3);
                flatBufferBuilder.b(17, a3);
                flatBufferBuilder.b(18, a4);
                flatBufferBuilder.b(19, a5);
                flatBufferBuilder.b(20, b4);
                flatBufferBuilder.b(21, a6);
                flatBufferBuilder.b(22, a7);
                flatBufferBuilder.b(23, a8);
                flatBufferBuilder.b(24, a9);
                flatBufferBuilder.b(25, a10);
                flatBufferBuilder.b(26, a11);
                flatBufferBuilder.b(27, a12);
                flatBufferBuilder.a(28, this.f9580F, 0);
                flatBufferBuilder.b(29, a13);
                i();
                return flatBufferBuilder.d();
            }

            public final void m16440a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9582d = mutableFlatBuffer.a(i, 0);
                this.f9583e = mutableFlatBuffer.a(i, 1);
                this.f9584f = mutableFlatBuffer.a(i, 2);
                this.f9585g = mutableFlatBuffer.a(i, 3);
                this.f9586h = mutableFlatBuffer.a(i, 4);
                this.f9587i = mutableFlatBuffer.a(i, 5);
                this.f9588j = mutableFlatBuffer.a(i, 6);
                this.f9589k = mutableFlatBuffer.a(i, 7);
                this.f9592n = mutableFlatBuffer.a(i, 10);
                this.f9593o = mutableFlatBuffer.a(i, 11);
                this.f9594p = mutableFlatBuffer.a(i, 12);
                this.f9597s = mutableFlatBuffer.a(i, 15);
                this.f9580F = mutableFlatBuffer.a(i, 28, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1256472406)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: animation_speed */
        public final class PermalinkTitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<RangesModel> f9610d;
            @Nullable
            private String f9611e;

            /* compiled from: animation_speed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PermalinkTitleModel.class, new Deserializer());
                }

                public Object m16454a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PermalinkTitleParser.m16499a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object permalinkTitleModel = new PermalinkTitleModel();
                    ((BaseModel) permalinkTitleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (permalinkTitleModel instanceof Postprocessable) {
                        return ((Postprocessable) permalinkTitleModel).a();
                    }
                    return permalinkTitleModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1358709069)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: animation_speed */
            public final class RangesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private EntityModel f9607d;
                private int f9608e;
                private int f9609f;

                /* compiled from: animation_speed */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(RangesModel.class, new Deserializer());
                    }

                    public Object m16455a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(RangesParser.m16497b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object rangesModel = new RangesModel();
                        ((BaseModel) rangesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (rangesModel instanceof Postprocessable) {
                            return ((Postprocessable) rangesModel).a();
                        }
                        return rangesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1787905591)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: animation_speed */
                public final class EntityModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                    @Nullable
                    private GraphQLObjectType f9605d;
                    @Nullable
                    private String f9606e;

                    /* compiled from: animation_speed */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EntityModel.class, new Deserializer());
                        }

                        public Object m16456a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EntityParser.m16495a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object entityModel = new EntityModel();
                            ((BaseModel) entityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (entityModel instanceof Postprocessable) {
                                return ((Postprocessable) entityModel).a();
                            }
                            return entityModel;
                        }
                    }

                    /* compiled from: animation_speed */
                    public class Serializer extends JsonSerializer<EntityModel> {
                        public final void m16457a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EntityModel entityModel = (EntityModel) obj;
                            if (entityModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(entityModel.m16460a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                entityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            EntityParser.m16496a(entityModel.w_(), entityModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(EntityModel.class, new Serializer());
                        }
                    }

                    public EntityModel() {
                        super(2);
                    }

                    @Nullable
                    private GraphQLObjectType m16458j() {
                        if (this.b != null && this.f9605d == null) {
                            this.f9605d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f9605d;
                    }

                    @Nullable
                    private String m16459k() {
                        this.f9606e = super.a(this.f9606e, 1);
                        return this.f9606e;
                    }

                    @Nullable
                    public final String m16462a() {
                        return m16459k();
                    }

                    public final int jK_() {
                        return 2080559107;
                    }

                    public final GraphQLVisitableModel m16461a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m16460a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m16458j());
                        int b = flatBufferBuilder.b(m16459k());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: animation_speed */
                public class Serializer extends JsonSerializer<RangesModel> {
                    public final void m16463a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        RangesModel rangesModel = (RangesModel) obj;
                        if (rangesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(rangesModel.m16465a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            rangesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        RangesParser.m16498b(rangesModel.w_(), rangesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(RangesModel.class, new Serializer());
                    }
                }

                public RangesModel() {
                    super(3);
                }

                @Nullable
                private EntityModel m16464a() {
                    this.f9607d = (EntityModel) super.a(this.f9607d, 0, EntityModel.class);
                    return this.f9607d;
                }

                public final int jK_() {
                    return -1024511161;
                }

                public final GraphQLVisitableModel m16466a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m16464a() != null) {
                        EntityModel entityModel = (EntityModel) graphQLModelMutatingVisitor.b(m16464a());
                        if (m16464a() != entityModel) {
                            graphQLVisitableModel = (RangesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f9607d = entityModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m16465a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m16464a());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.a(1, this.f9608e, 0);
                    flatBufferBuilder.a(2, this.f9609f, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m16467a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f9608e = mutableFlatBuffer.a(i, 1, 0);
                    this.f9609f = mutableFlatBuffer.a(i, 2, 0);
                }
            }

            /* compiled from: animation_speed */
            public class Serializer extends JsonSerializer<PermalinkTitleModel> {
                public final void m16468a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PermalinkTitleModel permalinkTitleModel = (PermalinkTitleModel) obj;
                    if (permalinkTitleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(permalinkTitleModel.m16471a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        permalinkTitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PermalinkTitleParser.m16500a(permalinkTitleModel.w_(), permalinkTitleModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PermalinkTitleModel.class, new Serializer());
                }
            }

            public PermalinkTitleModel() {
                super(2);
            }

            @Nonnull
            private ImmutableList<RangesModel> m16469a() {
                this.f9610d = super.a(this.f9610d, 0, RangesModel.class);
                return (ImmutableList) this.f9610d;
            }

            @Nullable
            private String m16470j() {
                this.f9611e = super.a(this.f9611e, 1);
                return this.f9611e;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m16472a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16469a() != null) {
                    Builder a = ModelHelper.a(m16469a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PermalinkTitleModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9610d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16471a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16469a());
                int b = flatBufferBuilder.b(m16470j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: animation_speed */
        public class Serializer extends JsonSerializer<FetchSingleCommentQueryModel> {
            public final void m16473a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FetchSingleCommentQueryModel fetchSingleCommentQueryModel = (FetchSingleCommentQueryModel) obj;
                if (fetchSingleCommentQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchSingleCommentQueryModel.m16483a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchSingleCommentQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FetchSingleCommentQueryParser.m16502a(fetchSingleCommentQueryModel.w_(), fetchSingleCommentQueryModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FetchSingleCommentQueryModel.class, new Serializer());
            }
        }

        public FetchSingleCommentQueryModel() {
            super(15);
        }

        @Nonnull
        private ImmutableList<AttachmentsModel> m16474j() {
            this.f9612d = super.a(this.f9612d, 0, AttachmentsModel.class);
            return (ImmutableList) this.f9612d;
        }

        @Nullable
        private AuthorModel m16475k() {
            this.f9613e = (AuthorModel) super.a(this.f9613e, 1, AuthorModel.class);
            return this.f9613e;
        }

        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel m16476l() {
            this.f9614f = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f9614f, 2, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f9614f;
        }

        @Nullable
        private BodyMarkdownHtmlModel m16477m() {
            this.f9615g = (BodyMarkdownHtmlModel) super.a(this.f9615g, 3, BodyMarkdownHtmlModel.class);
            return this.f9615g;
        }

        @Nullable
        private EditHistoryModel m16478n() {
            this.f9619k = (EditHistoryModel) super.a(this.f9619k, 7, EditHistoryModel.class);
            return this.f9619k;
        }

        @Nullable
        private FeedbackModel m16479o() {
            this.f9620l = (FeedbackModel) super.a(this.f9620l, 8, FeedbackModel.class);
            return this.f9620l;
        }

        @Nullable
        private String m16480p() {
            this.f9621m = super.a(this.f9621m, 9);
            return this.f9621m;
        }

        @Nullable
        private PermalinkTitleModel m16481q() {
            this.f9625q = (PermalinkTitleModel) super.a(this.f9625q, 13, PermalinkTitleModel.class);
            return this.f9625q;
        }

        @Nullable
        private TranslatabilityForViewerModel m16482r() {
            this.f9626r = (TranslatabilityForViewerModel) super.a(this.f9626r, 14, TranslatabilityForViewerModel.class);
            return this.f9626r;
        }

        @Nullable
        public final String m16485a() {
            return m16480p();
        }

        public final int jK_() {
            return -1679915457;
        }

        public final GraphQLVisitableModel m16484a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            AuthorModel authorModel;
            DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel;
            BodyMarkdownHtmlModel bodyMarkdownHtmlModel;
            EditHistoryModel editHistoryModel;
            FeedbackModel feedbackModel;
            PermalinkTitleModel permalinkTitleModel;
            TranslatabilityForViewerModel translatabilityForViewerModel;
            h();
            if (m16474j() != null) {
                Builder a = ModelHelper.a(m16474j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    FetchSingleCommentQueryModel fetchSingleCommentQueryModel = (FetchSingleCommentQueryModel) ModelHelper.a(null, this);
                    fetchSingleCommentQueryModel.f9612d = a.b();
                    graphQLVisitableModel = fetchSingleCommentQueryModel;
                    if (m16475k() != null) {
                        authorModel = (AuthorModel) graphQLModelMutatingVisitor.b(m16475k());
                        if (m16475k() != authorModel) {
                            graphQLVisitableModel = (FetchSingleCommentQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9613e = authorModel;
                        }
                    }
                    if (m16476l() != null) {
                        defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m16476l());
                        if (m16476l() != defaultTextWithEntitiesLongFieldsModel) {
                            graphQLVisitableModel = (FetchSingleCommentQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9614f = defaultTextWithEntitiesLongFieldsModel;
                        }
                    }
                    if (m16477m() != null) {
                        bodyMarkdownHtmlModel = (BodyMarkdownHtmlModel) graphQLModelMutatingVisitor.b(m16477m());
                        if (m16477m() != bodyMarkdownHtmlModel) {
                            graphQLVisitableModel = (FetchSingleCommentQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9615g = bodyMarkdownHtmlModel;
                        }
                    }
                    if (m16478n() != null) {
                        editHistoryModel = (EditHistoryModel) graphQLModelMutatingVisitor.b(m16478n());
                        if (m16478n() != editHistoryModel) {
                            graphQLVisitableModel = (FetchSingleCommentQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9619k = editHistoryModel;
                        }
                    }
                    if (m16479o() != null) {
                        feedbackModel = (FeedbackModel) graphQLModelMutatingVisitor.b(m16479o());
                        if (m16479o() != feedbackModel) {
                            graphQLVisitableModel = (FetchSingleCommentQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9620l = feedbackModel;
                        }
                    }
                    if (m16481q() != null) {
                        permalinkTitleModel = (PermalinkTitleModel) graphQLModelMutatingVisitor.b(m16481q());
                        if (m16481q() != permalinkTitleModel) {
                            graphQLVisitableModel = (FetchSingleCommentQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9625q = permalinkTitleModel;
                        }
                    }
                    if (m16482r() != null) {
                        translatabilityForViewerModel = (TranslatabilityForViewerModel) graphQLModelMutatingVisitor.b(m16482r());
                        if (m16482r() != translatabilityForViewerModel) {
                            graphQLVisitableModel = (FetchSingleCommentQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9626r = translatabilityForViewerModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m16475k() != null) {
                authorModel = (AuthorModel) graphQLModelMutatingVisitor.b(m16475k());
                if (m16475k() != authorModel) {
                    graphQLVisitableModel = (FetchSingleCommentQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9613e = authorModel;
                }
            }
            if (m16476l() != null) {
                defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m16476l());
                if (m16476l() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (FetchSingleCommentQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9614f = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            if (m16477m() != null) {
                bodyMarkdownHtmlModel = (BodyMarkdownHtmlModel) graphQLModelMutatingVisitor.b(m16477m());
                if (m16477m() != bodyMarkdownHtmlModel) {
                    graphQLVisitableModel = (FetchSingleCommentQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9615g = bodyMarkdownHtmlModel;
                }
            }
            if (m16478n() != null) {
                editHistoryModel = (EditHistoryModel) graphQLModelMutatingVisitor.b(m16478n());
                if (m16478n() != editHistoryModel) {
                    graphQLVisitableModel = (FetchSingleCommentQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9619k = editHistoryModel;
                }
            }
            if (m16479o() != null) {
                feedbackModel = (FeedbackModel) graphQLModelMutatingVisitor.b(m16479o());
                if (m16479o() != feedbackModel) {
                    graphQLVisitableModel = (FetchSingleCommentQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9620l = feedbackModel;
                }
            }
            if (m16481q() != null) {
                permalinkTitleModel = (PermalinkTitleModel) graphQLModelMutatingVisitor.b(m16481q());
                if (m16481q() != permalinkTitleModel) {
                    graphQLVisitableModel = (FetchSingleCommentQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9625q = permalinkTitleModel;
                }
            }
            if (m16482r() != null) {
                translatabilityForViewerModel = (TranslatabilityForViewerModel) graphQLModelMutatingVisitor.b(m16482r());
                if (m16482r() != translatabilityForViewerModel) {
                    graphQLVisitableModel = (FetchSingleCommentQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9626r = translatabilityForViewerModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m16483a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16474j());
            int a2 = ModelHelper.a(flatBufferBuilder, m16475k());
            int a3 = ModelHelper.a(flatBufferBuilder, m16476l());
            int a4 = ModelHelper.a(flatBufferBuilder, m16477m());
            int a5 = ModelHelper.a(flatBufferBuilder, m16478n());
            int a6 = ModelHelper.a(flatBufferBuilder, m16479o());
            int b = flatBufferBuilder.b(m16480p());
            int a7 = ModelHelper.a(flatBufferBuilder, m16481q());
            int a8 = ModelHelper.a(flatBufferBuilder, m16482r());
            flatBufferBuilder.c(15);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.a(4, this.f9616h);
            flatBufferBuilder.a(5, this.f9617i);
            flatBufferBuilder.a(6, this.f9618j, 0);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.b(8, a6);
            flatBufferBuilder.b(9, b);
            flatBufferBuilder.a(10, this.f9622n);
            flatBufferBuilder.a(11, this.f9623o);
            flatBufferBuilder.a(12, this.f9624p);
            flatBufferBuilder.b(13, a7);
            flatBufferBuilder.b(14, a8);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16486a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9616h = mutableFlatBuffer.a(i, 4);
            this.f9617i = mutableFlatBuffer.a(i, 5);
            this.f9618j = mutableFlatBuffer.a(i, 6, 0);
            this.f9622n = mutableFlatBuffer.a(i, 10);
            this.f9623o = mutableFlatBuffer.a(i, 11);
            this.f9624p = mutableFlatBuffer.a(i, 12);
        }
    }
}
