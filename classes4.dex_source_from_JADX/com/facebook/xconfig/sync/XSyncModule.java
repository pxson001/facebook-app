package com.facebook.xconfig.sync;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: rotation_vector */
public class XSyncModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @XSyncFetchPeriodMillis
    public static Long m3552a() {
        return Long.valueOf(7200000);
    }
}
