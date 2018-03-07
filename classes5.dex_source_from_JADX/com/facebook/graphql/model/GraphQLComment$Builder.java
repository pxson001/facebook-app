package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: is_away_toggle_on */
public class GraphQLComment$Builder extends Builder {
    public int f3449A;
    public int f3450B;
    @Nullable
    public GraphQLPostTranslatability f3451C;
    @Nullable
    public GraphQLTextWithEntities f3452D;
    @Nullable
    public String f3453E;
    public boolean f3454F;
    public int f3455d;
    @Nullable
    public GraphQLStory f3456e;
    public ImmutableList<GraphQLStoryAttachment> f3457f;
    @Nullable
    public GraphQLActor f3458g;
    @Nullable
    public GraphQLTextWithEntities f3459h;
    @Nullable
    public GraphQLTextWithEntities f3460i;
    public boolean f3461j;
    public boolean f3462k;
    @Nullable
    public GraphQLComment f3463l;
    public long f3464m;
    @Nullable
    public GraphQLEditHistoryConnection f3465n;
    @Nullable
    public GraphQLFeedback f3466o;
    @Nullable
    public String f3467p;
    @Nullable
    public GraphQLInterestingRepliesConnection f3468q;
    public boolean f3469r;
    public boolean f3470s;
    public boolean f3471t;
    public ImmutableList<GraphQLStoryAttachment> f3472u;
    @Nullable
    public GraphQLFeedback f3473v;
    @Nullable
    public GraphQLTextWithEntities f3474w;
    @Nullable
    public GraphQLPrivacyScope f3475x;
    @Nullable
    public GraphQLPrivateReplyContext f3476y;
    @Nullable
    public String f3477z;

    public GraphQLComment$Builder() {
        Preconditions.checkState(this instanceof GraphQLComment$Builder);
    }

    public static GraphQLComment$Builder m6799a(GraphQLComment graphQLComment) {
        GraphQLComment$Builder graphQLComment$Builder = new GraphQLComment$Builder();
        graphQLComment.h();
        graphQLComment$Builder.f3455d = graphQLComment.o();
        graphQLComment$Builder.f3456e = graphQLComment.p();
        graphQLComment$Builder.f3457f = graphQLComment.q();
        graphQLComment$Builder.f3458g = graphQLComment.r();
        graphQLComment$Builder.f3459h = graphQLComment.s();
        graphQLComment$Builder.f3460i = graphQLComment.P();
        graphQLComment$Builder.f3461j = graphQLComment.t();
        graphQLComment$Builder.f3462k = graphQLComment.u();
        graphQLComment$Builder.f3463l = graphQLComment.v();
        graphQLComment$Builder.f3464m = graphQLComment.w();
        graphQLComment$Builder.f3465n = graphQLComment.x();
        graphQLComment$Builder.f3466o = graphQLComment.l();
        graphQLComment$Builder.f3467p = graphQLComment.y();
        graphQLComment$Builder.f3468q = graphQLComment.z();
        graphQLComment$Builder.f3469r = graphQLComment.A();
        graphQLComment$Builder.f3470s = graphQLComment.B();
        graphQLComment$Builder.f3471t = graphQLComment.C();
        graphQLComment$Builder.f3472u = graphQLComment.D();
        graphQLComment$Builder.f3473v = graphQLComment.O();
        graphQLComment$Builder.f3474w = graphQLComment.E();
        graphQLComment$Builder.f3475x = graphQLComment.F();
        graphQLComment$Builder.f3476y = graphQLComment.G();
        graphQLComment$Builder.f3477z = graphQLComment.H();
        graphQLComment$Builder.f3449A = graphQLComment.I();
        graphQLComment$Builder.f3450B = graphQLComment.M();
        graphQLComment$Builder.f3451C = graphQLComment.J();
        graphQLComment$Builder.f3452D = graphQLComment.K();
        graphQLComment$Builder.f3453E = graphQLComment.L();
        graphQLComment$Builder.f3454F = graphQLComment.N();
        Builder.a(graphQLComment$Builder, graphQLComment);
        return graphQLComment$Builder;
    }

    public final GraphQLComment$Builder m6800a(long j) {
        this.f3464m = j;
        return this;
    }

    public final GraphQLComment m6801a() {
        return new GraphQLComment(this);
    }
}
