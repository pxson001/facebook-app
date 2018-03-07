package com.facebook.push.prefs;

import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: gql_payload */
public class Boolean_IsMobileOnlineAvailabilityEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return ChatOnPrefModule.a((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}
