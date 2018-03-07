package com.facebook.messaging.nux;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: response_downloadurl_null */
public class MessagingNuxModule extends AbstractLibraryModule {
    @ProviderMethod
    @IsNeueNuxPending
    public static Boolean m3319a() {
        return Boolean.valueOf(false);
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }
}
