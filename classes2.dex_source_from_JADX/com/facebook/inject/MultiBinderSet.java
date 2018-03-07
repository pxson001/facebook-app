package com.facebook.inject;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: viewer_join_state */
public final class MultiBinderSet<T> extends AbstractSet<T> {
    public final Injector f1029a;
    public final AtomicReferenceArray<T> f1030b;
    public final MultiBindIndexedProvider<T> f1031c;

    /* compiled from: viewer_join_state */
    class IndexedIterator implements Iterator<T> {
        final /* synthetic */ MultiBinderSet f1036a;
        private final AtomicInteger f1037b = new AtomicInteger(0);

        public IndexedIterator(MultiBinderSet multiBinderSet) {
            this.f1036a = multiBinderSet;
        }

        public boolean hasNext() {
            return this.f1037b.get() < this.f1036a.size();
        }

        public T next() {
            int andIncrement = this.f1037b.getAndIncrement();
            if (andIncrement >= this.f1036a.size()) {
                throw new NoSuchElementException();
            }
            T t = this.f1036a.f1030b.get(andIncrement);
            if (t == null) {
                synchronized (this.f1036a.f1030b) {
                    t = this.f1036a.f1030b.get(andIncrement);
                    if (t == null) {
                        t = this.f1036a.f1031c.provide(this.f1036a.f1029a, andIncrement);
                        this.f1036a.f1030b.set(andIncrement, t);
                    }
                }
            }
            return t;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public MultiBinderSet(Injector injector, MultiBindIndexedProvider<T> multiBindIndexedProvider) {
        this.f1029a = injector;
        this.f1031c = multiBindIndexedProvider;
        this.f1030b = new AtomicReferenceArray(multiBindIndexedProvider.size());
    }

    public final boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    public final boolean contains(Object obj) {
        Iterator it = iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (obj == null) {
                if (next == null) {
                }
            } else if (obj.equals(next)) {
            }
            return true;
        }
        return false;
    }

    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final Iterator<T> iterator() {
        return new IndexedIterator(this);
    }

    public final int size() {
        return this.f1030b.length();
    }
}
