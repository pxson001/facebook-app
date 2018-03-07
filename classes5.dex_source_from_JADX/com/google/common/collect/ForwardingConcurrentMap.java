package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

@GwtCompatible
/* compiled from: callCnt */
public abstract class ForwardingConcurrentMap<K, V> extends ForwardingMap<K, V> implements ConcurrentMap<K, V> {
    protected abstract ConcurrentMap<K, V> mo939b();

    protected /* synthetic */ Map mo877a() {
        return mo939b();
    }

    protected /* synthetic */ Object mo880e() {
        return mo939b();
    }

    protected ForwardingConcurrentMap() {
    }

    public V putIfAbsent(K k, V v) {
        return mo939b().putIfAbsent(k, v);
    }

    public boolean remove(Object obj, Object obj2) {
        return mo939b().remove(obj, obj2);
    }

    public V replace(K k, V v) {
        return mo939b().replace(k, v);
    }

    public boolean replace(K k, V v, V v2) {
        return mo939b().replace(k, v, v2);
    }
}
