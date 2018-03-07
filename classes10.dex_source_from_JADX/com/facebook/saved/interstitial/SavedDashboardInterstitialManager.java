package com.facebook.saved.interstitial;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.Assisted;
import com.facebook.interstitial.manager.InterstitialIntentController;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.saved.prefs.SavedPrefKeys;
import javax.inject.Inject;

/* compiled from: invalid placement in response */
public class SavedDashboardInterstitialManager {
    private final Context f9188a;
    public final FbSharedPreferences f9189b;
    private final SecureContextHelper f9190c;
    public final InterstitialManager f9191d;

    @Inject
    public SavedDashboardInterstitialManager(@Assisted Context context, FbSharedPreferences fbSharedPreferences, SecureContextHelper secureContextHelper, InterstitialManager interstitialManager) {
        this.f9188a = context;
        this.f9189b = fbSharedPreferences;
        this.f9190c = secureContextHelper;
        this.f9191d = interstitialManager;
    }

    public final void m9211a() {
        InterstitialIntentController interstitialIntentController = (InterstitialIntentController) this.f9191d.a(new InterstitialTrigger(Action.SAVED_DASHBOARD_START), InterstitialIntentController.class);
        if (interstitialIntentController != null) {
            Intent a = interstitialIntentController.a(this.f9188a);
            if (a != null) {
                this.f9191d.a().a(interstitialIntentController.b());
                this.f9189b.edit().putBoolean(SavedPrefKeys.b, true).commit();
                this.f9190c.a(a, this.f9188a);
            }
        }
    }
}
