package com.google.common.collect;

import com.google.common.collect.HashBiMap.BiEntry;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: cached_feedback_age */
public abstract class HashBiMap$Itr<T> implements Iterator<T> {
    BiEntry<K, V> f7306b = this.f7309e.c;
    BiEntry<K, V> f7307c = null;
    int f7308d = this.f7309e.g;
    final /* synthetic */ HashBiMap f7309e;

    abstract T mo923a(BiEntry<K, V> biEntry);

    HashBiMap$Itr(HashBiMap hashBiMap) {
        this.f7309e = hashBiMap;
    }

    public boolean hasNext() {
        if (this.f7309e.g == this.f7308d) {
            return this.f7306b != null;
        } else {
            throw new ConcurrentModificationException();
        }
    }

    public T next() {
        if (hasNext()) {
            BiEntry biEntry = this.f7306b;
            this.f7306b = biEntry.nextInKeyInsertionOrder;
            this.f7307c = biEntry;
            return mo923a(biEntry);
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        if (this.f7309e.g != this.f7308d) {
            throw new ConcurrentModificationException();
        }
        CollectPreconditions.a(this.f7307c != null);
        HashBiMap.a(this.f7309e, this.f7307c);
        this.f7308d = this.f7309e.g;
        this.f7307c = null;
    }
}
