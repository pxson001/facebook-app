package com.facebook.react.common;

/* compiled from: option_set_display */
public class LongArray {
    private long[] f11579a;
    public int f11580b = 0;

    public static LongArray m13594a(int i) {
        return new LongArray(i);
    }

    private LongArray(int i) {
        this.f11579a = new long[i];
    }

    public final void m13598a(long j) {
        m13595b();
        long[] jArr = this.f11579a;
        int i = this.f11580b;
        this.f11580b = i + 1;
        jArr[i] = j;
    }

    public final long m13599b(int i) {
        if (i < this.f11580b) {
            return this.f11579a[i];
        }
        throw new IndexOutOfBoundsException(i + " >= " + this.f11580b);
    }

    public final void m13597a(int i, long j) {
        if (i >= this.f11580b) {
            throw new IndexOutOfBoundsException(i + " >= " + this.f11580b);
        }
        this.f11579a[i] = j;
    }

    public final int m13596a() {
        return this.f11580b;
    }

    public final void m13600c(int i) {
        if (i > this.f11580b) {
            throw new IndexOutOfBoundsException("Trying to drop " + i + " items from array of length " + this.f11580b);
        }
        this.f11580b -= i;
    }

    private void m13595b() {
        if (this.f11580b == this.f11579a.length) {
            Object obj = new long[Math.max(this.f11580b + 1, (int) (((double) this.f11580b) * 1.8d))];
            System.arraycopy(this.f11579a, 0, obj, 0, this.f11580b);
            this.f11579a = obj;
        }
    }
}
