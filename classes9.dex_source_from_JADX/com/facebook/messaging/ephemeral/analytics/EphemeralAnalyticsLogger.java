package com.facebook.messaging.ephemeral.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: mState */
public class EphemeralAnalyticsLogger {
    public final AnalyticsLogger f11061a;

    public static EphemeralAnalyticsLogger m11448b(InjectorLike injectorLike) {
        return new EphemeralAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public EphemeralAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f11061a = analyticsLogger;
    }
}
