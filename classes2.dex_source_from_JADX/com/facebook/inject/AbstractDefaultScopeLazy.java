package com.facebook.inject;

import javax.annotation.Nullable;

/* compiled from: was expecting comma to separate  */
public abstract class AbstractDefaultScopeLazy<T> implements Lazy<T> {
    private T mCachedInstance;
    private final InjectorLike mInjector;
    @Nullable
    private volatile BasicScopeAwareInjector mScopeAwareInjector;
    private final byte mScopesSeenAtConstruction = ScopeSet.m1499a().f761a;

    protected abstract T onGetInstance(InjectorLike injectorLike);

    protected AbstractDefaultScopeLazy(InjectorLike injectorLike) {
        this.mInjector = injectorLike;
        this.mScopeAwareInjector = injectorLike.getScopeAwareInjector();
    }

    public final T get() {
        if (this.mScopeAwareInjector != null) {
            synchronized (this) {
                if (this.mScopeAwareInjector != null) {
                    BasicScopeAwareInjector basicScopeAwareInjector = this.mScopeAwareInjector;
                    ScopeSet a = ScopeSet.m1499a();
                    byte b = a.m1504b(this.mScopesSeenAtConstruction);
                    Object a2 = basicScopeAwareInjector.mo189a();
                    try {
                        this.mCachedInstance = onGetInstance(this.mInjector.getScopeUnawareInjector());
                        this.mScopeAwareInjector = null;
                    } finally {
                        basicScopeAwareInjector.mo190a(a2);
                        a.m1505c(b);
                    }
                }
            }
        }
        return this.mCachedInstance;
    }
}
