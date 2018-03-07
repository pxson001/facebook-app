package com.facebook.debug.fps;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorModule;

@InjectorModule
/* compiled from: _anySetter already set to non-null */
public class FPSModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    public static FPSControllerProvider getInstanceForTest_FPSControllerProvider(FbInjector fbInjector) {
        return (FPSControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FPSControllerProvider.class);
    }
}
