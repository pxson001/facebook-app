package com.facebook.video.api;

import com.facebook.common.eventbus.TypedEvent;
import com.facebook.common.eventbus.TypedHandler;

/* compiled from: percentile_75 */
public class AsyncVideo$PlayStartedEvent extends TypedEvent<Handler> {
    public final int f5277a;
    public final int f5278b;
    public final UserReason f5279c;

    /* compiled from: percentile_75 */
    public interface Handler extends TypedHandler {
        void mo468a(AsyncVideo$PlayStartedEvent asyncVideo$PlayStartedEvent);
    }

    public final void m5785a(TypedHandler typedHandler) {
        ((Handler) typedHandler).mo468a(this);
    }

    public AsyncVideo$PlayStartedEvent(int i, int i2, UserReason userReason) {
        this.f5277a = i;
        this.f5278b = i2;
        this.f5279c = userReason;
    }
}
