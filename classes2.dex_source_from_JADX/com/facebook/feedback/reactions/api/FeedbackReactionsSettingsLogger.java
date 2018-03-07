package com.facebook.feedback.reactions.api;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: gsm_psc */
public class FeedbackReactionsSettingsLogger {
    private final AnalyticsLogger f21462a;
    public final Clock f21463b;
    private final Map<String, Long> f21464c = new HashMap();
    public long f21465d;
    private boolean f21466e = true;

    public static FeedbackReactionsSettingsLogger m29178b(InjectorLike injectorLike) {
        return new FeedbackReactionsSettingsLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike));
    }

    @Inject
    public FeedbackReactionsSettingsLogger(AnalyticsLogger analyticsLogger, Clock clock) {
        this.f21462a = analyticsLogger;
        this.f21463b = clock;
    }

    public final void m29181a(boolean z) {
        long a = this.f21463b.mo211a() - this.f21465d;
        synchronized (this) {
            this.f21464c.put("base_settings_fetch_complete_time", Long.valueOf(a));
        }
        if (!z) {
            this.f21466e = false;
            m29182b();
        }
    }

    public final void m29179a(int i) {
        long a = this.f21463b.mo211a() - this.f21465d;
        synchronized (this) {
            this.f21464c.put(StringFormatUtil.formatStrLocaleSafe("assets_download_start_time_key_%d", Integer.valueOf(i)), Long.valueOf(a));
        }
    }

    public final void m29180a(int i, boolean z) {
        if (!z) {
            this.f21466e = false;
        }
        long a = z ? this.f21463b.mo211a() - this.f21465d : -1;
        synchronized (this) {
            this.f21464c.put(StringFormatUtil.formatStrLocaleSafe("reaction_ready_time_key_%d", Integer.valueOf(i)), Long.valueOf(a));
        }
    }

    public final void m29182b() {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("feedback_reaction_settings_fetch");
        honeyClientEvent.m5087a("status", this.f21466e);
        synchronized (this) {
            for (String str : this.f21464c.keySet()) {
                honeyClientEvent.m5086a(str, this.f21464c.get(str));
            }
        }
        honeyClientEvent.m5084a("all_reactions_ready_time", this.f21463b.mo211a() - this.f21465d);
        this.f21462a.mo526a(honeyClientEvent);
    }
}
