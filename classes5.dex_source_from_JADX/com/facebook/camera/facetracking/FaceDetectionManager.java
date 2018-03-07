package com.facebook.camera.facetracking;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Face;
import android.hardware.Camera.FaceDetectionListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.debug.log.BLog;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: alpha */
public class FaceDetectionManager implements FaceDetectionListener {
    private static final Class<?> f10931a = FaceDetectionManager.class;
    public Camera f10932b;
    private final AbstractFbErrorReporter f10933c;
    public int f10934d = -1;
    public boolean f10935e = true;
    private boolean f10936f = false;
    public List<FaceDetectionListener> f10937g;

    public FaceDetectionManager(Camera camera, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f10932b = camera;
        this.f10933c = abstractFbErrorReporter;
        this.f10937g = Lists.a();
    }

    @TargetApi(14)
    public final boolean m18969b() {
        if (this.f10932b == null || !this.f10935e || this.f10936f) {
            return false;
        }
        try {
            this.f10932b.startFaceDetection();
            this.f10936f = true;
            return true;
        } catch (IllegalArgumentException e) {
            m18968a("Could not start FD -- not supported");
            return false;
        } catch (RuntimeException e2) {
            m18968a("Could not start FD -- already running or failure");
            return false;
        }
    }

    @TargetApi(14)
    public final boolean m18970c() {
        if (this.f10932b == null || !this.f10935e || !this.f10936f) {
            return false;
        }
        this.f10932b.setFaceDetectionListener(null);
        try {
            this.f10932b.stopFaceDetection();
            this.f10936f = false;
            return true;
        } catch (RuntimeException e) {
            m18968a("Could not stop face detection");
            return false;
        }
    }

    private void m18968a(String str) {
        BLog.b(f10931a, str);
        this.f10933c.a(f10931a.getSimpleName(), str);
        this.f10936f = false;
    }

    @TargetApi(14)
    public void onFaceDetection(Face[] faceArr, Camera camera) {
        if (this.f10934d == 1) {
            for (Face face : faceArr) {
                Rect rect = face.rect;
                rect.set(rect.left * -1, rect.top, rect.right * -1, rect.bottom);
            }
        }
        for (FaceTracker faceTracker : this.f10937g) {
            if (!faceTracker.f10945f) {
                faceTracker.f10944e = faceArr;
                faceTracker.f10947h.sendEmptyMessage(1);
            }
        }
    }
}
