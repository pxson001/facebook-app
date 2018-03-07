package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLBoostedPostStatus;

/* compiled from: growth_friend_finder_pymk */
public class StorySponsoredHelper {
    public static GraphQLBoostedPostStatus m29214a(GraphQLStory graphQLStory) {
        if (graphQLStory.ap() == null || graphQLStory.ap().m24707s() == null) {
            return GraphQLBoostedPostStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        return graphQLStory.ap().m24707s();
    }
}
