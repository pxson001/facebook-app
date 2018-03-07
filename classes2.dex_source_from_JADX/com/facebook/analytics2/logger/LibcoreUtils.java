package com.facebook.analytics2.logger;

/* compiled from: t_omnistore_sync */
class LibcoreUtils {
    LibcoreUtils() {
    }

    public static void m5733a(int i, int i2, int i3) {
        if ((i2 | i3) < 0 || i2 > i || i - i2 < i3) {
            throw new ArrayIndexOutOfBoundsException("length=" + i + "; regionStart=" + i2 + "; regionLength=" + i3);
        }
    }

    public static StringIndexOutOfBoundsException m5732a(String str, int i, int i2) {
        return new StringIndexOutOfBoundsException("length=" + str.length() + "; regionStart=" + i + "; regionLength=" + i2);
    }
}
