package com.facebook.photos.creativecam.ui;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.support.annotation.Nullable;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.inject.Assisted;
import com.facebook.photos.creativecam.activity.CreativeEditingCameraFragment.9;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: sprout_nux */
public class PhotoPreviewController {
    public static final CallerContext f2270a = CallerContext.a(CameraPreviewController.class);
    public final CameraImageScaleType f2271b;
    public final 9 f2272c;
    public final FbDraweeView f2273d;
    public final Context f2274e;
    public final FbDraweeControllerBuilder f2275f;
    public final ControllerListener f2276g = new C02731(this);

    /* compiled from: sprout_nux */
    class C02731 extends BaseControllerListener {
        final /* synthetic */ PhotoPreviewController f2265a;

        C02731(PhotoPreviewController photoPreviewController) {
            this.f2265a = photoPreviewController;
        }

        public final void m2409a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            CloseableImage closeableImage = (CloseableImage) obj;
            super.a(str, closeableImage, animatable);
            if (closeableImage != null) {
                if (((GenericDraweeHierarchy) this.f2265a.f2273d.getHierarchy()).d() != this.f2265a.f2271b) {
                    this.f2265a.f2273d.setAspectRatio(((float) closeableImage.f()) / ((float) closeableImage.g()));
                }
                ((GenericDraweeHierarchy) this.f2265a.f2273d.getHierarchy()).a(new RectF());
                9 9 = this.f2265a.f2272c;
                int measuredWidth = this.f2265a.f2273d.getMeasuredWidth();
                int measuredWidth2 = (int) (((float) this.f2265a.f2273d.getMeasuredWidth()) / this.f2265a.f2273d.b);
                int measuredHeight = (9.a.jW_().getDisplayMetrics().heightPixels - 9.a.aq.getMeasuredHeight()) - 9.a.aI.getMeasuredHeight();
                if (measuredWidth2 > measuredHeight) {
                    9.a.aD.m2391a(measuredWidth, measuredHeight, 9.a.ar.c);
                } else {
                    9.a.aD.m2391a(measuredWidth, measuredWidth2, 9.a.ar.c);
                }
            }
        }
    }

    /* compiled from: sprout_nux */
    public class CameraImageScaleType extends AbstractScaleType {
        public RectF f2266i;
        public RectF f2267j;
        public int f2268k;
        public boolean f2269l;

        public final void m2410a(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            if (i >= i2 || this.f2266i.width() >= this.f2266i.height()) {
                f3 = f4;
                int i3 = i;
                i = i2;
                i2 = i3;
            }
            matrix.reset();
            Object obj = this.f2266i.width() < this.f2266i.height() ? 1 : null;
            float width = (this.f2266i.width() / this.f2267j.width()) * f3;
            matrix.setScale(width, width);
            width = (((float) Math.min(i, i2)) * width) / (obj != null ? this.f2266i.width() : this.f2266i.height());
            float f5 = (this.f2266i.left - this.f2267j.left) * width;
            width *= this.f2266i.top - this.f2267j.top;
            if (obj != null) {
                matrix.postTranslate(f5, width);
            } else {
                matrix.postTranslate(width, f5);
            }
            if (this.f2269l) {
                matrix.postScale(-1.0f, 1.0f, (float) rect.centerX(), (float) rect.centerY());
            }
            if (this.f2268k == 0 && obj == null) {
                matrix.setRotate((float) this.f2268k, (float) rect.centerX(), (float) rect.centerY());
            }
        }
    }

    @Inject
    public PhotoPreviewController(@Assisted 9 9, @Assisted FbDraweeView fbDraweeView, Context context, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f2272c = (9) Preconditions.checkNotNull(9);
        this.f2273d = (FbDraweeView) Preconditions.checkNotNull(fbDraweeView);
        this.f2274e = context;
        this.f2275f = fbDraweeControllerBuilder;
        this.f2271b = new CameraImageScaleType();
    }
}
