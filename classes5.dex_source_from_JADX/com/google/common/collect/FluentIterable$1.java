package com.google.common.collect;

import java.util.Iterator;

/* compiled from: callTrees */
final class FluentIterable$1 extends FluentIterable<E> {
    final /* synthetic */ Iterable f7303a;

    FluentIterable$1(Iterable iterable, Iterable iterable2) {
        this.f7303a = iterable2;
        super(iterable);
    }

    public final Iterator<E> iterator() {
        return this.f7303a.iterator();
    }
}
