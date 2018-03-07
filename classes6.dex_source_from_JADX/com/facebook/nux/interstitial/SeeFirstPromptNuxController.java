package com.facebook.nux.interstitial;

import android.os.Parcelable;
import android.view.View;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.seefirst.seefirstnux.SeeFirstNuxManager;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: isGraduated */
public class SeeFirstPromptNuxController implements InterstitialController {
    private SeeFirstNuxManager f12256a;

    @Inject
    public SeeFirstPromptNuxController(SeeFirstNuxManager seeFirstNuxManager) {
        this.f12256a = seeFirstNuxManager;
    }

    public final String m19158b() {
        return "3573";
    }

    public final InterstitialControllerState m19155a(InterstitialTrigger interstitialTrigger) {
        return this.f12256a.m16600a() ? InterstitialControllerState.ELIGIBLE : InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m19159c() {
        return ImmutableList.of(new InterstitialTrigger(Action.TIMELINE), new InterstitialTrigger(Action.PAGE_ACTIONBAR));
    }

    public final void m19157a(Parcelable parcelable) {
    }

    public final void m19156a(long j) {
    }

    public final long hI_() {
        return 0;
    }

    public static void m19154a(View view) {
        Tooltip tooltip = new Tooltip(view.getContext(), 2);
        tooltip.t = -1;
        tooltip.a(2131233359);
        tooltip.b(2131233360);
        tooltip.b(0.2f);
        tooltip.a(view);
    }
}
