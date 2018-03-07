package com.facebook.timeline.profilevideo.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

/* compiled from: mFeedUnitSubtitleStyled */
public class SimpleNewsFeedAnimator {
    public final View f9499a;
    public final View f9500b;
    public final View f9501c;
    public final ImageView f9502d;
    public final SimpleNewsFeedAdapter f9503e;
    public Animator f9504f;
    public final Rect f9505g = new Rect();
    public final Rect f9506h = new Rect();
    public final Rect f9507i = new Rect();
    public final Point f9508j = new Point();
    public float f9509k;
    public final AnimatorListener f9510l = new C09931(this);
    public final AnimatorListener f9511m = new C09942(this);
    public boolean f9512n = false;
    public final Runnable f9513o = new C09953(this);

    /* compiled from: mFeedUnitSubtitleStyled */
    class C09931 extends AnimatorListenerAdapter {
        final /* synthetic */ SimpleNewsFeedAnimator f9496a;

        C09931(SimpleNewsFeedAnimator simpleNewsFeedAnimator) {
            this.f9496a = simpleNewsFeedAnimator;
        }

        public void onAnimationEnd(Animator animator) {
            this.f9496a.f9504f = null;
            this.f9496a.f9502d.getGlobalVisibleRect(this.f9496a.f9506h);
            this.f9496a.f9506h.offset(-this.f9496a.f9508j.x, -this.f9496a.f9508j.y);
        }

        public void onAnimationCancel(Animator animator) {
            this.f9496a.f9504f = null;
            this.f9496a.f9502d.getGlobalVisibleRect(this.f9496a.f9506h);
            this.f9496a.f9506h.offset(-this.f9496a.f9508j.x, -this.f9496a.f9508j.y);
        }
    }

    /* compiled from: mFeedUnitSubtitleStyled */
    class C09942 extends AnimatorListenerAdapter {
        final /* synthetic */ SimpleNewsFeedAnimator f9497a;

        C09942(SimpleNewsFeedAnimator simpleNewsFeedAnimator) {
            this.f9497a = simpleNewsFeedAnimator;
        }

        public void onAnimationEnd(Animator animator) {
            this.f9497a.f9504f = null;
            this.f9497a.f9502d.setVisibility(4);
            this.f9497a.f9500b.setAlpha(1.0f);
        }

        public void onAnimationCancel(Animator animator) {
            this.f9497a.f9504f = null;
            this.f9497a.f9502d.setVisibility(4);
            this.f9497a.f9500b.setAlpha(1.0f);
        }
    }

    /* compiled from: mFeedUnitSubtitleStyled */
    class C09953 implements Runnable {
        final /* synthetic */ SimpleNewsFeedAnimator f9498a;

        C09953(SimpleNewsFeedAnimator simpleNewsFeedAnimator) {
            this.f9498a = simpleNewsFeedAnimator;
        }

        public void run() {
            SimpleNewsFeedAnimator simpleNewsFeedAnimator = this.f9498a;
            if (simpleNewsFeedAnimator.f9504f != null) {
                simpleNewsFeedAnimator.f9504f.cancel();
            }
            simpleNewsFeedAnimator.f9502d.setVisibility(0);
            simpleNewsFeedAnimator.f9500b.setAlpha(0.2f);
            View view = simpleNewsFeedAnimator.f9503e.f9494a;
            if (view != null) {
                view.setVisibility(4);
                view.getGlobalVisibleRect(simpleNewsFeedAnimator.f9505g);
                simpleNewsFeedAnimator.f9501c.getGlobalVisibleRect(simpleNewsFeedAnimator.f9506h);
                simpleNewsFeedAnimator.f9499a.getGlobalVisibleRect(simpleNewsFeedAnimator.f9507i, simpleNewsFeedAnimator.f9508j);
                simpleNewsFeedAnimator.f9505g.offset(-simpleNewsFeedAnimator.f9508j.x, -simpleNewsFeedAnimator.f9508j.y);
                simpleNewsFeedAnimator.f9506h.offset(-simpleNewsFeedAnimator.f9508j.x, -simpleNewsFeedAnimator.f9508j.y);
                simpleNewsFeedAnimator.f9509k = ((float) simpleNewsFeedAnimator.f9505g.height()) / ((float) simpleNewsFeedAnimator.f9506h.width());
                simpleNewsFeedAnimator.f9502d.setPivotX(0.0f);
                simpleNewsFeedAnimator.f9502d.setPivotY(0.0f);
                Animator animatorSet = new AnimatorSet();
                animatorSet.play(ObjectAnimator.ofFloat(simpleNewsFeedAnimator.f9502d, View.X, new float[]{(float) simpleNewsFeedAnimator.f9505g.left, (float) simpleNewsFeedAnimator.f9506h.left})).with(ObjectAnimator.ofFloat(simpleNewsFeedAnimator.f9502d, View.Y, new float[]{(float) simpleNewsFeedAnimator.f9505g.top, (float) simpleNewsFeedAnimator.f9506h.top})).with(ObjectAnimator.ofFloat(simpleNewsFeedAnimator.f9502d, View.SCALE_X, new float[]{simpleNewsFeedAnimator.f9509k, 1.0f})).with(ObjectAnimator.ofFloat(simpleNewsFeedAnimator.f9502d, View.SCALE_Y, new float[]{simpleNewsFeedAnimator.f9509k, 1.0f}));
                animatorSet.setDuration(300);
                animatorSet.setInterpolator(new DecelerateInterpolator());
                animatorSet.addListener(simpleNewsFeedAnimator.f9510l);
                animatorSet.start();
                simpleNewsFeedAnimator.f9504f = animatorSet;
                simpleNewsFeedAnimator.f9512n = false;
            }
        }
    }

    public SimpleNewsFeedAnimator(View view, SimpleNewsFeedAdapter simpleNewsFeedAdapter) {
        this.f9499a = view;
        this.f9500b = view.findViewById(2131566411);
        this.f9500b.setAlpha(1.0f);
        this.f9501c = view.findViewById(2131566414);
        this.f9502d = (ImageView) view.findViewById(2131566413);
        this.f9502d.setVisibility(4);
        this.f9503e = simpleNewsFeedAdapter;
    }
}
