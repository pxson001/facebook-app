package com.facebook.camera.utils;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera.Size;
import android.hardware.SensorEventListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.camera.CameraModule;
import com.facebook.camera.analytics.CameraFlowLogger;
import com.facebook.camera.analytics.CameraUsageData;
import com.facebook.camera.device.CameraHolder;
import com.facebook.camera.device.CameraHolder.CameraListener;
import com.facebook.camera.device.CameraHolder.PreviewAndPictureSize;
import com.facebook.camera.device.CameraPreview;
import com.facebook.camera.device.FocusManager.AutoFocusSource;
import com.facebook.camera.facetracking.FaceDetectionIndicatorView;
import com.facebook.camera.gating.CameraGating;
import com.facebook.camera.support.CameraSupport;
import com.facebook.camera.support.CameraSupport$TypedIntent;
import com.facebook.camera.support.CameraSupport$TypedIntent.IntentType;
import com.facebook.camera.support.DefaultCameraSupport;
import com.facebook.camera.utils.PhotoCapture.CaptureState;
import com.facebook.camera.views.CornerControl;
import com.facebook.camera.views.RotateLayout;
import com.facebook.camera.views.ShutterView;
import com.facebook.camera.views.ShutterView.ShutterAnimationListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.wakelock.FbWakeLockManager;
import com.facebook.common.wakelock.FbWakeLockManager.WakeLock;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.mediastorage.MediaStorage;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: analytics_tag */
public class CameraUIContainer implements CameraListener, ShutterAnimationListener {
    private static final Point f11005e = new Point(4, 3);
    private boolean f11006A = false;
    private float f11007B;
    public ObjectAnimator f11008C = null;
    public PhotoCaptureUpdater f11009D;
    private boolean f11010E;
    private boolean f11011F;
    private boolean f11012G;
    private long f11013H;
    private String f11014I;
    private int f11015J;
    private boolean f11016K = false;
    private int f11017L;
    private int f11018M;
    private int f11019N;
    private int f11020O;
    private int f11021P;
    private int f11022Q;
    private int f11023R;
    private int f11024S;
    private int f11025T;
    private int f11026U;
    private int f11027V;
    private int f11028W;
    public int f11029X = 1;
    public WakeLock f11030Y;
    public OrientationListener f11031Z;
    private final FbHandlerThreadFactory f11032a;
    private final FbWakeLockManager aa;
    public CameraFlowLogger ab;
    public CameraUsageData ac;
    private final DefaultCameraSupport ad;
    private final CameraGating ae;
    private final AbstractFbErrorReporter af;
    private final SecureContextHelper ag;
    private final DefaultAndroidThreadUtil ah;
    public final MediaStorage ai;
    private final Toaster aj;
    private final boolean ak;
    private final Provider<Boolean> al;
    private final Provider<Boolean> am;
    public Orientation an = Orientation.PORTRAIT;
    private Orientation ao = Orientation.PORTRAIT;
    public int ap = 0;
    public FbSharedPreferences aq;
    public CameraHolder ar;
    private boolean as = false;
    private boolean at = false;
    private boolean au = false;
    public boolean av = false;
    private Uri aw;
    private final OnTouchListener ax = new C10611(this);
    private final OnClickListener ay = new C10622(this);
    private final OnClickListener az = new C10633(this);
    public Class<?> f11033b;
    public Intent f11034c;
    public CameraUIContainerHolder f11035d;
    private View f11036f;
    private CameraPreview f11037g;
    private RelativeLayout f11038h;
    public RelativeLayout f11039i;
    public ImageView f11040j;
    private RotateLayout f11041k;
    public View f11042l;
    public View f11043m;
    public CornerControl f11044n;
    public CornerControl f11045o;
    private Rect f11046p;
    private RelativeLayout f11047q;
    private RelativeLayout f11048r;
    private RelativeLayout f11049s;
    private TextView f11050t;
    private TextView f11051u;
    private RotateLayout f11052v;
    private ImageView f11053w;
    private FaceDetectionIndicatorView f11054x;
    private ShutterView f11055y;
    private boolean f11056z = false;

    /* compiled from: analytics_tag */
    public interface CameraUIContainerHolder {
        void mo1129a(Uri uri);

        void mo1130a(List<Size> list, List<Size> list2, PreviewAndPictureSize previewAndPictureSize, Point point);

        void mo1131a(byte[] bArr, int i);

        void mo1132b(int i);

        void mo1133d(int i);

        Activity mo1134j();

        Context mo1135k();

        void mo1136l();
    }

