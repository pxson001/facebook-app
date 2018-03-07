package com.facebook.video.server;

import com.facebook.common.eventbus.TypedEvent;
import com.facebook.common.eventbus.TypedHandler;
import com.facebook.video.engine.texview.InitializationSequenceLogger.Handler;
import com.facebook.video.server.VideoServer$VideoServerWorker.RequestLiveInfoImpl;
import com.google.common.base.Preconditions;

/* compiled from: peer_id */
public class VideoServerEvents$RequestBeginEvent extends TypedEvent<Handler> {
    public final RequestLiveInfoImpl f5285a;
    public final long f5286b;

    public final void m5788a(TypedHandler typedHandler) {
        ((Handler) typedHandler).m5612a(this);
    }

    public VideoServerEvents$RequestBeginEvent(RequestLiveInfoImpl requestLiveInfoImpl, long j) {
        this.f5285a = (RequestLiveInfoImpl) Preconditions.checkNotNull(requestLiveInfoImpl);
        this.f5286b = j;
    }
}
