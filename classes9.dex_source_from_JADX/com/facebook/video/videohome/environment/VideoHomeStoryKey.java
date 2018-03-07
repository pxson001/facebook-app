package com.facebook.video.videohome.environment;

import com.facebook.feed.autoplay.AutoplayStateManagerProvider;
import com.facebook.feed.rows.core.binding.StoryKeyUtil;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.inject.Assisted;
import com.facebook.video.channelfeed.ChannelFeedDimmingControllerProvider;
import javax.inject.Inject;

/* compiled from: startUsingNetworkFeature */
public class VideoHomeStoryKey implements ContextStateKey<String, VideoHomeStoryPersistentState> {
    private static final String f2881a = VideoHomeStoryKey.class.getName();
    private final FeedProps<GraphQLStory> f2882b;
    private final GraphQLVideo f2883c;
    private final AutoplayStateManagerProvider f2884d;
    private final ChannelFeedDimmingControllerProvider f2885e;
    private final String f2886f;

    @Inject
    public VideoHomeStoryKey(@Assisted FeedProps<GraphQLStory> feedProps, @Assisted GraphQLVideo graphQLVideo, @Assisted String str, AutoplayStateManagerProvider autoplayStateManagerProvider, ChannelFeedDimmingControllerProvider channelFeedDimmingControllerProvider) {
        this.f2882b = feedProps;
        this.f2883c = graphQLVideo;
        this.f2886f = f2881a + StoryKeyUtil.a((GraphQLStory) feedProps.a) + ":" + str;
        this.f2884d = autoplayStateManagerProvider;
        this.f2885e = channelFeedDimmingControllerProvider;
    }

    public final Object m2789a() {
        VideoHomeStoryPersistentState videoHomeStoryPersistentState = new VideoHomeStoryPersistentState();
        videoHomeStoryPersistentState.f2887a = this.f2884d.a(this.f2882b, this.f2883c, Integer.valueOf(-1));
        videoHomeStoryPersistentState.f2887a.w = true;
        videoHomeStoryPersistentState.f2889c = this.f2885e.m2138a(this.f2883c.J(), 0.2f);
        return videoHomeStoryPersistentState;
    }

    public final Object m2790b() {
        return this.f2886f;
    }
}
