package com.facebook.crowdsourcing.placequestion.animation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: com.facebook.friendsharing.souvenirs.models.SouvenirUriItemDeserializer */
public class StackPopOffAnimation extends Animation {
    private final float f17561a;
    private final int f17562b;
    private final View f17563c;
    private final int f17564d;

    public StackPopOffAnimation(View view, float f) {
        this.f17563c = view;
        this.f17561a = f;
        this.f17564d = view.getWidth();
        this.f17562b = view.getHeight();
    }

    protected void applyTransformation(float f, Transformation transformation) {
        float f2 = (this.f17561a - 1.0f) * f;
        transformation.getMatrix().setTranslate((-(((float) this.f17564d) * f2)) / 2.0f, (-(((float) this.f17562b) * f2)) / 2.0f);
        transformation.getMatrix().postScale(1.0f + f2, f2 + 1.0f);
        this.f17563c.setAlpha(1.0f - f);
        this.f17563c.requestLayout();
    }
}
