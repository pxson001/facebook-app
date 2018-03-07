package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: rtc_voicemail_asset_url_download_time_ */
public class GraphQLFeedback$Builder extends Builder {
    @Nullable
    public String f3109A;
    @Nullable
    public GraphQLTextWithEntities f3110B;
    @Nullable
    public GraphQLLikersOfContentConnection f3111C;
    @Nullable
    public GraphQLTopLevelCommentsConnection f3112D;
    @Nullable
    public GraphQLReactorsOfContentConnection f3113E;
    @Nullable
    public GraphQLFeedbackRealTimeActivityInfo f3114F;
    @Nullable
    public String f3115G;
    @Nullable
    public GraphQLResharesOfContentConnection f3116H;
    @Nullable
    public GraphQLSeenByConnection f3117I;
    public boolean f3118J;
    public ImmutableList<GraphQLFeedbackReaction> f3119K;
    @Nullable
    public GraphQLTopLevelCommentsConnection f3120L;
    @Nullable
    public GraphQLTopReactionsConnection f3121M;
    @Nullable
    public String f3122N;
    @Nullable
    public GraphQLVideoTimestampedCommentsConnection f3123O;
    @Nullable
    public GraphQLPage f3124P;
    @Nullable
    public GraphQLUser f3125Q;
    @Nullable
    public String f3126R;
    @Nullable
    public GraphQLTextWithEntities f3127S;
    @Nullable
    public GraphQLFeedbackReaction f3128T;
    public int f3129U;
    @Nullable
    public String f3130V;
    @Nullable
    public GraphQLTextWithEntities f3131W;
    @Nullable
    PropertyBag f3132X = null;
    public boolean f3133d;
    public boolean f3134e;
    public boolean f3135f;
    public boolean f3136g;
    public boolean f3137h;
    public boolean f3138i;
    public boolean f3139j;
    public boolean f3140k;
    @Nullable
    public GraphQLCommentsConnection f3141l;
    @Nullable
    public GraphQLTextWithEntities f3142m;
    @Nullable
    public String f3143n;
    @Nullable
    public String f3144o;
    public boolean f3145p;
    public boolean f3146q;
    public boolean f3147r;
    public long f3148s;
    public boolean f3149t;
    public boolean f3150u;
    @Nullable
    public String f3151v;
    @Nullable
    public GraphQLImportantReactorsConnection f3152w;
    @Nullable
    public GraphQLInteractorsConnection f3153x;
    @Nullable
    public GraphQLInteractorsConnection f3154y;
    public boolean f3155z;

    public GraphQLFeedback$Builder() {
        Preconditions.checkState(this instanceof GraphQLFeedback$Builder);
    }

