package com.facebook.commerce.core.animations;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;

/* compiled from: primary_button */
public class SlideUpAnimation extends Animation {
    public float f7456a;
    public View f7457b;

    /* compiled from: primary_button */
    class C04481 implements AnimationListener {
        final /* synthetic */ SlideUpAnimation f7455a;

        C04481(SlideUpAnimation slideUpAnimation) {
            this.f7455a = slideUpAnimation;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            this.f7455a.f7457b.setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    public SlideUpAnimation(int i, View view) {
        this.f7457b = view;
        setDuration((long) i);
        setAnimationListener(new C04481(this));
    }

    protected void applyTransformation(float f, Transformation transformation) {
        if (f == 1.0f) {
            this.f7457b.getLayoutParams().height = -2;
        } else {
            this.f7457b.getLayoutParams().height = (int) (this.f7456a * (1.0f - f));
        }
        this.f7457b.requestLayout();
    }

    public boolean willChangeBounds() {
        return true;
    }
}
