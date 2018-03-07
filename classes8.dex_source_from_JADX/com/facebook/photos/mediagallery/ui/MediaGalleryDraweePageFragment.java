package com.facebook.photos.mediagallery.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.dialog.util.PhotosBackPressController;
import com.facebook.photos.dialog.util.PhotosBackPressController.PhotosBackPressListener;
import com.facebook.photos.dialog.util.PhotosDialogPerfUtil;
import com.facebook.photos.mediagallery.abtest.ExperimentsForMediaGalleryAbTestModule;
import com.facebook.photos.mediagallery.ui.MediaGalleryDataSource.Subscriber;
import com.facebook.photos.mediagallery.ui.tagging.DraweeMediaTaggingControllerProvider;
import com.facebook.photos.mediagallery.ui.tagging.MediaTaggingController;
import com.facebook.photos.mediagallery.ui.widget.GalleryDraweeView;
import com.facebook.photos.mediagallery.ui.widget.MediaGalleryChromeController;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.images.zoomableimageview.ZoomableImageViewListener;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: snap_low_velocity */
public class MediaGalleryDraweePageFragment extends FbFragment implements FragmentWithMediaId, Subscriber {
    private static final String f2367h = MediaGalleryDraweePageFragment.class.getSimpleName();
    private static final CallerContext f2368i = CallerContext.b(MediaGalleryDraweePageFragment.class, f2367h);
    @Inject
    DraweeMediaTaggingControllerProvider f2369a;
    public GalleryDraweeView al;
    public String am;
    @Nullable
    public String an;
    @Nullable
    public Uri ao;
    private MediaTaggingController ap;
    private PhotosBackPressListener aq;
    private DraweeControllerListener ar;
    private int as;
    private String at;
    private boolean au;
    private String av;
    @Inject
    MediaGalleryChromeController f2370b;
    @Inject
    MediaGalleryDataSource f2371c;
    @Inject
    PhotosBackPressController f2372d;
    @Inject
    public ImagePipeline f2373e;
    @Inject
    PhotosDialogPerfUtil f2374f;
    @Inject
    QeAccessor f2375g;

    /* compiled from: snap_low_velocity */
    class C02801 implements PhotosBackPressListener {
        final /* synthetic */ MediaGalleryDraweePageFragment f2365a;

        C02801(MediaGalleryDraweePageFragment mediaGalleryDraweePageFragment) {
            this.f2365a = mediaGalleryDraweePageFragment;
        }

        public final boolean m2477a() {
            if (this.f2365a.al.getZoomableController().b()) {
                return false;
            }
            this.f2365a.al.getZoomableController().a();
            return true;
        }
    }

    /* compiled from: snap_low_velocity */
    class DraweeControllerListener extends BaseControllerListener {
        final /* synthetic */ MediaGalleryDraweePageFragment f2366a;

        public DraweeControllerListener(MediaGalleryDraweePageFragment mediaGalleryDraweePageFragment) {
            this.f2366a = mediaGalleryDraweePageFragment;
        }

        public final void m2478a(String str, Object obj) {
            this.f2366a.f2374f.c(this.f2366a.am);
        }

        public final void m2479a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            this.f2366a.f2374f.a(this.f2366a.am, true);
        }

        public final void m2480b(String str, @Nullable Object obj) {
            this.f2366a.f2374f.a(this.f2366a.am, true);
        }

