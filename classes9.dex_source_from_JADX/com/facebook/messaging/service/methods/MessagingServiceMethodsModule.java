package com.facebook.messaging.service.methods;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.annotations.IsFqlWithoutActionIdEnabled;
import javax.inject.Provider;

@InjectorModule
/* compiled from: custom/ */
public class MessagingServiceMethodsModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsFqlWithoutActionIdEnabled
    public static Boolean m16985a(Provider<Boolean> provider, Boolean bool) {
        boolean z = ((Boolean) provider.get()).booleanValue() && bool.booleanValue();
        return Boolean.valueOf(z);
    }
}
