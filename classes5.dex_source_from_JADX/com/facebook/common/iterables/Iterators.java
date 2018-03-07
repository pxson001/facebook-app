package com.facebook.common.iterables;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: button_dropdown */
public class Iterators {

    /* compiled from: button_dropdown */
    public final class C10741 implements Iterator<T> {
        Iterator<T> f11092a;
        int f11093b = 0;
        final /* synthetic */ Iterable[] f11094c;

        public C10741(Iterable[] iterableArr) {
            this.f11094c = iterableArr;
        }

        public final boolean hasNext() {
            int length = this.f11094c.length;
            while (this.f11093b < length && (this.f11092a == null || !this.f11092a.hasNext())) {
                Iterable[] iterableArr = this.f11094c;
                int i = this.f11093b;
                this.f11093b = i + 1;
                this.f11092a = iterableArr[i].iterator();
            }
            return this.f11092a != null && this.f11092a.hasNext();
        }

        public final T next() {
            if (hasNext()) {
                return this.f11092a.next();
            }
            throw new NoSuchElementException();
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
