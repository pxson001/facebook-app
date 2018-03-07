package com.facebook.messaging.quickcam;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;

/* compiled from: depth= */
public class CameraFlash extends View {
    private Animation f16409a;

    /* compiled from: depth= */
    class C19351 implements AnimationListener {
        final /* synthetic */ CameraFlash f16408a;

        C19351(CameraFlash cameraFlash) {
            this.f16408a = cameraFlash;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            this.f16408a.setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    public CameraFlash(Context context) {
        super(context);
        m16469b();
    }

    public CameraFlash(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16469b();
    }

    private void m16469b() {
        setBackgroundDrawable(new ColorDrawable(-1));
        this.f16409a = new AlphaAnimation(1.0f, 0.0f);
        this.f16409a.setDuration(300);
        this.f16409a.setInterpolator(new LinearInterpolator());
        this.f16409a.setAnimationListener(new C19351(this));
    }

    public final void m16470a() {
        setVisibility(0);
        startAnimation(this.f16409a);
    }
}
