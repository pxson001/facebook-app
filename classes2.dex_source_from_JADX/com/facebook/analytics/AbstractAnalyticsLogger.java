package com.facebook.analytics;

import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.event.HoneyClientEventFastInternal;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import java.util.Random;

/* compiled from: update_timeline_app_collection_in_timeline */
public abstract class AbstractAnalyticsLogger implements AnalyticsLogger {
    private final Random f1754a;
    private final BaseAnalyticsConfig f1755b;
    private final AnalyticsStats f1756c;
    private final C01221 f1757d = new C01221(this);

    /* compiled from: update_timeline_app_collection_in_timeline */
    public class C01221 {
        final /* synthetic */ AbstractAnalyticsLogger f1844a;

        C01221(AbstractAnalyticsLogger abstractAnalyticsLogger) {
            this.f1844a = abstractAnalyticsLogger;
        }

        public final void m3687a(HoneyAnalyticsEvent honeyAnalyticsEvent) {
            this.f1844a.mo526a(honeyAnalyticsEvent);
        }
    }

    protected AbstractAnalyticsLogger(Random random, BaseAnalyticsConfig baseAnalyticsConfig, AnalyticsStats analyticsStats) {
        this.f1754a = random;
        this.f1755b = baseAnalyticsConfig;
        this.f1756c = analyticsStats;
    }

    protected final boolean m3547c(HoneyAnalyticsEvent honeyAnalyticsEvent, int i) {
        if (i == 1) {
            return true;
        }
        if (this.f1754a.nextInt() % i != 0) {
            return false;
        }
        if (honeyAnalyticsEvent instanceof HoneyClientEvent) {
            ((HoneyClientEvent) honeyAnalyticsEvent).m5083a("sampling_frequency", i);
            return true;
        } else if (!(honeyAnalyticsEvent instanceof HoneyClientEventFastInternal)) {
            return true;
        } else {
            ((HoneyClientEventFastInternal) honeyAnalyticsEvent).m5265a("sampling_frequency", i);
            return true;
        }
    }

    public final HoneyClientEventFast mo535a(String str, boolean z) {
        return new HoneyClientEventFast(str, this.f1755b.m3564a(str, z), this.f1757d);
    }

    protected final void m3546b(String str) {
        this.f1756c.m3667a(str);
    }
}
