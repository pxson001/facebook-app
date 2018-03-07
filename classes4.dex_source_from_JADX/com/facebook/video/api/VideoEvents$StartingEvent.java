package com.facebook.video.api;

import com.facebook.common.eventbus.TypedEvent;
import com.facebook.common.eventbus.TypedHandler;

/* compiled from: percentile_50 */
public class VideoEvents$StartingEvent extends TypedEvent<Handler> {
    public final UserReason f5283a;
    public final int f5284b;

    /* compiled from: percentile_50 */
    public interface Handler extends TypedHandler {
        void mo469a(VideoEvents$StartingEvent videoEvents$StartingEvent);
    }

    public final void m5787a(TypedHandler typedHandler) {
        ((Handler) typedHandler).mo469a(this);
    }

    public VideoEvents$StartingEvent(int i, UserReason userReason) {
        this.f5284b = i;
        this.f5283a = userReason;
    }
}
