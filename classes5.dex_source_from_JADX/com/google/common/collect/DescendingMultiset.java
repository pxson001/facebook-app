package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset.Entry;
import com.google.common.collect.Multisets.EntrySet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;

@GwtCompatible
/* compiled from: calling getOutputStream() on FakeSocketImpl */
abstract class DescendingMultiset<E> extends ForwardingMultiset<E> implements SortedMultiset<E> {
    private transient Comparator<? super E> f7287a;
    private transient NavigableSet<E> f7288b;
    private transient Set<Entry<E>> f7289c;

    abstract SortedMultiset<E> mo910c();

    abstract Iterator<Entry<E>> mo911f();

    protected final /* synthetic */ Collection mo899b() {
        return mo908l();
    }

    public final /* synthetic */ Set mo901d() {
        return mo903g();
    }

    protected final /* synthetic */ Object mo902e() {
        return mo908l();
    }

    DescendingMultiset() {
    }

    public Comparator<? super E> comparator() {
        Comparator<? super E> comparator = this.f7287a;
        if (comparator != null) {
            return comparator;
        }
        Ordering a = Ordering.a(mo910c().comparator()).a();
        this.f7287a = a;
        return a;
    }

    public final NavigableSet<E> mo903g() {
        NavigableSet<E> navigableSet = this.f7288b;
        if (navigableSet != null) {
            return navigableSet;
        }
        navigableSet = new NavigableElementSet(this);
        this.f7288b = navigableSet;
        return navigableSet;
    }

    public final Entry<E> mo906j() {
        return mo910c().mo907k();
    }

    public final Entry<E> mo907k() {
        return mo910c().mo906j();
    }

    public final SortedMultiset<E> mo895a(E e, BoundType boundType) {
        return mo910c().mo898b(e, boundType).mo909n();
    }

    public final SortedMultiset<E> mo896a(E e, BoundType boundType, E e2, BoundType boundType2) {
        return mo910c().mo896a(e2, boundType2, e, boundType).mo909n();
    }

    public final SortedMultiset<E> mo898b(E e, BoundType boundType) {
        return mo910c().mo895a(e, boundType).mo909n();
    }

    protected final Multiset<E> mo908l() {
        return mo910c();
    }

    public final SortedMultiset<E> mo909n() {
        return mo910c();
    }

    public final Entry<E> mo904h() {
        return mo910c().mo905i();
    }

    public final Entry<E> mo905i() {
        return mo910c().mo904h();
    }

    public final Set<Entry<E>> mo897a() {
        Set<Entry<E>> set = this.f7289c;
        if (set != null) {
            return set;
        }
        set = new EntrySet<E>(this) {
            final /* synthetic */ DescendingMultiset f7296a;

            {
                this.f7296a = r1;
            }

            final Multiset<E> m13333a() {
                return this.f7296a;
            }

            public Iterator<Entry<E>> iterator() {
                return this.f7296a.mo911f();
            }

            public int size() {
                return this.f7296a.mo910c().mo897a().size();
            }
        };
        this.f7289c = set;
        return set;
    }

    public Iterator<E> iterator() {
        return Multisets.a(this);
    }

    public Object[] toArray() {
        return o();
    }

    public <T> T[] toArray(T[] tArr) {
        return a(tArr);
    }

    public String toString() {
        return mo897a().toString();
    }
}
