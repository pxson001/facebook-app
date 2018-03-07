package com.facebook.graphql.model.conversion;

import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLProfile$Builder;
import com.facebook.graphql.model.GraphQLUser;
import javax.annotation.Nullable;

/* compiled from: TT;)TT; */
public final class GraphQLUserConversionHelper {
    @Nullable
    public static GraphQLProfile m22614a(GraphQLUser graphQLUser) {
        GraphQLProfile$Builder graphQLProfile$Builder = new GraphQLProfile$Builder();
        graphQLProfile$Builder.f12794d = graphQLUser.k();
        graphQLProfile$Builder.f12795e = graphQLUser.m();
        graphQLProfile$Builder.f12797g = graphQLUser.r();
        graphQLProfile$Builder.f12798h = graphQLUser.t();
        graphQLProfile$Builder.f12799i = graphQLUser.u();
        graphQLProfile$Builder.f12802l = graphQLUser.v();
        graphQLProfile$Builder.f12803m = graphQLUser.w();
        graphQLProfile$Builder.f12804n = graphQLUser.x();
        graphQLProfile$Builder.f12805o = graphQLUser.y();
        graphQLProfile$Builder.f12807q = graphQLUser.z();
        graphQLProfile$Builder.f12809s = graphQLUser.B();
        graphQLProfile$Builder.f12811u = graphQLUser.D();
        graphQLProfile$Builder.f12812v = graphQLUser.E();
        graphQLProfile$Builder.f12816z = graphQLUser.H();
        graphQLProfile$Builder.f12769B = graphQLUser.L();
        GraphQLFriendshipStatus M = graphQLUser.M();
        graphQLProfile$Builder.f12770C = M;
        if (graphQLProfile$Builder.a != null && graphQLProfile$Builder.a.d) {
            graphQLProfile$Builder.a.a(graphQLProfile$Builder.b, 28, M);
        }
        graphQLProfile$Builder.f12774G = graphQLUser.P();
        graphQLProfile$Builder.f12776I = graphQLUser.V();
        graphQLProfile$Builder.f12777J = graphQLUser.Y();
        graphQLProfile$Builder.f12779L = graphQLUser.ae();
        graphQLProfile$Builder.f12780M = graphQLUser.ag();
        graphQLProfile$Builder.f12781N = graphQLUser.ai();
        graphQLProfile$Builder.f12783P = graphQLUser.aq();
        graphQLProfile$Builder.f12784Q = graphQLUser.ar();
        graphQLProfile$Builder.f12785R = graphQLUser.as();
        graphQLProfile$Builder.f12792Y = graphQLUser.au();
        graphQLProfile$Builder.f12793Z = graphQLUser.av();
        graphQLProfile$Builder.aa = graphQLUser.aw();
        graphQLProfile$Builder.ab = graphQLUser.ax();
        graphQLProfile$Builder.ac = graphQLUser.az();
        graphQLProfile$Builder.ad = graphQLUser.aC();
        graphQLProfile$Builder.ae = graphQLUser.aI();
        graphQLProfile$Builder.af = graphQLUser.aK();
        graphQLProfile$Builder.m21093a(graphQLUser.aP());
        graphQLProfile$Builder.aj = graphQLUser.aS();
        graphQLProfile$Builder.ak = graphQLUser.aW();
        graphQLProfile$Builder.al = graphQLUser.aX();
        graphQLProfile$Builder.am = graphQLUser.aY();
        graphQLProfile$Builder.m21094a(graphQLUser.aZ());
        graphQLProfile$Builder.ao = graphQLUser.ba();
        graphQLProfile$Builder.ap = graphQLUser.bb();
        graphQLProfile$Builder.at = graphQLUser.bf();
        graphQLProfile$Builder.au = graphQLUser.bs();
        graphQLProfile$Builder.aC = graphQLUser.bt();
        graphQLProfile$Builder.aD = graphQLUser.bv();
        graphQLProfile$Builder.aE = new GraphQLObjectType(2645995);
        return graphQLProfile$Builder.m21095a();
    }
}
