package com.facebook.zero.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.zero.sdk.logging.ZeroLogger;
import java.util.Map;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fonts/Roboto-Thin.ttf */
public class FbZeroLogger implements ZeroLogger {
    private static final Class<?> f23502a = FbZeroLogger.class;
    private static final Pattern f23503b = Pattern.compile("^(https?)://((api|graph)\\\\.([0-9a-zA-Z\\\\.-]*)?facebook\\\\.com(:?[0-9]{0,5}))($|\\\\?.*$|/.*$)");
    private final AnalyticsLogger f23504c;

    public static FbZeroLogger m31813b(InjectorLike injectorLike) {
        return new FbZeroLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike));
    }

    @Inject
    public FbZeroLogger(AnalyticsLogger analyticsLogger) {
        this.f23504c = analyticsLogger;
    }

    private static void m31812a(HoneyClientEventFast honeyClientEventFast, @Nullable Map<String, Object> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                honeyClientEventFast.m17384a(str, map.get(str));
            }
        }
    }

    public final void mo3437a(Throwable th, @Nullable Map<String, Object> map) {
        HoneyClientEventFast a = this.f23504c.mo535a("zero_token_fetch_failed", false);
        if (a.m17388a()) {
            a.m17379a("zero_module");
            a.m17384a("exception_message", (Object) th);
            m31812a(a, (Map) map);
            a.m17390b();
        }
    }

    public final void mo3435a(String str, String str2, @Nullable Map<String, Object> map) {
        if (str.compareTo(str2) != 0 && !f23503b.matcher(str).matches()) {
            HoneyClientEventFast a = this.f23504c.mo535a("zero_url_rewrite", false);
            if (a.m17388a()) {
                a.m17385a("original_uri", str);
                a.m17385a("rewritten_uri", str2);
                m31812a(a, (Map) map);
                a.m17390b();
            }
        }
    }

    public final void mo3436a(String str, Map<String, Object> map) {
        HoneyClientEventFast a = this.f23504c.mo535a("zero_url_not_rewritten", false);
        if (a.m17388a()) {
            a.m17385a("url", str);
            m31812a(a, (Map) map);
            a.m17390b();
        }
    }

    public final void mo3438b(String str, Map<String, Object> map) {
        HoneyClientEventFast a = this.f23504c.mo535a("zero_campiagn_not_enabled", false);
        if (a.m17388a()) {
            a.m17385a("url", str);
            m31812a(a, (Map) map);
            a.m17390b();
        }
    }

    public final void mo3439c(String str, @Nullable Map<String, Object> map) {
        HoneyClientEventFast a = this.f23504c.mo535a("zero_invalid_mcc_mnc", false);
        if (a.m17388a()) {
            a.m17385a("mccmnc", str);
            m31812a(a, (Map) map);
            a.m17390b();
        }
    }
}
