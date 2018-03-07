package com.facebook.optic;

import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.util.Log;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: targetPrivacy */
public class CameraFeatures {
    public static final String f3288a = "hdr";
    private static final String f3289b = CameraFeatures.class.getSimpleName();
    private static final boolean f3290c = (VERSION.SDK_INT >= 17);
    private static final HashMap<Integer, CameraFeatures> f3291d = new HashMap();
    private static final ExecutorService f3292e = Executors.newSingleThreadExecutor();
    private Parameters f3293f;
    public WeakReference<Camera> f3294g;
    private volatile boolean f3295h;

    /* compiled from: targetPrivacy */
    class C01991 implements Runnable {
        final /* synthetic */ CameraFeatures f3287a;

        C01991(CameraFeatures cameraFeatures) {
            this.f3287a = cameraFeatures;
        }

        public void run() {
            synchronized (this.f3287a) {
                if (((Camera) this.f3287a.f3294g.get()) != null) {
                    this.f3287a.m4317a(false);
                }
                this.f3287a.f3295h = false;
            }
        }
    }

    /* compiled from: targetPrivacy */
    public class CameraFeatureNotSupportedException extends RuntimeException {
        public CameraFeatureNotSupportedException(String str) {
            super(str);
        }
    }

    private CameraFeatures(Camera camera) {
        this.f3293f = camera.getParameters();
        m4309a(camera);
    }

    private void m4309a(Camera camera) {
        this.f3294g = new WeakReference(camera);
    }

    public static synchronized CameraFeatures m4308a(Camera camera, int i) {
        CameraFeatures cameraFeatures;
        synchronized (CameraFeatures.class) {
            if (camera == null) {
                throw new NullPointerException("camera is null!");
            }
            if (f3291d.containsKey(Integer.valueOf(i))) {
                ((CameraFeatures) f3291d.get(Integer.valueOf(i))).m4309a(camera);
            } else {
                f3291d.put(Integer.valueOf(i), new CameraFeatures(camera));
            }
            cameraFeatures = (CameraFeatures) f3291d.get(Integer.valueOf(i));
        }
        return cameraFeatures;
    }

    public final synchronized void m4317a(boolean z) {
        if (this.f3295h || z) {
            Camera camera = (Camera) this.f3294g.get();
            if (camera != null) {
                camera.setParameters(this.f3293f);
            }
            this.f3295h = false;
        }
    }

    public final synchronized List<String> m4312a() {
        return this.f3293f.getSupportedFlashModes();
    }

    public final synchronized void m4315a(String str) {
        if (str != null) {
            this.f3293f.setFlashMode(str);
            m4307C();
        }
    }

    public final synchronized String m4318b() {
        return this.f3293f.getFlashMode();
    }

    public final synchronized boolean m4325c() {
        boolean z;
        String b = m4318b();
        z = b == null || b.equals("off");
        return z;
    }

    public final synchronized boolean m4326d() {
        boolean z;
        List a = m4312a();
        z = a == null || a.contains("torch");
        return z;
    }

    public final synchronized boolean m4327e() {
        return this.f3293f.isVideoSnapshotSupported();
    }

    public final synchronized boolean m4328f() {
        return this.f3293f.getSupportedFocusModes().contains("auto");
    }

    public final synchronized boolean m4329g() {
        return this.f3293f.getMaxNumMeteringAreas() > 0;
    }

