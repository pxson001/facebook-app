package com.facebook.photos.dialog;

import android.view.Menu;
import com.facebook.analytics.NavigationLogger;
import com.facebook.photos.dialog.util.PhotosBackPressController.PhotosBackPressListener;
import com.facebook.ui.dialogs.FbDialogFragment.FbDialog;
import com.google.common.base.Preconditions;
import java.util.Iterator;

/* compiled from: live_event_comment_dialog */
class PhotoAnimationDialogFragment$HelperDialog extends FbDialog {
    final /* synthetic */ PhotoAnimationDialogFragment f10101b;

    public PhotoAnimationDialogFragment$HelperDialog(PhotoAnimationDialogFragment photoAnimationDialogFragment) {
        this.f10101b = photoAnimationDialogFragment;
        super(photoAnimationDialogFragment, photoAnimationDialogFragment.getContext(), 16973840);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.f10101b.aV != PhotoAnimationDialogFragment$State.NORMAL) {
            return false;
        }
        PhotoAnimationContentFragment photoAnimationContentFragment = (PhotoAnimationContentFragment) this.f10101b.s().a(2131563682);
        Preconditions.checkNotNull(photoAnimationContentFragment);
        photoAnimationContentFragment.a(menu, this.f10101b.an().getMenuInflater());
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.f10101b.aV != PhotoAnimationDialogFragment$State.NORMAL) {
            return false;
        }
        PhotoAnimationContentFragment photoAnimationContentFragment = (PhotoAnimationContentFragment) this.f10101b.s().a(2131563682);
        Preconditions.checkNotNull(photoAnimationContentFragment);
        photoAnimationContentFragment.a(menu);
        return true;
    }

    public void onBackPressed() {
        Iterator it = this.f10101b.ay.f10137a.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = ((PhotosBackPressListener) it.next()).m12011a() | i;
        }
        if (i == 0) {
            ((NavigationLogger) this.f10101b.au.get()).a("tap_back_button");
            PhotoAnimationDialogFragment.aC(this.f10101b);
        }
    }
}
