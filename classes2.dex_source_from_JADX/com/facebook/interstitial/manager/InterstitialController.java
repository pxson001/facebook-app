package com.facebook.interstitial.manager;

import android.os.Parcelable;
import com.google.common.collect.ImmutableList;

/* compiled from: spdy/3 */
public interface InterstitialController {

    /* compiled from: spdy/3 */
    public enum InterstitialControllerState {
        ELIGIBLE,
        INELIGIBLE
    }

    InterstitialControllerState mo1170a(InterstitialTrigger interstitialTrigger);

    void mo1171a(long j);

    void mo1172a(Parcelable parcelable);

    String mo1173b();

    ImmutableList<InterstitialTrigger> mo1174c();

    long hI_();
}
