package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.collect.Multiset.Entry;
import com.google.common.collect.Multisets.AbstractEntry;
import com.google.common.primitives.Ints;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: offersite/detail/view/?offer_view_id=%s&share_id=%s&site_uri=%s&title=%s&offer_code=%s */
public abstract class AbstractMultiset<E> extends AbstractCollection<E> implements Multiset<E> {
    private transient Set<E> f11461a;
    private transient Set<Entry<E>> f11462b;

    /* compiled from: offersite/detail/view/?offer_view_id=%s&share_id=%s&site_uri=%s&title=%s&offer_code=%s */
    class EntrySet extends Multisets$EntrySet<E> {
        final /* synthetic */ AbstractMultiset f11463a;

        EntrySet(AbstractMultiset abstractMultiset) {
            this.f11463a = abstractMultiset;
        }

        final Multiset<E> mo2173a() {
            return this.f11463a;
        }

        public Iterator<Entry<E>> iterator() {
            return this.f11463a.mo2166b();
        }

        public int size() {
            return this.f11463a.mo2167c();
        }
    }

    abstract Iterator<Entry<E>> mo2166b();

    abstract int mo2167c();

    AbstractMultiset() {
    }

    public boolean isEmpty() {
        return mo2172a().isEmpty();
    }

    public boolean contains(@Nullable Object obj) {
        return mo2163a(obj) > 0;
    }

    public Iterator<E> iterator() {
        return Multisets.a(this);
    }

    public int mo2163a(@Nullable Object obj) {
        for (AbstractEntry abstractEntry : mo2172a()) {
            if (Objects.equal(abstractEntry.a(), obj)) {
                return abstractEntry.b();
            }
        }
        return 0;
    }

    public boolean add(@Nullable E e) {
        mo2164a(e, 1);
        return true;
    }

    public int mo2164a(@Nullable E e, int i) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(@Nullable Object obj) {
        return mo2165b(obj, 1) > 0;
    }

    public int mo2165b(@Nullable Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends E> collection) {
        return Multisets.a(this, collection);
    }

    public boolean removeAll(Collection<?> collection) {
        return Multisets.b(this, collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return Multisets.c(this, collection);
    }

    public void clear() {
        Iterators.m1429h(mo2166b());
    }

    public Set<E> mo2155d() {
        Set<E> set = this.f11461a;
        if (set != null) {
            return set;
        }
        set = m16759e();
        this.f11461a = set;
        return set;
    }

    Set<E> m16759e() {
        return new ElementSet(this);
    }

    public Set<Entry<E>> mo2172a() {
        Set<Entry<E>> set = this.f11462b;
        if (set != null) {
            return set;
        }
        set = m16760f();
        this.f11462b = set;
        return set;
    }

    Set<Entry<E>> m16760f() {
        return new EntrySet(this);
    }

    public boolean equals(@Nullable Object obj) {
        return Multisets.a(this, obj);
    }

    public int hashCode() {
        return mo2172a().hashCode();
    }

    public String toString() {
        return mo2172a().toString();
    }

    public int mo2168c(@Nullable E e, int i) {
        CollectPreconditions.m615a(i, "count");
        int a = mo2163a(e);
        int i2 = i - a;
        if (i2 > 0) {
            mo2164a(e, i2);
        } else if (i2 < 0) {
            mo2165b(e, -i2);
        }
        return a;
    }

    public boolean mo2151a(@Nullable E e, int i, int i2) {
        boolean z;
        CollectPreconditions.m615a(i, "oldCount");
        CollectPreconditions.m615a(i2, "newCount");
        if (mo2163a(e) == i) {
            mo2168c(e, i2);
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public int size() {
        long j = 0;
        for (AbstractEntry b : mo2172a()) {
            j = ((long) b.b()) + j;
        }
        return Ints.m4489b(j);
    }
}
