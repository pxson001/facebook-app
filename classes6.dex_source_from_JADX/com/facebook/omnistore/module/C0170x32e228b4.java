package com.facebook.omnistore.module;

import com.facebook.inject.AbstractUserScopedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Provider;

/* compiled from: target_type */
public final class C0170x32e228b4 extends AbstractUserScopedProvider {
    C0170x32e228b4(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return OmnistoreCallbackRegistration.m4246x66f7df21(injectorLike);
    }

    public static Provider<OmnistoreCallbackRegistration> getProvider(InjectorLike injectorLike) {
        return new C0170x32e228b4(injectorLike);
    }
}
