package com.facebook.graphql.model.conversion;

import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLUser;
import com.facebook.graphql.model.GraphQLUser$Builder;
import javax.annotation.Nullable;

/* compiled from: TURN_OFF */
public final class GraphQLActorConversionHelper {
    @Nullable
    public static GraphQLUser m22600b(@Nullable GraphQLActor graphQLActor) {
        if (graphQLActor == null || graphQLActor.b() == null || graphQLActor.b().g() != 2645995) {
            return null;
        }
        GraphQLUser$Builder graphQLUser$Builder = new GraphQLUser$Builder();
        graphQLUser$Builder.f13423h = graphQLActor.k();
        graphQLUser$Builder.f13426k = graphQLActor.m();
        graphQLUser$Builder.f13427l = graphQLActor.n();
        graphQLUser$Builder.f13430o = graphQLActor.o();
        graphQLUser$Builder.f13431p = graphQLActor.p();
        graphQLUser$Builder.f13432q = graphQLActor.q();
        boolean r = graphQLActor.r();
        graphQLUser$Builder.f13433r = r;
        if (graphQLUser$Builder.a != null && graphQLUser$Builder.a.d) {
            graphQLUser$Builder.a.a(graphQLUser$Builder.b, 13, r);
        }
        r = graphQLActor.s();
        graphQLUser$Builder.f13434s = r;
        if (graphQLUser$Builder.a != null && graphQLUser$Builder.a.d) {
            graphQLUser$Builder.a.a(graphQLUser$Builder.b, 14, r);
        }
        r = graphQLActor.t();
        graphQLUser$Builder.f13435t = r;
        if (graphQLUser$Builder.a != null && graphQLUser$Builder.a.d) {
            graphQLUser$Builder.a.a(graphQLUser$Builder.b, 15, r);
        }
        graphQLUser$Builder.f13436u = graphQLActor.u();
        graphQLUser$Builder.f13437v = graphQLActor.w();
        graphQLUser$Builder.f13439x = graphQLActor.x();
        graphQLUser$Builder.f13441z = graphQLActor.y();
        graphQLUser$Builder.f13394B = graphQLActor.A();
        graphQLUser$Builder.f13395C = graphQLActor.B();
        graphQLUser$Builder.f13396D = graphQLActor.C();
        graphQLUser$Builder.f13401I = graphQLActor.D();
        GraphQLFriendshipStatus E = graphQLActor.E();
        graphQLUser$Builder.f13402J = E;
        if (graphQLUser$Builder.a != null && graphQLUser$Builder.a.d) {
            graphQLUser$Builder.a.a(graphQLUser$Builder.b, 31, E);
        }
        graphQLUser$Builder.f13403K = graphQLActor.F();
        graphQLUser$Builder.f13405M = graphQLActor.G();
        graphQLUser$Builder.f13406N = graphQLActor.H();
        graphQLUser$Builder.f13409Q = graphQLActor.I();
        graphQLUser$Builder.f13411S = graphQLActor.J();
        graphQLUser$Builder.f13412T = graphQLActor.K();
        graphQLUser$Builder.f13413U = graphQLActor.L();
        graphQLUser$Builder.f13414V = graphQLActor.M();
        graphQLUser$Builder.f13416X = graphQLActor.N();
        graphQLUser$Builder.f13417Y = graphQLActor.O();
        graphQLUser$Builder.f13418Z = graphQLActor.P();
        graphQLUser$Builder.aa = graphQLActor.Q();
        graphQLUser$Builder.ad = graphQLActor.R();
        graphQLUser$Builder.ae = graphQLActor.aM();
        graphQLUser$Builder.af = graphQLActor.S();
        graphQLUser$Builder.ah = graphQLActor.T();
        graphQLUser$Builder.ai = graphQLActor.U();
        graphQLUser$Builder.aj = graphQLActor.V();
        graphQLUser$Builder.am = graphQLActor.W();
        graphQLUser$Builder.an = graphQLActor.X();
        graphQLUser$Builder.ao = graphQLActor.Y();
        graphQLUser$Builder.aq = graphQLActor.Z();
        graphQLUser$Builder.ar = graphQLActor.aa();
        graphQLUser$Builder.as = graphQLActor.ab();
        graphQLUser$Builder.at = graphQLActor.ac();
        graphQLUser$Builder.au = graphQLActor.ae();
        graphQLUser$Builder.aA = graphQLActor.af();
        graphQLUser$Builder.aD = graphQLActor.ag();
        graphQLUser$Builder.aE = graphQLActor.ah();
        graphQLUser$Builder.aI = graphQLActor.ai();
        graphQLUser$Builder.aJ = graphQLActor.aj();
        graphQLUser$Builder.aK = graphQLActor.ak();
        graphQLUser$Builder.aL = graphQLActor.aL();
        graphQLUser$Builder.aO = graphQLActor.al();
        graphQLUser$Builder.aP = graphQLActor.am();
        GraphQLSecondarySubscribeStatus an = graphQLActor.an();
        graphQLUser$Builder.aQ = an;
        if (graphQLUser$Builder.a != null && graphQLUser$Builder.a.d) {
            graphQLUser$Builder.a.a(graphQLUser$Builder.b, 88, an);
        }
        graphQLUser$Builder.aS = graphQLActor.aK();
        graphQLUser$Builder.aT = graphQLActor.ao();
        graphQLUser$Builder.aV = graphQLActor.ap();
        graphQLUser$Builder.aW = graphQLActor.aq();
        graphQLUser$Builder.aX = graphQLActor.ar();
        graphQLUser$Builder.aZ = graphQLActor.as();
        GraphQLSubscribeStatus at = graphQLActor.at();
        graphQLUser$Builder.bb = at;
        if (graphQLUser$Builder.a != null && graphQLUser$Builder.a.d) {
            graphQLUser$Builder.a.a(graphQLUser$Builder.b, 98, at);
        }
        graphQLUser$Builder.bd = graphQLActor.au();
        graphQLUser$Builder.bh = graphQLActor.av();
        graphQLUser$Builder.bj = graphQLActor.aw();
        String ax = graphQLActor.ax();
        graphQLUser$Builder.bk = ax;
        if (graphQLUser$Builder.a != null && graphQLUser$Builder.a.d) {
            graphQLUser$Builder.a.a(graphQLUser$Builder.b, 105, ax);
        }
        graphQLUser$Builder.bl = graphQLActor.ay();
        graphQLUser$Builder.bm = graphQLActor.aJ();
        graphQLUser$Builder.bn = graphQLActor.az();
        graphQLUser$Builder.bo = graphQLActor.aA();
        r = graphQLActor.aI();
        graphQLUser$Builder.bp = r;
        if (graphQLUser$Builder.a != null && graphQLUser$Builder.a.d) {
            graphQLUser$Builder.a.a(graphQLUser$Builder.b, 110, r);
        }
        r = graphQLActor.aB();
        graphQLUser$Builder.bq = r;
        if (graphQLUser$Builder.a != null && graphQLUser$Builder.a.d) {
            graphQLUser$Builder.a.a(graphQLUser$Builder.b, 111, r);
        }
        graphQLUser$Builder.bs = graphQLActor.aC();
        graphQLUser$Builder.bt = graphQLActor.aD();
        graphQLUser$Builder.bu = graphQLActor.aE();
        graphQLUser$Builder.bv = graphQLActor.aF();
        graphQLUser$Builder.by = graphQLActor.aH();
        return graphQLUser$Builder.m22381a();
    }
}
