package com.facebook.video.engine.texview;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.spherical.SphericalMediaTextureView;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@TargetApi(14)
/* compiled from: pending_app_calls */
public class VideoSurfaceTarget {
    private static final String f14110a = VideoSurfaceTarget.class.getName();
    private final TextureViewListener f14111b = new TextureViewListener(this);
    private final RmTextureViewProvider f14112c;
    public final SurfaceTexturePool f14113d;
    private final Lazy<FbErrorReporter> f14114e;
    private ViewGroup f14115f;
    private SurfaceTexture f14116g;
    public Surface f14117h;
    public TextureView f14118i;
    public SurfaceListener f14119j;
    private SurfaceTextureManagement f14120k = SurfaceTextureManagement.NOT_INITIALIZED;
    public boolean f14121l;

    /* compiled from: pending_app_calls */
    public interface SurfaceListener {
        void mo516a();

        void mo517a(Surface surface);

        void mo518a(C02403 c02403);

        void mo519b();
    }

    /* compiled from: pending_app_calls */
    class TextureViewListener implements SurfaceTextureListener {
        final /* synthetic */ VideoSurfaceTarget f14122a;

        public TextureViewListener(VideoSurfaceTarget videoSurfaceTarget) {
            this.f14122a = videoSurfaceTarget;
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            Preconditions.checkNotNull(surfaceTexture);
            VideoSurfaceTarget.m14916a(this.f14122a, surfaceTexture);
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            if (this.f14122a.f14119j != null) {
                this.f14122a.f14119j.mo516a();
            }
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (surfaceTexture == null) {
                VideoSurfaceTarget.m14917a(this.f14122a, "onSurfaceTextureDestroyed", "onSurfaceTextureDestroyed with null SurfaceTexture", null);
                return true;
            }
            VideoSurfaceTarget.m14920b(this.f14122a, surfaceTexture);
            return false;
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            this.f14122a.f14121l = true;
            if (this.f14122a.f14119j != null) {
                this.f14122a.f14119j.mo519b();
            }
        }
    }

    /* compiled from: pending_app_calls */
    public enum SurfaceTextureManagement {
        NOT_INITIALIZED,
        NEEDS_TO_RELEASE_SURFACETEXTURE,
        NEEDS_TO_RECYCLE_SURFACETEXTURE_FOR_REGULAR_VIDEO,
        USES_MANAGED_SURFACETEXTURE
    }

