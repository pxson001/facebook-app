package com.facebook.photos.dialog;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.facebook.photos.dialog.clipping.ClipAnimationListener;
import com.google.common.base.Preconditions;

/* compiled from: live_event_comment_dialog */
class PhotoAnimationDialogFragment$ShowAnimationListener extends ClipAnimationListener {
    final /* synthetic */ PhotoAnimationDialogFragment f10102a;

    public PhotoAnimationDialogFragment$ShowAnimationListener(PhotoAnimationDialogFragment photoAnimationDialogFragment) {
        this.f10102a = photoAnimationDialogFragment;
    }

    public void onAnimationStart(Animator animator) {
        this.f10102a.at.m12034c();
    }

    public void onAnimationEnd(Animator animator) {
        boolean z;
        if (this.f10102a.aV == PhotoAnimationDialogFragment$State.ANIMATE_IN) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        this.f10102a.aE.setLayerType(0, null);
        PhotoAnimationDialogFragment.aA(this.f10102a);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (valueAnimator.getAnimatedFraction() <= 0.03f) {
            this.f10102a.aK.mo1490a(this.f10102a.av, true, PhotoAnimationDialogFragment.aD(this.f10102a));
        }
    }
}
