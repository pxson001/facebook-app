package com.facebook.photos.dialog;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.ImageView.ScaleType;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.fbui.draggable.widget.DismissibleFrameLayout.AnimationListener;
import com.facebook.fbui.draggable.widget.DismissibleFrameLayout.FlingListener;
import com.facebook.fbui.draggable.widget.DismissibleFrameLayout.OnDismissListener;
import com.facebook.fbui.draggable.widget.DismissibleFrameLayout.OnResetListener;
import com.facebook.photos.dialog.clipping.ClippingImageView;
import com.facebook.photos.mediagallery.launcher.animation.DrawingRule;
import com.google.common.base.Preconditions;

/* compiled from: live_event_comment_dialog */
class PhotoAnimationDialogFragment$DismissableFrameListener implements AnimationListener, FlingListener, OnDismissListener, OnResetListener {
    final /* synthetic */ PhotoAnimationDialogFragment f10100a;

    public PhotoAnimationDialogFragment$DismissableFrameListener(PhotoAnimationDialogFragment photoAnimationDialogFragment) {
        this.f10100a = photoAnimationDialogFragment;
    }

    public final void mo551b() {
        Preconditions.checkState(this.f10100a.ap());
        boolean z = this.f10100a.aV == PhotoAnimationDialogFragment$State.NORMAL || PhotoAnimationDialogFragment$State.isSwiping(this.f10100a.aV);
        Preconditions.checkState(z, "onViewDismissStart invalid state: " + this.f10100a.aV);
        if (!PhotoAnimationDialogFragment$State.isSwiping(this.f10100a.aV)) {
            PhotoAnimationDialogFragment photoAnimationDialogFragment = this.f10100a;
            boolean z2 = true;
            Preconditions.checkState(photoAnimationDialogFragment.aV == PhotoAnimationDialogFragment$State.NORMAL);
            Drawable[] drawableArr = new Drawable[1];
            if (PhotoAnimationDialogFragment.a(photoAnimationDialogFragment, drawableArr, null)) {
                DrawingRule a = DrawingRule.m12758a(drawableArr[0], new Rect(0, 0, photoAnimationDialogFragment.aF.getMeasuredWidth(), photoAnimationDialogFragment.aF.getMeasuredHeight()), ScaleType.CENTER_INSIDE);
                ClippingImageView clippingImageView = photoAnimationDialogFragment.aF;
                clippingImageView.setDrawable(drawableArr[0]);
                clippingImageView.mo557a(a, a);
                clippingImageView.m12001a(a);
                ((NavigationLogger) photoAnimationDialogFragment.au.get()).a("swipe");
                photoAnimationDialogFragment.aD.removeView(photoAnimationDialogFragment.aF);
                photoAnimationDialogFragment.aG.addView(photoAnimationDialogFragment.aF, 0);
                photoAnimationDialogFragment.aF.setVisibility(0);
                photoAnimationDialogFragment.aR.d();
                photoAnimationDialogFragment.aV = PhotoAnimationDialogFragment$State.SWIPING_IMAGE;
            } else {
                if (photoAnimationDialogFragment.aH.getBackground() != null) {
                    z2 = false;
                }
                Preconditions.checkState(z2);
                photoAnimationDialogFragment.aH.setBackgroundDrawable(photoAnimationDialogFragment.aE.getBackground());
                photoAnimationDialogFragment.aE.setAlpha(0.0f);
                photoAnimationDialogFragment.aV = PhotoAnimationDialogFragment$State.SWIPING_FRAME;
            }
        }
    }

    public final void mo552c() {
        Preconditions.checkState(this.f10100a.ap());
        if (this.f10100a.aV != PhotoAnimationDialogFragment$State.ANIMATE_OUT) {
            Preconditions.checkState(PhotoAnimationDialogFragment$State.isSwiping(this.f10100a.aV), "onViewDismissed invalid state: " + this.f10100a.aV);
            PhotoAnimationDialogFragment.h(this.f10100a, false);
            this.f10100a.aK.mo1490a(this.f10100a.av, false, PhotoAnimationDialogFragment.aD(this.f10100a));
            this.f10100a.b();
        } else if (this.f10100a.aC != null) {
            ((AbstractFbErrorReporter) this.f10100a.aw.get()).b(PhotoAnimationDialogFragment.az, "onViewDismissed unexpected. Last call:", this.f10100a.aC);
        } else {
            ((AbstractFbErrorReporter) this.f10100a.aw.get()).b(PhotoAnimationDialogFragment.az, "onViewDismissed _really_ unexpected.");
        }
    }

    public final void mo550a(float f, float f2) {
        Preconditions.checkState(this.f10100a.ap());
        boolean z = PhotoAnimationDialogFragment$State.isSwiping(this.f10100a.aV) || this.f10100a.aV == PhotoAnimationDialogFragment$State.NORMAL || this.f10100a.aV == PhotoAnimationDialogFragment$State.ANIMATE_OUT;
        Preconditions.checkState(z, "onViewAnimating invalid state: " + this.f10100a.aV);
        if (this.f10100a.aV == PhotoAnimationDialogFragment$State.SWIPING_IMAGE) {
            this.f10100a.aE.setAlpha(Math.max(1.0f - (Math.abs(f2) * 2.0f), 0.0f));
        }
    }

    public final void mo553d() {
        Preconditions.checkState(this.f10100a.ap());
        Preconditions.checkState(PhotoAnimationDialogFragment$State.isSwiping(this.f10100a.aV), "onViewReset invalid state: " + this.f10100a.aV);
        this.f10100a.aK.mo1490a(this.f10100a.av, true, PhotoAnimationDialogFragment.aD(this.f10100a));
        this.f10100a.aE.setAlpha(1.0f);
        PhotoAnimationDialogFragment.h(this.f10100a, true);
    }

    public final void mo549a() {
        Preconditions.checkState(this.f10100a.ap());
        Preconditions.checkState(PhotoAnimationDialogFragment$State.isSwiping(this.f10100a.aV), "onFling invalid state: " + this.f10100a.aV);
        if (this.f10100a.aV != PhotoAnimationDialogFragment$State.SWIPING_FRAME && PhotoAnimationDialogFragment.a(this.f10100a, null, null)) {
            PhotoAnimationDialogFragment.h(this.f10100a, false);
            PhotoAnimationDialogFragment.b(this.f10100a, this.f10100a.aE.getAlpha());
            this.f10100a.aG.m4237g();
        }
    }
}
