package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: small_picture_url */
public final class Absent<T> extends Optional<T> {
    public static final Absent<Object> INSTANCE = new Absent();

    public static <T> Optional<T> withType() {
        return INSTANCE;
    }

    private Absent() {
    }

    public final boolean isPresent() {
        return false;
    }

    public final T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public final T or(T t) {
        return Preconditions.checkNotNull(t, "use Optional.orNull() instead of Optional.or(null)");
    }

    @Nullable
    public final T orNull() {
        return null;
    }

    public final boolean equals(@Nullable Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
