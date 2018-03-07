package com.facebook.appinvites.nux;

import android.os.Parcelable;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: render_as_sticker */
public class AppInviteCaretNuxInterstitialController implements InterstitialController {
    private static final InterstitialTrigger f3477a = new InterstitialTrigger(Action.APP_INVITE_CARET);

    public final String m3740b() {
        return "3078";
    }

    public final void m3739a(Parcelable parcelable) {
    }

    public final void m3738a(long j) {
    }

    public final InterstitialControllerState m3737a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3741c() {
        return ImmutableList.of(f3477a);
    }

    public final long hI_() {
        return 86400000;
    }
}
