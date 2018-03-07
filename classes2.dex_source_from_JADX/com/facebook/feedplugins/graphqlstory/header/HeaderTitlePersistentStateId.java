package com.facebook.feedplugins.graphqlstory.header;

import com.facebook.graphql.model.GraphQLStory;

/* compiled from: group */
public final class HeaderTitlePersistentStateId {
    public static String m29525a(GraphQLStory graphQLStory) {
        String str = "story:header:title:" + m29526b(graphQLStory);
        if (graphQLStory.aH() == null || graphQLStory.aH().mo2911a() == null) {
            return str;
        }
        return str + ":" + graphQLStory.aH().mo2911a();
    }

    public static String m29526b(GraphQLStory graphQLStory) {
        return graphQLStory.mo2507g() != null ? graphQLStory.mo2507g() : String.valueOf(graphQLStory.m22336V());
    }
}
