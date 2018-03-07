package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap.ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap.ValueReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: bulk_claim_importer */
final class MapMakerInternalMap$WeakValueReference<K, V> extends WeakReference<V> implements ValueReference<K, V> {
    final ReferenceEntry<K, V> f7465a;

    MapMakerInternalMap$WeakValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
        super(v, referenceQueue);
        this.f7465a = referenceEntry;
    }

    public final ReferenceEntry<K, V> m13521a() {
        return this.f7465a;
    }

    public final void m13524c() {
        clear();
    }

    public final ValueReference<K, V> m13522a(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
        return new MapMakerInternalMap$WeakValueReference(referenceQueue, v, referenceEntry);
    }

    public final boolean m13523b() {
        return false;
    }
}
