package com.google.zxing.common;

import com.google.zxing.NotFoundException;

/* compiled from: event_reminder_banner_view */
public abstract class GridSampler {
    public static GridSampler f13488a = new DefaultGridSampler();

    public abstract BitMatrix mo680a(BitMatrix bitMatrix, int i, int i2, PerspectiveTransform perspectiveTransform);

    protected static void m13682a(BitMatrix bitMatrix, float[] fArr) {
        int i;
        int i2 = bitMatrix.f13477a;
        int i3 = bitMatrix.f13478b;
        Object obj = 1;
        for (i = 0; i < fArr.length && r2 != null; i += 2) {
            int i4 = (int) fArr[i];
            int i5 = (int) fArr[i + 1];
            if (i4 < -1 || i4 > i2 || i5 < -1 || i5 > i3) {
                throw NotFoundException.f13456a;
            }
            if (i4 == -1) {
                fArr[i] = 0.0f;
                obj = 1;
            } else if (i4 == i2) {
                fArr[i] = (float) (i2 - 1);
                i4 = 1;
            } else {
                obj = null;
            }
            if (i5 == -1) {
                fArr[i + 1] = 0.0f;
                obj = 1;
            } else if (i5 == i3) {
                fArr[i + 1] = (float) (i3 - 1);
                i4 = 1;
            }
        }
        Object obj2 = 1;
        for (i4 = fArr.length - 2; i4 >= 0 && r0 != null; i4 -= 2) {
            i = (int) fArr[i4];
            i5 = (int) fArr[i4 + 1];
            if (i < -1 || i > i2 || i5 < -1 || i5 > i3) {
                throw NotFoundException.f13456a;
            }
            if (i == -1) {
                fArr[i4] = 0.0f;
                obj2 = 1;
            } else if (i == i2) {
                fArr[i4] = (float) (i2 - 1);
                i = 1;
            } else {
                obj2 = null;
            }
            if (i5 == -1) {
                fArr[i4 + 1] = 0.0f;
                obj2 = 1;
            } else if (i5 == i3) {
                fArr[i4 + 1] = (float) (i3 - 1);
                i = 1;
            }
        }
    }
}
