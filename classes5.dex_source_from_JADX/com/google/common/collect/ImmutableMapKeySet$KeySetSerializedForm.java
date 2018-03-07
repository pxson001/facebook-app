package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;

@GwtIncompatible("serialization")
/* compiled from: c38319dbbaf85201afe0c98eb1506ba6 */
class ImmutableMapKeySet$KeySetSerializedForm<K> implements Serializable {
    private static final long serialVersionUID = 0;
    final ImmutableMap<K, ?> map;

    ImmutableMapKeySet$KeySetSerializedForm(ImmutableMap<K, ?> immutableMap) {
        this.map = immutableMap;
    }

    Object readResolve() {
        return this.map.keySet();
    }
}
