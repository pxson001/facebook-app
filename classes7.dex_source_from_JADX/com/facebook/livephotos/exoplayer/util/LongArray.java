package com.facebook.livephotos.exoplayer.util;

import java.util.Arrays;

/* compiled from: option_set_display */
public final class LongArray {
    public int f7694a;
    private long[] f7695b;

    public LongArray() {
        this(32);
    }

    private LongArray(int i) {
        this.f7695b = new long[i];
    }

    public final void m9303a(long j) {
        if (this.f7694a == this.f7695b.length) {
            this.f7695b = Arrays.copyOf(this.f7695b, this.f7694a * 2);
        }
        long[] jArr = this.f7695b;
        int i = this.f7694a;
        this.f7694a = i + 1;
        jArr[i] = j;
    }

    public final long m9302a(int i) {
        if (i >= 0 && i < this.f7694a) {
            return this.f7695b[i];
        }
        throw new IndexOutOfBoundsException("Invalid size " + i + ", size is " + this.f7694a);
    }
}
