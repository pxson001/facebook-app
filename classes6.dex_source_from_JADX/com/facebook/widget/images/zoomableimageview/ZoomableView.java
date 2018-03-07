package com.facebook.widget.images.zoomableimageview;

import android.graphics.Matrix;

/* compiled from: remove_video */
public interface ZoomableView {

    /* compiled from: remove_video */
    public interface ZoomableImageViewZoomAndPanListener {
        void m8559a();
    }

    void mo416a(float f, float f2, float f3, float f4, float f5, long j);

    void mo418a(ZoomableImageViewListener zoomableImageViewListener);

    boolean mo421b();

    boolean mo424e();

    Matrix getBaseMatrix();

    Matrix getImageMatrix();

    float getMaxZoom();

    float getMinZoom();

    Matrix getPhotoDisplayMatrix();

    int getPhotoHeight();

    int getPhotoWidth();

    float getScale();

    int getWidth();

    void setZoomAndPanListener(ZoomableImageViewZoomAndPanListener zoomableImageViewZoomAndPanListener);
}
