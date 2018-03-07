package com.facebook.omnistore.logger;

import com.facebook.inject.AbstractDefaultScopeProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Provider;

/* compiled from: text_list */
public final class C0155xea2d881e extends AbstractDefaultScopeProvider {
    C0155xea2d881e(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return FakeOmnistoreErrorReporter.m4244x2b61d28b(injectorLike);
    }

    public static Provider<FakeOmnistoreErrorReporter> getProvider(InjectorLike injectorLike) {
        return new C0155xea2d881e(injectorLike);
    }
}
