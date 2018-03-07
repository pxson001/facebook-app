package com.facebook.search.quickpromotion;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialIntentController;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.search.prefs.SearchAwarenessPrefKeys;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: T delimeter is not found */
public class TutorialNuxInterstitialController implements InterstitialIntentController {
    private final SearchAwarenessTutorialNuxController f22532a;
    public final FbSharedPreferences f22533b;

    public final Optional<Intent> m25996a(int i, Intent intent) {
        return Absent.INSTANCE;
    }

    @Inject
    public TutorialNuxInterstitialController(SearchAwarenessTutorialNuxController searchAwarenessTutorialNuxController, FbSharedPreferences fbSharedPreferences) {
        this.f22532a = searchAwarenessTutorialNuxController;
        this.f22533b = fbSharedPreferences;
    }

    public final Intent m25994a(Context context) {
        return SearchAwarenessTutorialNuxActivity.m25904a(context);
    }

    public final String m25999b() {
        return "4084";
    }

    public final void m25998a(Parcelable parcelable) {
    }

    public final void m25997a(long j) {
    }

    public final InterstitialControllerState m25995a(InterstitialTrigger interstitialTrigger) {
        return (!this.f22532a.m25952c() || this.f22533b.a(SearchAwarenessPrefKeys.b("4084"), false)) ? InterstitialControllerState.INELIGIBLE : InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m26000c() {
        return ImmutableList.of(new InterstitialTrigger(Action.SEARCH_TUTORIAL_NUX));
    }

    public final long hI_() {
        return this.f22533b.a(SearchAwarenessPrefKeys.g, false) ? 10000 : 86400000;
    }
}
