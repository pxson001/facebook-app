package com.facebook.common.diagnostics;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: mute_until */
public class Boolean_IsDebugLogsEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return DiagnosticsModule.a((FbSharedPreferences) FbSharedPreferencesImpl.a(this), IdBasedProvider.a(this, 3924));
    }
}
