package com.facebook.richdocument.nux;

import com.facebook.common.time.Clock;
import com.facebook.interstitial.manager.BaseInterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.interstitial.prefs.InterstitialPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: photo_count_48_h */
public class InstantArticleIconInterstitialController extends BaseInterstitialController {
    public static final InterstitialTrigger f6374a = new InterstitialTrigger(Action.INSTANT_ARTICLE);
    private final Clock f6375b;
    private final FbSharedPreferences f6376c;

    @Inject
    public InstantArticleIconInterstitialController(FbSharedPreferences fbSharedPreferences, Clock clock) {
        this.f6376c = fbSharedPreferences;
        this.f6375b = clock;
    }

    public final String m6768b() {
        return "3838";
    }

    public final InterstitialControllerState m6767a(InterstitialTrigger interstitialTrigger) {
        long a = this.f6376c.a(InterstitialPrefKeys.b("3838"), 0);
        if (a == 0 || this.f6375b.a() - a > 259200000) {
            return InterstitialControllerState.ELIGIBLE;
        }
        return InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m6769c() {
        return ImmutableList.of(f6374a);
    }

    public final long hI_() {
        return 259200000;
    }
}
