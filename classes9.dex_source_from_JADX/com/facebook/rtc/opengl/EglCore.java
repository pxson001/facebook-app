package com.facebook.rtc.opengl;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.facebook.debug.log.BLog;

@TargetApi(17)
/* compiled from: application/vnd.syncml.notification */
public final class EglCore {
    private static final Class<?> f19862a = EglCore.class;
    public EGLDisplay f19863b = EGL14.EGL_NO_DISPLAY;
    private EGLContext f19864c = EGL14.EGL_NO_CONTEXT;
    private EGLConfig f19865d = null;

    public EglCore() {
        if (this.f19863b != EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("EGL already set up");
        }
        this.f19863b = EGL14.eglGetDisplay(0);
        if (this.f19863b == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (EGL14.eglInitialize(this.f19863b, iArr, 0, iArr, 1)) {
            if (this.f19864c == EGL14.EGL_NO_CONTEXT) {
                EGLConfig c = m19583c();
                if (c == null) {
                    throw new RuntimeException("Unable to find a suitable EGLConfig");
                }
                EGLContext eglCreateContext = EGL14.eglCreateContext(this.f19863b, c, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                m19582a("eglCreateContext");
                this.f19865d = c;
                this.f19864c = eglCreateContext;
            }
            EGL14.eglQueryContext(this.f19863b, this.f19864c, 12440, new int[1], 0);
            return;
        }
        this.f19863b = null;
        throw new RuntimeException("unable to initialize EGL14");
    }

    private EGLConfig m19583c() {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.f19863b, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        return null;
    }

    public final void m19586a() {
        if (this.f19863b != EGL14.EGL_NO_DISPLAY) {
            EGL14.eglMakeCurrent(this.f19863b, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.f19863b, this.f19864c);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f19863b);
        }
        this.f19863b = EGL14.EGL_NO_DISPLAY;
        this.f19864c = EGL14.EGL_NO_CONTEXT;
        this.f19865d = null;
    }

    protected final void finalize() {
        try {
            if (this.f19863b != EGL14.EGL_NO_DISPLAY) {
                BLog.a(f19862a, "WARNING: EglCore was not explicitly released -- state may be leaked");
                m19586a();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public final EGLSurface m19585a(Object obj) {
        if ((obj instanceof Surface) || (obj instanceof SurfaceTexture)) {
            EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.f19863b, this.f19865d, obj, new int[]{12344}, 0);
            m19582a("eglCreateWindowSurface");
            if (eglCreateWindowSurface != null) {
                return eglCreateWindowSurface;
            }
            throw new RuntimeException("surface was null");
        }
        throw new RuntimeException("invalid surface: " + obj);
    }

    public final void m19588b(EGLSurface eGLSurface) {
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        if (!EGL14.eglMakeCurrent(this.f19863b, eGLSurface, eGLSurface, this.f19864c)) {
            throw new RuntimeException("eglMakeCurrent failed");
        } else if (!EGL14.eglSwapInterval(this.f19863b, 0)) {
            throw new RuntimeException("engSwapInterval failed");
        }
    }

    public final void m19587b() {
        if (!EGL14.eglMakeCurrent(this.f19863b, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public final int m19584a(EGLSurface eGLSurface, int i) {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.f19863b, eGLSurface, i, iArr, 0);
        return iArr[0];
    }

    private static void m19582a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }
}
