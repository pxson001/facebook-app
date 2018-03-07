package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap.AsMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* compiled from: cameraTargetLng */
class AbstractMapBasedMultimap$SortedAsMap extends AsMap implements SortedMap<K, Collection<V>> {
    SortedSet<K> f7270c;
    final /* synthetic */ AbstractMapBasedMultimap f7271d;

    final /* synthetic */ Set m13218b() {
        return m13217f();
    }

    AbstractMapBasedMultimap$SortedAsMap(AbstractMapBasedMultimap abstractMapBasedMultimap, SortedMap<K, Collection<V>> sortedMap) {
        this.f7271d = abstractMapBasedMultimap;
        super(abstractMapBasedMultimap, sortedMap);
    }

    private SortedMap<K, Collection<V>> m13216c() {
        return (SortedMap) this.a;
    }

    public Comparator<? super K> comparator() {
        return m13216c().comparator();
    }

    public K firstKey() {
        return m13216c().firstKey();
    }

    public K lastKey() {
        return m13216c().lastKey();
    }

    public SortedMap<K, Collection<V>> headMap(K k) {
        return new AbstractMapBasedMultimap$SortedAsMap(this.f7271d, m13216c().headMap(k));
    }

    public SortedMap<K, Collection<V>> subMap(K k, K k2) {
        return new AbstractMapBasedMultimap$SortedAsMap(this.f7271d, m13216c().subMap(k, k2));
    }

    public SortedMap<K, Collection<V>> tailMap(K k) {
        return new AbstractMapBasedMultimap$SortedAsMap(this.f7271d, m13216c().tailMap(k));
    }

    public Set keySet() {
        Set set = this.f7270c;
        if (set != null) {
            return set;
        }
        set = m13217f();
        this.f7270c = set;
        return set;
    }

    private SortedSet<K> m13217f() {
        return new AbstractMapBasedMultimap$SortedKeySet(this.f7271d, m13216c());
    }
}
