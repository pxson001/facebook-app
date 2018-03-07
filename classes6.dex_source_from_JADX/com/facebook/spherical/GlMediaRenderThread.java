package com.facebook.spherical;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.WindowManager;
import android.widget.Scroller;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.time.Clock;
import com.facebook.gl.GlOutputSurface;
import com.facebook.inject.Lazy;
import com.facebook.spherical.model.SphericalRendererBounds;
import com.facebook.spherical.photo.RendererActionListener;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

@TargetApi(16)
/* compiled from: event_cancel */
public class GlMediaRenderThread extends HandlerThread implements SensorEventListener {
    public static Clock f16101r;
    private static int f16102s = 15;
    private final float[] f16103A = new float[16];
    private final float[] f16104B = new float[16];
    @GuardedBy("ViewportOrientationTracker.lock")
    public final ViewportOrientationTracker f16105C = new ViewportOrientationTracker();
    public boolean f16106D;
    public boolean f16107E;
    public boolean f16108F;
    public boolean f16109G = false;
    private boolean f16110H = true;
    public boolean f16111I = false;
    public boolean f16112J = false;
    public float f16113K = 0.0f;
    public float f16114L = 0.0f;
    private int f16115M;
    private Throwable f16116N;
    protected final TextureRenderer f16117a;
    protected final Lazy<FbErrorReporter> f16118b;
    protected final float[] f16119c = new float[16];
    @GuardedBy("ViewParam.lock")
    public final ViewParam f16120d = new ViewParam();
    @GuardedBy("RenderThreadController.lock")
    public final RenderThreadController f16121e;
    protected GlOutputSurface f16122f;
    public Handler f16123g;
    protected Runnable f16124h;
    protected Runnable f16125i;
    protected boolean f16126j;
    public float f16127k = 90.0f;
    public float f16128l = 90.0f;
    public float f16129m = 1.0f;
    protected volatile boolean f16130n;
    public volatile boolean f16131o;
    public float f16132p = 70.0f;
    private final String f16133q = getClass().getSimpleName();
    private final SurfaceTexture f16134t;
    private final SensorEventListener f16135u = new RotationSensorEventListener(this);
    public final FrameCallback f16136v = new ChoreographerCallback(this);
    public final Scroller f16137w;
    public final Choreographer f16138x;
    private final WindowManager f16139y;
    private final SensorManager f16140z;

    /* compiled from: event_cancel */
    class ChoreographerCallback implements FrameCallback {
        final /* synthetic */ GlMediaRenderThread f16091a;

        public ChoreographerCallback(GlMediaRenderThread glMediaRenderThread) {
            this.f16091a = glMediaRenderThread;
        }

        public void doFrame(long j) {
            if (this.f16091a.f16131o || this.f16091a.f16123g == null) {
                this.f16091a.f16138x.removeFrameCallback(this.f16091a.f16136v);
            } else {
                this.f16091a.f16123g.sendEmptyMessage(1);
            }
        }
    }

    /* compiled from: event_cancel */
    class RotationSensorEventListener implements SensorEventListener {
        final /* synthetic */ GlMediaRenderThread f16092a;
        private final Quaternion f16093b = new Quaternion();
        private final float[] f16094c = new float[4];

        public RotationSensorEventListener(GlMediaRenderThread glMediaRenderThread) {
            this.f16092a = glMediaRenderThread;
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 15 || sensorEvent.sensor.getType() == 11) {
                this.f16092a.f16121e.f16054a.lock();
                this.f16092a.f16121e.mo1237a(sensorEvent);
                if (!this.f16092a.f16111I) {
                    this.f16092a.f16111I = true;
                    if (this.f16092a.mo1249b()) {
                        this.f16092a.m23711d(this.f16092a.f16113K, this.f16092a.f16114L);
                        this.f16092a.f16121e.mo1235a(1.0f);
                        this.f16092a.f16112J = true;
                    }
                }
                this.f16092a.f16121e.f16054a.unlock();
            }
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    /* compiled from: event_cancel */
    public class ViewParam {
        public final Lock f16095a = new ReentrantLock();
        public int f16096b;
        public int f16097c;
        public final float[] f16098d = new float[16];
        public int f16099e;
        public int f16100f;

        ViewParam() {
        }
    }

    public GlMediaRenderThread(Context context, SurfaceTexture surfaceTexture, Runnable runnable, Runnable runnable2, int i, int i2, TextureRenderer textureRenderer, Lazy<FbErrorReporter> lazy, Clock clock, boolean z, SphericalRendererBounds sphericalRendererBounds, boolean z2) {
        super("GlMediaRenderThread");
        this.f16134t = surfaceTexture;
        this.f16124h = runnable;
        this.f16125i = runnable2;
        this.f16117a = textureRenderer;
        this.f16118b = lazy;
        f16101r = clock;
        this.f16138x = Choreographer.getInstance();
        this.f16140z = (SensorManager) context.getSystemService("sensor");
        this.f16139y = (WindowManager) context.getSystemService("window");
        this.f16137w = new Scroller(context, null, true);
        if (!z2 || z) {
            this.f16121e = new FullScreenRenderThreadController(this.f16140z, this.f16139y);
        } else {
            this.f16121e = new FeedRenderThreadController(this.f16140z, this.f16139y, sphericalRendererBounds);
        }
        mo1246a(i, i2, false);
    }

