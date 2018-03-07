package com.facebook.messaging.business.common.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: new_user */
public class BusinessAnalyticsLogger {
    public final AnalyticsLogger f8693a;

    public static BusinessAnalyticsLogger m8898b(InjectorLike injectorLike) {
        return new BusinessAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BusinessAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f8693a = analyticsLogger;
    }

    public static HoneyClientEvent m8899c(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "messenger_commerce";
        return honeyClientEvent;
    }
}
