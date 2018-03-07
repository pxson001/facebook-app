package com.facebook.video.server.prefetcher;

import com.facebook.common.eventbus.TypedHandler;
import com.facebook.video.server.prefetcher.PrefetchItemSequenceLogger.Handler;

/* compiled from: ShowDeleteOptionKey */
public class PrefetchEvents$RetrieveMetadataBeginEvent extends PrefetchEvents$BasePrefetchEvent<Handler> {
    public final void m339a(TypedHandler typedHandler) {
        ((Handler) typedHandler).m333a(this);
    }

    public PrefetchEvents$RetrieveMetadataBeginEvent(int i) {
        super(i);
    }
}
