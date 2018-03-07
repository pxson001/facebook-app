package com.facebook.notifications.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.ColorUtils;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

@TargetApi(15)
/* compiled from: meta */
public class SwitchableNotificationView extends CustomFrameLayout {
    public CaspianNotificationsView f9070a;
    public PostFeedbackView f9071b;
    public RevealAnimationOverlayView f9072c;
    private OnClickListener f9073d;
    private OnClickListener f9074e;
    public State f9075f = State.NOTIFICATION;
    private AnimatorSet f9076g;

    /* compiled from: meta */
    class C07262 implements AnimatorUpdateListener {
        final /* synthetic */ SwitchableNotificationView f9063a;

        C07262(SwitchableNotificationView switchableNotificationView) {
            this.f9063a = switchableNotificationView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f9063a.f9072c.setPct(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: meta */
    class C07273 implements AnimatorUpdateListener {
        final /* synthetic */ SwitchableNotificationView f9064a;

        C07273(SwitchableNotificationView switchableNotificationView) {
            this.f9064a = switchableNotificationView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f9064a.f9071b.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: meta */
    class C07284 implements AnimatorListener {
        final /* synthetic */ SwitchableNotificationView f9065a;

        C07284(SwitchableNotificationView switchableNotificationView) {
            this.f9065a = switchableNotificationView;
        }

        public void onAnimationStart(Animator animator) {
            this.f9065a.f9072c.setPct(100.0f);
            this.f9065a.f9072c.setVisibility(0);
            this.f9065a.f9071b.setAlpha(0.0f);
            this.f9065a.f9071b.setVisibility(0);
        }

        public void onAnimationEnd(Animator animator) {
            SwitchableNotificationView.m10893i(this.f9065a);
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: meta */
    class C07295 implements AnimatorUpdateListener {
        final /* synthetic */ SwitchableNotificationView f9066a;

        C07295(SwitchableNotificationView switchableNotificationView) {
            this.f9066a = switchableNotificationView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f9066a.f9071b.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: meta */
    class C07306 implements AnimatorUpdateListener {
        final /* synthetic */ SwitchableNotificationView f9067a;

        C07306(SwitchableNotificationView switchableNotificationView) {
            this.f9067a = switchableNotificationView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f9067a.f9072c.setPct(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: meta */
    class C07317 implements AnimatorListener {
        final /* synthetic */ SwitchableNotificationView f9068a;

        C07317(SwitchableNotificationView switchableNotificationView) {
            this.f9068a = switchableNotificationView;
        }

        public void onAnimationStart(Animator animator) {
            this.f9068a.f9072c.setPct(0.0f);
            this.f9068a.f9072c.setVisibility(0);
            this.f9068a.f9070a.setVisibility(0);
        }

        public void onAnimationEnd(Animator animator) {
            SwitchableNotificationView.m10894j(this.f9068a);
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: meta */
    public enum State {
        NOTIFICATION,
        POST_FEEDBACK
    }

    public SwitchableNotificationView(Context context) {
        super(context);
        m10888e();
    }

    public SwitchableNotificationView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m10888e();
    }

    public SwitchableNotificationView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10888e();
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1364111342);
        super.onDetachedFromWindow();
        m10890f();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1447532004, a);
    }

    private void m10888e() {
        setContentView(2130907359);
        this.f9070a = (CaspianNotificationsView) findViewById(2131567802);
        this.f9071b = (PostFeedbackView) findViewById(2131564286);
        this.f9072c = (RevealAnimationOverlayView) findViewById(2131567803);
        this.f9072c.setColor(getResources().getColor(2131361920));
    }

    public final void m10895a() {
        m10890f();
        m10896a(State.NOTIFICATION, false);
        this.f9073d = null;
        this.f9074e = null;
        this.f9070a.setAuxViewClickListener(null);
        this.f9071b.setChevronClickListener(null);
    }

    private void m10890f() {
        if (this.f9076g != null && this.f9076g.isRunning()) {
            this.f9076g.cancel();
        }
    }

    public State getState() {
        return this.f9075f;
    }

    public final void m10896a(State state, boolean z) {
        m10897a(state, z, null);
    }

    public final void m10897a(State state, boolean z, @Nullable Point point) {
        if (this.f9075f != state) {
            if (point == null) {
                this.f9072c.m10880a(-1, -1);
            } else {
                this.f9072c.m10880a(point.x, point.y);
            }
            switch (state) {
                case POST_FEEDBACK:
                    m10883a(z);
                    return;
                case NOTIFICATION:
                    m10885b(z);
                    return;
                default:
                    return;
            }
        }
    }

    public void setNotificationChevronListener(OnClickListener onClickListener) {
        this.f9073d = onClickListener;
        m10891g();
    }

    public void setPostFeedbackChevronListener(OnClickListener onClickListener) {
        this.f9074e = onClickListener;
    }

    private void m10891g() {
        this.f9071b.f9053b.setOnClickListener(null);
        if (this.f9073d != null) {
            this.f9070a.setAuxViewClickListener(this.f9073d);
            m10882a(this.f9070a, this.f9070a.f8989r);
        }
    }

    private void m10892h() {
        this.f9070a.f8989r.setOnClickListener(null);
        if (this.f9074e != null && this.f9071b.m10879a()) {
            this.f9071b.setChevronClickListener(this.f9074e);
            m10882a(this.f9071b, this.f9071b.f9053b);
        }
    }

    private void m10882a(final View view, final ImageButton imageButton) {
        view.post(new Runnable(this) {
            final /* synthetic */ SwitchableNotificationView f9062c;

            public void run() {
                Rect rect = new Rect();
                imageButton.getHitRect(rect);
                float dimension = view.getContext().getResources().getDimension(2131429193);
                float dimension2 = view.getContext().getResources().getDimension(2131429194);
                rect.top = (int) (((float) rect.top) - dimension);
                rect.left = (int) (((float) rect.left) - dimension2);
                rect.right = (int) (dimension2 + ((float) rect.right));
                rect.bottom = (int) (dimension + ((float) rect.bottom));
                view.setTouchDelegate(new TouchDelegate(rect, imageButton));
            }
        });
    }

    private void m10883a(boolean z) {
        if (z) {
            ValueAnimator.ofFloat(new float[]{100.0f, 0.0f}).setDuration(400).addUpdateListener(new C07262(this));
            ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(200).addUpdateListener(new C07273(this));
            this.f9076g = new AnimatorSet();
            this.f9076g.addListener(new C07284(this));
            this.f9076g.playSequentially(new Animator[]{r0, r1});
            this.f9076g.start();
            return;
        }
        m10893i(this);
    }

    public static void m10893i(SwitchableNotificationView switchableNotificationView) {
        switchableNotificationView.f9075f = State.POST_FEEDBACK;
        switchableNotificationView.f9071b.setVisibility(0);
        switchableNotificationView.f9071b.setAlpha(1.0f);
        switchableNotificationView.f9070a.setVisibility(4);
        switchableNotificationView.f9072c.setVisibility(4);
        switchableNotificationView.m10892h();
    }

    private void m10885b(boolean z) {
        if (z) {
            ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(200).addUpdateListener(new C07295(this));
            ValueAnimator.ofFloat(new float[]{0.0f, 100.0f}).setDuration(400).addUpdateListener(new C07306(this));
            this.f9076g = new AnimatorSet();
            this.f9076g.addListener(new C07317(this));
            this.f9076g.playSequentially(new Animator[]{r0, r1});
            this.f9076g.start();
            return;
        }
        m10894j(this);
    }

    public static void m10894j(SwitchableNotificationView switchableNotificationView) {
        switchableNotificationView.f9075f = State.NOTIFICATION;
        switchableNotificationView.f9071b.setVisibility(4);
        switchableNotificationView.f9072c.setVisibility(4);
        switchableNotificationView.f9070a.setVisibility(0);
        switchableNotificationView.m10891g();
    }

    public void setBackgroundResource(int i) {
        this.f9070a.setBackgroundResource(i);
    }

    public final void m10898b() {
        Drawable background = this.f9070a.getBackground();
        if (background != null && (background instanceof ColorDrawable)) {
            int a = ColorUtils.a(((ColorDrawable) background).getColor(), -1) | -16777216;
            this.f9072c.setColor(a);
            this.f9071b.setBackgroundColor(a);
        }
    }

    public CaspianNotificationsView getNotificationView() {
        return this.f9070a;
    }

    public PostFeedbackView getPostFeedbackView() {
        return this.f9071b;
    }
}
