package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset.Entry;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: calling getOption(int) on FakeSocketImpl */
public abstract class AbstractSortedMultiset<E> extends AbstractMultiset<E> implements SortedMultiset<E> {
    private transient SortedMultiset<E> f7291a;
    @GwtTransient
    final Comparator<? super E> comparator;

    abstract Iterator<Entry<E>> mo1008l();

    public final /* synthetic */ Set m13284d() {
        return mo903g();
    }

    AbstractSortedMultiset(Comparator<? super E> comparator) {
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
    }

    public NavigableSet<E> mo903g() {
        return (NavigableSet) super.d();
    }

    final Set m13285e() {
        return new NavigableElementSet(this);
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    public Entry<E> mo904h() {
        Iterator b = b();
        return b.hasNext() ? (Multisets$AbstractEntry) b.next() : null;
    }

    public Entry<E> mo905i() {
        Iterator l = mo1008l();
        return l.hasNext() ? (Multisets$AbstractEntry) l.next() : null;
    }

    public Entry<E> mo906j() {
        Iterator b = b();
        if (!b.hasNext()) {
            return null;
        }
        Multisets$AbstractEntry multisets$AbstractEntry = (Multisets$AbstractEntry) b.next();
        multisets$AbstractEntry = Multisets.a(multisets$AbstractEntry.mo889a(), multisets$AbstractEntry.mo890b());
        b.remove();
        return multisets$AbstractEntry;
    }

    public Entry<E> mo907k() {
        Iterator l = mo1008l();
        if (!l.hasNext()) {
            return null;
        }
        Multisets$AbstractEntry multisets$AbstractEntry = (Multisets$AbstractEntry) l.next();
        multisets$AbstractEntry = Multisets.a(multisets$AbstractEntry.mo889a(), multisets$AbstractEntry.mo890b());
        l.remove();
        return multisets$AbstractEntry;
    }

    public SortedMultiset<E> mo896a(@Nullable E e, BoundType boundType, @Nullable E e2, BoundType boundType2) {
        Preconditions.checkNotNull(boundType);
        Preconditions.checkNotNull(boundType2);
        return mo898b(e, boundType).mo895a(e2, boundType2);
    }

    public SortedMultiset<E> mo909n() {
        SortedMultiset<E> sortedMultiset = this.f7291a;
        if (sortedMultiset != null) {
            return sortedMultiset;
        }
        SortedMultiset anonymousClass1DescendingMultisetImpl = new DescendingMultiset<E>(this) {
            final /* synthetic */ AbstractSortedMultiset f7290a;

            {
                this.f7290a = r1;
            }

            final SortedMultiset<E> mo910c() {
                return this.f7290a;
            }

            final Iterator<Entry<E>> mo911f() {
                return this.f7290a.mo1008l();
            }

            public Iterator<E> iterator() {
                return Multisets.a(this.f7290a.mo909n());
            }
        };
        this.f7291a = anonymousClass1DescendingMultisetImpl;
        return anonymousClass1DescendingMultisetImpl;
    }

    AbstractSortedMultiset() {
        this(NaturalOrdering.a);
    }
}
