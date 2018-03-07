package com.facebook.feed.util.event;

import com.facebook.graphql.model.GraphQLStory;

/* compiled from: policyName */
public class StoryEvents$PaginatedSeeMoreAggregatedStoryEvent extends FeedEvent {
    public final GraphQLStory f13916a;
    public final int f13917b;

    public StoryEvents$PaginatedSeeMoreAggregatedStoryEvent(GraphQLStory graphQLStory, int i) {
        this.f13916a = graphQLStory;
        this.f13917b = i;
    }
}
