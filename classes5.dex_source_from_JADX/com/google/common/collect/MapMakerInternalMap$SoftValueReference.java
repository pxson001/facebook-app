package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap.ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap.ValueReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/* compiled from: bulk_claim_importer */
final class MapMakerInternalMap$SoftValueReference<K, V> extends SoftReference<V> implements ValueReference<K, V> {
    final ReferenceEntry<K, V> f7438a;

    MapMakerInternalMap$SoftValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
        super(v, referenceQueue);
        this.f7438a = referenceEntry;
    }

    public final ReferenceEntry<K, V> m13517a() {
        return this.f7438a;
    }

    public final void m13520c() {
        clear();
    }

    public final ValueReference<K, V> m13518a(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
        return new MapMakerInternalMap$SoftValueReference(referenceQueue, v, referenceEntry);
    }

    public final boolean m13519b() {
        return false;
    }
}
