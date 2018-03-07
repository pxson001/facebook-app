package com.facebook.groups.feed.ui.nux;

import android.os.Parcelable;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: ThreadViewLoader FETCH_THREAD  */
public class GroupsSeedsComposerSellSomethingNuxInterstitialController implements InterstitialController {
    private static final InterstitialTrigger f22422a = new InterstitialTrigger(Action.GROUP_SEEDS_COMPOSER);

    public final String m23504b() {
        return "3908";
    }

    public final void m23503a(Parcelable parcelable) {
    }

    public final void m23502a(long j) {
    }

    public final InterstitialControllerState m23501a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m23505c() {
        return ImmutableList.of(f22422a);
    }

    public final long hI_() {
        return 86400000;
    }
}
