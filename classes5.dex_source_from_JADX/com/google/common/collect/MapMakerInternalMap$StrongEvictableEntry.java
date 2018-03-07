package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap.ReferenceEntry;
import javax.annotation.Nullable;

/* compiled from: bulk_claim_importer */
final class MapMakerInternalMap$StrongEvictableEntry<K, V> extends MapMakerInternalMap$StrongEntry<K, V> implements ReferenceEntry<K, V> {
    ReferenceEntry<K, V> f7443e = MapMakerInternalMap$NullEntry.INSTANCE;
    ReferenceEntry<K, V> f7444f = MapMakerInternalMap$NullEntry.INSTANCE;

    MapMakerInternalMap$StrongEvictableEntry(K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        super(k, i, referenceEntry);
    }

    public final ReferenceEntry<K, V> getNextEvictable() {
        return this.f7443e;
    }

    public final void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
        this.f7443e = referenceEntry;
    }

    public final ReferenceEntry<K, V> getPreviousEvictable() {
        return this.f7444f;
    }

    public final void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
        this.f7444f = referenceEntry;
    }
}
