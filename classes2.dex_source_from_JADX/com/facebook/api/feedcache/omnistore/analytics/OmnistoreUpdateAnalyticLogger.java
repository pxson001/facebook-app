package com.facebook.api.feedcache.omnistore.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import java.util.Random;
import javax.inject.Inject;

/* compiled from: session_ended */
public class OmnistoreUpdateAnalyticLogger {
    public final AnalyticsLogger f5471a;
    public final Random f5472b;

    public static OmnistoreUpdateAnalyticLogger m9361b(InjectorLike injectorLike) {
        return new OmnistoreUpdateAnalyticLogger(Random_InsecureRandomMethodAutoProvider.m2102a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike));
    }

    @Inject
    public OmnistoreUpdateAnalyticLogger(Random random, AnalyticsLogger analyticsLogger) {
        this.f5471a = analyticsLogger;
        this.f5472b = random;
    }

    public final void m9364c(int i, int i2, int i3, int i4) {
        HoneyClientEventFast a = this.f5471a.mo535a("feed_omnistore_sync", false);
        if (a.m17388a()) {
            a.m17381a("home_stories_entry", i);
            a.m17381a("omnistore_entry", i2);
            a.m17381a("added_entry", i3);
            a.m17381a("deleted_entry", i4);
            a.m17390b();
        }
    }

    public final void m9363a(String str, String str2, String str3, int i, int i2, int i3) {
        if (this.f5472b.nextInt(50) == 0) {
            HoneyClientEventFast a = this.f5471a.mo535a("feed_omnistore_save_mod_50", false);
            if (a.m17388a()) {
                a.m17385a("dedup_key", str);
                a.m17385a("sort_key", str2);
                a.m17385a("graphql_id", str3);
                a.m17381a("valid", i);
                a.m17381a("old_like_count", i2);
                a.m17381a("old_comment_count", i3);
                a.m17390b();
            }
        }
    }

    public final void m9362a(String str, String str2, String str3) {
        HoneyClientEventFast a = this.f5471a.mo535a("feed_omnistore_invalidation", false);
        if (a.m17388a()) {
            a.m17385a("status", "failure");
            a.m17385a("dedup_key", str);
            a.m17385a("graphql_id", str2);
            a.m17385a("reason", str3);
            a.m17390b();
        }
    }
}
