package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: help/android-app?ref=Android */
public abstract class ForwardingSet<E> extends ForwardingCollection<E> implements Set<E> {
    protected abstract Set<E> mo807a();

    protected /* synthetic */ Collection mo731b() {
        return mo807a();
    }

    protected /* synthetic */ Object mo733e() {
        return mo807a();
    }

    protected ForwardingSet() {
    }

    public boolean equals(@Nullable Object obj) {
        return obj == this || mo807a().equals(obj);
    }

    public int hashCode() {
        return mo807a().hashCode();
    }

    protected final boolean mo809c(Collection<?> collection) {
        return Sets.a(this, (Collection) Preconditions.checkNotNull(collection));
    }
}
