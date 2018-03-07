package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import javax.annotation.Nullable;

@GwtIncompatible("NavigableMap")
/* compiled from: camera */
class Maps$TransformedEntriesNavigableMap<K, V1, V2> extends Maps$TransformedEntriesSortedMap<K, V1, V2> implements NavigableMap<K, V2> {
    protected final /* synthetic */ SortedMap mo977a() {
        return m13555b();
    }

    Maps$TransformedEntriesNavigableMap(NavigableMap<K, V1> navigableMap, Maps$EntryTransformer<? super K, ? super V1, V2> maps$EntryTransformer) {
        super(navigableMap, maps$EntryTransformer);
    }

    public Entry<K, V2> ceilingEntry(K k) {
        return m13554a(m13555b().ceilingEntry(k));
    }

    public K ceilingKey(K k) {
        return m13555b().ceilingKey(k);
    }

    public NavigableSet<K> descendingKeySet() {
        return m13555b().descendingKeySet();
    }

    public NavigableMap<K, V2> descendingMap() {
        return Maps.a(m13555b().descendingMap(), this.f7489b);
    }

    public Entry<K, V2> firstEntry() {
        return m13554a(m13555b().firstEntry());
    }

    public Entry<K, V2> floorEntry(K k) {
        return m13554a(m13555b().floorEntry(k));
    }

    public K floorKey(K k) {
        return m13555b().floorKey(k);
    }

    public SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    public NavigableMap<K, V2> headMap(K k, boolean z) {
        return Maps.a(m13555b().headMap(k, z), this.f7489b);
    }

    public Entry<K, V2> higherEntry(K k) {
        return m13554a(m13555b().higherEntry(k));
    }

    public K higherKey(K k) {
        return m13555b().higherKey(k);
    }

    public Entry<K, V2> lastEntry() {
        return m13554a(m13555b().lastEntry());
    }

    public Entry<K, V2> lowerEntry(K k) {
        return m13554a(m13555b().lowerEntry(k));
    }

    public K lowerKey(K k) {
        return m13555b().lowerKey(k);
    }

    public NavigableSet<K> navigableKeySet() {
        return m13555b().navigableKeySet();
    }

    public Entry<K, V2> pollFirstEntry() {
        return m13554a(m13555b().pollFirstEntry());
    }

    public Entry<K, V2> pollLastEntry() {
        return m13554a(m13555b().pollLastEntry());
    }

    public NavigableMap<K, V2> subMap(K k, boolean z, K k2, boolean z2) {
        return Maps.a(m13555b().subMap(k, z, k2, z2), this.f7489b);
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    public SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }

    public NavigableMap<K, V2> tailMap(K k, boolean z) {
        return Maps.a(m13555b().tailMap(k, z), this.f7489b);
    }

    @Nullable
    private Entry<K, V2> m13554a(@Nullable Entry<K, V1> entry) {
        return entry == null ? null : Maps.a(this.f7489b, entry);
    }

    private NavigableMap<K, V1> m13555b() {
        return (NavigableMap) super.mo977a();
    }
}
