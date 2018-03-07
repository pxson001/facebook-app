package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap.SafeToArraySet;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: bulk_claim_importer */
final class MapMakerInternalMap$EntrySet extends SafeToArraySet<Entry<K, V>> {
    final /* synthetic */ MapMakerInternalMap f7427a;

    MapMakerInternalMap$EntrySet(MapMakerInternalMap mapMakerInternalMap) {
        this.f7427a = mapMakerInternalMap;
    }

    public final Iterator<Entry<K, V>> iterator() {
        return new MapMakerInternalMap$EntryIterator(this.f7427a);
    }

    public final boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        Object key = entry.getKey();
        if (key == null) {
            return false;
        }
        key = this.f7427a.get(key);
        if (key == null || !this.f7427a.valueEquivalence.equivalent(entry.getValue(), key)) {
            return false;
        }
        return true;
    }

    public final boolean remove(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        Object key = entry.getKey();
        if (key == null || !this.f7427a.remove(key, entry.getValue())) {
            return false;
        }
        return true;
    }

    public final int size() {
        return this.f7427a.size();
    }

    public final boolean isEmpty() {
        return this.f7427a.isEmpty();
    }

    public final void clear() {
        this.f7427a.clear();
    }
}
