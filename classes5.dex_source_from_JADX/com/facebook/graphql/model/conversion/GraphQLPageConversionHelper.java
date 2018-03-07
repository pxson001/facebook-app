package com.facebook.graphql.model.conversion;

import com.facebook.graphql.enums.GraphQLLiveVideoSubscriptionStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActor.Builder;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLProfile$Builder;
import javax.annotation.Nullable;

/* compiled from: TT;>; */
public final class GraphQLPageConversionHelper {
    @Nullable
    public static GraphQLActor m22611a(GraphQLPage graphQLPage) {
        Builder builder = new Builder();
        builder.d = graphQLPage.m();
        builder.i = graphQLPage.v();
        boolean z = graphQLPage.z();
        builder.l = z;
        if (builder.a != null && builder.a.d) {
            builder.a.a(builder.b, 10, z);
        }
        builder.n = graphQLPage.A();
        builder.p = graphQLPage.F();
        builder.r = graphQLPage.M();
        builder.u = graphQLPage.P();
        builder.B = graphQLPage.ae();
        builder.C = graphQLPage.ak();
        builder.G = graphQLPage.an();
        builder.H = graphQLPage.ap();
        builder.L = graphQLPage.au();
        builder.P = graphQLPage.ax();
        GraphQLLiveVideoSubscriptionStatus ay = graphQLPage.ay();
        builder.Q = ay;
        if (builder.a != null && builder.a.d) {
            builder.a.a(builder.b, 43, ay);
        }
        builder.T = graphQLPage.aE();
        builder.V = graphQLPage.aG();
        builder.W = graphQLPage.aH();
        builder.Y = graphQLPage.aP();
        builder.Z = graphQLPage.bb();
        builder.aa = graphQLPage.bj();
        builder.ac = graphQLPage.bo();
        builder.ad = graphQLPage.bs();
        builder.af = graphQLPage.bt();
        builder.ag = graphQLPage.cP();
        builder.ah = graphQLPage.bA();
        builder.ai = graphQLPage.bB();
        GraphQLSecondarySubscribeStatus bF = graphQLPage.bF();
        builder.aj = bF;
        if (builder.a != null && builder.a.d) {
            builder.a.a(builder.b, 62, bF);
        }
        builder.al = graphQLPage.bQ();
        builder.am = graphQLPage.bU();
        builder.an = graphQLPage.bV();
        builder.ao = graphQLPage.bW();
        GraphQLSubscribeStatus bY = graphQLPage.bY();
        builder.aq = bY;
        if (builder.a != null && builder.a.d) {
            builder.a.a(builder.b, 68, bY);
        }
        builder.as = graphQLPage.cj();
        builder.at = graphQLPage.ck();
        builder.au = graphQLPage.cl();
        builder.av = graphQLPage.cn();
        builder.aw = graphQLPage.co();
        builder.ax = graphQLPage.cp();
        builder.ay = graphQLPage.cq();
        z = graphQLPage.cr();
        builder.az = z;
        if (builder.a != null && builder.a.d) {
            builder.a.a(builder.b, 84, z);
        }
        z = graphQLPage.cs();
        builder.aA = z;
        if (builder.a != null && builder.a.d) {
            builder.a.a(builder.b, 77, z);
        }
        builder.aB = graphQLPage.cu();
        builder.aC = graphQLPage.cv();
        builder.aD = graphQLPage.cw();
        builder.aE = graphQLPage.cx();
        builder.aF = graphQLPage.cy();
        builder.aH = new GraphQLObjectType(2479791);
        return builder.a();
    }

    @Nullable
    public static GraphQLProfile m22612b(GraphQLPage graphQLPage) {
        GraphQLProfile$Builder graphQLProfile$Builder = new GraphQLProfile$Builder();
        graphQLProfile$Builder.f12794d = graphQLPage.l();
        graphQLProfile$Builder.f12796f = graphQLPage.s();
        graphQLProfile$Builder.f12801k = graphQLPage.y();
        graphQLProfile$Builder.f12802l = graphQLPage.z();
        graphQLProfile$Builder.f12804n = graphQLPage.A();
        graphQLProfile$Builder.f12806p = graphQLPage.F();
        graphQLProfile$Builder.f12809s = graphQLPage.M();
        boolean O = graphQLPage.O();
        graphQLProfile$Builder.f12810t = O;
        if (graphQLProfile$Builder.a != null && graphQLProfile$Builder.a.d) {
            graphQLProfile$Builder.a.a(graphQLProfile$Builder.b, 18, O);
        }
        graphQLProfile$Builder.f12812v = graphQLPage.P();
        graphQLProfile$Builder.f12814x = graphQLPage.S();
        graphQLProfile$Builder.f12815y = graphQLPage.T();
        graphQLProfile$Builder.f12816z = graphQLPage.X();
        graphQLProfile$Builder.f12774G = graphQLPage.ae();
        graphQLProfile$Builder.f12777J = graphQLPage.ap();
        graphQLProfile$Builder.f12779L = graphQLPage.au();
        graphQLProfile$Builder.f12782O = graphQLPage.az();
        graphQLProfile$Builder.f12784Q = graphQLPage.aG();
        graphQLProfile$Builder.f12785R = graphQLPage.aH();
        graphQLProfile$Builder.f12786S = graphQLPage.aJ();
        graphQLProfile$Builder.f12787T = graphQLPage.aK();
        graphQLProfile$Builder.f12789V = graphQLPage.aP();
        graphQLProfile$Builder.f12790W = graphQLPage.aS();
        graphQLProfile$Builder.f12792Y = graphQLPage.bb();
        graphQLProfile$Builder.aa = graphQLPage.bf();
        graphQLProfile$Builder.ab = graphQLPage.bg();
        graphQLProfile$Builder.ac = graphQLPage.bi();
        graphQLProfile$Builder.ad = graphQLPage.bn();
        graphQLProfile$Builder.ae = graphQLPage.bs();
        graphQLProfile$Builder.af = graphQLPage.bt();
        graphQLProfile$Builder.ag = graphQLPage.by();
        graphQLProfile$Builder.m21093a(graphQLPage.bF());
        graphQLProfile$Builder.ai = graphQLPage.bG();
        graphQLProfile$Builder.ak = graphQLPage.bX();
        graphQLProfile$Builder.m21094a(graphQLPage.bY());
        graphQLProfile$Builder.ao = graphQLPage.ca();
        graphQLProfile$Builder.aq = graphQLPage.cg();
        graphQLProfile$Builder.ar = graphQLPage.ch();
        graphQLProfile$Builder.as = graphQLPage.ci();
        graphQLProfile$Builder.at = graphQLPage.ck();
        graphQLProfile$Builder.ay = graphQLPage.cA();
        graphQLProfile$Builder.az = graphQLPage.cB();
        graphQLProfile$Builder.aC = graphQLPage.cF();
        graphQLProfile$Builder.aE = new GraphQLObjectType(2479791);
        return graphQLProfile$Builder.m21095a();
    }
}
