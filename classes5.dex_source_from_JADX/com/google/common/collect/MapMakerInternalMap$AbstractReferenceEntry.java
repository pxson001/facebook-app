package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap.ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap.ValueReference;

/* compiled from: bulk_claim_importer */
abstract class MapMakerInternalMap$AbstractReferenceEntry<K, V> implements ReferenceEntry<K, V> {
    MapMakerInternalMap$AbstractReferenceEntry() {
    }

    public ValueReference<K, V> getValueReference() {
        throw new UnsupportedOperationException();
    }

    public void setValueReference(ValueReference<K, V> valueReference) {
        throw new UnsupportedOperationException();
    }

    public ReferenceEntry<K, V> getNext() {
        throw new UnsupportedOperationException();
    }

    public int getHash() {
        throw new UnsupportedOperationException();
    }

    public K getKey() {
        throw new UnsupportedOperationException();
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
}
