package com.facebook.api.graphql.feedback;

import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLInterfaces.SimpleFeedFeedback;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.BaseFeedbackFieldsModel.ViewerActsAsPageModel;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.FeedbackRealTimeActivityInfoFieldsModel.RealTimeActivityInfoModel;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.SimpleFeedFeedbackModel.LikersModel;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.SimpleFeedFeedbackModel.ResharesModel;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.SimpleFeedFeedbackModel.TopLevelCommentsModel;
import com.facebook.api.graphql.feedback.NewsFeedFeedbackGraphQLParsers.NewsFeedDefaultsFeedbackParser;
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

/* compiled from: anr_traces */
public class NewsFeedFeedbackGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1727240298)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: anr_traces */
    public final class NewsFeedDefaultsFeedbackModel extends BaseModel implements SimpleFeedFeedback, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private TopReactionsModel f9543A;
        @Nullable
        private ViewerActsAsPageModel f9544B;
        @Nullable
        private ViewerActsAsPersonModel f9545C;
        private int f9546D;
        private boolean f9547d;
        private boolean f9548e;
        private boolean f9549f;
        private boolean f9550g;
        private boolean f9551h;
        private boolean f9552i;
        private boolean f9553j;
        private boolean f9554k;
        @Nullable
        private String f9555l;
        @Nullable
        private String f9556m;
        private boolean f9557n;
        private boolean f9558o;
        @Nullable
        private String f9559p;
        @Nullable
        private ImportantReactorsModel f9560q;
        private boolean f9561r;
        @Nullable
        private String f9562s;
        @Nullable
        private LikersModel f9563t;
        @Nullable
        private ReactorsModel f9564u;
        @Nullable
        private RealTimeActivityInfoModel f9565v;
        @Nullable
        private String f9566w;
        @Nullable
        private ResharesModel f9567x;
        @Nullable
        private List<SupportedReactionsModel> f9568y;
        @Nullable
        private TopLevelCommentsModel f9569z;

        /* compiled from: anr_traces */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NewsFeedDefaultsFeedbackModel.class, new Deserializer());
            }

            public Object m16341a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(NewsFeedDefaultsFeedbackParser.m16377a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object newsFeedDefaultsFeedbackModel = new NewsFeedDefaultsFeedbackModel();
                ((BaseModel) newsFeedDefaultsFeedbackModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (newsFeedDefaultsFeedbackModel instanceof Postprocessable) {
                    return ((Postprocessable) newsFeedDefaultsFeedbackModel).a();
                }
                return newsFeedDefaultsFeedbackModel;
            }
        }

        /* compiled from: anr_traces */
        public class Serializer extends JsonSerializer<NewsFeedDefaultsFeedbackModel> {
            public final void m16342a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                NewsFeedDefaultsFeedbackModel newsFeedDefaultsFeedbackModel = (NewsFeedDefaultsFeedbackModel) obj;
                if (newsFeedDefaultsFeedbackModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(newsFeedDefaultsFeedbackModel.m16360a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    newsFeedDefaultsFeedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                NewsFeedDefaultsFeedbackParser.m16378a(newsFeedDefaultsFeedbackModel.w_(), newsFeedDefaultsFeedbackModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(NewsFeedDefaultsFeedbackModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ C0963x86c33d71 m16376p() {
            return m16359z();
        }

        public NewsFeedDefaultsFeedbackModel() {
            super(27);
        }

        public final void m16364a(String str, ConsistencyTuple consistencyTuple) {
            if ("can_viewer_comment".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m16367c());
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
            } else if ("can_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(bU_());
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
            } else if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m16371k());
                consistencyTuple.b = u_();
                consistencyTuple.c = 11;
            } else if ("is_viewer_subscribed".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m16373m());
                consistencyTuple.b = u_();
                consistencyTuple.c = 14;
            } else {
                if ("likers.count".equals(str)) {
                    LikersModel s = m16352s();
                    if (s != null) {
                        consistencyTuple.a = Integer.valueOf(s.m16225a());
                        consistencyTuple.b = s.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("reactors.count".equals(str)) {
                    ReactorsModel t = m16353t();
                    if (t != null) {
                        consistencyTuple.a = Integer.valueOf(t.m17067a());
                        consistencyTuple.b = t.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("reshares.count".equals(str)) {
                    ResharesModel v = m16355v();
                    if (v != null) {
                        consistencyTuple.a = Integer.valueOf(v.m16232a());
                        consistencyTuple.b = v.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("top_level_comments.count".equals(str)) {
                    r0 = m16357x();
                    if (r0 != null) {
                        consistencyTuple.a = Integer.valueOf(r0.m16240a());
                        consistencyTuple.b = r0.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("top_level_comments.total_count".equals(str)) {
                    r0 = m16357x();
                    if (r0 != null) {
                        consistencyTuple.a = Integer.valueOf(r0.m16245b());
                        consistencyTuple.b = r0.u_();
                        consistencyTuple.c = 1;
                        return;
                    }
                } else if ("viewer_feedback_reaction_key".equals(str)) {
                    consistencyTuple.a = Integer.valueOf(m16344B());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 26;
                    return;
                }
                consistencyTuple.a();
            }
        }

        public final void m16365a(String str, Object obj, boolean z) {
            if ("can_viewer_comment".equals(str)) {
                m16346a(((Boolean) obj).booleanValue());
            } else if ("can_viewer_like".equals(str)) {
                m16347b(((Boolean) obj).booleanValue());
            } else if ("does_viewer_like".equals(str)) {
                m16348c(((Boolean) obj).booleanValue());
            } else if ("is_viewer_subscribed".equals(str)) {
                m16349d(((Boolean) obj).booleanValue());
            } else if ("likers.count".equals(str)) {
                LikersModel s = m16352s();
                if (s == null) {
                    return;
                }
                if (z) {
                    s = (LikersModel) s.clone();
                    s.m16228a(((Integer) obj).intValue());
                    this.f9563t = s;
                    return;
                }
                s.m16228a(((Integer) obj).intValue());
            } else if ("reactors.count".equals(str)) {
                ReactorsModel t = m16353t();
                if (t == null) {
                    return;
                }
                if (z) {
                    t = (ReactorsModel) t.clone();
                    t.m17070a(((Integer) obj).intValue());
                    this.f9564u = t;
                    return;
                }
                t.m17070a(((Integer) obj).intValue());
            } else if ("reshares.count".equals(str)) {
                ResharesModel v = m16355v();
                if (v == null) {
                    return;
                }
                if (z) {
                    v = (ResharesModel) v.clone();
                    v.m16235a(((Integer) obj).intValue());
                    this.f9567x = v;
                    return;
                }
                v.m16235a(((Integer) obj).intValue());
            } else if ("top_level_comments.count".equals(str)) {
                r0 = m16357x();
                if (r0 == null) {
                    return;
                }
                if (z) {
                    r0 = (TopLevelCommentsModel) r0.clone();
                    r0.m16243a(((Integer) obj).intValue());
                    this.f9569z = r0;
                    return;
                }
                r0.m16243a(((Integer) obj).intValue());
            } else if ("top_level_comments.total_count".equals(str)) {
                r0 = m16357x();
                if (r0 == null) {
                    return;
                }
                if (z) {
                    r0 = (TopLevelCommentsModel) r0.clone();
                    r0.m16246b(((Integer) obj).intValue());
                    this.f9569z = r0;
                    return;
                }
                r0.m16246b(((Integer) obj).intValue());
            } else if ("viewer_feedback_reaction_key".equals(str)) {
                m16345a(((Integer) obj).intValue());
            }
        }

        public final boolean m16366b() {
            a(0, 0);
            return this.f9547d;
        }

        public final boolean m16367c() {
            a(0, 1);
            return this.f9548e;
        }

        private void m16346a(boolean z) {
            this.f9548e = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, z);
            }
        }

        public final boolean m16368d() {
            a(0, 2);
            return this.f9549f;
        }

        public final boolean bT_() {
            a(0, 3);
            return this.f9550g;
        }

        public final boolean m16369g() {
            a(0, 4);
            return this.f9551h;
        }

        public final boolean bU_() {
            a(0, 5);
            return this.f9552i;
        }

        private void m16347b(boolean z) {
            this.f9552i = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, z);
            }
        }

        public final boolean bV_() {
            a(0, 7);
            return this.f9554k;
        }

        @Nullable
        public final String m16370j() {
            this.f9555l = super.a(this.f9555l, 8);
            return this.f9555l;
        }

        @Nullable
        private String m16350q() {
            this.f9556m = super.a(this.f9556m, 9);
            return this.f9556m;
        }

        public final boolean m16371k() {
            a(1, 3);
            return this.f9558o;
        }

        private void m16348c(boolean z) {
            this.f9558o = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 11, z);
            }
        }

        @Nullable
        public final String m16372l() {
            this.f9559p = super.a(this.f9559p, 12);
            return this.f9559p;
        }

        @Nullable
        private ImportantReactorsModel m16351r() {
            this.f9560q = (ImportantReactorsModel) super.a(this.f9560q, 13, ImportantReactorsModel.class);
            return this.f9560q;
        }

        public final boolean m16373m() {
            a(1, 6);
            return this.f9561r;
        }

        private void m16349d(boolean z) {
            this.f9561r = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 14, z);
            }
        }

        @Nullable
        public final String m16374n() {
            this.f9562s = super.a(this.f9562s, 15);
            return this.f9562s;
        }

        @Nullable
        private LikersModel m16352s() {
            this.f9563t = (LikersModel) super.a(this.f9563t, 16, LikersModel.class);
            return this.f9563t;
        }

        @Nullable
        private ReactorsModel m16353t() {
            this.f9564u = (ReactorsModel) super.a(this.f9564u, 17, ReactorsModel.class);
            return this.f9564u;
        }

        @Nullable
        private RealTimeActivityInfoModel m16354u() {
            this.f9565v = (RealTimeActivityInfoModel) super.a(this.f9565v, 18, RealTimeActivityInfoModel.class);
            return this.f9565v;
        }

        @Nullable
        public final String m16375o() {
            this.f9566w = super.a(this.f9566w, 19);
            return this.f9566w;
        }

        @Nullable
        private ResharesModel m16355v() {
            this.f9567x = (ResharesModel) super.a(this.f9567x, 20, ResharesModel.class);
            return this.f9567x;
        }

        @Nonnull
        private ImmutableList<SupportedReactionsModel> m16356w() {
            this.f9568y = super.a(this.f9568y, 21, SupportedReactionsModel.class);
            return (ImmutableList) this.f9568y;
        }

        @Nullable
        private TopLevelCommentsModel m16357x() {
            this.f9569z = (TopLevelCommentsModel) super.a(this.f9569z, 22, TopLevelCommentsModel.class);
            return this.f9569z;
        }

        @Nullable
        private TopReactionsModel m16358y() {
            this.f9543A = (TopReactionsModel) super.a(this.f9543A, 23, TopReactionsModel.class);
            return this.f9543A;
        }

        @Nullable
        private ViewerActsAsPageModel m16359z() {
            this.f9544B = (ViewerActsAsPageModel) super.a(this.f9544B, 24, ViewerActsAsPageModel.class);
            return this.f9544B;
        }

        @Nullable
        private ViewerActsAsPersonModel m16343A() {
            this.f9545C = (ViewerActsAsPersonModel) super.a(this.f9545C, 25, ViewerActsAsPersonModel.class);
            return this.f9545C;
        }

        private int m16344B() {
            a(3, 2);
            return this.f9546D;
        }

        private void m16345a(int i) {
            this.f9546D = i;
            if (this.b != null && this.b.d) {
                this.b.b(this.c, 26, i);
            }
        }

        @Nullable
        public final String m16362a() {
            return m16374n();
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m16361a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16351r() != null) {
                ImportantReactorsModel importantReactorsModel = (ImportantReactorsModel) graphQLModelMutatingVisitor.b(m16351r());
                if (m16351r() != importantReactorsModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsFeedbackModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9560q = importantReactorsModel;
                }
            }
            if (m16352s() != null) {
                LikersModel likersModel = (LikersModel) graphQLModelMutatingVisitor.b(m16352s());
                if (m16352s() != likersModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9563t = likersModel;
                }
            }
            if (m16353t() != null) {
                ReactorsModel reactorsModel = (ReactorsModel) graphQLModelMutatingVisitor.b(m16353t());
                if (m16353t() != reactorsModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9564u = reactorsModel;
                }
            }
            if (m16354u() != null) {
                RealTimeActivityInfoModel realTimeActivityInfoModel = (RealTimeActivityInfoModel) graphQLModelMutatingVisitor.b(m16354u());
                if (m16354u() != realTimeActivityInfoModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9565v = realTimeActivityInfoModel;
                }
            }
            if (m16355v() != null) {
                ResharesModel resharesModel = (ResharesModel) graphQLModelMutatingVisitor.b(m16355v());
                if (m16355v() != resharesModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9567x = resharesModel;
                }
            }
            if (m16356w() != null) {
                Builder a = ModelHelper.a(m16356w(), graphQLModelMutatingVisitor);
                if (a != null) {
                    NewsFeedDefaultsFeedbackModel newsFeedDefaultsFeedbackModel = (NewsFeedDefaultsFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    newsFeedDefaultsFeedbackModel.f9568y = a.b();
                    graphQLVisitableModel = newsFeedDefaultsFeedbackModel;
                }
            }
            if (m16357x() != null) {
                TopLevelCommentsModel topLevelCommentsModel = (TopLevelCommentsModel) graphQLModelMutatingVisitor.b(m16357x());
                if (m16357x() != topLevelCommentsModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9569z = topLevelCommentsModel;
                }
            }
            if (m16358y() != null) {
                TopReactionsModel topReactionsModel = (TopReactionsModel) graphQLModelMutatingVisitor.b(m16358y());
                if (m16358y() != topReactionsModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9543A = topReactionsModel;
                }
            }
            if (m16359z() != null) {
                ViewerActsAsPageModel viewerActsAsPageModel = (ViewerActsAsPageModel) graphQLModelMutatingVisitor.b(m16359z());
                if (m16359z() != viewerActsAsPageModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9544B = viewerActsAsPageModel;
                }
            }
            if (m16343A() != null) {
                ViewerActsAsPersonModel viewerActsAsPersonModel = (ViewerActsAsPersonModel) graphQLModelMutatingVisitor.b(m16343A());
                if (m16343A() != viewerActsAsPersonModel) {
                    graphQLVisitableModel = (NewsFeedDefaultsFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9545C = viewerActsAsPersonModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16360a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16370j());
            int b2 = flatBufferBuilder.b(m16350q());
            int b3 = flatBufferBuilder.b(m16372l());
            int a = ModelHelper.a(flatBufferBuilder, m16351r());
            int b4 = flatBufferBuilder.b(m16374n());
            int a2 = ModelHelper.a(flatBufferBuilder, m16352s());
            int a3 = ModelHelper.a(flatBufferBuilder, m16353t());
            int a4 = ModelHelper.a(flatBufferBuilder, m16354u());
            int b5 = flatBufferBuilder.b(m16375o());
            int a5 = ModelHelper.a(flatBufferBuilder, m16355v());
            int a6 = ModelHelper.a(flatBufferBuilder, m16356w());
            int a7 = ModelHelper.a(flatBufferBuilder, m16357x());
            int a8 = ModelHelper.a(flatBufferBuilder, m16358y());
            int a9 = ModelHelper.a(flatBufferBuilder, m16359z());
            int a10 = ModelHelper.a(flatBufferBuilder, m16343A());
            flatBufferBuilder.c(27);
            flatBufferBuilder.a(0, this.f9547d);
            flatBufferBuilder.a(1, this.f9548e);
            flatBufferBuilder.a(2, this.f9549f);
            flatBufferBuilder.a(3, this.f9550g);
            flatBufferBuilder.a(4, this.f9551h);
            flatBufferBuilder.a(5, this.f9552i);
            flatBufferBuilder.a(6, this.f9553j);
            flatBufferBuilder.a(7, this.f9554k);
            flatBufferBuilder.b(8, b);
            flatBufferBuilder.b(9, b2);
            flatBufferBuilder.a(10, this.f9557n);
            flatBufferBuilder.a(11, this.f9558o);
            flatBufferBuilder.b(12, b3);
            flatBufferBuilder.b(13, a);
            flatBufferBuilder.a(14, this.f9561r);
            flatBufferBuilder.b(15, b4);
            flatBufferBuilder.b(16, a2);
            flatBufferBuilder.b(17, a3);
            flatBufferBuilder.b(18, a4);
            flatBufferBuilder.b(19, b5);
            flatBufferBuilder.b(20, a5);
            flatBufferBuilder.b(21, a6);
            flatBufferBuilder.b(22, a7);
            flatBufferBuilder.b(23, a8);
            flatBufferBuilder.b(24, a9);
            flatBufferBuilder.b(25, a10);
            flatBufferBuilder.a(26, this.f9546D, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16363a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9547d = mutableFlatBuffer.a(i, 0);
            this.f9548e = mutableFlatBuffer.a(i, 1);
            this.f9549f = mutableFlatBuffer.a(i, 2);
            this.f9550g = mutableFlatBuffer.a(i, 3);
            this.f9551h = mutableFlatBuffer.a(i, 4);
            this.f9552i = mutableFlatBuffer.a(i, 5);
            this.f9553j = mutableFlatBuffer.a(i, 6);
            this.f9554k = mutableFlatBuffer.a(i, 7);
            this.f9557n = mutableFlatBuffer.a(i, 10);
            this.f9558o = mutableFlatBuffer.a(i, 11);
            this.f9561r = mutableFlatBuffer.a(i, 14);
            this.f9546D = mutableFlatBuffer.a(i, 26, 0);
        }
    }
}
