package com.facebook.drawee.fbpipeline;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.C0093x5209d3a;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.callercontext.FbDraweeCallerContext;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.controller.STATICDI_MULTIBIND_PROVIDER$ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import com.facebook.imagepipeline.abtest.ExperimentsForImagePipelineAbTestModule;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.module.AnimatedDrawableFactoryMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.MultiBinderSet;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.viewdiagnostics.ViewDiagnosticsPreferenceKeys;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: multimedia_upload_in_progress_waterfallid */
public class FbDraweeControllerBuilder extends AbstractDraweeControllerBuilder<FbDraweeControllerBuilder, ImageRequest, CloseableReference<CloseableImage>, ImageInfo> {
    private static boolean f13200i;
    private static boolean f13201j;
    private final Lazy<ImagePipeline> f13202a;
    private final FbPipelineDraweeControllerProvider f13203b;
    private final FbSharedPreferences f13204c;
    private final Provider<Boolean> f13205d;
    private final DegradableDraweeControllerProvider f13206e;
    private final FbLazyDataSourceSupplierProvider f13207f;
    public boolean f13208g;
    public Drawable f13209h;

    public static FbDraweeControllerBuilder m19410b(InjectorLike injectorLike) {
        return new FbDraweeControllerBuilder((Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2309), (FbPipelineDraweeControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FbPipelineDraweeControllerProvider.class), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$ControllerListener(injectorLike)), FbSharedPreferencesImpl.m1826a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3959), (DegradableDraweeControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DegradableDraweeControllerProvider.class), (FbLazyDataSourceSupplierProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FbLazyDataSourceSupplierProvider.class), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    protected final Supplier mo2587a(Object obj, boolean z) {
        return ((ImagePipeline) this.f13202a.get()).m16065a((ImageRequest) obj, m19433q(), z);
    }

    public final /* synthetic */ DraweeController mo2589a() {
        return m19435s();
    }

    public final /* synthetic */ SimpleDraweeControllerBuilder mo2590a(Uri uri) {
        return m19424b(uri);
    }

    public final /* synthetic */ SimpleDraweeControllerBuilder mo2591a(Object obj) {
        return m19411f(obj);
    }

    public final /* synthetic */ AbstractDraweeControllerBuilder mo2592b() {
        return mo2601p();
    }

    public final /* synthetic */ AbstractDraweeControllerBuilder mo2593b(Object obj) {
        return m19411f(obj);
    }

    public final /* synthetic */ Object mo2594c() {
        return m19433q();
    }

    public final /* synthetic */ AbstractDraweeController mo2595i() {
        return m19435s();
    }

    public static FbDraweeControllerBuilder m19409a(InjectorLike injectorLike) {
        return m19410b(injectorLike);
    }

    @Inject
    public FbDraweeControllerBuilder(Context context, Lazy<ImagePipeline> lazy, FbPipelineDraweeControllerProvider fbPipelineDraweeControllerProvider, Set<ControllerListener> set, FbSharedPreferences fbSharedPreferences, Provider<Boolean> provider, DegradableDraweeControllerProvider degradableDraweeControllerProvider, FbLazyDataSourceSupplierProvider fbLazyDataSourceSupplierProvider, @Nullable QeAccessor qeAccessor) {
        super(context, set);
        this.f13202a = lazy;
        this.f13203b = fbPipelineDraweeControllerProvider;
        this.f13204c = fbSharedPreferences;
        this.f13205d = provider;
        this.f13206e = degradableDraweeControllerProvider;
        this.f13207f = fbLazyDataSourceSupplierProvider;
        if (!(f13200i || qeAccessor == null)) {
            f13201j = qeAccessor.mo596a(ExperimentsForImagePipelineAbTestModule.f10689b, false);
            f13200i = true;
        }
        m19412t();
    }

    private void m19412t() {
        this.f13208g = false;
        this.f13209h = null;
    }

    public final FbDraweeControllerBuilder mo2601p() {
        m19412t();
        return (FbDraweeControllerBuilder) super.mo2592b();
    }

    public final FbDraweeControllerBuilder m19424b(Uri uri) {
        if (f13201j && uri != null) {
            FacebookUriUtil.m20924i(uri);
        }
        return (FbDraweeControllerBuilder) super.m19452c(ImageRequest.m18795a(uri));
    }

    public final FbDraweeControllerBuilder m19418a(@Nullable String str) {
        if (str == null || !f13201j) {
            return (FbDraweeControllerBuilder) super.m19452c(ImageRequest.m18796a(str));
        }
        Uri parse = Uri.parse(str);
        FacebookUriUtil.m20924i(parse);
        return m19424b(parse);
    }

