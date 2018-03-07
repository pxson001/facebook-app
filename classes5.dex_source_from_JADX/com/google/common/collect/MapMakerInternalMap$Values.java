package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Iterator;

/* compiled from: bulk_claim_importer */
final class MapMakerInternalMap$Values extends AbstractCollection<V> {
    final /* synthetic */ MapMakerInternalMap f7454a;

    MapMakerInternalMap$Values(MapMakerInternalMap mapMakerInternalMap) {
        this.f7454a = mapMakerInternalMap;
    }

    public final Iterator<V> iterator() {
        return new MapMakerInternalMap$ValueIterator(this.f7454a);
    }

    public final int size() {
        return this.f7454a.size();
    }

    public final boolean isEmpty() {
        return this.f7454a.isEmpty();
    }

    public final boolean contains(Object obj) {
        return this.f7454a.containsValue(obj);
    }

    public final void clear() {
        this.f7454a.clear();
    }

    public final Object[] toArray() {
        return MapMakerInternalMap.b(this).toArray();
    }

    public final <E> E[] toArray(E[] eArr) {
        return MapMakerInternalMap.b(this).toArray(eArr);
    }
}
