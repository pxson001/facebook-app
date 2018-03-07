package com.facebook.video.api;

import com.facebook.common.eventbus.TypedEvent;
import com.facebook.common.eventbus.TypedHandler;

/* compiled from: percentile_75 */
public class AsyncVideo$PlayRequestedEvent extends TypedEvent<Handler> {
    public final UserReason f5275a;
    public final int f5276b;

    /* compiled from: percentile_75 */
    public interface Handler extends TypedHandler {
        void mo467a(AsyncVideo$PlayRequestedEvent asyncVideo$PlayRequestedEvent);
    }

    public final void m5784a(TypedHandler typedHandler) {
        ((Handler) typedHandler).mo467a(this);
    }

    public AsyncVideo$PlayRequestedEvent(int i, UserReason userReason) {
        this.f5276b = i;
        this.f5275a = userReason;
    }
}
