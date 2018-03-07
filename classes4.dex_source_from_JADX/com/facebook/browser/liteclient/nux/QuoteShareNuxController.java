package com.facebook.browser.liteclient.nux;

import android.content.Context;
import android.os.Parcelable;
import com.facebook.browser.lite.BrowserLiteIntentServiceHelper;
import com.facebook.browser.liteclient.qe.ExperimentsForBrowserLiteQEModule;
import com.facebook.interstitial.manager.InterstitialActionController;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.qe.api.QeAccessor;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: reg_login_nonce */
public class QuoteShareNuxController implements InterstitialActionController, InterstitialController {
    private Context f3531a;
    private QeAccessor f3532b;

    @Inject
    public QuoteShareNuxController(Context context, QeAccessor qeAccessor) {
        this.f3531a = context;
        this.f3532b = qeAccessor;
    }

    public final String m3891b() {
        return "4174";
    }

    public final void m3890a(Parcelable parcelable) {
    }

    public final void m3888a(long j) {
    }

    public final InterstitialControllerState m3887a(InterstitialTrigger interstitialTrigger) {
        if (this.f3532b.a(ExperimentsForBrowserLiteQEModule.a, false)) {
            return InterstitialControllerState.ELIGIBLE;
        }
        return InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3892c() {
        return ImmutableList.of(new InterstitialTrigger(Action.BUILT_IN_BROWSER));
    }

    public final long hI_() {
        return 86400000;
    }

    public final void m3889a(Context context, Object obj) {
        BrowserLiteIntentServiceHelper.c(this.f3531a);
    }
}
