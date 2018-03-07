package com.facebook.omnistore.module;

import com.facebook.inject.AbstractUserScopedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.omnistore.Omnistore;
import javax.inject.Provider;

/* compiled from: target_type */
public final class C0175xc2982af8 extends AbstractUserScopedProvider {
    C0175xc2982af8(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return OmnistoreMethodAutoProvider.getInstance__com_facebook_omnistore_Omnistore__INJECTED_BY_TemplateInjector(injectorLike);
    }

    public static Provider<Omnistore> getProvider(InjectorLike injectorLike) {
        return new C0175xc2982af8(injectorLike);
    }
}
