package com.google.common.collect;

import com.google.j2objc.annotations.Weak;
import java.util.Map.Entry;

/* compiled from: bytes_downloaded */
class ImmutableMultimap$EntryCollection<K, V> extends ImmutableCollection<Entry<K, V>> {
    @Weak
    final ImmutableMultimap<K, V> multimap;

    ImmutableMultimap$EntryCollection(ImmutableMultimap<K, V> immutableMultimap) {
        this.multimap = immutableMultimap;
    }

    public UnmodifiableIterator<Entry<K, V>> iterator() {
        return this.multimap.v();
    }

    boolean isPartialView() {
        return this.multimap.d();
    }

    public int size() {
        return this.multimap.f();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return this.multimap.b(entry.getKey(), entry.getValue());
    }
}
