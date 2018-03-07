package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap.ReferenceEntry;
import javax.annotation.Nullable;

/* compiled from: bulk_claim_importer */
final class MapMakerInternalMap$StrongExpirableEntry<K, V> extends MapMakerInternalMap$StrongEntry<K, V> implements ReferenceEntry<K, V> {
    volatile long f7445e = Long.MAX_VALUE;
    ReferenceEntry<K, V> f7446f = MapMakerInternalMap$NullEntry.INSTANCE;
    ReferenceEntry<K, V> f7447g = MapMakerInternalMap$NullEntry.INSTANCE;

    MapMakerInternalMap$StrongExpirableEntry(K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        super(k, i, referenceEntry);
    }

    public final long getExpirationTime() {
        return this.f7445e;
    }

    public final void setExpirationTime(long j) {
        this.f7445e = j;
    }

    public final ReferenceEntry<K, V> getNextExpirable() {
        return this.f7446f;
    }

    public final void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
        this.f7446f = referenceEntry;
    }

    public final ReferenceEntry<K, V> getPreviousExpirable() {
        return this.f7447g;
    }

    public final void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
        this.f7447g = referenceEntry;
    }
}
