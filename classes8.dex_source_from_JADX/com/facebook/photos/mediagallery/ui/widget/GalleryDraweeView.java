package com.facebook.photos.mediagallery.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.controller.ForwardingControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.samples.zoomable.AnimatedZoomableController;
import com.facebook.samples.zoomable.ZoomableDraweeView;
import com.facebook.widget.images.zoomableimageview.ZoomableImageViewListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: site_uri */
public class GalleryDraweeView extends ZoomableDraweeView {
    @Inject
    public FbDraweeControllerBuilder f2594a;
    public final List<ZoomableImageViewListener> f2595b = new CopyOnWriteArrayList();
    private final ForwardingControllerListener f2596c = new ForwardingControllerListener();

    /* compiled from: site_uri */
    class TapListener extends SimpleOnGestureListener {
        final /* synthetic */ GalleryDraweeView f2593a;

        public TapListener(GalleryDraweeView galleryDraweeView) {
            this.f2593a = galleryDraweeView;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            this.f2593a.getZoomableController().a(new PointF(motionEvent.getX(), motionEvent.getY()));
            for (ZoomableImageViewListener a : this.f2593a.f2595b) {
                a.a();
            }
            return false;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
            PointF a = this.f2593a.getZoomableController().a(pointF);
            for (ZoomableImageViewListener a2 : this.f2593a.f2595b) {
                a2.a(pointF, a);
            }
            return false;
        }

        public void onLongPress(MotionEvent motionEvent) {
            PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
            PointF a = this.f2593a.getZoomableController().a(pointF);
            for (ZoomableImageViewListener b : this.f2593a.f2595b) {
                b.b(pointF, a);
            }
        }

        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            AnimatedZoomableController zoomableController = this.f2593a.getZoomableController();
            if (motionEvent.getAction() == 1) {
                float f;
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                PointF a = zoomableController.a(pointF);
                if (zoomableController.m() > (zoomableController.i + zoomableController.j) / 2.0f) {
                    f = zoomableController.i;
                } else {
                    f = zoomableController.j;
                }
                zoomableController.a(f, a, pointF, 7, 400, null);
            }
            return false;
        }
    }

    private static <T extends View> void m2697a(Class<T> cls, T t) {
        m2698a((Object) t, t.getContext());
    }

    private static void m2698a(Object obj, Context context) {
        ((GalleryDraweeView) obj).f2594a = FbDraweeControllerBuilder.b(FbInjector.get(context));
    }

    private void m2696a(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f2594a = fbDraweeControllerBuilder;
    }

    public GalleryDraweeView(Context context) {
        super(context);
        m2699c();
    }

    public GalleryDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2699c();
    }

    public GalleryDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2699c();
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private void m2699c() {
        m2697a(GalleryDraweeView.class, (View) this);
        super.setTapListener(new TapListener(this));
    }

    public AnimatedZoomableController getZoomableController() {
        return (AnimatedZoomableController) super.getZoomableController();
    }

    public final void m2700a(Matrix matrix) {
        super.a(matrix);
        for (ZoomableImageViewListener a : this.f2595b) {
            a.a(matrix);
        }
    }

    public final void m2703a(ZoomableImageViewListener zoomableImageViewListener) {
        this.f2595b.add(zoomableImageViewListener);
    }

    public final void m2705b(ZoomableImageViewListener zoomableImageViewListener) {
        this.f2595b.remove(zoomableImageViewListener);
    }

    public final void m2702a(ControllerListener controllerListener) {
        this.f2596c.a(controllerListener);
    }

    public final void m2704b(ControllerListener controllerListener) {
        this.f2596c.b(controllerListener);
    }

    @Nullable
    private static ImageRequest m2694a(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        ImageRequestBuilder a = ImageRequestBuilder.a(uri);
        a.b = RequestLevel.DISK_CACHE;
        return a.m();
    }

    public final void m2701a(@Nullable Uri uri, Uri uri2, CallerContext callerContext) {
        setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f2594a.d(m2694a(uri))).b(uri2).b(getController())).a(callerContext).a(this.f2596c)).s());
    }
}
