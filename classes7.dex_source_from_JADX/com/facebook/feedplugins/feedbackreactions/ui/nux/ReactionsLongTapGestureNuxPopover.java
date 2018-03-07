package com.facebook.feedplugins.feedbackreactions.ui.nux;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import com.facebook.fbui.popover.PopoverViewFlipper.NubShown;
import com.facebook.fbui.popover.PopoverWindow;

/* compiled from: String */
public class ReactionsLongTapGestureNuxPopover extends PopoverWindow {
    private final ViewGroup f23126a;
    public final ImageView f23127l = ((ImageView) this.f23126a.findViewById(2131563647));
    public final ImageView f23128m = ((ImageView) this.f23126a.findViewById(2131563648));
    private final int f23129n;
    public AnimatorSet f23130o;

    /* compiled from: String */
    class C19991 implements OnTouchListener {
        final /* synthetic */ ReactionsLongTapGestureNuxPopover f23121a;

        C19991(ReactionsLongTapGestureNuxPopover reactionsLongTapGestureNuxPopover) {
            this.f23121a = reactionsLongTapGestureNuxPopover;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f23121a.r) {
                this.f23121a.l();
            }
            return false;
        }
    }

    /* compiled from: String */
    class C20002 implements AnimatorUpdateListener {
        final /* synthetic */ ReactionsLongTapGestureNuxPopover f23122a;

        C20002(ReactionsLongTapGestureNuxPopover reactionsLongTapGestureNuxPopover) {
            this.f23122a = reactionsLongTapGestureNuxPopover;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = 1.2f - (((Float) valueAnimator.getAnimatedValue()).floatValue() * 0.2f);
            this.f23122a.f23128m.setScaleX(floatValue);
            this.f23122a.f23128m.setScaleY(floatValue);
        }
    }

    /* compiled from: String */
    class C20013 implements AnimatorUpdateListener {
        final /* synthetic */ ReactionsLongTapGestureNuxPopover f23123a;

        C20013(ReactionsLongTapGestureNuxPopover reactionsLongTapGestureNuxPopover) {
            this.f23123a = reactionsLongTapGestureNuxPopover;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f23123a.f23127l.setAlpha(0.8f * (1.0f - floatValue));
            floatValue = (floatValue * 0.7f) + 0.3f;
            this.f23123a.f23127l.setScaleX(floatValue);
            this.f23123a.f23127l.setScaleY(floatValue);
        }
    }

    /* compiled from: String */
    class C20024 extends AnimatorListenerAdapter {
        final /* synthetic */ ReactionsLongTapGestureNuxPopover f23124a;
        private boolean f23125b;

        C20024(ReactionsLongTapGestureNuxPopover reactionsLongTapGestureNuxPopover) {
            this.f23124a = reactionsLongTapGestureNuxPopover;
        }

        public void onAnimationCancel(Animator animator) {
            this.f23125b = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f23125b) {
                ReactionsLongTapGestureNuxPopover.m25551b(this.f23124a);
                this.f23124a.f23130o.start();
            }
        }

        public void onAnimationStart(Animator animator) {
            this.f23125b = false;
        }
    }

    public ReactionsLongTapGestureNuxPopover(Context context) {
        super(context);
        this.f23126a = (ViewGroup) LayoutInflater.from(context).inflate(2130905146, null);
        this.f23129n = context.getResources().getDimensionPixelSize(2131431935) / 2;
        d(this.f23126a);
        m25550a(this.g, false);
        m25550a(this.f, false);
        m25550a(this.f23126a, false);
        a(null);
        b(0.0f);
        this.g.setOnTouchListener(new C19991(this));
        m25549a();
        m25551b(this);
    }

    private void m25549a() {
        Animator ofFloat = ObjectAnimator.ofFloat(this.f23128m, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setDuration(400);
        Animator ofFloat2 = ObjectAnimator.ofFloat(this.f23128m, "alpha", new float[]{1.0f, 0.0f});
        ofFloat2.setDuration(400);
        Animator ofFloat3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat3.setDuration(350);
        ofFloat3.setInterpolator(new AccelerateInterpolator());
        ofFloat3.addUpdateListener(new C20002(this));
        Animator ofFloat4 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat4.setDuration(2000);
        ofFloat4.addUpdateListener(new C20013(this));
        this.f23130o = new AnimatorSet();
        this.f23130o.play(ofFloat3).before(ofFloat4).after(ofFloat);
        this.f23130o.play(ofFloat2).after(1950);
        this.f23130o.setStartDelay(800);
        this.f23130o.addListener(new C20024(this));
    }

    private static void m25550a(ViewGroup viewGroup, boolean z) {
        viewGroup.setClipChildren(z);
        viewGroup.setClipToPadding(z);
    }

    public static void m25551b(ReactionsLongTapGestureNuxPopover reactionsLongTapGestureNuxPopover) {
        reactionsLongTapGestureNuxPopover.f23127l.setAlpha(0.0f);
        reactionsLongTapGestureNuxPopover.f23127l.setScaleX(0.3f);
        reactionsLongTapGestureNuxPopover.f23127l.setScaleY(0.3f);
        reactionsLongTapGestureNuxPopover.f23128m.setAlpha(0.0f);
        reactionsLongTapGestureNuxPopover.f23128m.setScaleX(1.2f);
        reactionsLongTapGestureNuxPopover.f23128m.setScaleY(1.2f);
    }

    public final void m25553l() {
        super.l();
        this.f23130o.cancel();
    }

    protected final void m25552a(View view, boolean z, LayoutParams layoutParams) {
        int width = view.getWidth();
        int height = view.getHeight();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        layoutParams.width = this.f23129n * 2;
        layoutParams.height = this.f23129n * 2;
        layoutParams.x = (width / 2) + (iArr[0] - this.f23129n);
        layoutParams.y = (iArr[1] - this.f23129n) + (height / 2);
        layoutParams.gravity = 51;
        this.f.setNubShown(NubShown.NONE);
        if (this.f.b()) {
            layoutParams.windowAnimations = 0;
        }
        layoutParams.flags |= 56;
    }
}
