package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: zero_rating2/clearable/default_optin/delay_interval_key */
final class SingletonImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    final transient K f450a;
    final transient V f451b;
    transient ImmutableBiMap<V, K> f452c;

    public final /* synthetic */ BiMap a_() {
        return mo73e();
    }

    SingletonImmutableBiMap(K k, V v) {
        CollectPreconditions.m616a((Object) k, (Object) v);
        this.f450a = k;
        this.f451b = v;
    }

    private SingletonImmutableBiMap(K k, V v, ImmutableBiMap<V, K> immutableBiMap) {
        this.f450a = k;
        this.f451b = v;
        this.f452c = immutableBiMap;
    }

    public final V get(@Nullable Object obj) {
        return this.f450a.equals(obj) ? this.f451b : null;
    }

    public final int size() {
        return 1;
    }

    public final boolean containsKey(@Nullable Object obj) {
        return this.f450a.equals(obj);
    }

    public final boolean containsValue(@Nullable Object obj) {
        return this.f451b.equals(obj);
    }

    final boolean isPartialView() {
        return false;
    }

    final ImmutableSet<Entry<K, V>> createEntrySet() {
        return ImmutableSet.of(Maps.m817a(this.f450a, this.f451b));
    }

    final ImmutableSet<K> createKeySet() {
        return ImmutableSet.of(this.f450a);
    }

    public final ImmutableBiMap<V, K> mo73e() {
        ImmutableBiMap<V, K> immutableBiMap = this.f452c;
        if (immutableBiMap != null) {
            return immutableBiMap;
        }
        immutableBiMap = new SingletonImmutableBiMap(this.f451b, this.f450a, this);
        this.f452c = immutableBiMap;
        return immutableBiMap;
    }
}
