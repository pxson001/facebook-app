package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import javax.annotation.CheckReturnValue;

@GwtCompatible
/* compiled from: rtt_moderate */
public abstract class FluentIterable<E> implements Iterable<E> {
    public final Iterable<E> f6367a;

    protected FluentIterable() {
        this.f6367a = this;
    }

    FluentIterable(Iterable<E> iterable) {
        this.f6367a = (Iterable) Preconditions.checkNotNull(iterable);
    }

    @CheckReturnValue
    public static <E> FluentIterable<E> m10760a(Iterable<E> iterable) {
        return iterable instanceof FluentIterable ? (FluentIterable) iterable : new 1(iterable, iterable);
    }

    @CheckReturnValue
    public String toString() {
        return Iterables.m967c(this.f6367a);
    }

    @CheckReturnValue
    @GwtIncompatible("Class.isInstance")
    public final <T> FluentIterable<T> m10762a(Class<T> cls) {
        return m10760a(Iterables.m961b(this.f6367a, (Class) cls));
    }

    @CheckReturnValue
    public final Optional<E> m10761a() {
        Iterator it = this.f6367a.iterator();
        return it.hasNext() ? Optional.of(it.next()) : Absent.INSTANCE;
    }
}
