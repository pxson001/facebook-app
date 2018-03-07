package com.facebook.http.common;

import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: vploss_count_window */
public class Boolean_IsTeakProfilingEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return FbHttpModule.b((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}
