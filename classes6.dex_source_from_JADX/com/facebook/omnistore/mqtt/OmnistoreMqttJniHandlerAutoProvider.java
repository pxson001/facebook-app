package com.facebook.omnistore.mqtt;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultSerialListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: target_frame_rate */
public class OmnistoreMqttJniHandlerAutoProvider extends AbstractProvider<OmnistoreMqttJniHandler> {
    public /* bridge */ /* synthetic */ Object get() {
        return new OmnistoreMqttJniHandler(DefaultSerialListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.b(this), ConnectionStarter.createInstance__com_facebook_omnistore_mqtt_ConnectionStarter__INJECTED_BY_TemplateInjector(this), MessagePublisher.createInstance__com_facebook_omnistore_mqtt_MessagePublisher__INJECTED_BY_TemplateInjector(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this));
    }
}
