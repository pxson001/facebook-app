package com.facebook.omnistore.module;

import com.facebook.inject.AbstractSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Provider;

/* compiled from: text_content */
public final class C0173xe7396780 extends AbstractSingletonScopeProvider {
    C0173xe7396780(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return OmnistoreExtraFileProvider.m4248x4992ee48(injectorLike);
    }

    public static Provider<OmnistoreExtraFileProvider> getProvider(InjectorLike injectorLike) {
        return new C0173xe7396780(injectorLike);
    }

    public static Lazy<OmnistoreExtraFileProvider> getLazy(InjectorLike injectorLike) {
        return new C0173xe7396780(injectorLike);
    }
}