    private FbDraweeControllerBuilder m19411f(Object obj) {
        Preconditions.a(obj instanceof CallerContext, "callerContext must be instance of CallerContext");
        return (FbDraweeControllerBuilder) super.mo2593b(obj);
    }

    public final FbDraweeControllerBuilder m19417a(CallerContext callerContext) {
        return (FbDraweeControllerBuilder) super.mo2593b((Object) callerContext);
    }

    public final CallerContext m19433q() {
        return (CallerContext) super.mo2594c();
    }

    private DegradableDraweeController m19414w() {
        AbstractDraweeController abstractDraweeController;
        Supplier e = m19457e(ImageRequestBuilder.m18776a(Uri.parse("res:///" + 2130838405)).m18785m());
        Uri uri = Uri.EMPTY;
        if (this.f13216f != null) {
            uri = ((ImageRequest) this.f13216f).f12746c;
        } else if (this.f13217g != null) {
            uri = ((ImageRequest) this.f13217g).f12746c;
        } else if (this.f13218h != null) {
            uri = ((ImageRequest[]) this.f13218h)[0].f12746c;
        }
        if (this.f13225o instanceof DegradableDraweeController) {
            abstractDraweeController = (DegradableDraweeController) this.f13225o;
            abstractDraweeController.a(mo2598m(), e, uri, AbstractDraweeControllerBuilder.m19436l(), m19408A());
        } else {
            abstractDraweeController = this.f13206e.m19481a(mo2598m(), e, uri, AbstractDraweeControllerBuilder.m19436l(), m19408A());
        }
        m19455c(abstractDraweeController);
        m19451b(abstractDraweeController);
        m19447a(abstractDraweeController);
        return abstractDraweeController;
    }

    protected final void mo2596j() {
        Preconditions.a(m19433q(), "CallerContext not specified!");
        super.mo2596j();
    }

    public final FbPipelineDraweeController m19435s() {
        return (FbPipelineDraweeController) super.mo2595i();
    }

    protected final AbstractDraweeController mo2597k() {
        if (((Boolean) this.f13205d.get()).booleanValue()) {
            return m19414w();
        }
        return m19413v();
    }

    private FbPipelineDraweeController m19413v() {
        AbstractDraweeController abstractDraweeController = (FbPipelineDraweeController) super.mo2597k();
        if (this.f13204c.mo286a(ViewDiagnosticsPreferenceKeys.f13486b, false)) {
            abstractDraweeController.mo2762a(new DebugControllerOverlay());
        }
        if (this.f13208g) {
            m19455c(abstractDraweeController);
            abstractDraweeController.f14352e = this.f13209h;
        }
        return abstractDraweeController;
    }

    protected final AbstractDraweeController mo2599n() {
        DraweeController draweeController = this.f13225o;
        if (draweeController instanceof FbPipelineDraweeController) {
            FbPipelineDraweeController fbPipelineDraweeController = (FbPipelineDraweeController) draweeController;
            fbPipelineDraweeController.m20722a(mo2598m(), AbstractDraweeControllerBuilder.m19436l(), m19408A());
            return fbPipelineDraweeController;
        }
        InjectorLike injectorLike = this.f13203b;
        Supplier m = mo2598m();
        String l = AbstractDraweeControllerBuilder.m19436l();
        return new FbPipelineDraweeController(ResourcesMethodAutoProvider.m6510a(injectorLike), DeferredReleaserMethodAutoProvider.m20759a(injectorLike), AnimatedDrawableFactoryMethodAutoProvider.m20763a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), C0093x5209d3a.m2600a(injectorLike), m, l, m19408A(), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    protected final Supplier<DataSource<CloseableReference<CloseableImage>>> mo2598m() {
        if (!this.f13208g) {
            return super.mo2598m();
        }
        Object obj = this.f13207f;
        return new FbLazyDataSourceSupplier(IdBasedSingletonScopeProvider.m1810b(obj, 2309), (ImageRequest) this.f13216f, (ImageRequest) this.f13217g, m19433q());
    }

    protected final DataSource mo2588a(Object obj, Object obj2, boolean z) {
        throw new UnsupportedOperationException();
    }

    protected final /* synthetic */ AbstractDraweeControllerBuilder mo2600o() {
        return this;
    }

    @Deprecated
    public final FbDraweeControllerBuilder m19434r() {
        return this;
    }

    private FbDraweeCallerContext m19408A() {
        FbDraweeCallerContext fbDraweeCallerContext;
        CallerContext q = m19433q();
        boolean z = this.f13208g;
        if (q == null) {
            fbDraweeCallerContext = null;
        } else {
            fbDraweeCallerContext = new FbDraweeCallerContext(q, z);
        }
        return fbDraweeCallerContext;
    }
}
