package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
@CheckReturnValue
/* compiled from: survey_context_data */
public abstract class Optional<T> implements Serializable {
    public abstract boolean equals(@Nullable Object obj);

    public abstract T get();

    public abstract boolean isPresent();

    public abstract T or(T t);

    @Nullable
    public abstract T orNull();

    public abstract String toString();

    public static <T> Optional<T> of(T t) {
        return new Present(Preconditions.checkNotNull(t));
    }

    public static <T> Optional<T> fromNullable(@Nullable T t) {
        return t == null ? Absent.INSTANCE : new Present(t);
    }

    Optional() {
    }
}
