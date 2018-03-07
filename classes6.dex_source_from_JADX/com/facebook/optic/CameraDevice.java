package com.facebook.optic;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.OnZoomChangeListener;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.backstage.camera.CameraView.6;
import com.facebook.backstage.camera.CameraView.7;
import com.facebook.backstage.camera.CameraView.9;
import com.facebook.optic.CameraPreviewView.FocusCallback;
import com.facebook.optic.CameraPreviewView.FocusCallback.FocusState;
import com.facebook.optic.util.ThreadUtil;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: targetProfilePicUrl */
public class CameraDevice {
    public static final String f3255a = CameraDevice.class.getSimpleName();
    public static final CameraDevice f3256b = new CameraDevice();
    private final DefaultSizeSetter f3257A = new DefaultSizeSetter();
    public MediaRecorder f3258B = null;
    public boolean f3259C;
    public VideoCaptureInfo f3260D;
    public String f3261E;
    public boolean f3262F;
    public int f3263c;
    public Camera f3264d;
    public SurfaceTexture f3265e;
    public int f3266f;
    public int f3267g;
    public int f3268h;
    public CameraFacing f3269i;
    public CaptureQuality f3270j;
    public CaptureQuality f3271k;
    public volatile boolean f3272l;
    public boolean f3273m;
    public boolean f3274n;
    public boolean f3275o;
    public FutureTask<Void> f3276p;
    public FutureTask<Void> f3277q;
    public 6 f3278r = null;
    public 7 f3279s = null;
    public FocusCallback f3280t = null;
    public ZoomController f3281u;
    public 9 f3282v = null;
    public boolean f3283w;
    public String f3284x;
    public Runnable f3285y = null;
    public final Object f3286z = new Object();

    /* compiled from: targetProfilePicUrl */
    public class AnonymousClass10 implements Callback<VideoCaptureInfo> {
        final /* synthetic */ Callback f3212a;
        final /* synthetic */ CameraDevice f3213b;

        public AnonymousClass10(CameraDevice cameraDevice, Callback callback) {
            this.f3213b = cameraDevice;
            this.f3212a = callback;
        }

        public final void mo209a(Object obj) {
            obj = (VideoCaptureInfo) obj;
            if (this.f3212a != null) {
                this.f3212a.mo209a(obj);
            }
        }

        public final void mo208a(Exception exception) {
            this.f3213b.f3264d.lock();
            this.f3213b.f3259C = false;
            if (this.f3212a != null) {
                this.f3212a.mo208a(exception);
            }
        }
    }

    /* compiled from: targetProfilePicUrl */
    public class AnonymousClass12 implements Callback<Size> {
        final /* synthetic */ Callback f3215a;
        final /* synthetic */ CameraDevice f3216b;

        public AnonymousClass12(CameraDevice cameraDevice, Callback callback) {
            this.f3216b = cameraDevice;
            this.f3215a = callback;
        }

        public final void mo209a(Object obj) {
            obj = (Size) obj;
            CameraFeatures a = CameraFeatures.m4308a(this.f3216b.f3264d, CameraDevice.m4272b(this.f3216b.f3269i));
            a.m4315a(this.f3216b.f3261E);
            a.m4323b(this.f3216b.f3262F);
            if (this.f3215a != null) {
                this.f3215a.mo209a(obj);
            }
        }

        public final void mo208a(Exception exception) {
            CameraFeatures a = CameraFeatures.m4308a(this.f3216b.f3264d, CameraDevice.m4272b(this.f3216b.f3269i));
            a.m4315a(this.f3216b.f3261E);
            a.m4323b(this.f3216b.f3262F);
            if (this.f3215a != null) {
                this.f3215a.mo208a(exception);
            }
        }
    }

    /* compiled from: targetProfilePicUrl */
    public class AnonymousClass13 implements Callback<VideoCaptureInfo> {
        final /* synthetic */ Callback f3217a;
        final /* synthetic */ Callback f3218b;
        final /* synthetic */ DefaultSizeSetter f3219c;
        final /* synthetic */ CameraDevice f3220d;

