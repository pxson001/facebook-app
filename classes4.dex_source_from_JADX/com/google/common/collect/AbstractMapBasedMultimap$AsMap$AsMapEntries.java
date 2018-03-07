package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap.AsMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: log_event */
class AbstractMapBasedMultimap$AsMap$AsMapEntries extends Maps$EntrySet<K, Collection<V>> {
    final /* synthetic */ AsMap f9015a;

    AbstractMapBasedMultimap$AsMap$AsMapEntries(AsMap asMap) {
        this.f9015a = asMap;
    }

    final Map<K, Collection<V>> mo701a() {
        return this.f9015a;
    }

    public Iterator<Entry<K, Collection<V>>> iterator() {
        return new AbstractMapBasedMultimap$AsMap$AsMapIterator(this.f9015a);
    }

    public boolean contains(Object obj) {
        return Collections2.a(this.f9015a.a.entrySet(), obj);
    }

    public boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        Entry entry = (Entry) obj;
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.f9015a.b;
        Collection collection = (Collection) Maps.c(abstractMapBasedMultimap.a, entry.getKey());
        int i = 0;
        if (collection != null) {
            i = collection.size();
            collection.clear();
            abstractMapBasedMultimap.b -= i;
        }
        int i2 = i;
        return true;
    }
}
