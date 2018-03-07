package com.facebook.analytics;

import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.katana.orca.FbAnalyticsConfig;

/* compiled from: postCallback */
public class PrefetchAnalyticsProvider extends AbstractAssistedProvider<PrefetchAnalytics> {
    public final PrefetchAnalytics m14412a(String str, String str2) {
        return new PrefetchAnalytics(AnalyticsLoggerMethodAutoProvider.m3509a(this), FbAnalyticsConfig.m3559a(this), Handler_ForNonUiThreadMethodAutoProvider.m5523b(this), str, str2);
    }
}
