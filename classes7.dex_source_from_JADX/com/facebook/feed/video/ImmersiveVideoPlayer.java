package com.facebook.feed.video;

import com.facebook.video.player.FullScreenVideoListener;

/* compiled from: Topic Composer NUX */
public interface ImmersiveVideoPlayer {
    Object mo1523a(FullScreenVideoListener fullScreenVideoListener);

    void mo1524a(FeedFullScreenParams feedFullScreenParams);

    boolean mo1525a();

    boolean mo1526b();

    void mo1527c();

    void mo1528d();

    void mo1529e();

    void mo1530f();

    boolean mo1531g();

    void setAllowLooping(boolean z);

    void setLogEnteringStartEvent(boolean z);

    void setLogExitingPauseEvent(boolean z);

    void setVisibility(int i);

    void u_(int i);
}
