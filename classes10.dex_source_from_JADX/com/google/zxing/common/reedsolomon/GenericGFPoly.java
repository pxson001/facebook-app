package com.google.zxing.common.reedsolomon;

/* compiled from: event_permalink_tab_bar_tapped */
public final class GenericGFPoly {
    private final GenericGF f13521a;
    public final int[] f13522b;

    GenericGFPoly(GenericGF genericGF, int[] iArr) {
        int i = 1;
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f13521a = genericGF;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f13522b = iArr;
            return;
        }
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.f13522b = genericGF.m13705a().f13522b;
            return;
        }
        this.f13522b = new int[(length - i)];
        System.arraycopy(iArr, i, this.f13522b, 0, this.f13522b.length);
    }

    final int m13714b() {
        return this.f13522b.length - 1;
    }

    final boolean m13718c() {
        return this.f13522b[0] == 0;
    }

    final int m13711a(int i) {
        return this.f13522b[(this.f13522b.length - 1) - i];
    }

    final int m13715b(int i) {
        int i2 = 0;
        if (i == 0) {
            return m13711a(0);
        }
        int length = this.f13522b.length;
        int i3;
        if (i == 1) {
            int[] iArr = this.f13522b;
            i3 = 0;
            while (i2 < iArr.length) {
                i2++;
                i3 ^= iArr[i2];
            }
            return i3;
        }
        i3 = this.f13522b[0];
        i2 = 1;
        while (i2 < length) {
            i2++;
            i3 = this.f13521a.m13710c(i, i3) ^ this.f13522b[i2];
        }
        return i3;
    }

    final GenericGFPoly m13713a(GenericGFPoly genericGFPoly) {
        if (!this.f13521a.equals(genericGFPoly.f13521a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (m13718c()) {
            return genericGFPoly;
        } else {
            if (genericGFPoly.m13718c()) {
                return this;
            }
            Object obj = this.f13522b;
            Object obj2 = genericGFPoly.f13522b;
            if (obj.length <= obj2.length) {
                Object obj3 = obj2;
                obj2 = obj;
                obj = obj3;
            }
            Object obj4 = new int[obj.length];
            int length = obj.length - r1.length;
            System.arraycopy(obj, 0, obj4, 0, length);
            for (int i = length; i < obj.length; i++) {
                obj4[i] = r1[i - length] ^ obj[i];
            }
            return new GenericGFPoly(this.f13521a, obj4);
        }
    }

    final GenericGFPoly m13716b(GenericGFPoly genericGFPoly) {
        if (!this.f13521a.equals(genericGFPoly.f13521a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (m13718c() || genericGFPoly.m13718c()) {
            return this.f13521a.m13705a();
        } else {
            int[] iArr = this.f13522b;
            int length = iArr.length;
            int[] iArr2 = genericGFPoly.f13522b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    iArr3[i + i3] = iArr3[i + i3] ^ this.f13521a.m13710c(i2, iArr2[i3]);
                }
            }
            return new GenericGFPoly(this.f13521a, iArr3);
        }
    }

    final GenericGFPoly m13717c(int i) {
        if (i == 0) {
            return this.f13521a.m13705a();
        }
        if (i == 1) {
            return this;
        }
        int length = this.f13522b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f13521a.m13710c(this.f13522b[i2], i);
        }
        return new GenericGFPoly(this.f13521a, iArr);
    }

    final GenericGFPoly m13712a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f13521a.m13705a();
        } else {
            int length = this.f13522b.length;
            int[] iArr = new int[(length + i)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.f13521a.m13710c(this.f13522b[i3], i2);
            }
            return new GenericGFPoly(this.f13521a, iArr);
        }
    }

    final GenericGFPoly[] m13719c(GenericGFPoly genericGFPoly) {
        if (!this.f13521a.equals(genericGFPoly.f13521a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (genericGFPoly.m13718c()) {
            throw new IllegalArgumentException("Divide by 0");
        } else {
            GenericGFPoly a = this.f13521a.m13705a();
            int c = this.f13521a.m13709c(genericGFPoly.m13711a(genericGFPoly.m13714b()));
            GenericGFPoly genericGFPoly2 = a;
            a = this;
            while (a.m13714b() >= genericGFPoly.m13714b() && !a.m13718c()) {
                int b = a.m13714b() - genericGFPoly.m13714b();
                int c2 = this.f13521a.m13710c(a.m13711a(a.m13714b()), c);
                GenericGFPoly a2 = genericGFPoly.m13712a(b, c2);
                genericGFPoly2 = genericGFPoly2.m13713a(this.f13521a.m13706a(b, c2));
                a = a.m13713a(a2);
            }
            return new GenericGFPoly[]{genericGFPoly2, a};
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(m13714b() * 8);
        for (int b = m13714b(); b >= 0; b--) {
            int a = m13711a(b);
            if (a != 0) {
                if (a < 0) {
                    stringBuilder.append(" - ");
                    a = -a;
                } else if (stringBuilder.length() > 0) {
                    stringBuilder.append(" + ");
                }
                if (b == 0 || a != 1) {
                    a = this.f13521a.m13707b(a);
                    if (a == 0) {
                        stringBuilder.append('1');
                    } else if (a == 1) {
                        stringBuilder.append('a');
                    } else {
                        stringBuilder.append("a^");
                        stringBuilder.append(a);
                    }
                }
                if (b != 0) {
                    if (b == 1) {
                        stringBuilder.append('x');
                    } else {
                        stringBuilder.append("x^");
                        stringBuilder.append(b);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
