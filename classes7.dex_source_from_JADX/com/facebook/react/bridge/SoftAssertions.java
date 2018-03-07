package com.facebook.react.bridge;

import javax.annotation.Nullable;

/* compiled from: gif_picker_search_returned */
public class SoftAssertions {
    public static void m13550a(String str) {
        throw new AssertionException(str);
    }

    public static void m13551a(boolean z, String str) {
        if (!z) {
            throw new AssertionException(str);
        }
    }

    public static <T> T m13549a(@Nullable T t) {
        if (t != null) {
            return t;
        }
        throw new AssertionException("Expected object to not be null!");
    }
}
