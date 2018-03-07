package com.facebook.composer.minutiae.interstitial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.FindViewUtil;
import com.facebook.composer.minutiae.RidgeRuntimePermissionManager;
import com.facebook.composer.minutiae.RidgeRuntimePermissionManagerProvider;
import com.facebook.composer.minutiae.analytics.RidgeAnalyticsLogger;
import com.facebook.composer.minutiae.analytics.RidgeAnalyticsLogger.RidgeView;
import com.facebook.composer.minutiae.ridge.config.RidgeXConfig;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nux.NuxFlowController;
import com.facebook.nux.NuxScreen;
import com.facebook.resources.ui.FbTextView;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.xconfig.core.XConfigReader;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: toControlX */
public class RidgeNewIntroScreenController extends RidgeBaseIntroScreenController {
    public static final String f1569a = RidgeNewIntroScreenController.class.getSimpleName();
    public boolean f1570b = false;
    @Nullable
    public String f1571c;
    public final Context f1572d;
    public final XConfigReader f1573e;
    public final RidgeAnalyticsLogger f1574f;
    public final FbUriIntentHandler f1575g;
    public final AbstractFbErrorReporter f1576h;
    public final Toaster f1577i;
    public final RidgeRuntimePermissionManager f1578j;
    private FbTextView f1579k;

    /* compiled from: toControlX */
    class C01511 implements OnClickListener {
        final /* synthetic */ RidgeNewIntroScreenController f1567a;

        C01511(RidgeNewIntroScreenController ridgeNewIntroScreenController) {
            this.f1567a = ridgeNewIntroScreenController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -439643443);
            String a2 = this.f1567a.f1573e.a(RidgeXConfig.c, null);
            if (a2 == null || !this.f1567a.f1575g.a(this.f1567a.f1572d, a2)) {
                this.f1567a.f1576h.b(RidgeNewIntroScreenController.f1569a, "Invalid help URI: " + a2);
                Logger.a(2, EntryType.UI_INPUT_END, 1090275490, a);
                return;
            }
            String str = "ridge_opt_in_learn_more_tapped";
            RidgeAnalyticsLogger.m1551a(str, this.f1567a.f1571c).m1550a(this.f1567a.f1574f.f1464a);
            LogUtils.a(-118683308, a);
        }
    }

    /* compiled from: toControlX */
    class C01522 implements RuntimePermissionsListener {
        final /* synthetic */ RidgeNewIntroScreenController f1568a;

        C01522(RidgeNewIntroScreenController ridgeNewIntroScreenController) {
            this.f1568a = ridgeNewIntroScreenController;
        }

        public final void m1630a() {
            String str = "ridge_opt_in_turn_on_tapped";
            RidgeAnalyticsLogger.m1551a(str, this.f1568a.f1571c).m1550a(this.f1568a.f1574f.f1464a);
            this.f1568a.f1570b = true;
            this.f1568a.b.b();
        }

        public final void m1631a(String[] strArr, String[] strArr2) {
            this.f1568a.f1577i.a(new ToastBuilder(this.f1568a.f1578j.f1454c));
            this.f1568a.f1574f.m1556b(this.f1568a.f1571c, RidgeView.INTERSTITIAL_NUX);
        }

        public final void m1632b() {
            this.f1568a.f1574f.m1558c(this.f1568a.f1571c, RidgeView.INTERSTITIAL_NUX);
        }
    }

    public static RidgeNewIntroScreenController m1633b(InjectorLike injectorLike) {
        return new RidgeNewIntroScreenController((Context) injectorLike.getInstance(Context.class), XConfigReader.a(injectorLike), RidgeAnalyticsLogger.m1552a(injectorLike), FbUriIntentHandler.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (RidgeRuntimePermissionManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RidgeRuntimePermissionManagerProvider.class), Toaster.b(injectorLike));
    }

    @Inject
    public RidgeNewIntroScreenController(Context context, XConfigReader xConfigReader, RidgeAnalyticsLogger ridgeAnalyticsLogger, FbUriIntentHandler fbUriIntentHandler, AbstractFbErrorReporter abstractFbErrorReporter, RidgeRuntimePermissionManagerProvider ridgeRuntimePermissionManagerProvider, Toaster toaster) {
        this.f1572d = context;
        this.f1573e = xConfigReader;
        this.f1574f = ridgeAnalyticsLogger;
        this.f1575g = fbUriIntentHandler;
        this.f1576h = abstractFbErrorReporter;
        this.f1578j = ridgeRuntimePermissionManagerProvider.m1537a((Activity) ContextUtils.a(context, Activity.class));
        this.f1577i = toaster;
    }

    public final void m1635a(NuxScreen nuxScreen, NuxFlowController nuxFlowController, ViewGroup viewGroup, Intent intent, FragmentManager fragmentManager) {
        super.a(nuxScreen, nuxFlowController, viewGroup, intent, fragmentManager);
        this.f1579k = (FbTextView) FindViewUtil.b(this.c, 2131567098);
        this.f1579k.setOnClickListener(new C01511(this));
        String str = "ridge_opt_in_nux_start";
        RidgeAnalyticsLogger.m1551a(str, this.f1571c).m1550a(this.f1574f.f1464a);
    }

    public final void m1634a() {
        String str = "ridge_opt_in_not_now_tapped";
        RidgeAnalyticsLogger.m1551a(str, this.f1571c).m1550a(this.f1574f.f1464a);
        this.f1570b = false;
        this.b.b();
    }

    public final void m1637b() {
        this.f1578j.m1536a(new C01522(this));
    }

    public final void m1638c() {
        String str = "ridge_opt_in_back_out_tapped";
        RidgeAnalyticsLogger.m1551a(str, this.f1571c).m1550a(this.f1574f.f1464a);
        super.c();
    }

    public final void mo83a(String str) {
        this.f1571c = str;
    }

    public final boolean mo84f() {
        return this.f1570b;
    }
}
