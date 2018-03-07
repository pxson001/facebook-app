package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedMap;

/* compiled from: camera */
public class Maps$TransformedEntriesSortedMap<K, V1, V2> extends Maps$TransformedEntriesMap<K, V1, V2> implements SortedMap<K, V2> {
    protected SortedMap<K, V1> mo977a() {
        return (SortedMap) this.f7488a;
    }

    public Maps$TransformedEntriesSortedMap(SortedMap<K, V1> sortedMap, Maps$EntryTransformer<? super K, ? super V1, V2> maps$EntryTransformer) {
        super(sortedMap, maps$EntryTransformer);
    }

    public Comparator<? super K> comparator() {
        return mo977a().comparator();
    }

    public K firstKey() {
        return mo977a().firstKey();
    }

    public SortedMap<K, V2> headMap(K k) {
        return Platform.a(mo977a().headMap(k), this.f7489b);
    }

    public K lastKey() {
        return mo977a().lastKey();
    }

    public SortedMap<K, V2> subMap(K k, K k2) {
        return Platform.a(mo977a().subMap(k, k2), this.f7489b);
    }

    public SortedMap<K, V2> tailMap(K k) {
        return Platform.a(mo977a().tailMap(k), this.f7489b);
    }
}
