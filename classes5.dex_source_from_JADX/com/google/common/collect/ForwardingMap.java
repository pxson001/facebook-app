package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: cameraTilt */
public abstract class ForwardingMap<K, V> extends ForwardingObject implements Map<K, V> {
    protected abstract Map<K, V> mo877a();

    protected /* synthetic */ Object mo880e() {
        return mo877a();
    }

    protected ForwardingMap() {
    }

    public int size() {
        return mo877a().size();
    }

    public boolean isEmpty() {
        return mo877a().isEmpty();
    }

    public V remove(Object obj) {
        return mo877a().remove(obj);
    }

    public void clear() {
        mo877a().clear();
    }

    public boolean containsKey(@Nullable Object obj) {
        return mo877a().containsKey(obj);
    }

    public boolean containsValue(@Nullable Object obj) {
        return mo877a().containsValue(obj);
    }

    public V get(@Nullable Object obj) {
        return mo877a().get(obj);
    }

    public V put(K k, V v) {
        return mo877a().put(k, v);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        mo877a().putAll(map);
    }

    public Set<K> keySet() {
        return mo877a().keySet();
    }

    public Collection<V> values() {
        return mo877a().values();
    }

    public Set<Entry<K, V>> entrySet() {
        return mo877a().entrySet();
    }

    public boolean equals(@Nullable Object obj) {
        return obj == this || mo877a().equals(obj);
    }

    public int hashCode() {
        return mo877a().hashCode();
    }
}
