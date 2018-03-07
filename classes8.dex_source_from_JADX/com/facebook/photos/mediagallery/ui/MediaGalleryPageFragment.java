package com.facebook.photos.mediagallery.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.base.fragment.FbFragment;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.dialog.util.PhotosBackPressController;
import com.facebook.photos.dialog.util.PhotosBackPressController.PhotosBackPressListener;
import com.facebook.photos.mediagallery.ui.MediaGalleryDataSource.Subscriber;
import com.facebook.photos.mediagallery.ui.tagging.LegacyMediaTaggingControllerProvider;
import com.facebook.photos.mediagallery.ui.tagging.MediaTaggingController;
import com.facebook.photos.mediagallery.ui.widget.MediaGalleryChromeController;
import com.facebook.photos.mediagallery.util.WarmupImageHelper;
import com.facebook.photos.mediagallery.util.ZoomableImageWrapper;
import com.facebook.photos.mediagallery.util.ZoomableImageWrapper.1;
import com.facebook.photos.mediagallery.util.ZoomableImageWrapperProvider;
import com.facebook.widget.images.zoomableimageview.ZoomableImageView;
import com.facebook.widget.images.zoomableimageview.ZoomableImageViewListener;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: snap_high_velocity */
public class MediaGalleryPageFragment extends FbFragment implements FragmentWithMediaId, Subscriber {
    @Inject
    ZoomableImageWrapperProvider f2400a;
    private PhotosBackPressListener al;
    public int am;
    public String an;
    public String ao;
    @Inject
    LegacyMediaTaggingControllerProvider f2401b;
    @Inject
    MediaGalleryChromeController f2402c;
    @Inject
    MediaGalleryDataSource f2403d;
    @Inject
    PhotosBackPressController f2404e;
    public ZoomableImageWrapper f2405f;
    public Optional<WarmupImageHelper> f2406g = Absent.INSTANCE;
    public String f2407h;
    private MediaTaggingController f2408i;

    /* compiled from: snap_high_velocity */
    class C02881 implements PhotosBackPressListener {
        final /* synthetic */ MediaGalleryPageFragment f2399a;

        C02881(MediaGalleryPageFragment mediaGalleryPageFragment) {
            this.f2399a = mediaGalleryPageFragment;
        }

        public final boolean m2529a() {
            if (!this.f2399a.f2405f.e.h()) {
                return false;
            }
            this.f2399a.f2405f.e.g();
            return true;
        }
    }

    public static void m2531a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((MediaGalleryPageFragment) obj).m2530a((ZoomableImageWrapperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ZoomableImageWrapperProvider.class), (LegacyMediaTaggingControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LegacyMediaTaggingControllerProvider.class), MediaGalleryChromeController.m2720a(injectorLike), MediaGalleryDataSource.m2473a(injectorLike), PhotosBackPressController.a(injectorLike));
    }

    private void m2530a(ZoomableImageWrapperProvider zoomableImageWrapperProvider, LegacyMediaTaggingControllerProvider legacyMediaTaggingControllerProvider, MediaGalleryChromeController mediaGalleryChromeController, MediaGalleryDataSource mediaGalleryDataSource, PhotosBackPressController photosBackPressController) {
        this.f2400a = zoomableImageWrapperProvider;
        this.f2401b = legacyMediaTaggingControllerProvider;
        this.f2402c = mediaGalleryChromeController;
        this.f2403d = mediaGalleryDataSource;
        this.f2404e = photosBackPressController;
    }

    public final void m2536c(Bundle bundle) {
        super.c(bundle);
        Class cls = MediaGalleryPageFragment.class;
        m2531a((Object) this, getContext());
        if (bundle != null) {
            this.f2407h = bundle.getString("EXTRA_MEDIA_ID");
        }
    }

    public final void m2537e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("EXTRA_MEDIA_ID", this.f2407h);
    }

    public final View m2532a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1622035972);
        View inflate = layoutInflater.inflate(2130905172, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1197828614, a);
        return inflate;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f2408i != null) {
            this.f2408i.m2589h();
        }
    }

    public final void m2534a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f2405f = this.f2400a.a((ZoomableImageView) view.findViewById(2131563683), this.f2406g);
        this.f2408i = this.f2401b.m2622a((FrameLayout) view, (ZoomableImageView) view.findViewById(2131563683), this.am, this.an, this.ao);
        ZoomableImageWrapper zoomableImageWrapper = this.f2405f;
        ZoomableImageViewListener zoomableImageViewListener = (ZoomableImageViewListener) Preconditions.checkNotNull(this.f2402c.f2637a);
        if (zoomableImageWrapper.e != null) {
            zoomableImageWrapper.e.a((ZoomableImageViewListener) Preconditions.checkNotNull(zoomableImageViewListener));
        }
        this.f2403d.m2476a(this.f2407h, this);
        this.al = new C02881(this);
        this.f2404e.a(this.al);
    }

    public final void m2538g(boolean z) {
        try {
            super.g(z);
            if (this.f2405f != null) {
                if (z) {
                    this.f2405f.a(this.f2407h);
                } else {
                    this.f2405f.b();
                }
            }
        } catch (Throwable e) {
            BLog.c("MediaGalleryPageFragment", "setUserVisibleHint failed FragmentManager is null", e);
        }
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -317032725);
        this.f2403d.m2475a(this.f2407h);
        this.f2408i.m2588g();
        ZoomableImageWrapper zoomableImageWrapper = this.f2405f;
        ZoomableImageViewListener zoomableImageViewListener = this.f2402c.f2637a;
        if (!(zoomableImageWrapper.e == null || zoomableImageViewListener == null)) {
            zoomableImageWrapper.e.b(zoomableImageViewListener);
        }
        zoomableImageWrapper = this.f2405f;
        if (zoomableImageWrapper.n != null) {
            zoomableImageWrapper.i.b(zoomableImageWrapper.n);
        }
        this.f2404e.b(this.al);
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 763999542, a);
    }

    public final void mo118a(MediaMetadata mediaMetadata) {
        ZoomableImageWrapper zoomableImageWrapper = this.f2405f;
        zoomableImageWrapper.o = mediaMetadata;
        if (ZoomableImageWrapper.g(zoomableImageWrapper)) {
            ZoomableImageWrapper.f(zoomableImageWrapper);
            if (zoomableImageWrapper.n == null) {
                zoomableImageWrapper.n = new 1(zoomableImageWrapper);
                zoomableImageWrapper.i.a(zoomableImageWrapper.n);
            }
        } else {
            ZoomableImageWrapper.b(zoomableImageWrapper, zoomableImageWrapper.o);
        }
        this.f2408i.m2584a(mediaMetadata);
        this.f2407h = mediaMetadata.d();
    }

    public final String mo117a() {
        return this.f2407h;
    }
}
