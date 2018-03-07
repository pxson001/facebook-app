package com.google.common.cache;

import com.google.common.cache.LocalCache.ReferenceEntry;
import com.google.common.cache.LocalCache.ValueReference;
import com.google.common.cache.LocalCache.WeakValueReference;
import java.lang.ref.ReferenceQueue;

/* compiled from: campaign_title */
final class LocalCache$WeightedWeakValueReference<K, V> extends WeakValueReference<K, V> {
    final int f7234b;

    LocalCache$WeightedWeakValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry, int i) {
        super(referenceQueue, v, referenceEntry);
        this.f7234b = i;
    }

    public final int m13171a() {
        return this.f7234b;
    }

    public final ValueReference<K, V> m13172a(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
        return new LocalCache$WeightedWeakValueReference(referenceQueue, v, referenceEntry, this.f7234b);
    }
}
