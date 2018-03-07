package org.webrtc.videoengine;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLUtils;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.MeasureSpec;
import com.facebook.R;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.facebook.debug.log.BLog;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

@DoNotStrip
/* compiled from: aliasEnabled */
public class ViEAndroidGLES20 extends TextureView implements Renderer, SurfaceTextureListener {
    private static final Class<?> f21059b = ViEAndroidGLES20.class;
    private boolean f21060A;
    private ConfigChooser f21061B;
    public boolean f21062C;
    public boolean f21063D;
    public int f21064E;
    private FbHandlerThreadFactory f21065F;
    public final AtomicInteger f21066G;
    public final AtomicLong f21067H;
    private final AtomicBoolean f21068I;
    ViEAndroidGLES20SurfaceTextureAvailableListener f21069a;
    private boolean f21070c;
    private boolean f21071d;
    private boolean f21072e;
    private final ReentrantLock f21073f;
    private long f21074g;
    private int f21075h;
    private int f21076i;
    public final AwakeTimeSinceBootClock f21077j;
    private boolean f21078k;
    public ViEAndroidGLES20OneShotDrawListener f21079l;
    private RenderThread f21080m;
    private HandlerThread f21081n;
    private Handler f21082o;
    private final int f21083p;
    private int f21084q;
    private int f21085r;
    public int f21086s;
    private GL10 f21087t;
    private SurfaceTexture f21088u;
    private EGLDisplay f21089v;
    private EGLSurface f21090w;
    private EGLContext f21091x;
    private EGL10 f21092y;
    private EGLConfig f21093z;

    /* compiled from: aliasEnabled */
    class C24541 implements Runnable {
        final /* synthetic */ ViEAndroidGLES20 f21046a;

        C24541(ViEAndroidGLES20 viEAndroidGLES20) {
            this.f21046a = viEAndroidGLES20;
        }

        public void run() {
            ViEAndroidGLES20.m21553j(this.f21046a);
        }
    }

    /* compiled from: aliasEnabled */
    class C24552 implements Runnable {
        final /* synthetic */ ViEAndroidGLES20 f21047a;

        C24552(ViEAndroidGLES20 viEAndroidGLES20) {
            this.f21047a = viEAndroidGLES20;
        }

        public void run() {
            this.f21047a.f21066G;
        }
    }

    /* compiled from: aliasEnabled */
    class C24563 implements Runnable {
        final /* synthetic */ ViEAndroidGLES20 f21048a;

        C24563(ViEAndroidGLES20 viEAndroidGLES20) {
            this.f21048a = viEAndroidGLES20;
        }

        public void run() {
            this.f21048a.f21066G.decrementAndGet();
            this.f21048a.f21077j;
        }
    }

    /* compiled from: aliasEnabled */
    class ConfigChooser implements EGLConfigChooser {
        private static final int[] f21049g = new int[]{12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344};
        protected int f21050a;
        protected int f21051b;
        protected int f21052c;
        protected int f21053d;
        protected int f21054e;
        protected int f21055f;
        private final int[] f21056h = new int[1];

        public ConfigChooser(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f21050a = i;
            this.f21051b = i2;
            this.f21052c = i3;
            this.f21053d = i4;
            this.f21054e = i5;
            this.f21055f = i6;
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, f21049g, null, 0, iArr);
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            egl10.eglChooseConfig(eGLDisplay, f21049g, eGLConfigArr, i, iArr);
            return m21531a(egl10, eGLDisplay, eGLConfigArr);
        }

