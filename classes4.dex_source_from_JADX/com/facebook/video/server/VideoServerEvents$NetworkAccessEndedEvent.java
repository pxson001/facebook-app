package com.facebook.video.server;

import com.facebook.common.eventbus.TypedEvent;
import com.facebook.common.eventbus.TypedHandler;
import com.facebook.video.engine.texview.InitializationSequenceLogger.Handler;

/* compiled from: peer_id */
public class VideoServerEvents$NetworkAccessEndedEvent extends TypedEvent<Handler> {
    public final void m5792a(TypedHandler typedHandler) {
        ((Handler) typedHandler).m5613b();
    }
}
