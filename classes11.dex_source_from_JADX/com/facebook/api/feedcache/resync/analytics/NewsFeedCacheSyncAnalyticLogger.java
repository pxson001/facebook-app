package com.facebook.api.feedcache.resync.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: mediaset/{%s} */
public class NewsFeedCacheSyncAnalyticLogger {
    private final FbNetworkManager f5472a;
    public final AnalyticsLogger f5473b;

    public static NewsFeedCacheSyncAnalyticLogger m6678b(InjectorLike injectorLike) {
        return new NewsFeedCacheSyncAnalyticLogger(FbNetworkManager.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NewsFeedCacheSyncAnalyticLogger(FbNetworkManager fbNetworkManager, AnalyticsLogger analyticsLogger) {
        this.f5472a = fbNetworkManager;
        this.f5473b = analyticsLogger;
    }

    public final HoneyClientEventFast m6682b() {
        return this.f5473b.a("android_async_feed_cache_invalidation", false);
    }

    public final void m6681a(HoneyClientEventFast honeyClientEventFast, String str) {
        if (honeyClientEventFast.a()) {
            honeyClientEventFast.a("stop_reason", "false");
            honeyClientEventFast.a("error_message", str);
            m6677a(honeyClientEventFast);
        }
    }

    public final void m6683b(HoneyClientEventFast honeyClientEventFast, String str) {
        if (honeyClientEventFast.a()) {
            honeyClientEventFast.a("status", "fail");
            honeyClientEventFast.a("error_message", str);
            m6677a(honeyClientEventFast);
        }
    }

    public final void m6680a(HoneyClientEventFast honeyClientEventFast, int i, int i2, int i3, long j) {
        if (honeyClientEventFast.a()) {
            honeyClientEventFast.a("status", "success");
            honeyClientEventFast.a("tried_stories_count", i);
            honeyClientEventFast.a("deleted_stories_count", i2);
            if (i2 > 0) {
                honeyClientEventFast.a("marked_seen_stories_count", i3);
                honeyClientEventFast.a("random_story_fetched_time", j);
            }
            m6677a(honeyClientEventFast);
        }
    }

    public final void m6679a(HoneyClientEventFast honeyClientEventFast, int i, int i2, int i3, int i4) {
        if (honeyClientEventFast.a()) {
            honeyClientEventFast.a("stop_reason", "true");
            honeyClientEventFast.a("tried_stories_count", i);
            honeyClientEventFast.a("updated_stories_count", i2);
            honeyClientEventFast.a("deleted_stories_count", i3);
            honeyClientEventFast.a("marked_seen_stories_count", i4);
            m6677a(honeyClientEventFast);
        }
    }

    private void m6677a(HoneyClientEventFast honeyClientEventFast) {
        honeyClientEventFast.a("network_type", this.f5472a.k());
        honeyClientEventFast.a("network_subtype", this.f5472a.l());
        honeyClientEventFast.b();
    }
}
