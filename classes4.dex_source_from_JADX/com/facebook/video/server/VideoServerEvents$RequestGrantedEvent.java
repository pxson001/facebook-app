package com.facebook.video.server;

import com.facebook.common.eventbus.TypedEvent;
import com.facebook.common.eventbus.TypedHandler;
import com.facebook.video.engine.texview.InitializationSequenceLogger.Handler;

/* compiled from: peer_id */
public class VideoServerEvents$RequestGrantedEvent extends TypedEvent<Handler> {
    public final void m5789a(TypedHandler typedHandler) {
        ((Handler) typedHandler).m5614c();
    }
}
