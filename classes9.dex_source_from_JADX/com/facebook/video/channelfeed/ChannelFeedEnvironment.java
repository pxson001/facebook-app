package com.facebook.video.channelfeed;

import android.content.Context;
import android.view.View;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.feed.autoplay.CenteredVideoAutoplayManager;
import com.facebook.feed.autoplay.HasVideoAutoplay;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.ui.VideoFeedStoryMenuHelperProvider;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.Assisted;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.player.RichVideoPlayerParams;
import com.google.common.base.Function;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: task_key_fetch_ride_type */
public class ChannelFeedEnvironment extends BaseFeedEnvironment implements HasVideoAutoplay<ChannelFeedVideoAttachmentView>, CanShowVideoInFullScreen, FeedEnvironment, CanReusePlayer, HasFullscreenPlayer {
    private final FeedListType f2133m;
    private final BaseFeedStoryMenuHelper f2134n;
    private final CenteredVideoAutoplayManager<ChannelFeedVideoAttachmentView> f2135o;
    @Nullable
    public PlayerOrigin f2136p;
    @Nullable
    public Function<RichVideoPlayerParams, Void> f2137q;
    @Nullable
    public ChannelFeedFullscreenManager f2138r;
    @Nullable
    public InlineToChannelFeedTransitionManager f2139s;
    public boolean f2140t;
    @Nullable
    public Function<String, Void> f2141u;

    public final void m2142b(View view, VideoViewController videoViewController) {
        this.f2135o.a((ChannelFeedVideoAttachmentView) view, videoViewController);
    }

    @Inject
    public ChannelFeedEnvironment(@Assisted Context context, @Assisted FeedListType feedListType, @Assisted Runnable runnable, CenteredVideoAutoplayManager centeredVideoAutoplayManager, VideoFeedStoryMenuHelperProvider videoFeedStoryMenuHelperProvider) {
        super(context, runnable, HasScrollListenerSupportImpl.b);
        this.f2133m = feedListType;
        this.f2135o = centeredVideoAutoplayManager;
        this.f2134n = videoFeedStoryMenuHelperProvider.a(this, NegativeFeedbackExperienceLocation.VIDEO_CHANNEL, "video_channel_feed");
    }

    public final BaseFeedStoryMenuHelper m2146e() {
        return this.f2134n;
    }

    public final BaseFeedStoryMenuHelper m2147l() {
        return m2146e();
    }

    public final FeedListType m2144c() {
        return this.f2133m;
    }

    public final void m2141a(GraphQLStoryAttachment graphQLStoryAttachment, View view) {
    }

    public final void m2140a(GraphQLStoryAttachment graphQLStoryAttachment) {
    }

    public final void m2143b(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (this.f2138r != null) {
            this.f2138r.m2206a();
        }
    }

    public final boolean m2145c(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment != null) {
            Object obj = (GraphQLStoryAttachmentUtil.d(graphQLStoryAttachment) && graphQLStoryAttachment.r() != null && graphQLStoryAttachment.r().al()) ? 1 : null;
            if (obj != null) {
                return true;
            }
        }
        return false;
    }
}
