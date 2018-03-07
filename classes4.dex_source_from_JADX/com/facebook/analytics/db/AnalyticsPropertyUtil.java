package com.facebook.analytics.db;

import com.facebook.database.properties.DbPropertyUtil;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: titleMaxLines and subtitleMaxLines must be non-negative */
public class AnalyticsPropertyUtil extends DbPropertyUtil<AnalyticsDbPropertyKey> {
    public static AnalyticsPropertyUtil m1290b(InjectorLike injectorLike) {
        return new AnalyticsPropertyUtil(AnalyticsDatabaseSupplier.m1291a(injectorLike));
    }

    @Inject
    public AnalyticsPropertyUtil(AnalyticsDatabaseSupplier analyticsDatabaseSupplier) {
        super(analyticsDatabaseSupplier, "analytics_db_properties");
    }

    public static AnalyticsPropertyUtil m1289a(InjectorLike injectorLike) {
        return m1290b(injectorLike);
    }
}