    public static GraphQLFeedback$Builder m3390a(GraphQLFeedback graphQLFeedback) {
        GraphQLFeedback$Builder graphQLFeedback$Builder = new GraphQLFeedback$Builder();
        graphQLFeedback.h();
        graphQLFeedback$Builder.f3133d = graphQLFeedback.b();
        graphQLFeedback$Builder.f3134e = graphQLFeedback.c();
        graphQLFeedback$Builder.f3135f = graphQLFeedback.d();
        graphQLFeedback$Builder.f3136g = graphQLFeedback.m();
        graphQLFeedback$Builder.f3137h = graphQLFeedback.x_();
        graphQLFeedback$Builder.f3138i = graphQLFeedback.g();
        graphQLFeedback$Builder.f3139j = graphQLFeedback.n();
        graphQLFeedback$Builder.f3140k = graphQLFeedback.o();
        graphQLFeedback$Builder.f3141l = graphQLFeedback.p();
        graphQLFeedback$Builder.f3142m = graphQLFeedback.q();
        graphQLFeedback$Builder.f3143n = graphQLFeedback.r();
        graphQLFeedback$Builder.f3144o = graphQLFeedback.s();
        graphQLFeedback$Builder.f3145p = graphQLFeedback.t();
        graphQLFeedback$Builder.f3146q = graphQLFeedback.y_();
        graphQLFeedback$Builder.f3147r = graphQLFeedback.u();
        graphQLFeedback$Builder.f3148s = graphQLFeedback.v();
        graphQLFeedback$Builder.f3149t = graphQLFeedback.w();
        graphQLFeedback$Builder.f3150u = graphQLFeedback.x();
        graphQLFeedback$Builder.f3151v = graphQLFeedback.z_();
        graphQLFeedback$Builder.f3152w = graphQLFeedback.W();
        graphQLFeedback$Builder.f3153x = graphQLFeedback.y();
        graphQLFeedback$Builder.f3154y = graphQLFeedback.z();
        graphQLFeedback$Builder.f3155z = graphQLFeedback.A();
        graphQLFeedback$Builder.f3109A = graphQLFeedback.j();
        graphQLFeedback$Builder.f3110B = graphQLFeedback.B();
        graphQLFeedback$Builder.f3111C = graphQLFeedback.C();
        graphQLFeedback$Builder.f3112D = graphQLFeedback.D();
        graphQLFeedback$Builder.f3113E = graphQLFeedback.E();
        graphQLFeedback$Builder.f3114F = graphQLFeedback.F();
        graphQLFeedback$Builder.f3115G = graphQLFeedback.G();
        graphQLFeedback$Builder.f3116H = graphQLFeedback.H();
        graphQLFeedback$Builder.f3117I = graphQLFeedback.I();
        graphQLFeedback$Builder.f3118J = graphQLFeedback.J();
        graphQLFeedback$Builder.f3119K = graphQLFeedback.K();
        graphQLFeedback$Builder.f3120L = graphQLFeedback.L();
        graphQLFeedback$Builder.f3121M = graphQLFeedback.M();
        graphQLFeedback$Builder.f3122N = graphQLFeedback.N();
        graphQLFeedback$Builder.f3123O = graphQLFeedback.V();
        graphQLFeedback$Builder.f3124P = graphQLFeedback.O();
        graphQLFeedback$Builder.f3125Q = graphQLFeedback.X();
        graphQLFeedback$Builder.f3126R = graphQLFeedback.P();
        graphQLFeedback$Builder.f3127S = graphQLFeedback.Q();
        graphQLFeedback$Builder.f3128T = graphQLFeedback.R();
        graphQLFeedback$Builder.f3129U = graphQLFeedback.S();
        graphQLFeedback$Builder.f3130V = graphQLFeedback.T();
        graphQLFeedback$Builder.f3131W = graphQLFeedback.U();
        Builder.a(graphQLFeedback$Builder, graphQLFeedback);
        graphQLFeedback$Builder.f3132X = (PropertyBag) graphQLFeedback.U_().clone();
        return graphQLFeedback$Builder;
    }

    public final GraphQLFeedback$Builder m3393b(boolean z) {
        this.f3134e = z;
        if (this.a != null && this.a.d) {
            this.a.a(this.b, 2, z);
        }
        return this;
    }

    public final GraphQLFeedback$Builder m3394f(boolean z) {
        this.f3138i = z;
        if (this.a != null && this.a.d) {
            this.a.a(this.b, 6, z);
        }
        return this;
    }

    public final GraphQLFeedback$Builder m3395j(boolean z) {
        this.f3146q = z;
        if (this.a != null && this.a.d) {
            this.a.a(this.b, 14, z);
        }
        return this;
    }

    public final GraphQLFeedback$Builder m3396m(boolean z) {
        this.f3155z = z;
        if (this.a != null && this.a.d) {
            this.a.a(this.b, 22, z);
        }
        return this;
    }

    public final GraphQLFeedback$Builder m3391a(int i) {
        this.f3129U = i;
        if (this.a != null && this.a.d) {
            this.a.b(this.b, 42, i);
        }
        return this;
    }

    public final GraphQLFeedback m3392a() {
        return new GraphQLFeedback(this);
    }
}
