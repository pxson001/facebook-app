package com.facebook.common.quickcam;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import com.facebook.camera.utils.CameraUtils;
import com.facebook.camera.utils.CameraUtils.OptimizeMode;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.quickcam.prefs.QuickCamPrefKeys;
import com.facebook.common.ui.util.BetterRotationManager;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Product;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

@TargetApi(10)
/* compiled from: provider_id */
public class QuickCamCameraManager {
    private static final Class<?> f6055a = QuickCamCameraManager.class;
    private Executor f6056b;
    private BetterRotationManager f6057c;
    private AbstractFbErrorReporter f6058d;
    public FbSharedPreferences f6059e;
    public Toaster f6060f;
    private FocusOverlayManagerProvider f6061g;
    private CameraUtil f6062h;
    @Nullable
    public FocusOverlayManager f6063i;
    public Camera f6064j;
    public Size f6065k;
    public TriState f6066l;
    public Product f6067m;
    public int f6068n = -1;
    public int f6069o = -1;
    public int f6070p = -1;
    public int f6071q = -1;

    /* compiled from: provider_id */
    class C06331 implements Runnable {
        final /* synthetic */ QuickCamCameraManager f6052a;

        C06331(QuickCamCameraManager quickCamCameraManager) {
            this.f6052a = quickCamCameraManager;
        }

        public void run() {
            this.f6052a.f6060f.b(new ToastBuilder(2131230758));
        }
    }

    /* compiled from: provider_id */
    public class C06342 implements PreviewCallback {
        final /* synthetic */ PictureCallback f6053a;
        final /* synthetic */ QuickCamCameraManager f6054b;

        public C06342(QuickCamCameraManager quickCamCameraManager, PictureCallback pictureCallback) {
            this.f6054b = quickCamCameraManager;
            this.f6053a = pictureCallback;
        }

        public void onPreviewFrame(byte[] bArr, Camera camera) {
            this.f6053a.onPictureTaken(bArr, camera);
        }
    }

    /* compiled from: provider_id */
    public class QuickCamCameraManagerException extends Exception {
        public QuickCamCameraManagerException(String str) {
            super(str);
        }
    }

    @Inject
    public QuickCamCameraManager(BetterRotationManager betterRotationManager, AbstractFbErrorReporter abstractFbErrorReporter, FbSharedPreferences fbSharedPreferences, Toaster toaster, FocusOverlayManagerProvider focusOverlayManagerProvider, CameraUtil cameraUtil, Executor executor, Product product) {
        this.f6057c = betterRotationManager;
        this.f6058d = abstractFbErrorReporter;
        this.f6059e = fbSharedPreferences;
        this.f6060f = toaster;
        this.f6061g = focusOverlayManagerProvider;
        this.f6062h = cameraUtil;
        this.f6056b = executor;
        this.f6067m = product;
    }

