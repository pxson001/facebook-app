package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

/* compiled from: event_location_summary_open_maps */
final class BitMatrixParser {
    private final BitMatrix f13528a;
    private Version f13529b;
    private FormatInformation f13530c;

    BitMatrixParser(BitMatrix bitMatrix) {
        int i = bitMatrix.f13478b;
        if (i < 21 || (i & 3) != 1) {
            throw FormatException.f13453a;
        }
        this.f13528a = bitMatrix;
    }

    final FormatInformation m13733a() {
        int i = 0;
        if (this.f13530c != null) {
            return this.f13530c;
        }
        int i2;
        int i3 = 0;
        for (i2 = 0; i2 < 6; i2++) {
            i3 = m13732a(i2, 8, i3);
        }
        i3 = m13732a(8, 7, m13732a(8, 8, m13732a(7, 8, i3)));
        for (i2 = 5; i2 >= 0; i2--) {
            i3 = m13732a(8, i2, i3);
        }
        int i4 = this.f13528a.f13478b;
        int i5 = i4 - 7;
        for (i2 = i4 - 1; i2 >= i5; i2--) {
            i = m13732a(8, i2, i);
        }
        for (i2 = i4 - 8; i2 < i4; i2++) {
            i = m13732a(i2, 8, i);
        }
        FormatInformation c = FormatInformation.m13761c(i3, i);
        if (c == null) {
            c = FormatInformation.m13761c(i3 ^ 21522, i ^ 21522);
        }
        this.f13530c = c;
        if (this.f13530c != null) {
            return this.f13530c;
        }
        throw FormatException.f13453a;
    }

    final Version m13734b() {
        if (this.f13529b != null) {
            return this.f13529b;
        }
        int i = this.f13528a.f13478b;
        int i2 = (i - 17) >> 2;
        if (i2 <= 6) {
            return Version.m13771b(i2);
        }
        int i3 = i - 11;
        int i4 = 0;
        for (int i5 = 5; i5 >= 0; i5--) {
            for (i2 = i - 9; i2 >= i3; i2--) {
                i4 = m13732a(i2, i5, i4);
            }
        }
        Version c = Version.m13772c(i4);
        if (c == null || c.m13777d() != i) {
            int i6 = 0;
            for (int i7 = 5; i7 >= 0; i7--) {
                for (i2 = i - 9; i2 >= i3; i2--) {
                    i6 = m13732a(i7, i2, i6);
                }
            }
            c = Version.m13772c(i6);
            if (c == null || c.m13777d() != i) {
                throw FormatException.f13453a;
            }
            this.f13529b = c;
            return c;
        }
        this.f13529b = c;
        return c;
    }

    private int m13732a(int i, int i2, int i3) {
        return this.f13528a.m13674a(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    final byte[] m13735c() {
        FormatInformation a = m13733a();
        Version b = m13734b();
        DataMask a2 = DataMask.m13739a(a.m13763b());
        int d = this.f13528a.m13679d();
        a2.m13740a(this.f13528a, d);
        BitMatrix e = b.m13778e();
        byte[] bArr = new byte[b.m13776c()];
        int i = d - 1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i > 0) {
            if (i == 6) {
                i--;
            }
            for (int i6 = 0; i6 < d; i6++) {
                int i7;
                if (i5 != 0) {
                    i7 = (d - 1) - i6;
                } else {
                    i7 = i6;
                }
                for (int i8 = 0; i8 < 2; i8++) {
                    if (!e.m13674a(i - i8, i7)) {
                        i2++;
                        i3 <<= 1;
                        if (this.f13528a.m13674a(i - i8, i7)) {
                            i3 |= 1;
                        }
                        if (i2 == 8) {
                            i2 = i4 + 1;
                            bArr[i4] = (byte) i3;
                            i3 = 0;
                            i4 = i2;
                            i2 = 0;
                        }
                    }
                }
            }
            i -= 2;
            i5 ^= 1;
        }
        if (i4 == b.m13776c()) {
            return bArr;
        }
        throw FormatException.m13651a();
    }
}
