package com.facebook.omnistore.mqtt;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.omnistore.MqttProtocolProvider;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: mKey */
public class OmnistoreMqttModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    public static MqttProtocolProvider provideMqttProtocolProvider(OmnistoreMqttJniHandler omnistoreMqttJniHandler) {
        return omnistoreMqttJniHandler.getJavaMqtt();
    }
}
