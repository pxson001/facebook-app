package com.facebook.camera.views;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* compiled from: all_sale_groups */
public class ShutterView extends View {
    ShutterAnimationListener f11083a;

    /* compiled from: all_sale_groups */
    public interface ShutterAnimationListener {
        void mo1179n();
    }

    /* compiled from: all_sale_groups */
    class C10721 implements AnimatorListener {
        final /* synthetic */ ShutterView f11082a;

        C10721(ShutterView shutterView) {
            this.f11082a = shutterView;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f11082a.f11083a != null) {
                this.f11082a.f11083a.mo1179n();
                this.f11082a.f11083a = null;
            }
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    public ShutterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setAlpha(0.0f);
    }

    public final void m19075a(ShutterAnimationListener shutterAnimationListener) {
        this.f11083a = shutterAnimationListener;
        setAlpha(1.0f);
        ViewPropertyAnimator animate = animate();
        animate.setStartDelay(80);
        animate.alpha(0.0f);
        animate.setDuration(150);
        if (this.f11083a != null) {
            animate.setListener(new C10721(this));
        }
        animate.start();
    }
}
