package com.facebook.widget.images.zoomableimageview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.ViewConfiguration;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;

/* compiled from: replyType */
public class ImageViewTouch extends ZoomableTouchBaseView {
    public ScaleGestureDetector f5932a;
    protected GestureDetector f5933b;
    protected int f5934c;
    protected float f5935d;
    protected float f5936e;
    protected int f5937f;
    protected OnGestureListener f5938g;
    protected OnScaleGestureListener f5939h;
    public boolean f5940i = true;
    public boolean f5941j = true;
    public boolean f5942k = true;

    /* compiled from: replyType */
    public class GestureListener extends SimpleOnGestureListener {
        final /* synthetic */ ImageViewTouch f5904a;

        public GestureListener(ImageViewTouch imageViewTouch) {
            this.f5904a = imageViewTouch;
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            String str = ZoomableTouchBaseView.f5906l;
            Boolean.valueOf(this.f5904a.f5940i);
            if (this.f5904a.f5940i) {
                float min = Math.min(this.f5904a.getMaxZoom(), Math.max(this.f5904a.mo396a(this.f5904a.getScale(), this.f5904a.getMaxZoom()), this.f5904a.getMinZoom()));
                this.f5904a.f5935d = min;
                this.f5904a.mo415a(min, motionEvent.getX(), motionEvent.getY(), 400.0f);
                this.f5904a.invalidate();
            }
            return super.onDoubleTap(motionEvent);
        }

        public void onLongPress(MotionEvent motionEvent) {
            if (this.f5904a.isLongClickable() && !this.f5904a.f5932a.isInProgress()) {
                this.f5904a.setPressed(true);
                this.f5904a.performLongClick();
            }
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            ZoomableTouchBaseView zoomableTouchBaseView = this.f5904a;
            boolean z = false;
            if (!(!zoomableTouchBaseView.f5942k || motionEvent == null || motionEvent2 == null || motionEvent.getPointerCount() > 1 || motionEvent2.getPointerCount() > 1 || zoomableTouchBaseView.f5932a.isInProgress() || zoomableTouchBaseView.getScale() == 1.0f)) {
                Float.valueOf(f);
                Float.valueOf(f2);
                zoomableTouchBaseView.m8493c(-f, -f2);
                zoomableTouchBaseView.invalidate();
                z = true;
            }
            return z;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            ZoomableTouchBaseView zoomableTouchBaseView = this.f5904a;
            boolean z = false;
            if (zoomableTouchBaseView.f5942k && motionEvent.getPointerCount() <= 1 && motionEvent2.getPointerCount() <= 1 && !zoomableTouchBaseView.f5932a.isInProgress()) {
                float x = motionEvent2.getX() - motionEvent.getX();
                float y = motionEvent2.getY() - motionEvent.getY();
                if (Math.abs(f) > 800.0f || Math.abs(f2) > 800.0f) {
                    zoomableTouchBaseView.m8482a(x / 2.0f, y / 2.0f, 300.0d);
                    zoomableTouchBaseView.invalidate();
                    z = true;
                }
            }
            return z;
        }
    }

    /* compiled from: replyType */
    public class ScaleListener extends SimpleOnScaleGestureListener {
        final /* synthetic */ ImageViewTouch f5905a;

        public ScaleListener(ImageViewTouch imageViewTouch) {
            this.f5905a = imageViewTouch;
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            String str = ZoomableTouchBaseView.f5906l;
            scaleGestureDetector.getCurrentSpan();
            scaleGestureDetector.getPreviousSpan();
            float scaleFactor = this.f5905a.f5935d * scaleGestureDetector.getScaleFactor();
            if (!this.f5905a.f5941j) {
                return false;
            }
            scaleFactor = Math.min(this.f5905a.getMaxZoom(), Math.max(scaleFactor, this.f5905a.getMinZoom() - 0.1f));
            this.f5905a.m8483a(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            this.f5905a.f5935d = Math.min(this.f5905a.getMaxZoom(), Math.max(scaleFactor, this.f5905a.getMinZoom() - 1.0f));
            this.f5905a.f5937f = 1;
            this.f5905a.invalidate();
            return true;
        }
    }

    public ImageViewTouch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final void mo397a() {
        super.mo397a();
        this.f5934c = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f5938g = getGestureListener();
        this.f5939h = getScaleListener();
        this.f5932a = new ScaleGestureDetector(getContext(), this.f5939h);
        this.f5933b = new GestureDetector(getContext(), this.f5938g, null, true);
        this.f5935d = 1.0f;
        this.f5937f = 1;
    }

    protected OnGestureListener getGestureListener() {
        return new GestureListener(this);
    }

    protected OnScaleGestureListener getScaleListener() {
        return new ScaleListener(this);
    }

    protected final void mo399a(@Nullable Drawable drawable) {
        super.mo399a(drawable);
        float[] fArr = new float[9];
        this.f5920o.getValues(fArr);
        this.f5935d = fArr[0];
    }

    protected final void mo400a(@Nullable Drawable drawable, boolean z, @Nullable Matrix matrix, float f) {
        super.mo400a(drawable, z, matrix, f);
        this.f5936e = getMaxZoom() / 3.0f;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -2045295901);
        this.f5932a.onTouchEvent(motionEvent);
        if (!this.f5932a.isInProgress()) {
            this.f5933b.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (getScale() < getMinZoom()) {
                    m8490b(getMinZoom(), 50.0f);
                    break;
                }
                break;
        }
        LogUtils.a(-895910411, a);
        return true;
    }

    protected final void mo398a(float f) {
        super.mo398a(f);
        if (!this.f5932a.isInProgress()) {
            this.f5935d = f;
        }
    }

    protected void mo401b(float f) {
        super.mo401b(f);
        if (!this.f5932a.isInProgress()) {
            this.f5935d = f;
        }
        if (f < getMinZoom()) {
            m8490b(getMinZoom(), 50.0f);
        }
    }

    protected float mo396a(float f, float f2) {
        if (this.f5937f != 1) {
            this.f5937f = 1;
            return 1.0f;
        } else if ((this.f5936e * 2.0f) + f <= f2) {
            return f + this.f5936e;
        } else {
            this.f5937f = -1;
            return f2;
        }
    }

    public boolean mo420a(int i) {
        RectF bitmapRect = getBitmapRect();
        mo417a(bitmapRect, this.f5916J);
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (bitmapRect.right < ((float) rect.right) || i >= 0) {
            if (((double) Math.abs(bitmapRect.left - this.f5916J.left)) <= 1.0d) {
                return false;
            }
            return true;
        } else if (Math.abs(bitmapRect.right - ((float) rect.right)) > 1.0f) {
            return true;
        } else {
            return false;
        }
    }

    public boolean canScrollVertically(int i) {
        if (this.f5935d <= getMinZoom()) {
            return false;
        }
        return true;
    }
}
