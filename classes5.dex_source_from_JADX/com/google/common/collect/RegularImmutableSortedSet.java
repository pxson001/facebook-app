package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.SortedLists.KeyAbsentBehavior;
import com.google.common.collect.SortedLists.KeyPresentBehavior;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: bugreport_attachments */
final class RegularImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    private final transient ImmutableList<E> f7538c;

    @GwtIncompatible("NavigableSet")
    public final /* synthetic */ Iterator descendingIterator() {
        return m13633b();
    }

    RegularImmutableSortedSet(ImmutableList<E> immutableList, Comparator<? super E> comparator) {
        super(comparator);
        this.f7538c = immutableList;
    }

    public final UnmodifiableIterator<E> iterator() {
        return this.f7538c.iterator();
    }

    @GwtIncompatible("NavigableSet")
    public final UnmodifiableIterator<E> m13633b() {
        return this.f7538c.reverse().iterator();
    }

    public final int size() {
        return this.f7538c.size();
    }

    public final boolean contains(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return m13626b(obj) >= 0;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public final boolean containsAll(Collection<?> collection) {
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).d();
        }
        if (!SortedIterables.m13658a(comparator(), collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        PeekingIterator i = Iterators.i(iterator());
        Iterator it = collection.iterator();
        Object next = it.next();
        while (i.hasNext()) {
            try {
                int a = a(i.mo932a(), next);
                if (a < 0) {
                    i.next();
                } else if (a == 0) {
                    if (!it.hasNext()) {
                        return true;
                    }
                    next = it.next();
                } else if (a > 0) {
                    return false;
                }
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return false;
    }

    private int m13626b(Object obj) {
        return Collections.binarySearch(this.f7538c, obj, this.a);
    }

    final boolean isPartialView() {
        return this.f7538c.isPartialView();
    }

    final int copyIntoArray(Object[] objArr, int i) {
        return this.f7538c.copyIntoArray(objArr, i);
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!SortedIterables.m13658a(this.a, set)) {
            return containsAll(set);
        }
        Iterator it = set.iterator();
        try {
            UnmodifiableIterator it2 = iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                Object next2 = it.next();
                if (next2 != null) {
                    if (a(next, next2) != 0) {
                    }
                }
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        } catch (NoSuchElementException e2) {
            return false;
        }
    }

    public final E first() {
        if (!isEmpty()) {
            return this.f7538c.get(0);
        }
        throw new NoSuchElementException();
    }

    public final E last() {
        if (!isEmpty()) {
            return this.f7538c.get(size() - 1);
        }
        throw new NoSuchElementException();
    }

    public final E lower(E e) {
        int e2 = m13635e(e, false) - 1;
        return e2 == -1 ? null : this.f7538c.get(e2);
    }

    public final E floor(E e) {
        int e2 = m13635e(e, true) - 1;
        return e2 == -1 ? null : this.f7538c.get(e2);
    }

    public final E ceiling(E e) {
        int f = m13636f(e, true);
        return f == size() ? null : this.f7538c.get(f);
    }

    public final E higher(E e) {
        int f = m13636f(e, false);
        return f == size() ? null : this.f7538c.get(f);
    }

    final ImmutableSortedSet<E> m13629a(E e, boolean z) {
        return m13631a(0, m13635e(e, z));
    }

    final int m13635e(E e, boolean z) {
        return SortedLists.m13660a(this.f7538c, Preconditions.checkNotNull(e), comparator(), z ? KeyPresentBehavior.FIRST_AFTER : KeyPresentBehavior.FIRST_PRESENT, KeyAbsentBehavior.NEXT_HIGHER);
    }

    final ImmutableSortedSet<E> m13630a(E e, boolean z, E e2, boolean z2) {
        return m13632b(e, z).a(e2, z2);
    }

    final ImmutableSortedSet<E> m13632b(E e, boolean z) {
        return m13631a(m13636f(e, z), size());
    }

    final int m13636f(E e, boolean z) {
        return SortedLists.m13660a(this.f7538c, Preconditions.checkNotNull(e), comparator(), z ? KeyPresentBehavior.FIRST_PRESENT : KeyPresentBehavior.FIRST_AFTER, KeyAbsentBehavior.NEXT_HIGHER);
    }

    private Comparator<Object> m13627e() {
        return this.a;
    }

    final RegularImmutableSortedSet<E> m13631a(int i, int i2) {
        if (i == 0 && i2 == size()) {
            return this;
        }
        if (i < i2) {
            return new RegularImmutableSortedSet(this.f7538c.subList(i, i2), this.a);
        }
        return ImmutableSortedSet.a(this.a);
    }

    final int m13628a(@Nullable Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            int a = SortedLists.m13660a(this.f7538c, obj, m13627e(), KeyPresentBehavior.ANY_PRESENT, KeyAbsentBehavior.INVERTED_INSERTION_INDEX);
            if (a >= 0) {
                return a;
            }
            return -1;
        } catch (ClassCastException e) {
            return -1;
        }
    }

    final ImmutableList<E> createAsList() {
        return size() <= 1 ? this.f7538c : new ImmutableSortedAsList(this, this.f7538c);
    }

    final ImmutableSortedSet<E> m13634c() {
        Ordering a = Ordering.a(this.a).a();
        if (isEmpty()) {
            return ImmutableSortedSet.a(a);
        }
        return new RegularImmutableSortedSet(this.f7538c.reverse(), a);
    }
}
