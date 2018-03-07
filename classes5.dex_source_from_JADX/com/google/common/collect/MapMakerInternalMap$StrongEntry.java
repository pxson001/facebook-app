package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap.ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap.ValueReference;
import javax.annotation.Nullable;

/* compiled from: bulk_claim_importer */
class MapMakerInternalMap$StrongEntry<K, V> implements ReferenceEntry<K, V> {
    final K f7439a;
    final int f7440b;
    final ReferenceEntry<K, V> f7441c;
    volatile ValueReference<K, V> f7442d = MapMakerInternalMap.e;

    MapMakerInternalMap$StrongEntry(K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        this.f7439a = k;
        this.f7440b = i;
        this.f7441c = referenceEntry;
    }

    public K getKey() {
        return this.f7439a;
    }

    public long getExpirationTime() {
        throw new UnsupportedOperationException();
    }

    public void setExpirationTime(long j) {
        throw new UnsupportedOperationException();
    }

    public ReferenceEntry<K, V> getNextExpirable() {
        throw new UnsupportedOperationException();
    }

    public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
        throw new UnsupportedOperationException();
    }

    public ReferenceEntry<K, V> getPreviousExpirable() {
        throw new UnsupportedOperationException();
    }

    public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
        throw new UnsupportedOperationException();
    }

    public ReferenceEntry<K, V> getNextEvictable() {
        throw new UnsupportedOperationException();
    }

    public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
        throw new UnsupportedOperationException();
    }

    public ReferenceEntry<K, V> getPreviousEvictable() {
        throw new UnsupportedOperationException();
    }

    public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
        throw new UnsupportedOperationException();
    }

    public ValueReference<K, V> getValueReference() {
        return this.f7442d;
    }

    public void setValueReference(ValueReference<K, V> valueReference) {
        ValueReference valueReference2 = this.f7442d;
        this.f7442d = valueReference;
        valueReference2.c();
    }

    public int getHash() {
        return this.f7440b;
    }

    public ReferenceEntry<K, V> getNext() {
        return this.f7441c;
    }
}
