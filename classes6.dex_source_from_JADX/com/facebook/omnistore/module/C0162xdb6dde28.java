package com.facebook.omnistore.module;

import com.facebook.inject.AbstractDefaultScopeLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.omnistore.module.OmnistoreComponentManager.OmnistoreComponentManagerBroadcastReceiverRegistration;

/* compiled from: text_only_name */
public final class C0162xdb6dde28 extends AbstractDefaultScopeLazy {
    public C0162xdb6dde28(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return OmnistoreComponentManagerBroadcastReceiverRegistration.createInstance__com_facebook_omnistore_module_OmnistoreComponentManager_OmnistoreComponentManagerBroadcastReceiverRegistration__INJECTED_BY_TemplateInjector(injectorLike);
    }

    public static Lazy<OmnistoreComponentManagerBroadcastReceiverRegistration> getLazy(InjectorLike injectorLike) {
        return new C0162xdb6dde28(injectorLike);
    }
}
