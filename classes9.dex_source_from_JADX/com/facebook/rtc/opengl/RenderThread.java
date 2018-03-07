package com.facebook.rtc.opengl;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Looper;
import android.view.WindowManager;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.facebook.rtc.services.BackgroundVideoCallService.C23404;
import com.facebook.rtc.services.BackgroundVideoCallService.C23459;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;

@TargetApi(16)
/* compiled from: application/vnd.oma.drm.message */
public class RenderThread extends Thread implements OnFrameAvailableListener {
    private static final Class<?> f19878b = RenderThread.class;
    public C23459 f19879a = null;
    private final WindowManager f19880c;
    public volatile RenderHandler f19881d;
    private final Object f19882e = new Object();
    private boolean f19883f = false;
    private EglCore f19884g;
    private WindowSurface f19885h;
    private int f19886i;
    private int f19887j;
    public SurfaceTexture f19888k;
    private final float[] f19889l = new float[16];
    private Texture2dProgram f19890m;
    private final Sprite2d f19891n = new Sprite2d();
    public C23404 f19892o;
    private boolean f19893p;
    private boolean f19894q;
    public final AwakeTimeSinceBootClock f19895r = AwakeTimeSinceBootClock.INSTANCE;
    public long f19896s;

    public RenderThread(WindowManager windowManager) {
        this.f19880c = windowManager;
    }

    public void run() {
        Looper.prepare();
        this.f19881d = new RenderHandler(this);
        synchronized (this.f19882e) {
            this.f19883f = true;
            ObjectDetour.b(this.f19882e, -933704868);
        }
        this.f19884g = new EglCore();
        Looper.loop();
        m19605h();
        this.f19884g.m19586a();
        synchronized (this.f19882e) {
            this.f19883f = false;
        }
    }

    public final void m19607a() {
        synchronized (this.f19882e) {
            while (!this.f19883f) {
                try {
                    ObjectDetour.a(this.f19882e, 2018344075);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public final RenderHandler m19612c() {
        return this.f19881d;
    }

    public final void m19610a(boolean z) {
        this.f19893p = z;
    }

    public final void m19611b(boolean z) {
        this.f19894q = z;
    }

    public final void m19609a(SurfaceTexture surfaceTexture) {
        if (this.f19885h != null) {
            this.f19885h.m19590d();
            this.f19892o.m19632a(this.f19888k);
            return;
        }
        this.f19885h = new WindowSurface(this.f19884g, surfaceTexture);
        this.f19885h.m19590d();
        this.f19890m = new Texture2dProgram();
        Texture2dProgram texture2dProgram = this.f19890m;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GlUtil.m19600a("glGenTextures");
        int i = iArr[0];
        GLES20.glBindTexture(texture2dProgram.f19911h, i);
        GlUtil.m19600a("glBindTexture " + i);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GlUtil.m19600a("glTexParameter");
        int i2 = i;
        this.f19888k = new SurfaceTexture(i2);
        this.f19891n.f19899c = i2;
        EglSurfaceBase eglSurfaceBase = this.f19885h;
        this.f19886i = eglSurfaceBase.f19867a.m19584a(eglSurfaceBase.f19868c, 12375);
        eglSurfaceBase = this.f19885h;
        this.f19887j = eglSurfaceBase.f19867a.m19584a(eglSurfaceBase.f19868c, 12374);
        m19606i();
        this.f19892o.m19632a(this.f19888k);
        this.f19888k.setOnFrameAvailableListener(this);
    }

    private void m19605h() {
        GlUtil.m19600a("releaseGl start");
        if (this.f19885h != null) {
            EglSurfaceBase eglSurfaceBase = this.f19885h;
            EglCore eglCore = eglSurfaceBase.f19867a;
            EGL14.eglDestroySurface(eglCore.f19863b, eglSurfaceBase.f19868c);
            eglSurfaceBase.f19868c = EGL14.EGL_NO_SURFACE;
            if (eglSurfaceBase.f19912b != null) {
                if (eglSurfaceBase.f19913c) {
                    eglSurfaceBase.f19912b.release();
                }
                eglSurfaceBase.f19912b = null;
            }
            this.f19885h = null;
        }
        if (this.f19890m != null) {
            Texture2dProgram texture2dProgram = this.f19890m;
            Integer.valueOf(texture2dProgram.f19905b);
            GLES20.glDeleteProgram(texture2dProgram.f19905b);
            texture2dProgram.f19905b = -1;
            this.f19890m = null;
        }
        if (this.f19888k != null) {
            this.f19888k.release();
            this.f19888k = null;
        }
        GlUtil.m19600a("releaseGl done");
        this.f19884g.m19587b();
    }

    public final void m19608a(int i, int i2) {
        this.f19886i = i;
        this.f19887j = i2;
        m19606i();
    }

    public final void m19613d() {
        m19605h();
    }

    private void m19606i() {
        float f;
        int i = this.f19886i;
        int i2 = this.f19887j;
        if (i > i2) {
            f = ((float) i) / ((float) i2);
        } else {
            f = ((float) i2) / ((float) i);
        }
        this.f19891n.f19903g = f;
        GLES20.glViewport(0, 0, i, i2);
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        RenderHandler renderHandler = this.f19881d;
        renderHandler.sendMessage(renderHandler.obtainMessage(4));
    }

    public final void m19614g() {
        GlUtil.m19600a("draw start");
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        Matrix.setIdentityM(this.f19889l, 0);
        switch (this.f19880c.getDefaultDisplay().getRotation()) {
            case 1:
                Matrix.rotateM(this.f19889l, 0, 90.0f, 0.0f, 0.0f, 1.0f);
                break;
            case 3:
                Matrix.rotateM(this.f19889l, 0, -90.0f, 0.0f, 0.0f, 1.0f);
                break;
        }
        if (this.f19893p && this.f19880c.getDefaultDisplay().getRotation() == 0) {
            Matrix.rotateM(this.f19889l, 0, 180.0f, 0.0f, 0.0f, 1.0f);
        }
        if (!this.f19893p && this.f19894q) {
            Matrix.rotateM(this.f19889l, 0, 180.0f, 0.0f, 0.0f, 1.0f);
        }
        this.f19891n.m19616a(this.f19890m, this.f19889l);
        EglSurfaceBase eglSurfaceBase = this.f19885h;
        EglCore eglCore = eglSurfaceBase.f19867a;
        boolean eglSwapBuffers = EGL14.eglSwapBuffers(eglCore.f19863b, eglSurfaceBase.f19868c);
        GlUtil.m19600a("draw done");
    }
}
