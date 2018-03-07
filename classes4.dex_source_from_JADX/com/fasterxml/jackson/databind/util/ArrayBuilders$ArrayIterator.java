package com.fasterxml.jackson.databind.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: verbs_config_version */
final class ArrayBuilders$ArrayIterator<T> implements Iterable<T>, Iterator<T> {
    private final T[] f305a;
    private int f306b = 0;

    public ArrayBuilders$ArrayIterator(T[] tArr) {
        this.f305a = tArr;
    }

    public final boolean hasNext() {
        return this.f306b < this.f305a.length;
    }

    public final T next() {
        if (this.f306b >= this.f305a.length) {
            throw new NoSuchElementException();
        }
        Object[] objArr = this.f305a;
        int i = this.f306b;
        this.f306b = i + 1;
        return objArr[i];
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final Iterator<T> iterator() {
        return this;
    }
}
