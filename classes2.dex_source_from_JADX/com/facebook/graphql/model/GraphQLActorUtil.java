package com.facebook.graphql.model;

import com.facebook.common.util.StringUtil;
import javax.annotation.Nullable;

/* compiled from: graphqlbatch */
public class GraphQLActorUtil {
    private GraphQLActorUtil() {
    }

    public static String m29707a(GraphQLActor graphQLActor) {
        return !StringUtil.m3591a(graphQLActor.aa()) ? graphQLActor.aa() : "";
    }

    public static boolean m29708b(GraphQLActor graphQLActor) {
        return (graphQLActor.ai() == null || graphQLActor.ai().mo2924b() == null) ? false : true;
    }

    public static String m29709c(GraphQLActor graphQLActor) {
        return m29708b(graphQLActor) ? graphQLActor.ai().mo2924b() : "";
    }

    @Nullable
    public static String m29710d(GraphQLActor graphQLActor) {
        if (graphQLActor != null) {
            GraphQLProfileVideo aL = graphQLActor.aL();
            if (aL != null) {
                GraphQLVideo j = aL.m24691j();
                if (j != null) {
                    return j.aE();
                }
            }
        }
        return null;
    }
}
