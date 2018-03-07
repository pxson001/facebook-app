package com.facebook.common.util;

import java.util.Set;

/* compiled from: first_install_time */
public class BitmaskEnumUtil {
    private static final Class<?> f23625a = BitmaskEnumUtil.class;

    private BitmaskEnumUtil() {
    }

    public static long m32026a(Enum enumR) {
        return (long) (1 << enumR.ordinal());
    }

    public static <T extends Enum<T>> long m32027a(Set<T> set) {
        long j = 0;
        for (T a : set) {
            j = m32026a((Enum) a) | j;
        }
        return j;
    }
}
