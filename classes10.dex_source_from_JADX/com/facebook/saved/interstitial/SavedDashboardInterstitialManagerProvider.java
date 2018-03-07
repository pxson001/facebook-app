package com.facebook.saved.interstitial;

import android.content.Context;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: invalid filter type */
public class SavedDashboardInterstitialManagerProvider extends AbstractAssistedProvider<SavedDashboardInterstitialManager> {
    public final SavedDashboardInterstitialManager m9212a(Context context) {
        return new SavedDashboardInterstitialManager(context, (FbSharedPreferences) FbSharedPreferencesImpl.a(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), InterstitialManager.a(this));
    }
}
