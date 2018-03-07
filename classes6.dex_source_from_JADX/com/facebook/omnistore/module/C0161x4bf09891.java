package com.facebook.omnistore.module;

import com.facebook.inject.AbstractUserScopedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;

/* compiled from: textWithEntities */
public final class C0161x4bf09891 extends AbstractUserScopedLazy {
    public C0161x4bf09891(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return OmnistoreCallbackRegistration.m4246x66f7df21(injectorLike);
    }

    public static Lazy<OmnistoreCallbackRegistration> getLazy(InjectorLike injectorLike) {
        return new C0161x4bf09891(injectorLike);
    }
}
