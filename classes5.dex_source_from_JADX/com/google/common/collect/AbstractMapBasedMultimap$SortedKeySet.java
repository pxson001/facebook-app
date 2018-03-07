package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap.KeySet;
import java.util.Collection;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

/* compiled from: cameraTargetLng */
class AbstractMapBasedMultimap$SortedKeySet extends KeySet implements SortedSet<K> {
    final /* synthetic */ AbstractMapBasedMultimap f7272b;

    AbstractMapBasedMultimap$SortedKeySet(AbstractMapBasedMultimap abstractMapBasedMultimap, SortedMap<K, Collection<V>> sortedMap) {
        this.f7272b = abstractMapBasedMultimap;
        super(abstractMapBasedMultimap, sortedMap);
    }

    private SortedMap<K, Collection<V>> m13219b() {
        return (SortedMap) super.a();
    }

    public Comparator<? super K> comparator() {
        return m13219b().comparator();
    }

    public K first() {
        return m13219b().firstKey();
    }

    public SortedSet<K> headSet(K k) {
        return new AbstractMapBasedMultimap$SortedKeySet(this.f7272b, m13219b().headMap(k));
    }

    public K last() {
        return m13219b().lastKey();
    }

    public SortedSet<K> subSet(K k, K k2) {
        return new AbstractMapBasedMultimap$SortedKeySet(this.f7272b, m13219b().subMap(k, k2));
    }

    public SortedSet<K> tailSet(K k) {
        return new AbstractMapBasedMultimap$SortedKeySet(this.f7272b, m13219b().tailMap(k));
    }
}
