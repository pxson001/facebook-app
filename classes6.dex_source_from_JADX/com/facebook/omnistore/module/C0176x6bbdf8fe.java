package com.facebook.omnistore.module;

import com.facebook.inject.AbstractSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Provider;

/* compiled from: text_content */
public final class C0176x6bbdf8fe extends AbstractSingletonScopeProvider {
    C0176x6bbdf8fe(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return OmnistoreSingletonProvider.m4252xb8a83167(injectorLike);
    }

    public static Provider<OmnistoreSingletonProvider> getProvider(InjectorLike injectorLike) {
        return new C0176x6bbdf8fe(injectorLike);
    }

    public static Lazy<OmnistoreSingletonProvider> getLazy(InjectorLike injectorLike) {
        return new C0176x6bbdf8fe(injectorLike);
    }
}
