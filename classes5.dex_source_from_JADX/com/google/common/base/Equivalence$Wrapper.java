package com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

/* compiled from: can_edit_menu */
public final class Equivalence$Wrapper<T> implements Serializable {
    private final Equivalence<? super T> equivalence;
    @Nullable
    public final T reference;

    public Equivalence$Wrapper(Equivalence<? super T> equivalence, @Nullable T t) {
        this.equivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
        this.reference = t;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Equivalence$Wrapper) {
            Equivalence$Wrapper equivalence$Wrapper = (Equivalence$Wrapper) obj;
            if (this.equivalence.equals(equivalence$Wrapper.equivalence)) {
                return this.equivalence.equivalent(this.reference, equivalence$Wrapper.reference);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.equivalence.hash(this.reference);
    }

    public final String toString() {
        return this.equivalence + ".wrap(" + this.reference + ")";
    }
}
