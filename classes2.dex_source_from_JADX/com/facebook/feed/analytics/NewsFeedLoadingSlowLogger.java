package com.facebook.feed.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: offers_click */
public class NewsFeedLoadingSlowLogger {
    final String f11549a = "session_id";
    private final AnalyticsLogger f11550b;

    public static NewsFeedLoadingSlowLogger m16867a(InjectorLike injectorLike) {
        return new NewsFeedLoadingSlowLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike));
    }

    @Inject
    public NewsFeedLoadingSlowLogger(AnalyticsLogger analyticsLogger) {
        this.f11550b = analyticsLogger;
    }
}
