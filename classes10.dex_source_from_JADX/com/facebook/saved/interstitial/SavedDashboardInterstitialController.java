package com.facebook.saved.interstitial;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialIntentController;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.saved.prefs.SavedPrefKeys;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: invalid_notification_parcelable */
public class SavedDashboardInterstitialController implements InterstitialIntentController {
    private FbSharedPreferences f9187a;

    public final Optional<Intent> m9206a(int i, Intent intent) {
        return Absent.INSTANCE;
    }

    @Inject
    public SavedDashboardInterstitialController(FbSharedPreferences fbSharedPreferences) {
        this.f9187a = fbSharedPreferences;
    }

    public final String m9209b() {
        return "2607";
    }

    public final void m9208a(@Nullable Parcelable parcelable) {
    }

    public final Intent m9204a(Context context) {
        return new Intent(context, SavedDashboardInterstitialActivity.class);
    }

    public final void m9207a(long j) {
    }

    public final InterstitialControllerState m9205a(InterstitialTrigger interstitialTrigger) {
        return this.f9187a.a(SavedPrefKeys.b, false) ? InterstitialControllerState.INELIGIBLE : InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m9210c() {
        return ImmutableList.of(new InterstitialTrigger(Action.SAVED_DASHBOARD_START));
    }

    public final long hI_() {
        return 86400000;
    }
}
