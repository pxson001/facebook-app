package com.facebook.feedplugins.video;

import android.content.Context;
import com.facebook.common.util.TriState;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.VideoInlineBroadcastEndScreenPlugin;
import com.facebook.feed.ui.inlinevideoplayer.plugins.InlineCallToActionEndscreenPlugin;
import com.facebook.feed.ui.inlinevideoplayer.plugins.InlineSaveButtonPlugin;
import com.facebook.feed.ui.inlinevideoplayer.plugins.LiveVideoStatusPlugin;
import com.facebook.feed.ui.inlinevideoplayer.plugins.PlayDownloadPlugin;
import com.facebook.feed.ui.inlinevideoplayer.plugins.VideoBroadcastPlugin;
import com.facebook.feed.ui.inlinevideoplayer.plugins.VideoLiveScribeButtonPlugin;
import com.facebook.feed.video.util.RichVideoPlayerPluginSelector;
import com.facebook.feed.video.util.RichVideoPlayerPluginSelector.RichVideoPlayerPluginType;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.qe.api.QeAccessor;
import com.facebook.saved.gating.feature.ExperimentsForSavedGatingModule;
import com.facebook.video.abtest.ExperimentsForVideoAbTestModule;
import com.facebook.video.abtest.Video360PlayerConfig;
import com.facebook.video.abtest.VideoAbTestGatekeepers;
import com.facebook.video.commercialbreak.abtest.CommercialBreakConfig;
import com.facebook.video.commercialbreak.plugins.CommercialBreakPlugin;
import com.facebook.video.commercialbreak.plugins.CommercialBreakTransitionPlugin;
import com.facebook.video.commercialbreak.plugins.CommercialBreakVideoPluginNew;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.plugins.CommercialBreakVideoPlugin;
import com.facebook.video.player.plugins.CoverImagePlugin;
import com.facebook.video.player.plugins.InlineFeed360TouchPlugin;
import com.facebook.video.player.plugins.InlineSubtitlePlugin;
import com.facebook.video.player.plugins.LoadingSpinnerPlugin;
import com.facebook.video.player.plugins.SinglePlayIconPlugin;
import com.facebook.video.player.plugins.Static360IndicatorPlugin;
import com.facebook.video.player.plugins.Video360HeadingPlugin;
import com.facebook.video.player.plugins.Video360IndicatorPlugin;
import com.facebook.video.player.plugins.Video360NuxAnimationPlugin;
import com.facebook.video.player.plugins.Video360Plugin;
import com.facebook.video.player.plugins.VideoPlugin;
import com.facebook.video.player.plugins.VideoVRCastPlugin;
import com.facebook.video.player.plugins.VolumeIconPlugin;
import com.facebook.video.videohome.abtest.ExperimentsForVideoHomeAbTestModule;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: prefill_used */
public class InlineRichVideoPlayerPluginSelector extends RichVideoPlayerPluginSelector {
    @Inject
    public InlineRichVideoPlayerPluginSelector(Context context, Video360PlayerConfig video360PlayerConfig, QeAccessor qeAccessor, GatekeeperStore gatekeeperStore, Boolean bool, Provider<TriState> provider, CommercialBreakConfig commercialBreakConfig) {
        VideoPlugin videoPlugin = new VideoPlugin(context);
        SinglePlayIconPlugin singlePlayIconPlugin = new SinglePlayIconPlugin(context);
        VideoInlineBroadcastEndScreenPlugin videoInlineBroadcastEndScreenPlugin = new VideoInlineBroadcastEndScreenPlugin(context);
        this.i = bool.booleanValue();
        this.a = ImmutableList.builder().c(InlineCallToActionEndscreenPlugin.class).b();
        Object obj = (qeAccessor.a(ExperimentsForVideoAbTestModule.cW, false) && ((TriState) provider.get()).asBoolean(false)) ? 1 : null;
        Object obj2 = !qeAccessor.a(ExperimentsForVideoHomeAbTestModule.p, false) ? 1 : null;
        boolean a = gatekeeperStore.a(VideoAbTestGatekeepers.f, false);
        boolean a2 = qeAccessor.a(ExperimentsForSavedGatingModule.f4366f, false);
        Builder c = ImmutableList.builder().c(new CoverImagePlugin(context)).c(new InlineSubtitlePlugin(context)).c(new LoadingSpinnerPlugin(context));
        if (obj2 != null) {
            c.c(new VideoLiveScribeButtonPlugin(context));
        }
        if (a2) {
            c.c(new InlineSaveButtonPlugin(context));
        }
        this.b = c.c(new VolumeIconPlugin(context)).b();
        Builder c2 = ImmutableList.builder().b(this.f4307b).c(videoPlugin);
        if (obj != null) {
            c2.c(new PlayDownloadPlugin(context));
        } else {
            c2.c(singlePlayIconPlugin);
        }
        this.c = c2.b();
        c2 = ImmutableList.builder().b(this.f4307b).c(videoPlugin).c(new CommercialBreakPlugin(context)).c(new CommercialBreakTransitionPlugin(context));
        if (commercialBreakConfig.f4324i) {
            c2.c(new CommercialBreakVideoPluginNew(context));
        } else {
            c2.c(new CommercialBreakVideoPlugin(context));
        }
        if (a) {
            obj = new LiveVideoStatusPlugin(context);
        } else {
            obj = new VideoBroadcastPlugin(context);
        }
        c2.c(obj).c(singlePlayIconPlugin).c(videoInlineBroadcastEndScreenPlugin).b();
        this.e = c2.b();
        Builder c3 = new Builder().b(this.f4307b).c(singlePlayIconPlugin).c(new InlineFeed360TouchPlugin(context)).c(new Video360Plugin(context));
        if (video360PlayerConfig.h()) {
            c3.c(new Video360HeadingPlugin(context));
        }
        if (video360PlayerConfig.g()) {
            c3.c(new Video360NuxAnimationPlugin(context));
        } else {
            c3.c(new Video360IndicatorPlugin(context)).c(new Static360IndicatorPlugin(context));
        }
        this.d = c3.c(new VideoVRCastPlugin(context)).b();
        this.f = this.f4308c;
    }

    protected final boolean mo375a(RichVideoPlayer richVideoPlayer, RichVideoPlayerPluginType richVideoPlayerPluginType) {
        RichVideoPlayerPluginType a = mo374a(richVideoPlayer);
        switch (a) {
            case REGULAR_VIDEO:
                if (richVideoPlayerPluginType == RichVideoPlayerPluginType.REGULAR_VIDEO || richVideoPlayerPluginType == RichVideoPlayerPluginType.PREVIOUSLY_LIVE_VIDEO) {
                    return true;
                }
                return false;
            default:
                if (richVideoPlayerPluginType == a) {
                    return true;
                }
                return false;
        }
    }

    public final RichVideoPlayerPluginType mo374a(RichVideoPlayer richVideoPlayer) {
        if (richVideoPlayer.m14816a(LiveVideoStatusPlugin.class) == null && richVideoPlayer.m14816a(VideoBroadcastPlugin.class) == null) {
            return super.mo374a(richVideoPlayer);
        }
        return RichVideoPlayerPluginType.LIVE_VIDEO;
    }
}
