package com.facebook.analytics;

import com.facebook.analytics.annotations.AnalyticsEventProcessorIdleTimeout;
import com.facebook.analytics.service.AnalyticsEventUploader;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: tincan_sig */
public class AnalyticsServiceModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @AnalyticsEventProcessorIdleTimeout
    @ProviderMethod
    static Long m1298a() {
        return Long.valueOf(30000);
    }

    public static AnalyticsEventUploader getInstanceForTest_AnalyticsEventUploader(FbInjector fbInjector) {
        return AnalyticsEventUploader.m1267a((InjectorLike) fbInjector);
    }
}
