package com.facebook.photos.photogallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView.ScaleType;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.photos.LocalPhoto;
import com.facebook.photos.base.photos.Photo;
import com.facebook.photos.base.photos.Photo.PhotoSize;
import com.facebook.photos.base.util.CachedDrawableProvider;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.images.fetch.FetchImageParams;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.images.UrlImage;
import com.facebook.widget.images.UrlImage.CurrentMode;
import com.facebook.widget.images.UrlImage.OnImageDownloadListener;
import com.facebook.widget.images.UrlImage.OnModeChangedListener;
import com.facebook.widget.images.zoomableimageview.ZoomableImageView;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.LinkedList;
import javax.annotation.Nullable;

/* compiled from: isLargeFormat */
public class PhotoView<T extends Photo> extends CustomFrameLayout {
    private final Object[] f10857a = new Object[0];
    public Photo f10858b;
    public UrlImage f10859c;
    public CachedDrawableProvider f10860d;
    public boolean f10861e;
    public LinkedList<Runnable> f10862f;
    public SettableFuture<Bitmap> f10863g;

    /* compiled from: isLargeFormat */
    public class C09331 extends OnImageDownloadListener {
        final /* synthetic */ PhotoView f10855a;

        public C09331(PhotoView photoView) {
            this.f10855a = photoView;
        }

        public final void m12885a() {
            PhotoView.m12889i(this.f10855a);
            this.f10855a.f10859c.G = null;
        }
    }

    /* compiled from: isLargeFormat */
    public class C09342 implements OnModeChangedListener {
        final /* synthetic */ PhotoView f10856a;

        public C09342(PhotoView photoView) {
            this.f10856a = photoView;
        }

        public final void m12886a(CurrentMode currentMode) {
            if (currentMode == CurrentMode.LOADED_IMAGE && (this.f10856a.f10858b instanceof LocalPhoto)) {
                this.f10856a.getZoomableImageView().setRotation(((LocalPhoto) this.f10856a.f10858b).e);
            }
        }

        public final void m12887b(CurrentMode currentMode) {
            if (currentMode == CurrentMode.LOADED_IMAGE) {
                this.f10856a.getZoomableImageView().f();
            }
        }
    }

    public static void m12888a(Object obj, Context context) {
        ((PhotoView) obj).f10860d = CachedDrawableProvider.b(FbInjector.get(context));
    }

    public PhotoView(Context context) {
        super(context);
        Class cls = PhotoView.class;
        m12888a((Object) this, getContext());
        setContentView(2130906218);
        this.f10862f = Lists.b();
        this.f10859c = (UrlImage) c(2131561583);
        this.f10863g = SettableFuture.f();
    }

    public final boolean m12893b() {
        return this.f10859c.aj;
    }

    public void mo612a(@Nullable T t) {
        FetchImageParams a;
        this.f10858b = t;
        this.f10861e = false;
        FetchImageParams fetchImageParams = null;
        getZoomableImageView().setRotation(0);
        if (this.f10858b != null) {
            a = this.f10858b.a(PhotoSize.THUMBNAIL);
            fetchImageParams = this.f10858b.a(PhotoSize.SCREENNAIL);
        } else {
            a = null;
        }
        if (this.f10858b == null || !this.f10860d.a(this.f10858b, PhotoSize.THUMBNAIL)) {
            this.f10859c.setPlaceHolderScaleType(ScaleType.CENTER);
            this.f10859c.setPlaceHolderResourceId(2130842624);
        } else {
            this.f10859c.setPlaceHolderScaleType(ScaleType.MATRIX);
            this.f10859c.setPlaceholderImageParams(a);
        }
        this.f10859c.G = new C09331(this);
        this.f10859c.H = new C09342(this);
        setFetchParams(fetchImageParams);
    }

    public void setFetchParams(@Nullable FetchImageParams fetchImageParams) {
        this.f10859c.setImageParams(fetchImageParams);
    }

    public Bitmap getCachedBitmap() {
        return this.f10859c.getBitmap();
    }

    public ZoomableImageView getZoomableImageView() {
        return (ZoomableImageView) this.f10859c.z;
    }

    @Nullable
    public ListenableFuture<Bitmap> getBitmap() {
        Bitmap cachedBitmap = getCachedBitmap();
        if (cachedBitmap != null) {
            return Futures.a(cachedBitmap);
        }
        return this.f10863g;
    }

    public static void m12889i(PhotoView photoView) {
        photoView.f10861e = true;
        photoView.mo613j();
        if (photoView.f10863g != null) {
            FutureDetour.a(photoView.f10863g, photoView.getCachedBitmap(), -215180075);
        }
    }

    public final void m12892a(Runnable runnable, boolean z) {
        synchronized (this.f10857a) {
            if (z) {
                this.f10862f.addFirst(runnable);
            } else {
                this.f10862f.addLast(runnable);
            }
        }
        mo613j();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void mo613j() {
        /*
        r3 = this;
        r1 = r3.f10857a;
        monitor-enter(r1);
        r0 = r3.f10861e;	 Catch:{ all -> 0x0034 }
        if (r0 == 0) goto L_0x000f;
    L_0x0007:
        r0 = r3.f10862f;	 Catch:{ all -> 0x0034 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0034 }
        if (r0 == 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r1);	 Catch:{ all -> 0x0034 }
    L_0x0010:
        return;
    L_0x0011:
        r0 = com.google.common.collect.Lists.b();	 Catch:{ all -> 0x0034 }
        r2 = r3.f10862f;	 Catch:{ all -> 0x0034 }
        r0.addAll(r2);	 Catch:{ all -> 0x0034 }
        r2 = r3.f10862f;	 Catch:{ all -> 0x0034 }
        r2.clear();	 Catch:{ all -> 0x0034 }
        monitor-exit(r1);	 Catch:{ all -> 0x0034 }
        r1 = r0.iterator();
    L_0x0024:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0010;
    L_0x002a:
        r0 = r1.next();
        r0 = (java.lang.Runnable) r0;
        r0.run();
        goto L_0x0024;
    L_0x0034:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.photogallery.PhotoView.j():void");
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1215330662);
        super.onDetachedFromWindow();
        if (this.f10863g != null) {
            this.f10863g.cancel(true);
            this.f10863g = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1429180555, a);
    }
}
