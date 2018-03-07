package com.facebook.feed.animation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: arcAngle */
public class CollapseAnimation extends Animation {
    private final View f19124a;
    private final int f19125b;
    private final int f19126c;

    public CollapseAnimation(View view, int i, int i2) {
        this.f19124a = view;
        this.f19125b = i;
        this.f19126c = i2;
    }

    protected void applyTransformation(float f, Transformation transformation) {
        this.f19124a.getLayoutParams().height = this.f19126c + ((int) (((float) (this.f19125b - this.f19126c)) * (1.0f - f)));
        this.f19124a.requestLayout();
    }

    public boolean willChangeBounds() {
        return true;
    }
}
