package com.google.common.collect;

import java.io.Serializable;
import java.util.EnumSet;

/* compiled from: cache_hit_count */
class ImmutableEnumSet$EnumSerializedForm<E extends Enum<E>> implements Serializable {
    final EnumSet<E> delegate;

    ImmutableEnumSet$EnumSerializedForm(EnumSet<E> enumSet) {
        this.delegate = enumSet;
    }

    Object readResolve() {
        return new ImmutableEnumSet(this.delegate.clone());
    }
}
