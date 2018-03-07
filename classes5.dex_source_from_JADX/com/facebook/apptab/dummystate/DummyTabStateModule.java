package com.facebook.apptab.dummystate;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.annotations.IsThreadListFragmentInApp;

@InjectorModule
/* compiled from: android_key_hash */
public class DummyTabStateModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsThreadListFragmentInApp
    public static Boolean m18432a() {
        return Boolean.valueOf(true);
    }
}
