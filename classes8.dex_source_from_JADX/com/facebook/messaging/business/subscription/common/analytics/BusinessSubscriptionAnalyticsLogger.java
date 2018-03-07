package com.facebook.messaging.business.subscription.common.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: trackers_finished_duration */
public class BusinessSubscriptionAnalyticsLogger {
    public final AnalyticsLogger f1434a;

    public static BusinessSubscriptionAnalyticsLogger m1591b(InjectorLike injectorLike) {
        return new BusinessSubscriptionAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BusinessSubscriptionAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f1434a = analyticsLogger;
    }

    public final void m1592a(String str, String str2, String str3) {
        HoneyClientEventFast a = this.f1434a.a("messenger_content_subscription_banner_impression", false);
        if (a.a()) {
            a.a("source", str).a("page_id", str2).a("article_info", str3).b();
        }
    }

    public static BusinessSubscriptionAnalyticsLogger m1590a(InjectorLike injectorLike) {
        return m1591b(injectorLike);
    }
}
