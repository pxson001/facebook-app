package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap.AsMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: log_event */
class AbstractMapBasedMultimap$AsMap$AsMapIterator implements Iterator<Entry<K, Collection<V>>> {
    final Iterator<Entry<K, Collection<V>>> f9016a = this.f9018c.a.entrySet().iterator();
    Collection<V> f9017b;
    final /* synthetic */ AsMap f9018c;

    AbstractMapBasedMultimap$AsMap$AsMapIterator(AsMap asMap) {
        this.f9018c = asMap;
    }

    public boolean hasNext() {
        return this.f9016a.hasNext();
    }

    public Object next() {
        Entry entry = (Entry) this.f9016a.next();
        this.f9017b = (Collection) entry.getValue();
        AsMap asMap = this.f9018c;
        Object key = entry.getKey();
        return Maps.a(key, asMap.b.a(key, (Collection) entry.getValue()));
    }

    public void remove() {
        this.f9016a.remove();
        this.f9018c.b.b -= this.f9017b.size();
        this.f9017b.clear();
    }
}
