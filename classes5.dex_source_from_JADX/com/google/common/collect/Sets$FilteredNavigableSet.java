package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.NavigableSet;
import javax.annotation.Nullable;

@GwtIncompatible("NavigableSet")
/* compiled from: bug_source */
class Sets$FilteredNavigableSet<E> extends Sets$FilteredSortedSet<E> implements NavigableSet<E> {
    Sets$FilteredNavigableSet(NavigableSet<E> navigableSet, Predicate<? super E> predicate) {
        super(navigableSet, predicate);
    }

    private NavigableSet<E> m13657a() {
        return (NavigableSet) this.a;
    }

    @Nullable
    public E lower(E e) {
        return Iterators.b(headSet(e, false).descendingIterator(), null);
    }

    @Nullable
    public E floor(E e) {
        return Iterators.b(headSet(e, true).descendingIterator(), null);
    }

    public E ceiling(E e) {
        return Iterables.a(tailSet(e, true), null);
    }

    public E higher(E e) {
        return Iterables.a(tailSet(e, false), null);
    }

    public E pollFirst() {
        return Iterables.b(m13657a(), this.b);
    }

    public E pollLast() {
        return Iterables.b(m13657a().descendingSet(), this.b);
    }

    public NavigableSet<E> descendingSet() {
        return Sets.a(m13657a().descendingSet(), this.b);
    }

    public Iterator<E> descendingIterator() {
        return Iterators.b(m13657a().descendingIterator(), this.b);
    }

    public E last() {
        return descendingIterator().next();
    }

    public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        return Sets.a(m13657a().subSet(e, z, e2, z2), this.b);
    }

    public NavigableSet<E> headSet(E e, boolean z) {
        return Sets.a(m13657a().headSet(e, z), this.b);
    }

    public NavigableSet<E> tailSet(E e, boolean z) {
        return Sets.a(m13657a().tailSet(e, z), this.b);
    }
}
