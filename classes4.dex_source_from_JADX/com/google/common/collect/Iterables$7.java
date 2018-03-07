package com.google.common.collect;

import com.google.common.base.Predicates$InstanceOfPredicate;
import java.util.Iterator;

/* compiled from: sms_takeover_state_change */
final class Iterables$7 extends FluentIterable<T> {
    final /* synthetic */ Iterable f10353a;
    final /* synthetic */ Class f10354b;

    Iterables$7(Iterable iterable, Class cls) {
        this.f10353a = iterable;
        this.f10354b = cls;
    }

    public final Iterator<T> iterator() {
        return Iterators.b(this.f10353a.iterator(), new Predicates$InstanceOfPredicate(this.f10354b));
    }
}
