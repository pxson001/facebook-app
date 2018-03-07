package com.google.common.collect;

import java.util.Iterator;

/* compiled from: button_icon_image */
final class Iterables$11 extends FluentIterable<T> {
    final /* synthetic */ Iterable f7357a;
    final /* synthetic */ int f7358b;

    Iterables$11(Iterable iterable, int i) {
        this.f7357a = iterable;
        this.f7358b = i;
    }

    public final Iterator<T> iterator() {
        return Iterators.c(this.f7357a.iterator(), this.f7358b);
    }
}
