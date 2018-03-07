package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.ListIterator;

@GwtCompatible
/* compiled from: messenger_inbox_item_impressions_remaining */
abstract class TransformedListIterator<F, T> extends TransformedIterator<F, T> implements ListIterator<T> {
    TransformedListIterator(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    private ListIterator<? extends F> m20278a() {
        return Iterators.m1431j(this.f6369c);
    }

    public final boolean hasPrevious() {
        return m20278a().hasPrevious();
    }

    public final T previous() {
        return mo1480a(m20278a().previous());
    }

    public final int nextIndex() {
        return m20278a().nextIndex();
    }

    public final int previousIndex() {
        return m20278a().previousIndex();
    }

    public void set(T t) {
        throw new UnsupportedOperationException();
    }

    public void add(T t) {
        throw new UnsupportedOperationException();
    }
}
