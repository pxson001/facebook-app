package com.facebook.omnistore.mqtt;

import com.facebook.inject.AbstractDefaultScopeProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Provider;

/* compiled from: text_list */
public final class C0182x2eb39588 extends AbstractDefaultScopeProvider {
    C0182x2eb39588(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return MessagePublisher.createInstance__com_facebook_omnistore_mqtt_MessagePublisher__INJECTED_BY_TemplateInjector(injectorLike);
    }

    public static Provider<MessagePublisher> getProvider(InjectorLike injectorLike) {
        return new C0182x2eb39588(injectorLike);
    }
}
