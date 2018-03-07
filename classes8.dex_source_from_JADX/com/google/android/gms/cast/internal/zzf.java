package com.google.android.gms.cast.internal;

import android.text.TextUtils;
import java.util.regex.Pattern;

public final class zzf {
    private static final Pattern f10171a = Pattern.compile("urn:x-cast:[-A-Za-z0-9_]+(\\.[-A-Za-z0-9_]+)*");

    public static double m11919a(long j) {
        return ((double) j) / 1000.0d;
    }

    public static long m11920a(double d) {
        return (long) (1000.0d * d);
    }

    public static void m11921a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Namespace cannot be null or empty");
        } else if (str.length() > 128) {
            throw new IllegalArgumentException("Invalid namespace length");
        } else if (!str.startsWith("urn:x-cast:")) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\"");
        } else if (str.length() == 11) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\" and have non-empty suffix");
        }
    }

    public static <T> boolean m11922a(T t, T t2) {
        return (t == null && t2 == null) || !(t == null || t2 == null || !t.equals(t2));
    }

    public static String m11923c(String str) {
        if (f10171a.matcher(str).matches()) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            Object obj = ((charAt < 'A' || charAt > 'Z') && ((charAt < 'a' || charAt > 'z') && !((charAt >= '0' && charAt <= '9') || charAt == '_' || charAt == '-'))) ? null : 1;
            if (obj != null || charAt == '.' || charAt == ':') {
                stringBuilder.append(charAt);
            } else {
                stringBuilder.append(String.format("%%%04x", new Object[]{Integer.valueOf(charAt & 65535)}));
            }
        }
        return stringBuilder.toString();
    }
}
