package com.facebook.katana.server.module;

import com.facebook.auth.login.AuthServiceHandler;
import com.facebook.fbservice.handlers.BlueServiceAggregateHandler;
import com.facebook.fbservice.service.AuthQueue;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.katana.server.SimpleDataFetchQueue;
import com.facebook.katana.server.handler.FacewebComponentsStoreHandler;
import com.facebook.katana.server.handler.Fb4aAuthHandler;
import com.google.common.collect.ImmutableMap.Builder;

@InjectorModule
/* compiled from: system_supports_bluetooth_low_energy */
public class Fb4aServiceModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @ContextScoped
    @SimpleDataFetchQueue
    static BlueServiceHandler m1615a(FacewebComponentsStoreHandler facewebComponentsStoreHandler) {
        Builder builder = new Builder();
        builder.b("fetchFwComponents", facewebComponentsStoreHandler);
        return new BlueServiceAggregateHandler(builder.b());
    }

    @AuthQueue
    @ProviderMethod
    public static BlueServiceHandler m1616a(Boolean bool, Fb4aAuthHandler fb4aAuthHandler, AuthServiceHandler authServiceHandler) {
        return bool.booleanValue() ? authServiceHandler : fb4aAuthHandler;
    }
}