    private synchronized boolean m4306B() {
        boolean z;
        List<String> supportedSceneModes = this.f3293f.getSupportedSceneModes();
        if (supportedSceneModes == null) {
            z = false;
        } else {
            for (String equals : supportedSceneModes) {
                if (equals.equals("hdr")) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    public final synchronized void m4323b(boolean z) {
        if (m4306B() && f3290c) {
            Parameters parameters = this.f3293f;
            parameters.setSceneMode(z ? f3288a : "auto");
            parameters.setRecordingHint(!z);
            m4307C();
        } else if (z) {
            Log.e(f3289b, "Cannot enable HDR, it is not supported on this camera device");
            throw new CameraFeatureNotSupportedException("HDR is not supported on this camera device");
        }
    }

    public final synchronized boolean m4330h() {
        boolean z;
        z = f3290c && f3288a.equals(this.f3293f.getSceneMode());
        return z;
    }

    public final synchronized Rect m4331i() {
        Size previewSize;
        previewSize = this.f3293f.getPreviewSize();
        return new Rect(0, 0, previewSize.width, previewSize.height);
    }

    public final synchronized Rect m4332j() {
        Size pictureSize;
        pictureSize = this.f3293f.getPictureSize();
        return new Rect(0, 0, pictureSize.width, pictureSize.height);
    }

    public final synchronized boolean m4333k() {
        return this.f3293f.isZoomSupported();
    }

    public final synchronized boolean m4334l() {
        return this.f3293f.isSmoothZoomSupported();
    }

    public final synchronized int m4335m() {
        return this.f3293f.getZoom();
    }

    public final synchronized int m4336n() {
        return this.f3293f.getMaxZoom();
    }

    public final synchronized List<Integer> m4337o() {
        return this.f3293f.getZoomRatios();
    }

    public final synchronized void m4313a(int i) {
        this.f3293f.setZoom(i);
        m4317a(true);
    }

    public final synchronized void m4319b(int i) {
        this.f3293f.setRotation(i);
        m4307C();
    }

    public final synchronized Size m4338p() {
        return this.f3293f.getPreviewSize();
    }

    public final synchronized void m4324c(boolean z) {
        this.f3293f.setRecordingHint(z);
        m4307C();
    }

    public final synchronized void m4316a(List<Area> list) {
        this.f3293f.setFocusAreas(list);
        m4307C();
    }

    public final synchronized void m4322b(List<Area> list) {
        this.f3293f.setMeteringAreas(list);
        m4307C();
    }

    public final synchronized String m4339q() {
        return this.f3293f.getFocusMode();
    }

    public final synchronized void m4321b(String str) {
        this.f3293f.setFocusMode(str);
        m4307C();
    }

    public final synchronized void m4340r() {
        Parameters parameters = this.f3293f;
        List supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes.contains("continuous-picture")) {
            parameters.setFocusMode("continuous-picture");
        } else if (supportedFocusModes.contains("auto")) {
            parameters.setFocusMode("auto");
        } else if (supportedFocusModes.contains("infinity")) {
            parameters.setFocusMode("infinity");
        }
        m4307C();
    }

    public final synchronized void m4341s() {
        Parameters parameters = this.f3293f;
        List supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes.contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
        } else if (supportedFocusModes.contains("infinity")) {
            parameters.setFocusMode("infinity");
        }
        m4307C();
    }

    public final synchronized void m4342t() {
        Parameters parameters = this.f3293f;
        List supportedAntibanding = parameters.getSupportedAntibanding();
        if (supportedAntibanding != null && supportedAntibanding.contains("auto")) {
            parameters.setAntibanding("auto");
        }
        m4307C();
    }

    public final synchronized void m4343u() {
        Parameters parameters = this.f3293f;
        List supportedWhiteBalance = parameters.getSupportedWhiteBalance();
        if (supportedWhiteBalance != null && supportedWhiteBalance.contains("auto")) {
            parameters.setWhiteBalance("auto");
        }
        m4307C();
    }

    public final synchronized void m4344v() {
        Parameters parameters = this.f3293f;
        List supportedSceneModes = parameters.getSupportedSceneModes();
        if (supportedSceneModes != null && supportedSceneModes.contains("auto")) {
            parameters.setSceneMode("auto");
        }
        m4307C();
    }

    public final synchronized void m4345w() {
        Parameters parameters = this.f3293f;
        if (parameters.isVideoStabilizationSupported()) {
            parameters.setVideoStabilization(true);
        }
        m4307C();
    }

    public final synchronized void m4346x() {
        int[] iArr;
        Parameters parameters = this.f3293f;
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        int[] iArr2 = null;
        int i = Integer.MAX_VALUE;
        for (int[] iArr3 : supportedPreviewFpsRange) {
            int i2;
            int[] iArr4;
            if (iArr3[1] < 30000 || iArr3[0] >= i) {
                i2 = i;
                iArr4 = iArr2;
            } else {
                iArr4 = iArr3;
                i2 = iArr3[0];
            }
            iArr2 = iArr4;
            i = i2;
        }
        if (iArr2 == null) {
            iArr3 = (int[]) supportedPreviewFpsRange.get(supportedPreviewFpsRange.size() - 1);
        } else {
            iArr3 = iArr2;
        }
        parameters.setPreviewFpsRange(iArr3[0], iArr3[1]);
        m4307C();
    }

    public final synchronized List<Size> m4347y() {
        return this.f3293f.getSupportedVideoSizes();
    }

    public final synchronized List<Size> m4348z() {
        return this.f3293f.getSupportedPreviewSizes();
    }

    public final synchronized List<Size> m4311A() {
        return this.f3293f.getSupportedPictureSizes();
    }

    public final synchronized void m4314a(int i, int i2) {
        this.f3293f.setPreviewSize(i, i2);
        m4307C();
    }

    public final synchronized void m4320b(int i, int i2) {
        this.f3293f.setPictureSize(i, i2);
        m4307C();
    }

    private synchronized void m4307C() {
        if (!this.f3295h) {
            ExecutorDetour.a(f3292e, new C01991(this), 983523919);
            this.f3295h = true;
        }
    }
}
