package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Multiset.Entry;
import com.google.j2objc.annotations.Weak;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: bug_reporter_chooser */
final class SortedMultisets {

    /* compiled from: bug_reporter_chooser */
    public class ElementSet<E> extends Multisets$ElementSet<E> implements SortedSet<E> {
        @Weak
        public final SortedMultiset<E> f7548a;

        ElementSet(SortedMultiset<E> sortedMultiset) {
            this.f7548a = sortedMultiset;
        }

        final /* synthetic */ Multiset mo891a() {
            return this.f7548a;
        }

        public Comparator<? super E> comparator() {
            return this.f7548a.comparator();
        }

        public E first() {
            return SortedMultisets.m13662c(this.f7548a.mo904h());
        }

        public SortedSet<E> headSet(E e) {
            return this.f7548a.mo895a(e, BoundType.OPEN).mo903g();
        }

        public E last() {
            return SortedMultisets.m13662c(this.f7548a.mo905i());
        }

        public SortedSet<E> subSet(E e, E e2) {
            return this.f7548a.mo896a(e, BoundType.CLOSED, e2, BoundType.OPEN).mo903g();
        }

        public SortedSet<E> tailSet(E e) {
            return this.f7548a.mo898b(e, BoundType.CLOSED).mo903g();
        }
    }

    @GwtIncompatible("Navigable")
    /* compiled from: bug_reporter_chooser */
    class NavigableElementSet<E> extends ElementSet<E> implements NavigableSet<E> {
        public E ceiling(E e) {
            return SortedMultisets.m13663d(this.f7548a.mo898b(e, BoundType.CLOSED).mo904h());
        }

        public E floor(E e) {
            return SortedMultisets.m13663d(this.f7548a.mo895a(e, BoundType.CLOSED).mo905i());
        }

        public E higher(E e) {
            return SortedMultisets.m13663d(this.f7548a.mo898b(e, BoundType.OPEN).mo904h());
        }

        public E lower(E e) {
            return SortedMultisets.m13663d(this.f7548a.mo895a(e, BoundType.OPEN).mo905i());
        }

        public E pollFirst() {
            return SortedMultisets.m13663d(this.f7548a.mo906j());
        }

        public E pollLast() {
            return SortedMultisets.m13663d(this.f7548a.mo907k());
        }

        NavigableElementSet(SortedMultiset<E> sortedMultiset) {
            super(sortedMultiset);
        }

        public NavigableSet<E> descendingSet() {
            return new NavigableElementSet(this.f7548a.mo909n());
        }

        public Iterator<E> descendingIterator() {
            return descendingSet().iterator();
        }

        public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
            return new NavigableElementSet(this.f7548a.mo896a(e, BoundType.forBoolean(z), e2, BoundType.forBoolean(z2)));
        }

        public NavigableSet<E> headSet(E e, boolean z) {
            return new NavigableElementSet(this.f7548a.mo895a(e, BoundType.forBoolean(z)));
        }

        public NavigableSet<E> tailSet(E e, boolean z) {
            return new NavigableElementSet(this.f7548a.mo898b(e, BoundType.forBoolean(z)));
        }
    }

    private SortedMultisets() {
    }

    public static <E> E m13662c(Entry<E> entry) {
        if (entry != null) {
            return entry.mo889a();
        }
        throw new NoSuchElementException();
    }

    public static <E> E m13663d(@Nullable Entry<E> entry) {
        return entry == null ? null : entry.mo889a();
    }
}
