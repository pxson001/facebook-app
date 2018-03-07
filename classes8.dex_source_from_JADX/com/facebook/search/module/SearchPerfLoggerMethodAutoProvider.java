package com.facebook.search.module;

import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbAnalyticsConfig;
import com.facebook.search.logging.perf.SearchPerfLogger;

/* compiled from: TEXT_PULL_QUOTE_ATTRIBUTION */
public class SearchPerfLoggerMethodAutoProvider extends AbstractProvider<SearchPerfLogger> {
    public static SearchPerfLogger m25835b(InjectorLike injectorLike) {
        return GraphSearchModule.m25830a(PerfTestConfig.a(injectorLike), (BaseAnalyticsConfig) FbAnalyticsConfig.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 10497), IdBasedSingletonScopeProvider.b(injectorLike, 10498));
    }

    public Object get() {
        return GraphSearchModule.m25830a(PerfTestConfig.a(this), (BaseAnalyticsConfig) FbAnalyticsConfig.a(this), IdBasedSingletonScopeProvider.b(this, 10497), IdBasedSingletonScopeProvider.b(this, 10498));
    }
}
