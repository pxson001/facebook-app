package com.facebook.omnistore.mqtt;

import com.facebook.inject.AbstractSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Provider;

/* compiled from: text_content */
public final class C0185x2cde5566 extends AbstractSingletonScopeProvider {
    C0185x2cde5566(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return OmnistoreMqttPushHandler.getInstance__com_facebook_omnistore_mqtt_OmnistoreMqttPushHandler__INJECTED_BY_TemplateInjector(injectorLike);
    }

    public static Provider<OmnistoreMqttPushHandler> getProvider(InjectorLike injectorLike) {
        return new C0185x2cde5566(injectorLike);
    }

    public static Lazy<OmnistoreMqttPushHandler> getLazy(InjectorLike injectorLike) {
        return new C0185x2cde5566(injectorLike);
    }
}
