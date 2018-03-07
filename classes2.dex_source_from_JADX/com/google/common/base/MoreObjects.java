package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: zeroOptout */
public final class MoreObjects {
    @CheckReturnValue
    public static <T> T firstNonNull(@Nullable T t, @Nullable T t2) {
        return t != null ? t : Preconditions.checkNotNull(t2);
    }

    @CheckReturnValue
    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName());
    }

    @CheckReturnValue
    public static ToStringHelper toStringHelper(Class<?> cls) {
        return new ToStringHelper(cls.getSimpleName());
    }

    private MoreObjects() {
    }
}
