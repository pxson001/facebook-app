package org.webrtc.videoengine;

import android.content.Context;
import android.content.res.TypedArray;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.facebook.R;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.facebook.debug.log.BLog;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

@DoNotStrip
/* compiled from: age_min */
public class ViEAndroidGLES20SurfaceView extends GLSurfaceView implements Renderer {
    public static final Class<?> f21102a = ViEAndroidGLES20SurfaceView.class;
    private boolean f21103b;
    private boolean f21104c;
    private boolean f21105d;
    private final ReentrantLock f21106e;
    private long f21107f;
    private int f21108g;
    private int f21109h;
    private final AwakeTimeSinceBootClock f21110i;
    private boolean f21111j;
    public ViEAndroidGLES20OneShotDrawListener f21112k;
    private int f21113l;
    private int f21114m;
    public boolean f21115n;
    private final AtomicLong f21116o;

    /* compiled from: age_min */
    class ConfigChooser implements EGLConfigChooser {
        private static final int[] f21094g = new int[]{12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344};
        protected int f21095a;
        protected int f21096b;
        protected int f21097c;
        protected int f21098d;
        protected int f21099e;
        protected int f21100f;
        private final int[] f21101h = new int[1];

        public ConfigChooser(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f21095a = i;
            this.f21096b = i2;
            this.f21097c = i3;
            this.f21098d = i4;
            this.f21099e = i5;
            this.f21100f = i6;
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, f21094g, null, 0, iArr);
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            egl10.eglChooseConfig(eGLDisplay, f21094g, eGLConfigArr, i, iArr);
            return m21558a(egl10, eGLDisplay, eGLConfigArr);
        }

