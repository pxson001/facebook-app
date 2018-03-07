package com.facebook.maps;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.android.maps.MapReporterLauncher;
import com.facebook.android.maps.StaticMapView;
import com.facebook.android.maps.internal.MapConfig;
import com.facebook.android.maps.internal.analytics.AnalyticsEvent;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.locale.Locales;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.iorg.common.upsell.ui.FbZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.maps.report.FbMapReporterLauncher;
import com.facebook.resources.ui.FbTextView;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import java.util.HashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: profile_pic_small_size */
public class FbStaticMapView extends StaticMapView {
    private String f13363d;
    private FbTextView f13364e;
    public ZeroFeatureKey f13365f;
    public ZeroDialogController f13366g;
    public ZeroRatingCallback f13367h;
    public DialtoneController f13368i;
    private FbDraweeView f13369j;
    public FragmentManager f13370k;
    private FbMapReporterLauncher f13371l;
    private FbDraweeControllerBuilder f13372m;
    public long f13373n = 0;

    private static <T extends View> void m14270a(Class<T> cls, T t) {
        m14271a((Object) t, t.getContext());
    }

    private static void m14271a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FbStaticMapView) obj).m14269a(Locales.a(injectorLike), MapAnalyticsLogger.m14303a(injectorLike), FbMapReporterLauncher.m14306a(injectorLike), MapsRuntimePermissionManager.m14367a(injectorLike), (ZeroDialogController) FbZeroDialogController.b(injectorLike), ViewerContextMethodAutoProvider.b(injectorLike), FbDraweeControllerBuilder.b(injectorLike), (DialtoneController) DialtoneControllerImpl.a(injectorLike));
    }

    public FbStaticMapView(Context context) {
        super(context);
        m14273b();
    }

    public FbStaticMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14273b();
    }

    public FbStaticMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14273b();
    }

    private void m14273b() {
        m14270a(FbStaticMapView.class, (View) this);
    }

    @Inject
    private void m14269a(Locales locales, MapAnalyticsLogger mapAnalyticsLogger, FbMapReporterLauncher fbMapReporterLauncher, MapsRuntimePermissionManager mapsRuntimePermissionManager, ZeroDialogController zeroDialogController, ViewerContext viewerContext, FbDraweeControllerBuilder fbDraweeControllerBuilder, DialtoneController dialtoneController) {
        this.f13363d = locales.c();
        this.f13366g = zeroDialogController;
        this.f13371l = fbMapReporterLauncher;
        MapConfig.m14372a(getContext(), viewerContext.mAuthToken, mapsRuntimePermissionManager);
        AnalyticsEvent.m14383a(mapAnalyticsLogger);
        this.f13385k = 2;
        setReportButtonVisibility(0);
        setMapReporterLauncher(this.f13371l);
        this.f13372m = fbDraweeControllerBuilder;
        this.f13368i = dialtoneController;
        setContentDescription(getResources().getString(2131230959));
    }

    public final void m14281a(ZeroFeatureKey zeroFeatureKey, FragmentManager fragmentManager, @Nullable ZeroRatingCallback zeroRatingCallback) {
        this.f13365f = zeroFeatureKey;
        this.f13370k = fragmentManager;
        this.f13367h = zeroRatingCallback;
        setZeroRatingEnabled(this.f13366g.a(zeroFeatureKey));
        FbMapReporterLauncher fbMapReporterLauncher = this.f13371l;
        fbMapReporterLauncher.f13410c = true;
        fbMapReporterLauncher.f13411d = fragmentManager;
    }

    public void setZeroRatingEnabled(boolean z) {
        if (!z || this.f13365f == null) {
            setEnabled(true);
            if (this.f13364e != null) {
                this.f13364e.setVisibility(8);
                return;
            }
            return;
        }
        setEnabled(false);
        if (this.f13364e == null) {
            this.f13364e = m14276d();
            this.f13364e.setOnClickListener(new 1(this));
            addView(this.f13364e, -1, -1);
        }
        this.f13364e.setVisibility(0);
    }

    public void setMapReporterLauncher(MapReporterLauncher mapReporterLauncher) {
        if (mapReporterLauncher == null) {
            mapReporterLauncher = this.f13371l;
        }
        super.setMapReporterLauncher(mapReporterLauncher);
    }

    protected final View mo952a() {
        this.f13369j = new FbDraweeView(getContext());
        return this.f13369j;
    }

    protected final void mo953a(View view, Uri uri, final String str) {
        ControllerListener c01952;
        ImageRequestBuilder a = ImageRequestBuilder.a(uri);
        a.g = true;
        ImageRequest m = a.m();
        if (AnalyticsEvent.f13510C.m14395c()) {
            this.f13373n = AnalyticsEvent.m14382a();
            c01952 = new ControllerListener<ImageInfo>(this) {
                final /* synthetic */ FbStaticMapView f4110b;

                /* compiled from: profile_pic_small_size */
                class C01961 extends HashMap<String, Object> {
                    C01961() {
                        put("duration", Long.valueOf(AnalyticsEvent.m14382a() - C01952.this.f4110b.f13373n));
                        put("surface", str == null ? "unknown" : str);
                    }
                }

                public final void m4652a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
                    if (this.f4110b.f13373n > 0) {
                        AnalyticsEvent.f13510C.m14394a(new C01961());
                        this.f4110b.f13373n = 0;
                    }
                }

                public final void m4651a(String str, Object obj) {
                }

                public final void m4653a(String str, Throwable th) {
                }

                public final void m4655b(String str, Throwable th) {
                }

                public final void m4650a(String str) {
                }
            };
        } else {
            c01952 = null;
        }
        ((FbDraweeView) view).setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f13372m.c(m)).a(CallerContext.a(FbStaticMapView.class, "map_view", str)).b(((FbDraweeView) view).getController())).a(c01952)).s());
    }

    protected CharSequence getReportButtonText() {
        return getContext().getResources().getText(2131230962);
    }

    protected String getLanguageCode() {
        return this.f13363d;
    }

    private FbTextView m14276d() {
        FbTextView fbTextView = new FbTextView(getContext());
        Resources resources = getResources();
        fbTextView.setText(resources.getText(2131230960));
        fbTextView.setTextColor(-9801344);
        fbTextView.setTextSize(0, resources.getDimension(2131427408));
        fbTextView.setTypeface(fbTextView.getTypeface(), 1);
        fbTextView.setBackgroundResource(2130843367);
        fbTextView.setGravity(17);
        return fbTextView;
    }
}
