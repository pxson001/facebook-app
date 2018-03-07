package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: spdy/3.1-hpack */
final class Present<T> extends Optional<T> {
    private final T reference;

    Present(T t) {
        this.reference = t;
    }

    public final boolean isPresent() {
        return true;
    }

    public final T get() {
        return this.reference;
    }

    public final T or(T t) {
        Preconditions.checkNotNull(t, "use Optional.orNull() instead of Optional.or(null)");
        return this.reference;
    }

    public final T orNull() {
        return this.reference;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Present)) {
            return false;
        }
        return this.reference.equals(((Present) obj).reference);
    }

    public final int hashCode() {
        return 1502476572 + this.reference.hashCode();
    }

    public final String toString() {
        return "Optional.of(" + this.reference + ")";
    }
}
