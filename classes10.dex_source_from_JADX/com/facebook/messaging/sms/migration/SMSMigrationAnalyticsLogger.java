package com.facebook.messaging.sms.migration;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import javax.inject.Inject;

/* compiled from: pymm_long_click */
public class SMSMigrationAnalyticsLogger {
    private final AnalyticsLogger f4200a;

    @Inject
    public SMSMigrationAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f4200a = analyticsLogger;
    }

    public final void m3842a(String str) {
        this.f4200a.a(new HoneyClientEvent("migrator_nux_open").b("source", str));
    }
}
