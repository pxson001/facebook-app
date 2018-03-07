package com.facebook.video.server;

import com.facebook.common.eventbus.TypedEvent;
import com.facebook.common.eventbus.TypedHandler;
import com.facebook.video.engine.texview.InitializationSequenceLogger.Handler;

/* compiled from: peer_id */
public class VideoServerEvents$NetworkAccessRetrievedEvent extends TypedEvent<Handler> {
    public final long f5289a;
    public final long f5290b;

    public final void m5791a(TypedHandler typedHandler) {
        ((Handler) typedHandler).m5611a(this);
    }

    public VideoServerEvents$NetworkAccessRetrievedEvent(long j, long j2) {
        this.f5289a = j;
        this.f5290b = j2;
    }
}
