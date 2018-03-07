package com.facebook.graphql.model.conversion;

import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.GraphQLPhoto$Builder;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import javax.annotation.Nullable;

/* compiled from: TT;>;)V */
public final class GraphQLNodeConversionHelper {
    @Nullable
    public static GraphQLStory m22609a(@Nullable GraphQLNode graphQLNode) {
        if (graphQLNode == null || graphQLNode.j() == null || graphQLNode.j().g() != 80218325) {
            return null;
        }
        Builder builder = new Builder();
        builder.d = graphQLNode.l();
        builder.e = graphQLNode.n();
        builder.f = graphQLNode.q();
        builder.g = graphQLNode.D();
        builder.h = graphQLNode.J();
        builder.i = graphQLNode.O();
        builder.j = graphQLNode.T();
        builder.k = graphQLNode.Z();
        builder.l = graphQLNode.aa();
        builder.m = graphQLNode.ab();
        builder.o = graphQLNode.at();
        builder.p = graphQLNode.aA();
        builder.q = graphQLNode.aJ();
        builder.r = graphQLNode.aK();
        builder.s = graphQLNode.aL();
        builder.t = graphQLNode.aM();
        builder.u = graphQLNode.aN();
        builder.x = graphQLNode.bw();
        builder.z = graphQLNode.bK();
        builder.A = graphQLNode.bS();
        builder.B = graphQLNode.ct();
        builder.C = graphQLNode.cz();
        builder.D = graphQLNode.cB();
        builder.E = graphQLNode.kf();
        builder.G = graphQLNode.cM();
        builder.H = graphQLNode.dg();
        builder.I = graphQLNode.dk();
        builder.J = graphQLNode.dn();
        builder.K = graphQLNode.dp();
        builder.L = graphQLNode.dv();
        builder.M = graphQLNode.dz();
        builder.N = graphQLNode.dA();
        builder.P = graphQLNode.ej();
        builder.X = graphQLNode.eD();
        builder.Y = graphQLNode.kD();
        builder.Z = graphQLNode.eJ();
        builder.aa = graphQLNode.eQ();
        builder.ab = graphQLNode.ft();
        builder.ac = graphQLNode.fy();
        builder.ad = graphQLNode.fJ();
        builder.ae = graphQLNode.gb();
        builder.af = graphQLNode.gm();
        builder.ag = graphQLNode.gz();
        builder.ah = graphQLNode.gA();
        builder.ai = graphQLNode.gJ();
        builder.a(graphQLNode.gS());
        builder.al = graphQLNode.hc();
        builder.am = graphQLNode.hf();
        builder.ao = graphQLNode.hH();
        builder.aq = graphQLNode.hQ();
        builder.at = graphQLNode.hU();
        builder.au = graphQLNode.hV();
        builder.av = graphQLNode.hW();
        builder.aw = graphQLNode.hY();
        builder.ax = graphQLNode.ia();
        builder.ay = graphQLNode.it();
        builder.az = graphQLNode.iu();
        builder.aA = graphQLNode.iv();
        builder.aB = graphQLNode.iA();
        builder.aC = graphQLNode.iD();
        builder.aD = graphQLNode.iH();
        builder.aE = graphQLNode.iJ();
        builder.aF = graphQLNode.iK();
        builder.aG = graphQLNode.iR();
        builder.aH = graphQLNode.iV();
        builder.aI = graphQLNode.jN();
        builder.aJ = graphQLNode.jl();
        builder.aK = graphQLNode.ju();
        return builder.a();
    }

    @Nullable
    public static GraphQLPhoto m22610c(@Nullable GraphQLNode graphQLNode) {
        if (graphQLNode == null || graphQLNode.j() == null || graphQLNode.j().g() != 77090322) {
            return null;
        }
        GraphQLPhoto$Builder graphQLPhoto$Builder = new GraphQLPhoto$Builder();
        graphQLPhoto$Builder.f12530d = graphQLNode.ko();
        graphQLPhoto$Builder.f12531e = graphQLNode.w();
        graphQLPhoto$Builder.f12532f = graphQLNode.K();
        graphQLPhoto$Builder.f12533g = graphQLNode.L();
        graphQLPhoto$Builder.f12534h = graphQLNode.Y();
        graphQLPhoto$Builder.f12537k = graphQLNode.aj();
        graphQLPhoto$Builder.f12538l = graphQLNode.az();
        graphQLPhoto$Builder.f12539m = graphQLNode.aJ();
        graphQLPhoto$Builder.f12540n = graphQLNode.aK();
        graphQLPhoto$Builder.f12544r = graphQLNode.kW();
        graphQLPhoto$Builder.f12548v = graphQLNode.bu();
        graphQLPhoto$Builder.f12549w = graphQLNode.bv();
        graphQLPhoto$Builder.f12550x = graphQLNode.kQ();
        graphQLPhoto$Builder.f12551y = graphQLNode.ct();
        graphQLPhoto$Builder.f12504A = graphQLNode.cB();
        graphQLPhoto$Builder.f12507D = graphQLNode.di();
        graphQLPhoto$Builder.f12508E = graphQLNode.dj();
        graphQLPhoto$Builder.f12509F = graphQLNode.dp();
        graphQLPhoto$Builder.f12510G = graphQLNode.dq();
        graphQLPhoto$Builder.f12512I = graphQLNode.dr();
        graphQLPhoto$Builder.f12513J = graphQLNode.ds();
        graphQLPhoto$Builder.ad = graphQLNode.dv();
        graphQLPhoto$Builder.ae = graphQLNode.dz();
        graphQLPhoto$Builder.ai = graphQLNode.dJ();
        graphQLPhoto$Builder.aj = graphQLNode.dS();
        graphQLPhoto$Builder.as = graphQLNode.eD();
        graphQLPhoto$Builder.at = graphQLNode.eH();
        graphQLPhoto$Builder.aA = graphQLNode.fa();
        graphQLPhoto$Builder.aE = graphQLNode.fC();
        graphQLPhoto$Builder.aF = graphQLNode.fD();
        graphQLPhoto$Builder.aG = graphQLNode.kx();
        graphQLPhoto$Builder.aH = graphQLNode.fE();
        graphQLPhoto$Builder.aI = graphQLNode.fF();
        graphQLPhoto$Builder.aK = graphQLNode.fL();
        graphQLPhoto$Builder.aM = graphQLNode.gb();
        graphQLPhoto$Builder.aN = graphQLNode.gd();
        graphQLPhoto$Builder.aO = graphQLNode.ge();
        graphQLPhoto$Builder.aW = graphQLNode.iR();
        graphQLPhoto$Builder.aX = graphQLNode.kS();
        graphQLPhoto$Builder.aY = graphQLNode.ju();
        return graphQLPhoto$Builder.m20715a();
    }
}
