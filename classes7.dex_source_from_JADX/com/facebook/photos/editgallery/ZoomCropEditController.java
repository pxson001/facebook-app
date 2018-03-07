package com.facebook.photos.editgallery;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.net.Uri;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.bitmaps.Dimension;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.editgallery.EditFeature;
import com.facebook.ipc.editgallery.EditGalleryZoomCropParams;
import com.facebook.ipc.editgallery.EditGalleryZoomCropParams.Builder;
import com.facebook.photos.creativeediting.RotatingFrameLayout;
import com.facebook.photos.creativeediting.interfaces.UriAwarePhotoOverlayItem;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.creativeediting.renderers.CreativeEditingPhotoOverlayView;
import com.facebook.photos.creativeediting.renderers.PhotoOverlayController;
import com.facebook.photos.creativeediting.renderers.PhotoOverlayController.OverlayType;
import com.facebook.photos.creativeediting.utilities.MediaRotationHelper;
import com.facebook.photos.creativeediting.utilities.RotateRectfHelper;
import com.facebook.photos.crop.ProfilePicZoomableImageView;
import com.facebook.photos.crop.ProfilePicZoomableImageView.Orientation;
import com.facebook.photos.crop.ZoomableImageViewGestureListener;
import com.facebook.photos.crop.ZoomableImageViewGestureListener.OnTouchCallback;
import com.facebook.photos.editgallery.EditFeatureController.UriRequestType;
import com.facebook.photos.editgallery.EditGalleryFragmentController.C08695;
import com.facebook.photos.editgallery.EditGalleryFragmentController.FileEditingListener;
import com.facebook.photos.editgallery.EditGalleryFragmentController.State;
import com.facebook.photos.editgallery.EditGalleryFragmentManager.UsageParams;
import com.facebook.photos.editgallery.utils.CropImageUtils;
import com.facebook.photos.editgallery.utils.CropImageUtils.CropCallback;
import com.facebook.photos.editgallery.utils.CropImageUtilsProvider;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: last_view_time */
public class ZoomCropEditController implements EditFeatureController {
    private static final RectF f10466a = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    private final OnTouchCallback f10467b = new C08831(this);
    private final Uri f10468c;
    private final Dimension f10469d;
    public final RotatingFrameLayout f10470e;
    private final Context f10471f;
    private final CropImageOverlayWithFrame f10472g;
    private final ProfilePicZoomableImageView f10473h;
    private final CreativeEditingPhotoOverlayView f10474i;
    private final Lazy<MediaRotationHelper> f10475j;
    private final PhotoOverlayController f10476k;
    private final CropImageUtils f10477l;
    private State f10478m;
    private CreativeEditingData f10479n;
    public C08695 f10480o;
    public boolean f10481p;

    /* compiled from: last_view_time */
    class C08831 implements OnTouchCallback {
        final /* synthetic */ ZoomCropEditController f10462a;

        C08831(ZoomCropEditController zoomCropEditController) {
            this.f10462a = zoomCropEditController;
        }

        public final void mo546a() {
            ZoomCropEditController.m12343p(this.f10462a);
        }
    }

    /* compiled from: last_view_time */
    class C08842 implements OnLayoutChangeListener {
        final /* synthetic */ ZoomCropEditController f10463a;