        public AnonymousClass13(CameraDevice cameraDevice, Callback callback, Callback callback2, DefaultSizeSetter defaultSizeSetter) {
            this.f3220d = cameraDevice;
            this.f3217a = callback;
            this.f3218b = callback2;
            this.f3219c = defaultSizeSetter;
        }

        public final void mo209a(Object obj) {
            obj = (VideoCaptureInfo) obj;
            if (this.f3217a != null) {
                this.f3217a.mo209a(obj);
            }
            if (this.f3218b != null) {
                this.f3220d.m4290b(this.f3218b, this.f3219c);
            }
        }

        public final void mo208a(Exception exception) {
            File file = new File(this.f3220d.f3260D.f3341c);
            if (file.exists()) {
                file.delete();
            }
            this.f3220d.f3259C = false;
            if (this.f3217a != null) {
                this.f3217a.mo208a(exception);
            }
            if (this.f3218b != null) {
                this.f3220d.m4290b(this.f3218b, this.f3219c);
            }
        }
    }

    /* compiled from: targetProfilePicUrl */
    public class AnonymousClass15 implements Callable<Void> {
        final /* synthetic */ DefaultSizeSetter f3222a;
        final /* synthetic */ CameraDevice f3223b;

        public AnonymousClass15(CameraDevice cameraDevice, DefaultSizeSetter defaultSizeSetter) {
            this.f3223b = cameraDevice;
            this.f3222a = defaultSizeSetter;
        }

        public Object call() {
            this.f3223b.m4287a(this.f3222a);
            return null;
        }
    }

    /* compiled from: targetProfilePicUrl */
    public class C01871 implements Callable<Void> {
        final /* synthetic */ CameraDevice f3224a;

        public C01871(CameraDevice cameraDevice) {
            this.f3224a = cameraDevice;
        }

        public Object call() {
            if (this.f3224a.f3259C) {
                CameraDevice.m4283w(this.f3224a);
            }
            if (this.f3224a.f3264d != null) {
                CameraDevice.m4280t(this.f3224a);
            }
            this.f3224a.f3265e = null;
            return null;
        }
    }

    /* compiled from: targetProfilePicUrl */
    class C01893 implements Runnable {
        final /* synthetic */ CameraDevice f3234a;

        C01893(CameraDevice cameraDevice) {
            this.f3234a = cameraDevice;
        }

        public void run() {
            this.f3234a.f3278r.a();
        }
    }

    /* compiled from: targetProfilePicUrl */
    class C01904 implements Runnable {
        final /* synthetic */ CameraDevice f3235a;

        C01904(CameraDevice cameraDevice) {
            this.f3235a = cameraDevice;
        }

        public void run() {
            this.f3235a.f3279s.a();
        }
    }

    /* compiled from: targetProfilePicUrl */
    public class C01925 implements AutoFocusCallback {
        final /* synthetic */ int f3237a;
        final /* synthetic */ int f3238b;
        final /* synthetic */ CameraFeatures f3239c;
        final /* synthetic */ CameraDevice f3240d;

        /* compiled from: targetProfilePicUrl */
        class C01911 implements Runnable {
            final /* synthetic */ C01925 f3236a;

            C01911(C01925 c01925) {
                this.f3236a = c01925;
            }

            public void run() {
                if (this.f3236a.f3240d.m4294e()) {
                    if (this.f3236a.f3240d.f3280t != null) {
                        this.f3236a.f3240d.f3280t.mo212a(FocusState.CANCELLED, null);
                    }
                    this.f3236a.f3240d.f3264d.cancelAutoFocus();
                    this.f3236a.f3240d.f3283w = false;
                    this.f3236a.f3239c.m4316a(null);
                    this.f3236a.f3239c.m4321b(this.f3236a.f3240d.f3284x);
                    CameraDevice.m4274c(this.f3236a.f3240d, false);
                }
            }
        }

        public C01925(CameraDevice cameraDevice, int i, int i2, CameraFeatures cameraFeatures) {
            this.f3240d = cameraDevice;
            this.f3237a = i;
            this.f3238b = i2;
            this.f3239c = cameraFeatures;
        }

