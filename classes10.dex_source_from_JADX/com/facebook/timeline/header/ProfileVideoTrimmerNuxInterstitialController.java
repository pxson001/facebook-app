package com.facebook.timeline.header;

import android.os.Parcelable;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: friends_nearby_dashboard_impression */
public class ProfileVideoTrimmerNuxInterstitialController implements InterstitialController {
    public boolean f11313a = false;

    public final String m11403b() {
        return "4101";
    }

    public final void m11402a(Parcelable parcelable) {
    }

    public final void m11401a(long j) {
    }

    public final InterstitialControllerState m11400a(InterstitialTrigger interstitialTrigger) {
        return this.f11313a ? InterstitialControllerState.ELIGIBLE : InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m11404c() {
        return ImmutableList.of(new InterstitialTrigger(Action.TIMELINE));
    }

    public final long hI_() {
        return 86400000;
    }
}
