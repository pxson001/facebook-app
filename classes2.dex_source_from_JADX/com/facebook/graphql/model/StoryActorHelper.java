package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.google.common.collect.ImmutableList;

/* compiled from: instant_article_html_native_ad */
public class StoryActorHelper {
    private StoryActorHelper() {
    }

    public static boolean m27491a(GraphQLStory graphQLStory) {
        GraphQLActor b = m27492b(graphQLStory);
        if (b == null) {
            return false;
        }
        GraphQLObjectType b2 = b.m23790b();
        if (b2 == null || b2.m22301g() != 2479791) {
            return false;
        }
        return true;
    }

    public static GraphQLActor m27492b(GraphQLStory graphQLStory) {
        ImmutableList b = graphQLStory.m22349b();
        return (b == null || b.size() <= 0) ? null : (GraphQLActor) b.get(0);
    }
}
