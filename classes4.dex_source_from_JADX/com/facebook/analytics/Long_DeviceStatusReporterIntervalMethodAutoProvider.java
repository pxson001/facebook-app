package com.facebook.analytics;

import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: handler_exception */
public class Long_DeviceStatusReporterIntervalMethodAutoProvider extends AbstractProvider<Long> {
    public Object get() {
        return AnalyticsClientModule.a((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}
