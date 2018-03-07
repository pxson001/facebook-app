package com.facebook.widget.images;

import android.graphics.Matrix;

/* compiled from: reportAAAOnlyMeAction */
public class PhotoFocusUtil {
    private PhotoFocusUtil() {
    }

    public static Matrix m8383a(int i, int i2, int i3, int i4, double d, double d2) {
        float f;
        float min;
        float f2 = 0.0f;
        if (((float) i3) / ((float) i4) > ((float) i) / ((float) i2)) {
            f = ((float) i2) / ((float) i4);
            min = Math.min(Math.max((float) ((((double) (((float) i3) * f)) * d) - ((double) (((float) i) * 0.5f))), 0.0f), (((float) i3) * f) - ((float) i));
        } else {
            f = ((float) i) / ((float) i3);
            min = 0.0f;
            f2 = Math.min(Math.max((float) ((((double) (((float) i4) * f)) * d2) - ((double) (((float) i2) * 0.5f))), 0.0f), (((float) i4) * f) - ((float) i2));
        }
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.postScale(f, f);
        matrix.postTranslate(-min, -f2);
        return matrix;
    }
}
