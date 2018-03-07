package com.facebook.messaging.business.airline.utils;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.messaging.business.airline.enums.TapSourceType;
import javax.inject.Inject;

/* compiled from: thread_keys */
public class AirlineAnalyticsLogger {
    private final AnalyticsLogger f1537a;

    @Inject
    public AirlineAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f1537a = analyticsLogger;
    }

    public final void m1545a(String str, TapSourceType tapSourceType) {
        AnalyticsLogger analyticsLogger = this.f1537a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("did_tap_airline_cta");
        honeyClientEvent.c = "messenger_commerce";
        analyticsLogger.a(honeyClientEvent.b("id", str).b("source", tapSourceType.getValue()));
    }
}
