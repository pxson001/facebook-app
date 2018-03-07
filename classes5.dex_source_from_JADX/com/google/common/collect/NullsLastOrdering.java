package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: build */
final class NullsLastOrdering<T> extends Ordering<T> implements Serializable {
    final Ordering<? super T> ordering;

    NullsLastOrdering(Ordering<? super T> ordering) {
        this.ordering = ordering;
    }

    public final int compare(@Nullable T t, @Nullable T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return 1;
        }
        if (t2 == null) {
            return -1;
        }
        return this.ordering.compare(t, t2);
    }

    public final <S extends T> Ordering<S> m13599a() {
        return this.ordering.a().b();
    }

    public final <S extends T> Ordering<S> m13600b() {
        return this.ordering.b();
    }

    public final <S extends T> Ordering<S> m13601c() {
        return this;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NullsLastOrdering)) {
            return false;
        }
        return this.ordering.equals(((NullsLastOrdering) obj).ordering);
    }

    public final int hashCode() {
        return this.ordering.hashCode() ^ -921210296;
    }

    public final String toString() {
        return this.ordering + ".nullsLast()";
    }
}
