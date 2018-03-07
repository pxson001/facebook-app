package com.facebook.events.permalink.guestlist;

import com.facebook.interstitial.manager.BaseInterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: releaseSurfaceTexture */
public class GuestListSeenStateInterstitialController extends BaseInterstitialController {
    public static final InterstitialTrigger f3506a = new InterstitialTrigger(Action.EVENTS_GUEST_LIST_INVITED_TAB);

    public final String m3800b() {
        return "3763";
    }

    public final InterstitialControllerState m3799a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3801c() {
        return ImmutableList.of(f3506a);
    }

    public final long hI_() {
        return 10000;
    }
}
