package com.facebook.spherical.photo;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.spherical.GlMediaRenderThread;
import com.facebook.spherical.SphericalMediaTextureView;
import com.facebook.spherical.SphericalMediaTextureView$GlThreadController;
import com.facebook.spherical.model.SphericalPhotoParams;
import com.facebook.spherical.photo.PartialPanoUtil.PanoBounds;
import com.facebook.widget.recyclerview.keepattached.RecyclerViewKeepAttached;
import javax.inject.Inject;

/* compiled from: errType= */
public class SphericalPhotoTextureView extends SphericalMediaTextureView implements RecyclerViewKeepAttached {
    @Inject
    Lazy<FbErrorReporter> f16276e;
    @Inject
    Clock f16277f;
    public PhotoTextureRenderer f16278g;
    public GlPhotoRenderThread f16279h;
    public SphericalPhotoParams f16280i;
    public PanoBounds f16281j;
    public HasSphericalPhoto f16282k;

    /* compiled from: errType= */
    public class GlPhotoThreadController extends SphericalMediaTextureView$GlThreadController implements SurfaceTextureListener {
        protected final String f16274l = GlPhotoThreadController.class.getSimpleName();
        final /* synthetic */ SphericalPhotoTextureView f16275m;

        public GlPhotoThreadController(SphericalPhotoTextureView sphericalPhotoTextureView, SurfaceTextureListener surfaceTextureListener) {
            this.f16275m = sphericalPhotoTextureView;
            super(sphericalPhotoTextureView, surfaceTextureListener);
        }

        protected final GlMediaRenderThread mo1257b() {
            this.f16275m.f16279h = new GlPhotoRenderThread(this.f16275m.getContext(), this.f16150d, this.f16151e, this.f16152f, this.f16155i, this.f16156j, this.f16275m.f16278g, this.f16275m.f16276e, this.f16275m.f16277f, this.f16275m.b, this.f16275m.c, this.f16275m.d);
            return this.f16275m.f16279h;
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            super.onSurfaceTextureAvailable(surfaceTexture, i, i2);
            this.f16148b.onSurfaceTextureAvailable(surfaceTexture, i, i2);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            Integer.valueOf(hashCode());
            Integer.valueOf(surfaceTexture.hashCode());
            this.f16148b.onSurfaceTextureDestroyed(surfaceTexture);
            return super.onSurfaceTextureDestroyed(surfaceTexture);
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            if (this.f16275m.f16279h != null) {
                this.f16275m.f16279h.m23766a(this.f16275m.f16281j);
            }
            super.onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        }
    }

    private static <T extends View> void m23806a(Class<T> cls, T t) {
        m23807a((Object) t, t.getContext());
    }

    private static void m23807a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((SphericalPhotoTextureView) obj).m23805a(IdBasedSingletonScopeProvider.b(fbInjector, 494), (Clock) SystemClockMethodAutoProvider.a(fbInjector));
    }

    private void m23805a(Lazy<FbErrorReporter> lazy, Clock clock) {
        this.f16276e = lazy;
        this.f16277f = clock;
    }

    public SphericalPhotoTextureView(Context context) {
        this(context, null, 0);
    }

    public SphericalPhotoTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SphericalPhotoTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m23806a(SphericalPhotoTextureView.class, (View) this);
        this.f16278g = new PhotoTextureRenderer(getResources());
        this.d = true;
    }

    protected final SphericalMediaTextureView$GlThreadController m23813a(SurfaceTextureListener surfaceTextureListener) {
        return new GlPhotoThreadController(this, surfaceTextureListener);
    }

    public final boolean gK_() {
        return true;
    }

    public final void m23815a(CloseableReference<CloseableImage> closeableReference, HasSphericalPhoto hasSphericalPhoto) {
        if (this.f16280i != null) {
            a(this.f16280i.mo1244c(), this.f16280i.mo1243b());
        }
        this.f16282k = hasSphericalPhoto;
        a();
        if (this.f16279h != null) {
            if (this.f16280i != null) {
                this.f16279h.m23702a((float) this.f16280i.f16181h);
                this.f16279h.m23766a(this.f16281j);
            }
            this.f16279h.m23765a(closeableReference, 0);
        }
    }

    public final void m23814a(CloseableReference<CloseableImage> closeableReference) {
        a();
        if (this.f16279h != null) {
            this.f16279h.m23765a(closeableReference, 1);
        }
    }

    public void setSphericalPhotoParams(SphericalPhotoParams sphericalPhotoParams) {
        this.f16280i = sphericalPhotoParams;
    }

    public void setPanoBounds(PanoBounds panoBounds) {
        this.f16281j = panoBounds;
    }

    public void setHasSphericalPhoto(HasSphericalPhoto hasSphericalPhoto) {
        this.f16282k = hasSphericalPhoto;
    }

    public HasSphericalPhoto getHasSphericalPhoto() {
        return this.f16282k;
    }
}
