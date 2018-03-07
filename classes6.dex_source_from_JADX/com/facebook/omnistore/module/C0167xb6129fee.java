package com.facebook.omnistore.module;

import com.facebook.inject.AbstractDefaultScopeProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Provider;

/* compiled from: text_list */
public final class C0167xb6129fee extends AbstractDefaultScopeProvider {
    C0167xb6129fee(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return Boolean_IsOmnistoreIntegrityEnabledGatekeeperAutoProvider.createInstance__java_lang_Boolean__com_facebook_omnistore_module_IsOmnistoreIntegrityEnabled__INJECTED_BY_TemplateInjector(injectorLike);
    }

    public static Provider<Boolean> getProvider(InjectorLike injectorLike) {
        return new C0167xb6129fee(injectorLike);
    }
}
