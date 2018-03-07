package com.facebook.video.videostreaming.opengl;

import android.opengl.EGL14;
import android.view.Surface;

/* compiled from: rotation_degrees */
public class WindowSurface extends EglSurfaceBase {
    private Surface f5444c;
    private boolean f5445d;

    public WindowSurface(EglCore eglCore, Surface surface, boolean z) {
        super(eglCore);
        m8110a((Object) surface);
        this.f5444c = surface;
        this.f5445d = z;
    }

    public final void m8124d() {
        EglCore eglCore = this.f5421b;
        EGL14.eglDestroySurface(eglCore.f5416b, this.f5422c);
        this.f5422c = EGL14.EGL_NO_SURFACE;
        this.f5424e = -1;
        this.f5423d = -1;
        if (this.f5444c != null) {
            if (this.f5445d) {
                this.f5444c.release();
            }
            this.f5444c = null;
        }
    }
}
