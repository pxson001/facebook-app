package com.facebook.fbui.facepile;

import java.util.Arrays;

/* compiled from: noTagExpansion */
final class ColumnLengthsTracker {
    private final int[] f9955a;

    public ColumnLengthsTracker(int i) {
        this.f9955a = new int[i];
    }

    public final int m15670a() {
        int i = 0;
        int i2 = this.f9955a[0];
        int i3 = 1;
        int length = this.f9955a.length;
        while (i3 != length) {
            int i4 = this.f9955a[i3];
            if (i4 < i2) {
                i2 = i3;
            } else {
                i4 = i2;
                i2 = i;
            }
            i3++;
            i = i2;
            i2 = i4;
        }
        return i;
    }

    public final int m15671a(int i) {
        return this.f9955a[i];
    }

    public final void m15672a(int i, int i2) {
        this.f9955a[i] = i2;
    }

    public final void m15673b() {
        Arrays.fill(this.f9955a, 0);
    }
}
