package com.facebook.messaging.business.search.analytics;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.qe.api.QeAccessor;
import javax.inject.Inject;

/* compiled from: mm_bots_impressions */
public class BusinessSearchAnalyticsLogger {
    public final AnalyticsLogger f9433a;
    public final QeAccessor f9434b;

    @Inject
    public BusinessSearchAnalyticsLogger(AnalyticsLogger analyticsLogger, QeAccessor qeAccessor) {
        this.f9433a = analyticsLogger;
        this.f9434b = qeAccessor;
    }
}
