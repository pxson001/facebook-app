package com.facebook.camera.views;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.camera.utils.CameraUtils;
import com.facebook.camera.utils.CameraUtils.Corner;

/* compiled from: all_contacts */
public class CornerControl {
    public final View f11075a;
    private final Rect f11076b;
    public Corner f11077c;
    public ObjectAnimator f11078d;

    /* compiled from: all_contacts */
    class ControlMoverRotater implements AnimatorListener {
        final /* synthetic */ CornerControl f11072a;
        private float f11073b;
        private boolean f11074c = false;

        ControlMoverRotater(CornerControl cornerControl, float f) {
            this.f11072a = cornerControl;
            this.f11073b = f;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
            m19059a(this);
        }

        public void onAnimationEnd(Animator animator) {
            m19059a(this);
            this.f11072a.f11078d = null;
        }

        public void onAnimationCancel(Animator animator) {
            this.f11074c = true;
        }

        public static void m19059a(ControlMoverRotater controlMoverRotater) {
            if (!controlMoverRotater.f11074c) {
                controlMoverRotater.f11072a.f11075a.setRotation(controlMoverRotater.f11073b);
                CornerControl.m19060c(controlMoverRotater.f11072a);
                controlMoverRotater.f11074c = true;
            }
        }
    }

    public CornerControl(View view, Rect rect) {
        this.f11075a = view;
        this.f11076b = rect;
    }

    public final void m19061a() {
        this.f11075a.setVisibility(0);
        this.f11075a.setAlpha(0.0f);
    }

    public final void m19064a(OnTouchListener onTouchListener) {
        this.f11075a.setOnTouchListener(onTouchListener);
    }

    public final void m19063a(OnClickListener onClickListener) {
        this.f11075a.setOnClickListener(onClickListener);
    }

    public final void m19062a(float f, boolean z) {
        float a = CameraUtils.m19050a(this.f11075a.getRotation(), f);
        boolean z2 = this.f11075a.getAlpha() != 0.0f;
        this.f11075a.setPivotX((float) (this.f11075a.getWidth() / 2));
        this.f11075a.setPivotY((float) (this.f11075a.getHeight() / 2));
        m19065b();
        if (z == z2) {
            if (z) {
                this.f11078d = ObjectAnimator.ofFloat(this.f11075a, "alpha", new float[]{1.0f, 0.0f});
                this.f11078d.setDuration(200);
                this.f11078d.setRepeatCount(1);
                this.f11078d.setRepeatMode(2);
                this.f11078d.addListener(new ControlMoverRotater(this, a));
                this.f11078d.start();
                return;
            }
            m19060c(this);
            this.f11075a.setRotation(a);
            this.f11078d = null;
        } else if (z) {
            AnimatorListener controlMoverRotater = new ControlMoverRotater(this, a);
            ControlMoverRotater.m19059a(controlMoverRotater);
            this.f11078d = ObjectAnimator.ofFloat(this.f11075a, "alpha", new float[]{r4, 1.0f});
            this.f11078d.setDuration(400);
            this.f11078d.addListener(controlMoverRotater);
            this.f11078d.start();
        } else {
            this.f11078d = ObjectAnimator.ofFloat(this.f11075a, "alpha", new float[]{r4, 0.0f});
            this.f11078d.setDuration(400);
            this.f11078d.addListener(new ControlMoverRotater(this, a));
            this.f11078d.start();
        }
    }

    public final void m19065b() {
        if (this.f11078d != null) {
            this.f11078d.cancel();
        }
    }

    public static void m19060c(CornerControl cornerControl) {
        LayoutParams layoutParams = (LayoutParams) cornerControl.f11075a.getLayoutParams();
        if (cornerControl.f11077c == Corner.TOP_LEFT || cornerControl.f11077c == Corner.BOTTOM_LEFT) {
            layoutParams.leftMargin = cornerControl.f11076b.left;
            layoutParams.rightMargin = 0;
            layoutParams.addRule(9);
            layoutParams.addRule(11, 0);
        } else {
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = cornerControl.f11076b.right;
            layoutParams.addRule(9, 0);
            layoutParams.addRule(11);
        }
        if (cornerControl.f11077c == Corner.TOP_LEFT || cornerControl.f11077c == Corner.TOP_RIGHT) {
            layoutParams.topMargin = cornerControl.f11076b.top;
            layoutParams.bottomMargin = 0;
            layoutParams.addRule(10);
            layoutParams.addRule(12, 0);
        } else {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = cornerControl.f11076b.bottom;
            layoutParams.addRule(10, 0);
            layoutParams.addRule(12);
        }
        cornerControl.f11075a.requestLayout();
    }
}
