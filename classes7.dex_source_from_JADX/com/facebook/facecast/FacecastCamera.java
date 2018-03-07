package com.facebook.facecast;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.hardware.Camera;
import android.hardware.Camera.ErrorCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.debug.log.BLog;
import com.facebook.facecast.plugin.FacecastAnalyticsLogger;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.videostreaming.CameraSetup;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

@TargetApi(11)
/* compiled from: button_text */
public class FacecastCamera {
    public static final String f17971a = FacecastCamera.class.getName();
    private final Handler f17972b = new Handler();
    public final FacecastAnalyticsLogger f17973c;
    private final AbstractFbErrorReporter f17974d;
    public volatile int f17975e;
    public Handler f17976f;
    private SurfaceTexture f17977g;
    public WeakReference<CameraHandlerDelegate> f17978h;
    public volatile int f17979i;
    public volatile int f17980j;
    private int f17981k = 0;
    @Nullable
    public volatile Camera f17982l;

    /* compiled from: button_text */
    class C15201 implements ErrorCallback {
        final /* synthetic */ FacecastCamera f17964a;

        C15201(FacecastCamera facecastCamera) {
            this.f17964a = facecastCamera;
        }

        public void onError(int i, Camera camera) {
            this.f17964a.f17976f.sendMessage(this.f17964a.f17976f.obtainMessage(5));
        }
    }

    /* compiled from: button_text */
    class CameraHandler extends Handler {
        final /* synthetic */ FacecastCamera f17968a;

        public CameraHandler(FacecastCamera facecastCamera, Looper looper) {
            this.f17968a = facecastCamera;
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            String str = FacecastCamera.f17971a;
            Integer.valueOf(i);
            Preconditions.checkState(this.f17968a.f17978h != null, "Camera Handler Delegate is not set.");
            if (((CameraHandlerDelegate) this.f17968a.f17978h.get()) == null) {
                BLog.a(FacecastCamera.f17971a, "FacecastCamera.handleMessage: activity is null");
                return;
            }
            switch (i) {
                case 0:
                    FacecastCamera.m21837a(this.f17968a, (SurfaceTexture) message.obj);
                    return;
                case 1:
                    FacecastCamera.m21841i(this.f17968a);
                    return;
                case 2:
                    FacecastCamera.m21838a(this.f17968a, (Integer) message.obj);
                    return;
                case 3:
                    FacecastCamera.m21844l(this.f17968a);
                    return;
                case 4:
                    FacecastCamera facecastCamera = this.f17968a;
                    int intValue = ((Integer) message.obj).intValue();
                    Preconditions.checkArgument(facecastCamera.f17982l.getParameters().isZoomSupported());
                    Parameters parameters = facecastCamera.f17982l.getParameters();
                    Integer.valueOf(intValue);
                    parameters.setZoom(intValue);
                    facecastCamera.f17982l.setParameters(parameters);
                    return;
                case 5:
                    FacecastCamera.m21845n(this.f17968a);
                    return;
                default:
                    throw new RuntimeException("unknown msg " + i);
            }
        }
    }

    /* compiled from: button_text */
    class SurfaceOnFrameAvailableHelper implements OnFrameAvailableListener {
        final /* synthetic */ FacecastCamera f17969a;
        private final int f17970b;

