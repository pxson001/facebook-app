package com.facebook.sideloading;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: has_clicked_on_cohost_selector */
public class SideloadingLogger {
    private final AnalyticsLogger f10038a;

    public static SideloadingLogger m10126b(InjectorLike injectorLike) {
        return new SideloadingLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SideloadingLogger(AnalyticsLogger analyticsLogger) {
        this.f10038a = analyticsLogger;
    }

    public final void m10127a(String str) {
        m10128a(str, null);
    }

    public final void m10128a(String str, @Nullable Map<String, String> map) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "sideloading";
        HoneyClientEvent honeyClientEvent2 = honeyClientEvent;
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                honeyClientEvent2.b((String) entry.getKey(), (String) entry.getValue());
            }
        }
        this.f10038a.a(honeyClientEvent2);
    }
}
