package com.google.common.collect;

import java.util.Iterator;

/* compiled from: button_icon_image */
final class Iterables$10 extends FluentIterable<T> {
    final /* synthetic */ Iterable f7355a;
    final /* synthetic */ int f7356b;

    Iterables$10(Iterable iterable, int i) {
        this.f7355a = iterable;
        this.f7356b = i;
    }

    public final Iterator<T> iterator() {
        final Iterator it = this.f7355a.iterator();
        Iterators.b(it, this.f7356b);
        return new Iterator<T>(this) {
            boolean f7352a = true;
            final /* synthetic */ Iterables$10 f7354c;

            public boolean hasNext() {
                return it.hasNext();
            }

            public T next() {
                T next = it.next();
                this.f7352a = false;
                return next;
            }

            public void remove() {
                CollectPreconditions.a(!this.f7352a);
                it.remove();
            }
        };
    }
}
