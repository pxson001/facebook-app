package com.facebook.events.create.ui;

import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.BaseInterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: relative_humidity */
public class CoverPhotoSelectorThemeInterstitialController extends BaseInterstitialController {
    public static final InterstitialTrigger f3509a = new InterstitialTrigger(Action.EVENTS_COVER_PHOTO_SELECTOR_THEME_NUX);

    private static CoverPhotoSelectorThemeInterstitialController m3819d() {
        return new CoverPhotoSelectorThemeInterstitialController();
    }

    public final String m3821b() {
        return "3819";
    }

    public final InterstitialControllerState m3820a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3822c() {
        return ImmutableList.of(f3509a);
    }

    public static CoverPhotoSelectorThemeInterstitialController m3818a(InjectorLike injectorLike) {
        return m3819d();
    }
}
