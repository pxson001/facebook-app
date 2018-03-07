package com.facebook.adinterfaces.ui.preview;

import android.os.Parcelable;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: registerPushTokenNoUserParams */
public class AdInterfacesResultsTooltipNuxController implements InterstitialController {
    public final String m3862b() {
        return "3960";
    }

    public final void m3861a(Parcelable parcelable) {
    }

    public final void m3860a(long j) {
    }

    public final InterstitialControllerState m3859a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3863c() {
        return ImmutableList.of(new InterstitialTrigger(Action.AD_INTERFACES_VIEW_RESULTS));
    }

    public final long hI_() {
        return 86400000;
    }
}
