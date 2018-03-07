package com.facebook.video.player;

import android.content.Context;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: composer_minutiae_icon_clicked */
public class RichVideoPlayerBuilder {
    public PlayerOrigin f19198a = PlayerOrigin.UNKNOWN;
    public PlayerType f19199b = PlayerType.OTHERS;
    private final List<RichVideoPlayerPlugin> f19200c = new ArrayList();
    public boolean f19201d = true;

    public final RichVideoPlayerBuilder m27992a(PlayerOrigin playerOrigin) {
        this.f19198a = playerOrigin;
        return this;
    }

    public final RichVideoPlayerBuilder m27993a(PlayerType playerType) {
        this.f19199b = playerType;
        return this;
    }

    public final RichVideoPlayerBuilder m27996a(RichVideoPlayerPlugin... richVideoPlayerPluginArr) {
        return m27994a(Arrays.asList(richVideoPlayerPluginArr));
    }

    public final RichVideoPlayerBuilder m27994a(List<RichVideoPlayerPlugin> list) {
        this.f19200c.addAll(list);
        return this;
    }

    public final RichVideoPlayerBuilder m27995a(boolean z) {
        this.f19201d = z;
        return this;
    }

    public final RichVideoPlayer m27990a(Context context) {
        return m27991a(new RichVideoPlayer(context));
    }

    public final RichVideoPlayer m27991a(RichVideoPlayer richVideoPlayer) {
        for (RichVideoPlayerPlugin a : this.f19200c) {
            richVideoPlayer.a(a);
        }
        richVideoPlayer.setPlayerOrigin(this.f19198a);
        richVideoPlayer.setPlayerType(this.f19199b);
        richVideoPlayer.s = this.f19201d;
        return richVideoPlayer;
    }
}
