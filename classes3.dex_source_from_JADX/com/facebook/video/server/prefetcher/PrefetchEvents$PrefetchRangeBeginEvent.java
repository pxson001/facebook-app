package com.facebook.video.server.prefetcher;

import com.facebook.common.eventbus.TypedHandler;
import com.facebook.ui.media.cache.Range;
import com.facebook.video.server.prefetcher.PrefetchItemSequenceLogger.Handler;

/* compiled from: ShowDeleteOptionKey */
public class PrefetchEvents$PrefetchRangeBeginEvent extends PrefetchEvents$BasePrefetchEvent<Handler> {
    public final Range f372b;

    public final void m337a(TypedHandler typedHandler) {
        ((Handler) typedHandler).m331a(this);
    }

    public PrefetchEvents$PrefetchRangeBeginEvent(int i, Range range) {
        super(i);
        this.f372b = range;
    }
}
