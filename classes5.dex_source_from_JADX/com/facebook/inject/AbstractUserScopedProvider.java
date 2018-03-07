package com.facebook.inject;

import javax.inject.Provider;

/* compiled from: device_bluetooth_power */
public abstract class AbstractUserScopedProvider<T> implements Provider<T> {
    private final InjectorLike mInjector;
    private final ScopeAwareInjector mScopeAwareInjector;

    protected abstract T onGetInstance(InjectorLike injectorLike);

    protected AbstractUserScopedProvider(InjectorLike injectorLike) {
        this.mInjector = injectorLike;
        this.mScopeAwareInjector = injectorLike.getScopeAwareInjector();
    }

    public final T get() {
        ScopeUnawareInjector scopeUnawareInjector = this.mInjector.getScopeUnawareInjector();
        Object a = this.mScopeAwareInjector.a();
        try {
            T onGetInstance = onGetInstance(scopeUnawareInjector);
            return onGetInstance;
        } finally {
            this.mScopeAwareInjector.a(a);
        }
    }
}
