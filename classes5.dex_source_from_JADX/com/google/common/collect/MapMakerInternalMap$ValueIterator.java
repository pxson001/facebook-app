package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap.HashIterator;

/* compiled from: bulk_claim_importer */
final class MapMakerInternalMap$ValueIterator extends HashIterator<V> {
    final /* synthetic */ MapMakerInternalMap f7453a;

    MapMakerInternalMap$ValueIterator(MapMakerInternalMap mapMakerInternalMap) {
        this.f7453a = mapMakerInternalMap;
        super(mapMakerInternalMap);
    }

    public final V next() {
        return a().getValue();
    }
}
