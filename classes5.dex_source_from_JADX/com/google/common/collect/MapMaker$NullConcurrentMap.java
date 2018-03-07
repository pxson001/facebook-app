package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker.RemovalCause;
import com.google.common.collect.MapMaker.RemovalListener;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

/* compiled from: bulk_unfriend_intern */
public class MapMaker$NullConcurrentMap<K, V> extends AbstractMap<K, V> implements Serializable, ConcurrentMap<K, V> {
    public final RemovalCause removalCause;
    public final RemovalListener<K, V> removalListener;

    MapMaker$NullConcurrentMap(MapMaker mapMaker) {
        this.removalListener = mapMaker.a();
        this.removalCause = mapMaker.j;
    }

    public boolean containsKey(@Nullable Object obj) {
        return false;
    }

    public boolean containsValue(@Nullable Object obj) {
        return false;
    }

    public V get(@Nullable Object obj) {
        return null;
    }

    public V put(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        this.removalListener.onRemoval(new MapMaker$RemovalNotification(k, v, this.removalCause));
        return null;
    }

    public V putIfAbsent(K k, V v) {
        return put(k, v);
    }

    public V remove(@Nullable Object obj) {
        return null;
    }

    public boolean remove(@Nullable Object obj, @Nullable Object obj2) {
        return false;
    }

    public V replace(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        return null;
    }

    public boolean replace(K k, @Nullable V v, V v2) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v2);
        return false;
    }

    public Set<Entry<K, V>> entrySet() {
        return Collections.emptySet();
    }
}
