package org.webrtc.videoengine;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.ErrorCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.debug.log.BLog;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Exchanger;

@DoNotStrip
/* compiled from: application/mikey */
public class VideoCaptureAndroid implements ErrorCallback, PreviewCallback {
    private static final Class<?> f21141a = VideoCaptureAndroid.class;
    private static SurfaceTexture f21142b;
    private static WebrtcUiHandler f21143c;
    private static CaptureErrorCallback f21144d;
    private static VideoCaptureAndroid f21145e;
    public SurfaceTexture f21146f;
    private int f21147g;
    private int f21148h;
    private int f21149i;
    private int f21150j;
    private int f21151k;
    private int f21152l;
    private Camera f21153m;
    private int f21154n;
    private int f21155o;
    private CameraThread f21156p;
    private Handler f21157q;
    private VideoCaptureState f21158r = VideoCaptureState.STOPPED;
    private int f21159s;
    private final int f21160t;
    private final CameraInfo f21161u;
    private final Display f21162v;
    private final long f21163w;
    private final int f21164x = 3;

    /* compiled from: application/mikey */
    public interface CaptureErrorCallback {
        void mo822b();
    }

    /* compiled from: application/mikey */
    class C24604 implements Runnable {
        final /* synthetic */ VideoCaptureAndroid f21138a;

        C24604(VideoCaptureAndroid videoCaptureAndroid) {
            this.f21138a = videoCaptureAndroid;
        }

        public void run() {
            VideoCaptureAndroid.m21591d(this.f21138a);
        }
    }

    /* compiled from: application/mikey */
    class CameraThread extends Thread {
        final /* synthetic */ VideoCaptureAndroid f21139a;
        private Exchanger<Handler> f21140b;

        public CameraThread(VideoCaptureAndroid videoCaptureAndroid, Exchanger<Handler> exchanger) {
            this.f21139a = videoCaptureAndroid;
            this.f21140b = exchanger;
        }

        public void run() {
            Looper.prepare();
            VideoCaptureAndroid.m21584b(this.f21140b, new Handler());
            Looper.loop();
        }
    }

    /* compiled from: application/mikey */
    enum VideoCaptureState {
        STOPPED,
        WAITING_FOR_SURFACE,
        CAPTURING
    }

    private native void OnOrientationChanged(long j, int i);

    private native void ProvideCameraFrame(byte[] bArr, int i, int i2, int i3, long j);

    public static void m21574a(SurfaceTexture surfaceTexture) {
        synchronized (VideoCaptureAndroid.class) {
            f21142b = surfaceTexture;
            VideoCaptureAndroid videoCaptureAndroid = f21145e;
        }
        if (videoCaptureAndroid != null) {
            videoCaptureAndroid.m21585b(f21142b);
        }
    }

    public void onError(int i, Camera camera) {
        BLog.b(f21141a, "Camera error detected : %d. Stopping capture", new Object[]{Integer.valueOf(i)});
        m21573a(i);
    }

    private static synchronized void m21573a(int i) {
        synchronized (VideoCaptureAndroid.class) {
            if (f21144d != null) {
                f21144d.mo822b();
            }
        }
    }

    public static synchronized SurfaceTexture m21569a() {
        SurfaceTexture surfaceTexture;
        synchronized (VideoCaptureAndroid.class) {
            surfaceTexture = f21142b;
        }
        return surfaceTexture;
    }

    public static synchronized void m21576a(WebrtcUiHandler webrtcUiHandler) {
        synchronized (VideoCaptureAndroid.class) {
            f21143c = webrtcUiHandler;
        }
    }

    public static synchronized void m21577a(CaptureErrorCallback captureErrorCallback) {
        synchronized (VideoCaptureAndroid.class) {
            f21144d = captureErrorCallback;
        }
    }

    private static synchronized void m21588c(VideoCaptureAndroid videoCaptureAndroid) {
        synchronized (VideoCaptureAndroid.class) {
            f21145e = videoCaptureAndroid;
        }
    }

    private int m21582b() {
        switch (this.f21162v.getRotation()) {
            case 1:
                return 90;
            case 2:
                return 180;
            case 3:
                return 270;
            default:
                return 0;
        }
    }

