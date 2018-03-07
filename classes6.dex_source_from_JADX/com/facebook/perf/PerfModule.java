package com.facebook.perf;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorModule;
import com.facebook.proguard.annotations.DoNotStrip;

@InjectorModule
/* compiled from: tags_list */
public class PerfModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @DoNotStrip
    public static MainActivityToFragmentCreatePerfLogger getInstanceForTest_MainActivityToFragmentCreatePerfLogger(FbInjector fbInjector) {
        return MainActivityToFragmentCreatePerfLogger.a(fbInjector);
    }

    @DoNotStrip
    public static InteractionTTILogger getInstanceForTest_InteractionTTILogger(FbInjector fbInjector) {
        return InteractionTTILogger.a(fbInjector);
    }
}
