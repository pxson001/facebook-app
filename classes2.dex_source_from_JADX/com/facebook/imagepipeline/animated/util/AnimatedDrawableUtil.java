package com.facebook.imagepipeline.animated.util;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build.VERSION;

/* compiled from: menuConfig */
public class AnimatedDrawableUtil {
    public static void m20768a(StringBuilder stringBuilder, int i) {
        if (i < 1024) {
            stringBuilder.append(i);
            stringBuilder.append("KB");
            return;
        }
        int i2 = (i % 1024) / 100;
        stringBuilder.append(i / 1024);
        stringBuilder.append(".");
        stringBuilder.append(i2);
        stringBuilder.append("MB");
    }

    @SuppressLint({"NewApi"})
    public static int m20767a(Bitmap bitmap) {
        if (VERSION.SDK_INT >= 19) {
            return bitmap.getAllocationByteCount();
        }
        if (VERSION.SDK_INT >= 12) {
            return bitmap.getByteCount();
        }
        return (bitmap.getWidth() * bitmap.getHeight()) * 4;
    }

    public static boolean m20769a(int i, int i2, int i3) {
        boolean z = true;
        if (i == -1 || i2 == -1) {
            return true;
        }
        if (i > i2) {
            if (i3 >= i || i3 <= i2) {
                z = false;
            }
            return z;
        } else if (i3 < i || i3 > i2) {
            return true;
        } else {
            return false;
        }
    }
}
