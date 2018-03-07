package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps.FilteredEntryMap;
import com.google.common.collect.Maps.FilteredEntryMap.KeySet;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* compiled from: camera */
public class Maps$FilteredEntrySortedMap<K, V> extends FilteredEntryMap<K, V> implements SortedMap<K, V> {

    /* compiled from: camera */
    class SortedKeySet extends KeySet implements SortedSet<K> {
        final /* synthetic */ Maps$FilteredEntrySortedMap f7479b;

        SortedKeySet(Maps$FilteredEntrySortedMap maps$FilteredEntrySortedMap) {
            this.f7479b = maps$FilteredEntrySortedMap;
            super(maps$FilteredEntrySortedMap);
        }

        public Comparator<? super K> comparator() {
            return this.f7479b.m13540c().comparator();
        }

        public SortedSet<K> subSet(K k, K k2) {
            return (SortedSet) this.f7479b.subMap(k, k2).keySet();
        }

        public SortedSet<K> headSet(K k) {
            return (SortedSet) this.f7479b.headMap(k).keySet();
        }

        public SortedSet<K> tailSet(K k) {
            return (SortedSet) this.f7479b.tailMap(k).keySet();
        }

        public K first() {
            return this.f7479b.firstKey();
        }

        public K last() {
            return this.f7479b.lastKey();
        }
    }

    public /* synthetic */ Set keySet() {
        return m13538e();
    }

    public Maps$FilteredEntrySortedMap(SortedMap<K, V> sortedMap, Predicate<? super Entry<K, V>> predicate) {
        super(sortedMap, predicate);
    }

    public final SortedMap<K, V> m13540c() {
        return (SortedMap) this.a;
    }

    private SortedSet<K> m13538e() {
        return (SortedSet) super.keySet();
    }

    final Set m13539b() {
        return new SortedKeySet(this);
    }

    public Comparator<? super K> comparator() {
        return m13540c().comparator();
    }

    public K firstKey() {
        return m13538e().iterator().next();
    }

    public K lastKey() {
        SortedMap c = m13540c();
        while (true) {
            K lastKey = c.lastKey();
            if (b(lastKey, this.a.get(lastKey))) {
                return lastKey;
            }
            c = m13540c().headMap(lastKey);
        }
    }

    public SortedMap<K, V> headMap(K k) {
        return new Maps$FilteredEntrySortedMap(m13540c().headMap(k), this.b);
    }

    public SortedMap<K, V> subMap(K k, K k2) {
        return new Maps$FilteredEntrySortedMap(m13540c().subMap(k, k2), this.b);
    }

    public SortedMap<K, V> tailMap(K k) {
        return new Maps$FilteredEntrySortedMap(m13540c().tailMap(k), this.b);
    }
}
