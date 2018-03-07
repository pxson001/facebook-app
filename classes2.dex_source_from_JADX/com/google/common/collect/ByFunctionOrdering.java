package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: gk_state */
final class ByFunctionOrdering<F, T> extends Ordering<F> implements Serializable {
    final Function<F, ? extends T> function;
    final Ordering<T> ordering;

    ByFunctionOrdering(Function<F, ? extends T> function, Ordering<T> ordering) {
        this.function = (Function) Preconditions.checkNotNull(function);
        this.ordering = (Ordering) Preconditions.checkNotNull(ordering);
    }

    public final int compare(F f, F f2) {
        return this.ordering.compare(this.function.apply(f), this.function.apply(f2));
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByFunctionOrdering)) {
            return false;
        }
        ByFunctionOrdering byFunctionOrdering = (ByFunctionOrdering) obj;
        if (this.function.equals(byFunctionOrdering.function) && this.ordering.equals(byFunctionOrdering.ordering)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.function, this.ordering);
    }

    public final String toString() {
        return this.ordering + ".onResultOf(" + this.function + ")";
    }
}