    /* compiled from: analytics_tag */
    public /* synthetic */ class AnonymousClass11 {
        public static final /* synthetic */ int[] f10986a = new int[CaptureState.values().length];
        static final /* synthetic */ int[] f10987b = new int[AutoFocusSource.values().length];

        static {
            try {
                f10987b[AutoFocusSource.TOUCH_TO_FOCUS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10987b[AutoFocusSource.LAST_SECOND_AUTOFOCUS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f10987b[AutoFocusSource.FACE_DETECTION_AUTOFOCUS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f10986a[CaptureState.READY.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f10986a[CaptureState.QUEUED.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f10986a[CaptureState.CAPTURE_PENDING.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* compiled from: analytics_tag */
    class C10611 implements OnTouchListener {
        final /* synthetic */ CameraUIContainer f10988a;

        C10611(CameraUIContainer cameraUIContainer) {
            this.f10988a = cameraUIContainer;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f10988a.f11029X == 1 && this.f10988a.ar.f10868s) {
                MediaStorage mediaStorage = this.f10988a.ai;
                if (MediaStorage.b() && motionEvent.getAction() == 0) {
                    CameraHolder cameraHolder = this.f10988a.ar;
                    if (cameraHolder.f10863n != null) {
                        cameraHolder.f10863n.m18952a();
                    }
                }
            }
            return false;
        }
    }

    /* compiled from: analytics_tag */
    class C10622 implements OnClickListener {
        final /* synthetic */ CameraUIContainer f10989a;

        C10622(CameraUIContainer cameraUIContainer) {
            this.f10989a = cameraUIContainer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1447957540);
            CameraUIContainer.m19021x(this.f10989a);
            Logger.a(2, EntryType.UI_INPUT_END, -1174113567, a);
        }
    }

    /* compiled from: analytics_tag */
    class C10633 implements OnClickListener {
        final /* synthetic */ CameraUIContainer f10990a;

        C10633(CameraUIContainer cameraUIContainer) {
            this.f10990a = cameraUIContainer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 960692936);
            if (this.f10990a.f11029X != 2) {
                Logger.a(2, EntryType.UI_INPUT_END, 772115041, a);
            } else if (this.f10990a.ar.f10868s) {
                MediaStorage mediaStorage = this.f10990a.ai;
                if (MediaStorage.b()) {
                    if (this.f10990a.ar.f10860k) {
                        this.f10990a.ar.m18927i();
                        CameraUIContainer.m19012f(this.f10990a, false);
                    } else {
                        this.f10990a.ar.m18925g();
                        if (this.f10990a.ar.f10860k) {
                            CameraUIContainer.m19012f(this.f10990a, true);
                        } else {
                            CameraUIContainer.m19018u(this.f10990a);
                        }
                    }
                    LogUtils.a(-1694669369, a);
                    return;
                }
                CameraUIContainer.m19017t(this.f10990a);
                LogUtils.a(-1625102523, a);
            } else {
                LogUtils.a(1759683759, a);
            }
        }
    }

    /* compiled from: analytics_tag */
    class C10644 implements AnimatorListener {
        final /* synthetic */ CameraUIContainer f10991a;

        C10644(CameraUIContainer cameraUIContainer) {
            this.f10991a = cameraUIContainer;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f10991a.f11008C = null;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: analytics_tag */
    class C10655 implements OnClickListener {
        final /* synthetic */ CameraUIContainer f10992a;

        C10655(CameraUIContainer cameraUIContainer) {
            this.f10992a = cameraUIContainer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2117599022);
            if (this.f10992a.ar.f10868s) {
                this.f10992a.ar.m18923c();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -876007514, a);
        }
    }

    /* compiled from: analytics_tag */
    class C10666 implements OnTouchListener {
        final /* synthetic */ CameraUIContainer f10993a;

        C10666(CameraUIContainer cameraUIContainer) {
            this.f10993a = cameraUIContainer;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            CameraUIContainer.m19022y(this.f10993a);
            return true;
        }
    }

    /* compiled from: analytics_tag */
    class C10677 implements OnClickListener {
        final /* synthetic */ CameraUIContainer f10994a;

        C10677(CameraUIContainer cameraUIContainer) {
            this.f10994a = cameraUIContainer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 56481168);
            if (this.f10994a.f11029X == 1) {
                this.f10994a.f11029X = 2;
                this.f10994a.f11040j.setBackgroundResource(2130837952);
                this.f10994a.f11043m.setVisibility(0);
                this.f10994a.f11042l.setVisibility(8);
            } else {
                this.f10994a.f11029X = 1;
                this.f10994a.f11040j.setBackgroundResource(2130837946);
                this.f10994a.f11043m.setVisibility(8);
                this.f10994a.f11042l.setVisibility(0);
            }
            LogUtils.a(1967246213, a);
        }
    }

    /* compiled from: analytics_tag */
    class C10688 implements OnClickListener {
        final /* synthetic */ CameraUIContainer f10995a;

        C10688(CameraUIContainer cameraUIContainer) {
            this.f10995a = cameraUIContainer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -369745480);
            this.f10995a.m19049o();
            Logger.a(2, EntryType.UI_INPUT_END, -92405073, a);
        }
    }

    /* compiled from: analytics_tag */
    class C10699 implements OnClickListener {
        final /* synthetic */ CameraUIContainer f10996a;

        C10699(CameraUIContainer cameraUIContainer) {
            this.f10996a = cameraUIContainer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1452759549);
            this.f10996a.m19035b(1);
            CameraUIContainer.m19022y(this.f10996a);
            Logger.a(2, EntryType.UI_INPUT_END, -91746454, a);
        }
    }

    /* compiled from: analytics_tag */
    public class OrientationListener extends OrientationEventListener {
        final /* synthetic */ CameraUIContainer f10997a;
        private RotationMonitor f10998b;
        private boolean f10999c = false;
        private boolean f11000d = false;

        public OrientationListener(CameraUIContainer cameraUIContainer, Context context, int i) {
            this.f10997a = cameraUIContainer;
            super(context, i);
            this.f10998b = new RotationMonitor(context);
        }

        public void enable() {
            if (!this.f10999c) {
                super.enable();
                SensorEventListener sensorEventListener = this.f10998b;
                if (sensorEventListener.f11063d) {
                    sensorEventListener.f11060a.registerListener(sensorEventListener, sensorEventListener.f11061b, 2);
                    sensorEventListener.f11060a.registerListener(sensorEventListener, sensorEventListener.f11062c, 2);
                }
                this.f10999c = true;
                Class cls = this.f10997a.f11033b;
            }
        }

        public void disable() {
            if (this.f10999c) {
                super.disable();
                SensorEventListener sensorEventListener = this.f10998b;
                if (sensorEventListener.f11063d) {
                    sensorEventListener.f11060a.unregisterListener(sensorEventListener);
                }
                this.f10999c = false;
                Class cls = this.f10997a.f11033b;
            }
        }

        public final void m18993a(boolean z) {
            if (this.f11000d != z) {
                this.f11000d = z;
                m18992a();
            }
        }

        public final void m18992a() {
            Object obj;
            if (this.f11000d && this.f10997a.f11009D.f11003c == CaptureState.READY) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                enable();
            } else {
                disable();
            }
        }

        public void onOrientationChanged(int i) {
            Orientation orientation;
            int i2 = ((((this.f10997a.ap + i) + 360) + 45) % 360) - 45;
            if (i2 <= 45) {
                orientation = Orientation.PORTRAIT;
            } else if (i2 <= 135) {
                orientation = Orientation.REVERSE_LANDSCAPE;
                i2 -= 90;
            } else if (i2 <= 225) {
                orientation = Orientation.REVERSE_PORTRAIT;
                i2 -= 180;
            } else {
                orientation = Orientation.LANDSCAPE;
                i2 -= 270;
            }
            if (orientation != this.f10997a.an && Math.abs(r1) <= 40) {
                Object obj;
                RotationMonitor rotationMonitor = this.f10998b;
                if (SystemClock.uptimeMillis() >= rotationMonitor.f11071l + 500 || Math.abs(rotationMonitor.f11069j) >= 45.0f || Math.abs(rotationMonitor.f11070k) >= 45.0f) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    this.f10997a.an = orientation;
                    CameraUIContainer.m19008b(this.f10997a, this.f10997a.an);
                    this.f10997a.ab.mo1151b(this.f10997a.an);
                }
            }
        }
    }

    /* compiled from: analytics_tag */
    class PhotoCaptureUpdater extends PhotoCapture {
        final /* synthetic */ CameraUIContainer f11004a;

        public PhotoCaptureUpdater(CameraUIContainer cameraUIContainer, AbstractFbErrorReporter abstractFbErrorReporter) {
            this.f11004a = cameraUIContainer;
            super(abstractFbErrorReporter);
        }

        protected final void mo1160a(CaptureState captureState) {
            CameraUIContainer cameraUIContainer = this.f11004a;
            switch (AnonymousClass11.f10986a[captureState.ordinal()]) {
                case 1:
                    cameraUIContainer.f11042l.setClickable(true);
                    cameraUIContainer.f11039i.setClickable(true);
                    cameraUIContainer.f11042l.setAlpha(1.0f);
                    cameraUIContainer.f11043m.setAlpha(1.0f);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    cameraUIContainer.f11042l.setClickable(false);
                    cameraUIContainer.f11039i.setClickable(false);
                    cameraUIContainer.f11042l.setAlpha(0.5f);
                    cameraUIContainer.f11043m.setAlpha(0.5f);
                    break;
                case 3:
                    cameraUIContainer.f11042l.setClickable(false);
                    cameraUIContainer.f11039i.setClickable(false);
                    cameraUIContainer.f11042l.setAlpha(0.5f);
                    cameraUIContainer.f11043m.setAlpha(0.5f);
                    break;
            }
            cameraUIContainer.f11031Z.m18992a();
        }
    }

    public static CameraUIContainer m19007b(InjectorLike injectorLike) {
        return new CameraUIContainer(CameraGating.m18983b(injectorLike), DefaultCameraSupport.m18990a(injectorLike), MediaStorage.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), FbHandlerThreadFactory.a(injectorLike), Toaster.b(injectorLike), CameraModule.m18804a(), IdBasedProvider.a(injectorLike, 3911), IdBasedProvider.a(injectorLike, 3913), FbWakeLockManager.a(injectorLike));
    }

    @Inject
    public CameraUIContainer(CameraGating cameraGating, CameraSupport cameraSupport, MediaStorage mediaStorage, FbErrorReporter fbErrorReporter, SecureContextHelper secureContextHelper, AndroidThreadUtil androidThreadUtil, FbSharedPreferences fbSharedPreferences, FbHandlerThreadFactory fbHandlerThreadFactory, Toaster toaster, Boolean bool, Provider<Boolean> provider, Provider<Boolean> provider2, FbWakeLockManager fbWakeLockManager) {
        this.ae = cameraGating;
        this.ad = cameraSupport;
        this.ai = mediaStorage;
        this.af = fbErrorReporter;
        this.ag = secureContextHelper;
        this.ah = androidThreadUtil;
        this.aq = fbSharedPreferences;
        this.f11032a = fbHandlerThreadFactory;
        this.aj = toaster;
        this.ak = bool.booleanValue();
        this.al = provider;
        this.am = provider2;
        this.aa = fbWakeLockManager;
    }

    private Activity m19013p() {
        return this.f11035d.mo1134j();
    }

    private Context m19014q() {
        return this.f11035d.mo1135k();
    }

    public final void m19040c(boolean z) {
        this.ab.mo1153b(z);
        this.as = z;
        m19015r();
    }

    public final void m19046i() {
        CameraUsageData cameraUsageData = this.ac;
        cameraUsageData.f10796f = true;
        cameraUsageData.f10797g = CameraUsageData.m18854m();
        this.f11009D.m18996b();
        this.at = true;
        m19015r();
    }

    public final void m19047j() {
        CameraUsageData cameraUsageData = this.ac;
        cameraUsageData.f10796f = false;
        cameraUsageData.f10795e += CameraUsageData.m18854m() - cameraUsageData.f10797g;
        this.at = false;
        m19015r();
    }

    private void m19015r() {
        int i = 0;
        boolean z = this.au;
        if (this.as && this.at) {
            if (!(this.au || this.av)) {
                this.ar.m18928j();
                this.ar.m18919a(m19013p());
                this.au = true;
                this.f11030Y.a(180000);
                if (!this.f11006A) {
                    boolean booleanValue = ((Boolean) this.al.get()).booleanValue();
                    Activity p = m19013p();
                    View view = this.f11036f;
                    RelativeLayout relativeLayout = this.f11038h;
                    RelativeLayout relativeLayout2 = this.f11047q;
                    Point point = f11005e;
                    Rect rect = this.f11046p;
                    if (!booleanValue) {
                        i = 10;
                    }
                    this.f11006A = CameraUtils.m19058a(p, view, relativeLayout, relativeLayout2, point, rect, 20, i, 20);
                    BLog.a(this.f11033b, "Preview resized " + this.f11006A);
                }
            }
            this.f11031Z.m18993a(true);
        } else {
            if (this.au) {
                if (this.ar.f10860k) {
                    this.ar.m18926h();
                    m19012f(this, false);
                }
                this.ar.m18930l();
                this.f11030Y.d();
                this.au = false;
            }
            this.f11031Z.m18993a(false);
        }
        new StringBuilder("updatePreviewState ").append(z).append(" -> ").append(this.au);
    }

    @DoNotStrip
    public void setIconsRotationAngle(float f) {
        this.f11007B = f;
        this.f11042l.setRotation(this.f11007B);
        this.f11040j.setRotation(this.f11007B);
        this.f11053w.setRotation(this.f11007B);
    }

    private void m19005a(float f, int i) {
        float a = CameraUtils.m19050a(this.f11007B, f);
        if (this.f11008C != null) {
            this.f11008C.cancel();
        }
        this.f11042l.setPivotX((float) (this.f11042l.getWidth() / 2));
        this.f11042l.setPivotY((float) (this.f11042l.getHeight() / 2));
        this.f11040j.setPivotX((float) (this.f11040j.getWidth() / 2));
        this.f11040j.setPivotY((float) (this.f11040j.getHeight() / 2));
        this.f11053w.setPivotX((float) (this.f11053w.getWidth() / 2));
        this.f11053w.setPivotY((float) (this.f11053w.getHeight() / 2));
        if (this.f11007B != a) {
            this.f11008C = ObjectAnimator.ofFloat(this, "IconsRotationAngle", new float[]{this.f11007B, a});
            this.f11008C.setDuration((long) i);
            this.f11008C.addListener(new C10644(this));
            this.f11008C.start();
            return;
        }
        setIconsRotationAngle(a);
    }

    private float m19004a(Orientation orientation) {
        return (float) ((orientation.mRotation + this.ao.mReverseRotation) - 90);
    }

    private float m19016s() {
        return m19004a(this.an);
    }

    public static void m19008b(CameraUIContainer cameraUIContainer, Orientation orientation) {
        float a = cameraUIContainer.m19004a(orientation);
        cameraUIContainer.m19005a(a, 400);
        CameraUtils.m19057a(cameraUIContainer.ao, orientation, cameraUIContainer.f11044n, cameraUIContainer.f11045o);
        cameraUIContainer.f11044n.m19062a(a, cameraUIContainer.ar.m18932n());
        cameraUIContainer.f11045o.m19062a(a, cameraUIContainer.ar.m18922b());
        cameraUIContainer.f11052v.setOrientation((int) a);
    }

    private void m19010d(boolean z) {
        this.f11044n.m19062a(m19016s(), z);
    }

    private void m19011e(boolean z) {
        this.f11045o.m19062a(m19016s(), z);
    }

    public static void m19017t(CameraUIContainer cameraUIContainer) {
        Toast.makeText(cameraUIContainer.m19014q(), 2131234293, 0).show();
    }

    public static void m19018u(CameraUIContainer cameraUIContainer) {
        Toast.makeText(cameraUIContainer.m19014q(), 2131234294, 1).show();
    }

    private void m19019v() {
        Toast.makeText(m19014q(), 2131234295, 1).show();
    }

    private void m19020w() {
        this.f11038h = (RelativeLayout) this.f11036f.findViewById(2131559845);
        this.f11044n = new CornerControl(this.f11038h.findViewById(2131560160), this.f11046p);
        this.f11045o = new CornerControl(this.f11038h.findViewById(2131560161), this.f11046p);
        this.f11055y = (ShutterView) this.f11038h.findViewById(2131560162);
        this.f11041k = (RotateLayout) this.f11038h.findViewById(2131562104);
        this.f11047q = (RelativeLayout) this.f11036f.findViewById(2131560159);
        this.f11042l = this.f11047q.findViewById(2131560166);
        this.f11043m = this.f11047q.findViewById(2131560167);
        this.f11048r = (RelativeLayout) this.f11047q.findViewById(2131560163);
        this.f11053w = (ImageView) this.f11048r.findViewById(2131560164);
        this.f11039i = (RelativeLayout) this.f11047q.findViewById(2131560168);
        this.f11040j = (ImageView) this.f11039i.findViewById(2131560169);
        this.f11049s = (RelativeLayout) this.f11036f.findViewById(2131560170);
        this.f11052v = (RotateLayout) this.f11049s.findViewById(2131560171);
        this.f11050t = (TextView) this.f11052v.findViewById(2131560173);
        this.f11051u = (TextView) this.f11052v.findViewById(2131560174);
        this.f11054x = null;
    }

    public final int m19024a(Bundle bundle) {
        String stringExtra = this.f11034c.getStringExtra("source_activity");
        if (stringExtra == null) {
            stringExtra = "<unspecified>";
        }
        this.ab.mo1142a(bundle, stringExtra);
        this.ac = new CameraUsageData(stringExtra);
        this.f11009D = new PhotoCaptureUpdater(this, this.af);
        int a = SizeUtil.a(m19013p().getResources(), 10.0f);
        this.f11046p = new Rect(a, a, a, a);
        CameraOrientation cameraOrientation = new CameraOrientation(m19013p(), ((Boolean) this.am.get()).booleanValue(), this.f11033b);
        this.ao = cameraOrientation.f10981b;
        this.an = cameraOrientation.f10980a;
        this.ap = cameraOrientation.f10982c;
        this.f11035d.mo1132b(cameraOrientation.f10984e);
        this.ab.mo1145a(this.ao);
        this.ab.mo1151b(this.an);
        return cameraOrientation.f10983d;
    }

    @TargetApi(9)
    public final void m19028a(View view) {
        this.f11036f = view;
        Context p = m19013p();
        m19020w();
        CameraUtils.m19057a(this.ao, this.an, this.f11044n, this.f11045o);
        this.f11015J = this.f11034c.getIntExtra("desired_initial_facing", 0);
        this.f11017L = this.f11034c.getIntExtra("video_profile", 1);
        this.f11018M = this.f11034c.getIntExtra("video_max_duration", -1);
        this.f11019N = this.f11034c.getIntExtra("video_format", -1);
        this.f11020O = this.f11034c.getIntExtra("video_codec", -1);
        this.f11021P = this.f11034c.getIntExtra("video_width", -1);
        this.f11022Q = this.f11034c.getIntExtra("video_height", -1);
        this.f11023R = this.f11034c.getIntExtra("video_frame", -1);
        this.f11024S = this.f11034c.getIntExtra("video_bit_rate", -1);
        this.f11025T = this.f11034c.getIntExtra("audio_codec", -1);
        this.f11026U = this.f11034c.getIntExtra("audio_sample_rate", -1);
        this.f11027V = this.f11034c.getIntExtra("audio_bit_rate", -1);
        this.f11028W = this.f11034c.getIntExtra("audio_channels", -1);
        this.ar = new CameraHolder(this, p, this.aq, this.ab, this.ai, this.ae, this.ah, this.f11032a, this.af, this.f11017L, this.f11018M, this.f11019N, this.f11020O, this.f11021P, this.f11022Q, this.f11023R, this.f11024S, this.f11025T, this.f11026U, this.f11027V, this.f11028W);
        this.f11031Z = new OrientationListener(this, p, 2);
        this.ar.m18924e();
        this.f11010E = this.f11034c.getBooleanExtra("extra_no_composer", false);
        this.f11011F = this.f11034c.getBooleanExtra("show_profile_crop_overlay", false);
        this.f11013H = this.f11034c.getLongExtra("extra_target_id", -1);
        this.f11014I = this.f11034c.getStringExtra("publisher_type");
        this.f11012G = this.f11034c.getBooleanExtra("extra_disable_video", false);
        this.f11016K = this.f11034c.getBooleanExtra("fire_review_after_snap", false);
        this.f11044n.m19064a(this.ar.m18931m());
        this.f11048r.setVisibility(8);
        if (this.f11011F && m19023z() <= 0.6f) {
            this.f11038h.addView(((LayoutInflater) m19014q().getApplicationContext().getSystemService("layout_inflater")).inflate(2130903493, null), 0, new LayoutParams(-1, -1));
        }
        if (this.ar.m18922b()) {
            this.f11045o.m19063a(new C10655(this));
        } else {
            m19011e(false);
        }
        this.f11049s.setOnTouchListener(new C10666(this));
        this.f11042l.setOnTouchListener(this.ax);
        this.f11042l.setOnClickListener(this.ay);
        this.f11043m.setOnClickListener(this.az);
        this.f11040j.setClickable(false);
        this.f11043m.setVisibility(8);
        this.f11042l.setVisibility(0);
        if (this.f11012G) {
            this.f11039i.setVisibility(4);
        } else if (this.ak) {
            this.f11039i.setOnClickListener(new C10677(this));
        } else {
            this.f11039i.setOnClickListener(new C10688(this));
        }
        this.f11050t.setOnClickListener(new C10699(this));
        this.f11051u.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CameraUIContainer f10985a;

            {
                this.f10985a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 348405819);
                this.f10985a.m19035b(2);
                CameraUIContainer.m19022y(this.f10985a);
                Logger.a(2, EntryType.UI_INPUT_END, 1278025899, a);
            }
        });
        this.f11030Y = this.aa.a(10, "Camera");
        this.f11030Y.a(false);
    }

    public final void mo1166a(List<Size> list, List<Size> list2, PreviewAndPictureSize previewAndPictureSize) {
        this.f11035d.mo1130a(list, list2, previewAndPictureSize, f11005e);
    }

    public static void m19021x(CameraUIContainer cameraUIContainer) {
        if (cameraUIContainer.f11029X != 1 || !cameraUIContainer.f11009D.m18997c()) {
            return;
        }
        if (!cameraUIContainer.ar.f10868s) {
            cameraUIContainer.f11009D.m18998d();
        } else if (MediaStorage.b()) {
            boolean b;
            CameraHolder cameraHolder = cameraUIContainer.ar;
            if (cameraHolder.f10863n != null) {
                b = cameraHolder.f10863n.m18957b();
            } else {
                b = false;
            }
            if (b) {
                cameraUIContainer.f11009D.m18999e();
                cameraUIContainer.f11031Z.m18993a(false);
                return;
            }
            BLog.a(cameraUIContainer.f11033b, "takeOrQueuePictureTaking denied by CameraHolder");
        } else {
            m19017t(cameraUIContainer);
        }
    }

    public static void m19012f(CameraUIContainer cameraUIContainer, boolean z) {
        boolean z2;
        boolean z3 = true;
        if (z) {
            cameraUIContainer.f11043m.setBackgroundResource(2130837969);
        } else {
            cameraUIContainer.f11043m.setBackgroundResource(2130837970);
        }
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        cameraUIContainer.m19011e(z2);
        CornerControl cornerControl = cameraUIContainer.f11045o;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        cornerControl.f11075a.setClickable(z2);
        RelativeLayout relativeLayout = cameraUIContainer.f11039i;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        relativeLayout.setClickable(z2);
        RelativeLayout relativeLayout2 = cameraUIContainer.f11048r;
        if (z) {
            z3 = false;
        }
        relativeLayout2.setClickable(z3);
    }

    public static boolean m19022y(CameraUIContainer cameraUIContainer) {
        if (cameraUIContainer.f11049s.getVisibility() != 0) {
            return false;
        }
        cameraUIContainer.f11049s.startAnimation(AnimationUtils.loadAnimation(cameraUIContainer.m19014q(), 2130968634));
        cameraUIContainer.f11049s.setVisibility(8);
        cameraUIContainer.f11009D.m18996b();
        return true;
    }

    public final void mo1164a(CameraPreview cameraPreview) {
        this.f11038h.addView(cameraPreview, 0);
        this.f11037g = cameraPreview;
    }

    public final void mo1167a(boolean z) {
        if (z) {
            this.ab.mo1137a();
            if (!this.f11056z) {
                this.f11044n.m19061a();
                this.f11045o.m19061a();
                m19005a(m19016s(), 0);
                this.f11056z = true;
            }
            if (this.ar.m18922b() && !this.ar.f10860k) {
                m19011e(true);
            }
            if (this.ar.m18932n()) {
                m19010d(true);
            }
            this.f11041k.setVisibility(0);
            this.f11031Z.m18993a(true);
            if (this.f11009D.f11003c == CaptureState.QUEUED) {
                m19021x(this);
                return;
            }
            return;
        }
        this.f11035d.mo1136l();
    }

    public final void mo1162a() {
        m19010d(false);
        m19011e(false);
        this.f11041k.setVisibility(4);
        if (this.f11037g != null) {
            this.f11038h.removeView(this.f11037g);
            this.f11037g = null;
        }
        this.f11031Z.m18993a(false);
    }

    public final void mo1165a(AutoFocusSource autoFocusSource) {
        CameraUsageData cameraUsageData;
        switch (AnonymousClass11.f10987b[autoFocusSource.ordinal()]) {
            case 1:
                cameraUsageData = this.ac;
                cameraUsageData.f10792b++;
                return;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                cameraUsageData = this.ac;
                cameraUsageData.f10793c++;
                return;
            case 3:
                cameraUsageData = this.ac;
                cameraUsageData.f10794d++;
                return;
            default:
                return;
        }
    }

    public final void mo1169b() {
        this.f11055y.m19075a(this);
    }

    public final void mo1179n() {
        this.f11009D.m19000f();
    }

    public final void mo1168a(byte[] bArr, int i) {
        CameraUsageData cameraUsageData = this.ac;
        cameraUsageData.f10791a++;
        this.ab.mo1144a(this.ac, bArr.length);
        this.f11035d.mo1131a(bArr, i);
        if (this.f11016K) {
            m19006a(null, 1);
            return;
        }
        this.f11035d.mo1133d(5);
        if (this.ar.m18929k()) {
            mo1167a(true);
        }
    }

    public final void mo1163a(Uri uri) {
        if (uri == null) {
            m19019v();
        } else if (this.f11016K) {
            m19006a(uri, 2);
        } else {
            this.f11035d.mo1133d(6);
        }
    }

    public final void mo1170b(Uri uri) {
        m19014q().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + uri.getPath())));
    }

    public final void mo1173c(Uri uri) {
        this.f11035d.mo1129a(uri);
    }

    public final RotateLayout mo1172c() {
        return this.f11041k;
    }

    public final FaceDetectionIndicatorView mo1178h() {
        return this.f11054x;
    }

    public final void C_(int i) {
        this.f11044n.f11075a.setBackgroundResource(i);
    }

    public final void mo1171b(boolean z) {
        m19010d(z);
    }

    public final int mo1174d() {
        return this.f11015J;
    }

    public final Orientation mo1175e() {
        return this.an;
    }

    public final Orientation mo1176f() {
        return this.ao;
    }

    public final int mo1177g() {
        return this.ap;
    }

    @TargetApi(13)
    private float m19023z() {
        int i;
        int i2;
        WindowManager windowManager = m19013p().getWindowManager();
        if (VERSION.SDK_INT >= 13) {
            Point point = new Point();
            windowManager.getDefaultDisplay().getSize(point);
            i = point.x;
            i2 = point.y;
        } else {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            i = defaultDisplay.getWidth();
            i2 = defaultDisplay.getHeight();
        }
        return ((float) Math.min(i, i2)) / ((float) Math.max(i, i2));
    }

    public final void m19026a(int i, int i2, Intent intent) {
        Context p = m19013p();
        this.av = false;
        if (i == 1338) {
            this.av = true;
            switch (i2) {
                case 0:
                    p.finish();
                    return;
                case 1:
                    m19035b(2);
                    return;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    m19035b(1);
                    return;
                case 3:
                    m19049o();
                    return;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    m19003A();
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
        } else {
            if (i == 1332) {
                this.av = true;
                if (intent == null) {
                    intent = new Intent();
                }
                intent.putExtra("mediaContentType", 2);
                p.setResult(i2, intent);
                p.finish();
            } else if (i == 1334) {
                if (i2 != 4) {
                    this.av = true;
                    p.setResult(i2, intent);
                    p.finish();
                }
            } else if (i == 1335) {
                this.av = true;
                String type = p.getContentResolver().getType(intent.getData());
                if (type == null) {
                    this.av = false;
                    return;
                }
                int i3;
                Uri parse;
                boolean z;
                if (type.startsWith("image/")) {
                    this.ab.mo1140a(intent.getData());
                    String a = MediaStorage.a(intent.getData(), p.getContentResolver());
                    if (a != null) {
                        i3 = 1;
                        parse = Uri.parse("file://" + a);
                        z = false;
                    } else {
                        z = true;
                        parse = null;
                        i3 = 1;
                    }
                } else if (type.startsWith("video/")) {
                    this.ab.mo1150b(intent.getData());
                    type = MediaStorage.b(intent.getData(), p.getContentResolver());
                    if (type != null) {
                        parse = Uri.parse("file://" + type);
                        i3 = 2;
                        z = false;
                    } else {
                        parse = null;
                        i3 = 2;
                        z = true;
                    }
                } else {
                    this.af.a(this.f11033b.getSimpleName(), "unknown content type:" + type);
                    z = false;
                    parse = null;
                    i3 = 0;
                }
                if (z) {
                    this.av = false;
                    Toast.makeText(p, 2131234298, 1).show();
                } else if (parse == null) {
                    this.av = false;
                    Toast.makeText(p, 2131234299, 1).show();
                } else {
                    new StringBuilder("URI: ").append(parse.toString());
                    m19006a(parse, i3);
                }
            } else if (i == 1336) {
                this.av = true;
                Uri data = intent.getData();
                this.ab.mo1149a(true);
                if (data != null) {
                    m19009d(data);
                }
            } else if (i == 1339) {
                this.av = true;
                if (this.f11010E) {
                    Intent intent2 = new Intent();
                    intent2.setData(this.aw);
                    p.setResult(1, intent2);
                    p.finish();
                    return;
                }
                m19006a(this.aw, 1);
            } else if (i == 1340) {
                this.av = true;
                p.setResult(i2, intent);
                p.finish();
            }
        }
    }

    private void m19006a(Uri uri, int i) {
        DefaultCameraSupport defaultCameraSupport = this.ad;
        Intent intent = null;
        if (intent != null) {
            this.ab.mo1139a(intent);
            intent.putExtra("publisher_type", this.f11034c.getStringExtra("publisher_type"));
            this.ag.a(intent, 1334, m19013p());
            return;
        }
        BLog.a(this.f11033b, "no ReviewActivity intent could be created");
    }

    private void m19009d(Uri uri) {
        Context p = m19013p();
        if (this.f11010E) {
            Intent intent = new Intent();
            this.ab.mo1139a(intent);
            intent.putExtra("mediaContentType", 2);
            intent.setData(uri);
            p.setResult(-1, intent);
            p.finish();
            return;
        }
        DefaultCameraSupport defaultCameraSupport = this.ad;
        PackageManager packageManager = p.getPackageManager();
        Intent type = new Intent().setAction("android.intent.action.PICK").setType("image/*");
        ComponentName resolveActivity = type.resolveActivity(packageManager);
        if (resolveActivity != null) {
            type = packageManager.getLaunchIntentForPackage(resolveActivity.getPackageName());
            if (type == null) {
                type = new Intent().setComponent(resolveActivity).setAction("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER");
            }
        }
        type.addFlags(268435456);
        CameraSupport$TypedIntent cameraSupport$TypedIntent = new CameraSupport$TypedIntent(type, IntentType.EXTERNAL);
        intent = cameraSupport$TypedIntent != null ? cameraSupport$TypedIntent.f10974a : null;
        if (intent == null) {
            BLog.a(this.f11033b, "no ComposerForVideo intent could be created");
        } else if (cameraSupport$TypedIntent.f10975b == IntentType.INTERNAL) {
            this.ab.mo1146a("launching_composer_for_video");
            this.ab.mo1139a(intent);
            this.ag.a(intent, 1332, p);
        } else {
            this.ag.b(intent, p);
        }
    }

    public final void m19035b(int i) {
        Intent intent = new Intent("android.intent.action.PICK");
        if (i == 1) {
            intent.setType("image/*");
        } else if (i == 2) {
            intent.setType("video/*");
        } else {
            return;
        }
        this.ag.b(intent, 1335, m19013p());
    }

    private void m19003A() {
        try {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            this.aw = this.ai.c();
            intent.putExtra("output", this.aw);
            this.ag.b(intent, 1339, m19013p());
        } catch (ActivityNotFoundException e) {
            this.aj.b(new ToastBuilder(2131234296).a(17));
        }
    }

    public final void m19049o() {
        try {
            this.ab.mo1146a("launching_video_recorder");
            this.ag.b(new Intent("android.media.action.VIDEO_CAPTURE"), 1336, m19013p());
        } catch (ActivityNotFoundException e) {
            this.aj.b(new ToastBuilder(2131234297).a(17));
        }
    }
}
