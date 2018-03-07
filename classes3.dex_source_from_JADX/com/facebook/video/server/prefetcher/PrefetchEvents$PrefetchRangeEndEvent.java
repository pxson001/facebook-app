package com.facebook.video.server.prefetcher;

import com.facebook.common.eventbus.TypedHandler;
import com.facebook.video.server.prefetcher.PrefetchItemSequenceLogger.Handler;

/* compiled from: ShowDeleteOptionKey */
public class PrefetchEvents$PrefetchRangeEndEvent extends PrefetchEvents$BasePrefetchEvent<Handler> {
    public final long f373b;
    public final boolean f374c;

    public final void m338a(TypedHandler typedHandler) {
        ((Handler) typedHandler).m332a(this);
    }

    public PrefetchEvents$PrefetchRangeEndEvent(int i, long j, boolean z) {
        super(i);
        this.f373b = j;
        this.f374c = z;
    }
}
