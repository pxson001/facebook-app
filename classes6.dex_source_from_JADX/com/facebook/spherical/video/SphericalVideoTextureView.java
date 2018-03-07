package com.facebook.spherical.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.spherical.GlMediaRenderThread;
import com.facebook.spherical.SphericalMediaTextureView;
import com.facebook.spherical.SphericalMediaTextureView$GlThreadController;
import javax.inject.Inject;

/* compiled from: entity_internal_id */
public class SphericalVideoTextureView extends SphericalMediaTextureView {
    @Inject
    public Lazy<FbErrorReporter> f16402e;
    @Inject
    public Clock f16403f;

    /* compiled from: entity_internal_id */
    public class GlVideoThreadController extends SphericalMediaTextureView$GlThreadController implements SurfaceTextureListener {
        protected final String f16399l = GlVideoThreadController.class.getSimpleName();
        protected SurfaceTexture f16400m;
        public final /* synthetic */ SphericalVideoTextureView f16401n;

        /* compiled from: entity_internal_id */
        public class C11471 {
            public final /* synthetic */ GlVideoThreadController f16398a;

            /* compiled from: entity_internal_id */
            public class C11461 implements Runnable {
                final /* synthetic */ SurfaceTexture f16394a;
                final /* synthetic */ int f16395b;
                final /* synthetic */ int f16396c;
                final /* synthetic */ C11471 f16397d;

                public C11461(C11471 c11471, SurfaceTexture surfaceTexture, int i, int i2) {
                    this.f16397d = c11471;
                    this.f16394a = surfaceTexture;
                    this.f16395b = i;
                    this.f16396c = i2;
                }

                public void run() {
                    this.f16397d.f16398a.f16400m = this.f16394a;
                    this.f16397d.f16398a.f16148b.onSurfaceTextureAvailable(this.f16397d.f16398a.f16400m, this.f16395b, this.f16396c);
                }
            }

            C11471(GlVideoThreadController glVideoThreadController) {
                this.f16398a = glVideoThreadController;
            }
        }

        public GlVideoThreadController(SphericalVideoTextureView sphericalVideoTextureView, SurfaceTextureListener surfaceTextureListener) {
            this.f16401n = sphericalVideoTextureView;
            super(sphericalVideoTextureView, surfaceTextureListener);
        }

        protected final GlMediaRenderThread mo1257b() {
            return new GlVideoRenderThread(this.f16401n.getContext(), this.f16150d, this.f16151e, this.f16152f, this.f16155i, this.f16156j, new VideoTextureRenderer(this.f16401n.getResources()), new C11471(this), this.f16401n.f16402e, this.f16401n.f16403f, this.f16401n.b, this.f16401n.c, this.f16401n.d);
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            super.onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
            this.f16148b.onSurfaceTextureSizeChanged(this.f16400m, i, i2);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            Integer.valueOf(hashCode());
            Integer.valueOf(surfaceTexture.hashCode());
            Integer.valueOf(this.f16400m != null ? this.f16400m.hashCode() : 0);
            if (this.f16400m != null) {
                this.f16148b.onSurfaceTextureDestroyed(this.f16400m);
                this.f16400m = null;
            }
            return super.onSurfaceTextureDestroyed(surfaceTexture);
        }
    }

    public static void m23881a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        SphericalVideoTextureView sphericalVideoTextureView = (SphericalVideoTextureView) obj;
        Lazy b = IdBasedSingletonScopeProvider.b(fbInjector, 494);
        Clock clock = (Clock) SystemClockMethodAutoProvider.a(fbInjector);
        sphericalVideoTextureView.f16402e = b;
        sphericalVideoTextureView.f16403f = clock;
    }

    public SphericalVideoTextureView(Context context) {
        this(context, null, 0);
    }

    private SphericalVideoTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = SphericalVideoTextureView.class;
        m23881a(this, getContext());
    }

    protected final SphericalMediaTextureView$GlThreadController m23882a(SurfaceTextureListener surfaceTextureListener) {
        return new GlVideoThreadController(this, surfaceTextureListener);
    }
}
