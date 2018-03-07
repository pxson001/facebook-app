package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Maps.EntrySet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;

@GwtIncompatible("NavigableMap")
/* compiled from: camera */
abstract class Maps$DescendingMap<K, V> extends ForwardingMap<K, V> implements NavigableMap<K, V> {
    private transient Comparator<? super K> f7283a;
    private transient Set<Entry<K, V>> f7284b;
    private transient NavigableSet<K> f7285c;

    abstract NavigableMap<K, V> mo892b();

    abstract Iterator<Entry<K, V>> mo893c();

    public String toString() {
        return Maps.c(this);
    }

    protected final /* synthetic */ Object mo880e() {
        return mo877a();
    }

    Maps$DescendingMap() {
    }

    protected final Map<K, V> mo877a() {
        return mo892b();
    }

    public Comparator<? super K> comparator() {
        Comparator<? super K> comparator = this.f7283a;
        if (comparator != null) {
            return comparator;
        }
        Comparator comparator2 = mo892b().comparator();
        if (comparator2 == null) {
            comparator2 = NaturalOrdering.a;
        }
        comparator = Ordering.a(comparator2).a();
        this.f7283a = comparator;
        return comparator;
    }

    public K firstKey() {
        return mo892b().lastKey();
    }

    public K lastKey() {
        return mo892b().firstKey();
    }

    public Entry<K, V> lowerEntry(K k) {
        return mo892b().higherEntry(k);
    }

    public K lowerKey(K k) {
        return mo892b().higherKey(k);
    }

    public Entry<K, V> floorEntry(K k) {
        return mo892b().ceilingEntry(k);
    }

    public K floorKey(K k) {
        return mo892b().ceilingKey(k);
    }

    public Entry<K, V> ceilingEntry(K k) {
        return mo892b().floorEntry(k);
    }

    public K ceilingKey(K k) {
        return mo892b().floorKey(k);
    }

    public Entry<K, V> higherEntry(K k) {
        return mo892b().lowerEntry(k);
    }

    public K higherKey(K k) {
        return mo892b().lowerKey(k);
    }

    public Entry<K, V> firstEntry() {
        return mo892b().lastEntry();
    }

    public Entry<K, V> lastEntry() {
        return mo892b().firstEntry();
    }

    public Entry<K, V> pollFirstEntry() {
        return mo892b().pollLastEntry();
    }

    public Entry<K, V> pollLastEntry() {
        return mo892b().pollFirstEntry();
    }

    public NavigableMap<K, V> descendingMap() {
        return mo892b();
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = this.f7284b;
        if (set != null) {
            return set;
        }
        set = new EntrySet<K, V>(this) {
            final /* synthetic */ Maps$DescendingMap f7472a;

            {
                this.f7472a = r1;
            }

            final Map<K, V> m13526a() {
                return this.f7472a;
            }

            public Iterator<Entry<K, V>> iterator() {
                return this.f7472a.mo893c();
            }
        };
        this.f7284b = set;
        return set;
    }

    public Set<K> keySet() {
        return navigableKeySet();
    }

    public NavigableSet<K> navigableKeySet() {
        NavigableSet<K> navigableSet = this.f7285c;
        if (navigableSet != null) {
            return navigableSet;
        }
        navigableSet = new Maps$NavigableKeySet(this);
        this.f7285c = navigableSet;
        return navigableSet;
    }

    public NavigableSet<K> descendingKeySet() {
        return mo892b().navigableKeySet();
    }

    public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
        return mo892b().subMap(k2, z2, k, z).descendingMap();
    }

    public NavigableMap<K, V> headMap(K k, boolean z) {
        return mo892b().tailMap(k, z).descendingMap();
    }

    public NavigableMap<K, V> tailMap(K k, boolean z) {
        return mo892b().headMap(k, z).descendingMap();
    }

    public SortedMap<K, V> subMap(K k, K k2) {
        return subMap(k, true, k2, false);
    }

    public SortedMap<K, V> headMap(K k) {
        return headMap(k, false);
    }

    public SortedMap<K, V> tailMap(K k) {
        return tailMap(k, true);
    }

    public Collection<V> values() {
        return new Maps$Values(this);
    }
}
