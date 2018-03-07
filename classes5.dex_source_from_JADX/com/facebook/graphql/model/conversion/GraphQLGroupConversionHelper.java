package com.facebook.graphql.model.conversion;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLGroup;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLProfile$Builder;
import javax.annotation.Nullable;

/* compiled from: TT;>;>; */
public final class GraphQLGroupConversionHelper {
    @Nullable
    public static GraphQLProfile m22608a(GraphQLGroup graphQLGroup) {
        GraphQLProfile$Builder graphQLProfile$Builder = new GraphQLProfile$Builder();
        graphQLProfile$Builder.f12802l = graphQLGroup.p();
        graphQLProfile$Builder.f12804n = graphQLGroup.q();
        graphQLProfile$Builder.f12809s = graphQLGroup.s();
        graphQLProfile$Builder.f12816z = graphQLGroup.w();
        graphQLProfile$Builder.f12772E = graphQLGroup.C();
        graphQLProfile$Builder.f12773F = graphQLGroup.D();
        graphQLProfile$Builder.f12774G = graphQLGroup.I();
        graphQLProfile$Builder.f12784Q = graphQLGroup.P();
        graphQLProfile$Builder.f12785R = graphQLGroup.Q();
        graphQLProfile$Builder.f12792Y = graphQLGroup.U();
        graphQLProfile$Builder.aa = graphQLGroup.X();
        graphQLProfile$Builder.ab = graphQLGroup.Y();
        graphQLProfile$Builder.ac = graphQLGroup.Z();
        graphQLProfile$Builder.ad = graphQLGroup.ab();
        graphQLProfile$Builder.ae = graphQLGroup.ag();
        graphQLProfile$Builder.af = graphQLGroup.ah();
        graphQLProfile$Builder.aj = graphQLGroup.an();
        graphQLProfile$Builder.ak = graphQLGroup.ao();
        graphQLProfile$Builder.m21094a(graphQLGroup.ap());
        graphQLProfile$Builder.ao = graphQLGroup.aq();
        graphQLProfile$Builder.at = graphQLGroup.au();
        Enum aI = graphQLGroup.aI();
        graphQLProfile$Builder.ax = aI;
        if (graphQLProfile$Builder.a != null && graphQLProfile$Builder.a.d) {
            graphQLProfile$Builder.a.a(graphQLProfile$Builder.b, 75, aI);
        }
        graphQLProfile$Builder.aB = graphQLGroup.aQ();
        graphQLProfile$Builder.aE = new GraphQLObjectType(69076575);
        return graphQLProfile$Builder.m21095a();
    }
}
