package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;

/* compiled from: event_prompt_surface */
public class GlobalHistogramBinarizer extends Binarizer {
    private static final byte[] f13491a = new byte[0];
    private byte[] f13492b = f13491a;
    private final int[] f13493c = new int[32];

    public GlobalHistogramBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    public BitMatrix mo681b() {
        int i;
        int i2;
        LuminanceSource luminanceSource = this.f13449a;
        int i3 = luminanceSource.f13454a;
        int i4 = luminanceSource.f13455b;
        BitMatrix bitMatrix = new BitMatrix(i3, i4);
        m13686a(i3);
        int[] iArr = this.f13493c;
        for (i = 1; i < 5; i++) {
            byte[] a = luminanceSource.mo679a((i4 * i) / 5, this.f13492b);
            int i5 = (i3 << 2) / 5;
            for (i2 = i3 / 5; i2 < i5; i2++) {
                int i6 = (a[i2] & 255) >> 3;
                iArr[i6] = iArr[i6] + 1;
            }
        }
        int a2 = m13685a(iArr);
        byte[] a3 = luminanceSource.mo678a();
        for (i = 0; i < i4; i++) {
            int i7 = i * i3;
            for (i2 = 0; i2 < i3; i2++) {
                if ((a3[i7 + i2] & 255) < a2) {
                    bitMatrix.m13676b(i2, i);
                }
            }
        }
        return bitMatrix;
    }

    private void m13686a(int i) {
        if (this.f13492b.length < i) {
            this.f13492b = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.f13493c[i2] = 0;
        }
    }

    private static int m13685a(int[] iArr) {
        int i;
        int i2;
        int i3 = 0;
        int length = iArr.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (i = 0; i < length; i++) {
            if (iArr[i] > i4) {
                i4 = iArr[i];
                i5 = i;
            }
            if (iArr[i] > i6) {
                i6 = iArr[i];
            }
        }
        i = 0;
        int i7 = 0;
        while (i3 < length) {
            i4 = i3 - i5;
            i4 *= iArr[i3] * i4;
            if (i4 > i) {
                i = i3;
            } else {
                i4 = i;
                i = i7;
            }
            i3++;
            i7 = i;
            i = i4;
        }
        if (i5 > i7) {
            i2 = i7;
            i7 = i5;
        } else {
            i2 = i5;
        }
        if (i7 - i2 <= (length >> 4)) {
            throw NotFoundException.f13456a;
        }
        i3 = i7 - 1;
        i5 = -1;
        i = i7 - 1;
        while (i > i2) {
            i4 = i - i2;
            i4 = ((i4 * i4) * (i7 - i)) * (i6 - iArr[i]);
            if (i4 > i5) {
                i5 = i;
            } else {
                i4 = i5;
                i5 = i3;
            }
            i--;
            i3 = i5;
            i5 = i4;
        }
        return i3 << 3;
    }
}
