package com.facebook.video.api;

import com.facebook.common.eventbus.TypedEventBus;

/* compiled from: container */
public interface Video<SourceType> {

    /* compiled from: container */
    public enum State {
        UNPREPARED,
        PREPARING,
        UNPREPARING,
        READY,
        SEEKING,
        PLAYING,
        BUFFERING,
        PAUSING,
        ERROR
    }

    void mo1403a(UserReason userReason);

    void mo1404b(UserReason userReason);

    State getCurrentState();

    TypedEventBus getEventBus();

    VideoMetadata getMetadata();

    int getPosition();

    SourceType getSource();

    void setPosition(int i);

    void setSource(SourceType sourceType);
}
