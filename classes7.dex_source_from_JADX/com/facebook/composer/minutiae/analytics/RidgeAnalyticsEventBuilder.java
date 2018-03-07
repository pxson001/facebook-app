package com.facebook.composer.minutiae.analytics;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.composer.minutiae.analytics.RidgeAnalyticsLogger.RidgeView;

/* compiled from: topTouchEnd */
public class RidgeAnalyticsEventBuilder {
    public final HoneyClientEvent f1462a;

    public RidgeAnalyticsEventBuilder(String str, String str2, String str3) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str2);
        honeyClientEvent.c = str;
        this.f1462a = honeyClientEvent;
        this.f1462a.b("composer_session_id", str3);
    }

    public final RidgeAnalyticsEventBuilder m1548a(RidgeView ridgeView) {
        this.f1462a.a("ridge_session_view", ridgeView);
        return this;
    }

    public final RidgeAnalyticsEventBuilder m1549a(String str) {
        this.f1462a.b("ridge_session_id", str);
        return this;
    }

    public final void m1550a(AnalyticsLogger analyticsLogger) {
        analyticsLogger.a(this.f1462a);
    }
}
