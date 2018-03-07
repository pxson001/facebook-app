package com.facebook.common.hasvalue;

import com.google.common.base.Objects;
import javax.annotation.Nullable;

/* compiled from: creativecam_exit_back */
public class HasValueUtil {
    @Nullable
    public static <T, E extends HasValue<T>> E m20652a(E[] eArr, @Nullable T t) {
        for (E e : eArr) {
            if (Objects.equal(e.getValue(), t)) {
                return e;
            }
        }
        return null;
    }

    private HasValueUtil() {
    }
}
