package com.google.common.base;

import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: can_cast_video */
public class Functions$FunctionForMapNoDefault<K, V> implements Function<K, V>, Serializable {
    final Map<K, V> map;

    public Functions$FunctionForMapNoDefault(Map<K, V> map) {
        this.map = (Map) Preconditions.checkNotNull(map);
    }

    public V apply(@Nullable K k) {
        boolean z;
        V v = this.map.get(k);
        if (v != null || this.map.containsKey(k)) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Key '%s' not present in map", new Object[]{k});
        return v;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Functions$FunctionForMapNoDefault)) {
            return false;
        }
        return this.map.equals(((Functions$FunctionForMapNoDefault) obj).map);
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public String toString() {
        return "Functions.forMap(" + this.map + ")";
    }
}
