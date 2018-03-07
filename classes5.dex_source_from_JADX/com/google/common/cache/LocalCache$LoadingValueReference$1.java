package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.cache.LocalCache.LoadingValueReference;

/* compiled from: campaign_title */
class LocalCache$LoadingValueReference$1 implements Function<V, V> {
    final /* synthetic */ LoadingValueReference f7202a;

    LocalCache$LoadingValueReference$1(LoadingValueReference loadingValueReference) {
        this.f7202a = loadingValueReference;
    }

    public V apply(V v) {
        this.f7202a.b(v);
        return v;
    }
}
