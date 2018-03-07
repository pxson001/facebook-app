package com.facebook.messaging.photos.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.widget.Gallery;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.sharedimage.VideoMessageView;
import com.facebook.messaging.sharedimage.VideoMessageView.C06041;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.zero.sdk.common.ZeroFeatureKey;

/* compiled from: registration_profile_pic_step_skipped */
public class PhotoGallery extends Gallery implements OnDoubleTapListener, OnScaleGestureListener {
    private ScaleGestureDetector f3592a;
    private PhotoMessageView f3593b;
    private VideoMessageView f3594c;

    public PhotoGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f3592a = new ScaleGestureDetector(context, this);
        new GestureDetector(this).setOnDoubleTapListener(this);
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.f3593b == null) {
            if (this.f3594c != null) {
                this.f3594c.m3740c();
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
        PhotoViewZoomableController photoViewZoomableController = this.f3593b.f3611k;
        if (photoViewZoomableController.m3470m() <= 1.5f && !m3421a(motionEvent, motionEvent2)) {
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
        photoViewZoomableController.m3461a(-f, -f2);
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.f3594c != null) {
            this.f3594c.m3740c();
        }
        if (this.f3593b != null && m3421a(motionEvent, motionEvent2)) {
            return false;
        }
        int i;
        if (m3422b(motionEvent, motionEvent2)) {
            i = 21;
        } else {
            i = 22;
        }
        onKeyDown(i, null);
        return true;
    }

    private boolean m3421a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        PhotoViewZoomableController photoViewZoomableController = this.f3593b.f3611k;
        photoViewZoomableController.f3639d.set(photoViewZoomableController.f3638c);
        photoViewZoomableController.f3636a.mapRect(photoViewZoomableController.f3639d);
        if (photoViewZoomableController.f3639d.right <= ((float) this.f3593b.getWidth()) || m3422b(motionEvent, motionEvent2)) {
            photoViewZoomableController.f3639d.set(photoViewZoomableController.f3638c);
            photoViewZoomableController.f3636a.mapRect(photoViewZoomableController.f3639d);
            if (photoViewZoomableController.f3639d.left >= 0.0f || !m3422b(motionEvent, motionEvent2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean m3422b(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return motionEvent2.getX() > motionEvent.getX();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -848014586);
        if (getChildCount() == 0) {
            Logger.a(2, EntryType.UI_INPUT_END, 2142848554, a);
            return false;
        }
        View selectedView = getSelectedView();
        this.f3594c = null;
        this.f3593b = null;
        if (selectedView instanceof PhotoMessageView) {
            this.f3593b = (PhotoMessageView) selectedView;
        } else if (selectedView instanceof VideoMessageView) {
            this.f3594c = (VideoMessageView) selectedView;
        }
        if (this.f3593b == null && this.f3594c == null) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            LogUtils.a(299047871, a);
            return onTouchEvent;
        }
        if (motionEvent.getPointerCount() >= 2) {
            this.f3592a.onTouchEvent(motionEvent);
            if (this.f3592a.isInProgress()) {
                LogUtils.a(-878227734, a);
                return true;
            }
        }
        onTouchEvent = super.onTouchEvent(motionEvent);
        LogUtils.a(979560139, a);
        return onTouchEvent;
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        if (this.f3593b == null) {
            return false;
        }
        PhotoViewZoomableController photoViewZoomableController = this.f3593b.f3611k;
        photoViewZoomableController.m3462a(scaleGestureDetector.getScaleFactor() * photoViewZoomableController.m3470m(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.f3593b == null) {
            return false;
        }
        PhotoViewZoomableController photoViewZoomableController = this.f3593b.f3611k;
        if (photoViewZoomableController.m3470m() > 2.0f) {
            photoViewZoomableController.m3462a(1.0f, photoViewZoomableController.f3637b.width() / 2.0f, photoViewZoomableController.f3637b.height() / 2.0f);
        } else {
            float width = photoViewZoomableController.f3637b.width() / 2.0f;
            float height = photoViewZoomableController.f3637b.height() / 2.0f;
            photoViewZoomableController.f3636a.postTranslate(width - motionEvent.getX(), height - motionEvent.getY());
            photoViewZoomableController.m3462a(3.0f, width, height);
        }
        return true;
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.f3594c == null) {
            return false;
        }
        VideoMessageView videoMessageView = this.f3594c;
        if (videoMessageView.f4032g.c()) {
            videoMessageView.m3740c();
        } else if (videoMessageView.f4035j) {
            videoMessageView.m3739b();
        } else {
            videoMessageView.f4028b.a(ZeroFeatureKey.VIDEO_PLAY_INTERSTITIAL, videoMessageView.getContext().getString(2131232932), new C06041(videoMessageView));
            videoMessageView.f4028b.a(ZeroFeatureKey.VIDEO_PLAY_INTERSTITIAL, videoMessageView.f4029d);
        }
        return true;
    }
}