    public synchronized void start() {
        super.start();
        this.f16123g = new Handler(this, getLooper()) {
            final int[] f16089a = new int[2];
            final /* synthetic */ GlMediaRenderThread f16090b;

            public void handleMessage(Message message) {
                if (this.f16090b.isInterrupted()) {
                    GlMediaRenderThread.m23699l(this.f16090b);
                } else if (!this.f16090b.mo1247a(message)) {
                    switch (message.what) {
                        case 0:
                            GlMediaRenderThread glMediaRenderThread = this.f16090b;
                            int[] iArr = this.f16089a;
                            glMediaRenderThread.f16120d.f16095a.lock();
                            iArr[0] = glMediaRenderThread.f16120d.f16096b;
                            iArr[1] = glMediaRenderThread.f16120d.f16097c;
                            glMediaRenderThread.f16120d.f16095a.unlock();
                            glMediaRenderThread.f16121e.f16054a.lock();
                            glMediaRenderThread.f16121e.f16068o = glMediaRenderThread.f16129m;
                            glMediaRenderThread.f16121e.mo1239b(glMediaRenderThread.f16127k, glMediaRenderThread.f16128l);
                            glMediaRenderThread.f16121e.f16054a.unlock();
                            glMediaRenderThread.mo1261c(iArr);
                            return;
                        case 1:
                            this.f16090b.mo1248b(this.f16089a);
                            return;
                        case 2:
                            GlMediaRenderThread.m23699l(this.f16090b);
                            return;
                        default:
                            return;
                    }
                }
            }
        };
        this.f16123g.sendEmptyMessage(0);
    }

    protected void mo1248b(int[] iArr) {
        if (!this.f16130n) {
            this.f16138x.postFrameCallback(this.f16136v);
            m23698d(iArr);
            this.f16117a.mo1255a(this.f16103A, this.f16119c, iArr[0], iArr[1]);
            this.f16122f.b();
            if (this.f16112J && (this instanceof RendererActionListener)) {
                this.f16112J = false;
                ((RendererActionListener) this).mo1250e(true);
            }
        }
    }

    protected boolean mo1247a(Message message) {
        return false;
    }

    public static void m23699l(GlMediaRenderThread glMediaRenderThread) {
        Integer.valueOf(glMediaRenderThread.hashCode());
        glMediaRenderThread.quit();
        glMediaRenderThread.mo1262k();
    }

    protected boolean mo1249b() {
        return this.f16109G;
    }

    public final void m23702a(float f) {
        this.f16132p = f;
        mo1246a(-1, -1, true);
    }

    public final void m23703a(float f, float f2) {
        this.f16113K = f;
        this.f16114L = f2;
        if (this.f16110H) {
            this.f16110H = false;
            this.f16121e.f16054a.lock();
            this.f16121e.mo1236a(f, f2);
            this.f16121e.f16054a.unlock();
        }
    }

    public final void m23708c() {
        this.f16130n = true;
        this.f16140z.unregisterListener(this);
    }

    public final void m23710d() {
        if (this.f16130n) {
            this.f16138x.postFrameCallback(this.f16136v);
            this.f16130n = false;
            m23700m();
        }
    }

