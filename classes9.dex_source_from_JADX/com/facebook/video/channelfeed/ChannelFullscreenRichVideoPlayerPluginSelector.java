package com.facebook.video.channelfeed;

import android.content.Context;
import android.view.ContextThemeWrapper;
import com.facebook.facecastdisplay.FacecastUiUtil;
import com.facebook.facecastdisplay.FacecastUtil;
import com.facebook.facecastdisplay.LiveEventsPlugin;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.FeedbackWithViewsAndCountPlugin;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.PreviouslyLiveVideoBroadcastControlsPlugin;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.StreamingReactionsPlugin;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.Video360ControlsPlugin;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.VideoBroadcastEndScreenPlugin;
import com.facebook.feed.ui.inlinevideoplayer.plugins.FullScreenLiveVideoStatusPlugin;
import com.facebook.feed.ui.inlinevideoplayer.plugins.FullScreenVideoBroadcastPlugin;
import com.facebook.feed.video.util.RichVideoPlayerPluginSelector;
import com.facebook.feed.video.util.RichVideoPlayerPluginSelector.RichVideoPlayerPluginType;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.app.module.Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider;
import com.facebook.video.abtest.Video360PlayerConfig;
import com.facebook.video.channelfeed.abtest.ChannelFeedConfig;
import com.facebook.video.channelfeed.plugins.AdvancePlaybackOnFlingPlugin;
import com.facebook.video.channelfeed.plugins.ChannelFeedFullscreenVideoControlsPlugin;
import com.facebook.video.channelfeed.plugins.ChannelFeedFullscreenVideoControlsPluginWithSocialContext;
import com.facebook.video.channelfeed.plugins.PostPlaybackPlugin;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.plugins.ClickToPlayNoPausePlugin;
import com.facebook.video.player.plugins.CoverImagePlugin;
import com.facebook.video.player.plugins.LiveVideoControlsPlugin;
import com.facebook.video.player.plugins.LoadingSpinnerPlugin;
import com.facebook.video.player.plugins.OverflowMenuPlugin;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.player.plugins.SubtitlePlugin;
import com.facebook.video.player.plugins.Video360FullScreenPlugin;
import com.facebook.video.player.plugins.Video360HeadingPlugin;
import com.facebook.video.player.plugins.Video360Plugin;
import com.facebook.video.player.plugins.VideoPlugin;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: success_verify_sms_code */
public class ChannelFullscreenRichVideoPlayerPluginSelector extends RichVideoPlayerPluginSelector {
    public static ChannelFullscreenRichVideoPlayerPluginSelector m2517b(InjectorLike injectorLike) {
        return new ChannelFullscreenRichVideoPlayerPluginSelector((Context) injectorLike.getInstance(Context.class), Video360PlayerConfig.b(injectorLike), ChannelFeedConfig.a(injectorLike), FacecastUtil.b(injectorLike), Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public ChannelFullscreenRichVideoPlayerPluginSelector(Context context, Video360PlayerConfig video360PlayerConfig, ChannelFeedConfig channelFeedConfig, FacecastUtil facecastUtil, Boolean bool) {
        Object channelFeedFullscreenVideoControlsPluginWithSocialContext;
        VideoPlugin videoPlugin = new VideoPlugin(context);
        SubtitlePlugin subtitlePlugin = new SubtitlePlugin(context);
        LiveEventsPlugin liveEventsPlugin = new LiveEventsPlugin(new ContextThemeWrapper(context, FacecastUiUtil.a()));
        PostPlaybackPlugin postPlaybackPlugin = new PostPlaybackPlugin(context);
        LoadingSpinnerPlugin loadingSpinnerPlugin = new LoadingSpinnerPlugin(context);
        StreamingReactionsPlugin streamingReactionsPlugin = new StreamingReactionsPlugin(context);
        AdvancePlaybackOnFlingPlugin advancePlaybackOnFlingPlugin = new AdvancePlaybackOnFlingPlugin(context);
        this.i = bool.booleanValue();
        this.b = new Builder().c(new CoverImagePlugin(context)).b();
        if (channelFeedConfig.l) {
            channelFeedFullscreenVideoControlsPluginWithSocialContext = new ChannelFeedFullscreenVideoControlsPluginWithSocialContext(context);
        } else {
            channelFeedFullscreenVideoControlsPluginWithSocialContext = new ChannelFeedFullscreenVideoControlsPlugin(context);
        }
        Builder c = new Builder().b(this.b).c(videoPlugin).c(loadingSpinnerPlugin).c(channelFeedFullscreenVideoControlsPluginWithSocialContext).c(subtitlePlugin);
        if (channelFeedConfig.i) {
            c.c(advancePlaybackOnFlingPlugin);
        }
        if (channelFeedConfig.h) {
            c.c(postPlaybackPlugin);
        }
        this.c = c.b();
        Builder c2 = new Builder().b(this.b).c(videoPlugin);
        if (facecastUtil.j()) {
            c2.c(new LiveVideoControlsPlugin(context));
        } else {
            c2.c(new ClickToPlayNoPausePlugin(context));
            c2.c(new OverflowMenuPlugin(context));
        }
        if (facecastUtil.d()) {
            channelFeedFullscreenVideoControlsPluginWithSocialContext = new FullScreenLiveVideoStatusPlugin(context);
        } else {
            channelFeedFullscreenVideoControlsPluginWithSocialContext = new FullScreenVideoBroadcastPlugin(context);
        }
        c2.c(channelFeedFullscreenVideoControlsPluginWithSocialContext).c(liveEventsPlugin);
        if (facecastUtil.a()) {
            c2.c(new StreamingReactionsPlugin(context));
        }
        this.e = c2.c(new VideoBroadcastEndScreenPlugin(context)).c(new FeedbackWithViewsAndCountPlugin(context)).b();
        if (facecastUtil.w()) {
            this.g = m2516a(context, this.e);
        }
        c = new Builder().b(this.b).c(new Video360FullScreenPlugin(context)).c(new Video360ControlsPlugin(context));
        if (video360PlayerConfig.h()) {
            c.c(new Video360HeadingPlugin(context));
        }
        if (channelFeedConfig.h) {
            c.c(postPlaybackPlugin);
        }
        this.d = c.b();
        if (facecastUtil.h()) {
            c = new Builder().b(this.b).c(videoPlugin).c(loadingSpinnerPlugin).c(liveEventsPlugin).c(new PreviouslyLiveVideoBroadcastControlsPlugin(context));
            if (facecastUtil.m()) {
                c.c(streamingReactionsPlugin);
            }
            if (channelFeedConfig.i) {
                c.c(advancePlaybackOnFlingPlugin);
            }
            this.f = c.b();
            if (facecastUtil.w()) {
                this.h = m2516a(context, this.f);
                return;
            }
            return;
        }
        this.f = this.c;
    }

    public final RichVideoPlayerPluginType m2518a(RichVideoPlayer richVideoPlayer) {
        if (richVideoPlayer.a(PreviouslyLiveVideoBroadcastControlsPlugin.class) != null) {
            return RichVideoPlayerPluginType.PREVIOUSLY_LIVE_VIDEO;
        }
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

    private static ImmutableList<RichVideoPlayerPlugin> m2516a(Context context, ImmutableList<RichVideoPlayerPlugin> immutableList) {
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
