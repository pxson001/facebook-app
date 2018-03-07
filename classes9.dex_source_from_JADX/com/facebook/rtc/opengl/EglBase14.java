package com.facebook.rtc.opengl;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.Build.VERSION;

@TargetApi(18)
/* compiled from: application/vnd.wap.cert-response */
public final class EglBase14 extends EglBase {
    private static final int f19857f = VERSION.SDK_INT;
    private EGLContext f19858g;
    private EGLConfig f19859h;
    public EGLDisplay f19860i;
    public EGLSurface f19861j;

    private void m19577d() {
        if (this.f19860i == EGL14.EGL_NO_DISPLAY || this.f19858g == EGL14.EGL_NO_CONTEXT || this.f19859h == null) {
            throw new RuntimeException("This object has been released");
        }
    }

    public final void m19579a() {
        m19577d();
        if (this.f19861j != EGL14.EGL_NO_SURFACE) {
            EGL14.eglDestroySurface(this.f19860i, this.f19861j);
            this.f19861j = EGL14.EGL_NO_SURFACE;
        }
        m19578e();
        EGL14.eglDestroyContext(this.f19860i, this.f19858g);
        EGL14.eglReleaseThread();
        EGL14.eglTerminate(this.f19860i);
        this.f19858g = EGL14.EGL_NO_CONTEXT;
        this.f19860i = EGL14.EGL_NO_DISPLAY;
        this.f19859h = null;
    }

    public final void m19581b() {
        m19577d();
        if (this.f19861j == EGL14.EGL_NO_SURFACE) {
            throw new RuntimeException("No EGLSurface - can't make current");
        } else if (!EGL14.eglMakeCurrent(this.f19860i, this.f19861j, this.f19861j, this.f19858g)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    private void m19578e() {
        if (!EGL14.eglMakeCurrent(this.f19860i, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public final void m19580a(long j) {
        m19577d();
        if (this.f19861j == EGL14.EGL_NO_SURFACE) {
            throw new RuntimeException("No EGLSurface - can't swap buffers");
        }
        EGLExt.eglPresentationTimeANDROID(this.f19860i, this.f19861j, j);
        EGL14.eglSwapBuffers(this.f19860i, this.f19861j);
    }
}
