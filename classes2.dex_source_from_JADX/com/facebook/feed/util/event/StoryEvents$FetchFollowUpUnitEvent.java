package com.facebook.feed.util.event;

import com.facebook.graphql.enums.GraphQLFollowUpFeedUnitActionType;

/* compiled from: policyName */
public class StoryEvents$FetchFollowUpUnitEvent extends FeedEvent {
    public final String f14045a;
    public final GraphQLFollowUpFeedUnitActionType f14046b;

    public StoryEvents$FetchFollowUpUnitEvent(String str, GraphQLFollowUpFeedUnitActionType graphQLFollowUpFeedUnitActionType) {
        this.f14045a = str;
        this.f14046b = graphQLFollowUpFeedUnitActionType;
    }
}
