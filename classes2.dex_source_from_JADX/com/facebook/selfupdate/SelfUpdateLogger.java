package com.facebook.selfupdate;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ranking_weight */
public class SelfUpdateLogger {
    private static final Class<?> f8240a = SelfUpdateLogger.class;
    private final AnalyticsLogger f8241b;
    private final AbstractFbErrorReporter f8242c;

    public static SelfUpdateLogger m12754b(InjectorLike injectorLike) {
        return new SelfUpdateLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public SelfUpdateLogger(AnalyticsLogger analyticsLogger, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f8241b = analyticsLogger;
        this.f8242c = abstractFbErrorReporter;
    }

    public final void m12755a(String str) {
        m12756a(str, null);
    }

    public final void m12756a(String str, Throwable th) {
        if (th == null) {
            BLog.b(f8240a, str);
            this.f8242c.m2340a("SelfUpdateService", str);
            return;
        }
        BLog.b(f8240a, th, str, new Object[0]);
        this.f8242c.m2343a("SelfUpdateService", str, th);
    }

    public final void m12757a(String str, @Nullable Map<String, ?> map) {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.f3099c = "self_update";
        honeyClientEvent.m5088a((Map) map);
        String.valueOf(map);
        this.f8241b.mo526a(honeyClientEvent);
    }
}
