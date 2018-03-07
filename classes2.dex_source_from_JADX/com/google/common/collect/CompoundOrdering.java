package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Comparator;

@GwtCompatible
/* compiled from: gk_exoplayer_bad_stop */
final class CompoundOrdering<T> extends Ordering<T> implements Serializable {
    final ImmutableList<Comparator<? super T>> comparators;

    CompoundOrdering(Comparator<? super T> comparator, Comparator<? super T> comparator2) {
        this.comparators = ImmutableList.of(comparator, comparator2);
    }

    public final int compare(T t, T t2) {
        int size = this.comparators.size();
        for (int i = 0; i < size; i++) {
            int compare = ((Comparator) this.comparators.get(i)).compare(t, t2);
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CompoundOrdering)) {
            return false;
        }
        return this.comparators.equals(((CompoundOrdering) obj).comparators);
    }

    public final int hashCode() {
        return this.comparators.hashCode();
    }

    public final String toString() {
        return "Ordering.compound(" + this.comparators + ")";
    }
}
