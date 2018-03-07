package com.facebook.video.server.prefetcher;

import com.facebook.common.eventbus.TypedHandler;
import com.facebook.ui.media.cache.Range;
import com.facebook.video.server.prefetcher.PrefetchItemSequenceLogger.Handler;
import java.util.List;

/* compiled from: ShowDeleteOptionKey */
public class PrefetchEvents$RetrieveMetadataEndEvent extends PrefetchEvents$BasePrefetchEvent<Handler> {
    public final long f375b;
    public final List<Range> f376c;

    public final void m340a(TypedHandler typedHandler) {
        ((Handler) typedHandler).m334a(this);
    }

    public PrefetchEvents$RetrieveMetadataEndEvent(int i, int i2, List<Range> list) {
        super(i);
        this.f375b = (long) i2;
        this.f376c = list;
    }
}
