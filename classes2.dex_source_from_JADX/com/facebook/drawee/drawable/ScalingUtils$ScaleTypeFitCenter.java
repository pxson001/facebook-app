package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;

/* compiled from: messenger/ */
class ScalingUtils$ScaleTypeFitCenter extends ScalingUtils$AbstractScaleType {
    public static final ScalingUtils$ScaleType f14224i = new ScalingUtils$ScaleTypeFitCenter();

    private ScalingUtils$ScaleTypeFitCenter() {
    }

    public final void mo2730a(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
        float min = Math.min(f3, f4);
        float width = ((float) rect.left) + ((((float) rect.width()) - (((float) i) * min)) * 0.5f);
        float height = ((float) rect.top) + ((((float) rect.height()) - (((float) i2) * min)) * 0.5f);
        matrix.setScale(min, min);
        matrix.postTranslate((float) ((int) (width + 0.5f)), (float) ((int) (height + 0.5f)));
    }
}
