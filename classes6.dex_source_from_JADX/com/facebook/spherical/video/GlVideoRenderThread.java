package com.facebook.spherical.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Message;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.time.Clock;
import com.facebook.inject.Lazy;
import com.facebook.spherical.GlMediaRenderThread;
import com.facebook.spherical.TextureRenderer;
import com.facebook.spherical.model.SphericalRendererBounds;
import com.facebook.spherical.video.SphericalVideoTextureView.GlVideoThreadController.C11471;
import com.facebook.spherical.video.SphericalVideoTextureView.GlVideoThreadController.C11471.C11461;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

@TargetApi(16)
/* compiled from: entity_type */
public class GlVideoRenderThread extends GlMediaRenderThread {
    private final String f16390q = getClass().getSimpleName();
    private final C11471 f16391r;
    public SurfaceTexture f16392s;
    private boolean f16393t;

    /* compiled from: entity_type */
    class FrameProducer implements OnFrameAvailableListener {
        final /* synthetic */ GlVideoRenderThread f16389a;

        public FrameProducer(GlVideoRenderThread glVideoRenderThread) {
            this.f16389a = glVideoRenderThread;
        }

        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            if (this.f16389a.f16131o || this.f16389a.f16123g == null) {
                this.f16389a.f16392s.setOnFrameAvailableListener(null);
            } else {
                this.f16389a.f16123g.sendEmptyMessage(3);
            }
        }
    }

    public GlVideoRenderThread(Context context, SurfaceTexture surfaceTexture, Runnable runnable, Runnable runnable2, int i, int i2, TextureRenderer textureRenderer, VideoSurfaceCreatedListener videoSurfaceCreatedListener, Lazy<FbErrorReporter> lazy, Clock clock, boolean z, SphericalRendererBounds sphericalRendererBounds, boolean z2) {
        super(context, surfaceTexture, runnable, runnable2, i, i2, textureRenderer, lazy, clock, z, sphericalRendererBounds, z2);
        this.f16391r = videoSurfaceCreatedListener;
        this.j = true;
        this.m = 0.8f;
    }

    protected final void mo1248b(int[] iArr) {
        if (!this.f16130n) {
            super.mo1248b(iArr);
            if (this.f16393t) {
                try {
                    this.f16122f.a();
                } catch (Throwable e) {
                    ((AbstractFbErrorReporter) this.f16118b.get()).a(this.f16390q, "makeCurrent failed in onVSync", e);
                    try {
                        this.f16122f.c();
                        m23712j();
                    } catch (Throwable e2) {
                        ((AbstractFbErrorReporter) this.f16118b.get()).a(this.f16390q, "Failed to recreate OutputSurface in onVSync", e2);
                        m23708c();
                        return;
                    }
                }
                this.f16392s.updateTexImage();
                this.f16392s.getTransformMatrix(this.f16119c);
                this.f16393t = false;
            }
        }
    }

    protected final boolean mo1247a(Message message) {
        if (message.what != 3) {
            return false;
        }
        this.f16393t = true;
        return true;
    }

    protected final void mo1261c(int[] iArr) {
        super.mo1261c(iArr);
        this.f16392s = new SurfaceTexture(this.f16117a.mo1254a());
        this.f16392s.setOnFrameAvailableListener(new FrameProducer(this));
        C11471 c11471 = this.f16391r;
        SurfaceTexture surfaceTexture = this.f16392s;
        int i = iArr[0];
        int i2 = iArr[1];
        Integer.valueOf(c11471.hashCode());
        Integer.valueOf(i);
        Integer.valueOf(i2);
        Integer.valueOf(surfaceTexture.hashCode());
        HandlerDetour.a(c11471.f16398a.f16401n.a, new C11461(c11471, surfaceTexture, i, i2), 1775666306);
    }

    protected final void mo1262k() {
        super.mo1262k();
        this.f16392s.setOnFrameAvailableListener(null);
        this.f16392s.release();
    }
}
