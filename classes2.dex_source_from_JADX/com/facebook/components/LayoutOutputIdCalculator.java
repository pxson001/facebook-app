package com.facebook.components;

import android.support.v4.util.LongSparseArray;

/* compiled from: gaps_above */
class LayoutOutputIdCalculator {
    private final LongSparseArray<Integer> f22747a = new LongSparseArray(8);

    LayoutOutputIdCalculator() {
    }

    final void m30713a(LayoutOutput layoutOutput, int i, int i2, long j, boolean z) {
        int i3;
        long a = m30710a(layoutOutput, i, i2);
        if (j <= 0 || m30711b(j) != i) {
            i3 = -1;
        } else {
            i3 = ((int) j) & 65535;
        }
        int intValue = ((Integer) this.f22747a.m4359a(a, Integer.valueOf(0))).intValue();
        if (i3 < intValue) {
            i3 = intValue + 1;
            intValue = 0;
        } else {
            intValue = z ? 1 : 2;
        }
        layoutOutput.f22635k = intValue;
        layoutOutput.f22625a = m30709a(a, i3);
        this.f22747a.m4364b(a, Integer.valueOf(i3 + 1));
    }

    final void m30712a() {
        this.f22747a.m4362b();
    }

    private static long m30709a(long j, int i) {
        if (i >= 0 && i <= 65535) {
            return ((long) i) | j;
        }
        throw new IllegalArgumentException("Sequence must be non-negative and no greater than 65535 actual sequence " + i);
    }

    private static int m30711b(long j) {
        return (int) ((j >> 18) & 255);
    }

    private static long m30710a(LayoutOutput layoutOutput, int i, int i2) {
        if (i < 0 || i > 255) {
            throw new IllegalArgumentException("Level must be non-negative and no greater than 255 actual level " + i);
        }
        long j;
        if (layoutOutput.f22626b != null) {
            j = (long) layoutOutput.f22626b.f22589c.f20396d;
        } else {
            j = 0;
        }
        return (((j << 26) | 0) | (((long) i) << 18)) | (((long) i2) << 16);
    }
}
