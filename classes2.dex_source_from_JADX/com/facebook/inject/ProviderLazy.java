package com.facebook.inject;

import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: webp */
public class ProviderLazy<T> implements Lazy<T> {
    private final byte f883a = ScopeSet.m1499a().f761a;
    @Nullable
    private Provider<T> f884b;
    @Nullable
    private volatile BasicScopeAwareInjector f885c;
    private T f886d;

    private ProviderLazy(Provider<T> provider, BasicScopeAwareInjector basicScopeAwareInjector) {
        this.f884b = provider;
        this.f885c = basicScopeAwareInjector;
    }

    public static <T> Lazy<T> m1699a(Provider<T> provider, BasicScopeAwareInjector basicScopeAwareInjector) {
        if (provider instanceof Lazy) {
            return m1698a(provider);
        }
        return new ProviderLazy(provider, basicScopeAwareInjector);
    }

    private static <T> Lazy<T> m1698a(Provider<T> provider) {
        return (Lazy) provider;
    }

    public T get() {
        if (this.f885c != null) {
            synchronized (this) {
                if (this.f885c != null) {
                    BasicScopeAwareInjector basicScopeAwareInjector = this.f885c;
                    ScopeSet a = ScopeSet.m1499a();
                    byte b = a.m1504b(this.f883a);
                    Object a2 = basicScopeAwareInjector.mo189a();
                    try {
                        this.f886d = this.f884b.get();
                        this.f884b = null;
                        this.f885c = null;
                    } finally {
                        basicScopeAwareInjector.mo190a(a2);
                        a.m1505c(b);
                    }
                }
            }
        }
        return this.f886d;
    }
}
