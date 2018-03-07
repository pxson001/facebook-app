package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: campaign_owner */
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {
    private T f7186a;

    protected abstract T mo871a(T t);

    protected AbstractSequentialIterator(@Nullable T t) {
        this.f7186a = t;
    }

    public final boolean hasNext() {
        return this.f7186a != null;
    }

    public final T next() {
        if (hasNext()) {
            try {
                T t = this.f7186a;
                return t;
            } finally {
                this.f7186a = mo871a(this.f7186a);
            }
        } else {
            throw new NoSuchElementException();
        }
    }
}
