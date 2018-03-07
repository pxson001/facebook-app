package com.facebook.omnistore.mqtt;

import com.facebook.inject.AbstractDefaultScopeLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;

/* compiled from: text_only_name */
public final class C0180xfcb182e5 extends AbstractDefaultScopeLazy {
    public C0180xfcb182e5(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return MessagePublisher.createInstance__com_facebook_omnistore_mqtt_MessagePublisher__INJECTED_BY_TemplateInjector(injectorLike);
    }

    public static Lazy<MessagePublisher> getLazy(InjectorLike injectorLike) {
        return new C0180xfcb182e5(injectorLike);
    }
}
