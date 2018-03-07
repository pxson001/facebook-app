package com.facebook.video.server.prefetcher;

import com.facebook.common.eventbus.TypedHandler;
import com.facebook.video.server.prefetcher.PrefetchItemSequenceLogger.Handler;

/* compiled from: ShowDeleteOptionKey */
public class PrefetchEvents$PrefetchItemEndEvent extends PrefetchEvents$BasePrefetchEvent<Handler> {
    public final void m336a(TypedHandler typedHandler) {
        ((Handler) typedHandler).m330a(this);
    }

    public PrefetchEvents$PrefetchItemEndEvent(int i) {
        super(i);
    }
}
