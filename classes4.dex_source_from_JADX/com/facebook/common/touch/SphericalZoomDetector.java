package com.facebook.common.touch;

import android.content.Context;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

/* compiled from: ping_rtt */
public class SphericalZoomDetector {
    public ScaleGestureDetector f4709a;
    private OnScaleGestureListener f4710b = new ScaleGestureDetectorListener(this);
    public ZoomListener f4711c;
    public ZoomState f4712d;

    /* compiled from: ping_rtt */
    public interface ZoomListener {
        boolean mo410a(float f);

        boolean mo413c();

        void mo414d();
    }

    /* compiled from: ping_rtt */
    class ScaleGestureDetectorListener implements OnScaleGestureListener {
        final /* synthetic */ SphericalZoomDetector f4713a;

        public ScaleGestureDetectorListener(SphericalZoomDetector sphericalZoomDetector) {
            this.f4713a = sphericalZoomDetector;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.f4713a.f4712d = ZoomState.ZOOM_STARTED;
            return this.f4713a.f4711c.mo413c();
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            this.f4713a.f4712d = ZoomState.ZOOMING;
            return this.f4713a.f4711c.mo410a(scaleGestureDetector.getScaleFactor());
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.f4713a.f4712d = ZoomState.ZOOM_ENDED;
            this.f4713a.f4711c.mo414d();
        }
    }

    public SphericalZoomDetector(Context context, ZoomListener zoomListener) {
        this.f4711c = zoomListener;
        this.f4709a = new ScaleGestureDetector(context, this.f4710b);
    }
}
