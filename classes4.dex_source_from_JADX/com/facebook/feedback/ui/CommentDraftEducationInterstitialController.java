package com.facebook.feedback.ui;

import android.os.Parcelable;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: reliability_serialized */
public class CommentDraftEducationInterstitialController implements InterstitialController {
    public static final InterstitialTrigger f3498a = new InterstitialTrigger(Action.PERMALINK_DRAFT_SAVE);

    public final String m3779b() {
        return "3746";
    }

    public final void m3778a(Parcelable parcelable) {
    }

    public final void m3777a(long j) {
    }

    public final InterstitialControllerState m3776a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3780c() {
        return ImmutableList.of(new InterstitialTrigger(Action.PERMALINK_DRAFT_SAVE));
    }

    public final long hI_() {
        return 86400000;
    }
}
