package com.facebook.messaging.clockskew;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: total_request */
public class ClockSkewLogger {
    public final AnalyticsLogger f2332a;

    public static ClockSkewLogger m4516b(InjectorLike injectorLike) {
        return new ClockSkewLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike));
    }

    @Inject
    public ClockSkewLogger(AnalyticsLogger analyticsLogger) {
        this.f2332a = analyticsLogger;
    }
}
