package com.facebook.feed.util.event;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: pigeon_beacon */
public class HideEvents$StoryDeleteEvent extends FeedEvent {
    public final FeedProps<GraphQLStory> f14027a;

    public HideEvents$StoryDeleteEvent(FeedProps<GraphQLStory> feedProps) {
        this.f14027a = feedProps;
    }

    public final String m20348a() {
        GraphQLStory graphQLStory = (GraphQLStory) this.f14027a.f13444a;
        return graphQLStory == null ? null : graphQLStory.mo2507g();
    }

    public final String m20349b() {
        GraphQLStory graphQLStory = (GraphQLStory) this.f14027a.f13444a;
        return graphQLStory == null ? null : graphQLStory.ai();
    }
}
