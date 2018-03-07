package com.google.common.collect;

import com.google.common.collect.Maps.KeySet;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

/* compiled from: camera */
class Maps$SortedKeySet<K, V> extends KeySet<K, V> implements SortedSet<K> {
    /* synthetic */ Map mo960a() {
        return mo961b();
    }

    Maps$SortedKeySet(SortedMap<K, V> sortedMap) {
        super(sortedMap);
    }

    SortedMap<K, V> mo961b() {
        return (SortedMap) super.a();
    }

    public Comparator<? super K> comparator() {
        return mo961b().comparator();
    }

    public SortedSet<K> subSet(K k, K k2) {
        return new Maps$SortedKeySet(mo961b().subMap(k, k2));
    }

    public SortedSet<K> headSet(K k) {
        return new Maps$SortedKeySet(mo961b().headMap(k));
    }

    public SortedSet<K> tailSet(K k) {
        return new Maps$SortedKeySet(mo961b().tailMap(k));
    }

    public K first() {
        return mo961b().firstKey();
    }

    public K last() {
        return mo961b().lastKey();
    }
}
