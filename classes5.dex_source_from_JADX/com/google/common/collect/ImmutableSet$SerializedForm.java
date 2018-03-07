package com.google.common.collect;

import java.io.Serializable;

/* compiled from: buyer_email */
class ImmutableSet$SerializedForm implements Serializable {
    private static final long serialVersionUID = 0;
    final Object[] elements;

    ImmutableSet$SerializedForm(Object[] objArr) {
        this.elements = objArr;
    }

    Object readResolve() {
        return ImmutableSet.copyOf(this.elements);
    }
}
