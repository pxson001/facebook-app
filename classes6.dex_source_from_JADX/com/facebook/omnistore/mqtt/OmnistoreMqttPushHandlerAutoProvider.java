package com.facebook.omnistore.mqtt;

import com.facebook.inject.AbstractProvider;

/* compiled from: target_as_target */
public class OmnistoreMqttPushHandlerAutoProvider extends AbstractProvider<OmnistoreMqttPushHandler> {
    public /* bridge */ /* synthetic */ Object get() {
        return new OmnistoreMqttPushHandler(OmnistoreMqttJniHandler.getInstance__com_facebook_omnistore_mqtt_OmnistoreMqttJniHandler__INJECTED_BY_TemplateInjector(this));
    }
}
