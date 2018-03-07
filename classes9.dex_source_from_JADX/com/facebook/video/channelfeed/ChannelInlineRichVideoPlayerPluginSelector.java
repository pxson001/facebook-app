package com.facebook.video.channelfeed;

import android.content.Context;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.VideoInlineBroadcastEndScreenPlugin;
import com.facebook.feed.ui.inlinevideoplayer.plugins.LiveVideoStatusPlugin;
import com.facebook.feed.ui.inlinevideoplayer.plugins.VideoBroadcastPlugin;
import com.facebook.feed.video.util.RichVideoPlayerPluginSelector;
import com.facebook.feed.video.util.RichVideoPlayerPluginSelector.RichVideoPlayerPluginType;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.video.abtest.Video360PlayerConfig;
import com.facebook.video.channelfeed.plugins.ChannelFeed360TouchControlsPlugin;
import com.facebook.video.channelfeed.plugins.ChannelFeedClickToFullscreenPlugin;
import com.facebook.video.channelfeed.plugins.ChannelFeedInlineVideoControlsPlugin;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.plugins.CoverImagePlugin;
import com.facebook.video.player.plugins.InlineSubtitlePlugin;
import com.facebook.video.player.plugins.LoadingSpinnerPlugin;
import com.facebook.video.player.plugins.SinglePlayIconPlugin;
import com.facebook.video.player.plugins.Static360IndicatorPlugin;
import com.facebook.video.player.plugins.Video360HeadingPlugin;
import com.facebook.video.player.plugins.Video360IndicatorPlugin;
import com.facebook.video.player.plugins.Video360Plugin;
import com.facebook.video.player.plugins.VideoPlugin;
import com.facebook.video.player.plugins.VideoVRCastPlugin;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: success_uri */
public class ChannelInlineRichVideoPlayerPluginSelector extends RichVideoPlayerPluginSelector {
    @Inject
    public ChannelInlineRichVideoPlayerPluginSelector(Context context, Video360PlayerConfig video360PlayerConfig, Boolean bool, GatekeeperStoreImpl gatekeeperStoreImpl) {
        Object liveVideoStatusPlugin;
        boolean a = gatekeeperStoreImpl.a(597, false);
        VideoPlugin videoPlugin = new VideoPlugin(context);
        CoverImagePlugin coverImagePlugin = new CoverImagePlugin(context);
        LoadingSpinnerPlugin loadingSpinnerPlugin = new LoadingSpinnerPlugin(context);
        SinglePlayIconPlugin singlePlayIconPlugin = new SinglePlayIconPlugin(context);
        ChannelFeedInlineVideoControlsPlugin channelFeedInlineVideoControlsPlugin = new ChannelFeedInlineVideoControlsPlugin(context);
        ChannelFeedClickToFullscreenPlugin channelFeedClickToFullscreenPlugin = new ChannelFeedClickToFullscreenPlugin(context);
        this.b = ImmutableList.builder().b();
        this.c = ImmutableList.builder().b(this.b).c(videoPlugin).c(coverImagePlugin).c(loadingSpinnerPlugin).c(channelFeedInlineVideoControlsPlugin).c(new InlineSubtitlePlugin(context)).b();
        Builder c = ImmutableList.builder().b(this.b).c(videoPlugin).c(coverImagePlugin);
        if (a) {
            liveVideoStatusPlugin = new LiveVideoStatusPlugin(context);
        } else {
            liveVideoStatusPlugin = new VideoBroadcastPlugin(context);
        }
        this.e = c.c(liveVideoStatusPlugin).c(singlePlayIconPlugin).c(new VideoInlineBroadcastEndScreenPlugin(context)).c(channelFeedClickToFullscreenPlugin).b();
        Builder c2 = new Builder().b(this.b).c(new Video360Plugin(context)).c(coverImagePlugin).c(loadingSpinnerPlugin).c(new ChannelFeed360TouchControlsPlugin(context));
        if (!video360PlayerConfig.k) {
            c2.c(new Video360IndicatorPlugin(context)).c(new Static360IndicatorPlugin(context));
        }
        if (video360PlayerConfig.h()) {
            c2.c(new Video360HeadingPlugin(context));
        }
        this.d = c2.c(new VideoVRCastPlugin(context)).b();
        this.i = bool.booleanValue();
        Builder c3 = ImmutableList.builder().b(this.b).c(videoPlugin).c(coverImagePlugin).c(loadingSpinnerPlugin).c(singlePlayIconPlugin);
        if (gatekeeperStoreImpl.a(473, false)) {
            liveVideoStatusPlugin = channelFeedClickToFullscreenPlugin;
        } else {
            ChannelFeedInlineVideoControlsPlugin channelFeedInlineVideoControlsPlugin2 = channelFeedInlineVideoControlsPlugin;
        }
        this.f = c3.c(liveVideoStatusPlugin).b();
    }

    public final RichVideoPlayerPluginType m2519a(RichVideoPlayer richVideoPlayer) {
        if (richVideoPlayer.a(LiveVideoStatusPlugin.class) != null || richVideoPlayer.a(VideoBroadcastPlugin.class) != null) {
            return RichVideoPlayerPluginType.LIVE_VIDEO;
        }
        if (richVideoPlayer.a(Video360Plugin.class) != null) {
            return RichVideoPlayerPluginType.REGULAR_360_VIDEO;
        }
        if (richVideoPlayer.a(SinglePlayIconPlugin.class) != null) {
            return RichVideoPlayerPluginType.PREVIOUSLY_LIVE_VIDEO;
        }
        if (richVideoPlayer.a(ChannelFeedInlineVideoControlsPlugin.class) != null) {
            return RichVideoPlayerPluginType.REGULAR_VIDEO;
        }
        return RichVideoPlayerPluginType.UNKNOWN_VIDEO;
    }
}
