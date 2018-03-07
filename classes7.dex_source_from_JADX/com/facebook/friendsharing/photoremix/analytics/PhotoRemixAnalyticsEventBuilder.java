package com.facebook.friendsharing.photoremix.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: relatedPageId */
public class PhotoRemixAnalyticsEventBuilder {
    public final AnalyticsLogger f5370a;

    public static PhotoRemixAnalyticsEventBuilder m5795a(InjectorLike injectorLike) {
        return new PhotoRemixAnalyticsEventBuilder(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PhotoRemixAnalyticsEventBuilder(AnalyticsLogger analyticsLogger) {
        this.f5370a = analyticsLogger;
    }
}
