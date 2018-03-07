package com.facebook.analytics.immediateactiveseconds;

import com.facebook.analytics.immediateactiveseconds.ImmediateActiveSecondsConfig.AuthComponent;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: system_control */
public class ImmediateActiveSecondsModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static AuthComponent m1619a(ImmediateActiveSecondsConfig immediateActiveSecondsConfig) {
        return immediateActiveSecondsConfig.e;
    }
}