        private EGLConfig m21558a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a = m21557a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int a2 = m21557a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (a >= this.f21099e && a2 >= this.f21100f) {
                    a = m21557a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int a3 = m21557a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int a4 = m21557a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    a2 = m21557a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (a == this.f21095a && a3 == this.f21096b && a4 == this.f21097c && a2 == this.f21098d) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int m21557a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.f21101h)) {
                return this.f21101h[0];
            }
            return i2;
        }
    }

    /* compiled from: age_min */
    class ContextFactory implements EGLContextFactory {
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            BLog.a(ViEAndroidGLES20SurfaceView.f21102a, "creating OpenGL ES 2.0 context");
            ViEAndroidGLES20SurfaceView.m21561b("Before eglCreateContext", egl10);
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            ViEAndroidGLES20SurfaceView.m21561b("After eglCreateContext", egl10);
            return eglCreateContext;
        }

        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    private native int CreateOpenGLNative(long j, int i, int i2, boolean z);

    private native void DrawNative(long j, boolean z);

    public void setOneShotDrawListener(ViEAndroidGLES20OneShotDrawListener viEAndroidGLES20OneShotDrawListener) {
        this.f21112k = viEAndroidGLES20OneShotDrawListener;
    }

    private void m21560b(int i, int i2) {
        this.f21114m = i;
        this.f21113l = i2;
    }

    public void setCropToCircle(boolean z) {
        this.f21111j = z;
    }

    @DoNotStrip
    public static boolean UseOpenGL2(Object obj) {
        return ViEAndroidGLES20SurfaceView.class.isInstance(obj);
    }

    public ViEAndroidGLES20SurfaceView(Context context) {
        super(context);
        this.f21103b = false;
        this.f21104c = false;
        this.f21105d = false;
        this.f21106e = new ReentrantLock();
        this.f21107f = 0;
        this.f21108g = 0;
        this.f21109h = 0;
        this.f21110i = AwakeTimeSinceBootClock.INSTANCE;
        this.f21112k = null;
        this.f21115n = true;
        this.f21116o = new AtomicLong(0);
        this.f21111j = false;
        m21563c(0, 0);
    }

    public ViEAndroidGLES20SurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21103b = false;
        this.f21104c = false;
        this.f21105d = false;
        this.f21106e = new ReentrantLock();
        this.f21107f = 0;
        this.f21108g = 0;
        this.f21109h = 0;
        this.f21110i = AwakeTimeSinceBootClock.INSTANCE;
        this.f21112k = null;
        this.f21115n = true;
        this.f21116o = new AtomicLong(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RTCVideoSurface);
        this.f21111j = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        m21563c(0, 0);
    }

    public void setFillWithAspect(boolean z) {
        this.f21115n = z;
    }

    public ViEAndroidGLES20SurfaceView(Context context, boolean z, int i, int i2) {
        super(context);
        this.f21103b = false;
        this.f21104c = false;
        this.f21105d = false;
        this.f21106e = new ReentrantLock();
        this.f21107f = 0;
        this.f21108g = 0;
        this.f21109h = 0;
        this.f21110i = AwakeTimeSinceBootClock.INSTANCE;
        this.f21112k = null;
        this.f21115n = true;
        this.f21116o = new AtomicLong(0);
        this.f21111j = false;
        m21563c(i, i2);
    }

    private void m21563c(int i, int i2) {
        if (this.f21111j) {
            getHolder().setFormat(-3);
        }
        setEGLContextFactory(new ContextFactory());
        setEGLConfigChooser(this.f21111j ? new ConfigChooser(8, 8, 8, 8, i, i2) : new ConfigChooser(5, 6, 5, 0, i, i2));
        setRenderer(this);
        setRenderMode(0);
        setZOrderMediaOverlay(true);
        this.f21116o.set(0);
    }

    public static void m21561b(String str, EGL10 egl10) {
        while (egl10.eglGetError() != 12288) {
            BLog.b(f21102a, "%s: EGL error: 0x%x", new Object[]{str, Integer.valueOf(egl10.eglGetError())});
        }
    }

    public final void m21565a(int i, int i2) {
        this.f21108g = i;
        this.f21109h = i2;
        requestLayout();
    }

    public void onMeasure(int i, int i2) {
        if (this.f21108g <= 0 || this.f21109h <= 0) {
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
        int i4 = (this.f21108g * 100) / this.f21109h;
        if (Math.abs(i3 - i4) <= 10) {
            setMeasuredDimension(size, size2);
            return;
        }
        if (this.f21111j) {
            if (i3 <= i4) {
                size = (this.f21108g * size2) / this.f21109h;
            }
            size2 = (this.f21109h * size) / this.f21108g;
        } else {
            if (i3 > i4) {
                size = (this.f21108g * size2) / this.f21109h;
            }
            size2 = (this.f21109h * size) / this.f21108g;
        }
        setMeasuredDimension(size, size2);
    }

    public void onDrawFrame(GL10 gl10) {
        this.f21106e.lock();
        try {
            if (!this.f21111j) {
                gl10.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            }
            gl10.glClear(16640);
            if (this.f21105d && this.f21103b) {
                if (!this.f21104c) {
                    int i = this.f21114m;
                    int i2 = this.f21113l;
                    if (this.f21115n && this.f21108g > 0 && this.f21109h > 0) {
                        if (this.f21109h > this.f21108g) {
                            i2 = (this.f21114m * this.f21109h) / this.f21108g;
                        } else {
                            i = (this.f21113l * this.f21108g) / this.f21109h;
                        }
                    }
                    if (CreateOpenGLNative(this.f21107f, i, i2, this.f21111j) != 0) {
                        this.f21106e.unlock();
                        return;
                    }
                    this.f21104c = true;
                }
                DrawNative(this.f21107f, this.f21111j);
                this.f21106e.unlock();
                if (this.f21112k != null) {
                    this.f21112k.mo835a();
                    this.f21112k = null;
                    return;
                }
                return;
            }
            this.f21106e.unlock();
        } catch (Throwable th) {
            this.f21106e.unlock();
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.f21103b = true;
        m21560b(i, i2);
        this.f21106e.lock();
        try {
            if (this.f21105d) {
                this.f21104c = false;
            }
            this.f21106e.unlock();
        } catch (Throwable th) {
            this.f21106e.unlock();
        }
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
    }

    @DoNotStrip
    public void RegisterNativeObject(long j) {
        this.f21106e.lock();
        try {
            this.f21107f = j;
            this.f21105d = true;
        } finally {
            this.f21106e.unlock();
        }
    }

    @DoNotStrip
    public void DeRegisterNativeObject() {
        this.f21106e.lock();
        try {
            this.f21105d = false;
            this.f21104c = false;
            this.f21107f = 0;
        } finally {
            this.f21106e.unlock();
        }
    }

    @DoNotStrip
    public void ReDraw() {
        if (this.f21103b) {
            this.f21116o.set(this.f21110i.now());
            requestRender();
        }
    }

    public final void m21564a() {
        this.f21116o.set(0);
    }

    public long getLastRedrawTime() {
        return this.f21116o.get();
    }

    public final void m21566b() {
        if (this.f21103b) {
            requestRender();
        }
    }
}
