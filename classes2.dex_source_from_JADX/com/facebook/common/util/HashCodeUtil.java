package com.facebook.common.util;

import javax.annotation.Nullable;

/* compiled from: memory_cache_miss */
public class HashCodeUtil {
    public static int m20813a(@Nullable Object obj) {
        int i;
        if (obj == null) {
            i = 0;
        } else {
            i = obj.hashCode();
        }
        return i + 31;
    }

    public static int m20814a(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3) {
        int i;
        int i2;
        int i3 = 0;
        if (obj == null) {
            i = 0;
        } else {
            i = obj.hashCode();
        }
        if (obj2 == null) {
            i2 = 0;
        } else {
            i2 = obj2.hashCode();
        }
        if (obj3 != null) {
            i3 = obj3.hashCode();
        }
        return ((((i + 31) * 31) + i2) * 31) + i3;
    }

    public static int m20815a(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6) {
        int i = 0;
        int hashCode = obj == null ? 0 : obj.hashCode();
        int hashCode2 = obj2 == null ? 0 : obj2.hashCode();
        int hashCode3 = obj3 == null ? 0 : obj3.hashCode();
        int hashCode4 = obj4 == null ? 0 : obj4.hashCode();
        int hashCode5 = obj5 == null ? 0 : obj5.hashCode();
        if (obj6 != null) {
            i = obj6.hashCode();
        }
        return m20812a(hashCode, hashCode2, hashCode3, hashCode4, hashCode5, i);
    }

    private static int m20812a(int i, int i2, int i3, int i4, int i5, int i6) {
        return ((((((((((i + 31) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + i6;
    }
}
