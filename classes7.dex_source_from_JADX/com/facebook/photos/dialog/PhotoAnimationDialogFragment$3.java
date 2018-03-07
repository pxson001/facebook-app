package com.facebook.photos.dialog;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;

/* compiled from: live_event_comment_dialog */
public class PhotoAnimationDialogFragment$3 {
    public final /* synthetic */ PhotoAnimationDialogFragment f10096a;

    public PhotoAnimationDialogFragment$3(PhotoAnimationDialogFragment photoAnimationDialogFragment) {
        this.f10096a = photoAnimationDialogFragment;
    }

    public final void m11986a(boolean z) {
        if (this.f10096a.aV == PhotoAnimationDialogFragment$State.INIT) {
            PhotoAnimationDialogFragment.i(this.f10096a, z);
        } else {
            ((AbstractFbErrorReporter) this.f10096a.aw.get()).b(PhotoAnimationDialogFragment.az, "PhotoAnimationDialogFragment received call to onAnimationReady in invalid state " + this.f10096a.aV.toString());
        }
    }
}
