package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: flex */
class PositionAndSizeAnimation extends Animation implements HandleLayout {
    private final View f11932a;
    private final float f11933b;
    private final float f11934c;
    private final float f11935d;
    private final float f11936e;
    private final int f11937f;
    private final int f11938g;
    private final int f11939h;
    private final int f11940i;

    public PositionAndSizeAnimation(View view, int i, int i2, int i3, int i4) {
        this.f11932a = view;
        this.f11933b = view.getX();
        this.f11934c = view.getY();
        this.f11937f = view.getWidth();
        this.f11938g = view.getHeight();
        this.f11935d = ((float) i) - this.f11933b;
        this.f11936e = ((float) i2) - this.f11934c;
        this.f11939h = i3 - this.f11937f;
        this.f11940i = i4 - this.f11938g;
    }

    protected void applyTransformation(float f, Transformation transformation) {
        float f2 = this.f11933b + (this.f11935d * f);
        float f3 = this.f11934c + (this.f11936e * f);
        this.f11932a.layout(Math.round(f2), Math.round(f3), Math.round(f2 + (((float) this.f11937f) + (((float) this.f11939h) * f))), Math.round(f3 + (((float) this.f11938g) + (((float) this.f11940i) * f))));
    }

    public boolean willChangeBounds() {
        return true;
    }
}
