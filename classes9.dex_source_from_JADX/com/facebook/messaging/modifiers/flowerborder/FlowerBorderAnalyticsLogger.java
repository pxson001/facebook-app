package com.facebook.messaging.modifiers.flowerborder;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: keyword_trigger */
public class FlowerBorderAnalyticsLogger {
    public final AnalyticsLogger f12266a;

    public static FlowerBorderAnalyticsLogger m12735a(InjectorLike injectorLike) {
        return new FlowerBorderAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FlowerBorderAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f12266a = analyticsLogger;
    }
}
