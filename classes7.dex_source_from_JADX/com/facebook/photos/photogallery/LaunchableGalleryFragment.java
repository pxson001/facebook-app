package com.facebook.photos.photogallery;

import android.os.Bundle;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.MediaLogger;
import com.facebook.photos.base.analytics.constants.ConsumptionLoggingConstants.ContentViewingSurface;
import com.facebook.photos.base.analytics.constants.ConsumptionLoggingConstants.UserAction;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.base.photos.Photo;
import com.facebook.photos.galleryutil.GlobalOnLayoutHelper;
import com.facebook.photos.grid.UrlImageGridAdapterImmutablePhotoSource;
import com.facebook.photos.photogallery.PhotoGallery.C09281;
import com.facebook.photos.photogallery.PhotoGallery.C09292;
import com.facebook.photos.photogallery.PhotoGallery.C09303;
import com.facebook.photos.photogallery.PhotoGallery.PhotoGalleryListenerAdapter;
import com.facebook.ui.drawers.DrawerController;
import com.facebook.ui.drawers.DrawerInterceptor;
import javax.annotation.Nullable;

/* compiled from: is_currently_active */
public abstract class LaunchableGalleryFragment<T1 extends Photo, T2 extends PhotoView> extends FbFragment {
    protected PhotoGallery f10827a;
    public String al;
    public long am = -1;
    private DrawerInterceptor an = new C09261(this);
    public int f10828b;
    public UrlImageGridAdapterImmutablePhotoSource f10829c;
    public PhotoViewFactory f10830d;
    public FullscreenGallerySource f10831e;
    public boolean f10832f;
    public boolean f10833g;
    private DrawerController f10834h = null;
    public MediaLogger f10835i;

    /* compiled from: is_currently_active */
    class C09261 implements DrawerInterceptor {
        final /* synthetic */ LaunchableGalleryFragment f10825a;

        C09261(LaunchableGalleryFragment launchableGalleryFragment) {
            this.f10825a = launchableGalleryFragment;
        }

        public final boolean mo607a() {
            return false;
        }

        public final boolean mo608a(boolean z) {
            return false;
        }
    }

    /* compiled from: is_currently_active */
    class C09272 implements PhotoGalleryListenerAdapter {
        final /* synthetic */ LaunchableGalleryFragment f10826a;

        C09272(LaunchableGalleryFragment launchableGalleryFragment) {
            this.f10826a = launchableGalleryFragment;
        }

        public final void mo609a() {
            this.f10826a.f10833g = true;
        }

        public final void mo610a(int i, PhotoView photoView) {
            this.f10826a.aq();
            if (photoView != null && photoView.f10858b != null) {
                long j = photoView.f10858b.a;
                if (j != this.f10826a.am) {
                    this.f10826a.ar();
                    MediaLogger mediaLogger = this.f10826a.f10835i;
                    String valueOf = String.valueOf(j);
                    UserAction userAction = this.f10826a.f10833g ? UserAction.SWIPE : UserAction.CLICK;
                    String str = this.f10826a.al;
                    ContentViewingSurface contentViewingSurface = ContentViewingSurface.FULL_SCREEN_GALLERY;
                    FullscreenGallerySource fullscreenGallerySource = this.f10826a.f10833g ? FullscreenGallerySource.FULLSCREEN_GALLERY : this.f10826a.f10831e != null ? this.f10826a.f10831e : FullscreenGallerySource.UNKNOWN;
                    mediaLogger.a(valueOf, null, userAction, str, contentViewingSurface, fullscreenGallerySource);
                    this.f10826a.am = j;
                }
            }
        }
    }

    public final void m12857c(@Nullable Bundle bundle) {
        super.c(bundle);
        this.f10834h = DrawerController.a(FbInjector.get(getContext()));
    }

    public final void m12852G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1836272917);
        super.G();
        if (this.f10834h != null && this.f10834h.b()) {
            if (!this.f10834h.g()) {
                this.f10834h.a(true);
            }
            this.f10834h.a(this.an);
        }
        ar();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -317367712, a);
    }

    private void ar() {
        if (this.f10835i == null) {
            this.f10835i = MediaLogger.a(FbInjector.get(getContext()));
        }
        this.al = this.f10835i.d;
        if (this.al == null) {
            this.al = SafeUUIDGenerator.a().toString();
        }
    }

    public final void m12853H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2103987330);
        if (this.f10834h != null && this.f10834h.b()) {
            this.f10834h.b(this.an);
        }
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -885760443, a);
    }

    public void m12854I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -938458658);
        if (this.f10827a != null) {
            this.f10827a.m12874b();
        }
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1680612461, a);
    }

    public final int m12856b() {
        return this.f10827a.getCurrentIndex();
    }

    protected final void m12855a(PhotoGallery photoGallery) {
        this.f10827a = photoGallery;
        PhotoGallery photoGallery2 = this.f10827a;
        int i = this.f10828b;
        UrlImageGridAdapterImmutablePhotoSource urlImageGridAdapterImmutablePhotoSource = this.f10829c;
        PhotoViewFactory photoViewFactory = this.f10830d;
        photoGallery2.f10842b = i;
        photoGallery2.f10843c = urlImageGridAdapterImmutablePhotoSource;
        photoGallery2.f10844d = photoViewFactory;
        photoGallery2.f10845e = new PhotoGalleryAdapter(photoGallery2.f10843c, photoGallery2.f10844d);
        photoGallery2.f10845e.f10854e = new C09281(photoGallery2);
        photoGallery2.f10841a.setPageMargin(20);
        photoGallery2.f10841a.setAdapter(photoGallery2.f10845e);
        photoGallery2.f10841a.setCurrentItem(photoGallery2.f10842b);
        photoGallery2.f10841a.setOnPageChangeListener(new C09292(photoGallery2));
        GlobalOnLayoutHelper.a(photoGallery2.f10841a, new C09303(photoGallery2));
        this.f10827a.f10846f = new C09272(this);
    }

    protected void aq() {
    }
}
