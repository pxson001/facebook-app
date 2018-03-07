package com.facebook.graphql.model;

import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: integration_point_id */
public class StoryHierarchyHelper {
    private StoryHierarchyHelper() {
    }

    @Deprecated
    public static GraphQLSubstoriesConnection m27434a(GraphQLStory graphQLStory) {
        GraphQLSubstoriesConnection G = graphQLStory.m22321G();
        if (G == null) {
            return GraphQLHelper.f15766g;
        }
        return G;
    }

    @Deprecated
    @Nullable
    public static GraphQLTextWithEntities m27435b(GraphQLStory graphQLStory) {
        GraphQLTextWithEntities graphQLTextWithEntities = graphQLStory.bd().f20929b;
        return graphQLTextWithEntities != null ? graphQLTextWithEntities : graphQLStory.aj();
    }

    public static GraphQLSubstoriesConnection m27436c(GraphQLStory graphQLStory) {
        GraphQLSubstoriesConnection G = graphQLStory.m22321G();
        return G == null ? GraphQLHelper.f15766g : G;
    }

    public static boolean m27437d(GraphQLStory graphQLStory) {
        return graphQLStory.aD() > 0;
    }

    public static GraphQLStory m27433a(GraphQLStory graphQLStory, String str) {
        String c = graphQLStory.m22350c();
        if (c != null && c.equals(str)) {
            return graphQLStory;
        }
        GraphQLStory L = graphQLStory.m22326L();
        if (L != null) {
            L = m27433a(L, str);
            if (L != null) {
                return L;
            }
        }
        GraphQLSubstoriesConnection G = graphQLStory.m22321G();
        if (G != null) {
            ImmutableList j = G.m22608j();
            int size = j.size();
            for (int i = 0; i < size; i++) {
                graphQLStory = m27433a((GraphQLStory) j.get(i), str);
                if (graphQLStory != null) {
                    return graphQLStory;
                }
            }
        }
        return null;
    }

    public static boolean m27438e(GraphQLStory graphQLStory) {
        return graphQLStory.m22326L() != null && graphQLStory.mo2890l() == null && !PropertyHelper.m21261a((Object) graphQLStory).f14864m && graphQLStory.aD() <= 0;
    }
}
