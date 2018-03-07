package com.facebook.drawee.fbpipeline;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.callercontext.FbDraweeCallerContext;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.imagepipeline.abtest.ExperimentsForImagePipelineAbTestModule;
import com.facebook.imagepipeline.animated.factory.AnimatedDrawableFactory;
import com.facebook.imagepipeline.image.CloseableAnimatedBitmap;
import com.facebook.imagepipeline.image.CloseableGIFImageOld;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.ui.images.webp.BitmapAnimationDrawable;
import gifdrawable.pl.droidsonroids.gif.GifDrawable;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: message_capping */
public class FbPipelineDraweeController extends PipelineDraweeController {
    private static boolean f14348a;
    private final AnalyticsLogger f14349b;
    private final TapToLoadLogger f14350c = new TapToLoadLogger(this.f14349b);
    private Supplier<DataSource<CloseableReference<CloseableImage>>> f14351d;
    public Drawable f14352e;

    public final /* synthetic */ Object mo2764i() {
        return m20718q();
    }

    @Inject
    public FbPipelineDraweeController(Resources resources, DeferredReleaser deferredReleaser, AnimatedDrawableFactory animatedDrawableFactory, AnalyticsLogger analyticsLogger, Executor executor, @Assisted Supplier<DataSource<CloseableReference<CloseableImage>>> supplier, @Assisted String str, @Assisted FbDraweeCallerContext fbDraweeCallerContext, @Nullable QeAccessor qeAccessor) {
        super(resources, deferredReleaser, animatedDrawableFactory, executor, supplier, str, fbDraweeCallerContext);
        this.f14349b = analyticsLogger;
        this.f14351d = supplier;
        if (qeAccessor != null && !f14348a) {
            PipelineDraweeController.m20719a(qeAccessor.mo596a(ExperimentsForImagePipelineAbTestModule.f10705r, false), qeAccessor.mo596a(ExperimentsForImagePipelineAbTestModule.f10706s, false));
            f14348a = true;
        }
    }

    protected final void mo2762a(Drawable drawable) {
        super.mo2762a(drawable);
        if (drawable instanceof DebugControllerOverlay) {
            DebugControllerOverlay debugControllerOverlay = (DebugControllerOverlay) drawable;
            debugControllerOverlay.b = this.f14369j;
            debugControllerOverlay.invalidateSelf();
        }
    }

    protected final Drawable mo2760a(CloseableReference<CloseableImage> closeableReference) {
        Drawable bitmapAnimationDrawable;
        Preconditions.b(CloseableReference.m15679a((CloseableReference) closeableReference));
        CloseableImage closeableImage = (CloseableImage) closeableReference.m15682a();
        if (closeableImage instanceof CloseableAnimatedBitmap) {
            CloseableAnimatedBitmap closeableAnimatedBitmap = (CloseableAnimatedBitmap) closeableImage;
            bitmapAnimationDrawable = new BitmapAnimationDrawable(this.f14356b, closeableAnimatedBitmap.f17915b, closeableAnimatedBitmap.f17916c);
        } else if (closeableImage instanceof CloseableGIFImageOld) {
            bitmapAnimationDrawable = new GifDrawable(((CloseableGIFImageOld) closeableImage).f17918b);
        } else {
            bitmapAnimationDrawable = super.mo2760a((CloseableReference) closeableReference);
        }
        if (Math.random() <= 2.0E-4d) {
            return new InstrumentedDrawable(bitmapAnimationDrawable, this.f14349b, m20718q());
        }
        return bitmapAnimationDrawable;
    }

    public final FbDraweeCallerContext m20718q() {
        return (FbDraweeCallerContext) super.mo2764i();
    }

    protected DataSource<CloseableReference<CloseableImage>> mo2766n() {
        DataSource<CloseableReference<CloseableImage>> n = super.mo2766n();
        if (m20710r()) {
            n.mo2783a(new DataSourceSubscriber(this), UiThreadImmediateExecutorService.m20771b());
        }
        return n;
    }

    protected boolean mo2765l() {
        return m20708a(this) || super.mo2765l();
    }

    public boolean mo2763c() {
        mo2762a(null);
        if (!m20708a(this)) {
            return super.mo2763c();
        }
        m20709p();
        m20746b();
        m20757m();
        TapToLoadLogger tapToLoadLogger = this.f14350c;
        CallerContext callerContext = m20718q().f14346b;
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("tap_to_load_image");
        honeyClientEvent.m5090b("calling_class", callerContext.f5181b);
        honeyClientEvent.m5090b("analytics_tag", callerContext.m9068c());
        honeyClientEvent.m5090b("module_tag", callerContext.m9069d());
        honeyClientEvent.m5090b("feature_tag", callerContext.m9067b());
        tapToLoadLogger.f14409a.mo526a(honeyClientEvent);
        return true;
    }

    public static boolean m20708a(FbPipelineDraweeController fbPipelineDraweeController) {
        return fbPipelineDraweeController.m20710r() && !((FbLazyDataSourceSupplier) fbPipelineDraweeController.f14351d).f14536f.get();
    }

    private void m20709p() {
        if (m20710r()) {
            ((FbLazyDataSourceSupplier) this.f14351d).m20951c();
        }
    }

    private boolean m20710r() {
        return this.f14351d instanceof FbLazyDataSourceSupplier;
    }
}
