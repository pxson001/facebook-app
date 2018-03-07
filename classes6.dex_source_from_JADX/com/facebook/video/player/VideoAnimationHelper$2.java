package com.facebook.video.player;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: composer_friend_tag_suggestions_shown */
public class VideoAnimationHelper$2 extends AnimatorListenerAdapter {
    final /* synthetic */ View f19211a;
    final /* synthetic */ VideoAnimationHelper f19212b;

    public VideoAnimationHelper$2(VideoAnimationHelper videoAnimationHelper, View view) {
        this.f19212b = videoAnimationHelper;
        this.f19211a = view;
    }

    public void onAnimationStart(Animator animator) {
        this.f19211a.setVisibility(0);
        this.f19211a.setAlpha(0.0f);
    }
}