    public final void m23711d(float f, float f2) {
        this.f16121e.f16054a.lock();
        this.f16121e.mo1241d(f, f2);
        this.f16121e.f16054a.unlock();
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.f16107E) {
            this.f16135u.onSensorChanged(sensorEvent);
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    protected final void m23712j() {
        this.f16122f = new GlOutputSurface(this.f16134t);
        this.f16122f.a();
        this.f16117a.mo1256b();
    }

    public void mo1261c(int[] iArr) {
        Integer.valueOf(hashCode());
        try {
            m23712j();
            if (this.f16115M != 0) {
                ((AbstractFbErrorReporter) this.f16118b.get()).a("GlMediaRenderThread-" + this.f16115M, "Succeeded creating an OutputSurface after " + this.f16115M + " retries!", this.f16116N);
                this.f16116N = null;
            }
            m23700m();
            this.f16138x.postFrameCallback(this.f16136v);
        } catch (Throwable e) {
            Throwable th = e;
            if (this.f16115M == 0) {
                ((AbstractFbErrorReporter) this.f16118b.get()).a(this.f16133q, "Failed to create OutputSurface", th);
            }
            this.f16116N = th;
            if (this.f16122f != null) {
                this.f16122f.c();
                this.f16122f = null;
            }
            int i = this.f16115M + 1;
            this.f16115M = i;
            if (i > 2) {
                ((AbstractFbErrorReporter) this.f16118b.get()).a("GlMediaRenderThread-" + this.f16115M, "Failed to create OutputSurface after " + this.f16115M + " retries! Aborting!", th);
                this.f16116N = null;
                throw th;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e2) {
            }
            this.f16123g.sendEmptyMessage(0);
        }
    }

    private void m23700m() {
        boolean registerListener = this.f16140z.registerListener(this, this.f16140z.getDefaultSensor(f16102s), 1);
        if (!registerListener) {
            f16102s = 11;
            boolean registerListener2 = this.f16140z.registerListener(this, this.f16140z.getDefaultSensor(f16102s), 1);
            ((AbstractFbErrorReporter) this.f16118b.get()).a(this.f16133q + ".registerSensorListener", "Device failed to register listener for " + m23701n());
            registerListener = registerListener2;
        }
        if (!registerListener) {
            ((AbstractFbErrorReporter) this.f16118b.get()).a(this.f16133q + ".registerSensorListener", "Device failed to register listener for " + m23701n());
        }
    }

    public void mo1262k() {
        boolean z = false;
        Integer.valueOf(hashCode());
        this.f16138x.removeFrameCallback(this.f16136v);
        this.f16140z.unregisterListener(this);
        this.f16111I = false;
        if (this.f16122f != null) {
            if (this.f16124h != null) {
                try {
                    this.f16122f.a();
                    GLES20.glClear(16384);
                    this.f16122f.b();
                } catch (Throwable e) {
                    ((AbstractFbErrorReporter) this.f16118b.get()).a(this.f16133q + ".releaseResources", "Error encountered in clearing the SurfaceTexture", e);
                    z = true;
                }
            }
            this.f16122f.c();
            this.f16122f = null;
            if (this.f16124h != null) {
                HandlerDetour.a(new Handler(Looper.getMainLooper()), z ? this.f16125i : this.f16124h, 1590365779);
            }
        }
        this.f16123g = null;
    }

    private void m23698d(int[] iArr) {
        if (this.f16120d.f16095a.tryLock()) {
            double d;
            iArr[0] = this.f16120d.f16096b;
            iArr[1] = this.f16120d.f16097c;
            if (!this.f16137w.isFinished()) {
                this.f16137w.computeScrollOffset();
                int currX = this.f16137w.getCurrX() - this.f16120d.f16099e;
                int currY = this.f16137w.getCurrY() - this.f16120d.f16100f;
                this.f16120d.f16099e = this.f16137w.getCurrX();
                this.f16120d.f16100f = this.f16137w.getCurrY();
                this.f16121e.f16054a.lock();
                this.f16121e.mo1240c((float) currX, (float) currY);
                this.f16121e.f16054a.unlock();
            }
            this.f16120d.f16095a.unlock();
            this.f16121e.f16054a.lock();
            this.f16121e.mo1238a(this.f16104B);
            this.f16121e.f16054a.unlock();
            Matrix.multiplyMM(this.f16103A, 0, this.f16120d.f16098d, 0, this.f16104B, 0);
            this.f16105C.a.lock();
            this.f16105C.c = ((float) this.f16120d.f16096b) / ((float) this.f16120d.f16097c);
            this.f16105C.b = this.f16132p;
            this.f16105C.d = ViewportOrientationTracker.a(this.f16103A);
            this.f16105C.e = ViewportOrientationTracker.c(this.f16103A);
            ViewportOrientationTracker viewportOrientationTracker = this.f16105C;
            float[] fArr = this.f16103A;
            if (fArr[4] > 0.998f) {
                d = 1.5707963267948966d;
            } else if (fArr[4] < -0.998f) {
                d = -1.5707963267948966d;
            } else {
                d = Math.asin((double) fArr[4]);
            }
            viewportOrientationTracker.f = (float) (-Math.toDegrees(d));
            this.f16105C.a.unlock();
        }
    }

    public void mo1246a(int i, int i2, boolean z) {
        this.f16120d.f16095a.lock();
        if (i > 0) {
            this.f16120d.f16096b = i;
        }
        if (i2 > 0) {
            this.f16120d.f16097c = i2;
        }
        Matrix.perspectiveM(this.f16120d.f16098d, 0, this.f16132p, ((float) this.f16120d.f16096b) / ((float) this.f16120d.f16097c), 0.1f, 100.0f);
        this.f16120d.f16095a.unlock();
    }

    private static String m23701n() {
        return f16102s == 15 ? "TYPE_GAME_ROTATION_VECTOR" : "TYPE_ROTATION_VECTOR";
    }
}
