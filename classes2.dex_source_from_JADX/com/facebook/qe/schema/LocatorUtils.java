package com.facebook.qe.schema;

/* compiled from: timeline_set_cover_photo */
public class LocatorUtils {
    public static boolean m4735a(char c) {
        return (c & 1) != 0;
    }

    public static boolean m4737a(short s) {
        return (s & 1) != 0;
    }

    public static int m4741b(short s) {
        int i;
        if (s <= Short.MAX_VALUE) {
            i = 32768 + s;
        } else {
            i = s - 32768;
        }
        return i >> 1;
    }

    public static boolean m4736a(int i) {
        return (i & 1) != 0;
    }

    public static int m4740b(long j) {
        return ((int) j) >> 1;
    }

    public static int m4739b(float f) {
        return ((int) f) >> 1;
    }

    public static int m4738b(double d) {
        return ((int) d) >> 1;
    }
}
