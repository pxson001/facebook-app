package com.facebook.messaging.material;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.annotations.IsMessengerMaterialDesignEnabled;

@InjectorModule
/* compiled from: is_group_thread */
public class MessengerMaterialModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsMessengerMaterialDesignEnabled
    static Boolean m18983a() {
        return Boolean.valueOf(false);
    }
}
