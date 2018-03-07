package com.facebook.feedplugins.multishare;

import com.facebook.feed.autoplay.AutoplayStateManagerProvider;
import com.facebook.feed.rows.core.binding.StoryKeyUtil;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.video.InlineVideoPersistentState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLVideo;

/* compiled from: conncls_bandwidth_qual */
public class MultiShareVideoStoryKey implements ContextStateKey<String, InlineVideoPersistentState> {
    private final String f8024a;
    private final int f8025b;
    private final FeedProps<GraphQLStory> f8026c;
    private final GraphQLVideo f8027d;
    private final AutoplayStateManagerProvider f8028e;

    public MultiShareVideoStoryKey(FeedProps<GraphQLStory> feedProps, GraphQLVideo graphQLVideo, int i, AutoplayStateManagerProvider autoplayStateManagerProvider) {
        this.f8024a = getClass() + StoryKeyUtil.a((GraphQLStory) feedProps.a) + i;
        this.f8025b = i;
        this.f8026c = feedProps;
        this.f8027d = graphQLVideo;
        this.f8028e = autoplayStateManagerProvider;
    }

    public final Object m9086b() {
        return this.f8024a;
    }

    public final Object m9085a() {
        InlineVideoPersistentState inlineVideoPersistentState = new InlineVideoPersistentState();
        inlineVideoPersistentState.f = this.f8028e.a(this.f8026c, this.f8027d, Integer.valueOf(this.f8025b - 1));
        return inlineVideoPersistentState;
    }
}
