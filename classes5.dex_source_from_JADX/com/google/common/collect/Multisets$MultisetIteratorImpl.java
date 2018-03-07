package com.google.common.collect;

import com.google.common.collect.Multiset.Entry;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: cameraTargetLat */
final class Multisets$MultisetIteratorImpl<E> implements Iterator<E> {
    private final Multiset<E> f7521a;
    private final Iterator<Entry<E>> f7522b;
    private Entry<E> f7523c;
    private int f7524d;
    private int f7525e;
    private boolean f7526f;

    Multisets$MultisetIteratorImpl(Multiset<E> multiset, Iterator<Entry<E>> it) {
        this.f7521a = multiset;
        this.f7522b = it;
    }

    public final boolean hasNext() {
        return this.f7524d > 0 || this.f7522b.hasNext();
    }

    public final E next() {
        if (hasNext()) {
            if (this.f7524d == 0) {
                this.f7523c = (Multisets$AbstractEntry) this.f7522b.next();
                int b = this.f7523c.mo890b();
                this.f7524d = b;
                this.f7525e = b;
            }
            this.f7524d--;
            this.f7526f = true;
            return this.f7523c.mo889a();
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        CollectPreconditions.a(this.f7526f);
        if (this.f7525e == 1) {
            this.f7522b.remove();
        } else {
            this.f7521a.remove(this.f7523c.mo889a());
        }
        this.f7525e--;
        this.f7526f = false;
    }
}
