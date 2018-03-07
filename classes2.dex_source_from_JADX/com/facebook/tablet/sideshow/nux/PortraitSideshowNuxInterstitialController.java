package com.facebook.tablet.sideshow.nux;

import android.content.Context;
import android.os.Parcelable;
import com.facebook.common.appchoreographer.AppChoreographer$Priority;
import com.facebook.common.appchoreographer.AppChoreographer$ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.interstitial.manager.InterstitialActionController;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.tablet.abtest.TabletExperimentConfiguration;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: mData= */
public class PortraitSideshowNuxInterstitialController implements InterstitialActionController, InterstitialController {
    private DefaultAppChoreographer f15651a;
    private FbSharedPreferences f15652b;
    private TabletExperimentConfiguration f15653c;

    @Inject
    public PortraitSideshowNuxInterstitialController(DefaultAppChoreographer defaultAppChoreographer, FbSharedPreferences fbSharedPreferences, TabletExperimentConfiguration tabletExperimentConfiguration) {
        this.f15651a = defaultAppChoreographer;
        this.f15652b = fbSharedPreferences;
        this.f15653c = tabletExperimentConfiguration;
    }

    public final void mo1752a(Context context, Object obj) {
        this.f15651a.m1634a("Show tablet NUX", new 1(this, context), AppChoreographer$Priority.APPLICATION_LOADED_UI_IDLE_HIGH_PRIORITY, AppChoreographer$ThreadType.UI);
    }

    public final String mo1173b() {
        return "3417";
    }

    public final void mo1172a(Parcelable parcelable) {
    }

    public final void mo1171a(long j) {
    }

    public final InterstitialControllerState mo1170a(InterstitialTrigger interstitialTrigger) {
        if (!this.f15653c.m7859b()) {
            return InterstitialControllerState.INELIGIBLE;
        }
        if (this.f15652b.mo286a(NuxSideshowUnitType.a, false)) {
            return InterstitialControllerState.INELIGIBLE;
        }
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> mo1174c() {
        return ImmutableList.of(new InterstitialTrigger(Action.APP_FOREGROUND));
    }

    public final long hI_() {
        return 86400000;
    }
}
