package com.google.common.base;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: tooltip_nux_categories */
class Predicates$AndPredicate<T> implements Predicate<T>, Serializable {
    private final List<? extends Predicate<? super T>> components;

    public Predicates$AndPredicate(List<? extends Predicate<? super T>> list) {
        this.components = list;
    }

    public boolean apply(@Nullable T t) {
        for (int i = 0; i < this.components.size(); i++) {
            if (!((Predicate) this.components.get(i)).apply(t)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.components.hashCode() + 306654252;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Predicates$AndPredicate)) {
            return false;
        }
        return this.components.equals(((Predicates$AndPredicate) obj).components);
    }

    public String toString() {
        return "Predicates.and(" + Predicates.COMMA_JOINER.join(this.components) + ")";
    }
}
