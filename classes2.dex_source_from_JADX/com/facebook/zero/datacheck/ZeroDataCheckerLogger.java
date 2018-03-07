package com.facebook.zero.datacheck;

import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.zero.common.constants.FbZeroTokenType;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: simple_story */
public class ZeroDataCheckerLogger {
    private static final Class<?> f4731a = ZeroDataCheckerLogger.class;
    private final String f4732b = "zero_data_state_change_event";
    private Provider<FbZeroTokenType> f4733c;
    private FbSharedPreferences f4734d;
    private AnalyticsLogger f4735e;

    @Inject
    public ZeroDataCheckerLogger(AnalyticsLogger analyticsLogger, Provider<FbZeroTokenType> provider, FbSharedPreferences fbSharedPreferences) {
        this.f4735e = analyticsLogger;
        this.f4733c = provider;
        this.f4734d = fbSharedPreferences;
    }

    public final void m8539a(String str, long j, long j2, long j3, long j4) {
        HoneyClientEventFast a = this.f4735e.mo535a(str, false);
        if (a.m17388a()) {
            a.m17382a("free_failure_pings", j);
            a.m17382a("free_success_pings", j2);
            a.m17382a("standard_failure_pings", j3);
            a.m17382a("standard_success_pings", j4);
            a.m17390b();
        }
    }

    public final void m8538a(DataState dataState, DataState dataState2, int i, String str, long j, long j2, long j3) {
        f4731a.getSimpleName();
        Integer.valueOf(i);
        FbZeroTokenType fbZeroTokenType = (FbZeroTokenType) this.f4733c.get();
        HoneyClientEventFast a = this.f4735e.mo535a("zero_data_state_change_event", false);
        if (a.m17388a()) {
            a.m17385a("Old State", dataState.name());
            a.m17385a("New State", dataState2.name());
            a.m17381a("Most recent status code", i);
            a.m17385a("uri", str);
            a.m17382a("Consecutive failed standard requests", j);
            a.m17382a("Consecutive failed bootstrap requests", j2);
            a.m17382a("Last state change time", j3);
            a.m17385a(fbZeroTokenType.getRegistrationStatusKey().m2012a(), this.f4734d.mo278a(fbZeroTokenType.getRegistrationStatusKey(), "unknown"));
            a.m17390b();
        }
    }
}
