package com.facebook.feed.rows.sections.hidden.ui;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: Unable to get FPS info */
public class FeedHiddenUnitAnimationHelper {
    public Animation f21473a;

    public final void m24140a(View view, AnimationListener animationListener) {
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200);
        alphaAnimation.setAnimationListener(animationListener);
        this.f21473a = alphaAnimation;
        view.startAnimation(this.f21473a);
    }

    public static Animation m24139a(AnimationListener animationListener) {
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200);
        alphaAnimation.setAnimationListener(animationListener);
        return alphaAnimation;
    }
}
