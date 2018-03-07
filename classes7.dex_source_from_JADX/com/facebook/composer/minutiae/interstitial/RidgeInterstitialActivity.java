package com.facebook.composer.minutiae.interstitial;

import android.content.Context;
import android.os.Bundle;
import com.facebook.composer.minutiae.analytics.RidgeAnalyticsLogger;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.nux.BaseNuxFlowActivity;
import com.facebook.nux.NuxFlow;
import com.facebook.nux.NuxScreen;
import com.facebook.nux.NuxScreen.Builder;
import com.facebook.nux.interstitial.BaseNuxScreenController;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: toX */
public class RidgeInterstitialActivity extends BaseNuxFlowActivity {
    private RidgeAnalyticsLogger f1561p;
    private Lazy<RidgeNewIntroScreenController> f1562q;
    private String f1563r;

    private static <T extends Context> void m1612a(Class<T> cls, T t) {
        m1613a((Object) t, (Context) t);
    }

    public static void m1613a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RidgeInterstitialActivity) obj).m1611a(RidgeAnalyticsLogger.m1552a(fbInjector), IdBasedLazy.a(fbInjector, 5242));
    }

    public final void m1618j() {
        Class cls = RidgeInterstitialActivity.class;
        m1613a((Object) this, (Context) this);
    }

    @Inject
    private void m1611a(RidgeAnalyticsLogger ridgeAnalyticsLogger, Lazy<RidgeNewIntroScreenController> lazy) {
        this.f1561p = ridgeAnalyticsLogger;
        this.f1562q = lazy;
    }

    protected final void m1616b(Bundle bundle) {
        super.b(bundle);
        this.f1563r = getIntent().getStringExtra("extra_composer_session_id");
        m1615n().mo83a(this.f1563r);
        String str = "ridge_opt_in_nux_activity_created";
        RidgeAnalyticsLogger.m1551a(str, this.f1563r).m1550a(this.f1561p.f1464a);
    }

    protected final NuxFlow m1617i() {
        boolean z;
        String str = "ridge_interstitial";
        String str2 = "composer".toString();
        NuxScreen[] nuxScreenArr = new NuxScreen[1];
        Builder builder = new Builder(getResources());
        builder.g = 2130906900;
        builder.h = true;
        builder = builder;
        builder.i = "primary_screen";
        builder = builder;
        builder.f = builder.k.getString(2131230748);
        builder = builder;
        builder.e = Optional.of(builder.k.getString(2131230737));
        Builder builder2 = builder;
        BaseNuxScreenController baseNuxScreenController = (BaseNuxScreenController) this.f1562q.get();
        Preconditions.checkNotNull(baseNuxScreenController);
        builder2.j = Optional.of(baseNuxScreenController);
        builder = builder2;
        Preconditions.checkNotNull(builder.f);
        Preconditions.checkArgument(builder.h);
        Preconditions.checkNotNull(builder.i);
        if (builder.a && builder.b) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z, "Cannot show beta tag and close button in the same NUX since they overlap");
        nuxScreenArr[0] = new NuxScreen(builder);
        return new NuxFlow(str, str2, nuxScreenArr);
    }

    protected final void m1619k() {
        if (m1615n().mo84f()) {
            setResult(-1);
        } else {
            setResult(0);
        }
        String str = "ridge_opt_in_nux_finish";
        RidgeAnalyticsLogger.m1551a(str, this.f1563r).m1550a(this.f1561p.f1464a);
        finish();
        m1614m();
    }

    protected final void m1620l() {
        String str = "ridge_opt_in_nux_close";
        RidgeAnalyticsLogger.m1551a(str, this.f1563r).m1550a(this.f1561p.f1464a);
        finish();
        m1614m();
    }

    private void m1614m() {
        overridePendingTransition(0, 2130968582);
    }

    private RidgeBaseIntroScreenController m1615n() {
        return (RidgeBaseIntroScreenController) this.f1562q.get();
    }
}
