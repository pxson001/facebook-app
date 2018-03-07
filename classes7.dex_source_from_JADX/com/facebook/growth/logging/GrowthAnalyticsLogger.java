package com.facebook.growth.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: prefetch_newsfeed_image_in_bkg */
public class GrowthAnalyticsLogger {
    public final AnalyticsLogger f6090a;

    public static GrowthAnalyticsLogger m7889b(InjectorLike injectorLike) {
        return new GrowthAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public GrowthAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f6090a = analyticsLogger;
    }
}
