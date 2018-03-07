package com.facebook.pages.common.util;

import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: could not extract ScaleType from =  */
public class PagesCacheEntry<V> {
    private final V f16888a;
    public final long f16889b;

    PagesCacheEntry(V v, long j) {
        this.f16888a = v;
        this.f16889b = j;
    }

    public final V m20184a() {
        return this.f16888a;
    }

    public final long m20185b() {
        return this.f16889b;
    }
}
