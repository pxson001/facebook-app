package com.facebook.video.watchandbrowse;

import android.content.Context;
import com.facebook.facecastdisplay.LiveEventsPlugin;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.Video360ControlsPlugin;
import com.facebook.feed.video.util.RichVideoPlayerPluginSelector;
import com.facebook.feed.video.util.RichVideoPlayerPluginSelector.RichVideoPlayerPluginType;
import com.facebook.video.abtest.Video360PlayerConfig;
import com.facebook.video.channelfeed.abtest.ChannelFeedConfig;
import com.facebook.video.channelfeed.plugins.ChannelFeedFullscreenVideoControlsPlugin;
import com.facebook.video.channelfeed.plugins.ChannelFeedFullscreenVideoControlsPluginWithSocialContext;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.plugins.CoverImagePlugin;
import com.facebook.video.player.plugins.LoadingSpinnerPlugin;
import com.facebook.video.player.plugins.SubtitlePlugin;
import com.facebook.video.player.plugins.Video360FullScreenPlugin;
import com.facebook.video.player.plugins.Video360HeadingPlugin;
import com.facebook.video.player.plugins.Video360Plugin;
import com.facebook.video.player.plugins.VideoPlugin;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: showInterstitial */
public class VideoWatchAndBrowseFullScreenVideoPlayerPluginSelector extends RichVideoPlayerPluginSelector {
    @Inject
    public VideoWatchAndBrowseFullScreenVideoPlayerPluginSelector(Context context, Video360PlayerConfig video360PlayerConfig, ChannelFeedConfig channelFeedConfig, Boolean bool) {
        this.i = bool.booleanValue();
        VideoPlugin videoPlugin = new VideoPlugin(context);
        CoverImagePlugin coverImagePlugin = new CoverImagePlugin(context);
        LoadingSpinnerPlugin loadingSpinnerPlugin = new LoadingSpinnerPlugin(context);
        Object channelFeedFullscreenVideoControlsPluginWithSocialContext = channelFeedConfig.l ? new ChannelFeedFullscreenVideoControlsPluginWithSocialContext(context) : new ChannelFeedFullscreenVideoControlsPlugin(context);
        this.a = ImmutableList.builder().b();
        this.b = ImmutableList.builder().b();
        this.c = new Builder().b(this.b).c(videoPlugin).c(coverImagePlugin).c(loadingSpinnerPlugin).c(channelFeedFullscreenVideoControlsPluginWithSocialContext).c(new SubtitlePlugin(context)).b();
        Builder c = new Builder().b(this.b).c(new Video360FullScreenPlugin(context)).c(new Video360ControlsPlugin(context));
        if (video360PlayerConfig.l) {
            c.c(new Video360HeadingPlugin(context));
        }
        this.d = c.b();
        this.e = this.c;
        this.f = this.c;
    }

    public final RichVideoPlayerPluginType m3210a(RichVideoPlayer richVideoPlayer) {
        if (richVideoPlayer.a(LiveEventsPlugin.class) != null) {
            return RichVideoPlayerPluginType.LIVE_VIDEO;
        }
        if (richVideoPlayer.a(Video360Plugin.class) != null) {
            return RichVideoPlayerPluginType.REGULAR_360_VIDEO;
        }
        if (richVideoPlayer.a(VideoPlugin.class) != null) {
            return RichVideoPlayerPluginType.REGULAR_VIDEO;
        }
        return RichVideoPlayerPluginType.UNKNOWN_VIDEO;
    }
}
