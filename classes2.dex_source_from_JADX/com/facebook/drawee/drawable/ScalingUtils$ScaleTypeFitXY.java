package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;

/* compiled from: messenger/ */
class ScalingUtils$ScaleTypeFitXY extends ScalingUtils$AbstractScaleType {
    public static final ScalingUtils$ScaleType f14222i = new ScalingUtils$ScaleTypeFitXY();

    private ScalingUtils$ScaleTypeFitXY() {
    }

    public final void mo2730a(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
        float f5 = (float) rect.left;
        float f6 = (float) rect.top;
        matrix.setScale(f3, f4);
        matrix.postTranslate((float) ((int) (f5 + 0.5f)), (float) ((int) (f6 + 0.5f)));
    }
}
