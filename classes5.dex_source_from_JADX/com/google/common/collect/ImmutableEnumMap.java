package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: cache_id */
public final class ImmutableEnumMap<K extends Enum<K>, V> extends ImmutableMap$IteratorBasedImmutableMap<K, V> {
    private final transient EnumMap<K, V> f7319a;

    /* compiled from: cache_id */
    class EnumSerializedForm<K extends Enum<K>, V> implements Serializable {
        final EnumMap<K, V> delegate;

        EnumSerializedForm(EnumMap<K, V> enumMap) {
            this.delegate = enumMap;
        }

        Object readResolve() {
            return new ImmutableEnumMap(this.delegate);
        }
    }

    public ImmutableEnumMap(EnumMap<K, V> enumMap) {
        this.f7319a = enumMap;
        Preconditions.checkArgument(!enumMap.isEmpty());
    }

    final UnmodifiableIterator<K> keyIterator() {
        return Iterators.a(this.f7319a.keySet().iterator());
    }

    public final int size() {
        return this.f7319a.size();
    }

    public final boolean containsKey(@Nullable Object obj) {
        return this.f7319a.containsKey(obj);
    }

    public final V get(Object obj) {
        return this.f7319a.get(obj);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableEnumMap) {
            obj = ((ImmutableEnumMap) obj).f7319a;
        }
        return this.f7319a.equals(obj);
    }

    final UnmodifiableIterator<Entry<K, V>> mo925a() {
        return new Maps$6(this.f7319a.entrySet().iterator());
    }

    final boolean isPartialView() {
        return false;
    }

    final Object writeReplace() {
        return new EnumSerializedForm(this.f7319a);
    }
}
