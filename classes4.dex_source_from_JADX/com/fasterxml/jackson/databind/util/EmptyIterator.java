package com.fasterxml.jackson.databind.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: thread_presence_ping_post */
public class EmptyIterator<T> implements Iterator<T> {
    public static final EmptyIterator<?> f1122a = new EmptyIterator();

    private EmptyIterator() {
    }

    public static <T> Iterator<T> m1388a() {
        return f1122a;
    }

    public boolean hasNext() {
        return false;
    }

    public T next() {
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
