package com.facebook.feedplugins.saved.nux;

import android.os.Parcelable;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: messenger_sync */
public class SavedOnlyMeShareNuxInterstitialController implements InterstitialController {
    public final String mo1173b() {
        return "3909";
    }

    public final void mo1172a(@Nullable Parcelable parcelable) {
    }

    public final void mo1171a(long j) {
    }

    public final InterstitialControllerState mo1170a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> mo1174c() {
        return ImmutableList.of(new InterstitialTrigger(Action.FEED_STORY_ONLY_ME_SHARE));
    }

    public final long hI_() {
        return 86400000;
    }
}
