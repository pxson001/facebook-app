package com.facebook.photos.photogallery.photoviewcontrollers;

import android.os.Handler;
import android.widget.AdapterView;
import com.facebook.photos.galleryutil.PhotoViewController;
import com.facebook.photos.galleryutil.PhotoViewController.PhotoViewControllerListener;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

/* compiled from: invitable_contacts */
public class AdapterViewPhotoViewController implements PhotoViewController {
    public AdapterView f10867a;
    protected PhotoViewControllerListener f10868b;

    /* compiled from: invitable_contacts */
    class C09351 implements Runnable {
        final /* synthetic */ AdapterViewPhotoViewController f10866a;

        C09351(AdapterViewPhotoViewController adapterViewPhotoViewController) {
            this.f10866a = adapterViewPhotoViewController;
        }

        public void run() {
        }
    }

    public final void m12901a(int i) {
        int min = Math.min(i, this.f10867a.getCount() - 1);
        if (min < this.f10867a.getFirstVisiblePosition() || min > this.f10867a.getLastVisiblePosition()) {
            this.f10867a.setSelection(min);
            if (this.f10868b != null) {
                HandlerDetour.b(new Handler(), new C09351(this), 0, -1673378361);
            }
        }
    }
}
