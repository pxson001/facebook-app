package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.annotation.CheckForNull;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
@CheckReturnValue
/* compiled from: tone */
public final class Longs {
    private static final byte[] f921a;

    private Longs() {
    }

    public static int m1257a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j > j2 ? 1 : 0;
    }

    public static int m1261c(long[] jArr, long j, int i, int i2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (jArr[i3] == j) {
                return i3;
            }
        }
        return -1;
    }

    static {
        int i = 0;
        byte[] bArr = new byte[128];
        Arrays.fill(bArr, (byte) -1);
        for (int i2 = 0; i2 <= 9; i2++) {
            bArr[i2 + 48] = (byte) i2;
        }
        while (i <= 26) {
            bArr[i + 65] = (byte) (i + 10);
            bArr[i + 97] = (byte) (i + 10);
            i++;
        }
        f921a = bArr;
    }

    private static int m1256a(char c) {
        return c < '' ? f921a[c] : -1;
    }

    @CheckForNull
    @Nullable
    @Beta
    public static Long m1258a(String str, int i) {
        if (((String) Preconditions.checkNotNull(str)).isEmpty()) {
            return null;
        }
        if (i < 2 || i > 36) {
            throw new IllegalArgumentException("radix must be between MIN_RADIX and MAX_RADIX but was " + i);
        }
        int i2;
        int i3;
        if (str.charAt(0) == '-') {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (i3 == str.length()) {
            return null;
        }
        int i4 = i3 + 1;
        i3 = m1256a(str.charAt(i3));
        if (i3 < 0 || i3 >= i) {
            return null;
        }
        long j = (long) (-i3);
        long j2 = Long.MIN_VALUE / ((long) i);
        while (i4 < str.length()) {
            int i5 = i4 + 1;
            i4 = m1256a(str.charAt(i4));
            if (i4 < 0 || i4 >= i || j < j2) {
                return null;
            }
            j *= (long) i;
            if (j < ((long) i4) - Long.MIN_VALUE) {
                return null;
            }
            j -= (long) i4;
            i4 = i5;
        }
        if (i2 != 0) {
            return Long.valueOf(j);
        }
        if (j == Long.MIN_VALUE) {
            return null;
        }
        return Long.valueOf(-j);
    }

    public static long[] m1260a(Collection<? extends Number> collection) {
        if (collection instanceof LongArrayAsList) {
            LongArrayAsList longArrayAsList = (LongArrayAsList) collection;
            int size = longArrayAsList.size();
            Object obj = new long[size];
            System.arraycopy(longArrayAsList.array, longArrayAsList.start, obj, 0, size);
            return obj;
        }
        Object[] toArray = collection.toArray();
        int length = toArray.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = ((Number) Preconditions.checkNotNull(toArray[i])).longValue();
        }
        return jArr;
    }

    public static List<Long> m1259a(long... jArr) {
        if (jArr.length == 0) {
            return Collections.emptyList();
        }
        return new LongArrayAsList(jArr);
    }
}
