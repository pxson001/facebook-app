package com.facebook.livephotos.exoplayer.util;

import android.text.TextUtils;

/* compiled from: original_image_height */
public final class Assertions {
    private Assertions() {
    }

    public static void m9295a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void m9296a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void m9297b(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void m9298b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static <T> T m9293a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static String m9294a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException();
    }
}
