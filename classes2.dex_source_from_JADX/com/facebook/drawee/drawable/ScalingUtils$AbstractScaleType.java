package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;

/* compiled from: messenger/ */
public abstract class ScalingUtils$AbstractScaleType implements ScalingUtils$ScaleType {
    public abstract void mo2730a(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4);

    public final Matrix mo2731a(Matrix matrix, Rect rect, int i, int i2, float f, float f2) {
        mo2730a(matrix, rect, i, i2, f, f2, ((float) rect.width()) / ((float) i), ((float) rect.height()) / ((float) i2));
        return matrix;
    }
}