        public SurfaceOnFrameAvailableHelper(FacecastCamera facecastCamera, int i) {
            this.f17969a = facecastCamera;
            this.f17970b = i;
        }

        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            if (this.f17970b != this.f17969a.f17975e) {
                String str = FacecastCamera.f17971a;
            }
            if (this.f17969a.f17978h != null && this.f17969a.f17978h.get() != null) {
                ((CameraHandlerDelegate) this.f17969a.f17978h.get()).q_(this.f17970b);
            }
        }
    }

    @Inject
    public FacecastCamera(FacecastAnalyticsLogger facecastAnalyticsLogger, AbstractFbErrorReporter abstractFbErrorReporter, @Assisted int i) {
        m21843k();
        this.f17973c = facecastAnalyticsLogger;
        this.f17974d = abstractFbErrorReporter;
        this.f17975e = i;
    }

    private boolean m21840a(int i, int i2) {
        if (this.f17982l != null) {
            BLog.a(f17971a, "camera already initialized");
            return true;
        }
        this.f17981k = i2;
        this.f17975e = i;
        Exception exception = null;
        try {
            this.f17982l = CameraSetup.a(i, Integer.valueOf(i2));
        } catch (Exception e) {
            exception = e;
        }
        if (this.f17982l == null) {
            m21839a(exception);
            return false;
        }
        this.f17982l.setErrorCallback(new C15201(this));
        Size previewSize = this.f17982l.getParameters().getPreviewSize();
        this.f17979i = previewSize.width;
        this.f17980j = previewSize.height;
        Preconditions.checkNotNull(this.f17978h, "Delegate cannot be null");
        Preconditions.checkNotNull(this.f17978h.get(), "Delegate reference cannot be null");
        return true;
    }

    public final void m21849a(CameraHandlerDelegate cameraHandlerDelegate) {
        this.f17978h = new WeakReference(cameraHandlerDelegate);
    }

    public final void m21847a(int i, @Nullable Object obj) {
        if (obj == null) {
            this.f17976f.sendMessageAtFrontOfQueue(this.f17976f.obtainMessage(i));
        } else {
            this.f17976f.sendMessageAtFrontOfQueue(this.f17976f.obtainMessage(i, obj));
        }
    }

    public final boolean m21850d() {
        return ((Camera) Preconditions.checkNotNull(this.f17982l)).getParameters().isZoomSupported();
    }

    public final int m21851e() {
        return ((Camera) Preconditions.checkNotNull(this.f17982l)).getParameters().getZoom();
    }

    public final boolean m21852g() {
        return this.f17982l != null;
    }

    @TargetApi(11)
    public static void m21837a(FacecastCamera facecastCamera, SurfaceTexture surfaceTexture) {
        if (surfaceTexture != null) {
            facecastCamera.f17977g = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(new SurfaceOnFrameAvailableHelper(facecastCamera, facecastCamera.f17975e));
            try {
                if (facecastCamera.f17982l == null) {
                    BLog.a(f17971a, "Camera object is null. Cannot set preview.");
                    return;
                }
                facecastCamera.f17982l.setPreviewTexture(surfaceTexture);
                facecastCamera.f17982l.startPreview();
            } catch (Throwable e) {
                BLog.b(f17971a, "Cannot set the preview surface texture for camera.", e);
            }
        }
    }

    public static void m21841i(FacecastCamera facecastCamera) {
        facecastCamera.m21842j();
        CameraHandlerDelegate o = facecastCamera.m21846o();
        if (o != null) {
            o.mo1390m();
        }
    }

    private void m21842j() {
        Camera camera = this.f17982l;
        if (camera != null) {
            camera.stopPreview();
            camera.release();
        }
        m21843k();
    }

    private void m21843k() {
        this.f17979i = -1;
        this.f17980j = -1;
        this.f17982l = null;
    }

    public static void m21844l(FacecastCamera facecastCamera) {
        int i = 1;
        Integer.valueOf(facecastCamera.f17975e);
        if (facecastCamera.f17975e == 1) {
            i = 0;
        }
        facecastCamera.m21842j();
        if (facecastCamera.m21840a(i, facecastCamera.f17981k)) {
            m21837a(facecastCamera, facecastCamera.f17977g);
            Integer.valueOf(facecastCamera.f17975e);
            facecastCamera.f17973c.m21964a(null, facecastCamera.f17975e == 0 ? "backCamera" : "frontCamera", "cameraFlipped", null, null);
            CameraHandlerDelegate o = facecastCamera.m21846o();
            if (o != null) {
                o.mo1392o();
            }
        }
    }

    public static void m21838a(FacecastCamera facecastCamera, Integer num) {
        if (facecastCamera.m21840a(facecastCamera.f17975e, num.intValue())) {
            CameraHandlerDelegate o = facecastCamera.m21846o();
            if (o != null) {
                o.mo1391n();
            }
        }
    }

    public static void m21845n(FacecastCamera facecastCamera) {
        facecastCamera.m21842j();
        if (facecastCamera.m21840a(facecastCamera.f17975e, facecastCamera.f17981k) && facecastCamera.f17977g != null) {
            m21837a(facecastCamera, facecastCamera.f17977g);
        }
    }

    private void m21839a(final Exception exception) {
        this.f17974d.a(f17971a, "Failed to open camera");
        final CameraHandlerDelegate o = m21846o();
        if (o != null) {
            HandlerDetour.a(this.f17972b, new Runnable(this) {
                final /* synthetic */ FacecastCamera f17967c;

                public void run() {
                    if (o != null) {
                        o.mo1387a(exception);
                    }
                }
            }, 38916706);
        }
    }

    @Nullable
    private CameraHandlerDelegate m21846o() {
        if (this.f17978h != null) {
            return (CameraHandlerDelegate) this.f17978h.get();
        }
        return null;
    }

    public final void m21848a(Looper looper) {
        this.f17976f = new CameraHandler(this, looper);
    }
}
