package com.facebook.timeline.header.favphotos;

import android.os.Parcelable;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: registerPushNoUser */
public class TimelineHeaderSuggestedPhotosNuxInterstitialController implements InterstitialController {
    public final String m3867b() {
        return "4017";
    }

    public final InterstitialControllerState m3864a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3868c() {
        return ImmutableList.of(new InterstitialTrigger(Action.TIMELINE_INTRO_CARD_SUGGESTED_PHOTOS));
    }

    public final void m3866a(Parcelable parcelable) {
    }

    public final void m3865a(long j) {
    }

    public final long hI_() {
        return 0;
    }
}
