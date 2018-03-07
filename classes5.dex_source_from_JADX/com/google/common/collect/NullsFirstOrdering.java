package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: buildMethodName */
final class NullsFirstOrdering<T> extends Ordering<T> implements Serializable {
    final Ordering<? super T> ordering;

    NullsFirstOrdering(Ordering<? super T> ordering) {
        this.ordering = ordering;
    }

    public final int compare(@Nullable T t, @Nullable T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return this.ordering.compare(t, t2);
    }

    public final <S extends T> Ordering<S> m13596a() {
        return this.ordering.a().c();
    }

    public final <S extends T> Ordering<S> m13597b() {
        return this;
    }

    public final <S extends T> Ordering<S> m13598c() {
        return this.ordering.c();
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NullsFirstOrdering)) {
            return false;
        }
        return this.ordering.equals(((NullsFirstOrdering) obj).ordering);
    }

    public final int hashCode() {
        return this.ordering.hashCode() ^ 957692532;
    }

    public final String toString() {
        return this.ordering + ".nullsFirst()";
    }
}
