package com.facebook.api.graphql.fetchfeedback;

import com.facebook.api.graphql.feedback.C0963x86c33d71;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLInterfaces.SimpleFeedFeedback;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.BaseFeedbackFieldsModel.ViewerActsAsPageModel;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.FeedbackRealTimeActivityInfoFieldsModel.RealTimeActivityInfoModel;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.SimpleFeedFeedbackModel.LikersModel;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.SimpleFeedFeedbackModel.ResharesModel;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.SimpleFeedFeedbackModel.TopLevelCommentsModel;
import com.facebook.api.graphql.fetchfeedback.FetchFeedbackGraphQLParsers.FetchFeedbackBaseFeedbackParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ReactionsCountFieldsModel.TopReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.SimpleReactionsFeedbackFieldsModel.ReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsFeedbackFieldsModel.SupportedReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ImportantReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ViewerActsAsPersonModel;
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

/* compiled from: animated_gif */
public class FetchFeedbackGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1691851477)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: animated_gif */
    public final class FetchFeedbackBaseFeedbackModel extends BaseModel implements SimpleFeedFeedback, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private ViewerActsAsPageModel f9627A;
        @Nullable
        private ViewerActsAsPersonModel f9628B;
        private int f9629C;
        private boolean f9630d;
        private boolean f9631e;
        private boolean f9632f;
        private boolean f9633g;
        private boolean f9634h;
        private boolean f9635i;
        private boolean f9636j;
        private boolean f9637k;
        @Nullable
        private String f9638l;
        private boolean f9639m;
        private boolean f9640n;
        @Nullable
        private String f9641o;
        @Nullable
        private ImportantReactorsModel f9642p;
        private boolean f9643q;
        @Nullable
        private String f9644r;
        @Nullable
        private LikersModel f9645s;
        @Nullable
        private ReactorsModel f9646t;
        @Nullable
        private RealTimeActivityInfoModel f9647u;
        @Nullable
        private String f9648v;
        @Nullable
        private ResharesModel f9649w;
        @Nullable
        private List<SupportedReactionsModel> f9650x;
        @Nullable
        private TopLevelCommentsModel f9651y;
        @Nullable
        private TopReactionsModel f9652z;

        /* compiled from: animated_gif */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchFeedbackBaseFeedbackModel.class, new Deserializer());
            }

            public Object m16504a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FetchFeedbackBaseFeedbackParser.m16539a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fetchFeedbackBaseFeedbackModel = new FetchFeedbackBaseFeedbackModel();
                ((BaseModel) fetchFeedbackBaseFeedbackModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fetchFeedbackBaseFeedbackModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchFeedbackBaseFeedbackModel).a();
                }
                return fetchFeedbackBaseFeedbackModel;
            }
        }

        /* compiled from: animated_gif */
        public class Serializer extends JsonSerializer<FetchFeedbackBaseFeedbackModel> {
            public final void m16505a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FetchFeedbackBaseFeedbackModel fetchFeedbackBaseFeedbackModel = (FetchFeedbackBaseFeedbackModel) obj;
                if (fetchFeedbackBaseFeedbackModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchFeedbackBaseFeedbackModel.m16522a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchFeedbackBaseFeedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FetchFeedbackBaseFeedbackParser.m16540a(fetchFeedbackBaseFeedbackModel.w_(), fetchFeedbackBaseFeedbackModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FetchFeedbackBaseFeedbackModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ C0963x86c33d71 m16538p() {
            return m16520y();
        }

        public FetchFeedbackBaseFeedbackModel() {
            super(26);
        }

        public final void m16526a(String str, ConsistencyTuple consistencyTuple) {
            if ("can_viewer_comment".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m16529c());
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
            } else if ("can_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(bU_());
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
            } else if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m16533k());
                consistencyTuple.b = u_();
                consistencyTuple.c = 10;
            } else if ("is_viewer_subscribed".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m16535m());
                consistencyTuple.b = u_();
                consistencyTuple.c = 13;
            } else {
                if ("likers.count".equals(str)) {
                    LikersModel r = m16513r();
                    if (r != null) {
                        consistencyTuple.a = Integer.valueOf(r.m16225a());
                        consistencyTuple.b = r.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("reactors.count".equals(str)) {
                    ReactorsModel s = m16514s();
                    if (s != null) {
                        consistencyTuple.a = Integer.valueOf(s.m17067a());
                        consistencyTuple.b = s.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("reshares.count".equals(str)) {
                    ResharesModel u = m16516u();
                    if (u != null) {
                        consistencyTuple.a = Integer.valueOf(u.m16232a());
                        consistencyTuple.b = u.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("top_level_comments.count".equals(str)) {
                    r0 = m16518w();
                    if (r0 != null) {
                        consistencyTuple.a = Integer.valueOf(r0.m16240a());
                        consistencyTuple.b = r0.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("top_level_comments.total_count".equals(str)) {
                    r0 = m16518w();
                    if (r0 != null) {
                        consistencyTuple.a = Integer.valueOf(r0.m16245b());
                        consistencyTuple.b = r0.u_();
                        consistencyTuple.c = 1;
                        return;
                    }
                } else if ("viewer_feedback_reaction_key".equals(str)) {
                    consistencyTuple.a = Integer.valueOf(m16506A());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 25;
                    return;
                }
                consistencyTuple.a();
            }
        }

        public final void m16527a(String str, Object obj, boolean z) {
            if ("can_viewer_comment".equals(str)) {
                m16508a(((Boolean) obj).booleanValue());
            } else if ("can_viewer_like".equals(str)) {
                m16509b(((Boolean) obj).booleanValue());
            } else if ("does_viewer_like".equals(str)) {
                m16510c(((Boolean) obj).booleanValue());
            } else if ("is_viewer_subscribed".equals(str)) {
                m16511d(((Boolean) obj).booleanValue());
            } else if ("likers.count".equals(str)) {
                LikersModel r = m16513r();
                if (r == null) {
                    return;
                }
                if (z) {
                    r = (LikersModel) r.clone();
                    r.m16228a(((Integer) obj).intValue());
                    this.f9645s = r;
                    return;
                }
                r.m16228a(((Integer) obj).intValue());
            } else if ("reactors.count".equals(str)) {
                ReactorsModel s = m16514s();
                if (s == null) {
                    return;
                }
                if (z) {
                    s = (ReactorsModel) s.clone();
                    s.m17070a(((Integer) obj).intValue());
                    this.f9646t = s;
                    return;
                }
                s.m17070a(((Integer) obj).intValue());
            } else if ("reshares.count".equals(str)) {
                ResharesModel u = m16516u();
                if (u == null) {
                    return;
                }
                if (z) {
                    u = (ResharesModel) u.clone();
                    u.m16235a(((Integer) obj).intValue());
                    this.f9649w = u;
                    return;
                }
                u.m16235a(((Integer) obj).intValue());
            } else if ("top_level_comments.count".equals(str)) {
                r0 = m16518w();
                if (r0 == null) {
                    return;
                }
                if (z) {
                    r0 = (TopLevelCommentsModel) r0.clone();
                    r0.m16243a(((Integer) obj).intValue());
                    this.f9651y = r0;
                    return;
                }
                r0.m16243a(((Integer) obj).intValue());
            } else if ("top_level_comments.total_count".equals(str)) {
                r0 = m16518w();
                if (r0 == null) {
                    return;
                }
                if (z) {
                    r0 = (TopLevelCommentsModel) r0.clone();
                    r0.m16246b(((Integer) obj).intValue());
                    this.f9651y = r0;
                    return;
                }
                r0.m16246b(((Integer) obj).intValue());
            } else if ("viewer_feedback_reaction_key".equals(str)) {
                m16507a(((Integer) obj).intValue());
            }
        }

        public final boolean m16528b() {
            a(0, 0);
            return this.f9630d;
        }

        public final boolean m16529c() {
            a(0, 1);
            return this.f9631e;
        }

        private void m16508a(boolean z) {
            this.f9631e = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, z);
            }
        }

        public final boolean m16530d() {
            a(0, 2);
            return this.f9632f;
        }

        public final boolean bT_() {
            a(0, 3);
            return this.f9633g;
        }

        public final boolean m16531g() {
            a(0, 4);
            return this.f9634h;
        }

        public final boolean bU_() {
            a(0, 5);
            return this.f9635i;
        }

        private void m16509b(boolean z) {
            this.f9635i = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, z);
            }
        }

        public final boolean bV_() {
            a(0, 7);
            return this.f9637k;
        }

        @Nullable
        public final String m16532j() {
            this.f9638l = super.a(this.f9638l, 8);
            return this.f9638l;
        }

        public final boolean m16533k() {
            a(1, 2);
            return this.f9640n;
        }

        private void m16510c(boolean z) {
            this.f9640n = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 10, z);
            }
        }

        @Nullable
        public final String m16534l() {
            this.f9641o = super.a(this.f9641o, 11);
            return this.f9641o;
        }

        @Nullable
        private ImportantReactorsModel m16512q() {
            this.f9642p = (ImportantReactorsModel) super.a(this.f9642p, 12, ImportantReactorsModel.class);
            return this.f9642p;
        }

        public final boolean m16535m() {
            a(1, 5);
            return this.f9643q;
        }

        private void m16511d(boolean z) {
            this.f9643q = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 13, z);
            }
        }

        @Nullable
        public final String m16536n() {
            this.f9644r = super.a(this.f9644r, 14);
            return this.f9644r;
        }

        @Nullable
        private LikersModel m16513r() {
            this.f9645s = (LikersModel) super.a(this.f9645s, 15, LikersModel.class);
            return this.f9645s;
        }

        @Nullable
        private ReactorsModel m16514s() {
            this.f9646t = (ReactorsModel) super.a(this.f9646t, 16, ReactorsModel.class);
            return this.f9646t;
        }

        @Nullable
        private RealTimeActivityInfoModel m16515t() {
            this.f9647u = (RealTimeActivityInfoModel) super.a(this.f9647u, 17, RealTimeActivityInfoModel.class);
            return this.f9647u;
        }

        @Nullable
        public final String m16537o() {
            this.f9648v = super.a(this.f9648v, 18);
            return this.f9648v;
        }

        @Nullable
        private ResharesModel m16516u() {
            this.f9649w = (ResharesModel) super.a(this.f9649w, 19, ResharesModel.class);
            return this.f9649w;
        }

        @Nonnull
        private ImmutableList<SupportedReactionsModel> m16517v() {
            this.f9650x = super.a(this.f9650x, 20, SupportedReactionsModel.class);
            return (ImmutableList) this.f9650x;
        }

        @Nullable
        private TopLevelCommentsModel m16518w() {
            this.f9651y = (TopLevelCommentsModel) super.a(this.f9651y, 21, TopLevelCommentsModel.class);
            return this.f9651y;
        }

        @Nullable
        private TopReactionsModel m16519x() {
            this.f9652z = (TopReactionsModel) super.a(this.f9652z, 22, TopReactionsModel.class);
            return this.f9652z;
        }

        @Nullable
        private ViewerActsAsPageModel m16520y() {
            this.f9627A = (ViewerActsAsPageModel) super.a(this.f9627A, 23, ViewerActsAsPageModel.class);
            return this.f9627A;
        }

        @Nullable
        private ViewerActsAsPersonModel m16521z() {
            this.f9628B = (ViewerActsAsPersonModel) super.a(this.f9628B, 24, ViewerActsAsPersonModel.class);
            return this.f9628B;
        }

        private int m16506A() {
            a(3, 1);
            return this.f9629C;
        }

        private void m16507a(int i) {
            this.f9629C = i;
            if (this.b != null && this.b.d) {
                this.b.b(this.c, 25, i);
            }
        }

        @Nullable
        public final String m16524a() {
            return m16536n();
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m16523a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16512q() != null) {
                ImportantReactorsModel importantReactorsModel = (ImportantReactorsModel) graphQLModelMutatingVisitor.b(m16512q());
                if (m16512q() != importantReactorsModel) {
                    graphQLVisitableModel = (FetchFeedbackBaseFeedbackModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9642p = importantReactorsModel;
                }
            }
            if (m16513r() != null) {
                LikersModel likersModel = (LikersModel) graphQLModelMutatingVisitor.b(m16513r());
                if (m16513r() != likersModel) {
                    graphQLVisitableModel = (FetchFeedbackBaseFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9645s = likersModel;
                }
            }
            if (m16514s() != null) {
                ReactorsModel reactorsModel = (ReactorsModel) graphQLModelMutatingVisitor.b(m16514s());
                if (m16514s() != reactorsModel) {
                    graphQLVisitableModel = (FetchFeedbackBaseFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9646t = reactorsModel;
                }
            }
            if (m16515t() != null) {
                RealTimeActivityInfoModel realTimeActivityInfoModel = (RealTimeActivityInfoModel) graphQLModelMutatingVisitor.b(m16515t());
                if (m16515t() != realTimeActivityInfoModel) {
                    graphQLVisitableModel = (FetchFeedbackBaseFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9647u = realTimeActivityInfoModel;
                }
            }
            if (m16516u() != null) {
                ResharesModel resharesModel = (ResharesModel) graphQLModelMutatingVisitor.b(m16516u());
                if (m16516u() != resharesModel) {
                    graphQLVisitableModel = (FetchFeedbackBaseFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9649w = resharesModel;
                }
            }
            if (m16517v() != null) {
                Builder a = ModelHelper.a(m16517v(), graphQLModelMutatingVisitor);
                if (a != null) {
                    FetchFeedbackBaseFeedbackModel fetchFeedbackBaseFeedbackModel = (FetchFeedbackBaseFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    fetchFeedbackBaseFeedbackModel.f9650x = a.b();
                    graphQLVisitableModel = fetchFeedbackBaseFeedbackModel;
                }
            }
            if (m16518w() != null) {
                TopLevelCommentsModel topLevelCommentsModel = (TopLevelCommentsModel) graphQLModelMutatingVisitor.b(m16518w());
                if (m16518w() != topLevelCommentsModel) {
                    graphQLVisitableModel = (FetchFeedbackBaseFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9651y = topLevelCommentsModel;
                }
            }
            if (m16519x() != null) {
                TopReactionsModel topReactionsModel = (TopReactionsModel) graphQLModelMutatingVisitor.b(m16519x());
                if (m16519x() != topReactionsModel) {
                    graphQLVisitableModel = (FetchFeedbackBaseFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9652z = topReactionsModel;
                }
            }
            if (m16520y() != null) {
                ViewerActsAsPageModel viewerActsAsPageModel = (ViewerActsAsPageModel) graphQLModelMutatingVisitor.b(m16520y());
                if (m16520y() != viewerActsAsPageModel) {
                    graphQLVisitableModel = (FetchFeedbackBaseFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9627A = viewerActsAsPageModel;
                }
            }
            if (m16521z() != null) {
                ViewerActsAsPersonModel viewerActsAsPersonModel = (ViewerActsAsPersonModel) graphQLModelMutatingVisitor.b(m16521z());
                if (m16521z() != viewerActsAsPersonModel) {
                    graphQLVisitableModel = (FetchFeedbackBaseFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9628B = viewerActsAsPersonModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16522a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16532j());
            int b2 = flatBufferBuilder.b(m16534l());
            int a = ModelHelper.a(flatBufferBuilder, m16512q());
            int b3 = flatBufferBuilder.b(m16536n());
            int a2 = ModelHelper.a(flatBufferBuilder, m16513r());
            int a3 = ModelHelper.a(flatBufferBuilder, m16514s());
            int a4 = ModelHelper.a(flatBufferBuilder, m16515t());
            int b4 = flatBufferBuilder.b(m16537o());
            int a5 = ModelHelper.a(flatBufferBuilder, m16516u());
            int a6 = ModelHelper.a(flatBufferBuilder, m16517v());
            int a7 = ModelHelper.a(flatBufferBuilder, m16518w());
            int a8 = ModelHelper.a(flatBufferBuilder, m16519x());
            int a9 = ModelHelper.a(flatBufferBuilder, m16520y());
            int a10 = ModelHelper.a(flatBufferBuilder, m16521z());
            flatBufferBuilder.c(26);
            flatBufferBuilder.a(0, this.f9630d);
            flatBufferBuilder.a(1, this.f9631e);
            flatBufferBuilder.a(2, this.f9632f);
            flatBufferBuilder.a(3, this.f9633g);
            flatBufferBuilder.a(4, this.f9634h);
            flatBufferBuilder.a(5, this.f9635i);
            flatBufferBuilder.a(6, this.f9636j);
            flatBufferBuilder.a(7, this.f9637k);
            flatBufferBuilder.b(8, b);
            flatBufferBuilder.a(9, this.f9639m);
            flatBufferBuilder.a(10, this.f9640n);
            flatBufferBuilder.b(11, b2);
            flatBufferBuilder.b(12, a);
            flatBufferBuilder.a(13, this.f9643q);
            flatBufferBuilder.b(14, b3);
            flatBufferBuilder.b(15, a2);
            flatBufferBuilder.b(16, a3);
            flatBufferBuilder.b(17, a4);
            flatBufferBuilder.b(18, b4);
            flatBufferBuilder.b(19, a5);
            flatBufferBuilder.b(20, a6);
            flatBufferBuilder.b(21, a7);
            flatBufferBuilder.b(22, a8);
            flatBufferBuilder.b(23, a9);
            flatBufferBuilder.b(24, a10);
            flatBufferBuilder.a(25, this.f9629C, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16525a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9630d = mutableFlatBuffer.a(i, 0);
            this.f9631e = mutableFlatBuffer.a(i, 1);
            this.f9632f = mutableFlatBuffer.a(i, 2);
            this.f9633g = mutableFlatBuffer.a(i, 3);
            this.f9634h = mutableFlatBuffer.a(i, 4);
            this.f9635i = mutableFlatBuffer.a(i, 5);
            this.f9636j = mutableFlatBuffer.a(i, 6);
            this.f9637k = mutableFlatBuffer.a(i, 7);
            this.f9639m = mutableFlatBuffer.a(i, 9);
            this.f9640n = mutableFlatBuffer.a(i, 10);
            this.f9643q = mutableFlatBuffer.a(i, 13);
            this.f9629C = mutableFlatBuffer.a(i, 25, 0);
        }
    }
}