        private EGLConfig m21531a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a = m21530a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int a2 = m21530a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (a >= this.f21054e && a2 >= this.f21055f) {
                    a = m21530a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int a3 = m21530a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int a4 = m21530a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    a2 = m21530a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (a == this.f21050a && a3 == this.f21051b && a4 == this.f21052c && a2 == this.f21053d) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int m21530a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.f21056h)) {
                return this.f21056h[0];
            }
            return i2;
        }
    }

    /* compiled from: aliasEnabled */
    class RenderThread extends Thread {
        public boolean f21057a;
        final /* synthetic */ ViEAndroidGLES20 f21058b;

        public RenderThread(ViEAndroidGLES20 viEAndroidGLES20) {
            this.f21058b = viEAndroidGLES20;
            this.f21057a = false;
        }

        public void run() {
            if (this.f21058b.f21064E == 1) {
                m21533b();
            } else {
                m21532a();
            }
        }

        private void m21532a() {
            this.f21057a = true;
            long currentTimeMillis = System.currentTimeMillis();
            ViEAndroidGLES20.m21553j(this.f21058b);
            while (this.f21057a) {
                if (!this.f21058b.f21077j) {
                    currentTimeMillis = System.currentTimeMillis();
                    this.f21058b.f21077j;
                }
                try {
                    if (this.f21058b.f21077j) {
                        Thread.sleep(100);
                    } else {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        try {
                            Thread.sleep(Math.max(10, ((long) this.f21058b.f21086s) - (currentTimeMillis2 - currentTimeMillis)));
                            currentTimeMillis = currentTimeMillis2;
                        } catch (InterruptedException e) {
                            currentTimeMillis = currentTimeMillis2;
                        }
                    }
                } catch (InterruptedException e2) {
                }
            }
            this.f21058b.f21066G;
        }

        private void m21533b() {
            this.f21057a = true;
            long now = this.f21058b.f21077j.now();
            ViEAndroidGLES20.m21553j(this.f21058b);
            while (this.f21057a) {
                if (!(this.f21058b.f21077j || this.f21058b.f21067H.get() == r0)) {
                    now = this.f21058b.f21067H.get();
                    this.f21058b.f21077j;
                }
                try {
                    if (this.f21058b.f21077j) {
                        Thread.sleep(100);
                    } else {
                        Thread.sleep(Math.max(10, ((long) this.f21058b.f21086s) - (this.f21058b.f21077j.now() - now)));
                    }
                } catch (InterruptedException e) {
                }
            }
            this.f21058b.f21066G;
        }
    }

    private native int CreateOpenGLNative(long j, int i, int i2, boolean z);

    private native void DrawNative(long j, boolean z);

    public void setViEAndroidGLES20SurfaceTextureAvailableListener(ViEAndroidGLES20SurfaceTextureAvailableListener viEAndroidGLES20SurfaceTextureAvailableListener) {
        this.f21069a = viEAndroidGLES20SurfaceTextureAvailableListener;
    }

    public void setOneShotDrawListener(ViEAndroidGLES20OneShotDrawListener viEAndroidGLES20OneShotDrawListener) {
        this.f21079l = viEAndroidGLES20OneShotDrawListener;
    }

    public final void m21556a(int i, FbHandlerThreadFactory fbHandlerThreadFactory) {
        if (i < 3) {
            this.f21064E = i;
        }
        this.f21065F = fbHandlerThreadFactory;
    }

    private void m21536b() {
        int glGetError = this.f21087t.glGetError();
        if (glGetError != 0) {
            BLog.b(f21059b, "GL error = 0x" + Integer.toHexString(glGetError));
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f21088u = surfaceTexture;
        m21537b(i, i2);
        this.f21086s = 66;
        onSurfaceChanged(this.f21087t, this.f21085r, this.f21084q);
        setPaused(false);
        if (this.f21064E != 2 || this.f21065F == null) {
            if (this.f21080m != null) {
                m21541d();
            }
            this.f21080m = new RenderThread(this);
            this.f21080m.start();
        } else if (this.f21081n == null) {
            this.f21081n = this.f21065F.a("RtcPeerRenderThread");
            this.f21081n.start();
            this.f21082o = new Handler(this.f21081n.getLooper());
            HandlerDetour.a(this.f21082o, new C24541(this), -577389901);
        }
    }

    private void m21537b(int i, int i2) {
        this.f21085r = i;
        this.f21084q = i2;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        m21537b(i, i2);
        onSurfaceChanged(this.f21087t, i, i2);
    }

    public void setPaused(boolean z) {
        new Object[1][0] = Boolean.valueOf(z);
        this.f21068I.set(z);
    }

    private boolean m21540c() {
        return this.f21068I.get();
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        m21541d();
        return false;
    }

    private void m21541d() {
        if (this.f21080m != null) {
            this.f21080m.f21057a = false;
            this.f21080m = null;
        }
        if (this.f21082o != null) {
            HandlerDetour.a(this.f21082o, new C24552(this), -1699543965);
        }
        if (this.f21081n != null) {
            this.f21081n.quitSafely();
            this.f21081n = null;
        }
    }

    public static boolean m21544e(ViEAndroidGLES20 viEAndroidGLES20) {
        return viEAndroidGLES20.m21540c();
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setFillWithAspect(boolean z) {
        this.f21062C = z;
    }

    private boolean m21546f() {
        if (!(this.f21091x.equals(this.f21092y.eglGetCurrentContext()) && this.f21090w.equals(this.f21092y.eglGetCurrentSurface(12377)))) {
            m21534a("not current", this.f21092y);
            if (!this.f21092y.eglMakeCurrent(this.f21089v, this.f21090w, this.f21090w, this.f21091x)) {
                m21534a("after make current", this.f21092y);
                return false;
            }
        }
        return true;
    }

    public static void m21548g(ViEAndroidGLES20 viEAndroidGLES20) {
        viEAndroidGLES20.m21546f();
        viEAndroidGLES20.onDrawFrame(viEAndroidGLES20.f21087t);
        viEAndroidGLES20.m21536b();
        if (!viEAndroidGLES20.f21092y.eglSwapBuffers(viEAndroidGLES20.f21089v, viEAndroidGLES20.f21090w)) {
            BLog.b(f21059b, "cannot swap buffers!");
        }
    }

    private void m21550h() {
        this.f21061B = this.f21078k ? new ConfigChooser(8, 8, 8, 8, 0, 0) : new ConfigChooser(5, 6, 5, 0, 0, 0);
        this.f21067H.set(0);
        setSurfaceTextureListener(this);
    }

    public static void m21552i(ViEAndroidGLES20 viEAndroidGLES20) {
        if (viEAndroidGLES20.f21089v != EGL10.EGL_NO_DISPLAY) {
            viEAndroidGLES20.f21092y.eglDestroySurface(viEAndroidGLES20.f21089v, viEAndroidGLES20.f21090w);
            viEAndroidGLES20.f21092y.eglDestroyContext(viEAndroidGLES20.f21089v, viEAndroidGLES20.f21091x);
            viEAndroidGLES20.f21092y.eglMakeCurrent(viEAndroidGLES20.f21089v, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            viEAndroidGLES20.f21092y.eglTerminate(viEAndroidGLES20.f21089v);
        }
        viEAndroidGLES20.f21089v = EGL10.EGL_NO_DISPLAY;
        viEAndroidGLES20.f21091x = EGL10.EGL_NO_CONTEXT;
        viEAndroidGLES20.f21090w = EGL10.EGL_NO_SURFACE;
        viEAndroidGLES20.f21060A = false;
    }

    public static void m21553j(ViEAndroidGLES20 viEAndroidGLES20) {
        if (!viEAndroidGLES20.f21060A) {
            viEAndroidGLES20.f21092y = (EGL10) EGLContext.getEGL();
            viEAndroidGLES20.f21089v = viEAndroidGLES20.f21092y.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (viEAndroidGLES20.f21089v == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed " + GLUtils.getEGLErrorString(viEAndroidGLES20.f21092y.eglGetError()));
            }
            if (viEAndroidGLES20.f21092y.eglInitialize(viEAndroidGLES20.f21089v, new int[2])) {
                int[] iArr = new int[1];
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                int[] iArr2 = new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};
                viEAndroidGLES20.f21093z = null;
                if (viEAndroidGLES20.f21092y.eglChooseConfig(viEAndroidGLES20.f21089v, iArr2, eGLConfigArr, 1, iArr)) {
                    if (iArr[0] > 0) {
                        viEAndroidGLES20.f21093z = eGLConfigArr[0];
                    }
                    if (viEAndroidGLES20.f21093z == null) {
                        throw new RuntimeException("eglConfig not initialized");
                    }
                    viEAndroidGLES20.f21091x = viEAndroidGLES20.f21092y.eglCreateContext(viEAndroidGLES20.f21089v, viEAndroidGLES20.f21093z, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                    viEAndroidGLES20.f21090w = viEAndroidGLES20.f21092y.eglCreateWindowSurface(viEAndroidGLES20.f21089v, viEAndroidGLES20.f21093z, viEAndroidGLES20.f21088u, null);
                    if (viEAndroidGLES20.f21090w == null || viEAndroidGLES20.f21090w == EGL10.EGL_NO_SURFACE) {
                        int eglGetError = viEAndroidGLES20.f21092y.eglGetError();
                        if (eglGetError == 12299) {
                            BLog.b(f21059b, "eglCreateWindowSurface returned EGL10.EGL_BAD_NATIVE_WINDOW");
                            return;
                        }
                        throw new RuntimeException("eglCreateWindowSurface failed " + GLUtils.getEGLErrorString(eglGetError));
                    } else if (viEAndroidGLES20.f21092y.eglMakeCurrent(viEAndroidGLES20.f21089v, viEAndroidGLES20.f21090w, viEAndroidGLES20.f21090w, viEAndroidGLES20.f21091x)) {
                        viEAndroidGLES20.f21087t = (GL10) viEAndroidGLES20.f21091x.getGL();
                        viEAndroidGLES20.f21060A = true;
                        return;
                    } else {
                        throw new RuntimeException("eglMakeCurrent failed " + GLUtils.getEGLErrorString(viEAndroidGLES20.f21092y.eglGetError()));
                    }
                }
                throw new IllegalArgumentException("eglChooseConfig failed " + GLUtils.getEGLErrorString(viEAndroidGLES20.f21092y.eglGetError()));
            }
            throw new RuntimeException("eglInitialize failed " + GLUtils.getEGLErrorString(viEAndroidGLES20.f21092y.eglGetError()));
        }
    }

    public void setCropToCircle(boolean z) {
        this.f21078k = z;
    }

    @DoNotStrip
    public static boolean UseOpenGL2(Object obj) {
        return ViEAndroidGLES20.class.isInstance(obj);
    }

    public ViEAndroidGLES20(Context context) {
        super(context);
        this.f21070c = false;
        this.f21071d = false;
        this.f21072e = false;
        this.f21073f = new ReentrantLock();
        this.f21074g = 0;
        this.f21075h = 0;
        this.f21076i = 0;
        this.f21077j = AwakeTimeSinceBootClock.INSTANCE;
        this.f21079l = null;
        this.f21080m = null;
        this.f21081n = null;
        this.f21083p = 15;
        this.f21060A = false;
        this.f21062C = true;
        this.f21063D = false;
        this.f21064E = 0;
        this.f21065F = null;
        this.f21066G = new AtomicInteger(0);
        this.f21067H = new AtomicLong(0);
        this.f21068I = new AtomicBoolean(false);
        this.f21069a = null;
        this.f21078k = false;
        m21550h();
    }

    public ViEAndroidGLES20(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21070c = false;
        this.f21071d = false;
        this.f21072e = false;
        this.f21073f = new ReentrantLock();
        this.f21074g = 0;
        this.f21075h = 0;
        this.f21076i = 0;
        this.f21077j = AwakeTimeSinceBootClock.INSTANCE;
        this.f21079l = null;
        this.f21080m = null;
        this.f21081n = null;
        this.f21083p = 15;
        this.f21060A = false;
        this.f21062C = true;
        this.f21063D = false;
        this.f21064E = 0;
        this.f21065F = null;
        this.f21066G = new AtomicInteger(0);
        this.f21067H = new AtomicLong(0);
        this.f21068I = new AtomicBoolean(false);
        this.f21069a = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RTCVideoSurface);
        this.f21078k = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        m21550h();
    }

    public ViEAndroidGLES20(Context context, boolean z, int i, int i2) {
        super(context);
        this.f21070c = false;
        this.f21071d = false;
        this.f21072e = false;
        this.f21073f = new ReentrantLock();
        this.f21074g = 0;
        this.f21075h = 0;
        this.f21076i = 0;
        this.f21077j = AwakeTimeSinceBootClock.INSTANCE;
        this.f21079l = null;
        this.f21080m = null;
        this.f21081n = null;
        this.f21083p = 15;
        this.f21060A = false;
        this.f21062C = true;
        this.f21063D = false;
        this.f21064E = 0;
        this.f21065F = null;
        this.f21066G = new AtomicInteger(0);
        this.f21067H = new AtomicLong(0);
        this.f21068I = new AtomicBoolean(false);
        this.f21069a = null;
        this.f21078k = false;
        m21550h();
    }

    private static void m21534a(String str, EGL10 egl10) {
        while (egl10.eglGetError() != 12288) {
            BLog.b(f21059b, "%s: EGL error: 0x%x", new Object[]{str, Integer.valueOf(egl10.eglGetError())});
        }
    }

    public final void m21555a(int i, int i2) {
        this.f21075h = i;
        this.f21076i = i2;
        requestLayout();
        Integer.valueOf(this.f21075h);
        Integer.valueOf(this.f21076i);
    }

    public void onMeasure(int i, int i2) {
        if (this.f21075h <= 0 || this.f21076i <= 0) {
            super.onMeasure(i, i2);
            return;
        }
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (size <= 0 || size2 <= 0) {
            super.onMeasure(i, i2);
            return;
        }
        int i3 = (size * 100) / size2;
        int i4 = (this.f21075h * 100) / this.f21076i;
        if (Math.abs(i3 - i4) <= 10) {
            setMeasuredDimension(size, size2);
            return;
        }
        if (this.f21078k) {
            if (i3 <= i4) {
                size = (this.f21075h * size2) / this.f21076i;
            }
            size2 = (this.f21076i * size) / this.f21075h;
        } else {
            if (i3 > i4) {
                size = (this.f21075h * size2) / this.f21076i;
            }
            size2 = (this.f21076i * size) / this.f21075h;
        }
        setMeasuredDimension(size, size2);
    }

    public void onDrawFrame(GL10 gl10) {
        if (!this.f21063D) {
            this.f21073f.lock();
            try {
                if (!this.f21078k) {
                    gl10.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                }
                gl10.glClear(16640);
                if (this.f21072e && this.f21070c) {
                    if (!this.f21071d) {
                        int i = this.f21085r;
                        int i2 = this.f21084q;
                        if (this.f21062C && this.f21075h > 0 && this.f21076i > 0) {
                            if (this.f21076i > this.f21075h) {
                                i2 = (this.f21085r * this.f21076i) / this.f21075h;
                            } else {
                                i = (this.f21084q * this.f21075h) / this.f21076i;
                            }
                        }
                        if (CreateOpenGLNative(this.f21074g, i, i2, this.f21078k) != 0) {
                            BLog.a(f21059b, "CreateOpenGLNative failed %d,%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                            this.f21073f.unlock();
                            return;
                        }
                        BLog.a(f21059b, "CreateOpenGLNative %d,%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                        this.f21071d = true;
                    }
                    DrawNative(this.f21074g, this.f21078k);
                    this.f21073f.unlock();
                    if (this.f21079l != null) {
                        this.f21079l.mo835a();
                        this.f21079l = null;
                        return;
                    }
                    return;
                }
                this.f21073f.unlock();
            } catch (Throwable th) {
                this.f21073f.unlock();
            }
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.f21070c = true;
        Integer.valueOf(i);
        Integer.valueOf(i2);
        Integer.valueOf(this.f21075h);
        Integer.valueOf(this.f21076i);
        this.f21073f.lock();
        try {
            if (this.f21072e) {
                this.f21071d = false;
            }
            this.f21073f.unlock();
        } catch (Throwable th) {
            this.f21073f.unlock();
        }
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
    }

    @DoNotStrip
    public void RegisterNativeObject(long j) {
        this.f21073f.lock();
        try {
            this.f21074g = j;
            this.f21072e = true;
        } finally {
            this.f21073f.unlock();
        }
    }

    @DoNotStrip
    public void DeRegisterNativeObject() {
        this.f21073f.lock();
        try {
            this.f21072e = false;
            this.f21071d = false;
            this.f21074g = 0;
        } finally {
            this.f21073f.unlock();
        }
    }

    @DoNotStrip
    public void ReDraw() {
        if (this.f21070c) {
            this.f21067H.set(this.f21077j.now());
            if (this.f21064E == 2 && this.f21082o != null && this.f21081n != null && this.f21066G.compareAndSet(0, 1)) {
                HandlerDetour.a(this.f21082o, new C24563(this), -1117978045);
            }
        }
    }

    public void setFreezeDrawing(boolean z) {
        this.f21063D = z;
    }

    public final void m21554a() {
        this.f21067H.set(0);
    }

    public long getLastRedrawTime() {
        return this.f21067H.get();
    }
}
