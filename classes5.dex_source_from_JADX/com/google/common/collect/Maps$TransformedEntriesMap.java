package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps.IteratorBasedAbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: camera */
public class Maps$TransformedEntriesMap<K, V1, V2> extends IteratorBasedAbstractMap<K, V2> {
    final Map<K, V1> f7488a;
    final Maps$EntryTransformer<? super K, ? super V1, V2> f7489b;

    Maps$TransformedEntriesMap(Map<K, V1> map, Maps$EntryTransformer<? super K, ? super V1, V2> maps$EntryTransformer) {
        this.f7488a = (Map) Preconditions.checkNotNull(map);
        this.f7489b = (Maps$EntryTransformer) Preconditions.checkNotNull(maps$EntryTransformer);
    }

    public int size() {
        return this.f7488a.size();
    }

    public boolean containsKey(Object obj) {
        return this.f7488a.containsKey(obj);
    }

    public V2 get(Object obj) {
        Object obj2 = this.f7488a.get(obj);
        return (obj2 != null || this.f7488a.containsKey(obj)) ? this.f7489b.m13527a(obj, obj2) : null;
    }

    public V2 remove(Object obj) {
        return this.f7488a.containsKey(obj) ? this.f7489b.m13527a(obj, this.f7488a.remove(obj)) : null;
    }

    public void clear() {
        this.f7488a.clear();
    }

    public Set<K> keySet() {
        return this.f7488a.keySet();
    }

    final Iterator<Entry<K, V2>> m13552d() {
        Iterator it = this.f7488a.entrySet().iterator();
        Maps$EntryTransformer maps$EntryTransformer = this.f7489b;
        Preconditions.checkNotNull(maps$EntryTransformer);
        return Iterators.a(it, new Maps$11(maps$EntryTransformer));
    }

    public Collection<V2> values() {
        return new Maps$Values(this);
    }
}
