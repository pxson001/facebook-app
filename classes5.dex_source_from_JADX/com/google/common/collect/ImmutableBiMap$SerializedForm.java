package com.google.common.collect;

/* compiled from: cache_miss_count */
class ImmutableBiMap$SerializedForm extends ImmutableMap$SerializedForm {
    ImmutableBiMap$SerializedForm(ImmutableBiMap<?, ?> immutableBiMap) {
        super(immutableBiMap);
    }

    Object readResolve() {
        return m13360a(new ImmutableBiMap$Builder());
    }
}
