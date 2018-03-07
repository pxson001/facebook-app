package com.facebook.photos.mediagallery.util;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView.ScaleType;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.io.FbCloseables;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.MediaGalleryUpgradeButtonDrawable;
import com.facebook.dialtone.common.DialtoneStateChangedListener;
import com.facebook.inject.Assisted;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.dialog.util.PhotosDialogPerfUtil;
import com.facebook.photos.mediagallery.util.GalleryDrawableFetcher.FullImageStatus;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.images.RemoteDrawableLoader;
import com.facebook.widget.images.zoomableimageview.SimpleZoomableImageViewListener;
import com.facebook.widget.images.zoomableimageview.ZoomableImageView;
import com.facebook.widget.images.zoomableimageview.ZoomableImageViewListener;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Optional;
import java.io.Closeable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: is_first_load */
public class ZoomableImageWrapper {
    public static final CallerContext f10810d = CallerContext.a(ZoomableImageWrapper.class);
    @VisibleForTesting
    final Drawable f10811a;
    @VisibleForTesting
    public final Drawable f10812b;
    @VisibleForTesting
    final FetcherListener f10813c = new FetcherListener(this);
    public final ZoomableImageView f10814e;
    public final DefaultAndroidThreadUtil f10815f;
    private final GalleryDrawableFetcher f10816g;
    public final PhotosDialogPerfUtil f10817h;
    public final DialtoneController f10818i;
    private LayoutObserver f10819j;
    public boolean f10820k;
    public ZoomableImageViewListener f10821l;
    public ZoomableImageViewListener f10822m;
    public DialtoneStateChangedListener f10823n;
    public MediaMetadata f10824o;

    /* compiled from: is_first_load */
    public class C09231 implements DialtoneStateChangedListener {
        final /* synthetic */ ZoomableImageWrapper f10803a;

        public C09231(ZoomableImageWrapper zoomableImageWrapper) {
            this.f10803a = zoomableImageWrapper;
        }

        public final void iw_() {
        }

        public final void b_(boolean z) {
            if (z) {
                ZoomableImageWrapper.m12836f(this.f10803a);
                return;
            }
            ZoomableImageWrapper zoomableImageWrapper = this.f10803a;
            zoomableImageWrapper.f10814e.setBackgroundDrawable(null);
            zoomableImageWrapper.f10814e.b(zoomableImageWrapper.f10821l);
            zoomableImageWrapper.f10814e.a(zoomableImageWrapper.f10822m);
            ZoomableImageWrapper.m12834b(this.f10803a, this.f10803a.f10824o);
        }
    }

    /* compiled from: is_first_load */
    class C09242 extends SimpleZoomableImageViewListener {
        final /* synthetic */ ZoomableImageWrapper f10804a;

        C09242(ZoomableImageWrapper zoomableImageWrapper) {
            this.f10804a = zoomableImageWrapper;
        }

        public final void m12829a() {
            if (ZoomableImageWrapper.m12837g(this.f10804a)) {
                this.f10804a.f10818i.a(this.f10804a.f10823n, Uri.parse(this.f10804a.f10824o.g().b()), true);
            }
        }
    }

    /* compiled from: is_first_load */
    class C09253 extends SimpleZoomableImageViewListener {
        final /* synthetic */ ZoomableImageWrapper f10805a;

        C09253(ZoomableImageWrapper zoomableImageWrapper) {
            this.f10805a = zoomableImageWrapper;
        }

        public final void m12830c() {
            this.f10805a.f10820k = true;
        }

        public final void m12831e() {
            this.f10805a.f10820k = true;
        }
    }

    /* compiled from: is_first_load */
    public class FetcherListener {
        public final /* synthetic */ ZoomableImageWrapper f10806a;

        FetcherListener(ZoomableImageWrapper zoomableImageWrapper) {
            this.f10806a = zoomableImageWrapper;
        }

        public final void m12832a(@Nullable Drawable drawable, String str) {
            Drawable drawable2;
            this.f10806a.f10815f.a();
            ZoomableImageWrapper zoomableImageWrapper = this.f10806a;
            if (drawable == null) {
                drawable2 = this.f10806a.f10811a;
            } else {
                drawable2 = drawable;
            }
            ZoomableImageWrapper.m12833a(zoomableImageWrapper, drawable2);
            if (drawable != null) {
                this.f10806a.f10817h.m12032a(str, true);
            }
        }
    }

    /* compiled from: is_first_load */
    class LayoutObserver implements OnGlobalLayoutListener {
        final /* synthetic */ ZoomableImageWrapper f10807a;
        private int f10808b = 0;
        private int f10809c = 0;

        public LayoutObserver(ZoomableImageWrapper zoomableImageWrapper) {
            this.f10807a = zoomableImageWrapper;
        }

        public void onGlobalLayout() {
            if (this.f10807a.f10814e.getWidth() != this.f10808b || this.f10807a.f10814e.getHeight() != this.f10809c) {
                this.f10808b = this.f10807a.f10814e.getWidth();
                this.f10809c = this.f10807a.f10814e.getHeight();
                if (this.f10807a.f10814e.getScaleType() == ScaleType.MATRIX) {
                    this.f10807a.f10820k = false;
                    ZoomableImageWrapper.m12835e(this.f10807a);
                }
            }
        }
    }

