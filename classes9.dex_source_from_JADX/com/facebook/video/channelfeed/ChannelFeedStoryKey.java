package com.facebook.video.channelfeed;

import com.facebook.feed.autoplay.AutoplayStateManagerProvider;
import com.facebook.feed.rows.core.binding.StoryKeyUtil;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.inject.Assisted;
import com.facebook.video.analytics.VideoChannelSessionManager;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: survey_choice */
public class ChannelFeedStoryKey implements ContextStateKey<String, ChannelFeedStoryPersistentState> {
    private final String f2490a;
    private final FeedProps<GraphQLStory> f2491b;
    private final GraphQLVideo f2492c;
    private final AutoplayStateManagerProvider f2493d;
    private final ChannelFeedVideoControllerProvider f2494e;
    private final ChannelFeedDimmingControllerProvider f2495f;

    @Inject
    public ChannelFeedStoryKey(@Assisted FeedProps<GraphQLStory> feedProps, @Assisted GraphQLVideo graphQLVideo, AutoplayStateManagerProvider autoplayStateManagerProvider, ChannelFeedVideoControllerProvider channelFeedVideoControllerProvider, ChannelFeedDimmingControllerProvider channelFeedDimmingControllerProvider) {
        String str;
        Preconditions.checkNotNull(feedProps);
        Preconditions.checkNotNull(graphQLVideo);
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        String str2 = getClass() + StoryKeyUtil.a(graphQLStory);
        if (MultiShareNoLinkUtil.b(graphQLStory)) {
            str = str2 + graphQLVideo.J();
        } else {
            str = str2;
        }
        this.f2490a = str;
        this.f2491b = feedProps;
        this.f2492c = graphQLVideo;
        this.f2493d = autoplayStateManagerProvider;
        this.f2494e = channelFeedVideoControllerProvider;
        this.f2495f = channelFeedDimmingControllerProvider;
    }

    public final Object m2424b() {
        return this.f2490a;
    }

    public final Object m2423a() {
        ChannelFeedStoryPersistentState channelFeedStoryPersistentState = new ChannelFeedStoryPersistentState();
        channelFeedStoryPersistentState.f2499a = this.f2493d.a(StoryProps.j(this.f2491b), this.f2492c, Integer.valueOf(-1));
        channelFeedStoryPersistentState.f2500b = new ChannelFeedVideoController(this.f2492c.J(), channelFeedStoryPersistentState, VideoChannelSessionManager.a(this.f2494e));
        channelFeedStoryPersistentState.f2501c = this.f2495f.m2138a(this.f2492c.J(), 0.08f);
        return channelFeedStoryPersistentState;
    }
}
