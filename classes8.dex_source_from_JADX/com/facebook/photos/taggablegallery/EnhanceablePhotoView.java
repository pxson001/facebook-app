package com.facebook.photos.taggablegallery;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.inject.FbInjector;
import com.facebook.photos.base.photos.LocalPhoto;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.creativeediting.renderers.CreativeEditingPhotoOverlayView;
import com.facebook.photos.creativeediting.renderers.PhotoOverlayController;
import com.facebook.photos.creativeediting.renderers.PhotoOverlayController.OverlayType;
import com.facebook.photos.tagging.ui.TaggablePhotoView;
import com.facebook.ui.images.fetch.FetchImageParams;
import com.facebook.ui.images.fetch.FetchImageParams.Builder;
import com.facebook.widget.images.zoomableimageview.SimpleZoomableImageViewListener;
import com.facebook.widget.images.zoomableimageview.ZoomableImageView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: serif */
public class EnhanceablePhotoView extends TaggablePhotoView {
    @Inject
    public PhotoOverlayController f3381a;
    public FetchImageParams f3382b;
    public boolean f3383c;
    @Nullable
    public Postprocessor f3384d;
    public Uri f3385e = null;
    public CreativeEditingPhotoOverlayView f3386f;
    public CreativeEditingData f3387g;

    /* compiled from: serif */
    class C04291 extends SimpleZoomableImageViewListener {
        final /* synthetic */ EnhanceablePhotoView f3380a;

        C04291(EnhanceablePhotoView enhanceablePhotoView) {
            this.f3380a = enhanceablePhotoView;
        }

        public final void m3319a(Matrix matrix) {
            EnhanceablePhotoView.m3321v(this.f3380a);
        }
    }

    public static void m3320a(Object obj, Context context) {
        ((EnhanceablePhotoView) obj).f3381a = PhotoOverlayController.b(FbInjector.get(context));
    }

    public EnhanceablePhotoView(Context context) {
        super(context);
        Class cls = EnhanceablePhotoView.class;
        m3320a(this, getContext());
        this.f3386f = new CreativeEditingPhotoOverlayView(getContext());
        this.f3386f.setId(1001);
        this.j = true;
    }

    public void setFetchParams(FetchImageParams fetchImageParams) {
        if (this.f3385e != null) {
            Builder a = FetchImageParams.a(this.f3385e);
            a.c = fetchImageParams.b;
            a.d = fetchImageParams.d;
            a.e = fetchImageParams.f;
            a.f = fetchImageParams.g;
            a.g = fetchImageParams.h;
            a.h = fetchImageParams.i;
            a.i = fetchImageParams.j;
            fetchImageParams = a.a();
        }
        this.f3382b = fetchImageParams;
        if (this.f3384d != null) {
            this.c.a(this.f3382b, this.f3384d);
        } else {
            this.c.setImageParams(this.f3382b);
        }
    }

    public static void m3321v(EnhanceablePhotoView enhanceablePhotoView) {
        RectF rectF;
        ZoomableImageView zoomableImageView = enhanceablePhotoView.getZoomableImageView();
        if (zoomableImageView == null || zoomableImageView.getDrawable() == null || zoomableImageView.getImageMatrix() == null || zoomableImageView.getPhotoHeight() == 0 || zoomableImageView.getMeasuredWidth() == 0) {
            rectF = null;
        } else {
            rectF = new RectF();
            rectF.top = (float) zoomableImageView.getTop();
            rectF.left = (float) zoomableImageView.getLeft();
            rectF.bottom = (float) (zoomableImageView.getTop() + zoomableImageView.getPhotoHeight());
            rectF.right = (float) (zoomableImageView.getLeft() + zoomableImageView.getPhotoWidth());
            zoomableImageView.getPhotoDisplayMatrix().mapRect(rectF);
        }
        RectF rectF2 = rectF;
        if (enhanceablePhotoView.f3387g != null && rectF2 != null) {
            LayoutParams layoutParams = new FrameLayout.LayoutParams((int) rectF2.width(), (int) rectF2.height());
            layoutParams.topMargin = (int) rectF2.top;
            layoutParams.leftMargin = (int) rectF2.left;
            enhanceablePhotoView.f3386f.setLayoutParams(layoutParams);
            if (enhanceablePhotoView.findViewById(1001) == null) {
                enhanceablePhotoView.addView(enhanceablePhotoView.f3386f);
            }
            enhanceablePhotoView.f3381a.b();
            enhanceablePhotoView.f3381a.a(enhanceablePhotoView.f3387g, (int) rectF2.width(), (int) rectF2.height(), ((LocalPhoto) enhanceablePhotoView.b).e, enhanceablePhotoView.f3386f, true, new OverlayType[]{OverlayType.STICKERS, OverlayType.TEXTS, OverlayType.DOODLE, OverlayType.FRAME});
            enhanceablePhotoView.f3386f.a = enhanceablePhotoView.f3381a;
        }
    }

    protected final void m3322q() {
        m3321v(this);
        getZoomableImageView().a(new C04291(this));
    }
}
