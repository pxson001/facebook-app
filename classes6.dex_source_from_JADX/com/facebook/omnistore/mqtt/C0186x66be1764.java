package com.facebook.omnistore.mqtt;

import com.facebook.inject.AbstractSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Provider;

/* compiled from: text_content */
public final class C0186x66be1764 extends AbstractSingletonScopeProvider {
    C0186x66be1764(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return OmnistoreMqttTopicsSetProvider.getInstance__com_facebook_omnistore_mqtt_OmnistoreMqttTopicsSetProvider__INJECTED_BY_TemplateInjector(injectorLike);
    }

    public static Provider<OmnistoreMqttTopicsSetProvider> getProvider(InjectorLike injectorLike) {
        return new C0186x66be1764(injectorLike);
    }

    public static Lazy<OmnistoreMqttTopicsSetProvider> getLazy(InjectorLike injectorLike) {
        return new C0186x66be1764(injectorLike);
    }
}
