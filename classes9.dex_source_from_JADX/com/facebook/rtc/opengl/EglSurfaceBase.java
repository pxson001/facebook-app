package com.facebook.rtc.opengl;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLSurface;

@TargetApi(17)
/* compiled from: application/vnd.syncml.ds.notification */
public class EglSurfaceBase {
    private static final Class<?> f19866b = EglSurfaceBase.class;
    public EglCore f19867a;
    public EGLSurface f19868c = EGL14.EGL_NO_SURFACE;

    protected EglSurfaceBase(EglCore eglCore) {
        this.f19867a = eglCore;
    }

    public final void m19589a(Object obj) {
        if (this.f19868c != EGL14.EGL_NO_SURFACE) {
            throw new IllegalStateException("surface already created");
        }
        this.f19868c = this.f19867a.m19585a(obj);
    }

    public final void m19590d() {
        this.f19867a.m19588b(this.f19868c);
    }
}
