package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: camera_facing_id */
public final class RemovalNotification<K, V> implements Entry<K, V> {
    @Nullable
    private final K f7249a;
    @Nullable
    private final V f7250b;
    public final RemovalCause f7251c;

    public RemovalNotification(@Nullable K k, @Nullable V v, RemovalCause removalCause) {
        this.f7249a = k;
        this.f7250b = v;
        this.f7251c = (RemovalCause) Preconditions.checkNotNull(removalCause);
    }

    @Nullable
    public final K getKey() {
        return this.f7249a;
    }

    @Nullable
    public final V getValue() {
        return this.f7250b;
    }

    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        if (Objects.equal(getKey(), entry.getKey()) && Objects.equal(getValue(), entry.getValue())) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        Object key = getKey();
        Object value = getValue();
        int hashCode = key == null ? 0 : key.hashCode();
        if (value != null) {
            i = value.hashCode();
        }
        return i ^ hashCode;
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
