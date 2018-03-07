package com.facebook.backstage.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.backstage.abtest.BackstageGatekeepers;
import com.facebook.backstage.camera.CaptureButton.CaptureButtonListener;
import com.facebook.backstage.camera.LiveStatusPoller.DemoLiveStatusGenerator;
import com.facebook.backstage.data.LocalShot;
import com.facebook.backstage.data.LocalShot.MediaType;
import com.facebook.backstage.ui.RotateButton;
import com.facebook.backstage.ui.RotateButton.RotateButtonListener;
import com.facebook.backstage.ui.ToggleTextButton;
import com.facebook.backstage.ui.ToggleTextButton.ToggleTextButtonListener;
import com.facebook.backstage.ui.VideoRecordingProgressBar;
import com.facebook.backstage.ui.ViewAnimator;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.optic.Callback;
import com.facebook.optic.CameraDevice;
import com.facebook.optic.CameraDevice.CameraFacing;
import com.facebook.optic.CameraPreviewView;
import com.facebook.optic.CameraPreviewView.CameraInitialisedCallback;
import com.facebook.optic.CameraPreviewView.FocusCallback;
import com.facebook.optic.CameraPreviewView.FocusCallback.FocusState;
import com.facebook.optic.CameraPreviewView.PinchZoomListener;
import com.facebook.optic.VideoCaptureInfo;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Preconditions;
import java.io.File;
import java.util.List;
import javax.inject.Inject;

/* compiled from: search_session_ended_by_user */
public class CameraView extends FrameLayout {
    public static final String f4356e = CameraView.class.getSimpleName();
    @Inject
    QuickPerformanceLogger f4357a;
    @Inject
    TempFileManager f4358b;
    @Inject
    LiveStatusPoller f4359c;
    @Inject
    BackstageGatekeepers f4360d;
    private final RotateButtonListener f4361f;
    private final CaptureButtonListener f4362g;
    private final ToggleTextButtonListener f4363h;
    public final CameraPreviewView f4364i;
    public final FocusView f4365j;
    public final ZoomView f4366k;
    private final LinearLayout f4367l;
    private final FrameLayout f4368m;
    public final ImageView f4369n;
    public final ImageView f4370o;
    private final RotateButton f4371p;
    private final CaptureButton f4372q;
    public final ToggleTextButton f4373r;
    public final VideoRecordingProgressBar f4374s;
    private final LiveStatusView f4375t;
    public final Handler f4376u;
    public final Runnable f4377v;
    public CameraViewOrientationListener f4378w;
    public CameraViewListener f4379x;
    public boolean f4380y;

    /* compiled from: search_session_ended_by_user */
    public interface CameraViewListener {
        void mo140a(LocalShot localShot);

        void mo141a(String str);
    }

