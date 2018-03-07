package com.facebook.timeline.header.controllers;

import android.os.Parcelable;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: remote_ended */
public class TimelineIntroCardNuxInterstitialController implements InterstitialController {
    public boolean f3486a = false;

    public final String m3767b() {
        return "3621";
    }

    public final void m3766a(Parcelable parcelable) {
    }

    public final void m3765a(long j) {
    }

    public final InterstitialControllerState m3764a(InterstitialTrigger interstitialTrigger) {
        return this.f3486a ? InterstitialControllerState.ELIGIBLE : InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3768c() {
        return ImmutableList.of(new InterstitialTrigger(Action.TIMELINE));
    }

    public final long hI_() {
        return 86400000;
    }
}
