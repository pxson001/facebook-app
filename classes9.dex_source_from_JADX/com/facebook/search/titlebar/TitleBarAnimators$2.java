package com.facebook.search.titlebar;

import android.animation.Animator;
import android.view.View;
import com.facebook.ui.animations.AnimationUtil;
import com.facebook.ui.animations.BaseAnimatorListener;

/* compiled from: video_frame_height */
class TitleBarAnimators$2 extends BaseAnimatorListener {
    final /* synthetic */ View f416a;
    final /* synthetic */ TitleBarAnimators f417b;

    TitleBarAnimators$2(TitleBarAnimators titleBarAnimators, View view) {
        this.f417b = titleBarAnimators;
        this.f416a = view;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        AnimationUtil animationUtil = this.f417b.e;
        if (AnimationUtil.a()) {
            this.f417b.e.b(this.f416a);
        }
    }
}
