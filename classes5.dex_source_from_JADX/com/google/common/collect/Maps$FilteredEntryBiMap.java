package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Maps.FilteredEntryMap;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: camera */
public final class Maps$FilteredEntryBiMap<K, V> extends FilteredEntryMap<K, V> implements BiMap<K, V> {
    private final BiMap<V, K> f7474d;

    /* compiled from: camera */
    public final class C08291 implements Predicate<Entry<V, K>> {
        final /* synthetic */ Predicate f7473a;

        public C08291(Predicate predicate) {
            this.f7473a = predicate;
        }

        public final boolean apply(Object obj) {
            Entry entry = (Entry) obj;
            return this.f7473a.apply(Maps.a(entry.getValue(), entry.getKey()));
        }
    }

    public final /* synthetic */ Collection values() {
        return m13529c();
    }

    public Maps$FilteredEntryBiMap(BiMap<K, V> biMap, Predicate<? super Entry<K, V>> predicate) {
        super(biMap, predicate);
        this.f7474d = new Maps$FilteredEntryBiMap(biMap.a_(), new C08291(predicate), this);
    }

    private Maps$FilteredEntryBiMap(BiMap<K, V> biMap, Predicate<? super Entry<K, V>> predicate, BiMap<V, K> biMap2) {
        super(biMap, predicate);
        this.f7474d = biMap2;
    }

    public final BiMap<K, V> m13530e() {
        return (BiMap) this.a;
    }

    public final V m13528a(@Nullable K k, @Nullable V v) {
        Preconditions.checkArgument(b(k, v));
        return m13530e().a(k, v);
    }

    public final BiMap<V, K> a_() {
        return this.f7474d;
    }

    public final Set<V> m13529c() {
        return this.f7474d.keySet();
    }
}
