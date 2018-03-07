package com.facebook.omnistore.mqtt;

import com.facebook.inject.AbstractDefaultScopeLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;

/* compiled from: text_only_name */
public final class C0179xed7aae29 extends AbstractDefaultScopeLazy {
    public C0179xed7aae29(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return ConnectionStarter.createInstance__com_facebook_omnistore_mqtt_ConnectionStarter__INJECTED_BY_TemplateInjector(injectorLike);
    }

    public static Lazy<ConnectionStarter> getLazy(InjectorLike injectorLike) {
        return new C0179xed7aae29(injectorLike);
    }
}
