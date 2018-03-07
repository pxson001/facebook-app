package com.facebook.timeline.header.bio;

import android.os.Parcelable;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: reg_terms_contacts_end_v4 */
public class TimelineHeaderSuggestedBioNuxInterstitialController implements InterstitialController {
    public final String m3872b() {
        return "4058";
    }

    public final InterstitialControllerState m3869a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3873c() {
        return ImmutableList.of(new InterstitialTrigger(Action.TIMELINE_INTRO_CARD_SUGGESTED_BIO));
    }

    public final void m3871a(Parcelable parcelable) {
    }

    public final void m3870a(long j) {
    }

    public final long hI_() {
        return 0;
    }
}
