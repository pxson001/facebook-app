package com.facebook.timeline.profilevideo.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: mHasReachedEndOfFeed */
public class ScrubberProgressIndicator extends FrameLayout {
    public AnimatorSet f9479a;
    public boolean f9480b;
    private boolean f9481c;
    public final Runnable f9482d;

    /* compiled from: mHasReachedEndOfFeed */
    class C09911 implements Runnable {
        final /* synthetic */ ScrubberProgressIndicator f9477a;

        C09911(ScrubberProgressIndicator scrubberProgressIndicator) {
            this.f9477a = scrubberProgressIndicator;
        }

        public void run() {
            if (this.f9477a.f9480b && !this.f9477a.f9479a.isStarted()) {
                this.f9477a.f9479a.start();
            }
        }
    }

    /* compiled from: mHasReachedEndOfFeed */
    class C09922 implements AnimatorListener {
        final /* synthetic */ ScrubberProgressIndicator f9478a;

        C09922(ScrubberProgressIndicator scrubberProgressIndicator) {
            this.f9478a = scrubberProgressIndicator;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f9478a.f9480b) {
                this.f9478a.post(this.f9478a.f9482d);
            }
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    public ScrubberProgressIndicator(Context context) {
        this(context, null);
    }

    public ScrubberProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrubberProgressIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9480b = false;
        this.f9481c = false;
        this.f9482d = new C09911(this);
        LayoutInflater.from(context).inflate(2130906962, this);
        m11201b();
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (!this.f9481c) {
            return;
        }
        if (i == 0) {
            m11198a();
        } else {
            this.f9480b = false;
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -966176003);
        super.onAttachedToWindow();
        this.f9481c = true;
        if (getVisibility() == 0) {
            m11198a();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1775406122, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 970600238);
        super.onDetachedFromWindow();
        this.f9481c = false;
        this.f9480b = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -999121999, a);
    }

    private void m11198a() {
        this.f9480b = true;
        if (!this.f9479a.isStarted()) {
            this.f9479a.start();
        }
    }

    private void m11201b() {
        View findViewById = findViewById(2131567240);
        View findViewById2 = findViewById(2131567241);
        View findViewById3 = findViewById(2131567242);
        Animator ofFloat = ObjectAnimator.ofFloat(findViewById, "scaleX", new float[]{1.0f, 1.33f});
        ofFloat.setDuration(250);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        Animator clone = ofFloat.clone();
        clone.setPropertyName("scaleY");
        Animator ofFloat2 = ObjectAnimator.ofFloat(findViewById, "scaleX", new float[]{1.33f, 1.0f});
        ofFloat2.setDuration(250);
        ofFloat2.setInterpolator(new DecelerateInterpolator());
        Animator clone2 = ofFloat2.clone();
        clone2.setPropertyName("scaleY");
        Animator clone3 = ofFloat.clone();
        Animator clone4 = clone.clone();
        Animator clone5 = ofFloat2.clone();
        Animator clone6 = clone2.clone();
        clone3.setTarget(findViewById2);
        clone4.setTarget(findViewById2);
        clone5.setTarget(findViewById2);
        clone6.setTarget(findViewById2);
        Animator clone7 = ofFloat.clone();
        Animator clone8 = clone.clone();
        Animator clone9 = ofFloat2.clone();
        Animator clone10 = clone2.clone();
        clone7.setTarget(findViewById3);
        clone8.setTarget(findViewById3);
        clone9.setTarget(findViewById3);
        clone10.setTarget(findViewById3);
        this.f9479a = new AnimatorSet();
        this.f9479a.play(ofFloat).with(clone);
        this.f9479a.play(clone3).with(clone4).with(ofFloat2).with(clone2).after(ofFloat);
        this.f9479a.play(clone7).with(clone8).with(clone5).with(clone6).after(clone3);
        this.f9479a.play(clone9).with(clone10).after(clone7);
        this.f9479a.addListener(new C09922(this));
    }
}
