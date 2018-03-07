package com.facebook.messaging.nativesurvey;

import android.os.Parcelable;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: rotation_ */
public class MessengerSurveyInterstitialController implements InterstitialController {
    private static final InterstitialTrigger f3337a = new InterstitialTrigger(Action.MESSENGER_THREAD_LIST);

    public final String m3255b() {
        return "3171";
    }

    public final void m3254a(Parcelable parcelable) {
    }

    public final void m3253a(long j) {
    }

    public final InterstitialControllerState m3252a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3256c() {
        return ImmutableList.of(f3337a);
    }

    public final long hI_() {
        return 0;
    }
}
