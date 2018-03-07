package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Queue;

@GwtCompatible
/* compiled from: localized_name */
public abstract class ForwardingQueue<E> extends ForwardingCollection<E> implements Queue<E> {
    protected abstract Queue<E> mo728a();

    protected /* synthetic */ Collection mo731b() {
        return mo728a();
    }

    protected /* synthetic */ Object mo733e() {
        return mo728a();
    }

    protected ForwardingQueue() {
    }

    public boolean offer(E e) {
        return mo728a().offer(e);
    }

    public E poll() {
        return mo728a().poll();
    }

    public E remove() {
        return mo728a().remove();
    }

    public E peek() {
        return mo728a().peek();
    }

    public E element() {
        return mo728a().element();
    }
}
