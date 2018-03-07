package com.facebook.inject;

import javax.inject.Provider;

/* compiled from: was expecting a colon to separate field name and value */
public class IdBasedSingletonScopeProvider<T> extends AbstractSingletonScopeProvider<T> {
    private final int f908a;

    private IdBasedSingletonScopeProvider(int i, InjectorLike injectorLike) {
        super(injectorLike);
        this.f908a = i;
    }

    protected T onGetInstance(InjectorLike injectorLike) {
        return FbInjectorImpl.m1266a(injectorLike, this.f908a);
    }

    public static <T> Provider<T> m1809a(InjectorLike injectorLike, int i) {
        return new IdBasedSingletonScopeProvider(i, injectorLike);
    }

    public static <T> Lazy<T> m1810b(InjectorLike injectorLike, int i) {
        return new IdBasedSingletonScopeProvider(i, injectorLike);
    }
}
