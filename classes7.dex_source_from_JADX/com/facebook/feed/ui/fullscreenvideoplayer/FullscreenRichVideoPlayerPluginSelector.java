package com.facebook.feed.ui.fullscreenvideoplayer;

import android.content.Context;
import android.view.ContextThemeWrapper;
import com.facebook.facecastdisplay.FacecastUiUtil;
import com.facebook.facecastdisplay.FacecastUtil;
import com.facebook.facecastdisplay.LiveEventsPlugin;
import com.facebook.facecastdisplay.tipjar.LiveTipJarPlugin;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.FeedFullscreenVideoControlsPlugin;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.FeedbackWithViewsAndCountPlugin;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.FullScreenCastPlugin;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.FullScreenNetworkErrorBannerPlugin;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.FullscreenCallToActionButtonPlugin;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.FullscreenCallToActionEndscreenPlugin;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.PreviouslyLiveVideoBroadcastControlsPlugin;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.StreamingReactionsPlugin;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.Video360ControlsPlugin;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.VideoBroadcastEndScreenPlugin;
import com.facebook.feed.ui.inlinevideoplayer.plugins.FullScreenLiveVideoStatusPlugin;
import com.facebook.feed.ui.inlinevideoplayer.plugins.FullScreenVideoBroadcastPlugin;
import com.facebook.feed.ui.inlinevideoplayer.plugins.VideoBroadcastPlugin;
import com.facebook.feed.video.util.RichVideoPlayerPluginSelector;
import com.facebook.feed.video.util.RichVideoPlayerPluginSelector.RichVideoPlayerPluginType;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.video.abtest.Video360PlayerConfig;
import com.facebook.video.abtest.VideoAbTestGatekeepers;
import com.facebook.video.commercialbreak.abtest.CommercialBreakConfig;
import com.facebook.video.commercialbreak.plugins.CommercialBreakPlugin;
import com.facebook.video.commercialbreak.plugins.CommercialBreakTransitionPlugin;
import com.facebook.video.commercialbreak.plugins.CommercialBreakVideoPluginNew;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.plugins.ClickToPlayAnimationPlugin;
import com.facebook.video.player.plugins.ClickToPlayNoPausePlugin;
import com.facebook.video.player.plugins.CommercialBreakVideoPlugin;
import com.facebook.video.player.plugins.CoverImagePlugin;
import com.facebook.video.player.plugins.LiveVideoControlsPlugin;
import com.facebook.video.player.plugins.LoadingSpinnerPlugin;
import com.facebook.video.player.plugins.OverflowMenuPlugin;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.player.plugins.SubtitlePlugin;
import com.facebook.video.player.plugins.Video360FullScreenPlugin;
import com.facebook.video.player.plugins.Video360HeadingPlugin;
import com.facebook.video.player.plugins.VideoPlugin;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: ToastAndroid */
public class FullscreenRichVideoPlayerPluginSelector extends RichVideoPlayerPluginSelector {
    private final GatekeeperStoreImpl f21943j;

