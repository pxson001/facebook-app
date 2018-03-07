package com.facebook.omnistore.module;

import com.facebook.inject.AbstractUserScopedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Provider;

/* compiled from: target_type */
public final class C0174xaee0e936 extends AbstractUserScopedProvider {
    C0174xaee0e936(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return OmnistoreIndexerRegistration.m4250xf8a12fa3(injectorLike);
    }

    public static Provider<OmnistoreIndexerRegistration> getProvider(InjectorLike injectorLike) {
        return new C0174xaee0e936(injectorLike);
    }
}
