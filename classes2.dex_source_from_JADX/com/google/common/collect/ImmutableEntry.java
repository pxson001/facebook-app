package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: zero_token_new_unknown_state_flow */
public class ImmutableEntry<K, V> extends AbstractMapEntry<K, V> implements Serializable {
    final K key;
    final V value;

    ImmutableEntry(@Nullable K k, @Nullable V v) {
        this.key = k;
        this.value = v;
    }

    @Nullable
    public final K getKey() {
        return this.key;
    }

    @Nullable
    public final V getValue() {
        return this.value;
    }

    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}
