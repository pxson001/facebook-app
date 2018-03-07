package com.facebook.common.util;

import java.util.Locale;

/* compiled from: mark_folder_seen */
public class StringLocaleUtil {
    public static final String m21640a(String str, Object... objArr) {
        return String.format(Locale.getDefault(), str, objArr);
    }

    public static final String m21639a(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(Locale.US);
    }

    public static final String m21641b(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase(Locale.US);
    }
}
