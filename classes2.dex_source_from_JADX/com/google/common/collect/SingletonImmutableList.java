package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

@GwtCompatible
/* compiled from: viewer_saved_state */
final class SingletonImmutableList<E> extends ImmutableList<E> {
    final transient E f1027a;

    SingletonImmutableList(E e) {
        this.f1027a = Preconditions.checkNotNull(e);
    }

    public final E get(int i) {
        Preconditions.checkElementIndex(i, 1);
        return this.f1027a;
    }

    public final UnmodifiableIterator<E> iterator() {
        return Iterators.m1403a(this.f1027a);
    }

    public final int size() {
        return 1;
    }

    public final ImmutableList<E> subList(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, 1);
        return i == i2 ? RegularImmutableList.f535a : this;
    }

    public final String toString() {
        String obj = this.f1027a.toString();
        return new StringBuilder(obj.length() + 2).append('[').append(obj).append(']').toString();
    }

    final boolean isPartialView() {
        return false;
    }
}
