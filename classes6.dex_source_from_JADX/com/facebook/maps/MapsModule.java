package com.facebook.maps;

import com.facebook.config.application.FbAppType;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.maps.annotation.MapApiKeyString;

@InjectorModule
/* compiled from: waterfall_id */
public class MapsModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @MapApiKeyString
    public static String m280a(FbAppType fbAppType) {
        return fbAppType.f;
    }
}