    @DoNotStrip
    public VideoCaptureAndroid(Context context, int i, long j) {
        this.f21160t = i;
        this.f21163w = j;
        this.f21161u = VideoCaptureDeviceInfoAndroid.m21593a(i);
        this.f21162v = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    @DoNotStrip
    private synchronized boolean startCapture(int i, int i2, int i3, int i4) {
        boolean z;
        if (this.f21156p == null && this.f21157q == null) {
            m21588c(this);
            Exchanger exchanger = new Exchanger();
            this.f21156p = new CameraThread(this, exchanger);
            this.f21156p.start();
            this.f21157q = (Handler) m21584b(exchanger, null);
            final Exchanger exchanger2 = new Exchanger();
            final int i5 = i;
            final int i6 = i2;
            final int i7 = i3;
            final int i8 = i4;
            HandlerDetour.a(this.f21157q, new Runnable(this) {
                final /* synthetic */ VideoCaptureAndroid f21133f;

                public void run() {
                    this.f21133f.f21146f = VideoCaptureAndroid.m21569a();
                    VideoCaptureAndroid.m21584b(exchanger2, Boolean.valueOf(this.f21133f.m21578a(i5, i6, i7, i8)));
                }
            }, 188785582);
            if (((Boolean) m21584b(exchanger2, Boolean.valueOf(false))).booleanValue()) {
                z = true;
            } else {
                m21588c(null);
                z = false;
            }
        } else {
            BLog.b(f21141a, "Camera thread already started!");
            z = false;
        }
        return z;
    }

    private static Size m21571a(List<Size> list, int i, int i2) {
        int i3 = -1;
        Size size = null;
        for (Size size2 : list) {
            Size size22;
            int i4;
            int abs = Math.abs((size22.width * size22.height) - (i * i2));
            if (i3 < 0 || i3 > abs) {
                i4 = abs;
            } else {
                size22 = size;
                i4 = i3;
            }
            i3 = i4;
            size = size22;
        }
        return size;
    }

    private static int[] m21581a(List<int[]> list, int i) {
        for (int[] iArr : list) {
            if (i <= iArr[1]) {
                return iArr;
            }
        }
        if (list.isEmpty()) {
            return null;
        }
        return (int[]) list.get(list.size() - 1);
    }

    @TargetApi(11)
    private boolean m21578a(int i, int i2, int i3, int i4) {
        Throwable e;
        Integer.valueOf(i);
        Integer.valueOf(i2);
        Integer.valueOf(i3);
        Integer.valueOf(i4);
        this.f21147g = i;
        this.f21148h = i2;
        this.f21149i = i3;
        this.f21150j = i4;
        if (this.f21146f == null) {
            this.f21158r = VideoCaptureState.WAITING_FOR_SURFACE;
            return true;
        }
        this.f21151k = m21582b();
        this.f21159s = -1;
        this.f21152l = 0;
        try {
            this.f21153m = Camera.open(this.f21160t);
            Parameters parameters = this.f21153m.getParameters();
            Size a = m21571a(parameters.getSupportedPreviewSizes(), i, i2);
            if (a != null) {
                i = a.width;
                i2 = a.height;
            }
            parameters.setPreviewSize(i, i2);
            this.f21154n = i;
            this.f21155o = i2;
            int[] a2 = m21581a(parameters.getSupportedPreviewFpsRange(), i4);
            if (a2 != null) {
                i3 = a2[0];
                i4 = a2[1];
            }
            parameters.setPreviewFpsRange(i3, i4);
            m21575a(parameters);
            parameters.setPreviewFormat(17);
            this.f21153m.setParameters(parameters);
            int bitsPerPixel = ((i * i2) * ImageFormat.getBitsPerPixel(17)) / 8;
            if (bitsPerPixel > 0) {
                for (int i5 = 0; i5 < 3; i5++) {
                    this.f21153m.addCallbackBuffer(new byte[bitsPerPixel]);
                }
            }
            this.f21153m.setPreviewCallbackWithBuffer(this);
            this.f21153m.setPreviewTexture(this.f21146f);
            this.f21153m.setErrorCallback(this);
            m21591d(this);
            this.f21153m.startPreview();
            this.f21158r = VideoCaptureState.CAPTURING;
            if (f21143c == null) {
                return true;
            }
            f21143c.m19450a(this.f21154n, this.f21155o);
            return true;
        } catch (IOException e2) {
            e = e2;
            BLog.b(f21141a, "startCapture failed", e);
            if (this.f21153m != null) {
                m21588c(this);
            }
            return false;
        } catch (RuntimeException e3) {
            e = e3;
            BLog.b(f21141a, "startCapture failed", e);
            if (this.f21153m != null) {
                m21588c(this);
            }
            return false;
        }
    }

    @TargetApi(15)
    private static void m21575a(Parameters parameters) {
        if (VERSION.SDK_INT >= 15) {
            Boolean.valueOf(parameters.isVideoStabilizationSupported());
            if (parameters.isVideoStabilizationSupported()) {
                parameters.setVideoStabilization(true);
            }
        }
    }

    @DoNotStrip
    private synchronized boolean stopCapture() {
        boolean booleanValue;
        m21588c(null);
        final Exchanger exchanger = new Exchanger();
        HandlerDetour.a(this.f21157q, new Runnable(this) {
            final /* synthetic */ VideoCaptureAndroid f21135b;

            public void run() {
                Looper.myLooper().quit();
                VideoCaptureAndroid.m21584b(exchanger, Boolean.valueOf(VideoCaptureAndroid.m21588c(this.f21135b)));
            }
        }, -1893000666);
        booleanValue = ((Boolean) m21584b(exchanger, Boolean.valueOf(false))).booleanValue();
        try {
            this.f21156p.join();
            this.f21157q = null;
            this.f21156p = null;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return booleanValue;
    }

    @TargetApi(11)
    public static boolean m21590c(VideoCaptureAndroid videoCaptureAndroid) {
        Throwable e;
        if (videoCaptureAndroid.f21153m == null) {
            BLog.b(f21141a, "Camera is already stopped!");
            videoCaptureAndroid.f21158r = VideoCaptureState.STOPPED;
            return true;
        }
        try {
            if (videoCaptureAndroid.f21158r == VideoCaptureState.CAPTURING) {
                videoCaptureAndroid.f21153m.stopPreview();
                videoCaptureAndroid.f21153m.setPreviewTexture(null);
            }
            videoCaptureAndroid.f21158r = VideoCaptureState.STOPPED;
            videoCaptureAndroid.f21153m.setPreviewCallbackWithBuffer(null);
            videoCaptureAndroid.f21153m.setErrorCallback(null);
            videoCaptureAndroid.f21153m.release();
            videoCaptureAndroid.f21153m = null;
            videoCaptureAndroid.f21154n = 0;
            videoCaptureAndroid.f21155o = 0;
            return true;
        } catch (IOException e2) {
            e = e2;
            BLog.b(f21141a, "Failed to stop mCamera", e);
            return false;
        } catch (RuntimeException e3) {
            e = e3;
            BLog.b(f21141a, "Failed to stop mCamera", e);
            return false;
        }
    }

    private synchronized void m21585b(final SurfaceTexture surfaceTexture) {
        if (this.f21157q != null) {
            HandlerDetour.a(this.f21157q, new Runnable(this) {
                final /* synthetic */ VideoCaptureAndroid f21137b;

                public void run() {
                    VideoCaptureAndroid.m21589c(this.f21137b, surfaceTexture);
                }
            }, -1830767359);
        }
    }

    public static void m21589c(VideoCaptureAndroid videoCaptureAndroid, SurfaceTexture surfaceTexture) {
        if (videoCaptureAndroid.f21158r != VideoCaptureState.STOPPED && videoCaptureAndroid.f21146f != surfaceTexture) {
            if (videoCaptureAndroid.f21146f != null) {
                m21588c(videoCaptureAndroid);
            }
            videoCaptureAndroid.f21146f = surfaceTexture;
            videoCaptureAndroid.m21578a(videoCaptureAndroid.f21147g, videoCaptureAndroid.f21148h, videoCaptureAndroid.f21149i, videoCaptureAndroid.f21150j);
        }
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (Thread.currentThread() != this.f21156p) {
            BLog.b(f21141a, "Camera callback not on mCamera thread?!?");
        } else if (this.f21153m == null) {
        } else {
            if (this.f21153m != camera) {
                BLog.b(f21141a, "Unexpected mCamera in callback!");
                return;
            }
            int b = m21582b();
            if (b != this.f21151k) {
                HandlerDetour.a(this.f21157q, new C24604(this), -964402242);
            }
            if (this.f21159s < 0 || b != this.f21151k) {
                this.f21159s = m21583b((360 - b) % 360);
                OnOrientationChanged(this.f21163w, this.f21159s);
            }
            this.f21151k = b;
            ProvideCameraFrame(bArr, bArr.length, this.f21154n, this.f21155o, this.f21163w);
            this.f21153m.addCallbackBuffer(bArr);
        }
    }

    public static void m21591d(VideoCaptureAndroid videoCaptureAndroid) {
        if (videoCaptureAndroid.f21153m != null && videoCaptureAndroid.f21146f != null) {
            int e = videoCaptureAndroid.m21592e();
            if (e != videoCaptureAndroid.f21152l) {
                try {
                    videoCaptureAndroid.f21153m.setDisplayOrientation(e);
                    videoCaptureAndroid.f21152l = e;
                } catch (Throwable e2) {
                    BLog.b(f21141a, "Failed to set preview orientation", e2);
                    videoCaptureAndroid.f21153m.stopPreview();
                    try {
                        videoCaptureAndroid.f21153m.setDisplayOrientation(e);
                        videoCaptureAndroid.f21152l = e;
                    } catch (Throwable e22) {
                        BLog.b(f21141a, "Failed to set display orientation after retrying", e22);
                    }
                    videoCaptureAndroid.f21153m.startPreview();
                }
            }
        }
    }

    private int m21592e() {
        if (this.f21161u.facing == 1) {
            return (720 - (this.f21161u.orientation + this.f21151k)) % 360;
        }
        return ((this.f21161u.orientation + 360) - this.f21151k) % 360;
    }

    private int m21583b(int i) {
        int i2;
        if (this.f21161u.facing == 1) {
            i2 = ((this.f21161u.orientation - i) + 360) % 360;
        } else {
            i2 = (this.f21161u.orientation + i) % 360;
        }
        if (i2 <= 45 || i2 > 315) {
            return 0;
        }
        if (i2 > 45 && i2 <= 135) {
            return 90;
        }
        if (i2 > 135 && i2 <= 225) {
            return 180;
        }
        if (i2 <= 225 || i2 > 315) {
            return 0;
        }
        return 270;
    }

    public static <T> T m21584b(Exchanger<T> exchanger, T t) {
        try {
            return exchanger.exchange(t);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
