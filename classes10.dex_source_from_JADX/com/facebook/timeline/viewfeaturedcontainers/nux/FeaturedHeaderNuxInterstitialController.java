package com.facebook.timeline.viewfeaturedcontainers.nux;

import android.os.Parcelable;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: extra_events_discovery_fragment_range_index */
public class FeaturedHeaderNuxInterstitialController implements InterstitialController {
    public final String m12795b() {
        return "4139";
    }

    public final InterstitialControllerState m12792a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m12796c() {
        return ImmutableList.of(new InterstitialTrigger(Action.TIMELINE_FEATURED));
    }

    public final void m12794a(Parcelable parcelable) {
    }

    public final void m12793a(long j) {
    }

    public final long hI_() {
        return 0;
    }
}
