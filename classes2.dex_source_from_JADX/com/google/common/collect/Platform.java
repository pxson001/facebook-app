package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import com.google.common.collect.Maps.EntryTransformer;
import com.google.common.collect.Maps.TransformedEntriesSortedMap;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible
/* compiled from: zero_status_to_update */
public final class Platform {
    public static <T> T[] m648a(T[] tArr, int i) {
        return (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
    }

    public static <E> Set<E> m644a(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <K, V1, V2> SortedMap<K, V2> m646a(SortedMap<K, V1> sortedMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        if (sortedMap instanceof NavigableMap) {
            return Maps.m822a((NavigableMap) sortedMap, (EntryTransformer) entryTransformer);
        }
        return new TransformedEntriesSortedMap(sortedMap, entryTransformer);
    }

    static <E> SortedSet<E> m647a(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
        if (sortedSet instanceof NavigableSet) {
            return Sets.m1316a((NavigableSet) sortedSet, (Predicate) predicate);
        }
        return Sets.m1318a((SortedSet) sortedSet, (Predicate) predicate);
    }

    public static <K, V> SortedMap<K, V> m645a(SortedMap<K, V> sortedMap, Predicate<? super Entry<K, V>> predicate) {
        if (sortedMap instanceof NavigableMap) {
            return Maps.m821a((NavigableMap) sortedMap, (Predicate) predicate);
        }
        return Maps.m823a((SortedMap) sortedMap, (Predicate) predicate);
    }

    private Platform() {
    }
}
