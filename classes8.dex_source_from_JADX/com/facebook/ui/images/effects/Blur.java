package com.facebook.ui.images.effects;

import android.graphics.Bitmap;
import java.lang.reflect.Array;

/* compiled from: mConfidenceLevel */
public abstract class Blur {
    public static void m11215b(Bitmap bitmap, int i) {
        if (i > 0) {
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[(width * height)];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            int i12 = width - 1;
            int i13 = height - 1;
            int i14 = width * height;
            int i15 = (i + i) + 1;
            int[] iArr2 = new int[i14];
            int[] iArr3 = new int[i14];
            int[] iArr4 = new int[i14];
            int[] iArr5 = new int[Math.max(width, height)];
            i14 = (i15 + 1) >> 1;
            int i16 = i14 * i14;
            int[] iArr6 = new int[(i16 * 256)];
            for (i14 = 0; i14 < i16 * 256; i14++) {
                iArr6[i14] = i14 / i16;
            }
            int[][] iArr7 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i15, 3});
            int i17 = i + 1;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            while (i18 < height) {
                int[] iArr8;
                i16 = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                i7 = 0;
                i8 = 0;
                i9 = 0;
                for (i10 = -i; i10 <= i; i10++) {
                    i11 = iArr[Math.min(i12, Math.max(i10, 0)) + i20];
                    iArr8 = iArr7[i10 + i];
                    iArr8[0] = (16711680 & i11) >> 16;
                    iArr8[1] = (65280 & i11) >> 8;
                    iArr8[2] = i11 & 255;
                    i11 = i17 - Math.abs(i10);
                    i6 += iArr8[0] * i11;
                    i7 += iArr8[1] * i11;
                    i8 += i11 * iArr8[2];
                    if (i10 > 0) {
                        i16 += iArr8[0];
                        i9 += iArr8[1];
                        i2 += iArr8[2];
                    } else {
                        i3 += iArr8[0];
                        i4 += iArr8[1];
                        i5 += iArr8[2];
                    }
                }
                i11 = i20;
                i20 = i8;
                i8 = i7;
                i7 = i6;
                i6 = i5;
                i5 = i3;
                i3 = i9;
                i9 = i;
                int i21 = i4;
                i4 = i2;
                i2 = i16;
                i10 = i21;
                for (i16 = 0; i16 < width; i16++) {
                    iArr2[i11] = iArr6[i7];
                    iArr3[i11] = iArr6[i8];
                    iArr4[i11] = iArr6[i20];
                    i7 -= i5;
                    i8 -= i10;
                    i20 -= i6;
                    iArr8 = iArr7[((i9 - i) + i15) % i15];
                    i5 -= iArr8[0];
                    i10 -= iArr8[1];
                    i6 -= iArr8[2];
                    if (i18 == 0) {
                        iArr5[i16] = Math.min((i16 + i) + 1, i12);
                    }
                    int i22 = iArr[iArr5[i16] + i19];
                    iArr8[0] = (16711680 & i22) >> 16;
                    iArr8[1] = (65280 & i22) >> 8;
                    iArr8[2] = i22 & 255;
                    i2 += iArr8[0];
                    i3 += iArr8[1];
                    i4 += iArr8[2];
                    i7 += i2;
                    i8 += i3;
                    i20 += i4;
                    i9 = (i9 + 1) % i15;
                    iArr8 = iArr7[i9 % i15];
                    i5 += iArr8[0];
                    i10 += iArr8[1];
                    i6 += iArr8[2];
                    i2 -= iArr8[0];
                    i3 -= iArr8[1];
                    i4 -= iArr8[2];
                    i11++;
                }
                i18++;
                i19 += width;
                i20 = i11;
            }
            for (i18 = 0; i18 < width; i18++) {
                int[] iArr9;
                i9 = 0;
                i16 = (-i) * width;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i10 = 0;
                i6 = 0;
                i7 = 0;
                i8 = 0;
                i2 = 0;
                for (i20 = -i; i20 <= i; i20++) {
                    i11 = Math.max(0, i16) + i18;
                    iArr9 = iArr7[i20 + i];
                    iArr9[0] = iArr2[i11];
                    iArr9[1] = iArr3[i11];
                    iArr9[2] = iArr4[i11];
                    i12 = i17 - Math.abs(i20);
                    i6 += iArr2[i11] * i12;
                    i7 += iArr3[i11] * i12;
                    i8 += iArr4[i11] * i12;
                    if (i20 > 0) {
                        i9 += iArr9[0];
                        i2 += iArr9[1];
                        i3 += iArr9[2];
                    } else {
                        i4 += iArr9[0];
                        i5 += iArr9[1];
                        i10 += iArr9[2];
                    }
                    if (i20 < i13) {
                        i16 += width;
                    }
                }
                i11 = i18;
                i16 = i;
                for (i20 = 0; i20 < height; i20++) {
                    iArr[i11] = (((-16777216 & iArr[i11]) | (iArr6[i6] << 16)) | (iArr6[i7] << 8)) | iArr6[i8];
                    i6 -= i4;
                    i7 -= i5;
                    i8 -= i10;
                    iArr9 = iArr7[((i16 - i) + i15) % i15];
                    i4 -= iArr9[0];
                    i5 -= iArr9[1];
                    i10 -= iArr9[2];
                    if (i18 == 0) {
                        iArr5[i20] = Math.min(i20 + i17, i13) * width;
                    }
                    i12 = iArr5[i20] + i18;
                    iArr9[0] = iArr2[i12];
                    iArr9[1] = iArr3[i12];
                    iArr9[2] = iArr4[i12];
                    i9 += iArr9[0];
                    i2 += iArr9[1];
                    i3 += iArr9[2];
                    i6 += i9;
                    i7 += i2;
                    i8 += i3;
                    i16 = (i16 + 1) % i15;
                    iArr9 = iArr7[i16];
                    i4 += iArr9[0];
                    i5 += iArr9[1];
                    i10 += iArr9[2];
                    i9 -= iArr9[0];
                    i2 -= iArr9[1];
                    i3 -= iArr9[2];
                    i11 += width;
                }
            }
            bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        }
    }
}
