package com.facebook.graphql.model;

import com.google.common.base.Strings;

/* compiled from: friending_remove_friend_list_member */
public class StoryTextHelper {
    private StoryTextHelper() {
    }

    public static String m31226a(GraphQLStory graphQLStory) {
        GraphQLTextWithEntities b = StoryHierarchyHelper.m27435b(graphQLStory);
        return b != null ? Strings.nullToEmpty(b.mo2911a()) : "";
    }
}
