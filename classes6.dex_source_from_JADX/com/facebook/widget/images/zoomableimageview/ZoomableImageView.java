package com.facebook.widget.images.zoomableimageview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.animation.DecelerateInterpolator;
import com.facebook.fbui.draggable.Direction;
import com.facebook.fbui.draggable.HorizontalScrollAwareView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.images.zoomableimageview.ZoomableView.ZoomableImageViewZoomAndPanListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;

/* compiled from: removedAdminFbIds */
public class ZoomableImageView extends ImageViewTouch implements HorizontalScrollAwareView, ZoomableView {
    private boolean f5953K = true;
    public boolean f5954L = true;
    public CopyOnWriteArrayList<ZoomableImageViewListener> f5955M;
    public ZoomableImageViewZoomAndPanListener f5956N;
    public float f5957O;
    public float f5958P;
    @Nullable
    public ImageModeListener f5959Q;
    public boolean f5960R = true;

    /* compiled from: removedAdminFbIds */
    class C03512 extends AnimatorListenerAdapter {
        final /* synthetic */ ZoomableImageView f5950a;

        C03512(ZoomableImageView zoomableImageView) {
            this.f5950a = zoomableImageView;
        }

        public void onAnimationEnd(Animator animator) {
            this.f5950a.mo401b(this.f5950a.getScale());
            ZoomableImageView.m8535j(this.f5950a);
            if (this.f5950a.f5956N != null) {
                this.f5950a.f5956N.m8559a();
                this.f5950a.f5956N = null;
            }
        }
    }

    /* compiled from: removedAdminFbIds */
    public class GestureListener extends com.facebook.widget.images.zoomableimageview.ImageViewTouch.GestureListener {
        final /* synthetic */ ZoomableImageView f5951b;

        public GestureListener(ZoomableImageView zoomableImageView) {
            this.f5951b = zoomableImageView;
            super(zoomableImageView);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
            Iterator it = this.f5951b.f5955M.iterator();
            while (it.hasNext()) {
                ZoomableImageViewListener zoomableImageViewListener = (ZoomableImageViewListener) it.next();
                this.f5951b.m8526a(pointF);
                zoomableImageViewListener.mo402a();
            }
            return super.onSingleTapUp(motionEvent);
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
            Iterator it = this.f5951b.f5955M.iterator();
            while (it.hasNext()) {
                ((ZoomableImageViewListener) it.next()).mo404a(pointF, this.f5951b.m8526a(pointF));
            }
            return super.onSingleTapConfirmed(motionEvent);
        }

