package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;

@GwtIncompatible("serialization")
/* compiled from: cachedSize */
class ImmutableAsList$SerializedForm implements Serializable {
    final ImmutableCollection<?> collection;

    ImmutableAsList$SerializedForm(ImmutableCollection<?> immutableCollection) {
        this.collection = immutableCollection;
    }

    Object readResolve() {
        return this.collection.asList();
    }
}
