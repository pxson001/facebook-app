package com.facebook.notifications.nux;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.fbui.popover.PopoverViewFlipper.NubShown;
import com.facebook.fbui.popover.PopoverWindow;

@TargetApi(11)
/* compiled from: negativefeedback_answer_question */
public class InlineFeedbackLongTapNuxPopover extends PopoverWindow {
    private View f8418a;
    public ImageView f8419l;
    public ImageView f8420m;
    public AnimatorSet f8421n;
    private int f8422o;

    /* compiled from: negativefeedback_answer_question */
    class C06761 implements OnTouchListener {
        final /* synthetic */ InlineFeedbackLongTapNuxPopover f8413a;

        C06761(InlineFeedbackLongTapNuxPopover inlineFeedbackLongTapNuxPopover) {
            this.f8413a = inlineFeedbackLongTapNuxPopover;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f8413a.r) {
                this.f8413a.l();
            }
            return false;
        }
    }

    /* compiled from: negativefeedback_answer_question */
    class C06772 implements AnimatorUpdateListener {
        final /* synthetic */ InlineFeedbackLongTapNuxPopover f8414a;

        C06772(InlineFeedbackLongTapNuxPopover inlineFeedbackLongTapNuxPopover) {
            this.f8414a = inlineFeedbackLongTapNuxPopover;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = 1.2f - (((Float) valueAnimator.getAnimatedValue()).floatValue() * 0.2f);
            this.f8414a.f8420m.setScaleX(floatValue);
            this.f8414a.f8420m.setScaleY(floatValue);
        }
    }

    /* compiled from: negativefeedback_answer_question */
    class C06783 implements AnimatorUpdateListener {
        final /* synthetic */ InlineFeedbackLongTapNuxPopover f8415a;

        C06783(InlineFeedbackLongTapNuxPopover inlineFeedbackLongTapNuxPopover) {
            this.f8415a = inlineFeedbackLongTapNuxPopover;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f8415a.f8419l.setAlpha(0.8f * (1.0f - floatValue));
            floatValue = (floatValue * 0.7f) + 0.3f;
            this.f8415a.f8419l.setScaleX(floatValue);
            this.f8415a.f8419l.setScaleY(floatValue);
        }
    }

    /* compiled from: negativefeedback_answer_question */
    class C06794 extends AnimatorListenerAdapter {
        final /* synthetic */ InlineFeedbackLongTapNuxPopover f8416a;
        private boolean f8417b;

        C06794(InlineFeedbackLongTapNuxPopover inlineFeedbackLongTapNuxPopover) {
            this.f8416a = inlineFeedbackLongTapNuxPopover;
        }

        public void onAnimationCancel(Animator animator) {
            this.f8417b = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f8417b) {
                InlineFeedbackLongTapNuxPopover.m10002b(this.f8416a);
                this.f8416a.f8421n.start();
            }
        }

        public void onAnimationStart(Animator animator) {
            this.f8417b = false;
        }
    }

    public InlineFeedbackLongTapNuxPopover(Context context) {
        super(context);
        this.f8418a = LayoutInflater.from(context).inflate(2130905492, null);
        this.f8422o = context.getResources().getDimensionPixelSize(2131429195) / 2;
        a(new ColorDrawable(0));
        b(0.0f);
        d(this.f8418a);
    }

    public final void m10003a() {
        this.g.setOnTouchListener(new C06761(this));
        this.f8419l = (ImageView) this.f8418a.findViewById(2131564276);
        this.f8420m = (ImageView) this.f8418a.findViewById(2131564277);
        Animator ofFloat = ObjectAnimator.ofFloat(this.f8420m, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setDuration(400);
        Animator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat2.setDuration(350);
        ofFloat2.setInterpolator(new AccelerateInterpolator());
        ofFloat2.addUpdateListener(new C06772(this));
        Animator ofFloat3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat3.setDuration(2000);
        ofFloat3.addUpdateListener(new C06783(this));
        Animator ofFloat4 = ObjectAnimator.ofFloat(this.f8420m, "alpha", new float[]{1.0f, 0.0f});
        ofFloat4.setDuration(400);
        this.f8421n = new AnimatorSet();
        this.f8421n.play(ofFloat2).before(ofFloat3).after(ofFloat);
        this.f8421n.play(ofFloat4).after(1950);
        this.f8421n.setStartDelay(800);
        this.f8421n.addListener(new C06794(this));
    }

    public static void m10002b(InlineFeedbackLongTapNuxPopover inlineFeedbackLongTapNuxPopover) {
        inlineFeedbackLongTapNuxPopover.f8419l.setAlpha(0.0f);
        inlineFeedbackLongTapNuxPopover.f8419l.setScaleX(0.3f);
        inlineFeedbackLongTapNuxPopover.f8419l.setScaleY(0.3f);
        inlineFeedbackLongTapNuxPopover.f8420m.setAlpha(0.0f);
        inlineFeedbackLongTapNuxPopover.f8420m.setScaleX(1.2f);
        inlineFeedbackLongTapNuxPopover.f8420m.setScaleY(1.2f);
    }

    public final void m10005l() {
        super.l();
        this.f8421n.cancel();
    }

    protected final void m10004a(View view, boolean z, LayoutParams layoutParams) {
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams2.leftMargin = 0;
        layoutParams2.rightMargin = 0;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int width = view.getWidth();
        int height = view.getHeight();
        int i = iArr[0];
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        int i2 = displayMetrics.widthPixels;
        this.f8418a.measure(MeasureSpec.makeMeasureSpec(i2, 0), MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, 0));
        int measuredWidth = this.f8418a.getMeasuredWidth();
        layoutParams.width = ((this.f.getPaddingLeft() + measuredWidth) + this.f.getPaddingRight() >= i2 ? 1 : 0) != 0 ? measuredWidth : -1;
        layoutParams.height = this.f8418a.getMeasuredHeight();
        layoutParams.y = (iArr[1] - this.f8422o) + (height / 2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f.getLayoutParams();
        int i3 = (width / 2) + i;
        this.f.setNubShown(NubShown.NONE);
        layoutParams3.gravity = 49;
        layoutParams.gravity = 49;
        layoutParams.gravity |= 1;
        layoutParams3.gravity |= 1;
        measuredWidth = (i2 - measuredWidth) / 2;
        layoutParams3.leftMargin = measuredWidth;
        layoutParams3.rightMargin = measuredWidth;
        this.f.setLayoutParams(layoutParams3);
        if (this.f.b()) {
            layoutParams.windowAnimations = 0;
        }
        if (VERSION.SDK_INT >= 14) {
            this.f.a(i3, 0);
        }
        layoutParams.flags |= 56;
    }
}
