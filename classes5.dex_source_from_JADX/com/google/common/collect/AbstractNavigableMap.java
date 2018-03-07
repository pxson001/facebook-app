package com.google.common.collect;

import com.google.common.collect.Maps.IteratorBasedAbstractMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.Nullable;

/* compiled from: calling_process_name */
abstract class AbstractNavigableMap<K, V> extends IteratorBasedAbstractMap<K, V> implements NavigableMap<K, V> {

    /* compiled from: calling_process_name */
    final class DescendingMap extends Maps$DescendingMap<K, V> {
        final /* synthetic */ AbstractNavigableMap f7286a;

        public DescendingMap(AbstractNavigableMap abstractNavigableMap) {
            this.f7286a = abstractNavigableMap;
        }

        final NavigableMap<K, V> mo892b() {
            return this.f7286a;
        }

        final Iterator<Entry<K, V>> mo893c() {
            return this.f7286a.mo965a();
        }
    }

    abstract Iterator<Entry<K, V>> mo965a();

    AbstractNavigableMap() {
    }

    @Nullable
    public Entry<K, V> firstEntry() {
        return (Entry) Iterators.b(d(), null);
    }

    @Nullable
    public Entry<K, V> lastEntry() {
        return (Entry) Iterators.b(mo965a(), null);
    }

    @Nullable
    public Entry<K, V> pollFirstEntry() {
        return (Entry) Iterators.g(d());
    }

    @Nullable
    public Entry<K, V> pollLastEntry() {
        return (Entry) Iterators.g(mo965a());
    }

    public K firstKey() {
        Entry firstEntry = firstEntry();
        if (firstEntry != null) {
            return firstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    public K lastKey() {
        Entry lastEntry = lastEntry();
        if (lastEntry != null) {
            return lastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @Nullable
    public Entry<K, V> lowerEntry(K k) {
        return headMap(k, false).lastEntry();
    }

    @Nullable
    public Entry<K, V> floorEntry(K k) {
        return headMap(k, true).lastEntry();
    }

    @Nullable
    public Entry<K, V> ceilingEntry(K k) {
        return tailMap(k, true).firstEntry();
    }

    @Nullable
    public Entry<K, V> higherEntry(K k) {
        return tailMap(k, false).firstEntry();
    }

    public K lowerKey(K k) {
        return Maps.b(lowerEntry(k));
    }

    public K floorKey(K k) {
        return Maps.b(floorEntry(k));
    }

    public K ceilingKey(K k) {
        return Maps.b(ceilingEntry(k));
    }

    public K higherKey(K k) {
        return Maps.b(higherEntry(k));
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

    public NavigableSet<K> navigableKeySet() {
        return new Maps$NavigableKeySet(this);
    }

    public Set<K> keySet() {
        return navigableKeySet();
    }

    public NavigableSet<K> descendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    public NavigableMap<K, V> descendingMap() {
        return new DescendingMap(this);
    }
}
