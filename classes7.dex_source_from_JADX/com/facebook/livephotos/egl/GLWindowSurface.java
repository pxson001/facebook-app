package com.facebook.livephotos.egl;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.view.Surface;

/* compiled from: partDefinition */
public class GLWindowSurface extends GLSurfaceBase {
    protected EGLSurface f6687c;
    private boolean f6688d;

    public GLWindowSurface(GLContext gLContext, Surface surface) {
        boolean z;
        super(gLContext);
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(gLContext.f6661f, gLContext.f6660e, surface, gLContext.f6658c, 0);
        GLContext.m8562b("eglCreateWindowSurface");
        this.f6687c = eglCreateWindowSurface;
        EGLSurface eGLSurface = this.f6687c;
        if (eGLSurface == null || eGLSurface == EGL14.EGL_NO_SURFACE) {
            z = false;
        } else {
            z = true;
        }
        this.f6688d = z;
        this.b = surface;
    }

    public final EGLSurface m8572a() {
        m8571g();
        return this.f6687c;
    }

    public final void m8574c() {
        m8571g();
        GLContext gLContext = this.f6681a;
        EGLSurface eGLSurface = this.f6687c;
        EGL14.eglMakeCurrent(gLContext.f6661f, eGLSurface, eGLSurface, gLContext.f6662g);
    }

    public final void mo363b() {
        GLContext gLContext = this.f6681a;
        EGLSurface eGLSurface = this.f6687c;
        EGL14.eglMakeCurrent(gLContext.f6661f, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
        boolean eglDestroySurface = EGL14.eglDestroySurface(gLContext.f6661f, eGLSurface);
    }

    private void m8571g() {
        if (this.f6687c == null) {
            throw new IllegalStateException("mEglSurface must be set in the constructor");
        }
    }
}
