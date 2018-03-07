package com.facebook.video.player;

import com.facebook.video.engine.PlayPosition;

/* compiled from: composer_privacy_ready */
public interface VideoControllable {
    void mo1430a(int i, int i2);

    void mo1432a(PlayPosition playPosition);

    boolean mo1425a();

    void mo1426b();

    int getBufferPercentage();

    int getTrimStartPositionMs();

    int getVideoViewCurrentPosition();

    int getVideoViewDurationInMillis();

    void i_(int i);
}