    @Inject
    public FullscreenRichVideoPlayerPluginSelector(Context context, Video360PlayerConfig video360PlayerConfig, GatekeeperStoreImpl gatekeeperStoreImpl, FacecastUtil facecastUtil, Boolean bool, CommercialBreakConfig commercialBreakConfig) {
        Object fullScreenLiveVideoStatusPlugin;
        VideoPlugin videoPlugin = new VideoPlugin(context);
        SubtitlePlugin subtitlePlugin = new SubtitlePlugin(context);
        LiveEventsPlugin liveEventsPlugin = new LiveEventsPlugin(new ContextThemeWrapper(context, FacecastUiUtil.m3097a()));
        LoadingSpinnerPlugin loadingSpinnerPlugin = new LoadingSpinnerPlugin(context);
        FullscreenCallToActionButtonPlugin fullscreenCallToActionButtonPlugin = new FullscreenCallToActionButtonPlugin(context);
        FullscreenCallToActionEndscreenPlugin fullscreenCallToActionEndscreenPlugin = new FullscreenCallToActionEndscreenPlugin(context);
        StreamingReactionsPlugin streamingReactionsPlugin = new StreamingReactionsPlugin(context);
        FullScreenNetworkErrorBannerPlugin fullScreenNetworkErrorBannerPlugin = new FullScreenNetworkErrorBannerPlugin(context);
        this.f21943j = gatekeeperStoreImpl;
        this.i = bool.booleanValue();
        this.b = ImmutableList.builder().c(new CoverImagePlugin(context)).b();
        this.c = ImmutableList.builder().b(this.b).c(videoPlugin).c(loadingSpinnerPlugin).c(subtitlePlugin).c(new VideoBroadcastPlugin(context)).c(fullScreenNetworkErrorBannerPlugin).c(new ClickToPlayAnimationPlugin(context)).c(new FeedFullscreenVideoControlsPlugin(context)).c(fullscreenCallToActionButtonPlugin).c(fullscreenCallToActionEndscreenPlugin).b();
        Builder c = new Builder().b(this.b).c(videoPlugin).c(loadingSpinnerPlugin);
        c.c(new CommercialBreakPlugin(context));
        if (commercialBreakConfig.i) {
            c.c(new CommercialBreakVideoPluginNew(context));
        } else {
            c.c(new CommercialBreakVideoPlugin(context));
        }
        if (facecastUtil.m3114j()) {
            c.c(new LiveVideoControlsPlugin(context));
        } else {
            c.c(new ClickToPlayNoPausePlugin(context));
            if (m24544a()) {
                c.c(new FullScreenCastPlugin(context));
            }
            c.c(new OverflowMenuPlugin(context));
        }
        if (facecastUtil.m3112d()) {
            fullScreenLiveVideoStatusPlugin = new FullScreenLiveVideoStatusPlugin(context);
        } else {
            fullScreenLiveVideoStatusPlugin = new FullScreenVideoBroadcastPlugin(context);
        }
        c.c(fullScreenLiveVideoStatusPlugin).c(liveEventsPlugin).c(new LiveTipJarPlugin(context)).c(new CommercialBreakTransitionPlugin(context));
        if (facecastUtil.m3109a()) {
            c.c(streamingReactionsPlugin);
        }
        this.e = c.c(new VideoBroadcastEndScreenPlugin(context)).c(new FeedbackWithViewsAndCountPlugin(context)).b();
        if (facecastUtil.m3122w()) {
            this.g = m24543a(context, this.e);
        }
        Builder c2 = new Builder().b(this.b).c(new Video360FullScreenPlugin(context)).c(loadingSpinnerPlugin).c(subtitlePlugin).c(fullScreenNetworkErrorBannerPlugin).c(new Video360ControlsPlugin(context)).c(fullscreenCallToActionButtonPlugin).c(fullscreenCallToActionEndscreenPlugin);
        if (video360PlayerConfig.h()) {
            c2.c(new Video360HeadingPlugin(context));
        }
        this.d = c2.b();
        if (facecastUtil.m3113h()) {
            c2 = new Builder().b(this.b).c(videoPlugin).c(loadingSpinnerPlugin).c(liveEventsPlugin).c(new PreviouslyLiveVideoBroadcastControlsPlugin(context));
            if (facecastUtil.m3117m()) {
                c2.c(streamingReactionsPlugin);
            }
            this.f = c2.b();
        } else {
            this.f = this.c;
        }
        if (facecastUtil.m3122w()) {
            this.h = m24543a(context, this.f);
        }
    }

    public final RichVideoPlayerPluginType m24545a(RichVideoPlayer richVideoPlayer) {
        if (richVideoPlayer.a(PreviouslyLiveVideoBroadcastControlsPlugin.class) != null) {
            return RichVideoPlayerPluginType.PREVIOUSLY_LIVE_VIDEO;
        }
        if (richVideoPlayer.a(LiveEventsPlugin.class) != null) {
            return RichVideoPlayerPluginType.LIVE_VIDEO;
        }
        if (richVideoPlayer.a(Video360ControlsPlugin.class) != null) {
            return RichVideoPlayerPluginType.REGULAR_360_VIDEO;
        }
        if (richVideoPlayer.a(FeedFullscreenVideoControlsPlugin.class) != null) {
            return RichVideoPlayerPluginType.REGULAR_VIDEO;
        }
        return RichVideoPlayerPluginType.UNKNOWN_VIDEO;
    }

    private boolean m24544a() {
        return this.f21943j.a(VideoAbTestGatekeepers.d, false);
    }

    private static ImmutableList<RichVideoPlayerPlugin> m24543a(Context context, ImmutableList<RichVideoPlayerPlugin> immutableList) {
        Builder builder = new Builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            RichVideoPlayerPlugin richVideoPlayerPlugin = (RichVideoPlayerPlugin) immutableList.get(i);
            if (LiveEventsPlugin.class.isInstance(richVideoPlayerPlugin)) {
                builder.c(new LiveEventsPlugin(new ContextThemeWrapper(context, 2131624720)));
            } else {
                builder.c(richVideoPlayerPlugin);
            }
        }
        return builder.b();
    }
}
