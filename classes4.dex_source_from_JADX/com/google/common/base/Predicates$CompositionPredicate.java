package com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

/* compiled from: tooltip_nux_categories */
class Predicates$CompositionPredicate<A, B> implements Predicate<A>, Serializable {
    final Function<A, ? extends B> f10752f;
    final Predicate<B> f10753p;

    public Predicates$CompositionPredicate(Predicate<B> predicate, Function<A, ? extends B> function) {
        this.f10753p = (Predicate) Preconditions.checkNotNull(predicate);
        this.f10752f = (Function) Preconditions.checkNotNull(function);
    }

    public boolean apply(@Nullable A a) {
        return this.f10753p.apply(this.f10752f.apply(a));
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Predicates$CompositionPredicate)) {
            return false;
        }
        Predicates$CompositionPredicate predicates$CompositionPredicate = (Predicates$CompositionPredicate) obj;
        if (this.f10752f.equals(predicates$CompositionPredicate.f10752f) && this.f10753p.equals(predicates$CompositionPredicate.f10753p)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f10752f.hashCode() ^ this.f10753p.hashCode();
    }

    public String toString() {
        return this.f10753p + "(" + this.f10752f + ")";
    }
}
