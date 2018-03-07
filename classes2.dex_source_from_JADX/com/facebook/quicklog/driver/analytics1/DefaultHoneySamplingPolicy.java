package com.facebook.quicklog.driver.analytics1;

import com.facebook.analytics.samplingpolicy.AnalyticsLoggingPolicy;
import com.facebook.analytics.samplingpolicy.AnalyticsLoggingPolicy.ConfigSnapShot;
import com.facebook.analytics.samplingpolicy.AnalyticsPerfUtils;
import com.facebook.quicklog.identifiers.Utils;
import javax.inject.Inject;

/* compiled from: use_snap_shot_aware_auto_refresh */
public class DefaultHoneySamplingPolicy {
    private final AnalyticsLoggingPolicy f1497a;
    private WrapperHoneySamplingConfig f1498b = null;

    /* compiled from: use_snap_shot_aware_auto_refresh */
    public class WrapperHoneySamplingConfig {
        final /* synthetic */ DefaultHoneySamplingPolicy f2278a;
        public final ConfigSnapShot f2279b;

        public WrapperHoneySamplingConfig(DefaultHoneySamplingPolicy defaultHoneySamplingPolicy, ConfigSnapShot configSnapShot) {
            this.f2278a = defaultHoneySamplingPolicy;
            this.f2279b = configSnapShot;
        }

        public final boolean m4465a() {
            return this.f2279b.m4374a();
        }

        public final int m4464a(int i) {
            return this.f2279b.m4373a(Utils.m4445a(i), Utils.m4446b(i));
        }
    }

    @Inject
    public DefaultHoneySamplingPolicy(AnalyticsLoggingPolicy analyticsLoggingPolicy) {
        this.f1497a = analyticsLoggingPolicy;
    }

    public final int m2926a(int i) {
        return AnalyticsPerfUtils.m4441a(i, this.f1497a.f1478d);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.facebook.quicklog.driver.analytics1.DefaultHoneySamplingPolicy.WrapperHoneySamplingConfig m2927a() {
        /*
        r3 = this;
        r0 = r3.f1497a;
        r0 = r0.m2874c();
        r1 = r3.f1498b;
        if (r1 == 0) goto L_0x0014;
    L_0x000a:
        r1 = r3.f1498b;
        r2 = r1.f2279b;
        if (r2 == r0) goto L_0x0024;
    L_0x0010:
        r2 = 1;
    L_0x0011:
        r1 = r2;
        if (r1 == 0) goto L_0x001d;
    L_0x0014:
        if (r0 == 0) goto L_0x0020;
    L_0x0016:
        r1 = new com.facebook.quicklog.driver.analytics1.DefaultHoneySamplingPolicy$WrapperHoneySamplingConfig;
        r1.<init>(r3, r0);
        r3.f1498b = r1;
    L_0x001d:
        r0 = r3.f1498b;
        return r0;
    L_0x0020:
        r0 = 0;
        r3.f1498b = r0;
        goto L_0x001d;
    L_0x0024:
        r2 = 0;
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.quicklog.driver.analytics1.DefaultHoneySamplingPolicy.a():com.facebook.quicklog.driver.analytics1.DefaultHoneySamplingPolicy$WrapperHoneySamplingConfig");
    }
}
