package com.facebook.spherical.photo;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import android.os.Message;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.Clock;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.inject.Lazy;
import com.facebook.spherical.FeedRenderThreadController;
import com.facebook.spherical.GlMediaRenderThread;
import com.facebook.spherical.TextureRenderer;
import com.facebook.spherical.model.SphericalRendererBounds;
import com.facebook.spherical.photo.PartialPanoUtil.PanoBounds;
import com.google.common.base.Preconditions;

@TargetApi(16)
/* compiled from: error_no_sticker_context */
public class GlPhotoRenderThread extends GlMediaRenderThread implements RendererActionListener {
    public HasSphericalPhoto f16215q;
    private PanoBounds f16216r;
    public boolean f16217s;
    public boolean f16218t;

    public GlPhotoRenderThread(Context context, SurfaceTexture surfaceTexture, Runnable runnable, Runnable runnable2, int i, int i2, TextureRenderer textureRenderer, Lazy<FbErrorReporter> lazy, Clock clock, boolean z, SphericalRendererBounds sphericalRendererBounds, boolean z2) {
        super(context, surfaceTexture, runnable, runnable2, i, i2, textureRenderer, lazy, clock, z, sphericalRendererBounds, z2);
        this.f16217s = false;
        this.f16218t = false;
        this.k = 0.0f;
        this.m = 0.5f;
    }

    protected final void mo1248b(int[] iArr) {
        if (!this.f16130n) {
            super.mo1248b(iArr);
        }
    }

    protected final boolean mo1247a(Message message) {
        if (message.what != 3) {
            return false;
        }
        CloseableReference closeableReference = (CloseableReference) message.obj;
        Preconditions.checkState(CloseableReference.a(closeableReference));
        try {
            CloseableImage closeableImage = (CloseableImage) closeableReference.a();
            Preconditions.checkArgument(closeableImage instanceof CloseableStaticBitmap);
            m23762l().m23782a(((CloseableStaticBitmap) closeableImage).a());
            if (message.arg1 == 0) {
                m23761f(true);
            }
            CloseableReference.c(closeableReference);
            return true;
        } catch (Throwable th) {
            CloseableReference.c(closeableReference);
        }
    }

    protected final boolean mo1249b() {
        return true;
    }

    private PhotoTextureRenderer m23762l() {
        return (PhotoTextureRenderer) this.f16117a;
    }

    public final void m23765a(CloseableReference<CloseableImage> closeableReference, int i) {
        if (this.f16123g != null) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.obj = closeableReference.b();
            obtain.arg1 = i;
            this.f16123g.sendMessage(obtain);
        }
    }

    public final void m23766a(PanoBounds panoBounds) {
        this.f16216r = panoBounds;
        m23759a(this.f16216r, this.f16120d.f16096b, this.f16120d.f16097c);
    }

    public final void mo1250e(boolean z) {
        this.f16217s = z;
        m23763p();
    }

    private void m23763p() {
        if (this.f16218t && this.f16217s) {
            this.f16215q.m23771c();
        }
    }

    private void m23761f(boolean z) {
        this.f16218t = z;
        m23763p();
    }

    private void m23759a(PanoBounds panoBounds, int i, int i2) {
        if (panoBounds != null) {
            float f = ((float) i) / ((float) i2);
            if (f > 1.0f) {
                ((FeedRenderThreadController) this.f16121e).m23689e(panoBounds.f16220b - (this.f16132p / 2.0f), (-panoBounds.f16219a) + (this.f16132p / 2.0f));
                return;
            }
            float f2 = this.f16132p * f;
            ((FeedRenderThreadController) this.f16121e).m23689e(panoBounds.f16220b - (f2 / 2.0f), (f2 / 2.0f) + (-panoBounds.f16219a));
        }
    }

    protected final void mo1246a(int i, int i2, boolean z) {
        float f;
        this.f16120d.f16095a.lock();
        if (i > 0) {
            this.f16120d.f16096b = i;
        }
        if (i2 > 0) {
            this.f16120d.f16097c = i2;
        }
        float f2 = this.f16132p;
        if (!z) {
            m23759a(this.f16216r, i, i2);
            float f3 = ((float) i) / ((float) i2);
            if (m23760d(f3)) {
                f2 /= f3;
            }
        }
        float f4 = ((float) this.f16120d.f16096b) / ((float) this.f16120d.f16097c);
        if (z && m23760d(f4)) {
            f = f2 / f4;
        } else {
            f = f2;
        }
        Matrix.perspectiveM(this.f16120d.f16098d, 0, f, f4, 0.1f, 100.0f);
        this.f16120d.f16095a.unlock();
    }

    private static boolean m23760d(float f) {
        return f > 1.0f;
    }
}
