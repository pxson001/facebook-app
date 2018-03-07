package com.facebook.events.ui.privacy;

import com.facebook.interstitial.manager.BaseInterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: relative_url */
public class EventsPrivacyEducationInterstitialController extends BaseInterstitialController {
    public static final InterstitialTrigger f3507a = new InterstitialTrigger(Action.EVENTS_CREATION_LOCKED_PRIVACY_EDUCATION_WIDGET);

    public final String m3803b() {
        return "3764";
    }

    public final InterstitialControllerState m3802a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3804c() {
        return ImmutableList.of(f3507a);
    }
}
