package com.facebook.debug.fps;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.katana.orca.FbAnalyticsConfig;

/* compiled from: pokeUser */
public class TouchDelayLoggerProvider extends AbstractAssistedProvider<TouchDelayLogger> {
    public final TouchDelayLogger m14509a(String str) {
        return new TouchDelayLogger(FbAnalyticsConfig.m3559a(this), AnalyticsLoggerMethodAutoProvider.m3509a(this), C0055x2995691a.m1881a(this), Random_InsecureRandomMethodAutoProvider.m2102a(this), str);
    }
}
