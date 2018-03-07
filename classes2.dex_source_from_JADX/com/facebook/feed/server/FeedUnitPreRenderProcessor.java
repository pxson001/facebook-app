package com.facebook.feed.server;

import com.facebook.api.feed.FeedFetchContext;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.OrganicImpression;
import com.facebook.graphql.model.StorySetHelper;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: secondary_subscribe_status */
public class FeedUnitPreRenderProcessor {
    public static FeedUnitPreRenderProcessor m9989a(InjectorLike injectorLike) {
        return new FeedUnitPreRenderProcessor();
    }

    public final void m9990a(@Nullable FeedUnit feedUnit, FeedFetchContext feedFetchContext) {
        if (feedUnit instanceof GraphQLStory) {
            OrganicImpression a = OrganicImpression.m27468a((GraphQLStory) feedUnit);
            if (a != null) {
                a.m27473l();
            }
        } else if (feedUnit instanceof GraphQLStorySet) {
            ImmutableList b = StorySetHelper.b((GraphQLStorySet) feedUnit);
            int size = b.size();
            for (int i = 0; i < size; i++) {
                m9990a((GraphQLStory) b.get(i), feedFetchContext);
            }
        }
    }
}