        public void onAutoFocus(boolean z, Camera camera) {
            if (this.f3240d.f3280t != null) {
                this.f3240d.f3280t.mo212a(z ? FocusState.SUCCESS : FocusState.FAILED, new Point(this.f3237a, this.f3238b));
            }
            this.f3240d.f3285y = new C01911(this);
            HandlerDetour.b(ThreadUtil.f3354e, this.f3240d.f3285y, 2000, -1864957155);
        }
    }

    /* compiled from: targetProfilePicUrl */
    public class C01936 implements Callable<Size> {
        final /* synthetic */ int f3241a;
        final /* synthetic */ CameraDevice f3242b;

        public C01936(CameraDevice cameraDevice, int i) {
            this.f3242b = cameraDevice;
            this.f3241a = i;
        }

        public Object call() {
            this.f3242b.f3264d.setDisplayOrientation(this.f3242b.m4292c());
            this.f3242b.f3266f = this.f3241a;
            return CameraFeatures.m4308a(this.f3242b.f3264d, CameraDevice.m4272b(this.f3242b.f3269i)).m4338p();
        }
    }

    /* compiled from: targetProfilePicUrl */
    public class C01947 implements Callable<Integer> {
        final /* synthetic */ CameraDevice f3243a;

        public C01947(CameraDevice cameraDevice) {
            this.f3243a = cameraDevice;
        }

        public Object call() {
            return Integer.valueOf(this.f3243a.m4273c(this.f3243a.f3263c));
        }
    }

    /* compiled from: targetProfilePicUrl */
    public class C01978 implements Callback<Integer> {
        final /* synthetic */ long f3248a;
        final /* synthetic */ Callback2 f3249b;
        final /* synthetic */ CameraDevice f3250c;

        public C01978(CameraDevice cameraDevice, long j, Callback2 callback2) {
            this.f3250c = cameraDevice;
            this.f3248a = j;
            this.f3249b = callback2;
        }

        public final void mo209a(Object obj) {
            final Integer num = (Integer) obj;
            CameraDevice.m4274c(this.f3250c, false);
            this.f3250c.f3264d.takePicture(null, null, null, new PictureCallback(this) {
                final /* synthetic */ C01978 f3247b;

                public void onPictureTaken(final byte[] bArr, Camera camera) {
                    Log.e(CameraDevice.f3255a, "jpeg: " + (SystemClock.elapsedRealtime() - this.f3247b.f3248a));
                    this.f3247b.f3250c.f3264d.startPreview();
                    CameraDevice.m4281u(this.f3247b.f3250c);
                    this.f3247b.f3250c.f3272l = true;
                    ThreadUtil.m4408a(new Runnable(this) {
                        final /* synthetic */ C01961 f3245b;

                        public void run() {
                            if (bArr != null) {
                                this.f3245b.f3247b.f3249b.mo211a(bArr, num);
                            } else {
                                this.f3245b.f3247b.f3249b.mo210a(new RuntimeException("Jpeg data returned by Camera.PictureCallback was null"));
                            }
                        }
                    });
                }
            });
        }

        public final void mo208a(Exception exception) {
        }
    }

    /* compiled from: targetProfilePicUrl */
    public class C01989 implements Callable<VideoCaptureInfo> {
        final /* synthetic */ String f3251a;
        final /* synthetic */ CameraDevice f3252b;

        public C01989(CameraDevice cameraDevice, String str) {
            this.f3252b = cameraDevice;
            this.f3251a = str;
        }

