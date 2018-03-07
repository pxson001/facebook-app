package com.facebook.video.videostreaming.opengl;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;

@TargetApi(17)
/* compiled from: rtmp_publish_url */
public class EglSurfaceBase {
    protected static final String f5420a = EglSurfaceBase.class.getName();
    public EglCore f5421b;
    public EGLSurface f5422c = EGL14.EGL_NO_SURFACE;
    public int f5423d = -1;
    public int f5424e = -1;

    protected EglSurfaceBase(EglCore eglCore) {
        this.f5421b = eglCore;
    }

    public final void m8110a(Object obj) {
        if (this.f5422c != EGL14.EGL_NO_SURFACE) {
            throw new IllegalStateException("surface already created");
        }
        this.f5422c = this.f5421b.m8106a(obj);
    }

    public final void m8111b() {
        this.f5421b.m8108b(this.f5422c);
    }

    public final boolean m8112c() {
        EglCore eglCore = this.f5421b;
        return EGL14.eglSwapBuffers(eglCore.f5416b, this.f5422c);
    }

    public final void m8109a(long j) {
        EglCore eglCore = this.f5421b;
        EGLExt.eglPresentationTimeANDROID(eglCore.f5416b, this.f5422c, j);
    }
}
