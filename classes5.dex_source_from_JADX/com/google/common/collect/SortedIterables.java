package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.SortedSet;

@GwtCompatible
/* compiled from: bug_shots */
public final class SortedIterables {
    private SortedIterables() {
    }

    public static boolean m13658a(Comparator<?> comparator, Iterable<?> iterable) {
        Object obj;
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof SortedSet) {
            Comparator comparator2 = ((SortedSet) iterable).comparator();
            if (comparator2 == null) {
                comparator2 = NaturalOrdering.a;
            }
            obj = comparator2;
        } else if (!(iterable instanceof SortedIterable)) {
            return false;
        } else {
            obj = ((SortedIterable) iterable).comparator();
        }
        return comparator.equals(obj);
    }
}
