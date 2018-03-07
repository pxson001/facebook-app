package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap.ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap.WeakEntry;
import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

/* compiled from: bulk_claim_importer */
final class MapMakerInternalMap$WeakExpirableEvictableEntry<K, V> extends WeakEntry<K, V> implements ReferenceEntry<K, V> {
    volatile long f7460d = Long.MAX_VALUE;
    ReferenceEntry<K, V> f7461e = MapMakerInternalMap$NullEntry.INSTANCE;
    ReferenceEntry<K, V> f7462f = MapMakerInternalMap$NullEntry.INSTANCE;
    ReferenceEntry<K, V> f7463g = MapMakerInternalMap$NullEntry.INSTANCE;
    ReferenceEntry<K, V> f7464h = MapMakerInternalMap$NullEntry.INSTANCE;

    MapMakerInternalMap$WeakExpirableEvictableEntry(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        super(referenceQueue, k, i, referenceEntry);
    }

    public final long getExpirationTime() {
        return this.f7460d;
    }

    public final void setExpirationTime(long j) {
        this.f7460d = j;
    }

    public final ReferenceEntry<K, V> getNextExpirable() {
        return this.f7461e;
    }

    public final void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
        this.f7461e = referenceEntry;
    }

    public final ReferenceEntry<K, V> getPreviousExpirable() {
        return this.f7462f;
    }

    public final void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
        this.f7462f = referenceEntry;
    }

    public final ReferenceEntry<K, V> getNextEvictable() {
        return this.f7463g;
    }

    public final void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
        this.f7463g = referenceEntry;
    }

    public final ReferenceEntry<K, V> getPreviousEvictable() {
        return this.f7464h;
    }

    public final void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
        this.f7464h = referenceEntry;
    }
}
