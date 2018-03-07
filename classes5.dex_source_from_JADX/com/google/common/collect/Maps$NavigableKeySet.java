package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtIncompatible("NavigableMap")
/* compiled from: camera */
class Maps$NavigableKeySet<K, V> extends Maps$SortedKeySet<K, V> implements NavigableSet<K> {
    final /* synthetic */ Map mo960a() {
        return m13533c();
    }

    final /* synthetic */ SortedMap mo961b() {
        return m13533c();
    }

    Maps$NavigableKeySet(NavigableMap<K, V> navigableMap) {
        super(navigableMap);
    }

    private NavigableMap<K, V> m13533c() {
        return (NavigableMap) this.c;
    }

    public K lower(K k) {
        return m13533c().lowerKey(k);
    }

    public K floor(K k) {
        return m13533c().floorKey(k);
    }

    public K ceiling(K k) {
        return m13533c().ceilingKey(k);
    }

    public K higher(K k) {
        return m13533c().higherKey(k);
    }

    public K pollFirst() {
        return Maps.b(m13533c().pollFirstEntry());
    }

    public K pollLast() {
        return Maps.b(m13533c().pollLastEntry());
    }

    public NavigableSet<K> descendingSet() {
        return m13533c().descendingKeySet();
    }

    public Iterator<K> descendingIterator() {
        return descendingSet().iterator();
    }

    public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
        return m13533c().subMap(k, z, k2, z2).navigableKeySet();
    }

    public NavigableSet<K> headSet(K k, boolean z) {
        return m13533c().headMap(k, z).navigableKeySet();
    }

    public NavigableSet<K> tailSet(K k, boolean z) {
        return m13533c().tailMap(k, z).navigableKeySet();
    }

    public SortedSet<K> subSet(K k, K k2) {
        return subSet(k, true, k2, false);
    }

    public SortedSet<K> headSet(K k) {
        return headSet(k, false);
    }

    public SortedSet<K> tailSet(K k) {
        return tailSet(k, true);
    }
}
