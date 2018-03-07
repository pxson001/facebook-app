package com.facebook.feed.seefirst;

import android.os.Parcelable;
import com.facebook.common.time.Clock;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.interstitial.prefs.InterstitialPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: showIcon */
public class SeeFirstNuxInterstitialController implements InterstitialController {
    private final Clock f3758a;
    private final FbSharedPreferences f3759b;

    @Inject
    public SeeFirstNuxInterstitialController(FbSharedPreferences fbSharedPreferences, Clock clock) {
        this.f3759b = fbSharedPreferences;
        this.f3758a = clock;
    }

    public final String m4426b() {
        return "3193";
    }

    public final void m4425a(Parcelable parcelable) {
    }

    public final void m4424a(long j) {
    }

    public final InterstitialControllerState m4423a(InterstitialTrigger interstitialTrigger) {
        long a = this.f3759b.a(InterstitialPrefKeys.b("3193"), 0);
        if (a == 0 || this.f3758a.a() >= a + 259200000) {
            return InterstitialControllerState.ELIGIBLE;
        }
        return InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m4427c() {
        return ImmutableList.of(new InterstitialTrigger(Action.SEE_FIRST_INDICATOR));
    }

    public final long hI_() {
        return 259200000;
    }
}
