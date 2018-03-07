package com.facebook.omnistore.mqtt;

import com.facebook.inject.AbstractSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Provider;

/* compiled from: text_content */
public final class C0184xbbb52e8c extends AbstractSingletonScopeProvider {
    C0184xbbb52e8c(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return OmnistoreMqttJniHandler.getInstance__com_facebook_omnistore_mqtt_OmnistoreMqttJniHandler__INJECTED_BY_TemplateInjector(injectorLike);
    }

    public static Provider<OmnistoreMqttJniHandler> getProvider(InjectorLike injectorLike) {
        return new C0184xbbb52e8c(injectorLike);
    }

    public static Lazy<OmnistoreMqttJniHandler> getLazy(InjectorLike injectorLike) {
        return new C0184xbbb52e8c(injectorLike);
    }
}
