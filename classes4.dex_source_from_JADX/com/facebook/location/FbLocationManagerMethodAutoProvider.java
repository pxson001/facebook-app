package com.facebook.location;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;

/* compiled from: is_primary */
public class FbLocationManagerMethodAutoProvider extends AbstractProvider<FbLocationManager> {
    public Object get() {
        return LocationModule.a(IdBasedProvider.a(this, 703), GooglePlayServicesUtil.a(this), FbZeroFeatureVisibilityHelper.a(this), IdBasedProvider.a(this, 2484), IdBasedProvider.a(this, 7449), IdBasedProvider.a(this, 2490), PerfTestConfig.a(this), (FbSharedPreferences) FbSharedPreferencesImpl.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this));
    }
}
