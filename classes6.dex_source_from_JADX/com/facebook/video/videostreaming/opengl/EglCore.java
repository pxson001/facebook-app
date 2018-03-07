package com.facebook.video.videostreaming.opengl;

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
/* compiled from: runtime_minutes */
public final class EglCore {
    private static final String f5415a = EglCore.class.getName();
    public EGLDisplay f5416b;
    private EGLContext f5417c;
    private EGLConfig f5418d;
    private int f5419e;

    public EglCore() {
        this(null, 0);
    }

    public EglCore(EGLContext eGLContext, int i) {
        this.f5416b = EGL14.EGL_NO_DISPLAY;
        this.f5417c = EGL14.EGL_NO_CONTEXT;
        this.f5418d = null;
        this.f5419e = -1;
        if (this.f5416b != EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("EGL already set up");
        }
        if (eGLContext == null) {
            eGLContext = EGL14.EGL_NO_CONTEXT;
        }
        this.f5416b = EGL14.eglGetDisplay(0);
        if (this.f5416b == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (EGL14.eglInitialize(this.f5416b, iArr, 0, iArr, 1)) {
            EGLConfig a;
            EGLContext eglCreateContext;
            if ((i & 2) != 0) {
                a = m8104a(i, 3);
                if (a != null) {
                    eglCreateContext = EGL14.eglCreateContext(this.f5416b, a, eGLContext, new int[]{12440, 3, 12344}, 0);
                    if (EGL14.eglGetError() == 12288) {
                        this.f5418d = a;
                        this.f5417c = eglCreateContext;
                        this.f5419e = 3;
                    }
                }
            }
            if (this.f5417c == EGL14.EGL_NO_CONTEXT) {
                a = m8104a(i, 2);
                if (a == null) {
                    throw new RuntimeException("Unable to find a suitable EGLConfig");
                }
                eglCreateContext = EGL14.eglCreateContext(this.f5416b, a, eGLContext, new int[]{12440, 2, 12344}, 0);
                m8105a("eglCreateContext");
                this.f5418d = a;
                this.f5417c = eglCreateContext;
                this.f5419e = 2;
            }
            iArr = new int[1];
            EGL14.eglQueryContext(this.f5416b, this.f5417c, 12440, iArr, 0);
            Integer.valueOf(iArr[0]);
            return;
        }
        this.f5416b = null;
        throw new RuntimeException("unable to initialize EGL14");
    }

    private EGLConfig m8104a(int i, int i2) {
        int i3;
        if (i2 >= 3) {
            i3 = 68;
        } else {
            i3 = 4;
        }
        int[] iArr = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, i3, 12344, 0, 12344};
        if ((i & 1) != 0) {
            iArr[10] = 12610;
            iArr[11] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.f5416b, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        BLog.a(f5415a, "unable to find RGB8888 /%d EGLConfig", new Object[]{Integer.valueOf(i2)});
        return null;
    }

    public final void m8107a() {
        if (this.f5416b != EGL14.EGL_NO_DISPLAY) {
            EGL14.eglMakeCurrent(this.f5416b, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.f5416b, this.f5417c);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f5416b);
        }
        this.f5416b = EGL14.EGL_NO_DISPLAY;
        this.f5417c = EGL14.EGL_NO_CONTEXT;
        this.f5418d = null;
    }

    protected final void finalize() {
        try {
            if (this.f5416b != EGL14.EGL_NO_DISPLAY) {
                BLog.a(f5415a, "WARNING: EglCore was not explicitly released -- state may be leaked");
                m8107a();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public final EGLSurface m8106a(Object obj) {
        if ((obj instanceof Surface) || (obj instanceof SurfaceTexture)) {
            EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.f5416b, this.f5418d, obj, new int[]{12344}, 0);
            m8105a("eglCreateWindowSurface");
            if (eglCreateWindowSurface != null) {
                return eglCreateWindowSurface;
            }
            throw new RuntimeException("surface was null");
        }
        throw new RuntimeException("invalid surface: " + obj);
    }

    public final void m8108b(EGLSurface eGLSurface) {
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        if (!EGL14.eglMakeCurrent(this.f5416b, eGLSurface, eGLSurface, this.f5417c)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    private static void m8105a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }
}
