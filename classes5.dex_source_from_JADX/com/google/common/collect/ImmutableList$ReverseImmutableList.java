package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.ListIterator;
import javax.annotation.Nullable;

/* compiled from: cacheIds */
class ImmutableList$ReverseImmutableList<E> extends ImmutableList<E> {
    private final transient ImmutableList<E> f7320a;

    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    public /* bridge */ /* synthetic */ ListIterator listIterator() {
        return super.listIterator();
    }

    public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return super.listIterator(i);
    }

    ImmutableList$ReverseImmutableList(ImmutableList<E> immutableList) {
        this.f7320a = immutableList;
    }

    private int m13363a(int i) {
        return (size() - 1) - i;
    }

    private int m13364b(int i) {
        return size() - i;
    }

    public ImmutableList<E> reverse() {
        return this.f7320a;
    }

    public boolean contains(@Nullable Object obj) {
        return this.f7320a.contains(obj);
    }

    public int indexOf(@Nullable Object obj) {
        int lastIndexOf = this.f7320a.lastIndexOf(obj);
        return lastIndexOf >= 0 ? m13363a(lastIndexOf) : -1;
    }

    public int lastIndexOf(@Nullable Object obj) {
        int indexOf = this.f7320a.indexOf(obj);
        return indexOf >= 0 ? m13363a(indexOf) : -1;
    }

    public ImmutableList<E> subList(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, size());
        return this.f7320a.subList(m13364b(i2), m13364b(i)).reverse();
    }

    public E get(int i) {
        Preconditions.checkElementIndex(i, size());
        return this.f7320a.get(m13363a(i));
    }

    public int size() {
        return this.f7320a.size();
    }

    boolean isPartialView() {
        return this.f7320a.isPartialView();
    }
}
