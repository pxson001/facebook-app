package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: url_interstitial */
abstract class AbstractListMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements ListMultimap<K, V> {
    abstract List<V> mo407a();

    /* synthetic */ Collection mo411c() {
        return mo407a();
    }

    public final /* synthetic */ Collection mo427c(@Nullable Object obj) {
        return mo424a(obj);
    }

    public final /* synthetic */ Collection mo429d(@Nullable Object obj) {
        return mo425b(obj);
    }

    protected AbstractListMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    final Collection mo428d() {
        return RegularImmutableList.f535a;
    }

    public List<V> mo424a(@Nullable K k) {
        return (List) super.mo427c((Object) k);
    }

    public List<V> mo425b(@Nullable Object obj) {
        return (List) super.mo429d(obj);
    }

    public Map<K, Collection<V>> mo426b() {
        return super.mo426b();
    }

    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
}
