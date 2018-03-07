package com.facebook.inject;

import javax.inject.Provider;

/* compiled from: warn_ack_for_ids */
public abstract class AbstractDefaultScopeProvider<T> implements Provider<T> {
    private final InjectorLike mInjector;
    private final ScopeAwareInjector mScopeAwareInjector;

    protected abstract T onGetInstance(InjectorLike injectorLike);

    protected AbstractDefaultScopeProvider(InjectorLike injectorLike) {
        this.mInjector = injectorLike;
        this.mScopeAwareInjector = injectorLike.getScopeAwareInjector();
    }

    public final T get() {
        InjectorLike scopeUnawareInjector = this.mInjector.getScopeUnawareInjector();
        Object a = this.mScopeAwareInjector.mo189a();
        try {
            T onGetInstance = onGetInstance(scopeUnawareInjector);
            return onGetInstance;
        } finally {
            this.mScopeAwareInjector.mo190a(a);
        }
    }
}
