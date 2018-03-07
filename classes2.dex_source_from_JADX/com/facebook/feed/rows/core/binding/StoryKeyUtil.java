package com.facebook.feed.rows.core.binding;

import com.facebook.graphql.model.GraphQLStory;
import javax.annotation.Nonnull;

/* compiled from: header. */
public class StoryKeyUtil {
    @Nonnull
    public static String m28909a(@Nonnull GraphQLStory graphQLStory) {
        return graphQLStory.mo2507g() != null ? graphQLStory.mo2507g() : graphQLStory.m22336V();
    }
}
