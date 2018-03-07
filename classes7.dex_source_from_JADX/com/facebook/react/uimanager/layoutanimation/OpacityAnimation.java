package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;

/* compiled from: flexDirection */
class OpacityAnimation extends Animation {
    private final View f11929a;
    private final float f11930b;
    private final float f11931c;

    /* compiled from: flexDirection */
    class OpacityAnimationListener implements AnimationListener {
        private final View f11927a;
        private boolean f11928b = false;

        public OpacityAnimationListener(View view) {
            this.f11927a = view;
        }

        public void onAnimationStart(Animation animation) {
            if (this.f11927a.hasOverlappingRendering() && this.f11927a.getLayerType() == 0) {
                this.f11928b = true;
                this.f11927a.setLayerType(2, null);
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f11928b) {
                this.f11927a.setLayerType(0, null);
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    public OpacityAnimation(View view, float f, float f2) {
        this.f11929a = view;
        this.f11930b = f;
        this.f11931c = f2 - f;
        setAnimationListener(new OpacityAnimationListener(view));
    }

    protected void applyTransformation(float f, Transformation transformation) {
        this.f11929a.setAlpha(this.f11930b + (this.f11931c * f));
    }

    public boolean willChangeBounds() {
        return false;
    }
}
