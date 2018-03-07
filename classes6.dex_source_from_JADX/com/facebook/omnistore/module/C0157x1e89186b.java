package com.facebook.omnistore.module;

import com.facebook.inject.AbstractDefaultScopeLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;

/* compiled from: text_only_name */
public final class C0157x1e89186b extends AbstractDefaultScopeLazy {
    public C0157x1e89186b(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return Boolean_IsConnectMessageSubscriptionsGatekeeperAutoProvider.createInstance__java_lang_Boolean__com_facebook_omnistore_module_IsConnectMessageSubscriptions__INJECTED_BY_TemplateInjector(injectorLike);
    }

    public static Lazy<Boolean> getLazy(InjectorLike injectorLike) {
        return new C0157x1e89186b(injectorLike);
    }
}
