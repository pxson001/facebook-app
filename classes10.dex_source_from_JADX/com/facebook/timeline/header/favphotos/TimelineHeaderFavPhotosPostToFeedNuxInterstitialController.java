package com.facebook.timeline.header.favphotos;

import android.os.Parcelable;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: fhnyfnumpummjimgwedfgjayhawcfycccasdncehjcurpfgfeasnewnowordbmwkovujhjoyvvvroccnjricyjdndy */
public class TimelineHeaderFavPhotosPostToFeedNuxInterstitialController implements InterstitialController {
    public final String m11816b() {
        return "4075";
    }

    public final InterstitialControllerState m11813a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m11817c() {
        return ImmutableList.of(new InterstitialTrigger(Action.TIMELINE_INTRO_CARD_FAV_PHOTOS_POST_TO_FEED));
    }

    public final void m11815a(Parcelable parcelable) {
    }

    public final void m11814a(long j) {
    }

    public final long hI_() {
        return 0;
    }
}
