package com.google.common.cache;

import com.google.common.cache.LocalCache.StrongValueReference;

/* compiled from: campaign_title */
final class LocalCache$WeightedStrongValueReference<K, V> extends StrongValueReference<K, V> {
    final int f7233b;

    LocalCache$WeightedStrongValueReference(V v, int i) {
        super(v);
        this.f7233b = i;
    }

    public final int m13170a() {
        return this.f7233b;
    }
}
