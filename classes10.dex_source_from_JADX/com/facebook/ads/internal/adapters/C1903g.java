package com.facebook.ads.internal.adapters;

import java.util.Locale;

public enum C1903g {
    UNKNOWN,
    AN;

    public static C1903g m14242a(String str) {
        if (str == null) {
            return UNKNOWN;
        }
        try {
            return (C1903g) Enum.valueOf(C1903g.class, str.toUpperCase(Locale.getDefault()));
        } catch (Exception e) {
            return UNKNOWN;
        }
    }
}
