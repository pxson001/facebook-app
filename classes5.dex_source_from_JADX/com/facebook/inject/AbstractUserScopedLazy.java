package com.facebook.inject;

import javax.annotation.Nullable;

/* compiled from: device_idle_power */
public abstract class AbstractUserScopedLazy<T> implements Lazy<T> {
    private T mCachedInstance;
    private final InjectorLike mInjector;
    @Nullable
    private volatile ScopeAwareInjector mScopeAwareInjector;
    private final byte mScopesSeenAtConstruction = ScopeSet.a().a;

    protected abstract T onGetInstance(InjectorLike injectorLike);

    protected AbstractUserScopedLazy(InjectorLike injectorLike) {
        this.mInjector = injectorLike;
        this.mScopeAwareInjector = injectorLike.getScopeAwareInjector();
    }

    public final T get() {
        if (this.mScopeAwareInjector != null) {
            synchronized (this) {
                if (this.mScopeAwareInjector != null) {
                    ScopeUnawareInjector scopeUnawareInjector = this.mInjector.getScopeUnawareInjector();
                    ScopeAwareInjector scopeAwareInjector = this.mScopeAwareInjector;
                    ScopeSet a = ScopeSet.a();
                    byte b = a.b(this.mScopesSeenAtConstruction);
                    Object a2 = scopeAwareInjector.a();
                    try {
                        this.mCachedInstance = onGetInstance(scopeUnawareInjector);
                        this.mScopeAwareInjector = null;
                    } finally {
                        scopeAwareInjector.a(a2);
                        a.c(b);
                    }
                }
            }
        }
        return this.mCachedInstance;
    }
}
