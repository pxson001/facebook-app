package com.facebook.photos.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.common.base.Preconditions;

/* compiled from: live_event_comment_dialog */
class PhotoAnimationDialogFragment$1 extends AnimatorListenerAdapter {
    final /* synthetic */ PhotoAnimationDialogFragment f10094a;

    PhotoAnimationDialogFragment$1(PhotoAnimationDialogFragment photoAnimationDialogFragment) {
        this.f10094a = photoAnimationDialogFragment;
    }

    public void onAnimationStart(Animator animator) {
        this.f10094a.at.m12034c();
    }

    public void onAnimationEnd(Animator animator) {
        Preconditions.checkState(this.f10094a.aV == PhotoAnimationDialogFragment$State.ANIMATE_IN, "mDefaultShowAnimator onAnimationEnd invalid state: " + this.f10094a.aV);
        PhotoAnimationDialogFragment.aA(this.f10094a);
        this.f10094a.aX = null;
    }
}
