package com.facebook.camera.device;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.facebook.camera.analytics.CameraFlowLogger;
import com.facebook.camera.facetracking.FaceDetectionManager;
import com.facebook.qrcode.QRCodeFragment;

/* compiled from: alternate_name */
public class CameraPreview extends SurfaceView implements PreviewCallback, Callback {
    private static final Class<?> f10876a = CameraPreview.class;
    private SurfaceHolder f10877b = getHolder();
    public Camera f10878c;
    public CreateSurfaceListener f10879d;
    public QRCodeFragment f10880e;
    private FocusManager f10881f;
    private FaceDetectionManager f10882g;
    private final CameraFlowLogger f10883h;

    /* compiled from: alternate_name */
    public abstract class CreateSurfaceListener {
        public abstract void mo1158a(boolean z);

        public void mo1157a() {
        }
    }

    public CameraPreview(Context context, Camera camera, FocusManager focusManager, FaceDetectionManager faceDetectionManager, CameraFlowLogger cameraFlowLogger) {
        super(context);
        this.f10878c = camera;
        this.f10881f = focusManager;
        this.f10883h = cameraFlowLogger;
        this.f10877b.addCallback(this);
        this.f10877b.setType(3);
        this.f10882g = faceDetectionManager;
    }

    private boolean m18936a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder.getSurface() == null) {
            return false;
        }
        this.f10877b = surfaceHolder;
        if (this.f10878c == null) {
            return false;
        }
        if (this.f10882g != null) {
            this.f10882g.m18970c();
        }
        this.f10878c.stopPreview();
        this.f10881f.m18959d();
        try {
            this.f10881f.m18962g();
            this.f10878c.setPreviewDisplay(this.f10877b);
        } catch (Exception e) {
            this.f10883h.mo1147a("CameraPreview/setPreviewDisplay failed", e);
        }
        try {
            this.f10878c.startPreview();
            this.f10881f.m18958c();
            if (this.f10882g != null) {
                this.f10882g.m18969b();
            }
            return true;
        } catch (Exception e2) {
            this.f10883h.mo1147a("CameraPreview/startPreview failed", e2);
            return false;
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (this.f10879d != null) {
            this.f10879d.mo1157a();
        }
        boolean a = m18936a(surfaceHolder);
        if (this.f10879d != null) {
            this.f10879d.mo1158a(a);
        }
    }

    public Surface getSurface() {
        return this.f10877b.getSurface();
    }

    public final void m18937a() {
        this.f10878c.setPreviewCallback(null);
        this.f10878c = null;
        this.f10879d = null;
        this.f10880e = null;
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.f10880e != null) {
            this.f10880e.a(bArr, camera.getParameters());
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}
