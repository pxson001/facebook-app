package com.facebook.react.views.view;

/* compiled from: fixed_width */
public class ColorUtil {
    public static int m14198a(int i, int i2) {
        if (i2 == 255) {
            return i;
        }
        if (i2 == 0) {
            return i & 16777215;
        }
        return (((((i2 >> 7) + i2) * (i >>> 24)) >> 8) << 24) | (i & 16777215);
    }

    public static int m14197a(int i) {
        int i2 = i >>> 24;
        if (i2 == 255) {
            return -1;
        }
        if (i2 == 0) {
            return -2;
        }
        return -3;
    }
}
