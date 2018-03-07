package com.facebook.video.videohome.plugins;

import android.content.Context;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.VideoInlineBroadcastEndScreenPlugin;
import com.facebook.feed.ui.inlinevideoplayer.plugins.LiveVideoStatusPlugin;
import com.facebook.feed.ui.inlinevideoplayer.plugins.VideoBroadcastPlugin;
import com.facebook.feed.video.util.RichVideoPlayerPluginSelector;
import com.facebook.feed.video.util.RichVideoPlayerPluginSelector.RichVideoPlayerPluginType;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.video.abtest.VideoAbTestGatekeepers;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.plugins.CoverImagePlugin;
import com.facebook.video.player.plugins.LoadingSpinnerPlugin;
import com.facebook.video.player.plugins.OverflowMenuPlugin;
import com.facebook.video.player.plugins.Static360IndicatorPlugin;
import com.facebook.video.player.plugins.Video360IndicatorPlugin;
import com.facebook.video.player.plugins.Video360Plugin;
import com.facebook.video.player.plugins.VideoPlugin;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: sideshow/ */
public class VideoHomePlayerPluginSelector extends RichVideoPlayerPluginSelector {
    @Inject
    public VideoHomePlayerPluginSelector(Context context, GatekeeperStoreImpl gatekeeperStoreImpl, Boolean bool) {
        boolean a = gatekeeperStoreImpl.a(VideoAbTestGatekeepers.f, false);
        VideoPlugin videoPlugin = new VideoPlugin(context);
        this.i = bool.booleanValue();
        this.b = ImmutableList.builder().c(new CoverImagePlugin(context)).c(new LoadingSpinnerPlugin(context)).c(new VideoHomeNonPlayingOverlayPlugin(context)).c(new OverflowMenuPlugin(context)).b();
        this.c = ImmutableList.builder().b(this.b).c(videoPlugin).b();
        this.e = ImmutableList.builder().b(this.b).c(videoPlugin).c(a ? new LiveVideoStatusPlugin(context) : new VideoBroadcastPlugin(context)).c(new VideoInlineBroadcastEndScreenPlugin(context)).b();
        this.d = ImmutableList.builder().b(this.b).c(new Video360Plugin(context)).c(new Video360IndicatorPlugin(context)).c(new Static360IndicatorPlugin(context)).b();
        this.f = this.c;
    }

    public final RichVideoPlayerPluginType m3124a(RichVideoPlayer richVideoPlayer) {
        if (richVideoPlayer.a(LiveVideoStatusPlugin.class) == null && richVideoPlayer.a(VideoBroadcastPlugin.class) == null) {
            return super.a(richVideoPlayer);
        }
        return RichVideoPlayerPluginType.LIVE_VIDEO;
    }
}
