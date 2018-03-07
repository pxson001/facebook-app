package com.facebook.api.graphql.reactions;

import com.facebook.api.graphql.reactions.ReactionsGraphQLInterfaces.ViewerReactionsSocialFeedbackFields;
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
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 1796429492)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: rtt_window */
public final class ReactionsGraphQLModels$ViewerReactionsMutationFragmentModel extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private FeedbackModel f11880d;

    /* compiled from: rtt_window */
    public final class Builder {
        @Nullable
        public FeedbackModel f2997a;

        public final ReactionsGraphQLModels$ViewerReactionsMutationFragmentModel m3295a() {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, this.f2997a);
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new ReactionsGraphQLModels$ViewerReactionsMutationFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -570493944)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: rtt_window */
    public final class FeedbackModel extends BaseModel implements ReactionsGraphQLInterfaces$ReactionsCountFields, ViewerReactionsSocialFeedbackFields, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f3014d;
        @Nullable
        private ImportantReactorsModel f3015e;
        @Nullable
        private String f3016f;
        @Nullable
        private LikersModel f3017g;
        @Nullable
        private ReactorsModel f3018h;
        @Nullable
        private C0143x5a63f940 f3019i;
        @Nullable
        private ViewerActsAsPersonModel f3020j;
        @Nullable
        private ViewerFeedbackReactionModel f3021k;
        private int f3022l;

        /* compiled from: rtt_window */
        public final class Builder {
            @Nullable
            public String f2998a;
            @Nullable
            public ImportantReactorsModel f2999b;
            @Nullable
            public String f3000c;
            @Nullable
            public LikersModel f3001d;
            @Nullable
            public ReactorsModel f3002e;
            @Nullable
            public C0143x5a63f940 f3003f;
            @Nullable
            public ViewerActsAsPersonModel f3004g;
            @Nullable
            public ViewerFeedbackReactionModel f3005h;
            public int f3006i;

            public final FeedbackModel m3296a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f2998a);
                int a = ModelHelper.a(flatBufferBuilder, this.f2999b);
                int b2 = flatBufferBuilder.b(this.f3000c);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f3001d);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f3002e);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f3003f);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f3004g);
                int a6 = ModelHelper.a(flatBufferBuilder, this.f3005h);
                flatBufferBuilder.c(9);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, a4);
                flatBufferBuilder.b(6, a5);
                flatBufferBuilder.b(7, a6);
                flatBufferBuilder.a(8, this.f3006i, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new FeedbackModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 224127441)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: rtt_window */
        public final class ViewerFeedbackReactionModel extends BaseModel implements GraphQLVisitableModel {
            private int f3008d;

            /* compiled from: rtt_window */
            public final class Builder {
                public int f3007a;

                public final ViewerFeedbackReactionModel m3297a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f3007a, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new ViewerFeedbackReactionModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            public ViewerFeedbackReactionModel() {
                super(1);
            }

            public ViewerFeedbackReactionModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m3298a() {
                a(0, 0);
                return this.f3008d;
            }

            public final int jK_() {
                return 116529390;
            }

            public final GraphQLVisitableModel m3300a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m3299a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f3008d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m3301a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f3008d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: rtt_window */
        public final class LikersModel extends BaseModel implements GraphQLVisitableModel {
            private int f3011d;

            /* compiled from: rtt_window */
            public final class Builder {
                public int f3010a;

                public final LikersModel m3308a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f3010a, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new LikersModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            public LikersModel() {
                super(1);
            }

            public LikersModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m3309a() {
                a(0, 0);
                return this.f3011d;
            }

            public final void m3312a(int i) {
                this.f3011d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public final int jK_() {
                return 733369288;
            }

            public final GraphQLVisitableModel m3311a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m3310a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f3011d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m3313a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f3011d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: rtt_window */
        public final class ReactorsModel extends BaseModel implements GraphQLVisitableModel {
            private int f3013d;

            /* compiled from: rtt_window */
            public final class Builder {
                public int f3012a;

                public final ReactorsModel m3314a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f3012a, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new ReactorsModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            public ReactorsModel() {
                super(1);
            }

            public ReactorsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m3315a() {
                a(0, 0);
                return this.f3013d;
            }

            public final void m3318a(int i) {
                this.f3013d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public final int jK_() {
                return 256909871;
            }

            public final GraphQLVisitableModel m3317a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m3316a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f3013d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m3319a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f3013d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        public FeedbackModel() {
            super(9);
        }

        public FeedbackModel(MutableFlatBuffer mutableFlatBuffer) {
            super(9);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m3329a(String str, ConsistencyTuple consistencyTuple) {
            if ("likers.count".equals(str)) {
                LikersModel l = m3333l();
                if (l != null) {
                    consistencyTuple.a = Integer.valueOf(l.m3309a());
                    consistencyTuple.b = l.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            } else if ("reactors.count".equals(str)) {
                ReactorsModel m = m3334m();
                if (m != null) {
                    consistencyTuple.a = Integer.valueOf(m.m3315a());
                    consistencyTuple.b = m.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            } else if ("viewer_feedback_reaction_key".equals(str)) {
                consistencyTuple.a = Integer.valueOf(m3324r());
                consistencyTuple.b = u_();
                consistencyTuple.c = 8;
                return;
            }
            consistencyTuple.a();
        }

        public final void m3330a(String str, Object obj, boolean z) {
            if ("likers.count".equals(str)) {
                LikersModel l = m3333l();
                if (l == null) {
                    return;
                }
                if (z) {
                    l = (LikersModel) l.clone();
                    l.m3312a(((Integer) obj).intValue());
                    this.f3017g = l;
                    return;
                }
                l.m3312a(((Integer) obj).intValue());
            } else if ("reactors.count".equals(str)) {
                ReactorsModel m = m3334m();
                if (m == null) {
                    return;
                }
                if (z) {
                    m = (ReactorsModel) m.clone();
                    m.m3318a(((Integer) obj).intValue());
                    this.f3018h = m;
                    return;
                }
                m.m3318a(((Integer) obj).intValue());
            } else if ("viewer_feedback_reaction_key".equals(str)) {
                m3320a(((Integer) obj).intValue());
            }
        }

        @Nullable
        public final String m3331j() {
            this.f3014d = super.a(this.f3014d, 0);
            return this.f3014d;
        }

        @Nullable
        private ImportantReactorsModel m3321o() {
            this.f3015e = (ImportantReactorsModel) super.a(this.f3015e, 1, ImportantReactorsModel.class);
            return this.f3015e;
        }

        @Nullable
        public final String m3332k() {
            this.f3016f = super.a(this.f3016f, 2);
            return this.f3016f;
        }

        @Nullable
        public final LikersModel m3333l() {
            this.f3017g = (LikersModel) super.a(this.f3017g, 3, LikersModel.class);
            return this.f3017g;
        }

        @Nullable
        public final ReactorsModel m3334m() {
            this.f3018h = (ReactorsModel) super.a(this.f3018h, 4, ReactorsModel.class);
            return this.f3018h;
        }

        @Nullable
        private C0143x5a63f940 m3322p() {
            this.f3019i = (C0143x5a63f940) super.a(this.f3019i, 5, C0143x5a63f940.class);
            return this.f3019i;
        }

        @Nullable
        private ViewerActsAsPersonModel m3323q() {
            this.f3020j = (ViewerActsAsPersonModel) super.a(this.f3020j, 6, ViewerActsAsPersonModel.class);
            return this.f3020j;
        }

        @Nullable
        public final ViewerFeedbackReactionModel m3335n() {
            this.f3021k = (ViewerFeedbackReactionModel) super.a(this.f3021k, 7, ViewerFeedbackReactionModel.class);
            return this.f3021k;
        }

        private int m3324r() {
            a(1, 0);
            return this.f3022l;
        }

        private void m3320a(int i) {
            this.f3022l = i;
            if (this.b != null && this.b.d) {
                this.b.b(this.c, 8, i);
            }
        }

        @Nullable
        public final String m3327a() {
            return m3332k();
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m3326a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3321o() != null) {
                ImportantReactorsModel importantReactorsModel = (ImportantReactorsModel) graphQLModelMutatingVisitor.b(m3321o());
                if (m3321o() != importantReactorsModel) {
                    graphQLVisitableModel = (FeedbackModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3015e = importantReactorsModel;
                }
            }
            if (m3333l() != null) {
                LikersModel likersModel = (LikersModel) graphQLModelMutatingVisitor.b(m3333l());
                if (m3333l() != likersModel) {
                    graphQLVisitableModel = (FeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3017g = likersModel;
                }
            }
            if (m3334m() != null) {
                ReactorsModel reactorsModel = (ReactorsModel) graphQLModelMutatingVisitor.b(m3334m());
                if (m3334m() != reactorsModel) {
                    graphQLVisitableModel = (FeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3018h = reactorsModel;
                }
            }
            if (m3322p() != null) {
                C0143x5a63f940 c0143x5a63f940 = (C0143x5a63f940) graphQLModelMutatingVisitor.b(m3322p());
                if (m3322p() != c0143x5a63f940) {
                    graphQLVisitableModel = (FeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3019i = c0143x5a63f940;
                }
            }
            if (m3323q() != null) {
                ViewerActsAsPersonModel viewerActsAsPersonModel = (ViewerActsAsPersonModel) graphQLModelMutatingVisitor.b(m3323q());
                if (m3323q() != viewerActsAsPersonModel) {
                    graphQLVisitableModel = (FeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3020j = viewerActsAsPersonModel;
                }
            }
            if (m3335n() != null) {
                ViewerFeedbackReactionModel viewerFeedbackReactionModel = (ViewerFeedbackReactionModel) graphQLModelMutatingVisitor.b(m3335n());
                if (m3335n() != viewerFeedbackReactionModel) {
                    graphQLVisitableModel = (FeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3021k = viewerFeedbackReactionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3325a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m3331j());
            int a = ModelHelper.a(flatBufferBuilder, m3321o());
            int b2 = flatBufferBuilder.b(m3332k());
            int a2 = ModelHelper.a(flatBufferBuilder, m3333l());
            int a3 = ModelHelper.a(flatBufferBuilder, m3334m());
            int a4 = ModelHelper.a(flatBufferBuilder, m3322p());
            int a5 = ModelHelper.a(flatBufferBuilder, m3323q());
            int a6 = ModelHelper.a(flatBufferBuilder, m3335n());
            flatBufferBuilder.c(9);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.b(7, a6);
            flatBufferBuilder.a(8, this.f3022l, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3328a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3022l = mutableFlatBuffer.a(i, 8, 0);
        }
    }

    public ReactionsGraphQLModels$ViewerReactionsMutationFragmentModel() {
        super(1);
    }

    public ReactionsGraphQLModels$ViewerReactionsMutationFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
        super(1);
        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
    }

    @Nullable
    public final FeedbackModel m12480a() {
        this.f11880d = (FeedbackModel) super.a(this.f11880d, 0, FeedbackModel.class);
        return this.f11880d;
    }

    public final int jK_() {
        return -1528407597;
    }

    public final GraphQLVisitableModel m12481a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m12480a() != null) {
            FeedbackModel feedbackModel = (FeedbackModel) graphQLModelMutatingVisitor.b(m12480a());
            if (m12480a() != feedbackModel) {
                graphQLVisitableModel = (ReactionsGraphQLModels$ViewerReactionsMutationFragmentModel) ModelHelper.a(null, this);
                graphQLVisitableModel.f11880d = feedbackModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m12479a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m12480a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }
}
