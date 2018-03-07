package com.facebook.omnistore.module;

import com.facebook.inject.AbstractDefaultScopeLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;

/* compiled from: text_only_name */
public final class C0160xf26a576f extends AbstractDefaultScopeLazy {
    public C0160xf26a576f(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return DefaultOmnistoreOpener.createInstance__com_facebook_omnistore_module_DefaultOmnistoreOpener__INJECTED_BY_TemplateInjector(injectorLike);
    }

    public static Lazy<DefaultOmnistoreOpener> getLazy(InjectorLike injectorLike) {
        return new C0160xf26a576f(injectorLike);
    }
}
