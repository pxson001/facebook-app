package com.facebook.analytics.logger;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.event.HoneyClientEventFast;
import java.util.Map;

/* compiled from: update_timeline_app_collection_in_newsfeed */
public interface AnalyticsLogger {
    HoneyClientEventFast mo535a(String str, boolean z);

    String mo525a();

    void mo526a(HoneyAnalyticsEvent honeyAnalyticsEvent);

    @Deprecated
    void mo527a(HoneyAnalyticsEvent honeyAnalyticsEvent, int i);

    void mo528a(HoneyClientEvent honeyClientEvent);

    void mo529a(String str);

    void mo530a(String str, Map<String, String> map);

    void mo531b(HoneyAnalyticsEvent honeyAnalyticsEvent);

    @Deprecated
    void mo532b(HoneyAnalyticsEvent honeyAnalyticsEvent, int i);

    @Deprecated
    void mo533c(HoneyAnalyticsEvent honeyAnalyticsEvent);

    void mo534d(HoneyAnalyticsEvent honeyAnalyticsEvent);
}
