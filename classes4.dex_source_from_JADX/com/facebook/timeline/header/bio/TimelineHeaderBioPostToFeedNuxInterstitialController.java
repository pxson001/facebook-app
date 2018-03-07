package com.facebook.timeline.header.bio;

import android.os.Parcelable;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: reg_terms_contacts_end_v3 */
public class TimelineHeaderBioPostToFeedNuxInterstitialController implements InterstitialController {
    public final String m3877b() {
        return "4079";
    }

    public final InterstitialControllerState m3874a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3878c() {
        return ImmutableList.of(new InterstitialTrigger(Action.TIMELINE_INTRO_CARD_BIO_POST_TO_FEED));
    }

    public final void m3876a(Parcelable parcelable) {
    }

    public final void m3875a(long j) {
    }

    public final long hI_() {
        return 0;
    }
}
