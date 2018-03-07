package com.google.zxing.common;

import com.google.zxing.NotFoundException;

/* compiled from: event_reminder_banner */
public final class DefaultGridSampler extends GridSampler {
    public final BitMatrix mo680a(BitMatrix bitMatrix, int i, int i2, PerspectiveTransform perspectiveTransform) {
        if (i <= 0 || i2 <= 0) {
            throw NotFoundException.m13654a();
        }
        BitMatrix bitMatrix2 = new BitMatrix(i, i2);
        float[] fArr = new float[(i << 1)];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4;
            int length = fArr.length;
            float f = ((float) i3) + 0.5f;
            for (i4 = 0; i4 < length; i4 += 2) {
                fArr[i4] = ((float) (i4 >> 1)) + 0.5f;
                fArr[i4 + 1] = f;
            }
            perspectiveTransform.m13698a(fArr);
            GridSampler.m13682a(bitMatrix, fArr);
            i4 = 0;
            while (i4 < length) {
                try {
                    if (bitMatrix.m13674a((int) fArr[i4], (int) fArr[i4 + 1])) {
                        bitMatrix2.m13676b(i4 >> 1, i3);
                    }
                    i4 += 2;
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw NotFoundException.m13654a();
                }
            }
        }
        return bitMatrix2;
    }
}
