package com.facebook.optic;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera.Area;
import android.hardware.Camera.Size;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.ViewParent;
import android.view.WindowManager;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.optic.CameraDevice.AnonymousClass10;
import com.facebook.optic.CameraDevice.AnonymousClass12;
import com.facebook.optic.CameraDevice.AnonymousClass13;
import com.facebook.optic.CameraDevice.AnonymousClass15;
import com.facebook.optic.CameraDevice.C01871;
import com.facebook.optic.CameraDevice.C01925;
import com.facebook.optic.CameraDevice.C01936;
import com.facebook.optic.CameraDevice.C01947;
import com.facebook.optic.CameraDevice.C01978;
import com.facebook.optic.CameraDevice.C01989;
import com.facebook.optic.CameraDevice.CameraDeviceBusyException;
import com.facebook.optic.CameraDevice.CameraFacing;
import com.facebook.optic.CameraDevice.CaptureQuality;
import com.facebook.optic.util.ThreadUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: targetName */
public class CameraPreviewView extends TextureView implements SurfaceTextureListener {
    public static final String f3312a = CameraPreviewView.class.getSimpleName();
    public int f3313b;
    public int f3314c;
    private CaptureQuality f3315d;
    private CaptureQuality f3316e;
    public boolean f3317f;
    private OrientationEventListener f3318g;
    public int f3319h;
    private int f3320i;
    private boolean f3321j;
    private OnSurfaceTextureUpdatedListener f3322k;
    public CameraInitialisedCallback f3323l;
    private GestureDetector f3324m;
    private ScaleGestureDetector f3325n;
    public PinchZoomListener f3326o;
    public CameraFacing f3327p;
    public Matrix f3328q;
    public boolean f3329r;
    public boolean f3330s;
    public boolean f3331t;
    public DefaultSizeSetter f3332u;

    /* compiled from: targetName */
    class C02012 implements Callback<Size> {
        final /* synthetic */ CameraPreviewView f3297a;

        C02012(CameraPreviewView cameraPreviewView) {
            this.f3297a = cameraPreviewView;
        }

        public final void mo209a(Object obj) {
            Size size = (Size) obj;
            Log.d(CameraPreviewView.f3312a, "Started camera preview " + size.width + " x " + size.height);
            this.f3297a.m4366a(this.f3297a.f3313b, this.f3297a.f3314c, size.width, size.height);
            synchronized (this) {
                if (this.f3297a.f3323l != null) {
                    this.f3297a.f3323l.m4359a();
                }
            }
        }

        public final void mo208a(Exception exception) {
            synchronized (this) {
                if (this.f3297a.f3323l != null) {
                    this.f3297a.f3323l.m4360a(exception);
                }
            }
            Log.e(CameraPreviewView.f3312a, exception.getMessage(), exception);
        }
    }

    /* compiled from: targetName */
    public interface FocusCallback {

        /* compiled from: targetName */
        public enum FocusState {
            FOCUSSING,
            CANCELLED,
            SUCCESS,
            FAILED
        }

        void mo212a(FocusState focusState, Point point);
    }

    /* compiled from: targetName */
    class CameraGestureDetector extends SimpleOnGestureListener {
        final /* synthetic */ CameraPreviewView f3307a;

