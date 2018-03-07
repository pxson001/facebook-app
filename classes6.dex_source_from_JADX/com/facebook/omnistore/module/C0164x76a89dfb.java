package com.facebook.omnistore.module;

import com.facebook.inject.AbstractUserScopedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.omnistore.Omnistore;

/* compiled from: textWithEntities */
public final class C0164x76a89dfb extends AbstractUserScopedLazy {
    public C0164x76a89dfb(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return OmnistoreMethodAutoProvider.getInstance__com_facebook_omnistore_Omnistore__INJECTED_BY_TemplateInjector(injectorLike);
    }

    public static Lazy<Omnistore> getLazy(InjectorLike injectorLike) {
        return new C0164x76a89dfb(injectorLike);
    }
}
