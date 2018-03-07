package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;

@GwtIncompatible("serialization")
/* compiled from: cabin_type_label */
class ImmutableMapEntrySet$EntrySetSerializedForm<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final ImmutableMap<K, V> map;

    ImmutableMapEntrySet$EntrySetSerializedForm(ImmutableMap<K, V> immutableMap) {
        this.map = immutableMap;
    }

    Object readResolve() {
        return this.map.entrySet();
    }
}
