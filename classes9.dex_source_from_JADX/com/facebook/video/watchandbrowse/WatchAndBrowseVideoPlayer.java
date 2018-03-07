package com.facebook.video.watchandbrowse;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.feed.ui.fullscreenvideoplayer.WatchAndBrowseRichVideoPlayerPluginSelector;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.FullScreenNetworkErrorBannerPlugin;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.WatchAndBrowseFullscreenVideoControlsPlugin;
import com.facebook.feed.ui.inlinevideoplayer.plugins.VideoBroadcastPlugin;
import com.facebook.feedplugins.attachments.video.VideoSizer;
import com.facebook.feedplugins.attachments.video.VideoSizer.VideoSize;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.FbInjector;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.engine.VideoResolution;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.VideoTransitionNode;
import com.facebook.video.player.environment.CanOpenFullscreen;
import com.facebook.video.player.plugins.ClickToPlayAnimationPlugin;
import com.facebook.video.player.plugins.CoverImagePlugin;
import com.facebook.video.player.plugins.LoadingSpinnerPlugin;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.player.plugins.SubtitlePlugin;
import com.facebook.video.player.plugins.Video360Plugin;
import com.facebook.video.player.plugins.VideoPlugin;
import com.facebook.video.watchandbrowse.VideoWatchAndBrowseRootView.C03121;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: should_show_pay_button */
public class WatchAndBrowseVideoPlayer extends CustomFrameLayout implements VideoTransitionNode {
    @Inject
    public VideoSizer f3434a;
    @Inject
    public WatchAndBrowseRichVideoPlayerPluginSelector f3435b;
    private final RichVideoPlayer f3436c;
    private final WatchAndBrowseVideoEnvironment f3437d;
    public RichVideoPlayer f3438e;
    public RichVideoPlayerParams f3439f;
    private GraphQLStoryAttachment f3440g;
    public Function<RichVideoPlayerParams, Void> f3441h;
    public VideoSize f3442i;

    /* compiled from: should_show_pay_button */
    class WatchAndBrowseVideoEnvironment implements CanOpenFullscreen {
        final /* synthetic */ WatchAndBrowseVideoPlayer f3433a;

        public WatchAndBrowseVideoEnvironment(WatchAndBrowseVideoPlayer watchAndBrowseVideoPlayer) {
            this.f3433a = watchAndBrowseVideoPlayer;
        }

        public final Function<RichVideoPlayerParams, Void> m3255a() {
            return this.f3433a.f3441h;
        }
    }

