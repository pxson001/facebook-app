package com.facebook.omnistore.module;

import com.facebook.inject.AbstractDefaultScopeLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;

/* compiled from: text_only_name */
public final class C0158xee61d331 extends AbstractDefaultScopeLazy {
    public C0158xee61d331(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return Boolean_IsOmnistoreIntegrityEnabledGatekeeperAutoProvider.createInstance__java_lang_Boolean__com_facebook_omnistore_module_IsOmnistoreIntegrityEnabled__INJECTED_BY_TemplateInjector(injectorLike);
    }

    public static Lazy<Boolean> getLazy(InjectorLike injectorLike) {
        return new C0158xee61d331(injectorLike);
    }
}
