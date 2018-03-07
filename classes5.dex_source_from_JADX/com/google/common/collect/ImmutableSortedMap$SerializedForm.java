package com.google.common.collect;

import java.util.Comparator;

/* compiled from: button_uri */
class ImmutableSortedMap$SerializedForm extends ImmutableMap$SerializedForm {
    private final Comparator<Object> comparator;

    ImmutableSortedMap$SerializedForm(ImmutableSortedMap<?, ?> immutableSortedMap) {
        super(immutableSortedMap);
        this.comparator = immutableSortedMap.comparator();
    }

    Object readResolve() {
        return m13360a(new ImmutableSortedMap$Builder(this.comparator));
    }
}
