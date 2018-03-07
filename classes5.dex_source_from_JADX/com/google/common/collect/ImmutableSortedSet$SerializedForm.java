package com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;

/* compiled from: button_type */
class ImmutableSortedSet$SerializedForm<E> implements Serializable {
    final Comparator<? super E> comparator;
    final Object[] elements;

    public ImmutableSortedSet$SerializedForm(Comparator<? super E> comparator, Object[] objArr) {
        this.comparator = comparator;
        this.elements = objArr;
    }

    Object readResolve() {
        return new ImmutableSortedSet$Builder(this.comparator).m13429c(this.elements).m13430c();
    }
}
