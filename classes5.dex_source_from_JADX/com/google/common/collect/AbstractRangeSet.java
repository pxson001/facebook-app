package com.google.common.collect;

import javax.annotation.Nullable;

/* compiled from: calling_class */
abstract class AbstractRangeSet<C extends Comparable> implements RangeSet<C> {
    AbstractRangeSet() {
    }

    public void mo894a(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    public void mo1011b(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RangeSet)) {
            return false;
        }
        return mo1009a().equals(((RangeSet) obj).mo1009a());
    }

    public final int hashCode() {
        return mo1009a().hashCode();
    }

    public final String toString() {
        return mo1009a().toString();
    }
}
