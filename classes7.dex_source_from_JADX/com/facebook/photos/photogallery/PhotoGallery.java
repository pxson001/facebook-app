package com.facebook.photos.photogallery;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.FbInjector;
import com.facebook.photos.galleryutil.GlobalOnLayoutHelper;
import com.facebook.photos.grid.UrlImageGridAdapterImmutablePhotoSource;
import com.facebook.photos.photogallery.PhotoGalleryAdapter.PhotoGalleryAdapterListener;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.DisableableView;
import com.google.common.base.Preconditions;

/* compiled from: is_crowdsourceable */
public class PhotoGallery extends CustomFrameLayout {
    public ViewPager f10841a;
    public int f10842b;
    public UrlImageGridAdapterImmutablePhotoSource f10843c;
    public PhotoViewFactory f10844d;
    public PhotoGalleryAdapter f10845e;
    public PhotoGalleryListenerAdapter f10846f;
    public PhotoView f10847g;
    public boolean f10848h;
    public boolean f10849i;

    /* compiled from: is_crowdsourceable */
    public interface PhotoGalleryListenerAdapter {
        void mo609a();

        void mo610a(int i, PhotoView photoView);
    }

    /* compiled from: is_crowdsourceable */
    public class C09281 implements PhotoGalleryAdapterListener {
        final /* synthetic */ PhotoGallery f10836a;

        public C09281(PhotoGallery photoGallery) {
            this.f10836a = photoGallery;
        }

        public final void mo611a() {
            if (this.f10836a.f10848h) {
                if (this.f10836a.f10846f != null) {
                    this.f10836a.getCurrentIndex();
                    this.f10836a.getCurrentPhotoView();
                }
                this.f10836a.f10848h = false;
            }
        }
    }

    /* compiled from: is_crowdsourceable */
    public class C09292 implements OnPageChangeListener {
        final /* synthetic */ PhotoGallery f10837a;

        public C09292(PhotoGallery photoGallery) {
            this.f10837a = photoGallery;
        }

        public final void m12860a(int i, float f, int i2) {
            if (!this.f10837a.f10849i) {
            }
        }

        public final void e_(int i) {
            if (!this.f10837a.f10849i) {
                if (this.f10837a.f10846f != null) {
                    this.f10837a.f10846f.mo610a(i, PhotoGallery.m12867b(this.f10837a, i));
                }
                this.f10837a.f10848h = true;
            }
        }

        public final void m12861b(int i) {
            if (!this.f10837a.f10849i && i == 0 && this.f10837a.f10847g != this.f10837a.getCurrentPhotoView()) {
                if (this.f10837a.f10847g.getZoomableImageView().getScale() != 1.0f) {
                    this.f10837a.f10847g.getZoomableImageView().c(1.0f);
                }
                this.f10837a.f10847g = this.f10837a.getCurrentPhotoView();
            }
        }
    }

    /* compiled from: is_crowdsourceable */
    public class C09303 implements Runnable {
        final /* synthetic */ PhotoGallery f10838a;

        public C09303(PhotoGallery photoGallery) {
            this.f10838a = photoGallery;
        }

        public void run() {
            if (this.f10838a.f10841a.getChildCount() == 0) {
                ((AbstractFbErrorReporter) FbErrorReporterImpl.a(FbInjector.get(this.f10838a.getContext()))).a("PhotoGallery", "ViewPager has no children after the layout after setting the adapter");
            }
            if (this.f10838a.f10846f != null) {
                this.f10838a.f10846f.mo610a(this.f10838a.getCurrentIndex(), this.f10838a.getCurrentPhotoView());
                this.f10838a.getCurrentIndex();
                this.f10838a.getCurrentPhotoView();
                this.f10838a.f10846f.mo609a();
            }
            this.f10838a.f10847g = this.f10838a.getCurrentPhotoView();
        }
    }

    /* compiled from: is_crowdsourceable */
    class C09314 implements Runnable {
        final /* synthetic */ PhotoGallery f10839a;

        C09314(PhotoGallery photoGallery) {
            this.f10839a = photoGallery;
        }

        public void run() {
            this.f10839a.m12872a();
        }
    }

    /* compiled from: is_crowdsourceable */
    class C09325 implements Runnable {
        final /* synthetic */ PhotoGallery f10840a;

        C09325(PhotoGallery photoGallery) {
            this.f10840a = photoGallery;
        }

        public void run() {
            this.f10840a.f10849i = false;
            if (this.f10840a.f10846f != null) {
                this.f10840a.f10846f.mo610a(this.f10840a.getCurrentIndex(), this.f10840a.getCurrentPhotoView());
                this.f10840a.getCurrentIndex();
                this.f10840a.getCurrentPhotoView();
            }
            this.f10840a.f10847g = this.f10840a.getCurrentPhotoView();
        }
    }

    public PhotoGallery(Context context) {
        this(context, null);
    }

    public PhotoGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130906193);
        this.f10841a = (ViewPager) c(2131565899);
        Preconditions.checkState(this.f10841a instanceof DisableableView);
    }

    public void onConfigurationChanged(Configuration configuration) {
        GlobalOnLayoutHelper.a(this.f10841a, new C09314(this));
    }

    public int getCurrentIndex() {
        return this.f10841a.k;
    }

    public final void m12872a() {
        m12865a(getCurrentIndex());
    }

    private void m12865a(int i) {
        this.f10849i = true;
        this.f10841a.setAdapter(this.f10845e);
        this.f10841a.setCurrentItem(i);
        GlobalOnLayoutHelper.a(this.f10841a, new C09325(this));
    }

    public PhotoView getCurrentPhotoView() {
        return m12867b(this, getCurrentIndex());
    }

    public final void m12873a(PhotoGalleryListenerAdapter photoGalleryListenerAdapter) {
        this.f10846f = photoGalleryListenerAdapter;
    }

    public final void m12874b() {
        this.f10846f = null;
    }

    public static PhotoView m12867b(PhotoGallery photoGallery, int i) {
        return (PhotoView) photoGallery.f10841a.findViewWithTag(Integer.valueOf(i));
    }
}
