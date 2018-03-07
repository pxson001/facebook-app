package com.facebook.livephotos.egl;

import android.view.Surface;

/* compiled from: pause_updates */
public abstract class GLSurfaceBase {
    public final GLContext f6681a;
    public Surface f6682b;

    abstract void mo363b();

    public GLSurfaceBase(GLContext gLContext) {
        this.f6681a = gLContext;
    }
}
