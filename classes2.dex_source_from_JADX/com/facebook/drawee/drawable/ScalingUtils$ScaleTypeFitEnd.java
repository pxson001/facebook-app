package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;

/* compiled from: messenger/ */
class ScalingUtils$ScaleTypeFitEnd extends ScalingUtils$AbstractScaleType {
    public static final ScalingUtils$ScaleType f14225i = new ScalingUtils$ScaleTypeFitEnd();

    private ScalingUtils$ScaleTypeFitEnd() {
    }

    public final void mo2730a(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
        float min = Math.min(f3, f4);
        float width = ((float) rect.left) + (((float) rect.width()) - (((float) i) * min));
        float height = ((float) rect.top) + (((float) rect.height()) - (((float) i2) * min));
        matrix.setScale(min, min);
        matrix.postTranslate((float) ((int) (width + 0.5f)), (float) ((int) (height + 0.5f)));
    }
}
