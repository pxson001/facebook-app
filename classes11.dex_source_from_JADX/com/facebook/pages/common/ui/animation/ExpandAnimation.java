package com.facebook.pages.common.ui.animation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: red_space_value */
public class ExpandAnimation extends Animation {
    private final View f2707a;
    private final int f2708b;
    private final int f2709c;

    public ExpandAnimation(View view, int i, int i2) {
        this.f2707a = view;
        this.f2708b = i;
        this.f2709c = i2;
    }

    protected void applyTransformation(float f, Transformation transformation) {
        this.f2707a.getLayoutParams().height = this.f2708b + ((int) (((float) (this.f2709c - this.f2708b)) * f));
        this.f2707a.requestLayout();
    }

    public boolean willChangeBounds() {
        return true;
    }
}
