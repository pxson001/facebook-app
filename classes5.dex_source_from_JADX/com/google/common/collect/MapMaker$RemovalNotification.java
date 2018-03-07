package com.google.common.collect;

import com.google.common.collect.MapMaker.RemovalCause;
import javax.annotation.Nullable;

/* compiled from: bulk_unfriend_intern */
public final class MapMaker$RemovalNotification<K, V> extends ImmutableEntry<K, V> {
    private final RemovalCause cause;

    public MapMaker$RemovalNotification(@Nullable K k, @Nullable V v, RemovalCause removalCause) {
        super(k, v);
        this.cause = removalCause;
    }
}
