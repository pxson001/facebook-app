package com.facebook.entitycards.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.Sets;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: hours_type */
public class OrderedImmutableMap<K, V> {
    static final OrderedImmutableMap f11039a = new OrderedImmutableMap();
    public final ImmutableList<K> f11040b;
    private final ImmutableMap<K, V> f11041c;

    /* compiled from: hours_type */
    public class Builder<K, V> {
        private final LinkedHashSet<K> f11037a = Sets.c();
        private final com.google.common.collect.ImmutableMap.Builder<K, V> f11038b = new com.google.common.collect.ImmutableMap.Builder();

        public final synchronized void m12983a(K k, V v) {
            this.f11037a.add(k);
            this.f11038b.b(k, v);
        }

        public final synchronized OrderedImmutableMap m12982a() {
            return new OrderedImmutableMap(ImmutableList.copyOf(this.f11037a), this.f11038b.b());
        }
    }

    public static <K, V> OrderedImmutableMap<K, V> m12984a() {
        return f11039a;
    }

    protected OrderedImmutableMap(ImmutableList<K> immutableList, ImmutableMap<K, V> immutableMap) {
        this.f11040b = immutableList;
        this.f11041c = immutableMap;
    }

    private OrderedImmutableMap() {
        this.f11040b = RegularImmutableList.a;
        this.f11041c = RegularImmutableBiMap.a;
    }

    public final V m12986a(Object obj) {
        if (obj instanceof Integer) {
            return m12985a(((Integer) obj).intValue());
        }
        return this.f11041c.get(obj);
    }

    public final Set<K> m12988b() {
        return this.f11041c.keySet();
    }

    public final int m12989c() {
        return this.f11040b.size();
    }

    public final V m12985a(int i) {
        return this.f11041c.get(this.f11040b.get(i));
    }

    public final K m12987b(int i) {
        return this.f11040b.get(i);
    }
}
