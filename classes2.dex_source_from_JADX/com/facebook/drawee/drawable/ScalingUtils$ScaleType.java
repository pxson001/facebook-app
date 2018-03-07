package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;

/* compiled from: messenger/ */
public interface ScalingUtils$ScaleType {
    public static final ScalingUtils$ScaleType f14214a = ScalingUtils$ScaleTypeFitXY.f14222i;
    public static final ScalingUtils$ScaleType f14215b = ScalingUtils$ScaleTypeFitStart.f14223i;
    public static final ScalingUtils$ScaleType f14216c = ScalingUtils$ScaleTypeFitCenter.f14224i;
    public static final ScalingUtils$ScaleType f14217d = ScalingUtils$ScaleTypeFitEnd.f14225i;
    public static final ScalingUtils$ScaleType f14218e = ScalingUtils$ScaleTypeCenter.f14226i;
    public static final ScalingUtils$ScaleType f14219f = ScalingUtils$ScaleTypeCenterInside.f14227i;
    public static final ScalingUtils$ScaleType f14220g = ScalingUtils$ScaleTypeCenterCrop.f14228i;
    public static final ScalingUtils$ScaleType f14221h = ScalingUtils$ScaleTypeFocusCrop.f14229i;

    Matrix mo2731a(Matrix matrix, Rect rect, int i, int i2, float f, float f2);
}
