package com.facebook.feed.rows.events;

import com.facebook.feed.rows.core.events.StoryPropsEvent;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: messenger_install_time_ms */
public class LikeClicked extends StoryPropsEvent {
    public LikeClicked(FeedProps<GraphQLStory> feedProps, String str) {
        super(feedProps, str);
    }
}
