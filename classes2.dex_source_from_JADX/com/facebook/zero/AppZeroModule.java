package com.facebook.zero;

import com.facebook.config.server.IsBootstrapEnabled;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: sequence_id */
public class AppZeroModule extends AbstractLibraryModule {
    public void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @IsBootstrapEnabled
    @ProviderMethod
    static Boolean m9501a() {
        return Boolean.valueOf(true);
    }
}
