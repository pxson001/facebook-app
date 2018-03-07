package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap.HashIterator;
import java.util.Map.Entry;

/* compiled from: bulk_claim_importer */
final class MapMakerInternalMap$EntryIterator extends HashIterator<Entry<K, V>> {
    final /* synthetic */ MapMakerInternalMap f7426a;

    MapMakerInternalMap$EntryIterator(MapMakerInternalMap mapMakerInternalMap) {
        this.f7426a = mapMakerInternalMap;
        super(mapMakerInternalMap);
    }

    public final Object next() {
        return a();
    }
}
