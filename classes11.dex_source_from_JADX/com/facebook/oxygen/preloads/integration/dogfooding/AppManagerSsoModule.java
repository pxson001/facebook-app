package com.facebook.oxygen.preloads.integration.dogfooding;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: Tried to perform a BLE scan for <0 millis */
public class AppManagerSsoModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @BroadcastLogicForDogfoodingBroadcastRegistration
    public static Boolean m11044a() {
        return Boolean.valueOf(false);
    }
}
