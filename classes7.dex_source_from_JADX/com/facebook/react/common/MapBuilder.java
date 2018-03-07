package com.facebook.react.common;

import java.util.HashMap;
import java.util.Map;

/* compiled from: getInt */
public class MapBuilder {

    /* compiled from: getInt */
    public final class Builder<K, V> {
        private Map f11581a;
        private boolean f11582b;

        public Builder() {
            this.f11581a = MapBuilder.m13603a();
            this.f11582b = true;
        }

        public final Builder<K, V> m13601a(K k, V v) {
            if (this.f11582b) {
                this.f11581a.put(k, v);
                return this;
            }
            throw new IllegalStateException("Underlying map has already been built");
        }

        public final Map<K, V> m13602a() {
            if (this.f11582b) {
                this.f11582b = false;
                return this.f11581a;
            }
            throw new IllegalStateException("Underlying map has already been built");
        }
    }

    public static <K, V> HashMap<K, V> m13603a() {
        return new HashMap();
    }

    private static <K, V> Map<K, V> m13610c() {
        return m13603a();
    }

    public static <K, V> Map<K, V> m13604a(K k, V v) {
        Map<K, V> a = m13603a();
        a.put(k, v);
        return a;
    }

    public static <K, V> Map<K, V> m13605a(K k, V v, K k2, V v2) {
        Map<K, V> a = m13603a();
        a.put(k, v);
        a.put(k2, v2);
        return a;
    }

    public static <K, V> Map<K, V> m13606a(K k, V v, K k2, V v2, K k3, V v3) {
        Map<K, V> a = m13603a();
        a.put(k, v);
        a.put(k2, v2);
        a.put(k3, v3);
        return a;
    }

    public static <K, V> Map<K, V> m13607a(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        Map<K, V> a = m13603a();
        a.put(k, v);
        a.put(k2, v2);
        a.put(k3, v3);
        a.put(k4, v4);
        return a;
    }

    public static <K, V> Map<K, V> m13608a(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Map<K, V> a = m13603a();
        a.put(k, v);
        a.put(k2, v2);
        a.put(k3, v3);
        a.put(k4, v4);
        a.put(k5, v5);
        return a;
    }

    public static <K, V> Builder<K, V> m13609b() {
        return new Builder();
    }
}
