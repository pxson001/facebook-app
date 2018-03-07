package com.facebook.omnistore.module;

import com.facebook.inject.AbstractSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Provider;

/* compiled from: text_content */
public final class C0172x662e8374 extends AbstractSingletonScopeProvider {
    C0172x662e8374(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return OmnistoreComponentManager.getInstance__com_facebook_omnistore_module_OmnistoreComponentManager__INJECTED_BY_TemplateInjector(injectorLike);
    }

    public static Provider<OmnistoreComponentManager> getProvider(InjectorLike injectorLike) {
        return new C0172x662e8374(injectorLike);
    }

    public static Lazy<OmnistoreComponentManager> getLazy(InjectorLike injectorLike) {
        return new C0172x662e8374(injectorLike);
    }
}