    @Inject
    public ZoomableImageWrapper(@Assisted ZoomableImageView zoomableImageView, @Assisted Optional<WarmupImageHelper> optional, Resources resources, AndroidThreadUtil androidThreadUtil, GalleryDrawableFetcherProvider galleryDrawableFetcherProvider, PhotosDialogPerfUtil photosDialogPerfUtil, DialtoneController dialtoneController) {
        this.f10814e = zoomableImageView;
        this.f10815f = androidThreadUtil;
        this.f10814e.setFitToScreen(false);
        this.f10814e.R = false;
        this.f10816g = new GalleryDrawableFetcher(this.f10813c, optional, RemoteDrawableLoader.a(galleryDrawableFetcherProvider), DefaultAndroidThreadUtil.b(galleryDrawableFetcherProvider), TasksManager.b(galleryDrawableFetcherProvider));
        this.f10817h = photosDialogPerfUtil;
        this.f10818i = dialtoneController;
        this.f10811a = resources.getDrawable(2130842624);
        this.f10812b = resources.getDrawable(2130842624);
        this.f10820k = false;
        this.f10822m = m12838j();
        this.f10814e.a(this.f10822m);
    }

    public final void m12839a(String str) {
        Object obj;
        if (this.f10816g.f10784h == FullImageStatus.SUCCEEDED) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            PhotosDialogPerfUtil photosDialogPerfUtil = this.f10817h;
            int a = PhotosDialogPerfUtil.m12024a((Object) str);
            photosDialogPerfUtil.f10154a.e(1310731, a);
            photosDialogPerfUtil.f10154a.b(1310731, a, (short) 2);
        }
    }

    public final void m12840b() {
        this.f10814e.c(this.f10814e.getMinZoom());
    }

    public static void m12833a(ZoomableImageWrapper zoomableImageWrapper, Drawable drawable) {
        zoomableImageWrapper.f10815f.a();
        Drawable drawable2 = zoomableImageWrapper.f10814e.getDrawable();
        if (drawable != drawable2) {
            zoomableImageWrapper.f10814e.b(drawable, !zoomableImageWrapper.f10820k, null, -1.0f);
            if (drawable == zoomableImageWrapper.f10811a || drawable == zoomableImageWrapper.f10812b) {
                zoomableImageWrapper.f10814e.setScaleType(ScaleType.CENTER);
            } else {
                zoomableImageWrapper.f10814e.setScaleType(ScaleType.MATRIX);
                m12835e(zoomableImageWrapper);
            }
            if (drawable2 instanceof Closeable) {
                FbCloseables.a((Closeable) drawable2);
            }
        }
    }

    public static void m12835e(ZoomableImageWrapper zoomableImageWrapper) {
        Drawable drawable = zoomableImageWrapper.f10814e.getDrawable();
        float width = (float) zoomableImageWrapper.f10814e.getWidth();
        float height = (float) zoomableImageWrapper.f10814e.getHeight();
        if (width != 0.0f && height != 0.0f && drawable != null) {
            float max = Math.max(1.0f, Math.min(width / ((float) drawable.getIntrinsicWidth()), height / ((float) drawable.getIntrinsicHeight())));
            zoomableImageWrapper.f10814e.setMinZoom(max);
            zoomableImageWrapper.f10814e.v = Math.max(2.0f * max, zoomableImageWrapper.f10814e.getMaxZoom());
            ZoomableImageView zoomableImageView = zoomableImageWrapper.f10814e;
            if (zoomableImageWrapper.f10820k) {
                max = Math.max(max, zoomableImageWrapper.f10814e.getScale());
            }
            zoomableImageView.c(max);
        }
    }

    public static void m12834b(ZoomableImageWrapper zoomableImageWrapper, MediaMetadata mediaMetadata) {
        zoomableImageWrapper.f10815f.a();
        zoomableImageWrapper.f10816g.m12805a(mediaMetadata);
        if (mediaMetadata == null) {
            zoomableImageWrapper.f10820k = false;
            m12833a(zoomableImageWrapper, null);
            if (zoomableImageWrapper.f10819j != null) {
                CustomViewUtils.a(zoomableImageWrapper.f10814e, zoomableImageWrapper.f10819j);
                zoomableImageWrapper.f10819j = null;
            }
        } else if (zoomableImageWrapper.f10819j == null) {
            zoomableImageWrapper.f10819j = new LayoutObserver(zoomableImageWrapper);
            zoomableImageWrapper.f10814e.getViewTreeObserver().addOnGlobalLayoutListener(zoomableImageWrapper.f10819j);
        }
    }

    public static void m12836f(ZoomableImageWrapper zoomableImageWrapper) {
        zoomableImageWrapper.f10814e.setBackgroundDrawable(new MediaGalleryUpgradeButtonDrawable(zoomableImageWrapper.f10818i));
        if (zoomableImageWrapper.f10821l == null) {
            zoomableImageWrapper.f10821l = new C09242(zoomableImageWrapper);
            zoomableImageWrapper.f10814e.b(zoomableImageWrapper.f10822m);
            zoomableImageWrapper.f10814e.a(zoomableImageWrapper.f10821l);
        }
    }

    public static boolean m12837g(ZoomableImageWrapper zoomableImageWrapper) {
        if (zoomableImageWrapper.f10818i.j()) {
            Uri parse = Uri.parse(zoomableImageWrapper.f10824o.g().b());
            Object obj = (parse == null || !zoomableImageWrapper.f10818i.a(parse, f10810d)) ? null : 1;
            if (obj == null) {
                return true;
            }
        }
        return false;
    }

    private SimpleZoomableImageViewListener m12838j() {
        return new C09253(this);
    }
}
