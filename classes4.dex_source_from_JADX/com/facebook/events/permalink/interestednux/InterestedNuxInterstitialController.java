package com.facebook.events.permalink.interestednux;

import com.facebook.interstitial.manager.BaseInterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: registration_id */
public class InterestedNuxInterstitialController extends BaseInterstitialController {
    public static final InterstitialTrigger f3524a = new InterstitialTrigger(Action.EVENTS_INTERESTED_RSVP_NUX);

    public final String m3844b() {
        return "3884";
    }

    public final InterstitialControllerState m3843a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3845c() {
        return ImmutableList.of(f3524a);
    }
}
