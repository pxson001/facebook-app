package com.facebook.events.invite;

import com.facebook.interstitial.manager.BaseInterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: registrationRegisterAccountParams */
public class EventsInviteThroughMessengerInterstitialController extends BaseInterstitialController {
    public static final InterstitialTrigger f3526a = new InterstitialTrigger(Action.EVENTS_INVITE_THROUGH_MESSENGER_NUX);

    public final String m3852b() {
        return "3936";
    }

    public final InterstitialControllerState m3851a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3853c() {
        return ImmutableList.of(f3526a);
    }
}
