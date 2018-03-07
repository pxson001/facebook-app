package com.facebook.omnistore.mqtt;

import com.facebook.inject.AbstractSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.omnistore.MqttProtocolProvider;
import javax.inject.Provider;

/* compiled from: text_content */
public final class C0183xd3ed988a extends AbstractSingletonScopeProvider {
    C0183xd3ed988a(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return MqttProtocolProviderMethodAutoProvider.getInstance__com_facebook_omnistore_MqttProtocolProvider__INJECTED_BY_TemplateInjector(injectorLike);
    }

    public static Provider<MqttProtocolProvider> getProvider(InjectorLike injectorLike) {
        return new C0183xd3ed988a(injectorLike);
    }

    public static Lazy<MqttProtocolProvider> getLazy(InjectorLike injectorLike) {
        return new C0183xd3ed988a(injectorLike);
    }
}
