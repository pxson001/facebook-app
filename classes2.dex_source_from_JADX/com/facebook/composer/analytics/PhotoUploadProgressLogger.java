package com.facebook.composer.analytics;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import javax.inject.Inject;

/* compiled from: position_after_gap */
public class PhotoUploadProgressLogger {
    private final AnalyticsLogger f9461a;

    @Inject
    public PhotoUploadProgressLogger(AnalyticsLogger analyticsLogger) {
        this.f9461a = analyticsLogger;
    }

    public final void m14454a(int i) {
        AnalyticsLogger analyticsLogger = this.f9461a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("fb4a_pending_stories");
        honeyClientEvent.f3099c = "photo_upload_progress";
        analyticsLogger.mo526a(honeyClientEvent.m5090b("event", "queue_size").m5083a("queue_size", i));
    }
}
