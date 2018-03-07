package com.google.common.collect;

import java.util.Iterator;

/* compiled from: sms_takeover_state_change */
final class Iterables$UnmodifiableIterable<T> extends FluentIterable<T> {
    private final Iterable<T> f14197a;

    public Iterables$UnmodifiableIterable(Iterable<T> iterable) {
        this.f14197a = iterable;
    }

    public final Iterator<T> iterator() {
        return Iterators.a(this.f14197a.iterator());
    }

    public final String toString() {
        return this.f14197a.toString();
    }
}
