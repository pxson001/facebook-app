package com.facebook.video.server;

import com.facebook.common.eventbus.TypedEvent;
import com.facebook.common.eventbus.TypedHandler;
import com.facebook.video.engine.texview.InitializationSequenceLogger.Handler;
import com.google.common.base.Objects;

/* compiled from: payments/ */
public class VideoServer$VideoIdEvent extends TypedEvent<Handler> {
    public final String f5313a;
    public final TypedEvent<?> f5314b;

    public final void m5847a(TypedHandler typedHandler) {
        Handler handler = (Handler) typedHandler;
        if (Objects.equal(handler.f5164a.f5160h, this.f5313a)) {
            handler.f5164a.f5157e.a(this.f5314b);
        }
    }

    public VideoServer$VideoIdEvent(String str, TypedEvent<?> typedEvent) {
        this.f5313a = str;
        this.f5314b = typedEvent;
    }
}
