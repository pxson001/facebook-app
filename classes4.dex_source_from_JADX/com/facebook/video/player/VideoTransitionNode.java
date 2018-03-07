package com.facebook.video.player;

import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import java.util.List;

/* compiled from: prefilled_value */
public interface VideoTransitionNode {
    void mo361a(RichVideoPlayer richVideoPlayer);

    List<RichVideoPlayerPlugin> getAdditionalPlugins();

    PlayerType getPlayerType();

    @Deprecated
    RichVideoPlayer getRichVideoPlayer();

    RichVideoPlayer mo371i();

    RichVideoPlayer mo372j();
}
