package com.facebook.photos.data.protocol;

import com.facebook.api.graphql.reactions.C0143x5a63f940;
import com.facebook.api.graphql.reactions.ReactionsGraphQLInterfaces$SimpleReactionsFeedbackFields;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.SimpleReactionsFeedbackFieldsModel.ReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsFeedbackFieldsModel.SupportedReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ImportantReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ViewerActsAsPersonModel;
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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 2120310671)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: rtccall/audio/%s */
public final class PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel extends BaseModel implements ReactionsGraphQLInterfaces$SimpleReactionsFeedbackFields, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    private boolean f3033d;
    private boolean f3034e;
    private boolean f3035f;
    private boolean f3036g;
    private boolean f3037h;
    private boolean f3038i;
    private boolean f3039j;
    private boolean f3040k;
    private boolean f3041l;
    @Nullable
    private String f3042m;
    @Nullable
    private ImportantReactorsModel f3043n;
    private boolean f3044o;
    @Nullable
    private String f3045p;
    @Nullable
    private LikersModel f3046q;
    @Nullable
    private ReactorsModel f3047r;
    @Nullable
    private String f3048s;
    @Nullable
    private List<SupportedReactionsModel> f3049t;
    @Nullable
    private TopLevelCommentsModel f3050u;
    @Nullable
    private C0143x5a63f940 f3051v;
    @Nullable
    private ViewerActsAsPersonModel f3052w;
    private int f3053x;

    @Nullable
    public final /* synthetic */ ImportantReactorsModel m3370m() {
        return m3354x();
    }

    @Nullable
    public final /* synthetic */ LikersModel m3373p() {
        return m3355y();
    }

    @Nullable
    public final /* synthetic */ ReactorsModel m3374q() {
        return m3356z();
    }

    @Nullable
    public final /* synthetic */ TopLevelCommentsModel m3377t() {
        return m3345A();
    }

    @Nullable
    public final /* synthetic */ C0143x5a63f940 m3378u() {
        return m3346B();
    }

    @Nullable
    public final /* synthetic */ ViewerActsAsPersonModel m3379v() {
        return m3347C();
    }

    public PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel() {
        super(21);
    }

    public PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel(MutableFlatBuffer mutableFlatBuffer) {
        super(21);
        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
    }

    public final void m3361a(String str, ConsistencyTuple consistencyTuple) {
        if ("can_viewer_comment".equals(str)) {
            consistencyTuple.a = Boolean.valueOf(m3364c());
            consistencyTuple.b = u_();
            consistencyTuple.c = 1;
        } else if ("can_viewer_like".equals(str)) {
            consistencyTuple.a = Boolean.valueOf(m3366g());
            consistencyTuple.b = u_();
            consistencyTuple.c = 4;
        } else if ("does_viewer_like".equals(str)) {
            consistencyTuple.a = Boolean.valueOf(m3368k());
            consistencyTuple.b = u_();
            consistencyTuple.c = 8;
        } else if ("is_viewer_subscribed".equals(str)) {
            consistencyTuple.a = Boolean.valueOf(m3371n());
            consistencyTuple.b = u_();
            consistencyTuple.c = 11;
        } else {
            if ("likers.count".equals(str)) {
                LikersModel y = m3355y();
                if (y != null) {
                    consistencyTuple.a = Integer.valueOf(y.a());
                    consistencyTuple.b = y.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            } else if ("reactors.count".equals(str)) {
                ReactorsModel z = m3356z();
                if (z != null) {
                    consistencyTuple.a = Integer.valueOf(z.a());
                    consistencyTuple.b = z.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            } else if ("top_level_comments.count".equals(str)) {
                r0 = m3345A();
                if (r0 != null) {
                    consistencyTuple.a = Integer.valueOf(r0.a());
                    consistencyTuple.b = r0.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            } else if ("top_level_comments.total_count".equals(str)) {
                r0 = m3345A();
                if (r0 != null) {
                    consistencyTuple.a = Integer.valueOf(r0.b());
                    consistencyTuple.b = r0.u_();
                    consistencyTuple.c = 1;
                    return;
                }
            } else if ("viewer_feedback_reaction_key".equals(str)) {
                consistencyTuple.a = Integer.valueOf(m3380w());
                consistencyTuple.b = u_();
                consistencyTuple.c = 20;
                return;
            }
            consistencyTuple.a();
        }
    }

    public final void m3362a(String str, Object obj, boolean z) {
        if ("can_viewer_comment".equals(str)) {
            m3350a(((Boolean) obj).booleanValue());
        } else if ("can_viewer_like".equals(str)) {
            m3351b(((Boolean) obj).booleanValue());
        } else if ("does_viewer_like".equals(str)) {
            m3352c(((Boolean) obj).booleanValue());
        } else if ("is_viewer_subscribed".equals(str)) {
            m3353d(((Boolean) obj).booleanValue());
        } else if ("likers.count".equals(str)) {
            LikersModel y = m3355y();
            if (y == null) {
                return;
            }
            if (z) {
                y = (LikersModel) y.clone();
                y.a(((Integer) obj).intValue());
                this.f3046q = y;
                return;
            }
            y.a(((Integer) obj).intValue());
        } else if ("reactors.count".equals(str)) {
            ReactorsModel z2 = m3356z();
            if (z2 == null) {
                return;
            }
            if (z) {
                z2 = (ReactorsModel) z2.clone();
                z2.a(((Integer) obj).intValue());
                this.f3047r = z2;
                return;
            }
            z2.a(((Integer) obj).intValue());
        } else if ("top_level_comments.count".equals(str)) {
            r0 = m3345A();
            if (r0 == null) {
                return;
            }
            if (z) {
                r0 = (TopLevelCommentsModel) r0.clone();
                r0.a(((Integer) obj).intValue());
                this.f3050u = r0;
                return;
            }
            r0.a(((Integer) obj).intValue());
        } else if ("top_level_comments.total_count".equals(str)) {
            r0 = m3345A();
            if (r0 == null) {
                return;
            }
            if (z) {
                r0 = (TopLevelCommentsModel) r0.clone();
                r0.b(((Integer) obj).intValue());
                this.f3050u = r0;
                return;
            }
            r0.b(((Integer) obj).intValue());
        } else if ("viewer_feedback_reaction_key".equals(str)) {
            m3349a(((Integer) obj).intValue());
        }
    }

    public final boolean m3363b() {
        a(0, 0);
        return this.f3033d;
    }

    public final boolean m3364c() {
        a(0, 1);
        return this.f3034e;
    }

    private void m3350a(boolean z) {
        this.f3034e = z;
        if (this.b != null && this.b.d) {
            this.b.a(this.c, 1, z);
        }
    }

    public final boolean m3365d() {
        a(0, 2);
        return this.f3035f;
    }

    public final boolean bn_() {
        a(0, 3);
        return this.f3036g;
    }

    public final boolean m3366g() {
        a(0, 4);
        return this.f3037h;
    }

    private void m3351b(boolean z) {
        this.f3037h = z;
        if (this.b != null && this.b.d) {
            this.b.a(this.c, 4, z);
        }
    }

    public final boolean bo_() {
        a(0, 5);
        return this.f3038i;
    }

    public final boolean bp_() {
        a(0, 6);
        return this.f3039j;
    }

    public final boolean m3367j() {
        a(0, 7);
        return this.f3040k;
    }

    public final boolean m3368k() {
        a(1, 0);
        return this.f3041l;
    }

    private void m3352c(boolean z) {
        this.f3041l = z;
        if (this.b != null && this.b.d) {
            this.b.a(this.c, 8, z);
        }
    }

    @Nullable
    public final String m3369l() {
        this.f3042m = super.a(this.f3042m, 9);
        return this.f3042m;
    }

    @Nullable
    private ImportantReactorsModel m3354x() {
        this.f3043n = (ImportantReactorsModel) super.a(this.f3043n, 10, ImportantReactorsModel.class);
        return this.f3043n;
    }

    public final boolean m3371n() {
        a(1, 3);
        return this.f3044o;
    }

    private void m3353d(boolean z) {
        this.f3044o = z;
        if (this.b != null && this.b.d) {
            this.b.a(this.c, 11, z);
        }
    }

    @Nullable
    public final String m3372o() {
        this.f3045p = super.a(this.f3045p, 12);
        return this.f3045p;
    }

    @Nullable
    private LikersModel m3355y() {
        this.f3046q = (LikersModel) super.a(this.f3046q, 13, LikersModel.class);
        return this.f3046q;
    }

    @Nullable
    private ReactorsModel m3356z() {
        this.f3047r = (ReactorsModel) super.a(this.f3047r, 14, ReactorsModel.class);
        return this.f3047r;
    }

    @Nullable
    public final String m3375r() {
        this.f3048s = super.a(this.f3048s, 15);
        return this.f3048s;
    }

    @Nonnull
    public final ImmutableList<SupportedReactionsModel> m3376s() {
        this.f3049t = super.a(this.f3049t, 16, SupportedReactionsModel.class);
        return (ImmutableList) this.f3049t;
    }

    @Nullable
    private TopLevelCommentsModel m3345A() {
        this.f3050u = (TopLevelCommentsModel) super.a(this.f3050u, 17, TopLevelCommentsModel.class);
        return this.f3050u;
    }

    @Nullable
    private C0143x5a63f940 m3346B() {
        this.f3051v = (C0143x5a63f940) super.a(this.f3051v, 18, C0143x5a63f940.class);
        return this.f3051v;
    }

    @Nullable
    private ViewerActsAsPersonModel m3347C() {
        this.f3052w = (ViewerActsAsPersonModel) super.a(this.f3052w, 19, ViewerActsAsPersonModel.class);
        return this.f3052w;
    }

    public final int m3380w() {
        a(2, 4);
        return this.f3053x;
    }

    private void m3349a(int i) {
        this.f3053x = i;
        if (this.b != null && this.b.d) {
            this.b.b(this.c, 20, i);
        }
    }

    public static PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel m3348a(PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel photosMetadataGraphQLModels$SimpleMediaFeedbackModel) {
        if (photosMetadataGraphQLModels$SimpleMediaFeedbackModel == null) {
            return null;
        }
        if (photosMetadataGraphQLModels$SimpleMediaFeedbackModel instanceof PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel) {
            return photosMetadataGraphQLModels$SimpleMediaFeedbackModel;
        }
        Builder builder = new Builder();
        builder.a = photosMetadataGraphQLModels$SimpleMediaFeedbackModel.m3363b();
        builder.b = photosMetadataGraphQLModels$SimpleMediaFeedbackModel.m3364c();
        builder.c = photosMetadataGraphQLModels$SimpleMediaFeedbackModel.m3365d();
        builder.d = photosMetadataGraphQLModels$SimpleMediaFeedbackModel.bn_();
        builder.e = photosMetadataGraphQLModels$SimpleMediaFeedbackModel.m3366g();
        builder.f = photosMetadataGraphQLModels$SimpleMediaFeedbackModel.bo_();
        builder.g = photosMetadataGraphQLModels$SimpleMediaFeedbackModel.bp_();
        builder.h = photosMetadataGraphQLModels$SimpleMediaFeedbackModel.m3367j();
        builder.i = photosMetadataGraphQLModels$SimpleMediaFeedbackModel.m3368k();
        builder.j = photosMetadataGraphQLModels$SimpleMediaFeedbackModel.m3369l();
        builder.k = ImportantReactorsModel.a(photosMetadataGraphQLModels$SimpleMediaFeedbackModel.m3370m());
        builder.l = photosMetadataGraphQLModels$SimpleMediaFeedbackModel.m3371n();
        builder.m = photosMetadataGraphQLModels$SimpleMediaFeedbackModel.m3372o();
        builder.n = LikersModel.a(photosMetadataGraphQLModels$SimpleMediaFeedbackModel.m3373p());
        builder.o = ReactorsModel.a(photosMetadataGraphQLModels$SimpleMediaFeedbackModel.m3374q());
        builder.p = photosMetadataGraphQLModels$SimpleMediaFeedbackModel.m3375r();
        Builder builder2 = ImmutableList.builder();
        for (int i = 0; i < photosMetadataGraphQLModels$SimpleMediaFeedbackModel.m3376s().size(); i++) {
            builder2.c(SupportedReactionsModel.a((SupportedReactionsModel) photosMetadataGraphQLModels$SimpleMediaFeedbackModel.m3376s().get(i)));
        }
        builder.q = builder2.b();
        builder.r = TopLevelCommentsModel.a(photosMetadataGraphQLModels$SimpleMediaFeedbackModel.m3377t());
        builder.s = C0143x5a63f940.m3304a(photosMetadataGraphQLModels$SimpleMediaFeedbackModel.m3378u());
        builder.t = ViewerActsAsPersonModel.a(photosMetadataGraphQLModels$SimpleMediaFeedbackModel.m3379v());
        builder.u = photosMetadataGraphQLModels$SimpleMediaFeedbackModel.m3380w();
        return builder.a();
    }

    @Nullable
    public final String m3359a() {
        return m3372o();
    }

    public final int jK_() {
        return -126857307;
    }

    public final GraphQLVisitableModel m3358a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m3354x() != null) {
            ImportantReactorsModel importantReactorsModel = (ImportantReactorsModel) graphQLModelMutatingVisitor.b(m3354x());
            if (m3354x() != importantReactorsModel) {
                graphQLVisitableModel = (PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel) ModelHelper.a(null, this);
                graphQLVisitableModel.f3043n = importantReactorsModel;
            }
        }
        if (m3355y() != null) {
            LikersModel likersModel = (LikersModel) graphQLModelMutatingVisitor.b(m3355y());
            if (m3355y() != likersModel) {
                graphQLVisitableModel = (PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3046q = likersModel;
            }
        }
        if (m3356z() != null) {
            ReactorsModel reactorsModel = (ReactorsModel) graphQLModelMutatingVisitor.b(m3356z());
            if (m3356z() != reactorsModel) {
                graphQLVisitableModel = (PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3047r = reactorsModel;
            }
        }
        if (m3376s() != null) {
            Builder a = ModelHelper.a(m3376s(), graphQLModelMutatingVisitor);
            if (a != null) {
                PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel photosMetadataGraphQLModels$SimpleMediaFeedbackModel = (PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                photosMetadataGraphQLModels$SimpleMediaFeedbackModel.f3049t = a.b();
                graphQLVisitableModel = photosMetadataGraphQLModels$SimpleMediaFeedbackModel;
            }
        }
        if (m3345A() != null) {
            TopLevelCommentsModel topLevelCommentsModel = (TopLevelCommentsModel) graphQLModelMutatingVisitor.b(m3345A());
            if (m3345A() != topLevelCommentsModel) {
                graphQLVisitableModel = (PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3050u = topLevelCommentsModel;
            }
        }
        if (m3346B() != null) {
            C0143x5a63f940 c0143x5a63f940 = (C0143x5a63f940) graphQLModelMutatingVisitor.b(m3346B());
            if (m3346B() != c0143x5a63f940) {
                graphQLVisitableModel = (PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3051v = c0143x5a63f940;
            }
        }
        if (m3347C() != null) {
            ViewerActsAsPersonModel viewerActsAsPersonModel = (ViewerActsAsPersonModel) graphQLModelMutatingVisitor.b(m3347C());
            if (m3347C() != viewerActsAsPersonModel) {
                graphQLVisitableModel = (PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3052w = viewerActsAsPersonModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m3357a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m3369l());
        int a = ModelHelper.a(flatBufferBuilder, m3354x());
        int b2 = flatBufferBuilder.b(m3372o());
        int a2 = ModelHelper.a(flatBufferBuilder, m3355y());
        int a3 = ModelHelper.a(flatBufferBuilder, m3356z());
        int b3 = flatBufferBuilder.b(m3375r());
        int a4 = ModelHelper.a(flatBufferBuilder, m3376s());
        int a5 = ModelHelper.a(flatBufferBuilder, m3345A());
        int a6 = ModelHelper.a(flatBufferBuilder, m3346B());
        int a7 = ModelHelper.a(flatBufferBuilder, m3347C());
        flatBufferBuilder.c(21);
        flatBufferBuilder.a(0, this.f3033d);
        flatBufferBuilder.a(1, this.f3034e);
        flatBufferBuilder.a(2, this.f3035f);
        flatBufferBuilder.a(3, this.f3036g);
        flatBufferBuilder.a(4, this.f3037h);
        flatBufferBuilder.a(5, this.f3038i);
        flatBufferBuilder.a(6, this.f3039j);
        flatBufferBuilder.a(7, this.f3040k);
        flatBufferBuilder.a(8, this.f3041l);
        flatBufferBuilder.b(9, b);
        flatBufferBuilder.b(10, a);
        flatBufferBuilder.a(11, this.f3044o);
        flatBufferBuilder.b(12, b2);
        flatBufferBuilder.b(13, a2);
        flatBufferBuilder.b(14, a3);
        flatBufferBuilder.b(15, b3);
        flatBufferBuilder.b(16, a4);
        flatBufferBuilder.b(17, a5);
        flatBufferBuilder.b(18, a6);
        flatBufferBuilder.b(19, a7);
        flatBufferBuilder.a(20, this.f3053x, 0);
        i();
        return flatBufferBuilder.d();
    }

    public final void m3360a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3033d = mutableFlatBuffer.a(i, 0);
        this.f3034e = mutableFlatBuffer.a(i, 1);
        this.f3035f = mutableFlatBuffer.a(i, 2);
        this.f3036g = mutableFlatBuffer.a(i, 3);
        this.f3037h = mutableFlatBuffer.a(i, 4);
        this.f3038i = mutableFlatBuffer.a(i, 5);
        this.f3039j = mutableFlatBuffer.a(i, 6);
        this.f3040k = mutableFlatBuffer.a(i, 7);
        this.f3041l = mutableFlatBuffer.a(i, 8);
        this.f3044o = mutableFlatBuffer.a(i, 11);
        this.f3053x = mutableFlatBuffer.a(i, 20, 0);
    }
}
