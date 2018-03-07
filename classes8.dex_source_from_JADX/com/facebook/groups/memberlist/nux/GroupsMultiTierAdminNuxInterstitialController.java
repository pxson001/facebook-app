package com.facebook.groups.memberlist.nux;

import android.os.Parcelable;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: extra_location */
public class GroupsMultiTierAdminNuxInterstitialController implements InterstitialController {
    private static final ImmutableList<InterstitialTrigger> f14458a = ImmutableList.of(new InterstitialTrigger(Action.GROUP_ADD_MODERATOR));

    public final String m15987b() {
        return "4136";
    }

    public final void m15986a(Parcelable parcelable) {
    }

    public final void m15985a(long j) {
    }

    public final InterstitialControllerState m15984a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m15988c() {
        return f14458a;
    }

    public final long hI_() {
        return 86400000;
    }
}
