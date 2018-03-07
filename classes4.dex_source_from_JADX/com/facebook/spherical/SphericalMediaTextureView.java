package com.facebook.spherical;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.facebook.spherical.GlMediaRenderThread.ViewParam;
import com.facebook.spherical.model.SphericalRendererBounds;
import com.facebook.spherical.model.SphericalRendererBounds.Builder;
import com.facebook.spherical.photo.GlPhotoRenderThread;
import com.facebook.spherical.photo.SphericalPhotoTextureView;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

@TargetApi(14)
/* compiled from: payments_sync_gk_override_off_ms */
public abstract class SphericalMediaTextureView extends TextureView {
    public final Handler f5300a;
    public boolean f5301b;
    public SphericalRendererBounds f5302c;
    public boolean f5303d;
    @Nullable
    public GlThreadController f5304e;
    public boolean f5305f;
    public boolean f5306g;
    public boolean f5307h;
    public boolean f5308i;
    private float f5309j;
    private float f5310k;
    private float f5311l;

    protected abstract GlThreadController m5838a(SurfaceTextureListener surfaceTextureListener);

    public SphericalMediaTextureView(Context context) {
        this(context, null, 0);
    }

    public SphericalMediaTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SphericalMediaTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5300a = new Handler(Looper.getMainLooper());
        this.f5301b = false;
        this.f5302c = new Builder().c();
        this.f5303d = false;
        this.f5305f = false;
        this.f5306g = false;
        this.f5307h = true;
        this.f5308i = false;
        this.f5309j = -1.0f;
    }

    @TargetApi(17)
    public final void m5841a(SurfaceTexture surfaceTexture, Runnable runnable, Runnable runnable2) {
        Preconditions.checkState(this.f5304e != null);
        GlThreadController.a(this.f5304e, surfaceTexture, runnable, runnable2, getWidth(), getHeight());
        setSurfaceTexture(surfaceTexture);
    }

    public void setSurfaceTextureListener(SurfaceTextureListener surfaceTextureListener) {
        if (surfaceTextureListener != null) {
            Preconditions.checkState(this.f5304e == null);
            this.f5304e = m5838a(surfaceTextureListener);
            super.setSurfaceTextureListener(this.f5304e);
            return;
        }
        if (this.f5304e != null) {
            GlThreadController.c(this.f5304e);
            this.f5304e = null;
        }
        super.setSurfaceTextureListener(null);
    }

    public final void m5839a() {
        if (this.f5304e != null) {
            this.f5304e.a();
        }
    }

    public final void m5843c() {
        if (this.f5304e != null && this.f5304e.c != null) {
            this.f5304e.c.c();
        }
    }

    public void setPreferredVerticalFOV(float f) {
        if (!(this.f5304e == null || this.f5304e.c == null)) {
            this.f5304e.c.a(f);
        }
        this.f5309j = f;
    }

    public final void m5840a(float f, float f2) {
        this.f5310k = f;
        this.f5311l = f2;
        if (this.f5304e != null && this.f5304e.c != null) {
            this.f5304e.c.a(this.f5310k, this.f5311l);
        }
    }

    public final void m5845d() {
        if (this.f5304e != null && this.f5304e.c != null) {
            this.f5304e.c.w.forceFinished(true);
        }
    }

    public final void m5842b(float f, float f2) {
        if (this.f5304e != null && this.f5304e.c != null) {
            GlMediaRenderThread glMediaRenderThread = this.f5304e.c;
            Long valueOf = Long.valueOf(GlMediaRenderThread.r.a() / 1000);
            glMediaRenderThread.d.a.lock();
            float a = RenderThreadUtil.a(-f, glMediaRenderThread.d.c, glMediaRenderThread.p);
            float a2 = RenderThreadUtil.a(-f2, glMediaRenderThread.d.c, glMediaRenderThread.p);
            ViewParam viewParam = glMediaRenderThread.d;
            viewParam.e = (int) (((float) viewParam.e) + a);
            viewParam = glMediaRenderThread.d;
            viewParam.f = (int) (((float) viewParam.f) + a2);
            glMediaRenderThread.d.a.unlock();
            glMediaRenderThread.e.a.lock();
            glMediaRenderThread.e.c(a, a2);
            glMediaRenderThread.e.a.unlock();
            glMediaRenderThread.C.f4744a.lock();
            glMediaRenderThread.C.f4750g = valueOf.longValue();
            glMediaRenderThread.C.f4744a.unlock();
        }
    }

    public final void m5844c(float f, float f2) {
        if (this.f5304e != null && this.f5304e.c != null) {
            GlMediaRenderThread glMediaRenderThread = this.f5304e.c;
            glMediaRenderThread.d.a.lock();
            int round = Math.round(RenderThreadUtil.a(f, glMediaRenderThread.d.c, glMediaRenderThread.p));
            int round2 = Math.round(RenderThreadUtil.a(f2, glMediaRenderThread.d.c, glMediaRenderThread.p));
            int i = glMediaRenderThread.d.e;
            int i2 = glMediaRenderThread.d.f;
            glMediaRenderThread.d.a.unlock();
            glMediaRenderThread.w.fling(i, i2, round, round2, i - 720, i + 720, i2 - 720, i2 + 720);
        }
    }

    public final void m5846g() {
        this.f5306g = false;
        m5837b(this);
    }

    public float getYaw() {
        if (this.f5304e == null || this.f5304e.c == null) {
            return 0.0f;
        }
        GlMediaRenderThread glMediaRenderThread = this.f5304e.c;
        return glMediaRenderThread.C.f4747d - glMediaRenderThread.k;
    }

    public float getPitch() {
        if (this.f5304e == null || this.f5304e.c == null) {
            return 0.0f;
        }
        return this.f5304e.c.C.f4748e;
    }

    public float getRoll() {
        if (this.f5304e == null || this.f5304e.c == null) {
            return 0.0f;
        }
        return this.f5304e.c.C.f4749f;
    }

    public float getFov() {
        if (this.f5304e == null || this.f5304e.c == null) {
            return 70.0f;
        }
        return this.f5304e.c.p;
    }

    public static void m5837b(SphericalMediaTextureView sphericalMediaTextureView) {
        if (sphericalMediaTextureView.f5304e != null && sphericalMediaTextureView.f5304e.c != null) {
            sphericalMediaTextureView.f5304e.c.D = sphericalMediaTextureView.f5305f;
            sphericalMediaTextureView.f5304e.c.F = sphericalMediaTextureView.f5306g;
            sphericalMediaTextureView.f5304e.c.E = sphericalMediaTextureView.f5307h;
            sphericalMediaTextureView.f5304e.c.G = sphericalMediaTextureView.f5308i;
            if (sphericalMediaTextureView.f5309j != -1.0f) {
                sphericalMediaTextureView.f5304e.c.a(sphericalMediaTextureView.f5309j);
            }
            sphericalMediaTextureView.f5304e.c.a(sphericalMediaTextureView.f5310k, sphericalMediaTextureView.f5311l);
            if ((sphericalMediaTextureView.f5304e.c instanceof GlPhotoRenderThread) && (sphericalMediaTextureView instanceof SphericalPhotoTextureView)) {
                ((GlPhotoRenderThread) sphericalMediaTextureView.f5304e.c).q = ((SphericalPhotoTextureView) sphericalMediaTextureView).k;
            }
        }
    }
}
