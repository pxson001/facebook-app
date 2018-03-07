package com.facebook.location;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;

/* compiled from: js_css_minification_version */
public class FbLocationContinuousListenerMethodAutoProvider extends AbstractProvider<FbLocationContinuousListener> {
    public static FbLocationContinuousListener m10147b(InjectorLike injectorLike) {
        return LocationModule.a(IdBasedProvider.a(injectorLike, 703), GooglePlayServicesUtil.a(injectorLike), FbZeroFeatureVisibilityHelper.a(injectorLike), IdBasedProvider.a(injectorLike, 7453), IdBasedProvider.a(injectorLike, 7448), IdBasedProvider.a(injectorLike, 2489), PerfTestConfig.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    public Object get() {
        return LocationModule.a(IdBasedProvider.a(this, 703), GooglePlayServicesUtil.a(this), FbZeroFeatureVisibilityHelper.a(this), IdBasedProvider.a(this, 7453), IdBasedProvider.a(this, 7448), IdBasedProvider.a(this, 2489), PerfTestConfig.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this));
    }
}
