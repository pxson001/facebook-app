package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.util.Iterator;
import java.util.NavigableSet;
import javax.annotation.Nullable;

/* compiled from: callerUid */
class DescendingImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    private final ImmutableSortedSet<E> forward;

    @GwtIncompatible("NavigableSet")
    public /* synthetic */ Iterator descendingIterator() {
        return m13331b();
    }

    @GwtIncompatible("NavigableSet")
    public /* synthetic */ NavigableSet descendingSet() {
        return m13327a();
    }

    DescendingImmutableSortedSet(ImmutableSortedSet<E> immutableSortedSet) {
        super(Ordering.a(immutableSortedSet.comparator()).a());
        this.forward = immutableSortedSet;
    }

    public boolean contains(@Nullable Object obj) {
        return this.forward.contains(obj);
    }

    public int size() {
        return this.forward.size();
    }

    public UnmodifiableIterator<E> iterator() {
        return this.forward.b();
    }

    final ImmutableSortedSet<E> m13328a(E e, boolean z) {
        return this.forward.d(e, z).a();
    }

    final ImmutableSortedSet<E> m13329a(E e, boolean z, E e2, boolean z2) {
        return this.forward.b(e2, z2, e, z).a();
    }

    final ImmutableSortedSet<E> m13330b(E e, boolean z) {
        return this.forward.c(e, z).a();
    }

    @GwtIncompatible("NavigableSet")
    public final ImmutableSortedSet<E> m13327a() {
        return this.forward;
    }

    @GwtIncompatible("NavigableSet")
    public final UnmodifiableIterator<E> m13331b() {
        return this.forward.iterator();
    }

    @GwtIncompatible("NavigableSet")
    final ImmutableSortedSet<E> m13332c() {
        throw new AssertionError("should never be called");
    }

    public E lower(E e) {
        return this.forward.higher(e);
    }

    public E floor(E e) {
        return this.forward.ceiling(e);
    }

    public E ceiling(E e) {
        return this.forward.floor(e);
    }

    public E higher(E e) {
        return this.forward.lower(e);
    }

    final int m13326a(@Nullable Object obj) {
        int a = this.forward.a(obj);
        return a == -1 ? a : (size() - 1) - a;
    }

    boolean isPartialView() {
        return this.forward.isPartialView();
    }
}