    /* compiled from: search_session_ended_by_user */
    /* synthetic */ class AnonymousClass12 {
        static final /* synthetic */ int[] f4341a = new int[FocusState.values().length];

        static {
            try {
                f4341a[FocusState.FOCUSSING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4341a[FocusState.CANCELLED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4341a[FocusState.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4341a[FocusState.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: search_session_ended_by_user */
    class C04001 implements RotateButtonListener {
        final /* synthetic */ CameraView f4342a;

        /* compiled from: search_session_ended_by_user */
        class C03991 implements Callback<CameraFacing> {
            final /* synthetic */ C04001 f4337a;

            C03991(C04001 c04001) {
                this.f4337a = c04001;
            }

            public final void m4325a(Object obj) {
                this.f4337a.f4342a.f4364i.p = this.f4337a.f4342a.f4364i.getCameraFacing();
            }

            public final void m4324a(Exception exception) {
                this.f4337a.f4342a.f4379x.mo141a(this.f4337a.f4342a.getResources().getString(2131239905));
                this.f4337a.f4342a.m4391d();
                BLog.b(CameraView.f4356e, "Failed to flip the camera", exception);
            }
        }

        C04001(CameraView cameraView) {
            this.f4342a = cameraView;
        }

        public final void mo144a() {
            CameraPreviewView cameraPreviewView = this.f4342a.f4364i;
            if (!CameraPreviewView.f()) {
                this.f4342a.m4390c();
                this.f4342a.f4364i.a(new C03991(this));
            }
        }

        public final void mo145a(float f) {
            float abs = Math.abs(f % 360.0f);
            if (abs > 180.0f) {
                abs = 360.0f - abs;
            }
            abs = 1.0f - (abs / 180.0f);
            this.f4342a.f4369n.setRotation(f);
            this.f4342a.f4369n.setAlpha(abs);
            this.f4342a.f4370o.setRotation(f);
            this.f4342a.f4370o.setAlpha(1.0f - abs);
        }
    }

    /* compiled from: search_session_ended_by_user */
    class C04042 implements CaptureButtonListener {
        final /* synthetic */ CameraView f4346a;

        /* compiled from: search_session_ended_by_user */
        class C04011 implements Callback<VideoCaptureInfo> {
            final /* synthetic */ C04042 f4343a;

            C04011(C04042 c04042) {
                this.f4343a = c04042;
            }

            public final void m4333a(Object obj) {
                HandlerDetour.b(this.f4343a.f4346a.f4376u, this.f4343a.f4346a.f4377v, 400, 2053002220);
            }

            public final void m4332a(Exception exception) {
                this.f4343a.f4346a.f4379x.mo141a(this.f4343a.f4346a.getResources().getString(2131239907));
                BLog.b(CameraView.f4356e, "Failed to start recording a video", exception);
                this.f4343a.f4346a.m4359a(false, true);
            }
        }

        /* compiled from: search_session_ended_by_user */
        class C04022 implements Callback<VideoCaptureInfo> {
            final /* synthetic */ C04042 f4344a;

            C04022(C04042 c04042) {
                this.f4344a = c04042;
            }

            public final void m4335a(Object obj) {
                VideoCaptureInfo videoCaptureInfo = (VideoCaptureInfo) obj;
                if (this.f4344a.f4346a.f4379x != null) {
                    this.f4344a.f4346a.f4379x.mo140a(new LocalShot(MediaType.VIDEO, null, videoCaptureInfo.c, 0, 0, this.f4344a.f4346a.f4376u, ((float) this.f4344a.f4346a.getHeight()) / ((float) this.f4344a.f4346a.getWidth())));
                }
            }

            public final void m4334a(Exception exception) {
                this.f4344a.f4346a.f4379x.mo141a(this.f4344a.f4346a.getResources().getString(2131239908));
                BLog.b(CameraView.f4356e, "Failed to finish recording a video", exception);
            }
        }

        /* compiled from: search_session_ended_by_user */
        class C04033 implements Callback<Size> {
            final /* synthetic */ C04042 f4345a;

            C04033(C04042 c04042) {
                this.f4345a = c04042;
            }

            public final void m4337a(Object obj) {
                this.f4345a.f4346a.m4359a(false, true);
            }

            public final void m4336a(Exception exception) {
                this.f4345a.f4346a.f4379x.mo141a(this.f4345a.f4346a.getResources().getString(2131239909));
                BLog.b(CameraView.f4356e, "Failed to restart the preview", exception);
            }
        }

        C04042(CameraView cameraView) {
            this.f4346a = cameraView;
        }

        public final void mo146a() {
            this.f4346a.f4357a.b(6160385);
            Bitmap previewFrame = this.f4346a.f4364i.getPreviewFrame();
            this.f4346a.f4357a.a(6160385, (short) 59);
            if (this.f4346a.f4379x != null) {
                this.f4346a.f4379x.mo140a(new LocalShot(MediaType.PHOTO, previewFrame, null, 0, this.f4346a.f4378w.f4355b, false, ((float) this.f4346a.getHeight()) / ((float) this.f4346a.getWidth())));
            }
        }

        public final void mo147b() {
            CameraPreviewView cameraPreviewView = this.f4346a.f4364i;
            if (!CameraPreviewView.f()) {
                this.f4346a.m4359a(false, false);
                if (this.f4346a.f4360d.m4257a()) {
                    CameraView.m4376k(this.f4346a);
                }
                this.f4346a.f4364i.a(new C04011(this), (File) Preconditions.checkNotNull(this.f4346a.f4358b.a("BackstageTemp", ".mp4", Privacy.REQUIRE_PRIVATE)));
            }
        }

        public final void mo148c() {
            CameraPreviewView cameraPreviewView = this.f4346a.f4364i;
            if (CameraPreviewView.f()) {
                HandlerDetour.a(this.f4346a.f4376u, this.f4346a.f4377v);
                this.f4346a.m4374j();
                this.f4346a.m4359a(false, false);
                if (this.f4346a.f4360d.m4257a()) {
                    this.f4346a.f4373r;
                }
                this.f4346a.f4364i.a(new C04022(this), new C04033(this));
            }
        }
    }

    /* compiled from: search_session_ended_by_user */
    class C04053 implements ToggleTextButtonListener {
        final /* synthetic */ CameraView f4347a;

        C04053(CameraView cameraView) {
            this.f4347a = cameraView;
        }

        public final void mo149a(boolean z) {
            CameraPreviewView cameraPreviewView = this.f4347a.f4364i;
            if (CameraPreviewView.f()) {
                this.f4347a.f4373r.setToggleState(!z);
            } else {
                CameraView.setFlash(this.f4347a, z);
            }
        }
    }

    /* compiled from: search_session_ended_by_user */
    class C04064 implements Runnable {
        final /* synthetic */ CameraView f4348a;

        C04064(CameraView cameraView) {
            this.f4348a = cameraView;
        }

        public void run() {
            this.f4348a.m4359a(true, false);
            this.f4348a.m4372i();
        }
    }

    /* compiled from: search_session_ended_by_user */
    class C04075 implements CameraInitialisedCallback {
        final /* synthetic */ CameraView f4349a;

        C04075(CameraView cameraView) {
            this.f4349a = cameraView;
        }

        public final void m4346a() {
            this.f4349a.f4380y = true;
            CameraPreviewView cameraPreviewView = this.f4349a.f4364i;
            if (!CameraPreviewView.e()) {
                this.f4349a.m4391d();
            }
            if (!CameraDevice.b.e()) {
                this.f4349a.f4379x.mo141a(this.f4349a.getResources().getString(2131239903));
                BLog.b(CameraView.f4356e, "Flash not ready.");
            } else if (this.f4349a.f4377v) {
                this.f4349a.f4373r.setVisibility(0);
                CameraView.setFlash(this.f4349a, CameraView.m4376k(this.f4349a));
                return;
            }
            this.f4349a.f4373r.setVisibility(4);
        }

        public final void m4347a(Exception exception) {
            this.f4349a.f4380y = true;
            this.f4349a.f4379x.mo141a(this.f4349a.getResources().getString(2131239904));
            BLog.b(CameraView.f4356e, "Failed to initialize the camera", exception);
        }
    }

    /* compiled from: search_session_ended_by_user */
    public class C04086 {
        final /* synthetic */ CameraView f4350a;

        C04086(CameraView cameraView) {
            this.f4350a = cameraView;
        }

        public final void m4348a() {
            if (this.f4350a.f4380y) {
                CameraPreviewView cameraPreviewView = this.f4350a.f4364i;
                if (!CameraPreviewView.e()) {
                    this.f4350a.m4391d();
                    return;
                }
            }
            this.f4350a.f4364i.c();
            this.f4350a.m4391d();
        }
    }

    /* compiled from: search_session_ended_by_user */
    public class C04097 {
        final /* synthetic */ CameraView f4351a;

        C04097(CameraView cameraView) {
            this.f4351a = cameraView;
        }

        public final void m4349a() {
            this.f4351a.m4390c();
        }
    }

    /* compiled from: search_session_ended_by_user */
    class C04108 implements FocusCallback {
        final /* synthetic */ CameraView f4352a;

        C04108(CameraView cameraView) {
            this.f4352a = cameraView;
        }

        public final void m4350a(FocusState focusState, Point point) {
            switch (AnonymousClass12.f4341a[focusState.ordinal()]) {
                case 1:
                    this.f4352a.f4365j.m4410a(point.x, point.y);
                    this.f4352a.f4365j.m4413d();
                    return;
                case 2:
                    this.f4352a.f4365j.m4409a();
                    return;
                case 3:
                    this.f4352a.f4365j.m4411b();
                    return;
                case 4:
                    this.f4352a.f4365j.m4412c();
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: search_session_ended_by_user */
    public class C04119 {
        final /* synthetic */ CameraView f4353a;

        C04119(CameraView cameraView) {
            this.f4353a = cameraView;
        }

        public final void m4351a(int i, int i2) {
            this.f4353a.f4366k.m4451a(i, i2);
        }
    }

    /* compiled from: search_session_ended_by_user */
    public class CameraViewOrientationListener extends OrientationEventListener {
        final /* synthetic */ CameraView f4354a;
        public int f4355b;

        public CameraViewOrientationListener(CameraView cameraView, Context context) {
            this.f4354a = cameraView;
            super(context, 3);
        }

        public void onOrientationChanged(int i) {
            this.f4355b = (Math.round(((float) i) / 90.0f) * 90) % 360;
        }

        public final int m4352a() {
            return this.f4355b;
        }
    }

    private static <T extends View> void m4357a(Class<T> cls, T t) {
        m4358a((Object) t, t.getContext());
    }

    private static void m4358a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((CameraView) obj).m4356a(QuickPerformanceLoggerMethodAutoProvider.a(fbInjector), TempFileManager.a(fbInjector), new LiveStatusPoller((MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(fbInjector)), BackstageGatekeepers.m4256b(fbInjector));
    }

    private void m4356a(QuickPerformanceLogger quickPerformanceLogger, TempFileManager tempFileManager, LiveStatusPoller liveStatusPoller, BackstageGatekeepers backstageGatekeepers) {
        this.f4357a = quickPerformanceLogger;
        this.f4358b = tempFileManager;
        this.f4359c = liveStatusPoller;
        this.f4360d = backstageGatekeepers;
    }

    public CameraView(Context context) {
        this(context, null);
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4361f = new C04001(this);
        this.f4362g = new C04042(this);
        this.f4363h = new C04053(this);
        this.f4376u = new Handler();
        this.f4377v = new C04064(this);
        m4357a(CameraView.class, (View) this);
        View.inflate(context, 2130903355, this);
        this.f4364i = (CameraPreviewView) findViewById(2131559845);
        this.f4365j = (FocusView) findViewById(2131559846);
        this.f4366k = (ZoomView) findViewById(2131559847);
        this.f4368m = (FrameLayout) findViewById(2131559851);
        this.f4367l = (LinearLayout) findViewById(2131559848);
        this.f4369n = (ImageView) findViewById(2131559852);
        this.f4370o = (ImageView) findViewById(2131559853);
        this.f4371p = (RotateButton) findViewById(2131559854);
        this.f4372q = (CaptureButton) findViewById(2131559850);
        this.f4373r = (ToggleTextButton) findViewById(2131559849);
        this.f4374s = (VideoRecordingProgressBar) findViewById(2131559856);
        this.f4375t = (LiveStatusView) findViewById(2131559855);
        this.f4359c.f4420c = this.f4375t;
        this.f4378w = new CameraViewOrientationListener(this, context);
        this.f4364i.u = new BackstageSizeSetter();
        m4390c();
        if (Camera.getNumberOfCameras() < 2) {
            this.f4371p.setVisibility(8);
        }
        this.f4364i.setCameraInitialisedCallback(new C04075(this));
        CameraPreviewView cameraPreviewView = this.f4364i;
        CameraDevice.b.r = new C04086(this);
        cameraPreviewView = this.f4364i;
        CameraDevice.b.s = new C04097(this);
        this.f4364i.setFocusCallbackListener(new C04108(this));
        cameraPreviewView = this.f4364i;
        CameraDevice.b.v = new C04119(this);
        this.f4364i.o = new PinchZoomListener(this) {
            final /* synthetic */ CameraView f4338a;

            {
                this.f4338a = r1;
            }

            public final void m4326a() {
                this.f4338a.f4366k.m4450a();
            }

            public final void m4327b() {
                this.f4338a.f4366k.m4452b();
            }
        };
        this.f4364i.setMediaOrientationLocked(true);
        this.f4371p.f5498b = this.f4361f;
        this.f4372q.f4400j = this.f4362g;
        this.f4373r.f5517a = this.f4363h;
    }

    public final boolean m4388a(MotionEvent motionEvent) {
        return motionEvent.getY() > this.f4367l.getY();
    }

    public void setListener(CameraViewListener cameraViewListener) {
        this.f4379x = cameraViewListener;
    }

    public final void m4387a() {
        CameraPreviewView.a();
    }

    public final void m4389b() {
        this.f4364i.c();
    }

    public void setSelfie(boolean z) {
        if (z && this.f4364i.getCameraFacing() != CameraFacing.FRONT) {
            this.f4364i.p = CameraFacing.FRONT;
        }
    }

    public static void setFlash(CameraView cameraView, boolean z) {
        if (m4376k(cameraView) != z) {
            cameraView.f4364i.setFlashMode(z ? "on" : "off");
        }
        if (z) {
            cameraView.f4373r.setBackgroundResource(2130839716);
        } else {
            cameraView.f4373r.setBackgroundResource(2130839717);
        }
    }

    public static boolean m4367f(CameraView cameraView) {
        return cameraView.f4364i.getFlashMode().equals("on");
    }

    public static boolean m4369g(CameraView cameraView) {
        List supportedFlashModes = cameraView.f4364i.getSupportedFlashModes();
        boolean z = (supportedFlashModes == null || supportedFlashModes.isEmpty()) ? false : true;
        if (z && supportedFlashModes.size() == 1 && ((String) supportedFlashModes.get(0)).equals("off")) {
            return false;
        }
        return z;
    }

    public static boolean m4371h(CameraView cameraView) {
        return cameraView.f4364i.getCameraFacing() == CameraFacing.FRONT;
    }

    private void m4359a(boolean z, boolean z2) {
        ToggleTextButton toggleTextButton;
        ToggleTextButton toggleTextButton2;
        int i;
        if (z) {
            this.f4368m.setVisibility(4);
            toggleTextButton = this.f4373r;
        } else {
            this.f4368m.setVisibility(0);
            toggleTextButton = this.f4373r;
            if (this.f4377v) {
                toggleTextButton2 = toggleTextButton;
                i = 0;
                toggleTextButton2.setVisibility(i);
                this.f4371p.setEnabled(z2);
                this.f4373r.setEnabled(z2);
            }
        }
        toggleTextButton2 = toggleTextButton;
        i = 4;
        toggleTextButton2.setVisibility(i);
        this.f4371p.setEnabled(z2);
        this.f4373r.setEnabled(z2);
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (!this.f4380y) {
            return;
        }
        if (i == 0) {
            m4389b();
        } else {
            CameraPreviewView.a();
        }
    }

    private void m4372i() {
        final long uptimeMillis = SystemClock.uptimeMillis();
        Runnable anonymousClass11 = new Runnable(this) {
            final /* synthetic */ CameraView f4340b;

            public void run() {
                this.f4340b.f4374s.setProgress(15000 - ((int) (SystemClock.uptimeMillis() - uptimeMillis)));
                CameraPreviewView cameraPreviewView = this.f4340b.f4364i;
                if (CameraPreviewView.f()) {
                    this.f4340b.f4374s.post(this);
                }
            }
        };
        this.f4374s.setProgress(15000);
        this.f4374s.setMax(15000);
        this.f4374s.post(anonymousClass11);
        float f = (float) (-this.f4374s.getHeight());
        ViewAnimator c = ViewAnimator.m5752a(this.f4374s).m5761e().m5757c(f, (float) this.f4374s.getTop());
        c.f5549z = 0;
        c.m5759d();
    }

    private void m4374j() {
        float top = (float) this.f4374s.getTop();
        ViewAnimator c = ViewAnimator.m5752a(this.f4374s).m5761e().m5757c(top, (float) (-this.f4374s.getHeight()));
        c.f5524A = 4;
        c.m5759d();
    }

    public final void m4390c() {
        this.f4371p.f5498b = null;
        this.f4372q.f4400j = null;
        this.f4372q.m4404a();
        this.f4373r.f5517a = null;
        this.f4364i.t = false;
        this.f4378w.disable();
    }

    public final void m4391d() {
        this.f4371p.f5498b = this.f4361f;
        this.f4372q.f4400j = this.f4362g;
        this.f4373r.f5517a = this.f4363h;
        this.f4364i.t = true;
        this.f4378w.enable();
    }

    public static void m4376k(CameraView cameraView) {
        LiveStatusPoller liveStatusPoller = cameraView.f4359c;
        DemoLiveStatusGenerator demoLiveStatusGenerator = liveStatusPoller.f4421d;
        demoLiveStatusGenerator.f4417f = demoLiveStatusGenerator.f4412a.f4422e.now();
        LiveStatusPoller.m4416c(liveStatusPoller, "VideoId");
        cameraView.f4375t.setVisibility(0);
    }

    public static void m4379l(CameraView cameraView) {
        LiveStatusPoller liveStatusPoller = cameraView.f4359c;
        liveStatusPoller.f4419b.removeCallbacksAndMessages(null);
        liveStatusPoller.f4421d.f4417f = 0;
        cameraView.f4375t.setVisibility(4);
    }
}
