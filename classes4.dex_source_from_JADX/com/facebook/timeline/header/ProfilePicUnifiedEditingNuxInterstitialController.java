package com.facebook.timeline.header;

import android.os.Parcelable;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: registration_fbns_id */
public class ProfilePicUnifiedEditingNuxInterstitialController implements InterstitialController {
    public boolean f3525a = false;

    public final String m3849b() {
        return "3887";
    }

    public final void m3848a(Parcelable parcelable) {
    }

    public final void m3847a(long j) {
    }

    public final InterstitialControllerState m3846a(InterstitialTrigger interstitialTrigger) {
        return this.f3525a ? InterstitialControllerState.ELIGIBLE : InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3850c() {
        return ImmutableList.of(new InterstitialTrigger(Action.TIMELINE));
    }

    public final long hI_() {
        return 86400000;
    }
}
