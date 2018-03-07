package com.facebook.photos.warning;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import javax.inject.Inject;

/* compiled from: info */
public class ObjectionableContentLoggerHelper {
    private AnalyticsLogger f20154a;

    @Inject
    public ObjectionableContentLoggerHelper(AnalyticsLogger analyticsLogger) {
        this.f20154a = analyticsLogger;
    }

    public final void m27827a(String str, String str2) {
        if (str != null) {
            HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent(str);
            honeyClientEvent.m5090b("content_id", str2);
            this.f20154a.mo526a(honeyClientEvent);
        }
    }
}
