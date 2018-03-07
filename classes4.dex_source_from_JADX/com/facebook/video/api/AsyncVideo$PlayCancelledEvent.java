package com.facebook.video.api;

import com.facebook.common.eventbus.TypedEvent;
import com.facebook.common.eventbus.TypedHandler;

/* compiled from: percentile_75 */
public class AsyncVideo$PlayCancelledEvent extends TypedEvent<Handler> {
    public final UserReason f5280a;
    public final UserReason f5281b;
    public final int f5282c;

    /* compiled from: percentile_75 */
    public interface Handler extends TypedHandler {
        void mo466a();
    }

    public final void m5786a(TypedHandler typedHandler) {
        ((Handler) typedHandler).mo466a();
    }

    public AsyncVideo$PlayCancelledEvent(UserReason userReason, UserReason userReason2, int i) {
        this.f5280a = userReason;
        this.f5281b = userReason2;
        this.f5282c = i;
    }
}
