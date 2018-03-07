package com.facebook.photos.photogallery.photoviewcontrollers;

import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.view.Window;
import com.facebook.photos.galleryutil.PhotoViewController;
import com.facebook.photos.galleryutil.PhotoViewController.PhotoViewControllerListener;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.widget.CustomViewPager;

/* compiled from: invalid_json */
public class PagerAdapterViewPhotoViewController implements PhotoViewController {
    protected Window f10869a;
    public CustomViewPager f10870b;
    protected PhotoViewControllerListener f10871c;

    /* compiled from: invalid_json */
    class C09361 implements Runnable {
        final /* synthetic */ PagerAdapterViewPhotoViewController f10880a;

        C09361(PagerAdapterViewPhotoViewController pagerAdapterViewPhotoViewController) {
            this.f10880a = pagerAdapterViewPhotoViewController;
        }

        public void run() {
        }
    }

    public PagerAdapterViewPhotoViewController(Window window, CustomViewPager customViewPager) {
        this.f10869a = window;
        this.f10870b = customViewPager;
    }

    public final void m12902a(int i) {
        int i2;
        CustomViewPager customViewPager = this.f10870b;
        PagerAdapter adapter = this.f10870b.getAdapter();
        if (adapter == null) {
            i2 = 0;
        } else {
            i2 = adapter.b();
        }
        customViewPager.a(Math.min(i, i2 - 1), false);
        if (this.f10871c != null) {
            HandlerDetour.b(new Handler(), new C09361(this), 0, -865503422);
        }
    }
}
