package com.google.common.collect;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: cameraBearing */
class AbstractMapBasedMultiset$MapBasedMultisetIterator implements Iterator<E> {
    final Iterator<Entry<E, Count>> f7277a;
    Entry<E, Count> f7278b;
    int f7279c;
    boolean f7280d;
    final /* synthetic */ AbstractMapBasedMultiset f7281e;

    AbstractMapBasedMultiset$MapBasedMultisetIterator(AbstractMapBasedMultiset abstractMapBasedMultiset) {
        this.f7281e = abstractMapBasedMultiset;
        this.f7277a = abstractMapBasedMultiset.a.entrySet().iterator();
    }

    public boolean hasNext() {
        return this.f7279c > 0 || this.f7277a.hasNext();
    }

    public E next() {
        if (this.f7279c == 0) {
            this.f7278b = (Entry) this.f7277a.next();
            this.f7279c = ((Count) this.f7278b.getValue()).value;
        }
        this.f7279c--;
        this.f7280d = true;
        return this.f7278b.getKey();
    }

    public void remove() {
        CollectPreconditions.a(this.f7280d);
        if (((Count) this.f7278b.getValue()).value <= 0) {
            throw new ConcurrentModificationException();
        }
        if (((Count) this.f7278b.getValue()).b(-1) == 0) {
            this.f7277a.remove();
        }
        AbstractMapBasedMultiset abstractMapBasedMultiset = this.f7281e;
        abstractMapBasedMultiset.b--;
        this.f7280d = false;
    }
}
