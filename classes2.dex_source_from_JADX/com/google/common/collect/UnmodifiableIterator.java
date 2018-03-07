package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;

@GwtCompatible
/* compiled from: work_hide_newsfeed_composer_android */
public abstract class UnmodifiableIterator<E> implements Iterator<E> {
    protected UnmodifiableIterator() {
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
