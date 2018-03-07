package com.facebook.photos.dialog;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.facebook.widget.CustomViewUtils;

/* compiled from: live_event_comment_dialog */
class PhotoAnimationDialogFragment$4 implements OnGlobalLayoutListener {
    final /* synthetic */ PhotoAnimationDialogFragment f10097a;

    PhotoAnimationDialogFragment$4(PhotoAnimationDialogFragment photoAnimationDialogFragment) {
        this.f10097a = photoAnimationDialogFragment;
    }

    public void onGlobalLayout() {
        CustomViewUtils.a(this.f10097a.aF, this);
        PhotoAnimationDialogFragment.i(this.f10097a, false);
    }
}
