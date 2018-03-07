package com.facebook.search.quickpromotion;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;

/* compiled from: TEXT_CODE */
public class ScaleTypeFitWidthAndCropBottom extends AbstractScaleType {
    public static final ScaleType f22351i = new ScaleTypeFitWidthAndCropBottom();

    public final void m25855a(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
        float width = ((float) rect.left) + ((((float) rect.width()) - (((float) i) * f3)) * 0.5f);
        float f5 = (float) rect.top;
        matrix.setScale(f3, f3);
        matrix.postTranslate(((float) ((int) width)) + 0.5f, ((float) ((int) f5)) + 0.5f);
    }
}
