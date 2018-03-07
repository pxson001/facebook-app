package com.facebook.feed.rows.core.events;

import com.facebook.feed.rows.core.binding.StoryKeyUtil;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: messenger_install_time */
public abstract class StoryPropsEvent implements KeyedEvent<String> {
    public final FeedProps<GraphQLStory> f13907a;
    private final String f13908b;
    public final String f13909c;

    public StoryPropsEvent(FeedProps<GraphQLStory> feedProps, String str) {
        this.f13907a = feedProps;
        this.f13908b = StoryKeyUtil.m28909a((GraphQLStory) feedProps.f13444a);
        this.f13909c = str;
    }

    public final Object mo1976c() {
        return this.f13908b;
    }
}
