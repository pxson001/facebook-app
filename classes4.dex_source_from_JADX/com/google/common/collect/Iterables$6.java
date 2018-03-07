package com.google.common.collect;

import com.google.common.base.Predicate;
import java.util.Iterator;

/* compiled from: sms_takeover_state_change */
final class Iterables$6 extends FluentIterable<T> {
    final /* synthetic */ Iterable f1992a;
    final /* synthetic */ Predicate f1993b;

    Iterables$6(Iterable iterable, Predicate predicate) {
        this.f1992a = iterable;
        this.f1993b = predicate;
    }

    public final Iterator<T> iterator() {
        return Iterators.b(this.f1992a.iterator(), this.f1993b);
    }
}
