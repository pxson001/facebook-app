package com.facebook.common.json;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.smile.SmileFactory;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: social_wifi_ego_imp */
public class FbJsonModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static SmileFactory m8064a(ObjectMapper objectMapper) {
        return new SmileFactory(objectMapper);
    }

    @ProviderMethod
    @Singleton
    static JsonFactory m8063a() {
        return FbObjectMapper.m6612i().mo910b();
    }
}
