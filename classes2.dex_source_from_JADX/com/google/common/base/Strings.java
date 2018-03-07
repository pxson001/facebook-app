package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
@CheckReturnValue
/* compiled from: thread_summaries */
public final class Strings {
    private Strings() {
    }

    public static String nullToEmpty(@Nullable String str) {
        return str == null ? "" : str;
    }

    @Nullable
    public static String emptyToNull(@Nullable String str) {
        return isNullOrEmpty(str) ? null : str;
    }

    public static boolean isNullOrEmpty(@Nullable String str) {
        return str == null || str.length() == 0;
    }

    public static String padStart(String str, int i, char c) {
        Preconditions.checkNotNull(str);
        if (str.length() >= i) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(i);
        for (int length = str.length(); length < i; length++) {
            stringBuilder.append(c);
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static String repeat(String str, int i) {
        Preconditions.checkNotNull(str);
        if (i <= 1) {
            Preconditions.checkArgument(i >= 0, "invalid count: %s", Integer.valueOf(i));
            return i == 0 ? "" : str;
        } else {
            int length = str.length();
            long j = ((long) length) * ((long) i);
            int i2 = (int) j;
            if (((long) i2) != j) {
                throw new ArrayIndexOutOfBoundsException("Required array size too large: " + j);
            }
            Object obj = new char[i2];
            str.getChars(0, length, obj, 0);
            while (length < i2 - length) {
                System.arraycopy(obj, 0, obj, length, length);
                length <<= 1;
            }
            System.arraycopy(obj, 0, obj, length, i2 - length);
            return new String(obj);
        }
    }
}
