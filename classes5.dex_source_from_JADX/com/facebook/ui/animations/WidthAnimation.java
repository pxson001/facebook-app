package com.facebook.ui.animations;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: completed_subtitle */
public class WidthAnimation extends Animation {
    private final int f5396a;
    private final int f5397b;
    private final View f5398c;

    public WidthAnimation(View view, int i, int i2) {
        this.f5398c = view;
        this.f5396a = i;
        this.f5397b = i2;
    }

    protected void applyTransformation(float f, Transformation transformation) {
        this.f5398c.getLayoutParams().width = (int) (((float) this.f5396a) + (((float) (this.f5397b - this.f5396a)) * f));
        this.f5398c.requestLayout();
    }

    public boolean willChangeBounds() {
        return true;
    }
}
