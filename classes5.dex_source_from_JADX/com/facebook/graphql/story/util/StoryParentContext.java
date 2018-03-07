package com.facebook.graphql.story.util;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.fasterxml.jackson.databind.node.ArrayNode;

/* compiled from: TRIGHT;>; */
public class StoryParentContext {
    public boolean f13511a;
    public ArrayNode f13512b;

    private StoryParentContext(boolean z, ArrayNode arrayNode) {
        this.f13511a = z;
        this.f13512b = arrayNode;
    }

    public static StoryParentContext m22710a(FeedProps<GraphQLStory> feedProps) {
        return new StoryParentContext(StoryProps.p(feedProps), TrackableFeedProps.a(feedProps));
    }
}
