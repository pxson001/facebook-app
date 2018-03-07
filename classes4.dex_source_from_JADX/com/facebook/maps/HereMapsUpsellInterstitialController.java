package com.facebook.maps;

import android.os.Parcelable;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: remove_count */
public class HereMapsUpsellInterstitialController implements InterstitialController {
    public final String m3745b() {
        return "3127";
    }

    public final void m3744a(Parcelable parcelable) {
    }

    public final void m3743a(long j) {
    }

    public final InterstitialControllerState m3742a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3746c() {
        return ImmutableList.of(new InterstitialTrigger(Action.MAPS_LAUNCH_EXTERNAL_MAP_APP));
    }

    public final long hI_() {
        return 86400000;
    }
}
