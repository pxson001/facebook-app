package com.google.zxing.common.reedsolomon;

/* compiled from: event_pinned_stories */
public final class GenericGF {
    public static final GenericGF f13506a = new GenericGF(4201, 4096);
    public static final GenericGF f13507b = new GenericGF(1033, 1024);
    public static final GenericGF f13508c = new GenericGF(67, 64);
    public static final GenericGF f13509d = new GenericGF(19, 16);
    public static final GenericGF f13510e = new GenericGF(285, 256);
    public static final GenericGF f13511f;
    public static final GenericGF f13512g;
    public static final GenericGF f13513h = f13508c;
    private int[] f13514i;
    private int[] f13515j;
    private GenericGFPoly f13516k;
    private GenericGFPoly f13517l;
    public final int f13518m;
    private final int f13519n;
    private boolean f13520o = false;

    static {
        GenericGF genericGF = new GenericGF(301, 256);
        f13511f = genericGF;
        f13512g = genericGF;
    }

    private GenericGF(int i, int i2) {
        this.f13519n = i;
        this.f13518m = i2;
        if (i2 <= 0) {
            m13702d();
        }
    }

    private void m13702d() {
        int i;
        this.f13514i = new int[this.f13518m];
        this.f13515j = new int[this.f13518m];
        int i2 = 1;
        for (i = 0; i < this.f13518m; i++) {
            this.f13514i[i] = i2;
            i2 <<= 1;
            if (i2 >= this.f13518m) {
                i2 = (i2 ^ this.f13519n) & (this.f13518m - 1);
            }
        }
        for (i = 0; i < this.f13518m - 1; i++) {
            this.f13515j[this.f13514i[i]] = i;
        }
        this.f13516k = new GenericGFPoly(this, new int[]{0});
        this.f13517l = new GenericGFPoly(this, new int[]{1});
        this.f13520o = true;
    }

    private void m13703e() {
        if (!this.f13520o) {
            m13702d();
        }
    }

    final GenericGFPoly m13705a() {
        m13703e();
        return this.f13516k;
    }

    final GenericGFPoly m13708b() {
        m13703e();
        return this.f13517l;
    }

    final GenericGFPoly m13706a(int i, int i2) {
        m13703e();
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f13516k;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new GenericGFPoly(this, iArr);
        }
    }

    final int m13704a(int i) {
        m13703e();
        return this.f13514i[i];
    }

    final int m13707b(int i) {
        m13703e();
        if (i != 0) {
            return this.f13515j[i];
        }
        throw new IllegalArgumentException();
    }

    final int m13709c(int i) {
        m13703e();
        if (i != 0) {
            return this.f13514i[(this.f13518m - this.f13515j[i]) - 1];
        }
        throw new ArithmeticException();
    }

    final int m13710c(int i, int i2) {
        m13703e();
        if (i == 0 || i2 == 0) {
            return 0;
        }
        return this.f13514i[(this.f13515j[i] + this.f13515j[i2]) % (this.f13518m - 1)];
    }
}
