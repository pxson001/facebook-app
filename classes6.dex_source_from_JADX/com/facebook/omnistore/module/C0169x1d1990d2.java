package com.facebook.omnistore.module;

import com.facebook.inject.AbstractDefaultScopeProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Provider;

/* compiled from: text_list */
public final class C0169x1d1990d2 extends AbstractDefaultScopeProvider {
    C0169x1d1990d2(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return DefaultOmnistoreOpener.createInstance__com_facebook_omnistore_module_DefaultOmnistoreOpener__INJECTED_BY_TemplateInjector(injectorLike);
    }

    public static Provider<DefaultOmnistoreOpener> getProvider(InjectorLike injectorLike) {
        return new C0169x1d1990d2(injectorLike);
    }
}
