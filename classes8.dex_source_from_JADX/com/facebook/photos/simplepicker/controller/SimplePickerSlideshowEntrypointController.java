package com.facebook.photos.simplepicker.controller;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.data.MediaData.Type;
import com.facebook.ipc.simplepicker.SimplePickerConfiguration;
import com.facebook.photos.simplepicker.view.SlideshowEntrypointView;
import com.facebook.photos.simplepicker.view.SlideshowEntrypointView.CollageSlideshowSwitchListener;
import com.google.common.collect.ImmutableList;

/* compiled from: shadowRadius */
public class SimplePickerSlideshowEntrypointController {
    private final SimplePickerConfiguration f3146a;
    private View f3147b;
    public SlideshowEntrypointView f3148c;
    public View f3149d;
    private CollageSlideshowSwitchListener f3150e;
    private AnimatorSet f3151f;
    private AnimatorSet f3152g;
    private AnimatorSet f3153h;
    private boolean f3154i;
    private boolean f3155j;

    /* compiled from: shadowRadius */
    class C04041 implements AnimatorListener {
        final /* synthetic */ SimplePickerSlideshowEntrypointController f3144a;

        C04041(SimplePickerSlideshowEntrypointController simplePickerSlideshowEntrypointController) {
            this.f3144a = simplePickerSlideshowEntrypointController;
        }

        public void onAnimationStart(Animator animator) {
            this.f3144a.f3148c.setVisibility(0);
        }

        public void onAnimationEnd(Animator animator) {
            this.f3144a.f3149d.setPadding(this.f3144a.f3149d.getPaddingLeft(), this.f3144a.f3149d.getPaddingTop(), this.f3144a.f3149d.getPaddingRight(), this.f3144a.f3149d.getPaddingBottom() + this.f3144a.f3148c.getMeasuredHeight());
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: shadowRadius */
    public class C04052 implements AnimatorListener {
        final /* synthetic */ SimplePickerSlideshowEntrypointController f3145a;

        public C04052(SimplePickerSlideshowEntrypointController simplePickerSlideshowEntrypointController) {
            this.f3145a = simplePickerSlideshowEntrypointController;
        }

        public void onAnimationStart(Animator animator) {
            this.f3145a.f3149d.setPadding(this.f3145a.f3149d.getPaddingLeft(), this.f3145a.f3149d.getPaddingTop(), this.f3145a.f3149d.getPaddingRight(), this.f3145a.f3149d.getPaddingBottom() - this.f3145a.f3148c.getMeasuredHeight());
        }

        public void onAnimationEnd(Animator animator) {
            this.f3145a.f3148c.setVisibility(8);
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    public SimplePickerSlideshowEntrypointController(SimplePickerConfiguration simplePickerConfiguration, View view, View view2, boolean z, CollageSlideshowSwitchListener collageSlideshowSwitchListener) {
        boolean z2;
        this.f3146a = simplePickerConfiguration;
        this.f3147b = view;
        this.f3149d = view2;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f3154i = z2;
        this.f3150e = collageSlideshowSwitchListener;
        this.f3155j = false;
    }

    public final void m3152a(ImmutableList<MediaItem> immutableList) {
        if ((this.f3148c == null && this.f3146a.v) || (this.f3148c != null && this.f3148c.m3281a())) {
            m3147b(immutableList);
        } else if (immutableList.size() < this.f3146a.t) {
            m3149e();
        } else {
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                if (((MediaItem) immutableList.get(i)).b().mType != Type.Photo) {
                    m3149e();
                    return;
                }
            }
            m3147b(immutableList);
        }
    }

    public final void m3151a() {
        if (this.f3151f != null && this.f3151f.isRunning()) {
            this.f3151f.end();
        }
        if (this.f3148c == null) {
            m3148d();
        } else if (this.f3148c.getVisibility() == 0) {
            return;
        }
        if (this.f3152g == null) {
            this.f3152g = m3150f();
        }
        this.f3151f = this.f3152g;
        this.f3151f.start();
    }

    public final void m3153c() {
        if (!this.f3155j) {
            m3149e();
        }
    }

    private void m3148d() {
        this.f3148c = (SlideshowEntrypointView) ((ViewStub) this.f3147b.findViewById(2131567465)).inflate();
        if (ViewCompat.E(this.f3147b)) {
            this.f3148c.measure(MeasureSpec.makeMeasureSpec(this.f3147b.getWidth(), Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(this.f3147b.getHeight(), Integer.MIN_VALUE));
        } else {
            this.f3148c.measure(0, 0);
        }
        this.f3148c.m3280a(this.f3154i, this.f3146a.v, this.f3150e);
    }

    private void m3147b(ImmutableList<MediaItem> immutableList) {
        if (this.f3151f != null && this.f3151f.isRunning()) {
            this.f3151f.end();
        }
        this.f3155j = true;
        if (this.f3148c == null) {
            m3148d();
        } else if (this.f3148c.getVisibility() == 0) {
            return;
        }
        if (immutableList.size() >= 3) {
            this.f3148c.m3279a(((MediaItem) immutableList.get(0)).f(), ((MediaItem) immutableList.get(1)).f(), ((MediaItem) immutableList.get(2)).f());
        }
        if (this.f3152g == null) {
            this.f3152g = m3150f();
        }
        this.f3151f = this.f3152g;
        this.f3151f.start();
    }

    private void m3149e() {
        if (this.f3151f != null && this.f3151f.isRunning()) {
            this.f3151f.end();
        }
        this.f3155j = false;
        if (this.f3148c != null && this.f3148c.getVisibility() != 8) {
            if (this.f3153h == null) {
                int measuredHeight = this.f3148c.getMeasuredHeight();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f3148c, "translationY", new float[]{0.0f, (float) (-measuredHeight)});
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f3149d, "translationY", new float[]{(float) measuredHeight, 0.0f});
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
                animatorSet.setInterpolator(new AccelerateInterpolator());
                animatorSet.setDuration(400);
                animatorSet.addListener(new C04052(this));
                this.f3153h = animatorSet;
            }
            this.f3151f = this.f3153h;
            this.f3151f.start();
        }
    }

    private AnimatorSet m3150f() {
        this.f3148c.setTranslationY((float) (-this.f3148c.getMeasuredHeight()));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f3148c, "translationY", new float[]{(float) (-r0), 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f3149d, "translationY", new float[]{0.0f, (float) r0});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.setDuration(400);
        animatorSet.addListener(new C04041(this));
        return animatorSet;
    }
}
