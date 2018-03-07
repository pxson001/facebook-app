package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Collection;
import javax.annotation.CheckForNull;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
@CheckReturnValue
/* compiled from: total_wakeup_count */
public final class Ints {
    private Ints() {
    }

    public static int m4486a(long j) {
        int i = (int) j;
        if (((long) i) == j) {
            return i;
        }
        throw new IllegalArgumentException("Out of range: " + j);
    }

    public static int m4489b(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    public static int m4485a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int m4490c(int[] iArr, int i, int i2, int i3) {
        for (int i4 = i2; i4 < i3; i4++) {
            if (iArr[i4] == i) {
                return i4;
            }
        }
        return -1;
    }

    public static int[] m4488a(Collection<? extends Number> collection) {
        if (collection instanceof IntArrayAsList) {
            IntArrayAsList intArrayAsList = (IntArrayAsList) collection;
            int size = intArrayAsList.size();
            Object obj = new int[size];
            System.arraycopy(intArrayAsList.array, intArrayAsList.start, obj, 0, size);
            return obj;
        }
        Object[] toArray = collection.toArray();
        int length = toArray.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = ((Number) Preconditions.checkNotNull(toArray[i])).intValue();
        }
        return iArr;
    }

    @CheckForNull
    @Nullable
    @Beta
    public static Integer m4487a(String str) {
        Integer num;
        Long a = Longs.a(str, 10);
        if (a == null || a.longValue() != ((long) a.intValue())) {
            num = null;
        } else {
            num = Integer.valueOf(a.intValue());
        }
        return num;
    }
}
