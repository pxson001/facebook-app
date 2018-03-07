package com.facebook.feed.video;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.ExternalLogType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.analytics.VideoAnalyticsRequiredInfo;
import com.facebook.video.analytics.VideoFeedStoryInfo;
import com.facebook.video.analytics.VideoPlaybackAnalyticsParams;
import com.facebook.video.analytics.VideoPlayerInfo;
import com.facebook.video.analytics.VideoTimeSpentInfo;
import com.facebook.video.player.VideoTransitionNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;

/* compiled from: photoQuality */
public class FeedFullScreenParams implements VideoPlaybackAnalyticsParams {
    public final GraphQLVideo f4943a;
    public final FeedProps<GraphQLStoryAttachment> f4944b;
    private final VideoTimeSpentInfo f4945c;
    public final VideoPlayerInfo f4946d;
    @Nullable
    public final ExternalLogType f4947e;
    @Nullable
    public final String f4948f;
    @Nullable
    public ImmutableMap f4949g;
    public VideoTransitionNode f4950h;
    private ImageRequest f4951i;
    public EventTriggerType f4952j;
    public boolean f4953k;
    public VideoFeedStoryInfo f4954l;
    private VideoAnalyticsRequiredInfo f4955m;

    public FeedFullScreenParams(VideoAnalyticsRequiredInfo videoAnalyticsRequiredInfo, VideoFeedStoryInfo videoFeedStoryInfo, ImageRequest imageRequest, GraphQLVideo graphQLVideo, FeedProps<GraphQLStoryAttachment> feedProps) {
        this(videoAnalyticsRequiredInfo, videoFeedStoryInfo, imageRequest, graphQLVideo, feedProps, null, null);
    }

    public FeedFullScreenParams(VideoAnalyticsRequiredInfo videoAnalyticsRequiredInfo, VideoFeedStoryInfo videoFeedStoryInfo, ImageRequest imageRequest, GraphQLVideo graphQLVideo, FeedProps<GraphQLStoryAttachment> feedProps, ExternalLogType externalLogType, String str) {
        this.f4945c = new VideoTimeSpentInfo();
        this.f4946d = new VideoPlayerInfo(PlayerType.FULL_SCREEN_PLAYER);
        this.f4952j = EventTriggerType.BY_USER;
        this.f4954l = new VideoFeedStoryInfo();
        this.f4955m = new VideoAnalyticsRequiredInfo();
        this.f4943a = graphQLVideo;
        this.f4944b = feedProps;
        this.f4955m = videoAnalyticsRequiredInfo;
        this.f4954l = videoFeedStoryInfo;
        this.f4951i = imageRequest;
        this.f4954l.b = videoFeedStoryInfo.b;
        this.f4947e = externalLogType;
        this.f4948f = str;
    }

    public final GraphQLVideo m5333d() {
        return this.f4943a;
    }

    public final FeedProps<GraphQLStoryAttachment> m5334e() {
        return this.f4944b;
    }

    @Nullable
    public final ImmutableMap m5335f() {
        return this.f4949g;
    }

    public final VideoTransitionNode m5336g() {
        return this.f4950h;
    }

    public final ImageRequest m5337h() {
        return this.f4951i;
    }

    public final EventTriggerType m5338i() {
        return this.f4954l.b;
    }

    public final int m5339j() {
        return this.f4945c.c;
    }

    public final PlayerOrigin m5340k() {
        return this.f4946d.b;
    }

    public final FeedFullScreenParams m5327a(int i) {
        this.f4945c.c = i;
        return this;
    }

    public final FeedFullScreenParams m5328a(PlayerOrigin playerOrigin) {
        this.f4946d.b = playerOrigin;
        return this;
    }

    public final ArrayNode m5341m() {
        return this.f4954l.a;
    }

    public final FeedFullScreenParams m5330b(int i) {
        this.f4945c.b = i;
        return this;
    }

    public final boolean m5342o() {
        return this.f4954l.d;
    }

    public final int m5343p() {
        return this.f4945c.b;
    }

    public final boolean m5344q() {
        return this.f4953k;
    }

    public final String m5345r() {
        return this.f4955m.a;
    }

    public final String m5346u() {
        return this.f4948f;
    }

    public final boolean m5329a() {
        return this.f4943a != null && this.f4943a.ae();
    }

    public final String m5332c() {
        return (this.f4943a == null || !this.f4943a.ai()) ? "" : "CUBEMAP";
    }

    public final boolean m5331b() {
        return this.f4943a != null && this.f4943a.aj();
    }
}
