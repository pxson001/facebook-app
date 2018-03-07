package com.facebook.groups.feed.ui.nux;

import android.os.Parcelable;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: relative_time */
public class GroupsSeedsComposerNuxInterstitialController implements InterstitialController {
    private static final InterstitialTrigger f3508a = new InterstitialTrigger(Action.GROUP_SEEDS_COMPOSER);

    public final String m3808b() {
        return "3775";
    }

    public final void m3807a(Parcelable parcelable) {
    }

    public final void m3806a(long j) {
    }

    public final InterstitialControllerState m3805a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3809c() {
        return ImmutableList.of(f3508a);
    }

    public final long hI_() {
        return 86400000;
    }
}
