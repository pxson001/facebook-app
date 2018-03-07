package com.facebook.timeline.header;

import android.os.Parcelable;
import com.facebook.common.time.Clock;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: removeControllers() must be called before setting  */
public class ProfilePictureNuxBubbleInterstitialController implements InterstitialController {
    public long f3483a = 0;
    private final Clock f3484b;
    public boolean f3485c = false;

    @Inject
    public ProfilePictureNuxBubbleInterstitialController(Clock clock) {
        this.f3484b = clock;
    }

    public final String m3762b() {
        return "3336";
    }

    public final InterstitialControllerState m3759a(InterstitialTrigger interstitialTrigger) {
        if (!this.f3485c || this.f3483a == 0 || (this.f3484b.a() / 1000) - this.f3483a <= 15552000) {
            return InterstitialControllerState.INELIGIBLE;
        }
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3763c() {
        return ImmutableList.of(new InterstitialTrigger(Action.TIMELINE));
    }

    public final void m3761a(Parcelable parcelable) {
    }

    public final void m3760a(long j) {
    }

    public final long hI_() {
        return 259200000;
    }
}
