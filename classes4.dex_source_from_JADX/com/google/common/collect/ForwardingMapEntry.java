package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: held_time_ms */
public abstract class ForwardingMapEntry<K, V> extends ForwardingObject implements Entry<K, V> {
    protected abstract Entry<K, V> mo810a();

    protected /* synthetic */ Object mo811e() {
        return mo810a();
    }

    protected ForwardingMapEntry() {
    }

    public K getKey() {
        return mo810a().getKey();
    }

    public V getValue() {
        return mo810a().getValue();
    }

    public V setValue(V v) {
        return mo810a().setValue(v);
    }

    public boolean equals(@Nullable Object obj) {
        return mo810a().equals(obj);
    }

    public int hashCode() {
        return mo810a().hashCode();
    }

    protected final boolean m11212a(@Nullable Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        if (Objects.equal(getKey(), entry.getKey()) && Objects.equal(getValue(), entry.getValue())) {
            return true;
        }
        return false;
    }
}
