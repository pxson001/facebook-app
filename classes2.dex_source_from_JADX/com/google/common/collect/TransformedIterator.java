package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Iterator;

@GwtCompatible
/* compiled from: rtt_good */
public abstract class TransformedIterator<F, T> implements Iterator<T> {
    final Iterator<? extends F> f6369c;

    abstract T mo1480a(F f);

    TransformedIterator(Iterator<? extends F> it) {
        this.f6369c = (Iterator) Preconditions.checkNotNull(it);
    }

    public final boolean hasNext() {
        return this.f6369c.hasNext();
    }

    public final T next() {
        return mo1480a(this.f6369c.next());
    }

    public final void remove() {
        this.f6369c.remove();
    }
}
