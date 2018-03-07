package com.facebook.photos.creativeediting.utilities;

import android.graphics.RectF;

/* compiled from: impression_event */
public class RotateRectfHelper {
    public static int m20242a(int i) {
        if (i % 90 == 0) {
            return (4 - (i / 90)) % 4;
        }
        throw new UnsupportedOperationException("Rotation " + i + " is not supported.");
    }

    public static RectF m20243a(RectF rectF, int i) {
        if (i == 1) {
            return new RectF(rectF.top, 1.0f - rectF.right, rectF.bottom, 1.0f - rectF.left);
        }
        if (i == 2) {
            return new RectF(1.0f - rectF.right, 1.0f - rectF.bottom, 1.0f - rectF.left, 1.0f - rectF.top);
        }
        if (i == 3) {
            return new RectF(1.0f - rectF.bottom, rectF.left, 1.0f - rectF.top, rectF.right);
        }
        if (i == 0 || i == 4) {
            return new RectF(rectF);
        }
        throw new UnsupportedOperationException("Number of counter clock wise rotation " + i + " is not supported.");
    }
}
