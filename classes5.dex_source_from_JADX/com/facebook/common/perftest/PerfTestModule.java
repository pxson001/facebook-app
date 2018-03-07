package com.facebook.common.perftest;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorModule;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
@InjectorModule
/* compiled from: show_in_permalink */
public class PerfTestModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @DoNotStrip
    public static PerfTestConfig getInstanceForTest_PerfTestConfig(FbInjector fbInjector) {
        return PerfTestConfig.a(fbInjector);
    }
}
