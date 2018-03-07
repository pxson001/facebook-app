package com.facebook.graphql.model;

import com.facebook.graphql.model.interfaces.FeedUnitCommon;
import com.google.common.collect.ImmutableList;

/* compiled from: mContainer= */
public class FetchTimeMsHelper {
    private FetchTimeMsHelper() {
    }

    public static void m22314a(FeedUnitCommon feedUnitCommon, long j) {
        if (feedUnitCommon instanceof GraphQLStory) {
            m22313a((GraphQLStory) feedUnitCommon, j);
        } else {
            feedUnitCommon.mo2872a(j);
        }
    }

    public static void m22313a(GraphQLStory graphQLStory, long j) {
        graphQLStory.mo2872a(j);
        if (graphQLStory.m22326L() != null) {
            m22313a(graphQLStory.m22326L(), j);
        }
        GraphQLSubstoriesConnection a = StoryHierarchyHelper.m27434a(graphQLStory);
        if (a != null) {
            ImmutableList j2 = a.m22608j();
            int size = j2.size();
            for (int i = 0; i < size; i++) {
                m22313a((GraphQLStory) j2.get(i), j);
            }
        }
    }
}
