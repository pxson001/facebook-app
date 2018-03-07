package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzf;
import java.util.Collection;

public final class CastMediaControlIntent {
    private CastMediaControlIntent() {
    }

    public static String m11768a(String str) {
        if (str != null) {
            return m11769a("com.google.android.gms.cast.CATEGORY_CAST", str, null);
        }
        throw new IllegalArgumentException("applicationId cannot be null");
    }

    private static String m11769a(String str, String str2, Collection<String> collection) {
        String toUpperCase;
        StringBuilder stringBuilder = new StringBuilder(str);
        if (str2 != null) {
            toUpperCase = str2.toUpperCase();
            if (toUpperCase.matches("[A-F0-9]+")) {
                stringBuilder.append("/").append(toUpperCase);
            } else {
                throw new IllegalArgumentException("Invalid application ID: " + str2);
            }
        }
        if (collection != null) {
            if (collection.isEmpty()) {
                throw new IllegalArgumentException("Must specify at least one namespace");
            }
            if (str2 == null) {
                stringBuilder.append("/");
            }
            stringBuilder.append("/");
            Object obj = 1;
            for (String toUpperCase2 : collection) {
                zzf.m11921a(toUpperCase2);
                if (obj != null) {
                    obj = null;
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append(zzf.m11923c(toUpperCase2));
            }
        }
        return stringBuilder.toString();
    }
}
