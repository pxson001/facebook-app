package com.facebook.inject;

import javax.inject.Provider;

/* compiled from: warning_screen_dismissed */
public class IdBasedProvider<T> extends AbstractDefaultScopeProvider<T> {
    private final int f909a;

    private IdBasedProvider(int i, InjectorLike injectorLike) {
        super(injectorLike);
        this.f909a = i;
    }

    protected T onGetInstance(InjectorLike injectorLike) {
        return FbInjectorImpl.m1266a(injectorLike, this.f909a);
    }

    public static <T> Provider<T> m1811a(InjectorLike injectorLike, int i) {
        return new IdBasedProvider(i, injectorLike);
    }
}
