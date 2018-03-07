package com.facebook.video.server;

import com.facebook.common.eventbus.TypedEvent;
import com.facebook.common.eventbus.TypedHandler;
import com.facebook.video.engine.texview.InitializationSequenceLogger.Handler;

/* compiled from: peer_id */
public class VideoServerEvents$NetworkAccessRequestedEvent extends TypedEvent<Handler> {
    public final long f5287a;
    public final long f5288b;

    public final void m5790a(TypedHandler typedHandler) {
        ((Handler) typedHandler).m5610a(this);
    }

    public VideoServerEvents$NetworkAccessRequestedEvent(long j, long j2) {
        this.f5287a = j;
        this.f5288b = j2;
    }
}
