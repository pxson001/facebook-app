package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap.ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap.WeakEntry;
import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

/* compiled from: bulk_claim_importer */
final class MapMakerInternalMap$WeakExpirableEntry<K, V> extends WeakEntry<K, V> implements ReferenceEntry<K, V> {
    volatile long f7457d = Long.MAX_VALUE;
    ReferenceEntry<K, V> f7458e = MapMakerInternalMap$NullEntry.INSTANCE;
    ReferenceEntry<K, V> f7459f = MapMakerInternalMap$NullEntry.INSTANCE;

    MapMakerInternalMap$WeakExpirableEntry(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        super(referenceQueue, k, i, referenceEntry);
    }

    public final long getExpirationTime() {
        return this.f7457d;
    }

    public final void setExpirationTime(long j) {
        this.f7457d = j;
    }

    public final ReferenceEntry<K, V> getNextExpirable() {
        return this.f7458e;
    }

    public final void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
        this.f7458e = referenceEntry;
    }

    public final ReferenceEntry<K, V> getPreviousExpirable() {
        return this.f7459f;
    }

    public final void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
        this.f7459f = referenceEntry;
    }
}
