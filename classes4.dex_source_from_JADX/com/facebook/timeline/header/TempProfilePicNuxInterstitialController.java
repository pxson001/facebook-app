package com.facebook.timeline.header;

import android.os.Parcelable;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: reindexContactNames */
public class TempProfilePicNuxInterstitialController implements InterstitialController {
    public boolean f3518a = false;

    public final String m3836b() {
        return "3876";
    }

    public final void m3835a(Parcelable parcelable) {
    }

    public final void m3834a(long j) {
    }

    public final InterstitialControllerState m3833a(InterstitialTrigger interstitialTrigger) {
        return this.f3518a ? InterstitialControllerState.ELIGIBLE : InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3837c() {
        return ImmutableList.of(new InterstitialTrigger(Action.TIMELINE));
    }

    public final long hI_() {
        return 86400000;
    }
}
