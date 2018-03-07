package com.facebook.localcontent.menus.nux;

import android.content.res.Resources;
import android.os.Parcelable;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: e6133917c8c80cd9d72a130627bf31a1 */
public class AddPhotoMenuMoreTabNuxController implements InterstitialController {
    private Resources f15117a;

    @Inject
    public AddPhotoMenuMoreTabNuxController(Resources resources) {
        this.f15117a = resources;
    }

    public final String m17563b() {
        return "3395";
    }

    public final void m17562a(Parcelable parcelable) {
    }

    public final void m17561a(long j) {
    }

    public final InterstitialControllerState m17560a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m17564c() {
        return ImmutableList.of(new InterstitialTrigger(Action.PAGES_MANAGER_APP_OPENED_NEW_PAGE));
    }

    public final long hI_() {
        return 86400000;
    }
}
