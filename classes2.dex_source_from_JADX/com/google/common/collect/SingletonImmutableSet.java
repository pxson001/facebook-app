package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

@GwtCompatible
/* compiled from: tuzi_should_show_delete_intercept_v2 */
final class SingletonImmutableSet<E> extends ImmutableSet<E> {
    final transient E f2189a;
    private transient int f2190b;

    SingletonImmutableSet(E e) {
        this.f2189a = Preconditions.checkNotNull(e);
    }

    SingletonImmutableSet(E e, int i) {
        this.f2189a = e;
        this.f2190b = i;
    }

    public final int size() {
        return 1;
    }

    public final boolean contains(Object obj) {
        return this.f2189a.equals(obj);
    }

    public final UnmodifiableIterator<E> iterator() {
        return Iterators.m1403a(this.f2189a);
    }

    final boolean isPartialView() {
        return false;
    }

    final int copyIntoArray(Object[] objArr, int i) {
        objArr[i] = this.f2189a;
        return i + 1;
    }

    public final int hashCode() {
        int i = this.f2190b;
        if (i != 0) {
            return i;
        }
        i = this.f2189a.hashCode();
        this.f2190b = i;
        return i;
    }

    final boolean isHashCodeFast() {
        return this.f2190b != 0;
    }

    public final String toString() {
        String obj = this.f2189a.toString();
        return new StringBuilder(obj.length() + 2).append('[').append(obj).append(']').toString();
    }
}
