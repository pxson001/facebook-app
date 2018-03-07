package com.facebook.components.fb.logger;

import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: gclid */
public class ComponentsLoggerModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static QPLComponentsLogger m30695a(PerfTestConfig perfTestConfig, QPLComponentsLogger qPLComponentsLogger) {
        if (!PerfTestConfigBase.m2938a() || PerfTestConfigBase.f1520o) {
            return qPLComponentsLogger;
        }
        return null;
    }
}
