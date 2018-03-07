package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Maps.FilteredMapValues;
import com.google.common.collect.Maps.ViewCachingAbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: log_eligibility_waterfall */
public abstract class Maps$AbstractFilteredMap<K, V> extends ViewCachingAbstractMap<K, V> {
    public final Map<K, V> f10754a;
    public final Predicate<? super Entry<K, V>> f10755b;

    Maps$AbstractFilteredMap(Map<K, V> map, Predicate<? super Entry<K, V>> predicate) {
        this.f10754a = map;
        this.f10755b = predicate;
    }

    final boolean m11197b(@Nullable Object obj, @Nullable V v) {
        return this.f10755b.apply(Maps.a(obj, v));
    }

    public V put(K k, V v) {
        Preconditions.checkArgument(m11197b(k, v));
        return this.f10754a.put(k, v);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Entry entry : map.entrySet()) {
            Preconditions.checkArgument(m11197b(entry.getKey(), entry.getValue()));
        }
        this.f10754a.putAll(map);
    }

    public boolean containsKey(Object obj) {
        return this.f10754a.containsKey(obj) && m11197b(obj, this.f10754a.get(obj));
    }

    public V get(Object obj) {
        V v = this.f10754a.get(obj);
        return (v == null || !m11197b(obj, v)) ? null : v;
    }

    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    public V remove(Object obj) {
        return containsKey(obj) ? this.f10754a.remove(obj) : null;
    }

    final Collection<V> m11198d() {
        return new FilteredMapValues(this, this.f10754a, this.f10755b);
    }
}
