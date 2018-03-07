package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtIncompatible("Class.isInstance")
/* compiled from: tooltip_nux_categories */
public class Predicates$InstanceOfPredicate implements Predicate<Object>, Serializable {
    private final Class<?> clazz;

    public Predicates$InstanceOfPredicate(Class<?> cls) {
        this.clazz = (Class) Preconditions.checkNotNull(cls);
    }

    public boolean apply(@Nullable Object obj) {
        return this.clazz.isInstance(obj);
    }

    public int hashCode() {
        return this.clazz.hashCode();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Predicates$InstanceOfPredicate)) {
            return false;
        }
        if (this.clazz == ((Predicates$InstanceOfPredicate) obj).clazz) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Predicates.instanceOf(" + this.clazz.getName() + ")";
    }
}
