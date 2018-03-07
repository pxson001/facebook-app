package com.google.common.collect;

import java.io.Serializable;

/* compiled from: cached_feedback_age */
final class HashBiMap$InverseSerializedForm<K, V> implements Serializable {
    private final HashBiMap<K, V> bimap;

    HashBiMap$InverseSerializedForm(HashBiMap<K, V> hashBiMap) {
        this.bimap = hashBiMap;
    }

    final Object readResolve() {
        return this.bimap.a_();
    }
}
