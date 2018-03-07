package com.google.common.collect;

import com.google.common.collect.MapDifference.ValueDifference;
import java.util.Map;
import java.util.SortedMap;

/* compiled from: camera */
public class Maps$SortedMapDifferenceImpl<K, V> extends Maps$MapDifferenceImpl<K, V> implements SortedMapDifference<K, V> {
    Maps$SortedMapDifferenceImpl(SortedMap<K, V> sortedMap, SortedMap<K, V> sortedMap2, SortedMap<K, V> sortedMap3, SortedMap<K, ValueDifference<V>> sortedMap4) {
        super(sortedMap, sortedMap2, sortedMap3, sortedMap4);
    }

    public final Map mo976d() {
        return (SortedMap) super.mo976d();
    }

    public final Map mo975c() {
        return (SortedMap) super.mo975c();
    }

    public final Map mo973a() {
        return (SortedMap) super.mo973a();
    }

    public final Map mo974b() {
        return (SortedMap) super.mo974b();
    }
}
