package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: rw_RW */
abstract class AbstractSetMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements SetMultimap<K, V> {
    abstract Set<V> mo1473a();

    /* synthetic */ Collection mo411c() {
        return mo1473a();
    }

    public final /* synthetic */ Collection mo427c(@Nullable Object obj) {
        return mo1474a(obj);
    }

    public final /* synthetic */ Collection mo429d(@Nullable Object obj) {
        return mo1475b(obj);
    }

    public /* synthetic */ Collection mo419k() {
        return m10714t();
    }

    protected AbstractSetMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    final Collection mo428d() {
        return RegularImmutableSet.f688a;
    }

    public Set<V> mo1474a(@Nullable K k) {
        return (Set) super.mo427c((Object) k);
    }

    public Set<Entry<K, V>> m10714t() {
        return (Set) super.mo419k();
    }

    public Set<V> mo1475b(@Nullable Object obj) {
        return (Set) super.mo429d(obj);
    }

    public Map<K, Collection<V>> mo426b() {
        return super.mo426b();
    }

    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
}
