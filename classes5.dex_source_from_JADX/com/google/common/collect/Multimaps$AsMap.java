package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps.ViewCachingAbstractMap;
import com.google.j2objc.annotations.Weak;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: build_num */
public final class Multimaps$AsMap<K, V> extends ViewCachingAbstractMap<K, Collection<V>> {
    @Weak
    public final Multimap<K, V> f7515a;

    /* compiled from: build_num */
    class EntrySet extends com.google.common.collect.Maps.EntrySet<K, Collection<V>> {
        final /* synthetic */ Multimaps$AsMap f7514a;

        /* compiled from: build_num */
        class C08311 implements Function<K, Collection<V>> {
            final /* synthetic */ EntrySet f7513a;

            C08311(EntrySet entrySet) {
                this.f7513a = entrySet;
            }

            public Object apply(Object obj) {
                return this.f7513a.f7514a.f7515a.c(obj);
            }
        }

        EntrySet(Multimaps$AsMap multimaps$AsMap) {
            this.f7514a = multimaps$AsMap;
        }

        final Map<K, Collection<V>> m13586a() {
            return this.f7514a;
        }

        public Iterator<Entry<K, Collection<V>>> iterator() {
            return Maps.a(this.f7514a.f7515a.p(), new C08311(this));
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            Entry entry = (Entry) obj;
            Multimaps$AsMap multimaps$AsMap = this.f7514a;
            multimaps$AsMap.f7515a.p().remove(entry.getKey());
            return true;
        }
    }

    Multimaps$AsMap(Multimap<K, V> multimap) {
        this.f7515a = (Multimap) Preconditions.checkNotNull(multimap);
    }

    public final int size() {
        return this.f7515a.p().size();
    }

    protected final Set<Entry<K, Collection<V>>> m13587a() {
        return new EntrySet(this);
    }

    public final Object get(Object obj) {
        return containsKey(obj) ? this.f7515a.c(obj) : null;
    }

    public final Object remove(Object obj) {
        return containsKey(obj) ? this.f7515a.d(obj) : null;
    }

    public final Set<K> keySet() {
        return this.f7515a.p();
    }

    public final boolean isEmpty() {
        return this.f7515a.n();
    }

    public final boolean containsKey(Object obj) {
        return this.f7515a.f(obj);
    }

    public final void clear() {
        this.f7515a.g();
    }
}
