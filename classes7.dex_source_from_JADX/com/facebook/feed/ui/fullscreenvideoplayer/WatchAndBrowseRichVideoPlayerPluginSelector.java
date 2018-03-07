package com.facebook.feed.ui.fullscreenvideoplayer;

import android.content.Context;
import com.facebook.facecastdisplay.LiveEventsPlugin;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.FullScreenNetworkErrorBannerPlugin;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.PreviouslyLiveVideoBroadcastControlsPlugin;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.Video360ControlsPlugin;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.WatchAndBrowseFullscreenVideoControlsPlugin;
import com.facebook.feed.ui.inlinevideoplayer.plugins.VideoBroadcastPlugin;
import com.facebook.feed.video.util.RichVideoPlayerPluginSelector;
import com.facebook.feed.video.util.RichVideoPlayerPluginSelector.RichVideoPlayerPluginType;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.app.module.Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.plugins.ClickToPlayAnimationPlugin;
import com.facebook.video.player.plugins.CoverImagePlugin;
import com.facebook.video.player.plugins.LoadingSpinnerPlugin;
import com.facebook.video.player.plugins.SubtitlePlugin;
import com.facebook.video.player.plugins.Video360Plugin;
import com.facebook.video.player.plugins.VideoPlugin;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: TimelineRenderLowResHeaderCoverphotoOptional */
public class WatchAndBrowseRichVideoPlayerPluginSelector extends RichVideoPlayerPluginSelector {
    public static WatchAndBrowseRichVideoPlayerPluginSelector m24556b(InjectorLike injectorLike) {
        return new WatchAndBrowseRichVideoPlayerPluginSelector((Context) injectorLike.getInstance(Context.class), Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public WatchAndBrowseRichVideoPlayerPluginSelector(Context context, Boolean bool) {
        this.i = bool.booleanValue();
        VideoPlugin videoPlugin = new VideoPlugin(context);
        LoadingSpinnerPlugin loadingSpinnerPlugin = new LoadingSpinnerPlugin(context);
        SubtitlePlugin subtitlePlugin = new SubtitlePlugin(context);
        this.b = ImmutableList.builder().c(new CoverImagePlugin(context)).b();
        this.c = ImmutableList.builder().b(this.b).c(videoPlugin).c(loadingSpinnerPlugin).c(subtitlePlugin).c(new VideoBroadcastPlugin(context)).c(new FullScreenNetworkErrorBannerPlugin(context)).c(new ClickToPlayAnimationPlugin(context)).c(new WatchAndBrowseFullscreenVideoControlsPlugin(context)).b();
        this.d = ImmutableList.builder().b(this.b).c(new Video360Plugin(context)).c(loadingSpinnerPlugin).c(subtitlePlugin).c(new FullScreenNetworkErrorBannerPlugin(context)).c(new Video360ControlsPlugin(context)).b();
        this.e = this.c;
        this.f = this.c;
    }

    public final RichVideoPlayerPluginType m24557a(RichVideoPlayer richVideoPlayer) {
        if (richVideoPlayer.a(PreviouslyLiveVideoBroadcastControlsPlugin.class) != null) {
            return RichVideoPlayerPluginType.PREVIOUSLY_LIVE_VIDEO;
        }
        if (richVideoPlayer.a(LiveEventsPlugin.class) != null) {
            return RichVideoPlayerPluginType.LIVE_VIDEO;
        }
        if (richVideoPlayer.a(Video360ControlsPlugin.class) != null) {
            return RichVideoPlayerPluginType.REGULAR_360_VIDEO;
        }
        if (richVideoPlayer.a(WatchAndBrowseFullscreenVideoControlsPlugin.class) != null) {
            return RichVideoPlayerPluginType.REGULAR_VIDEO;
        }
        return RichVideoPlayerPluginType.UNKNOWN_VIDEO;
    }
}
