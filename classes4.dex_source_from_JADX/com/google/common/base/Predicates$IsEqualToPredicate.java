package com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

/* compiled from: tooltip_nux_categories */
class Predicates$IsEqualToPredicate<T> implements Predicate<T>, Serializable {
    private final T target;

    public Predicates$IsEqualToPredicate(T t) {
        this.target = t;
    }

    public boolean apply(T t) {
        return this.target.equals(t);
    }

    public int hashCode() {
        return this.target.hashCode();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Predicates$IsEqualToPredicate)) {
            return false;
        }
        return this.target.equals(((Predicates$IsEqualToPredicate) obj).target);
    }

    public String toString() {
        return "Predicates.equalTo(" + this.target + ")";
    }
}
