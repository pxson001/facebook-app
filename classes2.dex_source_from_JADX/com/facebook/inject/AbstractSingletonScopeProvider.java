package com.facebook.inject;

import javax.inject.Provider;

/* compiled from: warning_screen_reenabled */
public abstract class AbstractSingletonScopeProvider<T> implements Lazy<T>, Provider<T> {
    private final InjectorLike mInjector;
    private final ScopeAwareInjector mScopeAwareInjector;

    protected abstract T onGetInstance(InjectorLike injectorLike);

    protected AbstractSingletonScopeProvider(InjectorLike injectorLike) {
        this.mInjector = injectorLike;
        this.mScopeAwareInjector = injectorLike.getScopeAwareInjector();
    }

    public final T get() {
        T onGetInstance = onGetInstance(null);
        if (onGetInstance == null) {
            InjectorLike scopeUnawareInjector = this.mInjector.getScopeUnawareInjector();
            Object a = this.mScopeAwareInjector.mo189a();
            try {
                onGetInstance = onGetInstance(scopeUnawareInjector);
            } finally {
                this.mScopeAwareInjector.mo190a(a);
            }
        }
        return onGetInstance;
    }
}
