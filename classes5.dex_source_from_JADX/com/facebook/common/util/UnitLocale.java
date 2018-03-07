package com.facebook.common.util;

import java.util.Locale;

/* compiled from: set_icon */
public enum UnitLocale {
    METRIC,
    IMPERIAL;

    public static UnitLocale getDefault() {
        return from(Locale.getDefault());
    }

    public static UnitLocale from(Locale locale) {
        return isImperial(locale.getCountry()) ? IMPERIAL : METRIC;
    }

    private static boolean isImperial(String str) {
        return "US".equals(str) || "LR".equals(str) || "GB".equals(str) || "MM".equals(str);
    }
}
