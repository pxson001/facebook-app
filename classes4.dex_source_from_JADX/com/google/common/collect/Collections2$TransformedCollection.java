package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: marker_list[ */
class Collections2$TransformedCollection<F, T> extends AbstractCollection<T> {
    final Collection<F> f8283a;
    final Function<? super F, ? extends T> f8284b;

    Collections2$TransformedCollection(Collection<F> collection, Function<? super F, ? extends T> function) {
        this.f8283a = (Collection) Preconditions.checkNotNull(collection);
        this.f8284b = (Function) Preconditions.checkNotNull(function);
    }

    public void clear() {
        this.f8283a.clear();
    }

    public boolean isEmpty() {
        return this.f8283a.isEmpty();
    }

    public Iterator<T> iterator() {
        return Iterators.a(this.f8283a.iterator(), this.f8284b);
    }

    public int size() {
        return this.f8283a.size();
    }
}
