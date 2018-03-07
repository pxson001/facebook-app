package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPageCategoryType;
import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
import com.facebook.graphql.enums.GraphQLPageSuperCategoryType;
import com.facebook.graphql.enums.GraphQLPermanentlyClosedStatus;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: WEB_SEARCH */
public class GraphQLPlace$Builder extends Builder {
    @Nullable
    public GraphQLTextWithEntities f12591A;
    public GraphQLPageOpenHoursDisplayDecisionEnum f12592B = GraphQLPageOpenHoursDisplayDecisionEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public String f12593C;
    public GraphQLPlaceType f12594D = GraphQLPlaceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public String f12595E;
    @Nullable
    public GraphQLImage f12596F;
    @Nullable
    public GraphQLImage f12597G;
    @Nullable
    public GraphQLPhoto f12598H;
    @Nullable
    public GraphQLImage f12599I;
    public boolean f12600J;
    @Nullable
    public GraphQLPageStarRatersConnection f12601K;
    public ImmutableList<GraphQLRedirectionInfo> f12602L;
    public ImmutableList<GraphQLPhoto> f12603M;
    @Nullable
    public GraphQLTimelineAppCollection f12604N;
    public ImmutableList<String> f12605O;
    public boolean f12606P;
    public ImmutableList<String> f12607Q;
    public GraphQLPageSuperCategoryType f12608R = GraphQLPageSuperCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public String f12609S;
    public ImmutableList<String> f12610T;
    public GraphQLSavedState f12611U = GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLViewerVisitsConnection f12612V;
    public ImmutableList<String> f12613W;
    @Nullable
    public GraphQLObjectType f12614X = null;
    @Nullable
    public GraphQLStreetAddress f12615d;
    public boolean f12616e;
    public boolean f12617f;
    @Nullable
    public GraphQLImage f12618g;
    public ImmutableList<String> f12619h;
    public GraphQLPageCategoryType f12620i = GraphQLPageCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLPage f12621j;
    @Nullable
    public String f12622k;
    public boolean f12623l;
    public boolean f12624m;
    @Nullable
    public GraphQLFriendsWhoVisitedConnection f12625n;
    @Nullable
    public String f12626o;
    public ImmutableList<GraphQLTimeRange> f12627p;
    @Nullable
    public String f12628q;
    public boolean f12629r;
    @Nullable
    public GraphQLLocation f12630s;
    @Nullable
    public GraphQLGeoRectangle f12631t;
    @Nullable
    public String f12632u;
    @Nullable
    public GraphQLRating f12633v;
    @Nullable
    public GraphQLPageLikersConnection f12634w;
    @Nullable
    public GraphQLPageVisitsConnection f12635x;
    public GraphQLPermanentlyClosedStatus f12636y = GraphQLPermanentlyClosedStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLImage f12637z;

    public GraphQLPlace$Builder() {
        Preconditions.checkState(this instanceof GraphQLPlace$Builder);
    }

    public static GraphQLPlace$Builder m20830a(GraphQLPlace graphQLPlace) {
        GraphQLPlace$Builder graphQLPlace$Builder = new GraphQLPlace$Builder();
        graphQLPlace.h();
        graphQLPlace$Builder.f12615d = graphQLPlace.k();
        graphQLPlace$Builder.f12616e = graphQLPlace.l();
        graphQLPlace$Builder.f12617f = graphQLPlace.m();
        graphQLPlace$Builder.f12618g = graphQLPlace.n();
        graphQLPlace$Builder.f12619h = graphQLPlace.o();
        graphQLPlace$Builder.f12620i = graphQLPlace.p();
        graphQLPlace$Builder.f12621j = graphQLPlace.q();
        graphQLPlace$Builder.f12622k = graphQLPlace.r();
        graphQLPlace$Builder.f12623l = graphQLPlace.s();
        graphQLPlace$Builder.f12624m = graphQLPlace.t();
        graphQLPlace$Builder.f12625n = graphQLPlace.u();
        graphQLPlace$Builder.f12626o = graphQLPlace.v();
        graphQLPlace$Builder.f12627p = graphQLPlace.w();
        graphQLPlace$Builder.f12628q = graphQLPlace.x();
        graphQLPlace$Builder.f12629r = graphQLPlace.y();
        graphQLPlace$Builder.f12630s = graphQLPlace.z();
        graphQLPlace$Builder.f12631t = graphQLPlace.A();
        graphQLPlace$Builder.f12632u = graphQLPlace.B();
        graphQLPlace$Builder.f12633v = graphQLPlace.C();
        graphQLPlace$Builder.f12634w = graphQLPlace.D();
        graphQLPlace$Builder.f12635x = graphQLPlace.E();
        graphQLPlace$Builder.f12636y = graphQLPlace.F();
        graphQLPlace$Builder.f12637z = graphQLPlace.G();
        graphQLPlace$Builder.f12591A = graphQLPlace.ac();
        graphQLPlace$Builder.f12592B = graphQLPlace.ad();
        graphQLPlace$Builder.f12593C = graphQLPlace.H();
        graphQLPlace$Builder.f12594D = graphQLPlace.I();
        graphQLPlace$Builder.f12595E = graphQLPlace.J();
        graphQLPlace$Builder.f12596F = graphQLPlace.K();
        graphQLPlace$Builder.f12597G = graphQLPlace.L();
        graphQLPlace$Builder.f12598H = graphQLPlace.M();
        graphQLPlace$Builder.f12599I = graphQLPlace.N();
        graphQLPlace$Builder.f12600J = graphQLPlace.O();
        graphQLPlace$Builder.f12601K = graphQLPlace.P();
        graphQLPlace$Builder.f12602L = graphQLPlace.Q();
        graphQLPlace$Builder.f12603M = graphQLPlace.R();
        graphQLPlace$Builder.f12604N = graphQLPlace.S();
        graphQLPlace$Builder.f12605O = graphQLPlace.T();
        graphQLPlace$Builder.f12606P = graphQLPlace.U();
        graphQLPlace$Builder.f12607Q = graphQLPlace.V();
        graphQLPlace$Builder.f12608R = graphQLPlace.W();
        graphQLPlace$Builder.f12609S = graphQLPlace.X();
        graphQLPlace$Builder.f12610T = graphQLPlace.Y();
        graphQLPlace$Builder.f12611U = graphQLPlace.Z();
        graphQLPlace$Builder.f12612V = graphQLPlace.ab();
        graphQLPlace$Builder.f12613W = graphQLPlace.aa();
        Builder.a(graphQLPlace$Builder, graphQLPlace);
        graphQLPlace$Builder.f12614X = graphQLPlace.j();
        return graphQLPlace$Builder;
    }

    public final GraphQLPlace$Builder m20833c(@Nullable String str) {
        this.f12632u = str;
        if (this.a != null && this.a.d) {
            this.a.a(this.b, 19, str);
        }
        return this;
    }

    public final GraphQLPlace$Builder m20831a(GraphQLSavedState graphQLSavedState) {
        this.f12611U = graphQLSavedState;
        if (this.a != null && this.a.d) {
            this.a.a(this.b, 43, graphQLSavedState);
        }
        return this;
    }

    public final GraphQLPlace m20832a() {
        return new GraphQLPlace(this);
    }
}
