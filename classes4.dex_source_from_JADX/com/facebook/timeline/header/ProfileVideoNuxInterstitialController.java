package com.facebook.timeline.header;

import android.os.Parcelable;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.qe.api.QeAccessor;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: registerPushTokenParams */
public class ProfileVideoNuxInterstitialController implements InterstitialController {
    private final QeAccessor f3527a;
    public boolean f3528b = false;

    @Inject
    public ProfileVideoNuxInterstitialController(QeAccessor qeAccessor) {
        this.f3527a = qeAccessor;
    }

    public final String m3857b() {
        return "3972";
    }

    public final InterstitialControllerState m3854a(InterstitialTrigger interstitialTrigger) {
        if (this.f3528b && this.f3527a.a(ExperimentsForTimelineAbTestModule.aK, false)) {
            return InterstitialControllerState.ELIGIBLE;
        }
        return InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3858c() {
        return ImmutableList.of(new InterstitialTrigger(Action.TIMELINE));
    }

    public final void m3856a(Parcelable parcelable) {
    }

    public final void m3855a(long j) {
    }

    public final long hI_() {
        return 259200000;
    }
}
