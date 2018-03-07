package com.facebook.feed.util.event;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: policyName */
public class StoryEvents$PermalinkClickedEvent extends FeedEvent {
    public final String f13911a;
    public final String f13912b;

    public StoryEvents$PermalinkClickedEvent(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory d = StoryProps.m27457d(feedProps);
        this.f13912b = d != null ? d.mo2507g() : null;
        this.f13911a = ((GraphQLStory) feedProps.f13444a).mo2507g();
    }
}
