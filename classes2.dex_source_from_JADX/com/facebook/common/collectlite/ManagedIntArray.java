package com.facebook.common.collectlite;

/* compiled from: ne_NP */
public final class ManagedIntArray {
    public int[] f12950a;
    public int f12951b = 0;

    public static ManagedIntArray m19031a(int i) {
        return new ManagedIntArray(i);
    }

    private ManagedIntArray(int i) {
        this.f12950a = new int[i];
    }

    public final void m19033b(int i) {
        if (this.f12951b >= this.f12950a.length) {
            Object obj = new int[Math.max(this.f12951b + 1, (int) (((double) this.f12951b) * 1.8d))];
            System.arraycopy(this.f12950a, 0, obj, 0, this.f12951b);
            this.f12950a = obj;
        }
        int[] iArr = this.f12950a;
        int i2 = this.f12951b;
        this.f12951b = i2 + 1;
        iArr[i2] = i;
    }

    public final int m19034c(int i) {
        if (i >= 0 && i < this.f12951b) {
            return this.f12950a[i];
        }
        throw new IndexOutOfBoundsException("Index " + i + " is out of bounds. Collection length " + this.f12951b);
    }

    public final int m19032a() {
        return this.f12951b;
    }

    public final void m19035c() {
        this.f12951b = 0;
    }

    public final int[] m19036d() {
        Object obj = new int[this.f12951b];
        System.arraycopy(this.f12950a, 0, obj, 0, this.f12951b);
        return obj;
    }
}
