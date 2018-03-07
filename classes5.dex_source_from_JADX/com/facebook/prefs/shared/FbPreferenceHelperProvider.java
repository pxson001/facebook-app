package com.facebook.prefs.shared;

import android.preference.Preference;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: datasavings */
public class FbPreferenceHelperProvider extends AbstractAssistedProvider<FbPreferenceHelper> {
    public final FbPreferenceHelper m10079a(Preference preference) {
        return new FbPreferenceHelper(preference, (FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}
