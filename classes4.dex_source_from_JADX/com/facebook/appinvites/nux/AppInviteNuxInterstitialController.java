package com.facebook.appinvites.nux;

import android.os.Parcelable;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: removeView TextureView failed */
public class AppInviteNuxInterstitialController implements InterstitialController {
    private static final InterstitialTrigger f3478a = new InterstitialTrigger(Action.APP_INVITE_FEED);

    public final String m3750b() {
        return "3205";
    }

    public final void m3749a(Parcelable parcelable) {
    }

    public final void m3748a(long j) {
    }

    public final InterstitialControllerState m3747a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3751c() {
        return ImmutableList.of(f3478a);
    }

    public final long hI_() {
        return 86400000;
    }
}
