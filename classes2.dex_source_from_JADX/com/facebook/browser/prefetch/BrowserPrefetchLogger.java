package com.facebook.browser.prefetch;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: power_localstats_logging_enabled */
public class BrowserPrefetchLogger {
    private AnalyticsLogger f9358a;

    public static BrowserPrefetchLogger m14326a(InjectorLike injectorLike) {
        return new BrowserPrefetchLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike));
    }

    @Inject
    public BrowserPrefetchLogger(AnalyticsLogger analyticsLogger) {
        this.f9358a = analyticsLogger;
    }

    public final void m14327a(String str, long j, int i, boolean z) {
        HoneyClientEventFast a = this.f9358a.mo535a("inapp_browser_prefetch_timing", false);
        if (a.m17388a()) {
            a.m17385a("url", str);
            a.m17382a("duration", j);
            a.m17381a("redirects", i);
            a.m17386a("succeed", z);
            a.m17390b();
        }
    }
}
