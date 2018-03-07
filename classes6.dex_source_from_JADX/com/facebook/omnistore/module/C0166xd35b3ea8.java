package com.facebook.omnistore.module;

import com.facebook.inject.AbstractDefaultScopeProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Provider;

/* compiled from: text_list */
public final class C0166xd35b3ea8 extends AbstractDefaultScopeProvider {
    C0166xd35b3ea8(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return Boolean_IsConnectMessageSubscriptionsGatekeeperAutoProvider.createInstance__java_lang_Boolean__com_facebook_omnistore_module_IsConnectMessageSubscriptions__INJECTED_BY_TemplateInjector(injectorLike);
    }

    public static Provider<Boolean> getProvider(InjectorLike injectorLike) {
        return new C0166xd35b3ea8(injectorLike);
    }
}
