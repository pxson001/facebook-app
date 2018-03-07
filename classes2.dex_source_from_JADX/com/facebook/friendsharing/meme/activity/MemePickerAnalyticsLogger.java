package com.facebook.friendsharing.meme.activity;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: mobile_tracer_employees */
public class MemePickerAnalyticsLogger {
    public final AnalyticsLogger f13382a;

    public static MemePickerAnalyticsLogger m19719b(InjectorLike injectorLike) {
        return new MemePickerAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike));
    }

    @Inject
    public MemePickerAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f13382a = analyticsLogger;
    }

    public static HoneyClientEvent m19718b(String str, String str2) {
        HoneyClientEvent b = new HoneyClientEvent("meme_posted").m5090b("event", str);
        b.f3102f = str2;
        return b;
    }
}
