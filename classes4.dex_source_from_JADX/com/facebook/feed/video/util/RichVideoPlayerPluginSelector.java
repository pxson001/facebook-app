package com.facebook.feed.video.util;

import android.content.Context;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.environment.AnyPlayerEnvironment;
import com.facebook.video.player.plugins.DebugConsolePlugin;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.player.plugins.Video360Plugin;
import com.facebook.video.player.plugins.VideoPlugin;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;

/* compiled from: prefill */
public class RichVideoPlayerPluginSelector {
    protected ImmutableList<Class> f4306a;
    protected ImmutableList<RichVideoPlayerPlugin> f4307b;
    protected ImmutableList<RichVideoPlayerPlugin> f4308c;
    protected ImmutableList<RichVideoPlayerPlugin> f4309d;
    protected ImmutableList<RichVideoPlayerPlugin> f4310e;
    protected ImmutableList<RichVideoPlayerPlugin> f4311f;
    @Nullable
    protected ImmutableList<RichVideoPlayerPlugin> f4312g;
    @Nullable
    protected ImmutableList<RichVideoPlayerPlugin> f4313h;
    protected boolean f4314i;

    @VisibleForTesting
    /* compiled from: prefill */
    public enum RichVideoPlayerPluginType {
        UNKNOWN_VIDEO(0),
        REGULAR_VIDEO(1),
        REGULAR_360_VIDEO(2),
        LIVE_VIDEO(3),
        PREVIOUSLY_LIVE_VIDEO(4);
        
        private final int value;

        private RichVideoPlayerPluginType(int i) {
            this.value = i;
        }

        public final String toString() {
            return String.valueOf(this.value);
        }
    }

    public final RichVideoPlayer m4862a(RichVideoPlayer richVideoPlayer, RichVideoPlayerParams richVideoPlayerParams, @Nullable AnyPlayerEnvironment anyPlayerEnvironment) {
        Preconditions.checkNotNull(richVideoPlayer);
        Preconditions.checkNotNull(richVideoPlayerParams);
        RichVideoPlayerPluginType a = m4860a(richVideoPlayerParams);
        if (mo375a(richVideoPlayer, a)) {
            return richVideoPlayer;
        }
        Context context = richVideoPlayer.getContext();
        if (context == null) {
            return richVideoPlayer;
        }
        if (this.f4306a == null) {
            this.f4306a = new Builder().b();
        }
        richVideoPlayer.m14831b(this.f4306a);
        if (this.f4314i) {
            richVideoPlayer.m14825a(new DebugConsolePlugin(context));
        }
        switch (a) {
            case REGULAR_VIDEO:
                Preconditions.checkNotNull(this.f4308c);
                richVideoPlayer.m14828a(this.f4308c);
                break;
            case REGULAR_360_VIDEO:
                Preconditions.checkNotNull(this.f4309d);
                richVideoPlayer.m14828a(this.f4309d);
                break;
            case LIVE_VIDEO:
                if (this.f4312g != null && richVideoPlayerParams.m5357b()) {
                    richVideoPlayer.m14828a(this.f4312g);
                    break;
                }
                Preconditions.checkNotNull(this.f4310e);
                richVideoPlayer.m14828a(this.f4310e);
                break;
            case PREVIOUSLY_LIVE_VIDEO:
                if (this.f4313h != null && richVideoPlayerParams.m5357b()) {
                    richVideoPlayer.m14828a(this.f4313h);
                    break;
                }
                Preconditions.checkNotNull(this.f4311f);
                richVideoPlayer.m14828a(this.f4311f);
                break;
            case UNKNOWN_VIDEO:
                return null;
        }
        richVideoPlayer.setPluginEnvironment(anyPlayerEnvironment);
        return richVideoPlayer;
    }

    @VisibleForTesting
    private static RichVideoPlayerPluginType m4860a(RichVideoPlayerParams richVideoPlayerParams) {
        if (richVideoPlayerParams.f4962a == null) {
            return RichVideoPlayerPluginType.UNKNOWN_VIDEO;
        }
        if (richVideoPlayerParams.f4962a.f4850s != null) {
            return RichVideoPlayerPluginType.REGULAR_360_VIDEO;
        }
        if (richVideoPlayerParams.f4962a.f4839h) {
            return RichVideoPlayerPluginType.LIVE_VIDEO;
        }
        if (RichVideoPlayerParamsUtil.m5430d(richVideoPlayerParams)) {
            return RichVideoPlayerPluginType.PREVIOUSLY_LIVE_VIDEO;
        }
        return RichVideoPlayerPluginType.REGULAR_VIDEO;
    }

    @VisibleForTesting
    public RichVideoPlayerPluginType mo374a(RichVideoPlayer richVideoPlayer) {
        if (richVideoPlayer.m14816a(Video360Plugin.class) != null) {
            return RichVideoPlayerPluginType.REGULAR_360_VIDEO;
        }
        if (richVideoPlayer.m14816a(VideoPlugin.class) != null) {
            return RichVideoPlayerPluginType.REGULAR_VIDEO;
        }
        return RichVideoPlayerPluginType.UNKNOWN_VIDEO;
    }

    protected boolean mo375a(RichVideoPlayer richVideoPlayer, RichVideoPlayerPluginType richVideoPlayerPluginType) {
        return richVideoPlayerPluginType == mo374a(richVideoPlayer);
    }
}
