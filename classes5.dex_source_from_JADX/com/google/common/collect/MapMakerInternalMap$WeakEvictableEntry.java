package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap.ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap.WeakEntry;
import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

/* compiled from: bulk_claim_importer */
final class MapMakerInternalMap$WeakEvictableEntry<K, V> extends WeakEntry<K, V> implements ReferenceEntry<K, V> {
    ReferenceEntry<K, V> f7455d = MapMakerInternalMap$NullEntry.INSTANCE;
    ReferenceEntry<K, V> f7456e = MapMakerInternalMap$NullEntry.INSTANCE;

    MapMakerInternalMap$WeakEvictableEntry(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        super(referenceQueue, k, i, referenceEntry);
    }

    public final ReferenceEntry<K, V> getNextEvictable() {
        return this.f7455d;
    }

    public final void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
        this.f7455d = referenceEntry;
    }

    public final ReferenceEntry<K, V> getPreviousEvictable() {
        return this.f7456e;
    }

    public final void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
        this.f7456e = referenceEntry;
    }
}
