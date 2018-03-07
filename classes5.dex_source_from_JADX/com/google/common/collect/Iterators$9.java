package com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: button_dropdown */
final class Iterators$9 implements Iterator<T> {
    final /* synthetic */ int f7361a;
    final /* synthetic */ Iterator f7362b;
    private int f7363c;

    Iterators$9(int i, Iterator it) {
        this.f7361a = i;
        this.f7362b = it;
    }

    public final boolean hasNext() {
        return this.f7363c < this.f7361a && this.f7362b.hasNext();
    }

    public final T next() {
        if (hasNext()) {
            this.f7363c++;
            return this.f7362b.next();
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        this.f7362b.remove();
    }
}
