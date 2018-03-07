package com.facebook.video.server.prefetcher;

import com.facebook.common.eventbus.TypedEvent;
import com.facebook.common.eventbus.TypedHandler;

/* compiled from: ShowDeleteOptionKey */
public abstract class PrefetchEvents$BasePrefetchEvent<Handler extends TypedHandler> extends TypedEvent<Handler> {
    public final int f371a;

    public PrefetchEvents$BasePrefetchEvent(int i) {
        this.f371a = i;
    }
}
