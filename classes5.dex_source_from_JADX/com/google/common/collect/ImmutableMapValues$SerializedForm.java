package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;

@GwtIncompatible("serialization")
/* compiled from: c */
class ImmutableMapValues$SerializedForm<V> implements Serializable {
    private static final long serialVersionUID = 0;
    final ImmutableMap<?, V> map;

    ImmutableMapValues$SerializedForm(ImmutableMap<?, V> immutableMap) {
        this.map = immutableMap;
    }

    Object readResolve() {
        return this.map.values();
    }
}
