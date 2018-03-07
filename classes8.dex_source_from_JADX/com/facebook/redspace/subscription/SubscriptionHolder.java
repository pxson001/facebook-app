package com.facebook.redspace.subscription;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: USER_BLOCKED */
public class SubscriptionHolder<T> implements Iterable<T> {
    public List<WeakReference<T>> f21352a = new ArrayList();

    /* compiled from: USER_BLOCKED */
    class SubscriptionHolderIterator implements Iterator<T> {
        final /* synthetic */ SubscriptionHolder f21350a;
        private int f21351b = this.f21350a.m24961a();

        public SubscriptionHolderIterator(SubscriptionHolder subscriptionHolder) {
            this.f21350a = subscriptionHolder;
        }

        public boolean hasNext() {
            return this.f21351b != 0;
        }

        public T next() {
            int i = this.f21351b;
            if (i == 0) {
                throw new NoSuchElementException();
            }
            T t;
            this.f21351b = i - 1;
            SubscriptionHolder subscriptionHolder = this.f21350a;
            i = this.f21350a.m24961a() - i;
            if (subscriptionHolder.f21352a.get(i) == null) {
                t = null;
            } else {
                t = ((WeakReference) subscriptionHolder.f21352a.get(i)).get();
            }
            return t;
        }

        public void remove() {
            throw new UnsupportedOperationException("not supported in the iterator. Use remove() in SubscriptionHolder directly");
        }
    }

    public final boolean m24962a(T t) {
        if (t == null) {
            return false;
        }
        for (int size = this.f21352a.size() - 1; size >= 0; size--) {
            if (((WeakReference) this.f21352a.get(size)).get() == null) {
                this.f21352a.remove(size);
            } else if (((WeakReference) this.f21352a.get(size)).get() == t) {
                return false;
            }
        }
        this.f21352a.add(new WeakReference(t));
        return true;
    }

    public final boolean m24963b(T t) {
        if (t == null) {
            return false;
        }
        for (int size = this.f21352a.size() - 1; size >= 0; size--) {
            if (((WeakReference) this.f21352a.get(size)).get() == null) {
                this.f21352a.remove(size);
            } else if (((WeakReference) this.f21352a.get(size)).get() == t) {
                this.f21352a.remove(size);
                return true;
            }
        }
        return false;
    }

    public final int m24961a() {
        return this.f21352a.size();
    }

    public Iterator<T> iterator() {
        return new SubscriptionHolderIterator(this);
    }
}
