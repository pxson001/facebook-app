package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: bugreport */
final class ReverseOrdering<T> extends Ordering<T> implements Serializable {
    final Ordering<? super T> forwardOrder;

    ReverseOrdering(Ordering<? super T> ordering) {
        this.forwardOrder = (Ordering) Preconditions.checkNotNull(ordering);
    }

    public final int compare(T t, T t2) {
        return this.forwardOrder.compare(t2, t);
    }

    public final <S extends T> Ordering<S> m13637a() {
        return this.forwardOrder;
    }

    public final <E extends T> E m13639a(E e, E e2) {
        return this.forwardOrder.b(e, e2);
    }

    public final <E extends T> E m13640a(Iterator<E> it) {
        return this.forwardOrder.b(it);
    }

    public final <E extends T> E m13638a(Iterable<E> iterable) {
        return this.forwardOrder.b(iterable);
    }

    public final <E extends T> E m13642b(E e, E e2) {
        return this.forwardOrder.a(e, e2);
    }

    public final <E extends T> E m13643b(Iterator<E> it) {
        return this.forwardOrder.a(it);
    }

    public final <E extends T> E m13641b(Iterable<E> iterable) {
        return this.forwardOrder.a(iterable);
    }

    public final int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReverseOrdering)) {
            return false;
        }
        return this.forwardOrder.equals(((ReverseOrdering) obj).forwardOrder);
    }

    public final String toString() {
        return this.forwardOrder + ".reverse()";
    }
}
