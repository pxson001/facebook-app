package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;

/* compiled from: messenger/ */
class ScalingUtils$ScaleTypeFitStart extends ScalingUtils$AbstractScaleType {
    public static final ScalingUtils$ScaleType f14223i = new ScalingUtils$ScaleTypeFitStart();

    private ScalingUtils$ScaleTypeFitStart() {
    }

    public final void mo2730a(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
        float min = Math.min(f3, f4);
        float f5 = (float) rect.left;
        float f6 = (float) rect.top;
        matrix.setScale(min, min);
        matrix.postTranslate((float) ((int) (f5 + 0.5f)), (float) ((int) (f6 + 0.5f)));
    }
}
