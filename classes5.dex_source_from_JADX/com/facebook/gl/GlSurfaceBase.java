package com.facebook.gl;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import com.google.common.base.Preconditions;

@TargetApi(17)
/* compiled from: WWW_GAMETIME_LEAGUE_PAGE */
public abstract class GlSurfaceBase {
    protected EGLDisplay f12337a = EGL14.EGL_NO_DISPLAY;
    protected EGLContext f12338b = EGL14.EGL_NO_CONTEXT;
    protected EGLSurface f12339c = EGL14.EGL_NO_SURFACE;
    protected EGLConfig f12340d;

    public final void m20412a() {
        if (!EGL14.eglMakeCurrent(this.f12337a, this.f12339c, this.f12339c, this.f12338b)) {
            GLHelpers.m20408b("eglMakeCurrent");
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public final void m20413b() {
        EGL14.eglSwapBuffers(this.f12337a, this.f12339c);
    }

    public final void m20415c() {
        if (this.f12339c != EGL14.EGL_NO_SURFACE) {
            EGL14.eglDestroySurface(this.f12337a, this.f12339c);
        }
        EGL14.eglDestroyContext(this.f12337a, this.f12338b);
        EGL14.eglReleaseThread();
        EGL14.eglTerminate(this.f12337a);
        this.f12337a = EGL14.EGL_NO_DISPLAY;
        this.f12338b = EGL14.EGL_NO_CONTEXT;
        this.f12339c = EGL14.EGL_NO_SURFACE;
    }

    protected final void m20416d() {
        this.f12337a = EGL14.eglGetDisplay(0);
        GLHelpers.m20408b("eglGetDisplay");
        Preconditions.checkState(this.f12337a != EGL14.EGL_NO_DISPLAY);
        int[] iArr = new int[2];
        if (EGL14.eglInitialize(this.f12337a, iArr, 0, iArr, 1)) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(this.f12337a, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                this.f12340d = eGLConfigArr[0];
                this.f12338b = EGL14.eglCreateContext(this.f12337a, this.f12340d, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                GLHelpers.m20408b("eglCreateContext");
                Preconditions.checkNotNull(this.f12338b);
                return;
            }
            GLHelpers.m20408b("eglChooseConfig");
            throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
        }
        GLHelpers.m20408b("eglInitialize");
        throw new RuntimeException("unable to initialize EGL14");
    }

    protected final EGLSurface m20411a(SurfaceTexture surfaceTexture) {
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.f12337a, this.f12340d, surfaceTexture, new int[]{12344}, 0);
        GLHelpers.m20408b("eglCreateWindowSurface");
        Preconditions.checkNotNull(eglCreateWindowSurface);
        return eglCreateWindowSurface;
    }

    public final void m20414b(SurfaceTexture surfaceTexture) {
        EGLSurface a = m20411a(surfaceTexture);
        if (EGL14.eglMakeCurrent(this.f12337a, a, a, this.f12338b)) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(16384);
            EGL14.eglSwapBuffers(this.f12337a, a);
            EGL14.eglMakeCurrent(EGL14.EGL_NO_DISPLAY, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroySurface(this.f12337a, a);
            return;
        }
        GLHelpers.m20408b("eglMakeCurrent");
        throw new RuntimeException("eglMakeCurrent");
    }
}
