package com.facebook.feed.analytics;

import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.feed.rows.core.analytics.MultiRowPerfLogger;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Provider;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: period_end */
public class FeedAnalyticsModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static MultiRowPerfLogger m15289a(Provider<MultiRowPerfLoggerImpl> provider, Provider<MultiRowPerfLoggerForTesting> provider2, PerfTestConfig perfTestConfig) {
        return PerfTestConfigBase.m2938a() ? (MultiRowPerfLogger) provider2.get() : (MultiRowPerfLogger) provider.get();
    }
}
