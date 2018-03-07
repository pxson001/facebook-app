package com.facebook.googleplay;

import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.google.common.collect.ImmutableMap;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: after_video_list_page */
public class GrowthReferrerDataProcessor implements GooglePlayReferrerDataProcessor {
    private final AnalyticsLogger f10074a;

    @Inject
    public GrowthReferrerDataProcessor(AnalyticsLogger analyticsLogger) {
        this.f10074a = analyticsLogger;
    }

    public final void mo256a(ImmutableMap<String, String> immutableMap) {
        HoneyClientEventFast a = this.f10074a.a("google_play_referrer", true);
        if (a.a()) {
            a.a("growth");
            Iterator it = immutableMap.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                a.a((String) entry.getKey(), (String) entry.getValue());
            }
            a.b();
        }
    }
}
