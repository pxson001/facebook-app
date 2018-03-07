package com.google.common.cache;

import com.google.common.cache.LocalCache.ReferenceEntry;
import com.google.common.cache.LocalCache.ValueReference;
import java.lang.ref.ReferenceQueue;

/* compiled from: campaign_title */
final class LocalCache$WeightedSoftValueReference<K, V> extends LocalCache$SoftValueReference<K, V> {
    final int f7232b;

    LocalCache$WeightedSoftValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry, int i) {
        super(referenceQueue, v, referenceEntry);
        this.f7232b = i;
    }

    public final int mo872a() {
        return this.f7232b;
    }

    public final ValueReference<K, V> mo873a(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
        return new LocalCache$WeightedSoftValueReference(referenceQueue, v, referenceEntry, this.f7232b);
    }
}
