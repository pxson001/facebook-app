package com.google.zxing.common;

/* compiled from: event_source_module */
public final class BitArray {
    private int[] f13475a = new int[1];
    public int f13476b = 0;

    public final int m13671b() {
        return (this.f13476b + 7) >> 3;
    }

    private void m13665b(int i) {
        if (i > (this.f13475a.length << 5)) {
            Object obj = new int[((i + 31) >> 5)];
            System.arraycopy(this.f13475a, 0, obj, 0, this.f13475a.length);
            this.f13475a = obj;
        }
    }

    public final boolean m13670a(int i) {
        return (this.f13475a[i >> 5] & (1 << (i & 31))) != 0;
    }

    public final void m13669a(boolean z) {
        m13665b(this.f13476b + 1);
        if (z) {
            int[] iArr = this.f13475a;
            int i = this.f13476b >> 5;
            iArr[i] = iArr[i] | (1 << (this.f13476b & 31));
        }
        this.f13476b++;
    }

    public final void m13666a(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        m13665b(this.f13476b + i2);
        while (i2 > 0) {
            m13669a(((i >> (i2 + -1)) & 1) == 1);
            i2--;
        }
    }

    public final void m13668a(BitArray bitArray) {
        int i = bitArray.f13476b;
        m13665b(this.f13476b + i);
        for (int i2 = 0; i2 < i; i2++) {
            m13669a(bitArray.m13670a(i2));
        }
    }

    public final void m13672b(BitArray bitArray) {
        if (this.f13475a.length != bitArray.f13475a.length) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        for (int i = 0; i < this.f13475a.length; i++) {
            int[] iArr = this.f13475a;
            iArr[i] = iArr[i] ^ bitArray.f13475a[i];
        }
    }

    public final void m13667a(int i, byte[] bArr, int i2, int i3) {
        int i4 = 0;
        int i5 = i;
        while (i4 < i3) {
            int i6 = i5;
            i5 = 0;
            for (int i7 = 0; i7 < 8; i7++) {
                if (m13670a(i6)) {
                    i5 |= 1 << (7 - i7);
                }
                i6++;
            }
            bArr[i2 + i4] = (byte) i5;
            i4++;
            i5 = i6;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.f13476b);
        for (int i = 0; i < this.f13476b; i++) {
            if ((i & 7) == 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(m13670a(i) ? 'X' : '.');
        }
        return stringBuilder.toString();
    }
}
