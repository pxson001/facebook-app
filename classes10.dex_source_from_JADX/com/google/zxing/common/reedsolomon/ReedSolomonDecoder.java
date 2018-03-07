package com.google.zxing.common.reedsolomon;

/* compiled from: event_permalink_first_scroll */
public final class ReedSolomonDecoder {
    private final GenericGF f13523a;

    public ReedSolomonDecoder(GenericGF genericGF) {
        this.f13523a = genericGF;
    }

    public final void m13723a(int[] iArr, int i) {
        int i2 = 0;
        GenericGFPoly genericGFPoly = new GenericGFPoly(this.f13523a, iArr);
        int[] iArr2 = new int[i];
        boolean equals = this.f13523a.equals(GenericGF.f13511f);
        int i3 = 0;
        int i4 = 1;
        while (i3 < i) {
            int i5;
            GenericGF genericGF = this.f13523a;
            if (equals) {
                i5 = i3 + 1;
            } else {
                i5 = i3;
            }
            i5 = genericGFPoly.m13715b(genericGF.m13704a(i5));
            iArr2[(i - 1) - i3] = i5;
            if (i5 != 0) {
                i5 = 0;
            } else {
                i5 = i4;
            }
            i3++;
            i4 = i5;
        }
        if (i4 == 0) {
            GenericGFPoly[] a = m13722a(this.f13523a.m13706a(i, 1), new GenericGFPoly(this.f13523a, iArr2), i);
            GenericGFPoly genericGFPoly2 = a[0];
            GenericGFPoly genericGFPoly3 = a[1];
            int[] a2 = m13720a(genericGFPoly2);
            int[] a3 = m13721a(genericGFPoly3, a2, equals);
            while (i2 < a2.length) {
                i4 = (iArr.length - 1) - this.f13523a.m13707b(a2[i2]);
                if (i4 < 0) {
                    throw new ReedSolomonException("Bad error location");
                }
                iArr[i4] = iArr[i4] ^ a3[i2];
                i2++;
            }
        }
    }

    private GenericGFPoly[] m13722a(GenericGFPoly genericGFPoly, GenericGFPoly genericGFPoly2, int i) {
        if (genericGFPoly.m13714b() >= genericGFPoly2.m13714b()) {
            GenericGFPoly genericGFPoly3 = genericGFPoly2;
            genericGFPoly2 = genericGFPoly;
            genericGFPoly = genericGFPoly3;
        }
        GenericGFPoly a = this.f13523a.m13705a();
        GenericGFPoly b = this.f13523a.m13708b();
        while (genericGFPoly.m13714b() >= i / 2) {
            if (genericGFPoly.m13718c()) {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
            GenericGFPoly a2 = this.f13523a.m13705a();
            int c = this.f13523a.m13709c(genericGFPoly.m13711a(genericGFPoly.m13714b()));
            GenericGFPoly genericGFPoly4 = a2;
            a2 = genericGFPoly2;
            while (a2.m13714b() >= genericGFPoly.m13714b() && !a2.m13718c()) {
                int b2 = a2.m13714b() - genericGFPoly.m13714b();
                int c2 = this.f13523a.m13710c(a2.m13711a(a2.m13714b()), c);
                genericGFPoly4 = genericGFPoly4.m13713a(this.f13523a.m13706a(b2, c2));
                a2 = a2.m13713a(genericGFPoly.m13712a(b2, c2));
            }
            genericGFPoly2 = genericGFPoly;
            genericGFPoly = a2;
            genericGFPoly3 = b;
            b = genericGFPoly4.m13716b(b).m13713a(a);
            a = genericGFPoly3;
        }
        int a3 = b.m13711a(0);
        if (a3 == 0) {
            throw new ReedSolomonException("sigmaTilde(0) was zero");
        }
        a3 = this.f13523a.m13709c(a3);
        b = b.m13717c(a3);
        a = genericGFPoly.m13717c(a3);
        return new GenericGFPoly[]{b, a};
    }

    private int[] m13720a(GenericGFPoly genericGFPoly) {
        int i = 0;
        int i2 = 1;
        int b = genericGFPoly.m13714b();
        if (b == 1) {
            return new int[]{genericGFPoly.m13711a(1)};
        }
        int[] iArr = new int[b];
        while (i2 < this.f13523a.f13518m && i < b) {
            if (genericGFPoly.m13715b(i2) == 0) {
                iArr[i] = this.f13523a.m13709c(i2);
                i++;
            }
            i2++;
        }
        if (i == b) {
            return iArr;
        }
        throw new ReedSolomonException("Error locator degree does not match number of roots");
    }

    private int[] m13721a(GenericGFPoly genericGFPoly, int[] iArr, boolean z) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            int c = this.f13523a.m13709c(iArr[i]);
            int i2 = 1;
            int i3 = 0;
            while (i3 < length) {
                int c2;
                if (i != i3) {
                    c2 = this.f13523a.m13710c(iArr[i3], c);
                    c2 = this.f13523a.m13710c(i2, (c2 & 1) == 0 ? c2 | 1 : c2 & -2);
                } else {
                    c2 = i2;
                }
                i3++;
                i2 = c2;
            }
            iArr2[i] = this.f13523a.m13710c(genericGFPoly.m13715b(c), this.f13523a.m13709c(i2));
            if (z) {
                iArr2[i] = this.f13523a.m13710c(iArr2[i], c);
            }
        }
        return iArr2;
    }
}
