package com.facebook.gl;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import com.google.common.base.Preconditions;

@TargetApi(17)
/* compiled from: WWW_FEED_SNOWLIFT */
public class GlPbufferSurface extends GlSurfaceBase {
    public GlPbufferSurface(int i, int i2) {
        m20416d();
        this.c = EGL14.eglCreatePbufferSurface(this.f12337a, this.f12340d, new int[]{12375, i, 12374, i2, 12344}, 0);
        GLHelpers.m20408b("eglCreatePbufferSurface");
        Preconditions.checkNotNull(this.f12339c);
    }
}
