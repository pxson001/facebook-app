package com.google.common.collect;

import java.io.Serializable;

/* compiled from: bugreporter-doodle- */
class RegularImmutableBiMap$InverseSerializedForm<K, V> implements Serializable {
    private final ImmutableBiMap<K, V> forward;

    RegularImmutableBiMap$InverseSerializedForm(ImmutableBiMap<K, V> immutableBiMap) {
        this.forward = immutableBiMap;
    }

    Object readResolve() {
        return this.forward.e();
    }
}
