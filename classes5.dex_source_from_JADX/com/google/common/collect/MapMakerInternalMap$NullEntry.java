package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap.ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap.ValueReference;

/* compiled from: bulk_claim_importer */
public enum MapMakerInternalMap$NullEntry implements ReferenceEntry<Object, Object> {
    INSTANCE;

    public final ValueReference<Object, Object> getValueReference() {
        return null;
    }

    public final void setValueReference(ValueReference<Object, Object> valueReference) {
    }

    public final ReferenceEntry<Object, Object> getNext() {
        return null;
    }

    public final int getHash() {
        return 0;
    }

    public final Object getKey() {
        return null;
    }

    public final long getExpirationTime() {
        return 0;
    }

    public final void setExpirationTime(long j) {
    }

    public final ReferenceEntry<Object, Object> getNextExpirable() {
        return this;
    }

    public final void setNextExpirable(ReferenceEntry<Object, Object> referenceEntry) {
    }

    public final ReferenceEntry<Object, Object> getPreviousExpirable() {
        return this;
    }

    public final void setPreviousExpirable(ReferenceEntry<Object, Object> referenceEntry) {
    }

    public final ReferenceEntry<Object, Object> getNextEvictable() {
        return this;
    }

    public final void setNextEvictable(ReferenceEntry<Object, Object> referenceEntry) {
    }

    public final ReferenceEntry<Object, Object> getPreviousEvictable() {
        return this;
    }

    public final void setPreviousEvictable(ReferenceEntry<Object, Object> referenceEntry) {
    }
}
