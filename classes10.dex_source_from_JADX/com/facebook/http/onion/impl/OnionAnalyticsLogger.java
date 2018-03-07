package com.facebook.http.onion.impl;

import android.support.v4.util.ArrayMap;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: SyncContactsPermanentRowConfDialog */
public class OnionAnalyticsLogger {
    private final AnalyticsLogger f23355a;
    public final Map<String, Object> f23356b = new ArrayMap();

    @Inject
    public OnionAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f23355a = analyticsLogger;
    }

    private void m24677a(HoneyClientEvent honeyClientEvent) {
        honeyClientEvent.a(this.f23356b);
        this.f23355a.a(honeyClientEvent);
    }

    public final void m24679a(String str, int i, String str2, int i2) {
        this.f23356b.put("httpHost", str);
        this.f23356b.put("httpPort", Integer.valueOf(i));
        this.f23356b.put("socksHost", str2);
        this.f23356b.put("socksPort", Integer.valueOf(i2));
    }

    public final void m24678a() {
        m24677a(new HoneyClientEvent("onion_orbot_available"));
    }

    public final void m24680a(boolean z) {
        m24677a(new HoneyClientEvent(z ? "onion_tor_enabled" : "onion_tor_disabled"));
    }

    public final void m24682b(boolean z) {
        m24677a(new HoneyClientEvent(z ? "onion_rewrite_enabled" : "onion_rewrite_disabled"));
    }

    public final void m24681b() {
        m24677a(new HoneyClientEvent("onion_state_change"));
    }
}
