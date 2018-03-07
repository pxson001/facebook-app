package com.facebook.zero.upsell.ui.screencontroller;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.view.View;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.TimeSpan;
import com.facebook.inject.InjectorLike;
import com.facebook.iorg.common.upsell.activity.ZeroInterstitialActivityResultHandler;
import com.facebook.iorg.common.upsell.ui.UpsellDialogFragment.Screen;
import com.facebook.iorg.common.upsell.ui.UpsellDialogView;
import com.facebook.iorg.common.upsell.ui.screencontroller.AbstractUpsellDialogScreenController;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: visit_activity_tab */
public class VpnCallToHandleController extends AbstractUpsellDialogScreenController {
    public final ZeroInterstitialActivityResultHandler f310c;
    private final Handler f311d;
    private UpsellDialogView f312e;
    private final Runnable f313f = new C00461(this);

    /* compiled from: visit_activity_tab */
    class C00461 implements Runnable {
        final /* synthetic */ VpnCallToHandleController f308a;

        C00461(VpnCallToHandleController vpnCallToHandleController) {
            this.f308a = vpnCallToHandleController;
        }

        public void run() {
            this.f308a.f310c.a(null);
            this.f308a.m349g();
        }
    }

    /* compiled from: visit_activity_tab */
    class C00472 implements Runnable {
        final /* synthetic */ VpnCallToHandleController f309a;

        C00472(VpnCallToHandleController vpnCallToHandleController) {
            this.f309a = vpnCallToHandleController;
        }

        public void run() {
            this.f309a.m349g();
        }
    }

    public static VpnCallToHandleController m346b(InjectorLike injectorLike) {
        return new VpnCallToHandleController(ZeroInterstitialActivityResultHandler.a(injectorLike), Handler_ForUiThreadMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public VpnCallToHandleController(ZeroInterstitialActivityResultHandler zeroInterstitialActivityResultHandler, Handler handler) {
        this.f310c = zeroInterstitialActivityResultHandler;
        this.f311d = handler;
    }

    public final View m347a(Context context) {
        Intent putExtra = new Intent().setClassName("org.internet", "com.facebook.iorg.app.activity.IorgDialogActivity").putExtra("protocol_version", 1).putExtra("token", "there_is_no_token").putExtra("feature_key_string_v2", this.a.ar.prefString);
        this.f312e = new UpsellDialogView(context);
        this.f312e.a();
        Object obj = null;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null && packageManager.queryIntentActivities(putExtra, 65536).size() == 1) {
            int i = 1;
        }
        if (obj == null) {
            HandlerDetour.a(this.f311d, new C00472(this), 572178013);
            return this.f312e;
        }
        this.f310c.a(this.a);
        this.a.ao().startActivityForResult(putExtra, 7979);
        HandlerDetour.b(this.f311d, this.f313f, new TimeSpan(3, TimeUnit.MINUTES).a(), -260203779);
        return this.f312e;
    }

    public final void m348a() {
        HandlerDetour.a(this.f311d, this.f313f);
    }

    public final void m349g() {
        if (this.a != null) {
            this.a.a(Screen.FETCH_UPSELL);
        }
    }
}
