package com.facebook.fbui.draggable;

import android.view.animation.Interpolator;

/* compiled from: requiresReauth */
public class SmoothLinearInterpolator implements Interpolator {
    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
    }
}
