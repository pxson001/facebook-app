package com.facebook.feed.rows.styling.animators;

import android.animation.Animator;
import android.view.View;
import com.facebook.ui.animations.BaseAnimatorListener;

/* compiled from: showPopupMenu */
class FeedAnimators$2 extends BaseAnimatorListener {
    final /* synthetic */ View f3754a;
    final /* synthetic */ int f3755b;
    final /* synthetic */ int f3756c;
    final /* synthetic */ FeedAnimators f3757d;

    FeedAnimators$2(FeedAnimators feedAnimators, View view, int i, int i2) {
        this.f3757d = feedAnimators;
        this.f3754a = view;
        this.f3755b = i;
        this.f3756c = i2;
    }

    public void onAnimationEnd(Animator animator) {
        m4422a();
    }

    public void onAnimationCancel(Animator animator) {
        m4422a();
    }

    private void m4422a() {
        this.f3754a.getLayoutParams().height = Math.max(this.f3755b, this.f3756c);
    }
}
