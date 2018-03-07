package com.facebook.camera.device;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import com.facebook.camera.analytics.CameraFlowLogger;
import java.util.List;

/* compiled from: already specified skipNulls */
public class PinchToZoom implements OnScaleGestureListener {
    private static final Class<?> f10913a = PinchToZoom.class;
    private final Camera f10914b;
    private final CameraFlowLogger f10915c;
    private int f10916d;
    private int f10917e;
    private List<Integer> f10918f;
    private float f10919g = 2.0f;
    public boolean f10920h;

    public PinchToZoom(Camera camera, CameraFlowLogger cameraFlowLogger) {
        this.f10914b = camera;
        this.f10915c = cameraFlowLogger;
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        int i;
        int intValue = (int) (((float) ((Integer) this.f10918f.get(this.f10916d)).intValue()) * (1.0f + ((scaleGestureDetector.getScaleFactor() - 1.0f) * this.f10919g)));
        Parameters parameters = this.f10914b.getParameters();
        int zoom = parameters.getZoom();
        if (zoom < 0 || zoom >= this.f10917e) {
            i = zoom;
        } else if (intValue >= ((Integer) this.f10918f.get(zoom)).intValue()) {
            i = zoom;
            while (i < this.f10917e - 1 && intValue > ((Integer) this.f10918f.get(i + 1)).intValue()) {
                i++;
            }
        } else {
            i = zoom;
            while (i > 0 && intValue < ((Integer) this.f10918f.get(i - 1)).intValue()) {
                i--;
            }
        }
        if (zoom != i) {
            parameters.setZoom(i);
            try {
                this.f10914b.setParameters(parameters);
            } catch (Exception e) {
                this.f10915c.mo1147a("onScale/setParameters failed", e);
            }
            this.f10920h = true;
        }
        return false;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        Parameters parameters = this.f10914b.getParameters();
        this.f10916d = parameters.getZoom();
        this.f10918f = parameters.getZoomRatios();
        this.f10917e = this.f10918f.size();
        while (this.f10917e > 1 && ((Integer) this.f10918f.get(this.f10917e - 1)).intValue() > 400) {
            this.f10917e--;
        }
        this.f10919g = Math.max(1.15f, (((float) ((Integer) this.f10918f.get(this.f10917e - 1)).intValue()) / 100.0f) / 3.0f);
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }
}