    private static VideoSurfaceTarget m14918b(InjectorLike injectorLike) {
        return new VideoSurfaceTarget(RmTextureViewProvider.b(injectorLike), SurfaceTexturePool.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    @Inject
    public VideoSurfaceTarget(RmTextureViewProvider rmTextureViewProvider, SurfaceTexturePool surfaceTexturePool, Lazy<FbErrorReporter> lazy) {
        this.f14112c = rmTextureViewProvider;
        this.f14113d = surfaceTexturePool;
        this.f14114e = lazy;
    }

    @TargetApi(17)
    public final void m14924a(ViewGroup viewGroup) {
        SurfaceTexture surfaceTexture;
        boolean z;
        boolean z2;
        boolean z3 = true;
        Preconditions.checkNotNull(viewGroup, "Must pass a parent as an argument");
        if (this.f14116g != null) {
            m14917a(this, "attachToView", "onSurfaceTextureDestroyed wasn't called", null);
            if (this.f14120k == SurfaceTextureManagement.NEEDS_TO_RECYCLE_SURFACETEXTURE_FOR_REGULAR_VIDEO) {
                this.f14120k = SurfaceTextureManagement.NEEDS_TO_RELEASE_SURFACETEXTURE;
            }
            m14920b(this, this.f14116g);
            if (this.f14118i != null) {
                this.f14118i.setSurfaceTextureListener(null);
                this.f14118i = null;
            }
        }
        this.f14115f = viewGroup;
        if (this.f14118i == null) {
            this.f14118i = this.f14112c.a();
            this.f14118i.setSurfaceTextureListener(this.f14111b);
        }
        if (this.f14118i.isAvailable()) {
            surfaceTexture = null;
            z = false;
        } else if (this.f14118i instanceof SphericalMediaTextureView) {
            this.f14120k = SurfaceTextureManagement.USES_MANAGED_SURFACETEXTURE;
            SurfaceTexture a = this.f14113d.a();
            if (a != null) {
                try {
                    ((SphericalMediaTextureView) this.f14118i).m5841a(a, new 1(this, a), new 2(this, a));
                    surfaceTexture = a;
                    z = false;
                } catch (Throwable e) {
                    m14917a(this, "attachToView", "setSurfaceTexture failed for 360 Video", e);
                    a.release();
                    surfaceTexture = null;
                    z = false;
                }
            } else {
                surfaceTexture = a;
                z = false;
            }
        } else {
            if (VERSION.SDK_INT >= 17) {
                surfaceTexture = this.f14113d.b();
            } else {
                surfaceTexture = null;
            }
            if (surfaceTexture != null) {
                try {
                    this.f14118i.setSurfaceTexture(surfaceTexture);
                    this.f14120k = SurfaceTextureManagement.NEEDS_TO_RECYCLE_SURFACETEXTURE_FOR_REGULAR_VIDEO;
                    z = true;
                } catch (Throwable e2) {
                    m14917a(this, "attachToView", "setSurfaceTexture failed for Regular Video", e2);
                    surfaceTexture.release();
                    surfaceTexture = null;
                }
            }
            this.f14120k = SurfaceTextureManagement.NEEDS_TO_RELEASE_SURFACETEXTURE;
            z = false;
        }
        if (this.f14120k != SurfaceTextureManagement.NOT_INITIALIZED) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        if (this.f14118i.getParent() != null) {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Must detach before re-attaching");
        this.f14115f.addView(this.f14118i);
        this.f14121l = false;
        if (this.f14118i.getParent() == null) {
            m14917a(this, "attachToView", "addView TextureView failed", null);
        }
        if (z && surfaceTexture != null) {
            m14916a(this, surfaceTexture);
        }
    }

    public final void m14922a() {
        Preconditions.checkNotNull(this.f14115f);
        Preconditions.checkNotNull(this.f14118i);
        if (this.f14118i.getParent() == null) {
            m14917a(this, "detachFromView", "TextureView must be attached", null);
        }
        if (!this.f14121l) {
            try {
                this.f14118i.getBitmap(1, 1);
            } catch (Throwable e) {
                m14917a(this, "detachFromView", "Failed to call TextureView.getBitmap", e);
            }
        }
        try {
            this.f14115f.removeView(this.f14118i);
            if (this.f14118i.getParent() != null) {
                m14917a(this, "detachFromView", "mTextureView.getParent is not null after removeView", null);
            }
        } catch (Throwable e2) {
            m14917a(this, "detachFromView", "removeView TextureView failed", e2);
            this.f14118i.setSurfaceTextureListener(null);
            this.f14118i = null;
        }
        this.f14121l = false;
        this.f14115f = null;
    }

    public final boolean m14925b() {
        return (this.f14118i == null || this.f14118i.getParent() == null) ? false : true;
    }

    public final boolean m14926d() {
        return this.f14117h != null;
    }

    public final SphericalMediaTextureView m14927g() {
        boolean z = this.f14118i != null && (this.f14118i instanceof SphericalMediaTextureView);
        Preconditions.checkArgument(z);
        return (SphericalMediaTextureView) this.f14118i;
    }

    public final int m14928h() {
        return this.f14118i != null ? this.f14118i.getWidth() : 0;
    }

    public final int m14929i() {
        return this.f14118i != null ? this.f14118i.getHeight() : 0;
    }

    public final int m14930j() {
        return this.f14118i != null ? this.f14118i.getMeasuredWidth() : 0;
    }

    public final int m14931k() {
        return this.f14118i != null ? this.f14118i.getMeasuredHeight() : 0;
    }

    public final void m14923a(Matrix matrix) {
        if (this.f14118i != null) {
            this.f14118i.setTransform(matrix);
        }
    }

    public final Bitmap m14921a(double d, double d2) {
        Bitmap bitmap = null;
        if (this.f14118i != null) {
            try {
                bitmap = this.f14118i.getBitmap((int) (((double) this.f14118i.getWidth()) * d), (int) (((double) this.f14118i.getHeight()) * d2));
            } catch (Throwable e) {
                m14917a(this, "getCurrentFrameAsBitmapSLOW", "Error encountered in getting current frame bitmap from textureView", e);
            }
        }
        return bitmap;
    }

    public static void m14916a(VideoSurfaceTarget videoSurfaceTarget, SurfaceTexture surfaceTexture) {
        videoSurfaceTarget.f14116g = surfaceTexture;
        try {
            if (videoSurfaceTarget.f14117h != null) {
                m14917a(videoSurfaceTarget, "acquireSurfaceTexture", "acquireSurfaceTexture was called before releaseSurfaceTexture", null);
                videoSurfaceTarget.f14117h.release();
                videoSurfaceTarget.f14117h = null;
            }
            videoSurfaceTarget.f14117h = new Surface(surfaceTexture);
            if (!videoSurfaceTarget.f14117h.isValid()) {
                m14917a(videoSurfaceTarget, "acquireSurfaceTexture", "Surface is not valid", null);
            } else if (videoSurfaceTarget.f14119j != null) {
                videoSurfaceTarget.f14119j.mo517a(videoSurfaceTarget.f14117h);
            }
        } catch (Throwable e) {
            m14917a(videoSurfaceTarget, "acquireSurfaceTexture", "Error encountered in creating Surface", e);
        }
    }

    public static void m14920b(VideoSurfaceTarget videoSurfaceTarget, SurfaceTexture surfaceTexture) {
        if (videoSurfaceTarget.f14116g == null) {
            m14917a(videoSurfaceTarget, "releaseSurfaceTexture", "releaseSurfaceTexture was called before acquireSurfaceTexture, or error occured", null);
            surfaceTexture.release();
        } else if (videoSurfaceTarget.f14116g != surfaceTexture) {
            m14917a(videoSurfaceTarget, "releaseSurfaceTexture", "Destroying a different SurfaceTexture?", null);
            surfaceTexture.release();
        } else {
            final SurfaceTexturePool surfaceTexturePool = videoSurfaceTarget.f14113d;
            final Surface surface = videoSurfaceTarget.f14117h;
            final SurfaceTextureManagement surfaceTextureManagement = videoSurfaceTarget.f14120k;
            if (videoSurfaceTarget.f14119j != null) {
                final SurfaceTexture surfaceTexture2 = surfaceTexture;
                videoSurfaceTarget.f14119j.mo518a(new Object(videoSurfaceTarget) {
                    final /* synthetic */ VideoSurfaceTarget f5662e;

                    public final void m6168a() {
                        VideoSurfaceTarget.m14919b(surfaceTexturePool, surface, surfaceTexture2, surfaceTextureManagement);
                    }
                });
            } else {
                m14919b(surfaceTexturePool, surface, surfaceTexture, surfaceTextureManagement);
            }
            videoSurfaceTarget.f14116g = null;
            videoSurfaceTarget.f14117h = null;
        }
    }

    public static void m14919b(SurfaceTexturePool surfaceTexturePool, Surface surface, SurfaceTexture surfaceTexture, SurfaceTextureManagement surfaceTextureManagement) {
        if (surface != null) {
            surface.release();
        }
        switch (surfaceTextureManagement) {
            case NEEDS_TO_RECYCLE_SURFACETEXTURE_FOR_REGULAR_VIDEO:
                surfaceTexturePool.b(surfaceTexture);
                return;
            case NEEDS_TO_RELEASE_SURFACETEXTURE:
                surfaceTexture.release();
                return;
            default:
                return;
        }
    }

    public static void m14917a(VideoSurfaceTarget videoSurfaceTarget, String str, String str2, Throwable th) {
        SoftErrorBuilder a = SoftError.m4758a(f14110a + "." + str, str2);
        a.f4226c = th;
        ((AbstractFbErrorReporter) videoSurfaceTarget.f14114e.get()).a(a.m4765g());
    }
}
