package com.facebook.composer.minutiae;

import com.facebook.composer.minutiae.config.MinutiaeXConfig;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: sticker_store */
public class MinutiaeModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    public static MinutiaeXConfig m1929a() {
        return new MinutiaeXConfig();
    }
}
