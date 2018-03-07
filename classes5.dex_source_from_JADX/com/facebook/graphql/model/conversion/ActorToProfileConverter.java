package com.facebook.graphql.model.conversion;

import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLPage$Builder;
import com.facebook.graphql.model.GraphQLProfile;
import javax.annotation.Nullable;

/* compiled from: TUTORING */
public class ActorToProfileConverter {
    @Nullable
    public static GraphQLProfile m22598a(GraphQLActor graphQLActor) {
        if (graphQLActor.b() == null) {
            return null;
        }
        if (graphQLActor.b().g() == 2479791) {
            GraphQLPage graphQLPage;
            if (graphQLActor == null || graphQLActor.b() == null || graphQLActor.b().g() != 2479791) {
                graphQLPage = null;
            } else {
                GraphQLPage$Builder graphQLPage$Builder = new GraphQLPage$Builder();
                graphQLPage$Builder.f4722g = graphQLActor.j();
                graphQLPage$Builder.f4731p = graphQLActor.o();
                graphQLPage$Builder.f4736u = graphQLActor.r();
                graphQLPage$Builder.f4737v = graphQLActor.t();
                graphQLPage$Builder.f4693A = graphQLActor.v();
                graphQLPage$Builder.f4700H = graphQLActor.x();
                graphQLPage$Builder.f4703K = graphQLActor.A();
                graphQLPage$Builder.f4718Z = graphQLActor.H();
                graphQLPage$Builder.af = graphQLActor.I();
                graphQLPage$Builder.aj = graphQLActor.M();
                graphQLPage$Builder.am = graphQLActor.N();
                graphQLPage$Builder.ar = graphQLActor.R();
                graphQLPage$Builder.av = graphQLActor.U();
                graphQLPage$Builder.aw = graphQLActor.V();
                graphQLPage$Builder.aD = graphQLActor.Y();
                graphQLPage$Builder.aF = graphQLActor.aa();
                graphQLPage$Builder.aG = graphQLActor.ab();
                graphQLPage$Builder.aQ = graphQLActor.ad();
                graphQLPage$Builder.be = graphQLActor.ae();
                graphQLPage$Builder.bm = graphQLActor.af();
                graphQLPage$Builder.br = graphQLActor.ah();
                graphQLPage$Builder.bv = graphQLActor.ai();
                graphQLPage$Builder.bw = graphQLActor.ak();
                graphQLPage$Builder.bx = graphQLActor.aL();
                graphQLPage$Builder.bE = graphQLActor.al();
                graphQLPage$Builder.bF = graphQLActor.am();
                GraphQLSecondarySubscribeStatus an = graphQLActor.an();
                graphQLPage$Builder.bJ = an;
                if (graphQLPage$Builder.a != null && graphQLPage$Builder.a.d) {
                    graphQLPage$Builder.a.a(graphQLPage$Builder.b, 128, an);
                }
                graphQLPage$Builder.bV = graphQLActor.ao();
                graphQLPage$Builder.bZ = graphQLActor.ap();
                graphQLPage$Builder.ca = graphQLActor.aq();
                graphQLPage$Builder.cb = graphQLActor.ar();
                graphQLPage$Builder.cd = graphQLActor.at();
                graphQLPage$Builder.cp = graphQLActor.av();
                graphQLPage$Builder.cq = graphQLActor.aw();
                graphQLPage$Builder.cr = graphQLActor.ax();
                graphQLPage$Builder.ct = graphQLActor.ay();
                graphQLPage$Builder.cu = graphQLActor.aJ();
                graphQLPage$Builder.cv = graphQLActor.az();
                graphQLPage$Builder.cw = graphQLActor.aA();
                boolean aI = graphQLActor.aI();
                graphQLPage$Builder.cx = aI;
                if (graphQLPage$Builder.a != null && graphQLPage$Builder.a.d) {
                    graphQLPage$Builder.a.a(graphQLPage$Builder.b, 166, aI);
                }
                aI = graphQLActor.aB();
                graphQLPage$Builder.cy = aI;
                if (graphQLPage$Builder.a != null && graphQLPage$Builder.a.d) {
                    graphQLPage$Builder.a.a(graphQLPage$Builder.b, 167, aI);
                }
                graphQLPage$Builder.cA = graphQLActor.aC();
                graphQLPage$Builder.cB = graphQLActor.aD();
                graphQLPage$Builder.cC = graphQLActor.aE();
                graphQLPage$Builder.cD = graphQLActor.aF();
                graphQLPage$Builder.cE = graphQLActor.aG();
                graphQLPage = graphQLPage$Builder.m9460a();
            }
            return GraphQLPageConversionHelper.m22612b(graphQLPage);
        } else if (graphQLActor.b().g() == 2645995) {
            return GraphQLUserConversionHelper.m22614a(GraphQLActorConversionHelper.m22600b(graphQLActor));
        } else {
            return null;
        }
    }
}