        public Object call() {
            CameraFeatures a = CameraFeatures.m4308a(this.f3252b.f3264d, CameraDevice.m4272b(this.f3252b.f3269i));
            a.m4341s();
            this.f3252b.f3262F = a.m4330h();
            this.f3252b.f3261E = a.m4318b();
            if (!a.m4325c() && a.m4326d()) {
                a.m4315a("torch");
            }
            CameraDevice.m4274c(this.f3252b, false);
            synchronized (this.f3252b.f3286z) {
                this.f3252b.f3264d.unlock();
                this.f3252b.f3258B = new MediaRecorder();
                this.f3252b.f3258B.setCamera(this.f3252b.f3264d);
                this.f3252b.f3258B.setAudioSource(5);
                this.f3252b.f3258B.setVideoSource(1);
                CamcorderProfile camcorderProfile = CamcorderProfile.get(CameraDevice.m4272b(this.f3252b.f3269i), 1);
                Size p = a.m4338p();
                camcorderProfile.videoFrameWidth = p.width;
                camcorderProfile.videoFrameHeight = p.height;
                if (this.f3252b.f3270j.equals(CaptureQuality.HIGH)) {
                    camcorderProfile.videoBitRate = 5000000;
                } else if (this.f3252b.f3270j.equals(CaptureQuality.MEDIUM)) {
                    camcorderProfile.videoBitRate = 3000000;
                } else if (this.f3252b.f3270j.equals(CaptureQuality.LOW)) {
                    camcorderProfile.videoBitRate = 1000000;
                }
                this.f3252b.f3258B.setProfile(camcorderProfile);
                this.f3252b.f3258B.setOutputFile(this.f3251a);
                this.f3252b.f3260D = new VideoCaptureInfo(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight, this.f3251a, this.f3252b.m4275d(this.f3252b.f3263c));
                this.f3252b.f3258B.setOrientationHint(this.f3252b.m4275d(this.f3252b.f3263c));
                this.f3252b.f3258B.prepare();
                this.f3252b.f3258B.start();
            }
            return this.f3252b.f3260D;
        }
    }

    /* compiled from: targetProfilePicUrl */
    public class CameraDeviceBusyException extends Exception {
        public CameraDeviceBusyException(String str) {
            super(str);
        }
    }

    /* compiled from: targetProfilePicUrl */
    public enum CameraFacing {
        FRONT(1),
        BACK(0);
        
        private int mInfoId;

        private CameraFacing(int i) {
            this.mInfoId = i;
        }

        public static CameraFacing fromId(int i) {
            for (CameraFacing cameraFacing : values()) {
                if (cameraFacing.mInfoId == i) {
                    return cameraFacing;
                }
            }
            return BACK;
        }

        public final int getInfoId() {
            return this.mInfoId;
        }
    }

    /* compiled from: targetProfilePicUrl */
    public class CameraNotInitialisedException extends RuntimeException {
        public CameraNotInitialisedException(String str) {
            super("Camera not initialised: " + str);
        }
    }

    /* compiled from: targetProfilePicUrl */
    public enum CaptureQuality {
        HIGH(0),
        MEDIUM(1),
        LOW(2),
        DEACTIVATED(3);
        
        int mId;

        private CaptureQuality(int i) {
            this.mId = i;
        }

