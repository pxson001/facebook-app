package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps.FilteredEntryMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import javax.annotation.Nullable;

@GwtIncompatible("NavigableMap")
/* compiled from: camera */
public class Maps$FilteredEntryNavigableMap<K, V> extends AbstractNavigableMap<K, V> {
    public final NavigableMap<K, V> f7476a;
    public final Predicate<? super Entry<K, V>> f7477b;
    private final Map<K, V> f7478c;

    public Maps$FilteredEntryNavigableMap(NavigableMap<K, V> navigableMap, Predicate<? super Entry<K, V>> predicate) {
        this.f7476a = (NavigableMap) Preconditions.checkNotNull(navigableMap);
        this.f7477b = predicate;
        this.f7478c = new FilteredEntryMap(navigableMap, predicate);
    }

    public Comparator<? super K> comparator() {
        return this.f7476a.comparator();
    }

    public NavigableSet<K> navigableKeySet() {
        return new Maps$NavigableKeySet<K, V>(this, this) {
            final /* synthetic */ Maps$FilteredEntryNavigableMap f7475a;

            public boolean removeAll(Collection<?> collection) {
                return Iterators.a(this.f7475a.f7476a.entrySet().iterator(), Predicates.and(this.f7475a.f7477b, Maps.a(Predicates.in(collection))));
            }

            public boolean retainAll(Collection<?> collection) {
                return Iterators.a(this.f7475a.f7476a.entrySet().iterator(), Predicates.and(this.f7475a.f7477b, Maps.a(Predicates.not(Predicates.in(collection)))));
            }
        };
    }

    public Collection<V> values() {
        return new Maps$FilteredMapValues(this, this.f7476a, this.f7477b);
    }

    final Iterator<Entry<K, V>> m13537d() {
        return Iterators.b(this.f7476a.entrySet().iterator(), this.f7477b);
    }

    final Iterator<Entry<K, V>> mo965a() {
        return Iterators.b(this.f7476a.descendingMap().entrySet().iterator(), this.f7477b);
    }

    public int size() {
        return this.f7478c.size();
    }

    public boolean isEmpty() {
        return !Iterables.d(this.f7476a.entrySet(), this.f7477b);
    }

    @Nullable
    public V get(@Nullable Object obj) {
        return this.f7478c.get(obj);
    }

    public boolean containsKey(@Nullable Object obj) {
        return this.f7478c.containsKey(obj);
    }

    public V put(K k, V v) {
        return this.f7478c.put(k, v);
    }

    public V remove(@Nullable Object obj) {
        return this.f7478c.remove(obj);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        this.f7478c.putAll(map);
    }

    public void clear() {
        this.f7478c.clear();
    }

    public Set<Entry<K, V>> entrySet() {
        return this.f7478c.entrySet();
    }

    public Entry<K, V> pollFirstEntry() {
        return (Entry) Iterables.b(this.f7476a.entrySet(), this.f7477b);
    }

    public Entry<K, V> pollLastEntry() {
        return (Entry) Iterables.b(this.f7476a.descendingMap().entrySet(), this.f7477b);
    }

    public NavigableMap<K, V> descendingMap() {
        return Maps.a(this.f7476a.descendingMap(), this.f7477b);
    }

    public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
        return Maps.a(this.f7476a.subMap(k, z, k2, z2), this.f7477b);
    }

    public NavigableMap<K, V> headMap(K k, boolean z) {
        return Maps.a(this.f7476a.headMap(k, z), this.f7477b);
    }

    public NavigableMap<K, V> tailMap(K k, boolean z) {
        return Maps.a(this.f7476a.tailMap(k, z), this.f7477b);
    }
}