        public CameraGestureDetector(CameraPreviewView cameraPreviewView) {
            this.f3307a = cameraPreviewView;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return true;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (!this.f3307a.f3329r && !this.f3307a.f3330s) {
                return false;
            }
            if (!CameraPreviewView.m4384g() && !CameraPreviewView.m4387h()) {
                return false;
            }
            CameraDevice cameraDevice = CameraDevice.f3256b;
            if (!cameraDevice.m4295f() || cameraDevice.f3273m || this.f3307a.f3328q == null) {
                return false;
            }
            boolean z;
            float[] fArr = new float[]{motionEvent.getX(), motionEvent.getY()};
            this.f3307a.f3328q.mapPoints(fArr);
            if (this.f3307a.f3329r && CameraPreviewView.m4384g()) {
                int i = (int) fArr[0];
                int i2 = (int) fArr[1];
                if (cameraDevice.m4294e()) {
                    Rect rect = new Rect(i, i2, i, i2);
                    rect.inset(-30, -30);
                    rect.intersect(-1000, -1000, 1000, 1000);
                    List arrayList = new ArrayList();
                    arrayList.add(new Area(rect, 1000));
                    CameraFeatures a = CameraFeatures.m4308a(cameraDevice.f3264d, CameraDevice.m4272b(cameraDevice.f3269i));
                    a.m4316a(arrayList);
                    if (!cameraDevice.f3283w) {
                        cameraDevice.f3284x = a.m4339q();
                    }
                    a.m4321b("auto");
                    CameraDevice.m4274c(cameraDevice, false);
                    if (cameraDevice.f3280t != null) {
                        cameraDevice.f3280t.mo212a(FocusState.CANCELLED, null);
                        cameraDevice.f3280t.mo212a(FocusState.FOCUSSING, new Point(i, i2));
                    }
                    if (cameraDevice.f3285y != null) {
                        HandlerDetour.a(ThreadUtil.f3354e, cameraDevice.f3285y);
                    }
                    if (cameraDevice.f3283w) {
                        cameraDevice.f3264d.cancelAutoFocus();
                        cameraDevice.f3283w = false;
                    }
                    cameraDevice.f3283w = true;
                    cameraDevice.f3264d.autoFocus(new C01925(cameraDevice, i, i2, a));
                }
                z = true;
            } else {
                z = false;
            }
            if (this.f3307a.f3330s && CameraPreviewView.m4387h()) {
                cameraDevice.m4285a((int) fArr[0], (int) fArr[1]);
                z = true;
            }
            return z;
        }
    }

    /* compiled from: targetName */
    public interface CameraInitialisedCallback {
        void m4359a();

        void m4360a(Exception exception);
    }

    /* compiled from: targetName */
    class CameraZoomGestureDetector extends SimpleOnScaleGestureListener {
        final /* synthetic */ CameraPreviewView f3308a;
        private int f3309b;
        private int f3310c;
        private float f3311d;

        public CameraZoomGestureDetector(CameraPreviewView cameraPreviewView) {
            this.f3308a = cameraPreviewView;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            if (CameraDevice.f3256b.f3273m || !this.f3308a.f3317f || !CameraDevice.f3256b.m4303p()) {
                return false;
            }
            ViewParent parent = this.f3308a.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            this.f3309b = CameraDevice.f3256b.m4304q();
            this.f3310c = CameraDevice.f3256b.m4305r();
            this.f3311d = scaleGestureDetector.getCurrentSpan();
            if (this.f3308a.f3326o != null) {
                this.f3308a.f3326o.m4361a();
            }
            return true;
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (!this.f3308a.f3317f || !CameraDevice.f3256b.m4303p()) {
                return false;
            }
            CameraDevice.f3256b.m4289b(Math.min(this.f3310c, Math.max(0, ((int) (((scaleGestureDetector.getCurrentSpan() - this.f3311d) / ((float) this.f3308a.getWidth())) * ((float) this.f3310c))) + this.f3309b)));
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            if (this.f3308a.f3326o != null) {
                this.f3308a.f3326o.m4362b();
            }
        }
    }

    /* compiled from: targetName */
    public interface OnSurfaceTextureUpdatedListener {
    }

    /* compiled from: targetName */
    public interface PinchZoomListener {
        void m4361a();

        void m4362b();
    }

    public CameraPreviewView(Context context) {
        this(context, null);
    }