        public final void m2481b(String str, Throwable th) {
            this.f2366a.f2374f.a(this.f2366a.am, false);
        }
    }

    public static void m2484a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((MediaGalleryDraweePageFragment) obj).m2483a((DraweeMediaTaggingControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DraweeMediaTaggingControllerProvider.class), MediaGalleryChromeController.m2720a(injectorLike), MediaGalleryDataSource.m2473a(injectorLike), PhotosBackPressController.a(injectorLike), ImagePipelineMethodAutoProvider.a(injectorLike), PhotosDialogPerfUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    private void m2483a(DraweeMediaTaggingControllerProvider draweeMediaTaggingControllerProvider, MediaGalleryChromeController mediaGalleryChromeController, MediaGalleryDataSource mediaGalleryDataSource, PhotosBackPressController photosBackPressController, ImagePipeline imagePipeline, PhotosDialogPerfUtil photosDialogPerfUtil, QeAccessor qeAccessor) {
        this.f2369a = draweeMediaTaggingControllerProvider;
        this.f2370b = mediaGalleryChromeController;
        this.f2371c = mediaGalleryDataSource;
        this.f2372d = photosBackPressController;
        this.f2373e = imagePipeline;
        this.f2374f = photosDialogPerfUtil;
        this.f2375g = qeAccessor;
    }

    public static MediaGalleryDraweePageFragment m2482a(MediaMetadata mediaMetadata, @Nullable String str, @Nullable Uri uri, int i, @Nullable String str2, @Nullable String str3) {
        Preconditions.checkNotNull(mediaMetadata);
        MediaGalleryDraweePageFragment mediaGalleryDraweePageFragment = new MediaGalleryDraweePageFragment();
        mediaGalleryDraweePageFragment.am = mediaMetadata.d();
        mediaGalleryDraweePageFragment.an = str;
        mediaGalleryDraweePageFragment.ao = uri;
        mediaGalleryDraweePageFragment.as = i;
        mediaGalleryDraweePageFragment.at = str2;
        mediaGalleryDraweePageFragment.av = str3;
        return mediaGalleryDraweePageFragment;
    }

    public final void m2489c(Bundle bundle) {
        super.c(bundle);
        Class cls = MediaGalleryDraweePageFragment.class;
        m2484a((Object) this, getContext());
        if (bundle != null) {
            this.am = bundle.getString("EXTRA_MEDIA_ID");
        }
    }

    public final void m2490e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("EXTRA_MEDIA_ID", this.am);
    }

    public final View m2485a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -889538769);
        View inflate = layoutInflater.inflate(2130905168, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 466879917, a);
        return inflate;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.ap != null) {
            this.ap.m2589h();
        }
    }

    public final void m2487a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.al = (GalleryDraweeView) e(2131563683);
        GenericDraweeHierarchyBuilder e = new GenericDraweeHierarchyBuilder(jW_()).e(ScaleType.c);
        if (this.f2375g.a(ExperimentsForMediaGalleryAbTestModule.f, false)) {
            this.au = false;
        } else {
            e.f = jW_().getDrawable(2130842624);
            e.j = jW_().getDrawable(2130842624);
            this.au = true;
        }
        this.al.setHierarchy(e.u());
        this.al.m2703a((ZoomableImageViewListener) Preconditions.checkNotNull(this.f2370b.f2637a));
        this.ar = new DraweeControllerListener(this);
        this.al.m2702a(this.ar);
        this.ap = this.f2369a.m2594a((FrameLayout) view, this.al, this.as, this.at, this.av);
        this.f2371c.m2476a(this.am, this);
        this.aq = new C02801(this);
        this.f2372d.a(this.aq);
    }

    public final void m2491g(boolean z) {
        try {
            super.g(z);
            if (!z && this.al != null) {
                this.al.getZoomableController().a();
            }
        } catch (Throwable e) {
            BLog.c(f2367h, "setUserVisibleHint failed FragmentManager is null", e);
        }
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -278354217);
        this.f2371c.m2475a(this.am);
        this.ap.m2588g();
        this.al.m2705b(this.f2370b.f2637a);
        this.al.m2704b(this.ar);
        this.f2372d.b(this.aq);
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -532081290, a);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo118a(com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata r8) {
        /*
        r7 = this;
        r5 = r8.d();
        r6 = r7.an;
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x007c;
    L_0x000c:
        r5 = r7.ao;
    L_0x000e:
        r2 = r5;
        r0 = r8.g();
        if (r0 != 0) goto L_0x006e;
    L_0x0015:
        r1 = r2;
    L_0x0016:
        r0 = r7.au;
        if (r0 != 0) goto L_0x0057;
    L_0x001a:
        if (r2 != 0) goto L_0x0057;
    L_0x001c:
        r0 = r7.f2373e;
        r0 = r0.b(r1);
        if (r0 != 0) goto L_0x0057;
    L_0x0024:
        r0 = r7.al;
        r0 = r0.getHierarchy();
        r0 = (com.facebook.drawee.generic.GenericDraweeHierarchy) r0;
        r3 = r7.jW_();
        r4 = 2130842624; // 0x7f021400 float:1.7290349E38 double:1.052776137E-314;
        r3 = r3.getDrawable(r4);
        r4 = com.facebook.drawee.drawable.ScalingUtils.ScaleType.f;
        r0.a(r3, r4);
        r0 = r7.al;
        r0 = r0.getHierarchy();
        r0 = (com.facebook.drawee.generic.GenericDraweeHierarchy) r0;
        r3 = r7.jW_();
        r4 = 2130842624; // 0x7f021400 float:1.7290349E38 double:1.052776137E-314;
        r3 = r3.getDrawable(r4);
        r4 = com.facebook.drawee.drawable.ScalingUtils.ScaleType.f;
        r0.b(r3, r4);
        r0 = 1;
        r7.au = r0;
    L_0x0057:
        r0 = r7.al;
        r3 = f2368i;
        r0.m2701a(r2, r1, r3);
        r0 = r7.ap;
        if (r0 == 0) goto L_0x0067;
    L_0x0062:
        r0 = r7.ap;
        r0.m2584a(r8);
    L_0x0067:
        r0 = r8.d();
        r7.am = r0;
        return;
    L_0x006e:
        r0 = r8.g();
        r0 = r0.b();
        r0 = android.net.Uri.parse(r0);
        r1 = r0;
        goto L_0x0016;
    L_0x007c:
        r5 = r8.bc_();
        if (r5 == 0) goto L_0x0096;
    L_0x0082:
        r5 = r8.bc_();
        r5 = r5.b();
        r5 = android.net.Uri.parse(r5);
        r6 = r7.f2373e;
        r6 = r6.b(r5);
        if (r6 != 0) goto L_0x000e;
    L_0x0096:
        r5 = r8.bd_();
        if (r5 == 0) goto L_0x00b0;
    L_0x009c:
        r5 = r8.bd_();
        r5 = r5.b();
        r5 = android.net.Uri.parse(r5);
        r6 = r7.f2373e;
        r6 = r6.b(r5);
        if (r6 != 0) goto L_0x000e;
    L_0x00b0:
        r5 = 0;
        goto L_0x000e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.mediagallery.ui.MediaGalleryDraweePageFragment.a(com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces$MediaMetadata):void");
    }

    public final String mo117a() {
        return this.am;
    }
}
