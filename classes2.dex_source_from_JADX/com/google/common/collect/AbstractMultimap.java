package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps.KeySet;
import com.google.common.collect.Multimaps.Keys;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: uris */
public abstract class AbstractMultimap<K, V> implements Multimap<K, V> {
    private transient Collection<Entry<K, V>> f1545a;
    private transient Set<K> f1546b;
    private transient Multiset<K> f1547c;
    private transient Collection<V> f1548d;
    private transient Map<K, Collection<V>> f1549e;

    /* compiled from: uris */
    class Values extends AbstractCollection<V> {
        final /* synthetic */ AbstractMultimap f15136a;

        Values(AbstractMultimap abstractMultimap) {
            this.f15136a = abstractMultimap;
        }

        public Iterator<V> iterator() {
            return this.f15136a.mo433j();
        }

        public int size() {
            return this.f15136a.mo413f();
        }

        public boolean contains(@Nullable Object obj) {
            return this.f15136a.mo416g(obj);
        }

        public void clear() {
            this.f15136a.mo415g();
        }
    }

    abstract Iterator<Entry<K, V>> mo434l();

    abstract Map<K, Collection<V>> mo435m();

    AbstractMultimap() {
    }

    public boolean mo420n() {
        return mo413f() == 0;
    }

    public boolean mo416g(@Nullable Object obj) {
        for (Collection contains : mo426b().values()) {
            if (contains.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean mo410b(@Nullable Object obj, @Nullable Object obj2) {
        Collection collection = (Collection) mo426b().get(obj);
        return collection != null && collection.contains(obj2);
    }

    public boolean mo412c(@Nullable Object obj, @Nullable Object obj2) {
        Collection collection = (Collection) mo426b().get(obj);
        return collection != null && collection.remove(obj2);
    }

    public boolean mo431a(@Nullable K k, @Nullable V v) {
        return mo427c(k).add(v);
    }

    public boolean mo409a(@Nullable K k, Iterable<? extends V> iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.isEmpty() || !mo427c(k).addAll(collection)) {
                return false;
            }
            return true;
        }
        Iterator it = iterable.iterator();
        if (it.hasNext() && Iterators.m1411a(mo427c(k), it)) {
            return true;
        }
        return false;
    }

    public boolean mo408a(Multimap<? extends K, ? extends V> multimap) {
        boolean z = false;
        for (Entry entry : multimap.mo419k()) {
            z = mo431a(entry.getKey(), entry.getValue()) | z;
        }
        return z;
    }

    public Collection<Entry<K, V>> mo419k() {
        Collection<Entry<K, V>> collection = this.f1545a;
        if (collection != null) {
            return collection;
        }
        collection = mo1992o();
        this.f1545a = collection;
        return collection;
    }

    Collection<Entry<K, V>> mo1992o() {
        if (this instanceof SetMultimap) {
            return new EntrySet(this);
        }
        return new Entries(this);
    }

    public Set<K> mo421p() {
        Set<K> set = this.f1546b;
        if (set != null) {
            return set;
        }
        set = mo432h();
        this.f1546b = set;
        return set;
    }

    Set<K> mo432h() {
        return new KeySet(mo426b());
    }

    public Multiset<K> mo422q() {
        Multiset<K> multiset = this.f1547c;
        if (multiset != null) {
            return multiset;
        }
        multiset = mo1993r();
        this.f1547c = multiset;
        return multiset;
    }

    Multiset<K> mo1993r() {
        return new Keys(this);
    }

    public Collection<V> mo418i() {
        Collection<V> collection = this.f1548d;
        if (collection != null) {
            return collection;
        }
        collection = mo1994s();
        this.f1548d = collection;
        return collection;
    }

    Collection<V> mo1994s() {
        return new Values(this);
    }

    Iterator<V> mo433j() {
        return Maps.m832b(mo419k().iterator());
    }

    public Map<K, Collection<V>> mo426b() {
        Map<K, Collection<V>> map = this.f1549e;
        if (map != null) {
            return map;
        }
        map = mo435m();
        this.f1549e = map;
        return map;
    }

    public boolean equals(@Nullable Object obj) {
        return Multimaps.a(this, obj);
    }

    public int hashCode() {
        return mo426b().hashCode();
    }

    public String toString() {
        return mo426b().toString();
    }
}
