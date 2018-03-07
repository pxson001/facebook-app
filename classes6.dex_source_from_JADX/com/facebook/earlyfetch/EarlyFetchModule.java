package com.facebook.earlyfetch;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorModule;
import com.facebook.proguard.annotations.DoNotStrip;

@InjectorModule
/* compiled from: nux_flow_start */
public class EarlyFetchModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @DoNotStrip
    public static EarlyFetchController getInstanceForTest_EarlyFetchController(FbInjector fbInjector) {
        return EarlyFetchController.a(fbInjector);
    }
}