        public void onLongPress(MotionEvent motionEvent) {
            if (!this.f5951b.f5932a.isInProgress()) {
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                Iterator it = this.f5951b.f5955M.iterator();
                while (it.hasNext()) {
                    ((ZoomableImageViewListener) it.next()).mo406b(pointF, this.f5951b.m8526a(pointF));
                }
            }
            super.onLongPress(motionEvent);
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
            Iterator it = this.f5951b.f5955M.iterator();
            while (it.hasNext()) {
                ZoomableImageViewListener zoomableImageViewListener = (ZoomableImageViewListener) it.next();
                this.f5951b.m8526a(pointF);
                zoomableImageViewListener.mo405b();
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    /* compiled from: removedAdminFbIds */
    public interface ImageModeListener {
        void m8519a();
    }

    /* compiled from: removedAdminFbIds */
    public class ScaleListener extends com.facebook.widget.images.zoomableimageview.ImageViewTouch.ScaleListener {
        final /* synthetic */ ZoomableImageView f5952b;

        public ScaleListener(ZoomableImageView zoomableImageView) {
            this.f5952b = zoomableImageView;
            super(zoomableImageView);
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            Iterator it = this.f5952b.f5955M.iterator();
            while (it.hasNext()) {
                ((ZoomableImageViewListener) it.next()).mo410f();
            }
            return super.onScaleBegin(scaleGestureDetector);
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            Iterator it = this.f5952b.f5955M.iterator();
            while (it.hasNext()) {
                it.next();
            }
            super.onScaleEnd(scaleGestureDetector);
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor() * this.f5952b.f5935d;
            Iterator it = this.f5952b.f5955M.iterator();
            while (it.hasNext()) {
                ((ZoomableImageViewListener) it.next()).mo409e();
            }
            if (!this.f5952b.f5941j) {
                return false;
            }
            float min = Math.min(this.f5952b.getMaxZoom(), Math.max(scaleFactor, this.f5952b.getMinZoom()));
            this.f5952b.m8483a(min, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            this.f5952b.d = Math.min(this.f5952b.getMaxZoom(), Math.max(min, this.f5952b.getMinZoom()));
            this.f5952b.f = -1;
            this.f5952b.invalidate();
            return true;
        }
    }

    public ZoomableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFitToScreen(true);
        this.f5955M = new CopyOnWriteArrayList();
    }

    protected OnGestureListener getGestureListener() {
        return new GestureListener(this);
    }

    protected OnScaleGestureListener getScaleListener() {
        return new ScaleListener(this);
    }

    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        Iterator it = this.f5955M.iterator();
        while (it.hasNext()) {
            ((ZoomableImageViewListener) it.next()).mo403a(this.f5924s);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -639801709);
        if (this.f5953K) {
            this.f5932a.onTouchEvent(motionEvent);
            if (!this.f5932a.isInProgress()) {
                this.f5933b.onTouchEvent(motionEvent);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 807774240, a);
            return true;
        }
        LogUtils.a(759820447, a);
        return false;
    }

    public final void m8544a(MotionEvent motionEvent) {
        motionEvent.setAction(3);
        onTouchEvent(motionEvent);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    protected final float mo396a(float f, float f2) {
        if (this.f5937f == 1) {
            this.f = -1;
            return f2;
        }
        this.f = 1;
        return 1.0f;
    }

    public void setMinZoom(float f) {
        if (this.f5960R) {
            f = 1.0f;
        }
        this.w = f;
    }

    public final boolean mo421b() {
        return ((float) getWidth()) / ((float) getHeight()) <= ((float) getPhotoWidth()) / ((float) getPhotoHeight());
    }

    public void setRestrictMinZoomToOne(boolean z) {
        this.f5960R = z;
    }

    public final void m8552c() {
        this.f5953K = true;
    }

    public final void mo423d() {
        this.f5953K = false;
    }

    private boolean m8534i() {
        return this.f5954L;
    }

    protected final void mo419a(boolean z, boolean z2) {
        if (this.f5954L) {
            super.mo419a(z, z2);
        }
    }

    public static void m8535j(ZoomableImageView zoomableImageView) {
        zoomableImageView.f5954L = true;
    }

    private void m8536k() {
        this.f5954L = false;
    }

    protected final void mo401b(float f) {
        if (!this.f5932a.isInProgress()) {
            this.d = f;
        }
        m8538m();
    }

    public final void mo422c(float f) {
        super.mo422c(f);
        this.f = 1;
    }

    public final void mo414a(double d, double d2) {
        super.mo414a(d, d2);
    }

    public final boolean mo420a(int i) {
        if (getDrawable() != null) {
            return super.mo420a(i);
        }
        return false;
    }

    protected final void mo415a(float f, float f2, float f3, float f4) {
        m8537l();
        super.mo415a(f, f2, f3, f4);
    }

    public final void mo416a(float f, float f2, float f3, float f4, float f5, long j) {
        m8537l();
        if (f > getMaxZoom()) {
            f = getMaxZoom();
        }
        if (((float) j) > 0.0f) {
            final float scale = getScale();
            final float f6 = f - scale;
            this.f5957O = 0.0f;
            this.f5958P = 0.0f;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.setDuration(j);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            final float f7 = f4;
            final float f8 = f5;
            final float f9 = f2;
            final float f10 = f3;
            ofFloat.addUpdateListener(new AnimatorUpdateListener(this) {
                final /* synthetic */ ZoomableImageView f5949g;

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float f = f6 * floatValue;
                    float f2 = f7 * floatValue;
                    floatValue *= f8;
                    this.f5949g.m8483a(f + scale, f9 + this.f5949g.f5957O, f10 + this.f5949g.f5958P);
                    this.f5949g.mo414a((double) (f2 - this.f5949g.f5957O), (double) (floatValue - this.f5949g.f5958P));
                    this.f5949g.f5957O = f2;
                    this.f5949g.f5958P = floatValue;
                }
            });
            ofFloat.addListener(new C03512(this));
            m8536k();
            ofFloat.start();
            return;
        }
        m8483a(f, f2, f3);
        mo414a((double) f4, (double) f5);
        mo401b(getScale());
        if (this.f5956N != null) {
            this.f5956N.m8559a();
            this.f5956N = null;
        }
    }

    public final boolean mo424e() {
        return getDrawable() != null;
    }

    protected final void mo417a(RectF rectF, RectF rectF2) {
        if (rectF != null && this.f5954L) {
            super.mo417a(rectF, rectF2);
        }
    }

    public final void mo418a(ZoomableImageViewListener zoomableImageViewListener) {
        this.f5955M.add(zoomableImageViewListener);
    }

    public final void m8550b(ZoomableImageViewListener zoomableImageViewListener) {
        this.f5955M.remove(zoomableImageViewListener);
    }

    private void m8537l() {
        Iterator it = this.f5955M.iterator();
        while (it.hasNext()) {
            ((ZoomableImageViewListener) it.next()).mo407c();
        }
        this.f5942k = false;
    }

    private void m8538m() {
        Iterator it = this.f5955M.iterator();
        while (it.hasNext()) {
            ((ZoomableImageViewListener) it.next()).mo408d();
        }
        this.f5942k = true;
    }

    public void setZoomAndPanListener(ZoomableImageViewZoomAndPanListener zoomableImageViewZoomAndPanListener) {
        this.f5956N = zoomableImageViewZoomAndPanListener;
    }

    public final boolean m8548a(Direction direction, int i, int i2) {
        int i3 = 1;
        if (direction == Direction.UP || direction == Direction.DOWN) {
            return true;
        }
        if (direction == Direction.LEFT) {
            i3 = -1;
        }
        return mo420a(i3);
    }

    public void setImageModeListener(ImageModeListener imageModeListener) {
        this.f5959Q = imageModeListener;
    }

    public final void m8556f() {
        if (this.f5959Q != null) {
            this.f5959Q.m8519a();
        }
    }

    public final void m8557g() {
        m8490b(getMinZoom(), 400.0f);
    }

    public final boolean m8558h() {
        return getScale() > getMinZoom();
    }

    private PointF m8526a(PointF pointF) {
        RectF bitmapRect = getBitmapRect();
        if (bitmapRect == null || !bitmapRect.contains(pointF.x, pointF.y)) {
            return null;
        }
        return new PointF((pointF.x - bitmapRect.left) / bitmapRect.width(), (pointF.y - bitmapRect.top) / bitmapRect.height());
    }
}