    public static void m3256a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        WatchAndBrowseVideoPlayer watchAndBrowseVideoPlayer = (WatchAndBrowseVideoPlayer) obj;
        VideoSizer a = VideoSizer.a(fbInjector);
        WatchAndBrowseRichVideoPlayerPluginSelector b = WatchAndBrowseRichVideoPlayerPluginSelector.b(fbInjector);
        watchAndBrowseVideoPlayer.f3434a = a;
        watchAndBrowseVideoPlayer.f3435b = b;
    }

    public WatchAndBrowseVideoPlayer(Context context) {
        this(context, null);
    }

    private WatchAndBrowseVideoPlayer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private WatchAndBrowseVideoPlayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3437d = new WatchAndBrowseVideoEnvironment(this);
        Class cls = WatchAndBrowseVideoPlayer.class;
        m3256a((Object) this, getContext());
        setContentView(2130907764);
        this.f3438e = (RichVideoPlayer) c(2131560290);
        this.f3438e.setPlayerType(getPlayerType());
        this.f3438e.a(new VideoPlugin(context));
        this.f3436c = this.f3438e;
        ImmutableList additionalPlugins = getAdditionalPlugins();
        int size = additionalPlugins.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f3438e.a((RichVideoPlayerPlugin) additionalPlugins.get(i2));
        }
    }

    public RichVideoPlayer getRichVideoPlayer() {
        return this.f3438e;
    }

    public final void m3258a(RichVideoPlayer richVideoPlayer) {
        this.f3436c.setVisibility(8);
        this.f3438e = richVideoPlayer;
        attachRecyclableViewToParent(richVideoPlayer, 0, richVideoPlayer.getLayoutParams());
    }

    public final RichVideoPlayer m3260i() {
        if (this.f3438e.getParent() == this) {
            detachRecyclableViewFromParent(this.f3438e);
        }
        return this.f3438e;
    }

    public final RichVideoPlayer m3261j() {
        return this.f3436c;
    }

    public PlayerType getPlayerType() {
        return PlayerType.FULL_SCREEN_PLAYER;
    }

    public ImmutableList<RichVideoPlayerPlugin> getAdditionalPlugins() {
        return new Builder().c(new CoverImagePlugin(getContext())).c(new LoadingSpinnerPlugin(getContext())).c(new SubtitlePlugin(getContext())).c(new VideoBroadcastPlugin(getContext())).c(new FullScreenNetworkErrorBannerPlugin(getContext())).c(new ClickToPlayAnimationPlugin(getContext())).c(new WatchAndBrowseFullscreenVideoControlsPlugin(getContext())).b();
    }

    public final void m3259a(RichVideoPlayerParams richVideoPlayerParams, GraphQLStoryAttachment graphQLStoryAttachment) {
        boolean z = (richVideoPlayerParams == null || graphQLStoryAttachment == null || graphQLStoryAttachment.r() == null || graphQLStoryAttachment.r().j() == null || graphQLStoryAttachment.r().j().g() != 82650203) ? false : true;
        Preconditions.checkArgument(z);
        this.f3440g = graphQLStoryAttachment;
        this.f3439f = richVideoPlayerParams;
        setupPlayerLayout(graphQLStoryAttachment);
        this.f3438e.a(richVideoPlayerParams);
    }

    public final void m3257a(int i, VideoResolution videoResolution) {
        if (this.f3439f != null) {
            this.f3435b.a(this.f3438e, this.f3439f, null);
            setupPlayerLayout(this.f3440g);
            setupFullscreenButtonClickHandler(this.f3441h);
            this.f3438e.a(this.f3439f);
            if (this.f3439f.a.s != null) {
                Video360Plugin video360Plugin = (Video360Plugin) this.f3438e.a(Video360Plugin.class);
                if (video360Plugin != null) {
                    video360Plugin.f();
                }
            }
            this.f3438e.a(false, EventTriggerType.BY_USER);
            this.f3438e.a(videoResolution, EventTriggerType.BY_USER);
            this.f3438e.a(i, EventTriggerType.BY_USER);
            this.f3438e.a(EventTriggerType.BY_USER);
        }
    }

    public void setupFullscreenButtonClickHandler(Function<RichVideoPlayerParams, Void> function) {
        if (function != null) {
            this.f3441h = function;
            WatchAndBrowseFullscreenVideoControlsPlugin watchAndBrowseFullscreenVideoControlsPlugin = (WatchAndBrowseFullscreenVideoControlsPlugin) this.f3438e.a(WatchAndBrowseFullscreenVideoControlsPlugin.class);
            if (watchAndBrowseFullscreenVideoControlsPlugin != null) {
                watchAndBrowseFullscreenVideoControlsPlugin.setEnvironment(this.f3437d);
            }
        }
    }

    public void setupDismissPlayerButton(C03121 c03121) {
        WatchAndBrowseFullscreenVideoControlsPlugin watchAndBrowseFullscreenVideoControlsPlugin = (WatchAndBrowseFullscreenVideoControlsPlugin) this.f3438e.a(WatchAndBrowseFullscreenVideoControlsPlugin.class);
        if (watchAndBrowseFullscreenVideoControlsPlugin != null) {
            watchAndBrowseFullscreenVideoControlsPlugin.p = c03121;
        }
    }

    private void setupPlayerLayout(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment != null) {
            this.f3442i = this.f3434a.a(graphQLStoryAttachment, 0.0f);
            this.f3438e.setLayoutParams(new LayoutParams(this.f3442i.a, this.f3442i.b));
        }
    }
}
