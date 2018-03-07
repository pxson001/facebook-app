package com.facebook.omnistore.module;

import com.facebook.inject.AbstractUserScopedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;

/* compiled from: textWithEntities */
public final class C0163xa993ac53 extends AbstractUserScopedLazy {
    public C0163xa993ac53(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return OmnistoreIndexerRegistration.m4250xf8a12fa3(injectorLike);
    }

    public static Lazy<OmnistoreIndexerRegistration> getLazy(InjectorLike injectorLike) {
        return new C0163xa993ac53(injectorLike);
    }
}
