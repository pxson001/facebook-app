package com.facebook.api.graphql.feed;

import com.facebook.api.graphql.comments.NewsFeedCommentsGraphQLModels.TopLevelCommentsConnectionFragmentModel;
import com.facebook.api.graphql.feed.NewsFeedDefaultsFeedbackGraphQLModels$NewsFeedDefaultsCompleteFeedbackModel.Deserializer;
import com.facebook.api.graphql.feed.NewsFeedDefaultsFeedbackGraphQLModels$NewsFeedDefaultsCompleteFeedbackModel.LikersModel;
import com.facebook.api.graphql.feed.NewsFeedDefaultsFeedbackGraphQLModels$NewsFeedDefaultsCompleteFeedbackModel.ResharesModel;
import com.facebook.api.graphql.feed.NewsFeedDefaultsFeedbackGraphQLModels$NewsFeedDefaultsCompleteFeedbackModel.SeenByModel;
import com.facebook.api.graphql.feed.NewsFeedDefaultsFeedbackGraphQLModels$NewsFeedDefaultsCompleteFeedbackModel.Serializer;
import com.facebook.api.graphql.feed.NewsFeedDefaultsFeedbackGraphQLModels$NewsFeedDefaultsCompleteFeedbackModel.ViewerActsAsPageModel;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLInterfaces$BaseFeedbackFields;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLInterfaces$BaseFeedbackFields.ViewerActsAsPage;
import com.facebook.api.graphql.reactions.ReactionsGraphQLInterfaces$CompleteReactionsFeedbackFields;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.CompleteReactionsCountFieldsModel.TopReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.CompleteReactionsFeedbackFieldsModel.ReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsFeedbackFieldsModel.SupportedReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ImportantReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ViewerActsAsPersonModel;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@FragmentModelWithBridge
@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -1826800442)
@JsonSerialize(using = Serializer.class)
/* compiled from: group_notifs_unseen */
public final class C0861x186baa6f extends BaseModel implements FeedbackDefaultsGraphQLInterfaces$BaseFeedbackFields, ReactionsGraphQLInterfaces$CompleteReactionsFeedbackFields, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    @Nullable
    private SeenByModel f21654A;
    @Nullable
    private List<SupportedReactionsModel> f21655B;
    @Nullable
    private TopLevelCommentsConnectionFragmentModel f21656C;
    @Nullable
    private TopReactionsModel f21657D;
    @Nullable
    private ViewerActsAsPageModel f21658E;
    @Nullable
    private ViewerActsAsPersonModel f21659F;
    private int f21660G;
    private boolean f21661d;
    private boolean f21662e;
    private boolean f21663f;
    private boolean f21664g;
    private boolean f21665h;
    private boolean f21666i;
    private boolean f21667j;
    private boolean f21668k;
    @Nullable
    private DefaultTextWithEntitiesLongFieldsModel f21669l;
    @Nullable
    private String f21670m;
    @Nullable
    private String f21671n;
    private boolean f21672o;
    private boolean f21673p;
    private boolean f21674q;
    private boolean f21675r;
    @Nullable
    private String f21676s;
    @Nullable
    private ImportantReactorsModel f21677t;
    private boolean f21678u;
    @Nullable
    private String f21679v;
    @Nullable
    private LikersModel f21680w;
    @Nullable
    private ReactorsModel f21681x;
    @Nullable
    private String f21682y;
    @Nullable
    private ResharesModel f21683z;

    @Nullable
    public final /* synthetic */ ViewerActsAsPage mo3184p() {
        return m29349B();
    }

    public C0861x186baa6f() {
        super(30);
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("can_viewer_comment".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(mo3175c());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 1;
        } else if ("can_viewer_like".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(bU_());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 5;
        } else if ("does_viewer_like".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(mo3179k());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 12;
        } else if ("have_comments_been_disabled".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(m29360s());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 14;
        } else if ("is_viewer_subscribed".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(mo3181m());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 17;
        } else {
            if ("likers.count".equals(str)) {
                LikersModel u = m29362u();
                if (u != null) {
                    consistencyTuple.f18727a = Integer.valueOf(u.a());
                    consistencyTuple.f18728b = u.u_();
                    consistencyTuple.f18729c = 0;
                    return;
                }
            } else if ("reactors.count".equals(str)) {
                ReactorsModel v = m29363v();
                if (v != null) {
                    consistencyTuple.f18727a = Integer.valueOf(v.a());
                    consistencyTuple.f18728b = v.u_();
                    consistencyTuple.f18729c = 0;
                    return;
                }
            } else if ("reshares.count".equals(str)) {
                ResharesModel w = m29364w();
                if (w != null) {
                    consistencyTuple.f18727a = Integer.valueOf(w.a());
                    consistencyTuple.f18728b = w.u_();
                    consistencyTuple.f18729c = 0;
                    return;
                }
            } else if ("seen_by.count".equals(str)) {
                SeenByModel x = m29365x();
                if (x != null) {
                    consistencyTuple.f18727a = Integer.valueOf(x.a());
                    consistencyTuple.f18728b = x.u_();
                    consistencyTuple.f18729c = 0;
                    return;
                }
            } else if ("top_level_comments.count".equals(str)) {
                r0 = m29367z();
                if (r0 != null) {
                    consistencyTuple.f18727a = Integer.valueOf(r0.a());
                    consistencyTuple.f18728b = r0.u_();
                    consistencyTuple.f18729c = 0;
                    return;
                }
            } else if ("top_level_comments.total_count".equals(str)) {
                r0 = m29367z();
                if (r0 != null) {
                    consistencyTuple.f18727a = Integer.valueOf(r0.j());
                    consistencyTuple.f18728b = r0.u_();
                    consistencyTuple.f18729c = 3;
                    return;
                }
            } else if ("viewer_feedback_reaction_key".equals(str)) {
                consistencyTuple.f18727a = Integer.valueOf(m29351D());
                consistencyTuple.f18728b = u_();
                consistencyTuple.f18729c = 29;
                return;
            }
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        if ("can_viewer_comment".equals(str)) {
            m29353a(((Boolean) obj).booleanValue());
        } else if ("can_viewer_like".equals(str)) {
            m29354b(((Boolean) obj).booleanValue());
        } else if ("does_viewer_like".equals(str)) {
            m29355c(((Boolean) obj).booleanValue());
        } else if ("have_comments_been_disabled".equals(str)) {
            m29356d(((Boolean) obj).booleanValue());
        } else if ("is_viewer_subscribed".equals(str)) {
            m29357e(((Boolean) obj).booleanValue());
        } else if ("likers.count".equals(str)) {
            LikersModel u = m29362u();
            if (u == null) {
                return;
            }
            if (z) {
                u = (LikersModel) u.clone();
                u.a(((Integer) obj).intValue());
                this.f21680w = u;
                return;
            }
            u.a(((Integer) obj).intValue());
        } else if ("reactors.count".equals(str)) {
            ReactorsModel v = m29363v();
            if (v == null) {
                return;
            }
            if (z) {
                v = (ReactorsModel) v.clone();
                v.a(((Integer) obj).intValue());
                this.f21681x = v;
                return;
            }
            v.a(((Integer) obj).intValue());
        } else if ("reshares.count".equals(str)) {
            ResharesModel w = m29364w();
            if (w == null) {
                return;
            }
            if (z) {
                w = (ResharesModel) w.clone();
                w.a(((Integer) obj).intValue());
                this.f21683z = w;
                return;
            }
            w.a(((Integer) obj).intValue());
        } else if ("seen_by.count".equals(str)) {
            SeenByModel x = m29365x();
            if (x == null) {
                return;
            }
            if (z) {
                x = (SeenByModel) x.clone();
                x.a(((Integer) obj).intValue());
                this.f21654A = x;
                return;
            }
            x.a(((Integer) obj).intValue());
        } else if ("top_level_comments.count".equals(str)) {
            r0 = m29367z();
            if (r0 == null) {
                return;
            }
            if (z) {
                r0 = (TopLevelCommentsConnectionFragmentModel) r0.clone();
                r0.a(((Integer) obj).intValue());
                this.f21656C = r0;
                return;
            }
            r0.a(((Integer) obj).intValue());
        } else if ("top_level_comments.total_count".equals(str)) {
            r0 = m29367z();
            if (r0 == null) {
                return;
            }
            if (z) {
                r0 = (TopLevelCommentsConnectionFragmentModel) r0.clone();
                r0.b(((Integer) obj).intValue());
                this.f21656C = r0;
                return;
            }
            r0.b(((Integer) obj).intValue());
        } else if ("viewer_feedback_reaction_key".equals(str)) {
            m29352a(((Integer) obj).intValue());
        }
    }

    public final boolean mo3171b() {
        m9949a(0, 0);
        return this.f21661d;
    }

    public final boolean mo3175c() {
        m9949a(0, 1);
        return this.f21662e;
    }

    private void m29353a(boolean z) {
        this.f21662e = z;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21538a(this.f5824c, 1, z);
        }
    }

    public final boolean mo3176d() {
        m9949a(0, 2);
        return this.f21663f;
    }

    public final boolean bT_() {
        m9949a(0, 3);
        return this.f21664g;
    }

    public final boolean mo3177g() {
        m9949a(0, 4);
        return this.f21665h;
    }

    public final boolean bU_() {
        m9949a(0, 5);
        return this.f21666i;
    }

    private void m29354b(boolean z) {
        this.f21666i = z;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21538a(this.f5824c, 5, z);
        }
    }

    public final boolean bV_() {
        m9949a(0, 7);
        return this.f21668k;
    }

    @Nullable
    private DefaultTextWithEntitiesLongFieldsModel m29358q() {
        this.f21669l = (DefaultTextWithEntitiesLongFieldsModel) super.m9947a(this.f21669l, 8, DefaultTextWithEntitiesLongFieldsModel.class);
        return this.f21669l;
    }

    @Nullable
    public final String mo3178j() {
        this.f21670m = super.m9948a(this.f21670m, 9);
        return this.f21670m;
    }

    @Nullable
    private String m29359r() {
        this.f21671n = super.m9948a(this.f21671n, 10);
        return this.f21671n;
    }

    public final boolean mo3179k() {
        m9949a(1, 4);
        return this.f21673p;
    }

    private void m29355c(boolean z) {
        this.f21673p = z;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21538a(this.f5824c, 12, z);
        }
    }

    private boolean m29360s() {
        m9949a(1, 6);
        return this.f21675r;
    }

    private void m29356d(boolean z) {
        this.f21675r = z;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21538a(this.f5824c, 14, z);
        }
    }

    @Nullable
    public final String mo3180l() {
        this.f21676s = super.m9948a(this.f21676s, 15);
        return this.f21676s;
    }

    @Nullable
    private ImportantReactorsModel m29361t() {
        this.f21677t = (ImportantReactorsModel) super.m9947a(this.f21677t, 16, ImportantReactorsModel.class);
        return this.f21677t;
    }

    public final boolean mo3181m() {
        m9949a(2, 1);
        return this.f21678u;
    }

    private void m29357e(boolean z) {
        this.f21678u = z;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21538a(this.f5824c, 17, z);
        }
    }

    @Nullable
    public final String mo3182n() {
        this.f21679v = super.m9948a(this.f21679v, 18);
        return this.f21679v;
    }

    @Nullable
    private LikersModel m29362u() {
        this.f21680w = (LikersModel) super.m9947a(this.f21680w, 19, LikersModel.class);
        return this.f21680w;
    }

    @Nullable
    private ReactorsModel m29363v() {
        this.f21681x = (ReactorsModel) super.m9947a(this.f21681x, 20, ReactorsModel.class);
        return this.f21681x;
    }

    @Nullable
    public final String mo3183o() {
        this.f21682y = super.m9948a(this.f21682y, 21);
        return this.f21682y;
    }

    @Nullable
    private ResharesModel m29364w() {
        this.f21683z = (ResharesModel) super.m9947a(this.f21683z, 22, ResharesModel.class);
        return this.f21683z;
    }

    @Nullable
    private SeenByModel m29365x() {
        this.f21654A = (SeenByModel) super.m9947a(this.f21654A, 23, SeenByModel.class);
        return this.f21654A;
    }

    @Nonnull
    private ImmutableList<SupportedReactionsModel> m29366y() {
        this.f21655B = super.m9944a(this.f21655B, 24, SupportedReactionsModel.class);
        return (ImmutableList) this.f21655B;
    }

    @Nullable
    private TopLevelCommentsConnectionFragmentModel m29367z() {
        this.f21656C = (TopLevelCommentsConnectionFragmentModel) super.m9947a(this.f21656C, 25, TopLevelCommentsConnectionFragmentModel.class);
        return this.f21656C;
    }

    @Nullable
    private TopReactionsModel m29348A() {
        this.f21657D = (TopReactionsModel) super.m9947a(this.f21657D, 26, TopReactionsModel.class);
        return this.f21657D;
    }

    @Nullable
    private ViewerActsAsPageModel m29349B() {
        this.f21658E = (ViewerActsAsPageModel) super.m9947a(this.f21658E, 27, ViewerActsAsPageModel.class);
        return this.f21658E;
    }

    @Nullable
    private ViewerActsAsPersonModel m29350C() {
        this.f21659F = (ViewerActsAsPersonModel) super.m9947a(this.f21659F, 28, ViewerActsAsPersonModel.class);
        return this.f21659F;
    }

    private int m29351D() {
        m9949a(3, 5);
        return this.f21660G;
    }

    private void m29352a(int i) {
        this.f21660G = i;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21544b(this.f5824c, 29, i);
        }
    }

    @Nullable
    public final String mo2834a() {
        return mo3182n();
    }

    public final int jK_() {
        return -126857307;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m29358q() != null) {
            DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.mo2928b(m29358q());
            if (m29358q() != defaultTextWithEntitiesLongFieldsModel) {
                graphQLVisitableModel = (C0861x186baa6f) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f21669l = defaultTextWithEntitiesLongFieldsModel;
            }
        }
        if (m29361t() != null) {
            ImportantReactorsModel importantReactorsModel = (ImportantReactorsModel) graphQLModelMutatingVisitor.mo2928b(m29361t());
            if (m29361t() != importantReactorsModel) {
                graphQLVisitableModel = (C0861x186baa6f) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f21677t = importantReactorsModel;
            }
        }
        if (m29362u() != null) {
            LikersModel likersModel = (LikersModel) graphQLModelMutatingVisitor.mo2928b(m29362u());
            if (m29362u() != likersModel) {
                graphQLVisitableModel = (C0861x186baa6f) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f21680w = likersModel;
            }
        }
        if (m29363v() != null) {
            ReactorsModel reactorsModel = (ReactorsModel) graphQLModelMutatingVisitor.mo2928b(m29363v());
            if (m29363v() != reactorsModel) {
                graphQLVisitableModel = (C0861x186baa6f) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f21681x = reactorsModel;
            }
        }
        if (m29364w() != null) {
            ResharesModel resharesModel = (ResharesModel) graphQLModelMutatingVisitor.mo2928b(m29364w());
            if (m29364w() != resharesModel) {
                graphQLVisitableModel = (C0861x186baa6f) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f21683z = resharesModel;
            }
        }
        if (m29365x() != null) {
            SeenByModel seenByModel = (SeenByModel) graphQLModelMutatingVisitor.mo2928b(m29365x());
            if (m29365x() != seenByModel) {
                graphQLVisitableModel = (C0861x186baa6f) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f21654A = seenByModel;
            }
        }
        if (m29366y() != null) {
            Builder a = ModelHelper.m23097a(m29366y(), graphQLModelMutatingVisitor);
            if (a != null) {
                C0861x186baa6f c0861x186baa6f = (C0861x186baa6f) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                c0861x186baa6f.f21655B = a.m1068b();
                graphQLVisitableModel = c0861x186baa6f;
            }
        }
        if (m29367z() != null) {
            TopLevelCommentsConnectionFragmentModel topLevelCommentsConnectionFragmentModel = (TopLevelCommentsConnectionFragmentModel) graphQLModelMutatingVisitor.mo2928b(m29367z());
            if (m29367z() != topLevelCommentsConnectionFragmentModel) {
                graphQLVisitableModel = (C0861x186baa6f) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f21656C = topLevelCommentsConnectionFragmentModel;
            }
        }
        if (m29348A() != null) {
            TopReactionsModel topReactionsModel = (TopReactionsModel) graphQLModelMutatingVisitor.mo2928b(m29348A());
            if (m29348A() != topReactionsModel) {
                graphQLVisitableModel = (C0861x186baa6f) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f21657D = topReactionsModel;
            }
        }
        if (m29349B() != null) {
            ViewerActsAsPageModel viewerActsAsPageModel = (ViewerActsAsPageModel) graphQLModelMutatingVisitor.mo2928b(m29349B());
            if (m29349B() != viewerActsAsPageModel) {
                graphQLVisitableModel = (C0861x186baa6f) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f21658E = viewerActsAsPageModel;
            }
        }
        if (m29350C() != null) {
            ViewerActsAsPersonModel viewerActsAsPersonModel = (ViewerActsAsPersonModel) graphQLModelMutatingVisitor.mo2928b(m29350C());
            if (m29350C() != viewerActsAsPersonModel) {
                graphQLVisitableModel = (C0861x186baa6f) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f21659F = viewerActsAsPersonModel;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m29358q());
        int b = flatBufferBuilder.m21502b(mo3178j());
        int b2 = flatBufferBuilder.m21502b(m29359r());
        int b3 = flatBufferBuilder.m21502b(mo3180l());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m29361t());
        int b4 = flatBufferBuilder.m21502b(mo3182n());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m29362u());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m29363v());
        int b5 = flatBufferBuilder.m21502b(mo3183o());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m29364w());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m29365x());
        int a7 = ModelHelper.m23094a(flatBufferBuilder, m29366y());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m29367z());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m29348A());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m29349B());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m29350C());
        flatBufferBuilder.m21510c(30);
        flatBufferBuilder.m21498a(0, this.f21661d);
        flatBufferBuilder.m21498a(1, this.f21662e);
        flatBufferBuilder.m21498a(2, this.f21663f);
        flatBufferBuilder.m21498a(3, this.f21664g);
        flatBufferBuilder.m21498a(4, this.f21665h);
        flatBufferBuilder.m21498a(5, this.f21666i);
        flatBufferBuilder.m21498a(6, this.f21667j);
        flatBufferBuilder.m21498a(7, this.f21668k);
        flatBufferBuilder.m21507b(8, a);
        flatBufferBuilder.m21507b(9, b);
        flatBufferBuilder.m21507b(10, b2);
        flatBufferBuilder.m21498a(11, this.f21672o);
        flatBufferBuilder.m21498a(12, this.f21673p);
        flatBufferBuilder.m21498a(13, this.f21674q);
        flatBufferBuilder.m21498a(14, this.f21675r);
        flatBufferBuilder.m21507b(15, b3);
        flatBufferBuilder.m21507b(16, a2);
        flatBufferBuilder.m21498a(17, this.f21678u);
        flatBufferBuilder.m21507b(18, b4);
        flatBufferBuilder.m21507b(19, a3);
        flatBufferBuilder.m21507b(20, a4);
        flatBufferBuilder.m21507b(21, b5);
        flatBufferBuilder.m21507b(22, a5);
        flatBufferBuilder.m21507b(23, a6);
        flatBufferBuilder.m21507b(24, a7);
        flatBufferBuilder.m21507b(25, a8);
        flatBufferBuilder.m21507b(26, a9);
        flatBufferBuilder.m21507b(27, a10);
        flatBufferBuilder.m21507b(28, a11);
        flatBufferBuilder.m21494a(29, this.f21660G, 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f21661d = mutableFlatBuffer.m21540a(i, 0);
        this.f21662e = mutableFlatBuffer.m21540a(i, 1);
        this.f21663f = mutableFlatBuffer.m21540a(i, 2);
        this.f21664g = mutableFlatBuffer.m21540a(i, 3);
        this.f21665h = mutableFlatBuffer.m21540a(i, 4);
        this.f21666i = mutableFlatBuffer.m21540a(i, 5);
        this.f21667j = mutableFlatBuffer.m21540a(i, 6);
        this.f21668k = mutableFlatBuffer.m21540a(i, 7);
        this.f21672o = mutableFlatBuffer.m21540a(i, 11);
        this.f21673p = mutableFlatBuffer.m21540a(i, 12);
        this.f21674q = mutableFlatBuffer.m21540a(i, 13);
        this.f21675r = mutableFlatBuffer.m21540a(i, 14);
        this.f21678u = mutableFlatBuffer.m21540a(i, 17);
        this.f21660G = mutableFlatBuffer.m21524a(i, 29, 0);
    }
}
