package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: zero_unknown_state */
public class ImmutableMap<K, V> extends HashMap<K, V> {
    private ImmutableMap(Map<? extends K, ? extends V> map) {
        super(map);
    }

    public static <K, V> Map<K, V> m3306a(K k, V v) {
        Map hashMap = new HashMap();
        hashMap.put(k, v);
        return Collections.unmodifiableMap(hashMap);
    }

    public static <K, V> Map<K, V> m3307a(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        Map hashMap = new HashMap();
        hashMap.put(k, v);
        hashMap.put(k2, v2);
        hashMap.put(k3, v3);
        hashMap.put(k4, v4);
        return Collections.unmodifiableMap(hashMap);
    }

    public static <K, V> Map<K, V> m3308a(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Map hashMap = new HashMap();
        hashMap.put(k, v);
        hashMap.put(k2, v2);
        hashMap.put(k3, v3);
        hashMap.put(k4, v4);
        hashMap.put(k5, v5);
        return Collections.unmodifiableMap(hashMap);
    }

    public static <K, V> ImmutableMap<K, V> m3305a(Map<? extends K, ? extends V> map) {
        return new ImmutableMap(map);
    }
}