    public final void m6402a(QuickCamPreviewHolder quickCamPreviewHolder) {
        try {
            this.f6064j = (Camera) Preconditions.checkNotNull(Camera.open(this.f6070p));
            Parameters parameters = this.f6064j.getParameters();
            this.f6057c.a();
            if (m6398a("continuous-picture", parameters.getSupportedFocusModes())) {
                parameters.setFocusMode("continuous-picture");
            }
            CamcorderProfile b = this.f6062h.m6334b(this.f6070p);
            Integer.valueOf(b.videoFrameWidth);
            Integer.valueOf(b.videoFrameHeight);
            this.f6065k = CameraUtils.a(parameters.getSupportedPreviewSizes(), b.videoFrameWidth, b.videoFrameHeight, OptimizeMode.NO_CONSTRAINTS);
            Integer.valueOf(this.f6065k.width);
            Integer.valueOf(this.f6065k.height);
            parameters.setPreviewSize(this.f6065k.width, this.f6065k.height);
            Size a = CameraUtils.a(parameters.getSupportedPictureSizes(), this.f6065k.width, this.f6065k.height);
            Integer.valueOf(a.width);
            Integer.valueOf(a.height);
            parameters.setPictureSize(a.width, a.height);
            this.f6064j.setParameters(parameters);
            new String[1][0] = "auto";
            if (this.f6064j != null) {
                this.f6063i = this.f6061g.m6349a(this.f6064j, Boolean.valueOf(m6409j()));
                this.f6063i.m6346a(parameters.getPreviewSize().width, parameters.getPreviewSize().height);
            }
            int a2 = m6397a(this.f6057c.b());
            this.f6064j.setDisplayOrientation(a2);
            if (this.f6063i != null) {
                this.f6063i.m6345a(a2);
            }
            try {
                quickCamPreviewHolder.mo234a(this.f6064j);
                try {
                    this.f6064j.startPreview();
                } catch (RuntimeException e) {
                    ExecutorDetour.a(this.f6056b, new C06331(this), -1816940447);
                }
            } catch (IOException e2) {
                this.f6058d.a("QuickCamPopup", "error setting the camera to the preview texture. Maybe because the phone isn't ics or above, maybe camera is already in use");
                throw new QuickCamCameraManagerException(e2.getMessage());
            }
        } catch (Throwable e3) {
            this.f6058d.a("QuickCamCameraManager", e3.getMessage(), e3);
            throw new QuickCamCameraManagerException(e3.getMessage());
        }
    }

    public final void m6403b() {
        if (this.f6064j != null) {
            this.f6064j.stopPreview();
        }
    }

    public final void m6405c() {
        if (this.f6064j != null) {
            this.f6064j.startPreview();
        }
    }

    public final void m6404b(QuickCamPreviewHolder quickCamPreviewHolder) {
        if (this.f6064j != null) {
            this.f6064j.release();
            this.f6070p = m6409j() ? this.f6069o : this.f6068n;
            if (this.f6066l == TriState.UNSET) {
                this.f6059e.edit().a(QuickCamPrefKeys.f6121b, m6409j() ? 1 : 2).commit();
            } else {
                this.f6066l = m6409j() ? TriState.NO : TriState.YES;
            }
            m6402a(quickCamPreviewHolder);
            if (this.f6063i != null) {
                this.f6063i.m6347a(m6409j());
            }
        }
    }

    public final void m6401a(MediaRecorder mediaRecorder, int i) {
        int a = m6409j() ? (360 - m6397a(i)) % 360 : m6397a(i);
        mediaRecorder.setOrientationHint(a);
        this.f6071q = a / 90;
    }

    private int m6397a(int i) {
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(this.f6070p, cameraInfo);
        int i2 = i * 90;
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i2) + 360) % 360;
    }

    public final int m6406e() {
        return this.f6070p;
    }

    public final void m6407h() {
        this.f6064j.lock();
    }

    public final void m6408i() {
        this.f6064j.unlock();
    }

    public final boolean m6409j() {
        if (this.f6066l != TriState.UNSET) {
            if (this.f6066l == TriState.YES) {
                return true;
            }
            return false;
        } else if (this.f6070p != this.f6068n || this.f6070p <= 0) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean m6398a(String str, List<String> list) {
        return list != null && list.indexOf(str) >= 0;
    }

    public static int m6399b(int i) {
        CameraInfo cameraInfo = new CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == i) {
                return i2;
            }
        }
        return -1;
    }

    public final void m6400a(MediaRecorder mediaRecorder) {
        mediaRecorder.setCamera(this.f6064j);
    }

    public final float m6410m() {
        if (this.f6065k == null || this.f6065k.height == 0) {
            return -1.0f;
        }
        float f = ((float) this.f6065k.width) / ((float) this.f6065k.height);
        int a = this.f6057c.a();
        if (a == 0 || a == 2) {
            return 1.0f / f;
        }
        return f;
    }
}