    public CameraPreviewView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraPreviewView(Context context, AttributeSet attributeSet, int i) {
        boolean z = true;
        super(context, attributeSet, i);
        this.f3318g = null;
        this.f3326o = null;
        this.f3327p = CameraFacing.BACK;
        this.f3331t = false;
        this.f3332u = new DefaultSizeSetter();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CameraPreviewView, 0, 0);
        try {
            this.f3315d = CaptureQuality.fromId(obtainStyledAttributes.getInt(1, 0));
            this.f3316e = CaptureQuality.fromId(obtainStyledAttributes.getInt(2, 0));
            this.f3317f = obtainStyledAttributes.getBoolean(3, true);
            setInitialCameraFacing(CameraFacing.fromId(obtainStyledAttributes.getInt(0, CameraFacing.BACK.getInfoId())));
            int i2 = obtainStyledAttributes.getInt(4, 3);
            this.f3329r = (i2 & 1) == 1;
            if ((i2 & 2) != 2) {
                z = false;
            }
            this.f3330s = z;
            setMediaOrientationLocked(obtainStyledAttributes.getBoolean(5, false));
            setSurfaceTextureListener(this);
            this.f3324m = new GestureDetector(context, new CameraGestureDetector(this));
            this.f3325n = new ScaleGestureDetector(context, new CameraZoomGestureDetector(this));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1635036473);
        super.onAttachedToWindow();
        m4367a(getContext());
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1855641872, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -529818320);
        super.onDetachedFromWindow();
        if (this.f3318g != null) {
            this.f3318g.disable();
        }
        setCameraInitialisedCallback(null);
        m4395n();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 284104733, a);
    }

    public static void m4364a() {
        CameraDevice.f3256b.m4296g();
    }

    private void m4365a(final int i) {
        CameraDevice cameraDevice = CameraDevice.f3256b;
        ThreadUtil.m4413b(new FutureTask(new C01936(cameraDevice, i)), new Callback<Size>(this) {
            final /* synthetic */ CameraPreviewView f3299b;

            public final void mo209a(Object obj) {
                Size size = (Size) obj;
                this.f3299b.m4366a(this.f3299b.getWidth(), this.f3299b.getHeight(), size.width, size.height);
                this.f3299b.f3319h = i;
            }

            public final void mo208a(Exception exception) {
                Log.e(CameraPreviewView.f3312a, exception.getMessage());
            }
        });
    }

    private static void m4376b(Callback<Void> callback) {
        CameraDevice cameraDevice = CameraDevice.f3256b;
        if (cameraDevice.f3276p == null || cameraDevice.f3276p.isDone()) {
            cameraDevice.f3276p = new FutureTask(new Callable<Void>(cameraDevice) {
                final /* synthetic */ CameraDevice f3221a;

                {
                    this.f3221a = r1;
                }

                public Object call() {
                    this.f3221a.m4296g();
                    return null;
                }
            });
            ThreadUtil.m4413b(cameraDevice.f3276p, (Callback) callback);
            return;
        }
        ThreadUtil.m4410a(cameraDevice.f3276p, callback);
    }

    private void m4378c(Callback<Void> callback) {
        CameraDevice cameraDevice = CameraDevice.f3256b;
        DefaultSizeSetter defaultSizeSetter = this.f3332u;
        if (cameraDevice.f3277q == null || cameraDevice.f3277q.isDone()) {
            cameraDevice.f3277q = new FutureTask(new AnonymousClass15(cameraDevice, defaultSizeSetter));
            ThreadUtil.m4413b(cameraDevice.f3277q, (Callback) callback);
            return;
        }
        ThreadUtil.m4410a(cameraDevice.f3277q, callback);
    }

    public static boolean m4381e() {
        return CameraDevice.f3256b.f3273m;
    }

    public static boolean m4382f() {
        return CameraDevice.f3256b.f3259C;
    }

    public static boolean m4384g() {
        return CameraDevice.f3256b.m4301n();
    }

    public static boolean m4387h() {
        return CameraDevice.f3256b.m4302o();
    }

    private void m4391j() {
        CameraDevice.f3256b.m4286a(getSurfaceTexture(), this.f3327p, getDisplayRotation(this), this.f3313b, this.f3314c, this.f3316e, this.f3315d, this.f3332u, new C02012(this));
    }

    private static void m4392k() {
        CameraDevice cameraDevice = CameraDevice.f3256b;
        ThreadUtil.m4407a();
        ThreadUtil.m4409a(new FutureTask(new C01871(cameraDevice)));
    }

    public final void m4396a(final Callback2<byte[], PhotoCaptureInfo> callback2) {
        CameraDevice cameraDevice = CameraDevice.f3256b;
        Callback2 c02045 = new Callback2<byte[], Integer>(this) {
            final /* synthetic */ CameraPreviewView f3303b;

            public final void mo211a(Object obj, Object obj2) {
                byte[] bArr = (byte[]) obj;
                Integer num = (Integer) obj2;
                CameraDevice cameraDevice = CameraDevice.f3256b;
                callback2.mo211a(bArr, new PhotoCaptureInfo(cameraDevice.m4298k(), cameraDevice.m4297j(), new Rect(0, 0, this.f3303b.getWidth(), this.f3303b.getHeight()), num.intValue()));
            }

            public final void mo210a(Exception exception) {
                callback2.mo210a(exception);
            }
        };
        if (!cameraDevice.m4294e()) {
            c02045.mo210a(new CameraDeviceBusyException("Busy taking photo"));
        } else if (!cameraDevice.f3259C || cameraDevice.f3274n) {
            cameraDevice.f3272l = false;
            ThreadUtil.m4413b(new FutureTask(new C01947(cameraDevice)), new C01978(cameraDevice, SystemClock.elapsedRealtime(), c02045));
        }
    }

    public final void m4397a(final Callback<CameraFacing> callback) {
        CameraDevice cameraDevice = CameraDevice.f3256b;
        Callback c02034 = new Callback<Size>(this) {
            final /* synthetic */ CameraPreviewView f3301b;

            public final void mo209a(Object obj) {
                Size size = (Size) obj;
                this.f3301b.m4366a(this.f3301b.f3313b, this.f3301b.f3314c, size.width, size.height);
                callback.mo209a(CameraDevice.m4267a().m4293d());
                synchronized (this) {
                    if (this.f3301b.f3323l != null) {
                        this.f3301b.f3323l.m4359a();
                    }
                }
            }

            public final void mo208a(Exception exception) {
                callback.mo208a(exception);
            }
        };
        DefaultSizeSetter defaultSizeSetter = this.f3332u;
        if (cameraDevice.m4294e()) {
            cameraDevice.m4286a(cameraDevice.f3265e, cameraDevice.f3269i.equals(CameraFacing.BACK) ? CameraFacing.FRONT : CameraFacing.BACK, cameraDevice.f3266f, cameraDevice.f3267g, cameraDevice.f3268h, cameraDevice.f3271k, cameraDevice.f3270j, defaultSizeSetter, c02034);
        } else {
            c02034.mo208a(new RuntimeException("Failed to switch camera. Camera not initialised."));
        }
    }

    public final void m4401c() {
        CameraDevice.f3256b.m4287a(this.f3332u);
    }

    public CameraFacing getCameraFacing() {
        return CameraDevice.f3256b.f3269i;
    }

    public String getFlashMode() {
        return CameraDevice.f3256b.m4300m();
    }

    public Bitmap getPreviewFrame() {
        Rect j = CameraDevice.f3256b.m4297j();
        return getBitmap(j.height(), j.width());
    }

    public List<String> getSupportedFlashModes() {
        return CameraDevice.f3256b.m4299l();
    }

    public void setFlashMode(String str) {
        CameraDevice.f3256b.m4288a(str);
    }

    public void setHdr(boolean z) {
        CameraDevice.f3256b.m4291b(z);
    }

    public void setMediaOrientationLocked(boolean z) {
        CameraDevice cameraDevice = CameraDevice.f3256b;
        cameraDevice.f3263c = 0;
        cameraDevice.f3275o = z;
    }

    public final void m4400b() {
        m4376b(null);
    }

    public final void m4402d() {
        m4378c(null);
    }

    public void setInitialCameraFacing(CameraFacing cameraFacing) {
        this.f3327p = cameraFacing;
    }

    public CameraFacing getInitialCameraFacing() {
        return this.f3327p;
    }

    public void setTouchEnabled(boolean z) {
        this.f3331t = z;
    }

    private void m4367a(Context context) {
        if (this.f3318g == null) {
            this.f3318g = new OrientationEventListener(this, context) {
                final /* synthetic */ CameraPreviewView f3296a;

                public void onOrientationChanged(int i) {
                    CameraDevice cameraDevice = CameraDevice.f3256b;
                    if (!cameraDevice.f3275o) {
                        cameraDevice.f3263c = i;
                    }
                    int displayRotation = CameraPreviewView.getDisplayRotation(this.f3296a);
                    if (displayRotation != this.f3296a.f3319h) {
                        this.f3296a.m4365a(displayRotation);
                    }
                }
            };
        }
        if (this.f3318g.canDetectOrientation()) {
            this.f3318g.enable();
        }
    }

    public static int getDisplayRotation(CameraPreviewView cameraPreviewView) {
        return ((WindowManager) cameraPreviewView.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f3313b = i;
        this.f3314c = i2;
        m4391j();
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f3313b = i;
        this.f3314c = i2;
        m4365a(getDisplayRotation(this));
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        m4392k();
        return true;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        if (this.f3322k != null) {
            this.f3322k = null;
        }
    }

    public void setOnSurfaceTextureUpdatedListener(OnSurfaceTextureUpdatedListener onSurfaceTextureUpdatedListener) {
        this.f3322k = onSurfaceTextureUpdatedListener;
    }

    private void m4366a(int i, int i2, int i3, int i4) {
        Matrix transform = getTransform(new Matrix());
        float f = ((float) i) / ((float) i2);
        int c = CameraDevice.f3256b.m4292c();
        if (c == 90 || c == 270) {
            int i5 = i3;
            i3 = i4;
            i4 = i5;
        }
        if (((float) i3) / ((float) i4) > f) {
            f = ((float) i2) / ((float) i4);
        } else {
            f = ((float) i) / ((float) i3);
        }
        transform.setScale((((float) i3) / ((float) i)) * f, f * (((float) i4) / ((float) i2)), (float) (i / 2), (float) (i2 / 2));
        setTransform(transform);
        m4368a(transform);
    }

    private void m4368a(Matrix matrix) {
        float f;
        RectF rectF = new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        matrix.mapRect(rectF);
        Matrix matrix2 = new Matrix();
        if (CameraDevice.f3256b.f3269i == CameraFacing.FRONT) {
            f = -1.0f;
        } else {
            f = 1.0f;
        }
        matrix2.setScale(f, 1.0f);
        matrix2.postRotate((float) CameraDevice.f3256b.m4292c());
        Matrix matrix3 = new Matrix();
        matrix3.setRectToRect(new RectF(-1000.0f, -1000.0f, 1000.0f, 1000.0f), rectF, ScaleToFit.FILL);
        matrix2.setConcat(matrix3, matrix2);
        this.f3328q = new Matrix();
        matrix2.invert(this.f3328q);
    }

    private void m4373a(float[] fArr) {
        Matrix matrix = new Matrix();
        this.f3328q.invert(matrix);
        matrix.mapPoints(fArr);
    }

    public final void m4399a(Callback<VideoCaptureInfo> callback, File file) {
        m4369a((Callback) callback, file.getAbsolutePath());
    }

    private void m4369a(Callback<VideoCaptureInfo> callback, String str) {
        m4393l();
        CameraDevice cameraDevice = CameraDevice.f3256b;
        if (cameraDevice.m4294e()) {
            cameraDevice.f3259C = true;
            ThreadUtil.m4413b(new FutureTask(new C01989(cameraDevice, str)), new AnonymousClass10(cameraDevice, callback));
            return;
        }
        callback.mo208a(new RuntimeException("Can't record video before it's initialised."));
    }

    public final void m4398a(Callback<VideoCaptureInfo> callback, Callback<Size> callback2) {
        m4394m();
        CameraDevice cameraDevice = CameraDevice.f3256b;
        DefaultSizeSetter defaultSizeSetter = this.f3332u;
        if (cameraDevice.f3259C) {
            ThreadUtil.m4413b(new FutureTask(new Callable<VideoCaptureInfo>(cameraDevice) {
                final /* synthetic */ CameraDevice f3214a;

                {
                    this.f3214a = r1;
                }

                public Object call() {
                    CameraDevice.m4283w(this.f3214a);
                    return this.f3214a.f3260D;
                }
            }), new AnonymousClass13(cameraDevice, callback, new AnonymousClass12(cameraDevice, callback2), defaultSizeSetter));
        } else if (callback != null) {
            callback.mo208a(new RuntimeException("Not recording video"));
        }
    }

    private void m4393l() {
        if (!this.f3321j && (getContext() instanceof Activity)) {
            Activity activity = (Activity) getContext();
            this.f3320i = activity.getRequestedOrientation();
            int displayRotation = getDisplayRotation(this);
            if (displayRotation == 0) {
                activity.setRequestedOrientation(1);
            } else if (displayRotation == 1) {
                activity.setRequestedOrientation(0);
            } else if (displayRotation == 3) {
                activity.setRequestedOrientation(8);
            }
            this.f3321j = true;
        }
    }

    private void m4394m() {
        if ((getContext() instanceof Activity) && this.f3321j) {
            ((Activity) getContext()).setRequestedOrientation(this.f3320i);
            this.f3321j = false;
        }
    }

    public void setCameraInitialisedCallback(CameraInitialisedCallback cameraInitialisedCallback) {
        if (CameraDevice.m4267a().m4294e() && cameraInitialisedCallback != null) {
            cameraInitialisedCallback.m4359a();
        }
        synchronized (this) {
            this.f3323l = cameraInitialisedCallback;
        }
    }

    private void m4395n() {
        setFocusCallbackListener(null);
    }

    public void setFocusCallbackListener(final FocusCallback focusCallback) {
        if (focusCallback == null) {
            CameraDevice.f3256b.f3280t = null;
            return;
        }
        CameraDevice.f3256b.f3280t = new FocusCallback(this) {
            float[] f3304a = new float[2];
            final /* synthetic */ CameraPreviewView f3306c;

            public final void mo212a(FocusState focusState, Point point) {
                if (focusCallback != null) {
                    if (point != null) {
                        this.f3304a[0] = (float) point.x;
                        this.f3304a[1] = (float) point.y;
                        this.f3306c.m4373a(this.f3304a);
                        focusCallback.mo212a(focusState, new Point((int) this.f3304a[0], (int) this.f3304a[1]));
                        return;
                    }
                    focusCallback.mo212a(focusState, null);
                }
            }
        };
    }

    public void setPinchZoomListener(PinchZoomListener pinchZoomListener) {
        this.f3326o = pinchZoomListener;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1930103679);
        if (this.f3331t) {
            boolean onTouchEvent = this.f3324m.onTouchEvent(motionEvent);
            boolean onTouchEvent2 = this.f3325n.onTouchEvent(motionEvent);
            if (onTouchEvent || onTouchEvent2) {
                z = true;
            }
            LogUtils.a(-1431285821, a);
        } else {
            Logger.a(2, EntryType.UI_INPUT_END, -427839286, a);
        }
        return z;
    }
}
