package com.facebook.rapidfeedback.nux;

import android.content.Context;
import android.os.Parcelable;
import com.facebook.common.util.TriState;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.manager.InterstitialActionController;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.rapidfeedback.RapidFeedbackController;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: SIZE_DEFAULT */
public class RapidFeedbackNuxInterstitialController implements InterstitialActionController, InterstitialController {
    private final Lazy<RapidFeedbackController> f11381a;
    private final Provider<TriState> f11382b;

    @Inject
    public RapidFeedbackNuxInterstitialController(Lazy<RapidFeedbackController> lazy, Provider<TriState> provider) {
        this.f11381a = lazy;
        this.f11382b = provider;
    }

    public final void m11716a(Context context, Object obj) {
        if (!((TriState) this.f11382b.get()).asBoolean(false)) {
            ((RapidFeedbackController) this.f11381a.get()).a("1565141090400626", context);
        }
    }

    public final String m11718b() {
        return "3184";
    }

    public final void m11717a(Parcelable parcelable) {
    }

    public final void m11715a(long j) {
    }

    public final ImmutableList<InterstitialTrigger> m11719c() {
        return ImmutableList.of(new InterstitialTrigger(Action.APP_FOREGROUND));
    }

    public final InterstitialControllerState m11714a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final long hI_() {
        return 0;
    }
}
