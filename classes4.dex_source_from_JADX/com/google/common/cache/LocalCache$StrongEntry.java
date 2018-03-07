package com.google.common.cache;

import com.google.common.cache.LocalCache.AbstractReferenceEntry;
import com.google.common.cache.LocalCache.ReferenceEntry;
import com.google.common.cache.LocalCache.ValueReference;
import javax.annotation.Nullable;

/* compiled from: outputDisplayList */
class LocalCache$StrongEntry<K, V> extends AbstractReferenceEntry<K, V> {
    final K f5750g;
    final int f5751h;
    final ReferenceEntry<K, V> f5752i;
    volatile ValueReference<K, V> f5753j = LocalCache.u;

    LocalCache$StrongEntry(K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        this.f5750g = k;
        this.f5751h = i;
        this.f5752i = referenceEntry;
    }

    public K getKey() {
        return this.f5750g;
    }

    public ValueReference<K, V> getValueReference() {
        return this.f5753j;
    }

    public void setValueReference(ValueReference<K, V> valueReference) {
        this.f5753j = valueReference;
    }

    public int getHash() {
        return this.f5751h;
    }

    public ReferenceEntry<K, V> getNext() {
        return this.f5752i;
    }
}
