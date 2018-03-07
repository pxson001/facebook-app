package com.facebook.http.common;

import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: vploss_thresh */
public class Boolean_IsPhpProfilingEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return FbHttpModule.a((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}
