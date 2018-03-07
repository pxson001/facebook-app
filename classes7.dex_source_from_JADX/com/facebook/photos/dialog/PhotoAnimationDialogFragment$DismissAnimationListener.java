package com.facebook.photos.dialog;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.photos.dialog.clipping.ClipAnimationListener;

/* compiled from: live_event_comment_dialog */
class PhotoAnimationDialogFragment$DismissAnimationListener extends ClipAnimationListener {
    final /* synthetic */ PhotoAnimationDialogFragment f10099a;

    public PhotoAnimationDialogFragment$DismissAnimationListener(PhotoAnimationDialogFragment photoAnimationDialogFragment) {
        this.f10099a = photoAnimationDialogFragment;
    }

    public void onAnimationEnd(Animator animator) {
        if (this.f10099a.aV != PhotoAnimationDialogFragment$State.ANIMATE_OUT) {
            ((AbstractFbErrorReporter) this.f10099a.aw.get()).a(PhotoAnimationDialogFragment.az, StringFormatUtil.formatStrLocaleSafe("illegal animationEnd state: %s, safe dismiss: %s", this.f10099a.aV.name(), Boolean.valueOf(this.f10099a.E.p().c())));
        }
        if (this.f10099a.aK != null) {
            this.f10099a.aK.mo1490a(this.f10099a.av, false, PhotoAnimationDialogFragment.aD(this.f10099a));
        }
        this.f10099a.b();
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (valueAnimator.getAnimatedFraction() >= 0.97f) {
            this.f10099a.aK.mo1490a(this.f10099a.av, false, PhotoAnimationDialogFragment.aD(this.f10099a));
        }
    }
}
