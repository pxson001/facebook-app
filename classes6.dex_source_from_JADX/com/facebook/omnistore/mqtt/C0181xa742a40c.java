package com.facebook.omnistore.mqtt;

import com.facebook.inject.AbstractDefaultScopeProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Provider;

/* compiled from: text_list */
public final class C0181xa742a40c extends AbstractDefaultScopeProvider {
    C0181xa742a40c(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return ConnectionStarter.createInstance__com_facebook_omnistore_mqtt_ConnectionStarter__INJECTED_BY_TemplateInjector(injectorLike);
    }

    public static Provider<ConnectionStarter> getProvider(InjectorLike injectorLike) {
        return new C0181xa742a40c(injectorLike);
    }
}
