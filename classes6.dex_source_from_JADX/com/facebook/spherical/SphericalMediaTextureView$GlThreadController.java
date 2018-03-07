package com.facebook.spherical;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import com.facebook.debug.log.BLog;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: eventTime */
public abstract class SphericalMediaTextureView$GlThreadController implements SurfaceTextureListener {
    protected final String f16147a = SphericalMediaTextureView$GlThreadController.class.getSimpleName();
    public final SurfaceTextureListener f16148b;
    @Nullable
    public GlMediaRenderThread f16149c;
    protected SurfaceTexture f16150d;
    protected Runnable f16151e;
    protected Runnable f16152f;
    protected boolean f16153g;
    protected boolean f16154h;
    protected int f16155i;
    protected int f16156j;
    final /* synthetic */ SphericalMediaTextureView f16157k;

    protected abstract GlMediaRenderThread mo1257b();

    public SphericalMediaTextureView$GlThreadController(SphericalMediaTextureView sphericalMediaTextureView, SurfaceTextureListener surfaceTextureListener) {
        this.f16157k = sphericalMediaTextureView;
        this.f16148b = (SurfaceTextureListener) Preconditions.checkNotNull(surfaceTextureListener);
    }

    @SuppressLint({"BadMethodUse-java.lang.Thread.start"})
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f16154h = true;
        m23723a(surfaceTexture, null, null, i, i2);
    }

    private void m23723a(SurfaceTexture surfaceTexture, Runnable runnable, Runnable runnable2, int i, int i2) {
        Integer.valueOf(i);
        Integer.valueOf(i2);
        this.f16155i = i;
        this.f16156j = i2;
        this.f16151e = runnable;
        this.f16152f = runnable2;
        this.f16150d = surfaceTexture;
        if (this.f16153g) {
            m23726a();
            this.f16153g = false;
        }
    }

    public void m23726a() {
        boolean z = true;
        if (this.f16150d == null) {
            BLog.a(this.f16147a, "id:%d beginRendering surface texture is null", new Object[]{Integer.valueOf(hashCode())});
            this.f16153g = true;
        } else if (this.f16149c != null) {
            Integer.valueOf(hashCode());
            this.f16149c.m23710d();
        } else {
            Integer.valueOf(hashCode());
            Integer.valueOf(this.f16150d.hashCode());
            if (this.f16149c != null) {
                z = false;
            }
            Preconditions.checkArgument(z);
            this.f16149c = mo1257b();
            SphericalMediaTextureView.b(this.f16157k);
            Preconditions.checkNotNull(this.f16149c);
            this.f16149c.start();
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Integer.valueOf(hashCode());
        Integer.valueOf(i);
        Integer.valueOf(i2);
        this.f16155i = i;
        this.f16156j = i2;
        if (this.f16149c != null) {
            this.f16149c.mo1246a(i, i2, false);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f16157k.setOnTouchListener(null);
        m23725c(this);
        this.f16150d = null;
        return this.f16154h;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.f16148b.onSurfaceTextureUpdated(surfaceTexture);
    }

    public static void m23725c(SphericalMediaTextureView$GlThreadController sphericalMediaTextureView$GlThreadController) {
        if (sphericalMediaTextureView$GlThreadController.f16149c != null) {
            GlMediaRenderThread glMediaRenderThread = sphericalMediaTextureView$GlThreadController.f16149c;
            if (glMediaRenderThread.f16123g != null) {
                glMediaRenderThread.f16123g.sendEmptyMessage(2);
            }
            glMediaRenderThread.f16131o = true;
            sphericalMediaTextureView$GlThreadController.f16149c = null;
        }
    }
}