        C08842(ZoomCropEditController zoomCropEditController) {
            this.f10463a = zoomCropEditController;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.f10463a.f10481p) {
                ZoomCropEditController.m12343p(this.f10463a);
            }
        }
    }

    /* compiled from: last_view_time */
    class C08853 implements CropCallback {
        final /* synthetic */ ZoomCropEditController f10464a;

        C08853(ZoomCropEditController zoomCropEditController) {
            this.f10464a = zoomCropEditController;
        }

        public final void mo595a(CreativeEditingData creativeEditingData) {
            this.f10464a.f10470e.m11444b();
            this.f10464a.f10480o.m12163a(creativeEditingData);
        }

        public final void mo596a(Throwable th, CreativeEditingData creativeEditingData) {
            this.f10464a.f10470e.m11444b();
            this.f10464a.f10480o.m12163a(creativeEditingData);
        }
    }

    /* compiled from: last_view_time */
    class C08864 implements CropCallback {
        final /* synthetic */ ZoomCropEditController f10465a;

        C08864(ZoomCropEditController zoomCropEditController) {
            this.f10465a = zoomCropEditController;
        }

        public final void mo595a(CreativeEditingData creativeEditingData) {
            this.f10465a.f10470e.m11444b();
            this.f10465a.f10480o.m12163a(creativeEditingData);
        }

        public final void mo596a(Throwable th, CreativeEditingData creativeEditingData) {
            this.f10465a.f10470e.m11444b();
            this.f10465a.f10480o.m12163a(creativeEditingData);
        }
    }

    @Inject
    public ZoomCropEditController(@Assisted Uri uri, @Assisted RotatingFrameLayout rotatingFrameLayout, @Assisted FileEditingListener fileEditingListener, @Assisted String str, BitmapUtils bitmapUtils, Lazy<MediaRotationHelper> lazy, PhotoOverlayController photoOverlayController, CropImageUtilsProvider cropImageUtilsProvider, Context context) {
        this.f10468c = uri;
        this.f10470e = rotatingFrameLayout;
        this.f10480o = fileEditingListener;
        this.f10475j = lazy;
        this.f10476k = photoOverlayController;
        this.f10477l = cropImageUtilsProvider.m12373a(str);
        this.f10471f = context;
        this.f10469d = BitmapUtils.a(this.f10468c.getPath());
        this.f10473h = new ProfilePicZoomableImageView(context);
        this.f10473h.setId(2131558576);
        this.f10472g = new CropImageOverlayWithFrame(this.f10471f, true);
        this.f10472g.setId(2131558577);
        this.f10474i = new CreativeEditingPhotoOverlayView(context);
        this.f10474i.setId(2131558578);
    }

    public final Object mo572j() {
        return EditFeature.CROP;
    }

    @TargetApi(11)
    public final void mo561a(State state) {
        boolean z = true;
        Preconditions.checkNotNull(state.f10290k);
        this.f10478m = state;
        this.f10479n = state.f10290k;
        int a = ((MediaRotationHelper) this.f10475j.get()).a(this.f10468c);
        EditGalleryZoomCropParams editGalleryZoomCropParams = state.f10292m;
        Dimension dimension = editGalleryZoomCropParams.g;
        boolean z2 = !EditGalleryZoomCropParams.b.equals(dimension);
        if (a % 90 != 0) {
            z = false;
        }
        Preconditions.checkState(z, "rotation must be multiple of 90 degree");
        this.f10472g.f10066d = editGalleryZoomCropParams.e;
        this.f10472g.f10067e = editGalleryZoomCropParams.f;
        this.f10473h.setMinBoundingRectRatio(editGalleryZoomCropParams.e);
        this.f10473h.setCoverPhotoMultiplier(editGalleryZoomCropParams.f);
        this.f10473h.setAlpha(1.0f);
        this.f10473h.setVisibility(0);
        this.f10473h.setImageDrawable(Drawable.createFromPath(this.f10468c.getPath()));
        if (z2) {
            this.f10473h.setMaxScale(Math.min(((float) this.f10469d.b) / ((float) dimension.b), ((float) this.f10469d.a) / ((float) dimension.a)));
        }
        this.f10473h.setDrawableOrientation(Orientation.valueOf(a));
        this.f10473h.setOnTouchListener(new ZoomableImageViewGestureListener(this.f10473h, this.f10467b));
        this.f10473h.setInitialZoomCropBounds(editGalleryZoomCropParams.c);
        this.f10473h.addOnLayoutChangeListener(new C08842(this));
        this.f10470e.setVisibility(0);
        if (this.f10470e.findViewById(2131558576) == null) {
            this.f10470e.addView(this.f10473h);
        }
        if (this.f10470e.findViewById(2131558577) == null) {
            if (editGalleryZoomCropParams.d != null) {
                Callback callback = this.f10472g;
                ImmutableList<UriAwarePhotoOverlayItem> of = ImmutableList.of(editGalleryZoomCropParams.d);
                callback.f10219c.m11523j();
                for (UriAwarePhotoOverlayItem a2 : of) {
                    callback.f10219c.m11509a(a2, callback);
                }
            }
            this.f10472g.setVisibility(0);
            this.f10470e.addView(this.f10472g);
        }
        m12343p(this);
        this.f10474i.f9581a = this.f10476k;
    }

    public final void mo564b() {
        this.f10470e.removeAllViews();
        this.f10470e.setVisibility(8);
    }

    public final void mo565c() {
    }

    public final String mo559a() {
        return this.f10471f.getResources().getString(2131237792);
    }

    public final UriRequestType mo573k() {
        return UriRequestType.NONE;
    }

    public final void mo560a(Rect rect) {
    }

    public final boolean mo574l() {
        if (this.f10473h.f10076h.height() == 0.0f || this.f10473h.f10076h.width() == 0.0f) {
            return false;
        }
        RectF o = m12342o();
        if (this.f10479n.c() == null) {
            return m12341a(o, f10466a);
        }
        return m12341a(o, this.f10479n.c());
    }

    private static boolean m12341a(RectF rectF, RectF rectF2) {
        Preconditions.checkNotNull(rectF);
        Preconditions.checkNotNull(rectF2);
        return (rectF.right == rectF2.right && rectF.left == rectF2.left && rectF.top == rectF2.top && rectF.bottom == rectF2.bottom) ? false : true;
    }

    public final State mo575m() {
        State state = this.f10478m;
        Builder builder = new Builder(this.f10478m.f10292m);
        builder.a = m12342o();
        state.f10292m = builder.a();
        int a = ((MediaRotationHelper) this.f10475j.get()).a(this.f10468c);
        RectF o = m12342o();
        if (a == 0) {
            CreativeEditingData.Builder builder2 = new CreativeEditingData.Builder(this.f10479n);
            builder2.e = o;
            this.f10479n = builder2.a();
            this.f10478m.f10290k = this.f10479n;
            this.f10480o.m12162a();
            this.f10477l.m12372a(this.f10479n, this.f10468c, this.f10469d, o, new C08853(this));
            return this.f10478m;
        }
        int a2 = 4 - RotateRectfHelper.a(a);
        ((MediaRotationHelper) this.f10475j.get()).a(this.f10468c, a % 360);
        o = RotateRectfHelper.a(o, a2);
        builder2 = new CreativeEditingData.Builder(this.f10479n);
        builder2.e = o;
        this.f10479n = builder2.a();
        this.f10478m.f10290k = this.f10479n;
        this.f10480o.m12162a();
        this.f10477l.m12372a(this.f10479n, this.f10468c, this.f10469d, o, new C08864(this));
        return this.f10478m;
    }

    public final boolean mo566d() {
        return false;
    }

    public final boolean mo567e() {
        return false;
    }

    public final void mo568f() {
        m12343p(this);
    }

    public final void mo569g() {
    }

    public final void mo570h() {
    }

    public final void mo571i() {
    }

    public final void mo562a(UsageParams usageParams) {
    }

    public final void mo563a(boolean z) {
    }

    private RectF m12342o() {
        RectF rectF = this.f10472g.f10065c;
        RectF rectF2 = this.f10473h.f10076h;
        boolean z = (rectF2.width() == 0.0f || rectF2.height() == 0.0f) ? false : true;
        Preconditions.checkState(z);
        RectF rectF3 = new RectF((rectF.left - rectF2.left) / rectF2.width(), (rectF.top - rectF2.top) / rectF2.height(), (rectF.right - rectF2.left) / rectF2.width(), (rectF.bottom - rectF2.top) / rectF2.height());
        rectF3.intersect(0.0f, 0.0f, 1.0f, 1.0f);
        return rectF3;
    }

    public static void m12343p(ZoomCropEditController zoomCropEditController) {
        if (zoomCropEditController.f10479n == null || !zoomCropEditController.f10479n.k()) {
            zoomCropEditController.f10476k.m11533d();
            return;
        }
        RectF rectF = zoomCropEditController.f10473h.f10076h;
        if (rectF.width() == 0.0f || rectF.height() == 0.0f) {
            zoomCropEditController.f10481p = true;
            return;
        }
        zoomCropEditController.f10481p = false;
        LayoutParams layoutParams = new FrameLayout.LayoutParams((int) rectF.width(), (int) rectF.height());
        layoutParams.topMargin = (int) rectF.top;
        layoutParams.leftMargin = (int) rectF.left;
        zoomCropEditController.f10474i.setLayoutParams(layoutParams);
        if (zoomCropEditController.f10470e.findViewById(2131558578) == null) {
            zoomCropEditController.f10470e.addView(zoomCropEditController.f10474i);
            zoomCropEditController.f10472g.bringToFront();
        }
        zoomCropEditController.f10476k.mo500b();
        zoomCropEditController.f10476k.m11529a(zoomCropEditController.f10479n, (int) rectF.width(), (int) rectF.height(), zoomCropEditController.f10470e.f9505g ? zoomCropEditController.f10470e.getFinalRotation() : ((MediaRotationHelper) zoomCropEditController.f10475j.get()).a(zoomCropEditController.f10468c), zoomCropEditController.f10474i, false, OverlayType.STICKERS, OverlayType.TEXTS, OverlayType.DOODLE);
    }
}
