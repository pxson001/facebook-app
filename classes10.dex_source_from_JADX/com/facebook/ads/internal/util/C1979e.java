package com.facebook.ads.internal.util;

import java.util.Locale;

public enum C1979e {
    NONE,
    INSTALLED,
    NOT_INSTALLED;

    public static C1979e m14452a(String str) {
        if (C1994r.m14486a(str)) {
            return NONE;
        }
        try {
            return C1979e.valueOf(str.toUpperCase(Locale.US));
        } catch (IllegalArgumentException e) {
            return NONE;
        }
    }
}
