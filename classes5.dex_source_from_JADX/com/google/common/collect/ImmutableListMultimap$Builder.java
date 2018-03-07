package com.google.common.collect;

import com.google.common.collect.ImmutableMultimap.Builder;

/* compiled from: cacheId */
public final class ImmutableListMultimap$Builder<K, V> extends Builder<K, V> {
    public final /* synthetic */ Builder m13369b(Multimap multimap) {
        return m13365a(multimap);
    }

    public final /* synthetic */ Builder m13370b(Object obj, Iterable iterable) {
        return m13366a(obj, iterable);
    }

    public final /* synthetic */ Builder m13371b(Object obj, Object obj2) {
        return m13367a(obj, obj2);
    }

    public final /* synthetic */ ImmutableMultimap m13372b() {
        return m13368a();
    }

    public final ImmutableListMultimap$Builder<K, V> m13367a(K k, V v) {
        super.b(k, v);
        return this;
    }

    public final ImmutableListMultimap$Builder<K, V> m13366a(K k, Iterable<? extends V> iterable) {
        super.b(k, iterable);
        return this;
    }

    public final ImmutableListMultimap$Builder<K, V> m13365a(Multimap<? extends K, ? extends V> multimap) {
        super.b(multimap);
        return this;
    }

    public final ImmutableListMultimap<K, V> m13368a() {
        return (ImmutableListMultimap) super.b();
    }
}
