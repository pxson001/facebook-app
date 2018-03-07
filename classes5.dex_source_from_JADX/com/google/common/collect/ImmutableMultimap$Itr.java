package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: bytes_downloaded */
abstract class ImmutableMultimap$Itr<T> extends UnmodifiableIterator<T> {
    final Iterator<Entry<K, Collection<V>>> f7328b = this.f7331e.b.entrySet().iterator();
    K f7329c = null;
    Iterator<V> f7330d = Iterators.a;
    final /* synthetic */ ImmutableMultimap f7331e;

    abstract T mo927a(K k, V v);

    public ImmutableMultimap$Itr(ImmutableMultimap immutableMultimap) {
        this.f7331e = immutableMultimap;
    }

    public boolean hasNext() {
        return this.f7328b.hasNext() || this.f7330d.hasNext();
    }

    public T next() {
        if (!this.f7330d.hasNext()) {
            Entry entry = (Entry) this.f7328b.next();
            this.f7329c = entry.getKey();
            this.f7330d = ((Collection) entry.getValue()).iterator();
        }
        return mo927a(this.f7329c, this.f7330d.next());
    }
}
