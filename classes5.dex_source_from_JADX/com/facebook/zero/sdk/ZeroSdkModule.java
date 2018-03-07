package com.facebook.zero.sdk;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: com.facebook.fbservice.service.ICompletionHandler */
public class ZeroSdkModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    public static Boolean m10623b() {
        return Boolean.valueOf(false);
    }
}
