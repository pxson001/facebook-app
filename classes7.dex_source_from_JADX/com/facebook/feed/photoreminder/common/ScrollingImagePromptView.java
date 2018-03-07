package com.facebook.feed.photoreminder.common;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.device.ScreenUtil;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPhotoTray;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: admin_panel_upsell_notifications_row */
public abstract class ScrollingImagePromptView extends CustomFrameLayout implements HasPhotoTray {
    @Inject
    public ScreenUtil f19726a;
    public PromptHScrollView f19727b;
    public View f19728c;
    public ValueAnimator f19729d;
    public ValueAnimator f19730e;
    public ObjectAnimator f19731f;
    private int f19732g;
    public int f19733h;
    public boolean f19734i;

    /* compiled from: admin_panel_upsell_notifications_row */
    class C17121 implements AnimatorUpdateListener {
        final /* synthetic */ ScrollingImagePromptView f19755a;

        C17121(ScrollingImagePromptView scrollingImagePromptView) {
            this.f19755a = scrollingImagePromptView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            LayoutParams layoutParams = this.f19755a.f19728c.getLayoutParams();
            layoutParams.height = intValue;
            this.f19755a.f19728c.setLayoutParams(layoutParams);
        }
    }

    /* compiled from: admin_panel_upsell_notifications_row */
    class C17132 implements AnimatorListener {
        final /* synthetic */ ScrollingImagePromptView f19756a;

        C17132(ScrollingImagePromptView scrollingImagePromptView) {
            this.f19756a = scrollingImagePromptView;
        }

        public void onAnimationStart(Animator animator) {
            this.f19756a.setPadding(0, 0, 0, 0);
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f19756a.mo1470g()) {
                this.f19756a.f19727b.setTranslationX((float) this.f19756a.f19733h);
                this.f19756a.f19727b.setVisibility(0);
            }
            this.f19756a.setHasBeenShown(true);
            this.f19756a.f19731f.start();
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: admin_panel_upsell_notifications_row */
    class C17143 implements AnimatorUpdateListener {
        final /* synthetic */ ScrollingImagePromptView f19757a;

        C17143(ScrollingImagePromptView scrollingImagePromptView) {
            this.f19757a = scrollingImagePromptView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            LayoutParams layoutParams = this.f19757a.f19728c.getLayoutParams();
            layoutParams.height = intValue;
            this.f19757a.f19728c.setLayoutParams(layoutParams);
        }
    }

    /* compiled from: admin_panel_upsell_notifications_row */
    class C17154 implements AnimatorListener {
        final /* synthetic */ ScrollingImagePromptView f19758a;

        C17154(ScrollingImagePromptView scrollingImagePromptView) {
            this.f19758a = scrollingImagePromptView;
        }

        public void onAnimationStart(Animator animator) {
            this.f19758a.setIsAnimationRunning(true);
        }

        public void onAnimationEnd(Animator animator) {
            this.f19758a.f19727b.setVisibility(8);
            this.f19758a.f19727b.setTranslationX((float) this.f19758a.f19733h);
            this.f19758a.setIsAnimationRunning(false);
            this.f19758a.setHasBeenShown(false);
            this.f19758a.f19734i = false;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: admin_panel_upsell_notifications_row */
    class SlidePhotoGalleryAnimatorListener implements AnimatorListener {
        final /* synthetic */ ScrollingImagePromptView f19759a;

        public SlidePhotoGalleryAnimatorListener(ScrollingImagePromptView scrollingImagePromptView) {
            this.f19759a = scrollingImagePromptView;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f19759a.setIsAnimationRunning(false);
            this.f19759a.f19734i = true;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    public static void m22980a(Object obj, Context context) {
        ((ScrollingImagePromptView) obj).f19726a = ScreenUtil.a(FbInjector.get(context));
    }

    protected abstract boolean mo1470g();

    protected abstract int getImageTrayHeight();

    protected abstract boolean mo1472h();

    protected abstract void setHasBeenShown(boolean z);

    protected abstract void setIsAnimationRunning(boolean z);

    public ScrollingImagePromptView(Context context) {
        super(context);
        mo1467b();
    }

    public ScrollingImagePromptView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo1467b();
    }

    public ScrollingImagePromptView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo1467b();
    }

    protected void mo1467b() {
        Class cls = ScrollingImagePromptView.class;
        m22980a(this, getContext());
        getResources();
        setContentView(2130904320);
        this.f19732g = getImageTrayHeight();
        this.f19728c = findViewById(2131561946);
        this.f19733h = this.f19726a.c();
        this.f19727b = (PromptHScrollView) findViewById(2131561947);
        this.f19727b.setTranslationX((float) this.f19733h);
        setMinimumHeight(this.f19732g);
        this.f19728c.setMinimumHeight(this.f19732g);
        if (this.f19729d == null || this.f19730e == null) {
            this.f19729d = mo1468e();
            this.f19730e = mo1469f();
            this.f19731f = mo1473i();
        }
    }

    public int getMinimumHeight() {
        if (VERSION.SDK_INT < 16) {
            return getSuggestedMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public View getPhotoTray() {
        return findViewById(2131561947);
    }

    public void mo1466a(boolean z) {
        if (!mo1472h()) {
            this.f19730e.setDuration(z ? 0 : 500);
            this.f19730e.start();
        }
    }

    @SuppressLint({"SetLayoutParams"})
    public void setHeight(int i) {
        Preconditions.checkState(getLayoutParams() instanceof LayoutParams, "expected the container to be a ViewGroup, update ScrollingImagePromptView");
        LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    public ValueAnimator mo1468e() {
        Preconditions.checkNotNull(this.f19728c);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f19728c.getHeight(), this.f19732g});
        ofInt.setDuration(0);
        ofInt.addUpdateListener(new C17121(this));
        ofInt.addListener(new C17132(this));
        return ofInt;
    }

    public ValueAnimator mo1469f() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f19732g, 0});
        ofInt.setDuration(500);
        ofInt.addUpdateListener(new C17143(this));
        ofInt.addListener(new C17154(this));
        return ofInt;
    }

    public ObjectAnimator mo1473i() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f19727b, "translationX", new float[]{(float) this.f19733h, 0.0f});
        ofFloat.setDuration(600);
        ofFloat.addListener(new SlidePhotoGalleryAnimatorListener(this));
        return ofFloat;
    }
}
