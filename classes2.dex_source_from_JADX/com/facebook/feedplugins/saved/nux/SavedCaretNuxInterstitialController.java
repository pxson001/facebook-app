package com.facebook.feedplugins.saved.nux;

import android.os.Parcelable;
import com.facebook.common.time.Clock;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.interstitial.prefs.InterstitialPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: intermediate_failed @ onFailure */
public class SavedCaretNuxInterstitialController implements InterstitialController {
    private final Clock f19741a;
    private final FbSharedPreferences f19742b;

    @Inject
    public SavedCaretNuxInterstitialController(FbSharedPreferences fbSharedPreferences, Clock clock) {
        this.f19741a = clock;
        this.f19742b = fbSharedPreferences;
    }

    public final String mo1173b() {
        return "2862";
    }

    public final void mo1172a(@Nullable Parcelable parcelable) {
    }

    public final void mo1171a(long j) {
    }

    public final InterstitialControllerState mo1170a(InterstitialTrigger interstitialTrigger) {
        long a = this.f19742b.mo277a(InterstitialPrefKeys.m12489b("2943"), 0);
        if (a == 0 || this.f19741a.mo211a() >= a + 172800000) {
            return InterstitialControllerState.ELIGIBLE;
        }
        return InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> mo1174c() {
        return ImmutableList.of(new InterstitialTrigger(Action.FEED_STORY_CARET));
    }

    public final long hI_() {
        return 172800000;
    }
}
