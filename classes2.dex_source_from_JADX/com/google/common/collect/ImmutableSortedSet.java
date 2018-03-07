package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: tls_cache_hit */
public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements SortedIterable<E>, NavigableSet<E> {
    private static final Comparator<Comparable> f2532c = NaturalOrdering.f22266a;
    private static final RegularImmutableSortedSet<Comparable> f2533d = new RegularImmutableSortedSet(RegularImmutableList.f535a, f2532c);
    public final transient Comparator<? super E> f2534a;
    @GwtIncompatible("NavigableSet")
    transient ImmutableSortedSet<E> f2535b;

    abstract int m4690a(@Nullable Object obj);

    abstract ImmutableSortedSet<E> m4693a(E e, boolean z);

    abstract ImmutableSortedSet<E> m4694a(E e, boolean z, E e2, boolean z2);

    abstract ImmutableSortedSet<E> m4695b(E e, boolean z);

    @GwtIncompatible("NavigableSet")
    public abstract UnmodifiableIterator<E> m4697b();

    public abstract UnmodifiableIterator<E> iterator();

    @GwtIncompatible("NavigableSet")
    public /* synthetic */ Iterator descendingIterator() {
        return m4697b();
    }

    @GwtIncompatible("NavigableSet")
    public /* synthetic */ NavigableSet descendingSet() {
        return m4692a();
    }

    @GwtIncompatible("NavigableSet")
    public /* synthetic */ NavigableSet headSet(Object obj, boolean z) {
        return m4699c(obj, z);
    }

    @GwtIncompatible("NavigableSet")
    public /* synthetic */ NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return m4696b(obj, z, obj2, z2);
    }

    @GwtIncompatible("NavigableSet")
    public /* synthetic */ NavigableSet tailSet(Object obj, boolean z) {
        return m4700d(obj, z);
    }

    static <E> RegularImmutableSortedSet<E> m4687a(Comparator<? super E> comparator) {
        if (f2532c.equals(comparator)) {
            return f2533d;
        }
        return new RegularImmutableSortedSet(RegularImmutableList.f535a, comparator);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> m4685a(E e, E e2, E e3) {
        return m4686a(NaturalOrdering.f22266a, 3, e, e2, e3);
    }

    public static <E> ImmutableSortedSet<E> m4686a(Comparator<? super E> comparator, int i, E... eArr) {
        if (i == 0) {
            return m4687a((Comparator) comparator);
        }
        ObjectArrays.m634c(eArr, i);
        Arrays.sort(eArr, 0, i, comparator);
        int i2 = 1;
        int i3 = 1;
        while (i2 < i) {
            int i4;
            Object obj = eArr[i2];
            if (comparator.compare(obj, eArr[i3 - 1]) != 0) {
                i4 = i3 + 1;
                eArr[i3] = obj;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        Arrays.fill(eArr, i3, i, null);
        return new RegularImmutableSortedSet(ImmutableList.asImmutableList(eArr, i3), comparator);
    }

    public static <E> Builder<E> m4688b(Comparator<E> comparator) {
        return new Builder(comparator);
    }

    public static <E extends Comparable<?>> Builder<E> m4689d() {
        return new Builder(NaturalOrdering.f22266a);
    }

    final int m4691a(Object obj, Object obj2) {
        return this.f2534a.compare(obj, obj2);
    }

    ImmutableSortedSet(Comparator<? super E> comparator) {
        this.f2534a = comparator;
    }

    public Comparator<? super E> comparator() {
        return this.f2534a;
    }

    public SortedSet headSet(Object obj) {
        return m4699c(obj, false);
    }

    @GwtIncompatible("NavigableSet")
    public final ImmutableSortedSet<E> m4699c(E e, boolean z) {
        return m4693a(Preconditions.checkNotNull(e), z);
    }

    public SortedSet subSet(Object obj, Object obj2) {
        return m4696b(obj, true, obj2, false);
    }

    @GwtIncompatible("NavigableSet")
    public final ImmutableSortedSet<E> m4696b(E e, boolean z, E e2, boolean z2) {
        Preconditions.checkNotNull(e);
        Preconditions.checkNotNull(e2);
        Preconditions.checkArgument(this.f2534a.compare(e, e2) <= 0);
        return m4694a(e, z, e2, z2);
    }

    public SortedSet tailSet(Object obj) {
        return m4700d(obj, true);
    }

    @GwtIncompatible("NavigableSet")
    public final ImmutableSortedSet<E> m4700d(E e, boolean z) {
        return m4695b(Preconditions.checkNotNull(e), z);
    }

    @GwtIncompatible("NavigableSet")
    public E lower(E e) {
        return Iterators.m1418b(m4699c(e, false).m4697b(), null);
    }

    @GwtIncompatible("NavigableSet")
    public E floor(E e) {
        return Iterators.m1418b(m4699c(e, true).m4697b(), null);
    }

    @GwtIncompatible("NavigableSet")
    public E ceiling(E e) {
        return Iterables.m950a(m4700d(e, true), null);
    }

    @GwtIncompatible("NavigableSet")
    public E higher(E e) {
        return Iterables.m950a(m4700d(e, false), null);
    }

    public E first() {
        return iterator().next();
    }

    public E last() {
        return m4697b().next();
    }

    @GwtIncompatible("NavigableSet")
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @GwtIncompatible("NavigableSet")
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    @GwtIncompatible("NavigableSet")
    public ImmutableSortedSet<E> m4692a() {
        ImmutableSortedSet<E> immutableSortedSet = this.f2535b;
        if (immutableSortedSet != null) {
            return immutableSortedSet;
        }
        immutableSortedSet = m4698c();
        this.f2535b = immutableSortedSet;
        immutableSortedSet.f2535b = this;
        return immutableSortedSet;
    }

    @GwtIncompatible("NavigableSet")
    ImmutableSortedSet<E> m4698c() {
        return new DescendingImmutableSortedSet(this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    Object writeReplace() {
        return new SerializedForm(this.f2534a, toArray());
    }
}
