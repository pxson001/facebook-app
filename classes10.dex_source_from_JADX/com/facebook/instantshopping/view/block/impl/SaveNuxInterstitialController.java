package com.facebook.instantshopping.view.block.impl;

import com.facebook.instantshopping.InstantShoppingPrefKeys;
import com.facebook.interstitial.manager.BaseInterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: SSL_CLOCK_SKEW */
public class SaveNuxInterstitialController extends BaseInterstitialController {
    public static final InterstitialTrigger f23830b = new InterstitialTrigger(Action.INSTANT_SHOPPING_SAVE_NUX);
    public TipSeenTracker f23831a;

    @Inject
    public SaveNuxInterstitialController(TipSeenTracker tipSeenTracker) {
        this.f23831a = tipSeenTracker;
        this.f23831a.b = 3;
        this.f23831a.a(InstantShoppingPrefKeys.f23461c);
    }

    public final String m25116b() {
        return "3903";
    }

    public final InterstitialControllerState m25115a(InterstitialTrigger interstitialTrigger) {
        if (this.f23831a.c()) {
            return InterstitialControllerState.ELIGIBLE;
        }
        return InterstitialControllerState.INELIGIBLE;
    }

    public final long hI_() {
        return 259200000;
    }

    public final ImmutableList<InterstitialTrigger> m25117c() {
        return ImmutableList.of(f23830b);
    }
}
