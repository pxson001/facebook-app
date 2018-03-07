package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets.FilteredSet;
import java.util.Comparator;
import java.util.SortedSet;

/* compiled from: bug_source */
class Sets$FilteredSortedSet<E> extends FilteredSet<E> implements SortedSet<E> {
    Sets$FilteredSortedSet(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
        super(sortedSet, predicate);
    }

    public Comparator<? super E> comparator() {
        return ((SortedSet) this.a).comparator();
    }

    public SortedSet<E> subSet(E e, E e2) {
        return new Sets$FilteredSortedSet(((SortedSet) this.a).subSet(e, e2), this.b);
    }

    public SortedSet<E> headSet(E e) {
        return new Sets$FilteredSortedSet(((SortedSet) this.a).headSet(e), this.b);
    }

    public SortedSet<E> tailSet(E e) {
        return new Sets$FilteredSortedSet(((SortedSet) this.a).tailSet(e), this.b);
    }

    public E first() {
        return iterator().next();
    }

    public E last() {
        SortedSet sortedSet = (SortedSet) this.a;
        while (true) {
            E last = sortedSet.last();
            if (this.b.apply(last)) {
                return last;
            }
            sortedSet = sortedSet.headSet(last);
        }
    }
}
