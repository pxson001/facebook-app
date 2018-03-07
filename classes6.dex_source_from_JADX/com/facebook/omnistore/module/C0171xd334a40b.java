package com.facebook.omnistore.module;

import com.facebook.inject.AbstractDefaultScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.omnistore.module.OmnistoreComponentManager.OmnistoreComponentManagerBroadcastReceiverRegistration;
import javax.inject.Provider;

/* compiled from: text_list */
public final class C0171xd334a40b extends AbstractDefaultScopeProvider {
    C0171xd334a40b(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return OmnistoreComponentManagerBroadcastReceiverRegistration.createInstance__com_facebook_omnistore_module_OmnistoreComponentManager_OmnistoreComponentManagerBroadcastReceiverRegistration__INJECTED_BY_TemplateInjector(injectorLike);
    }

    public static Provider<OmnistoreComponentManagerBroadcastReceiverRegistration> getProvider(InjectorLike injectorLike) {
        return new C0171xd334a40b(injectorLike);
    }
}
