package com.facebook.performancelogger;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorModule;
import com.facebook.proguard.annotations.DoNotStrip;

@InjectorModule
/* compiled from: tagged_mediaset */
public class PerformanceLoggerModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @DoNotStrip
    public static PerformanceLogger getInstanceForTest_PerformanceLogger(FbInjector fbInjector) {
        return (PerformanceLogger) DelegatingPerformanceLogger.a(fbInjector);
    }
}
