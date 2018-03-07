package com.facebook.react.uimanager.layoutanimation;

import android.view.animation.Interpolator;

/* compiled from: flag */
class SimpleSpringInterpolator implements Interpolator {
    SimpleSpringInterpolator() {
    }

    public float getInterpolation(float f) {
        return (float) (1.0d + (Math.pow(2.0d, (double) (-10.0f * f)) * Math.sin(((((double) (f - 0.125f)) * 3.141592653589793d) * 2.0d) / 0.5d)));
    }
}
