package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap.ReferenceEntry;
import javax.annotation.Nullable;

/* compiled from: bulk_claim_importer */
final class MapMakerInternalMap$StrongExpirableEvictableEntry<K, V> extends MapMakerInternalMap$StrongEntry<K, V> implements ReferenceEntry<K, V> {
    volatile long f7448e = Long.MAX_VALUE;
    ReferenceEntry<K, V> f7449f = MapMakerInternalMap$NullEntry.INSTANCE;
    ReferenceEntry<K, V> f7450g = MapMakerInternalMap$NullEntry.INSTANCE;
    ReferenceEntry<K, V> f7451h = MapMakerInternalMap$NullEntry.INSTANCE;
    ReferenceEntry<K, V> f7452i = MapMakerInternalMap$NullEntry.INSTANCE;

    MapMakerInternalMap$StrongExpirableEvictableEntry(K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        super(k, i, referenceEntry);
    }

    public final long getExpirationTime() {
        return this.f7448e;
    }

    public final void setExpirationTime(long j) {
        this.f7448e = j;
    }

    public final ReferenceEntry<K, V> getNextExpirable() {
        return this.f7449f;
    }

    public final void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
        this.f7449f = referenceEntry;
    }

    public final ReferenceEntry<K, V> getPreviousExpirable() {
        return this.f7450g;
    }

    public final void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
        this.f7450g = referenceEntry;
    }

    public final ReferenceEntry<K, V> getNextEvictable() {
        return this.f7451h;
    }

    public final void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
        this.f7451h = referenceEntry;
    }

    public final ReferenceEntry<K, V> getPreviousEvictable() {
        return this.f7452i;
    }

    public final void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
        this.f7452i = referenceEntry;
    }
}
