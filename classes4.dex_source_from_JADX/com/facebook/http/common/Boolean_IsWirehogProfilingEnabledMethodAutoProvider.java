package com.facebook.http.common;

import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: vploss_count_thresh */
public class Boolean_IsWirehogProfilingEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return FbHttpModule.d((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}