        public static CaptureQuality fromId(int i) {
            for (CaptureQuality captureQuality : values()) {
                if (captureQuality.mId == i) {
                    return captureQuality;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    /* compiled from: targetProfilePicUrl */
    class ZoomController implements OnZoomChangeListener {
        final /* synthetic */ CameraDevice f3253a;
        private List<Integer> f3254b;

        public ZoomController(CameraDevice cameraDevice) {
            this.f3253a = cameraDevice;
            if (cameraDevice.m4294e()) {
                this.f3254b = CameraFeatures.m4308a(cameraDevice.f3264d, CameraDevice.m4272b(cameraDevice.f3269i)).m4337o();
                return;
            }
            throw new CameraNotInitialisedException("Failed to create a zoom controller.");
        }

        public void onZoomChange(int i, boolean z, Camera camera) {
            if (z) {
                CameraFeatures.m4308a(this.f3253a.f3264d, CameraDevice.m4272b(this.f3253a.f3269i)).m4313a(i);
            }
            if (this.f3253a.f3282v != null) {
                this.f3253a.f3282v.a(((Integer) this.f3254b.get(i)).intValue(), ((Integer) this.f3254b.get(this.f3254b.size() - 1)).intValue());
            }
        }

        public final void m4265a(int i) {
            if (this.f3253a.m4294e()) {
                CameraFeatures a = CameraFeatures.m4308a(this.f3253a.f3264d, CameraDevice.m4272b(this.f3253a.f3269i));
                if (a.m4334l()) {
                    this.f3253a.f3264d.startSmoothZoom(i);
                    return;
                }
                a.m4313a(i);
                if (this.f3253a.f3282v != null) {
                    9 9 = this.f3253a.f3282v;
                    int intValue = ((Integer) this.f3254b.get(i)).intValue();
                    int intValue2 = ((Integer) this.f3254b.get(this.f3254b.size() - 1)).intValue();
                    Camera camera = this.f3253a.f3264d;
                    9.a(intValue, intValue2);
                    return;
                }
                return;
            }
            throw new CameraNotInitialisedException("Zoom controller failed to set the zoom level.");
        }
    }

    private CameraDevice() {
    }

    protected Object clone() {
        super.clone();
        throw new CloneNotSupportedException();
    }

    public static CameraDevice m4267a() {
        return f3256b;
    }

    public static void m4280t(CameraDevice cameraDevice) {
        if (cameraDevice.f3264d != null) {
            cameraDevice.f3272l = false;
            Camera camera = cameraDevice.f3264d;
            cameraDevice.f3264d = null;
            camera.stopPreview();
            cameraDevice.m4282v();
            camera.release();
        }
    }

    public final void m4286a(SurfaceTexture surfaceTexture, CameraFacing cameraFacing, int i, int i2, int i3, CaptureQuality captureQuality, CaptureQuality captureQuality2, SizeSetter sizeSetter, Callback<Size> callback) {
        final CameraFacing cameraFacing2 = cameraFacing;
        final SurfaceTexture surfaceTexture2 = surfaceTexture;
        final int i4 = i;
        final CaptureQuality captureQuality3 = captureQuality;
        final CaptureQuality captureQuality4 = captureQuality2;
        final int i5 = i2;
        final int i6 = i3;
        final DefaultSizeSetter defaultSizeSetter = sizeSetter;
        ThreadUtil.m4413b(new FutureTask(new Callable<Size>(this) {
            final /* synthetic */ CameraDevice f3233i;

            public Object call() {
                int b;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (this.f3233i.f3264d == null || this.f3233i.f3269i != cameraFacing2) {
                    CameraDevice.m4280t(this.f3233i);
                    this.f3233i.f3269i = cameraFacing2;
                    b = CameraDevice.m4272b(cameraFacing2);
                    this.f3233i.f3264d = Camera.open(b);
                } else {
                    b = CameraDevice.m4272b(cameraFacing2);
                }
                if (this.f3233i.f3264d != null) {
                    this.f3233i.f3264d.setPreviewTexture(surfaceTexture2);
                    this.f3233i.f3264d.setDisplayOrientation(CameraDevice.m4276d(i4, b));
                    CameraFeatures a = CameraFeatures.m4308a(this.f3233i.f3264d, b);
                    a.m4324c(true);
                    this.f3233i.m4270a(captureQuality3, captureQuality4, i5, i6, defaultSizeSetter);
                    this.f3233i.f3265e = surfaceTexture2;
                    this.f3233i.f3266f = i4;
                    this.f3233i.f3267g = i5;
                    this.f3233i.f3268h = i6;
                    this.f3233i.f3271k = captureQuality3;
                    this.f3233i.f3270j = captureQuality4;
                    a.m4340r();
                    this.f3233i.f3274n = a.m4327e();
                    a.m4342t();
                    a.m4343u();
                    a.m4346x();
                    a.m4344v();
                    a.m4345w();
                    this.f3233i.f3272l = true;
                    this.f3233i.f3273m = false;
                    CameraDevice.m4274c(this.f3233i, true);
                    this.f3233i.f3281u = new ZoomController(this.f3233i);
                    this.f3233i.f3264d.setZoomChangeListener(this.f3233i.f3281u);
                    this.f3233i.f3264d.startPreview();
                    CameraDevice.m4281u(this.f3233i);
                    Log.d(CameraDevice.f3255a, "time to setPreviewSurfaceTexture:" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
                    return a.m4338p();
                }
                throw new RuntimeException("Can't connect to the camera.");
            }
        }), (Callback) callback);
    }

    public static void m4281u(CameraDevice cameraDevice) {
        if (cameraDevice.f3278r != null) {
            ThreadUtil.m4408a(new C01893(cameraDevice));
        }
    }

    private void m4282v() {
        if (this.f3279s != null) {
            ThreadUtil.m4408a(new C01904(this));
        }
    }

    private int m4273c(int i) {
        int d = m4275d(i);
        CameraFeatures.m4308a(this.f3264d, m4272b(this.f3269i)).m4319b(d);
        return d;
    }

    private int m4275d(int i) {
        if (i == -1) {
            return 0;
        }
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(m4272b(this.f3269i), cameraInfo);
        int i2 = ((i + 45) / 90) * 90;
        if (cameraInfo.facing == 1) {
            return ((cameraInfo.orientation - i2) + 360) % 360;
        }
        return (cameraInfo.orientation + i2) % 360;
    }

    private void m4270a(CaptureQuality captureQuality, CaptureQuality captureQuality2, int i, int i2, DefaultSizeSetter defaultSizeSetter) {
        if (this.f3264d == null) {
            throw new RuntimeException("Set sizes failed, camera not yet initialised");
        }
        CameraFeatures a = CameraFeatures.m4308a(this.f3264d, m4272b(this.f3269i));
        if (!captureQuality2.equals(CaptureQuality.DEACTIVATED) && !captureQuality.equals(CaptureQuality.DEACTIVATED)) {
            defaultSizeSetter.m4403a(a, captureQuality, captureQuality2);
        } else if (captureQuality2.equals(CaptureQuality.DEACTIVATED) && !captureQuality.equals(CaptureQuality.DEACTIVATED)) {
        } else {
            if (captureQuality2.equals(CaptureQuality.DEACTIVATED) || !captureQuality.equals(CaptureQuality.DEACTIVATED)) {
                float max = ((float) Math.max(i, i2)) / ((float) Math.min(i, i2));
                int i3 = 0;
                Size size = null;
                for (Size size2 : a.m4348z()) {
                    Size size22;
                    int i4;
                    int i5;
                    if (max < ((float) Math.max(size22.width, size22.height)) / ((float) Math.min(size22.width, size22.height))) {
                        i4 = (int) ((((float) size22.height) * max) * ((float) size22.height));
                    } else {
                        i4 = (int) (((float) size22.width) * (((float) size22.width) / max));
                    }
                    if (i4 > i3) {
                        i5 = i4;
                    } else {
                        size22 = size;
                        i5 = i3;
                    }
                    i3 = i5;
                    size = size22;
                }
                a.m4314a(size.width, size.height);
            }
        }
    }

    public final void m4285a(int i, int i2) {
        if (m4294e()) {
            Rect rect = new Rect(i, i2, i, i2);
            rect.inset(-30, -30);
            rect.intersect(-1000, -1000, 1000, 1000);
            List arrayList = new ArrayList();
            arrayList.add(new Area(rect, 1000));
            CameraFeatures.m4308a(this.f3264d, m4272b(this.f3269i)).m4322b(arrayList);
            m4274c(this, false);
        }
    }

    public static int m4272b(CameraFacing cameraFacing) {
        int numberOfCameras = Camera.getNumberOfCameras();
        CameraInfo cameraInfo = new CameraInfo();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == cameraFacing.getInfoId()) {
                return i;
            }
        }
        return 0;
    }

    public final int m4292c() {
        return m4276d(this.f3266f, m4272b(this.f3269i));
    }

    public static int m4276d(int i, int i2) {
        int i3 = 0;
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(i2, cameraInfo);
        switch (i) {
            case 1:
                i3 = 90;
                break;
            case 2:
                i3 = 180;
                break;
            case 3:
                i3 = 270;
                break;
        }
        if (cameraInfo.facing == 1) {
            return (360 - ((i3 + cameraInfo.orientation) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i3) + 360) % 360;
    }

    public final CameraFacing m4293d() {
        return this.f3269i;
    }

    public final boolean m4294e() {
        return m4295f() && !this.f3273m;
    }

    public final boolean m4295f() {
        return this.f3264d != null && this.f3272l;
    }

    public static void m4283w(CameraDevice cameraDevice) {
        if (cameraDevice.f3258B != null) {
            cameraDevice.f3258B.stop();
            cameraDevice.f3258B.reset();
            cameraDevice.f3258B.release();
            cameraDevice.f3258B = null;
        }
        if (cameraDevice.f3264d != null) {
            cameraDevice.f3264d.lock();
            CameraFeatures.m4308a(cameraDevice.f3264d, m4272b(cameraDevice.f3269i)).m4315a("off");
            m4274c(cameraDevice, false);
        }
        cameraDevice.f3259C = false;
    }

    public final void m4290b(Callback<Size> callback, SizeSetter sizeSetter) {
        this.f3272l = false;
        m4284x();
        if (this.f3264d != null) {
            m4286a(this.f3265e, this.f3269i, this.f3266f, this.f3267g, this.f3268h, this.f3271k, this.f3270j, sizeSetter, callback);
        }
    }

    private void m4284x() {
        if (this.f3264d != null) {
            this.f3264d.stopPreview();
            m4282v();
        }
    }

    public final void m4296g() {
        if (!this.f3273m) {
            m4284x();
            this.f3273m = true;
        }
    }

    public final void m4287a(DefaultSizeSetter defaultSizeSetter) {
        if (this.f3273m) {
            m4290b(null, defaultSizeSetter);
            this.f3273m = false;
        }
    }

    final Rect m4297j() {
        if (m4294e()) {
            return CameraFeatures.m4308a(this.f3264d, m4272b(this.f3269i)).m4331i();
        }
        throw new CameraNotInitialisedException("Failed to get preview rect.");
    }

    final Rect m4298k() {
        if (m4294e()) {
            return CameraFeatures.m4308a(this.f3264d, m4272b(this.f3269i)).m4332j();
        }
        throw new CameraNotInitialisedException("Failed to get picture rect.");
    }

    final List<String> m4299l() {
        if (m4294e()) {
            return CameraFeatures.m4308a(this.f3264d, m4272b(this.f3269i)).m4312a();
        }
        throw new CameraNotInitialisedException("Failed to get supported flash modes.");
    }

    final void m4288a(String str) {
        if (m4294e()) {
            CameraFeatures.m4308a(this.f3264d, m4272b(this.f3269i)).m4315a(str);
            return;
        }
        throw new CameraNotInitialisedException("Failed to set flash mode.");
    }

    final String m4300m() {
        if (m4294e()) {
            return CameraFeatures.m4308a(this.f3264d, m4272b(this.f3269i)).m4318b();
        }
        throw new CameraNotInitialisedException("Failed to get flash mode.");
    }

    final void m4291b(boolean z) {
        if (m4294e()) {
            CameraFeatures.m4308a(this.f3264d, m4272b(this.f3269i)).m4323b(z);
            return;
        }
        throw new CameraNotInitialisedException("Failed to toggle HDR mode.");
    }

    final boolean m4301n() {
        if (m4294e()) {
            return CameraFeatures.m4308a(this.f3264d, m4272b(this.f3269i)).m4328f();
        }
        throw new CameraNotInitialisedException("Failed to detect auto-focus support.");
    }

    final boolean m4302o() {
        if (m4294e()) {
            return CameraFeatures.m4308a(this.f3264d, m4272b(this.f3269i)).m4329g();
        }
        throw new CameraNotInitialisedException("Failed to detect spot metering support.");
    }

    final boolean m4303p() {
        if (m4294e()) {
            return CameraFeatures.m4308a(this.f3264d, m4272b(this.f3269i)).m4333k();
        }
        throw new CameraNotInitialisedException("Failed to detect zoom support.");
    }

    final int m4304q() {
        if (m4294e()) {
            return CameraFeatures.m4308a(this.f3264d, m4272b(this.f3269i)).m4335m();
        }
        throw new CameraNotInitialisedException("Failed to get current zoom level");
    }

    final int m4305r() {
        if (m4294e()) {
            return CameraFeatures.m4308a(this.f3264d, m4272b(this.f3269i)).m4336n();
        }
        throw new CameraNotInitialisedException("Failed to get the maximum zoom level");
    }

    final void m4289b(int i) {
        if (m4294e()) {
            this.f3281u.m4265a(i);
            return;
        }
        throw new CameraNotInitialisedException("Failed to set zoom level");
    }

    public static void m4274c(CameraDevice cameraDevice, boolean z) {
        synchronized (cameraDevice.f3286z) {
            CameraFeatures.m4308a(cameraDevice.f3264d, m4272b(cameraDevice.f3269i)).m4317a(z);
        }
    }
}
