package com.facebook.video.channelfeed;

import com.facebook.attachments.videos.ui.HasChannelFeedLauncherInfo;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.video.FullScreenVideoPlayerHost;
import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.Assisted;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.channelfeed.ChannelFeedParams.Builder;
import com.facebook.video.channelfeed.abtest.ChannelFeedConfig;
import com.facebook.video.engine.ExitFullScreenResult;
import com.facebook.video.player.FullScreenVideoListener;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerCallbackListener;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.VideoTransitionNode;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager;
import com.google.common.base.Preconditions;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: success_update_email */
public class InlineToChannelFeedTransitionManager {
    private final FullScreenVideoPlayerHost f2608a;
    private final ChannelFeedConfig f2609b;
    private final VideoHomeSessionManager f2610c;
    private ChannelFeedParams f2611d;
    public VideoTransitionNode f2612e;
    public RichVideoPlayer f2613f;
    public List<RichVideoPlayerPlugin> f2614g;
    public RichVideoPlayerCallbackListener f2615h;
    public RichVideoPlayerParams f2616i;
    @Nullable
    public String f2617j;
    public boolean f2618k;

    /* compiled from: success_update_email */
    class ChannelFeedExitListener implements FullscreenTransitionListener, FullScreenVideoListener {
        private final AtomicReference<FullscreenTransitionListener> f2607a;

        public ChannelFeedExitListener(AtomicReference<FullscreenTransitionListener> atomicReference) {
            this.f2607a = atomicReference;
        }

        public final void m2521a(EventTriggerType eventTriggerType) {
        }

        public final void m2522a(EventTriggerType eventTriggerType, ExitFullScreenResult exitFullScreenResult) {
            m2523a(exitFullScreenResult);
        }

        public final void m2523a(ExitFullScreenResult exitFullScreenResult) {
            FullscreenTransitionListener fullscreenTransitionListener = (FullscreenTransitionListener) this.f2607a.get();
            if (fullscreenTransitionListener != null) {
                fullscreenTransitionListener.a(exitFullScreenResult);
            }
        }
    }

    @Inject
    public InlineToChannelFeedTransitionManager(@Assisted FullScreenVideoPlayerHost fullScreenVideoPlayerHost, @Assisted ChannelFeedParams channelFeedParams, ChannelFeedConfig channelFeedConfig, VideoHomeSessionManager videoHomeSessionManager) {
        this.f2608a = fullScreenVideoPlayerHost;
        this.f2611d = channelFeedParams;
        this.f2609b = channelFeedConfig;
        this.f2610c = videoHomeSessionManager;
    }

    public final void m2524a(@Nullable HasChannelFeedLauncherInfo hasChannelFeedLauncherInfo, AtomicReference<FullscreenTransitionListener> atomicReference) {
        Object obj;
        boolean z;
        String str;
        VideoTransitionNode transitionNode;
        InlineToChannelFeedTransitionManager inlineToChannelFeedTransitionManager = null;
        Object obj2 = 1;
        if (this.f2610c.g() && !this.f2610c.i()) {
            this.f2610c.b();
        }
        if (hasChannelFeedLauncherInfo != null) {
            Builder a = Builder.a(this.f2611d);
            a.f = hasChannelFeedLauncherInfo.getLastStartPosition();
            a = a;
            a.e = hasChannelFeedLauncherInfo.getSeekPosition();
            this.f2611d = a.a();
        }
        if (this.f2611d.a == null || this.f2611d.a.a == null) {
            obj = null;
        } else {
            obj = 1;
        }
        Object obj3;
        if (this.f2611d.c == null || this.f2611d.c.isEmpty()) {
            obj3 = null;
        } else {
            obj3 = 1;
        }
        if (obj == null && r3 == null) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkState(z, "Either storyProps or videoChannelIds must be provided");
        if (obj != null) {
            String str2;
            FeedProps feedProps = this.f2611d.a;
            if (feedProps == null) {
                str2 = null;
            } else {
                GraphQLStoryAttachment o = StoryAttachmentHelper.o((GraphQLStory) StoryProps.j(feedProps).a);
                str2 = (o == null || o.r() == null) ? null : o.r().b();
            }
            str = str2;
        } else {
            str = null;
        }
        this.f2617j = str;
        ChannelFeedRootView channelFeedRootView = (ChannelFeedRootView) this.f2608a.l();
        Preconditions.checkNotNull(channelFeedRootView);
        channelFeedRootView.m2401a(new ChannelFeedExitListener(atomicReference));
        if (hasChannelFeedLauncherInfo != null) {
            transitionNode = hasChannelFeedLauncherInfo.getTransitionNode();
        } else {
            transitionNode = null;
        }
        if (!this.f2609b.g || transitionNode == null || transitionNode.getRichVideoPlayer() == null || transitionNode.getRichVideoPlayer().t == null) {
            obj2 = null;
        }
        if (obj2 != null) {
            this.f2612e = transitionNode;
            this.f2613f = transitionNode.i();
            this.f2616i = this.f2613f.t;
            this.f2614g = this.f2613f.k();
            this.f2615h = this.f2613f.v;
            this.f2618k = false;
        }
        Builder a2 = Builder.a(this.f2611d);
        if (obj2 != null) {
            inlineToChannelFeedTransitionManager = this;
        }
        a2.i = inlineToChannelFeedTransitionManager;
        this.f2611d = a2.a();
        channelFeedRootView.m2403a(this.f2611d);
    }
}
