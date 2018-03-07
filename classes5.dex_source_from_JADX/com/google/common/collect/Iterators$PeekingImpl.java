package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;

/* compiled from: button_dropdown */
class Iterators$PeekingImpl<E> implements PeekingIterator<E> {
    private final Iterator<? extends E> f7364a;
    private boolean f7365b;
    private E f7366c;

    public Iterators$PeekingImpl(Iterator<? extends E> it) {
        this.f7364a = (Iterator) Preconditions.checkNotNull(it);
    }

    public boolean hasNext() {
        return this.f7365b || this.f7364a.hasNext();
    }

    public E next() {
        if (!this.f7365b) {
            return this.f7364a.next();
        }
        E e = this.f7366c;
        this.f7365b = false;
        this.f7366c = null;
        return e;
    }

    public void remove() {
        Preconditions.checkState(!this.f7365b, "Can't remove after you've peeked at next");
        this.f7364a.remove();
    }

    public final E mo932a() {
        if (!this.f7365b) {
            this.f7366c = this.f7364a.next();
            this.f7365b = true;
        }
        return this.f7366c;
    }
}
