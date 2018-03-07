package com.facebook.inject;

import android.content.Context;
import com.facebook.auth.module.C0091xcd74b2f8;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.google.inject.Key;
import javax.inject.Provider;

/* compiled from: wifi_scan_result */
public class SingletonAwareInjector extends DelegatingInjector implements ScopeAwareInjector {
    public final SingletonScope f757a;
    private final FbInjector f758b;

    public SingletonAwareInjector(FbInjector fbInjector, SingletonScope singletonScope) {
        super(fbInjector);
        this.f758b = fbInjector;
        this.f757a = singletonScope;
    }

    @Deprecated
    public ScopeAwareInjector getScopeAwareInjector() {
        return this;
    }

    public <T> T getInstance(Key<T> key) {
        InjectorThreadStack enterScope = this.f757a.enterScope();
        try {
            T instance = this.f758b.getScopeUnawareInjector().getInstance((Key) key);
            return instance;
        } finally {
            SingletonScope.m1338a(enterScope);
        }
    }

    public <T> Provider<T> getProvider(Key<T> key) {
        return new 1(this, this.f758b.getScopeUnawareInjector().getProvider((Key) key));
    }

    public <T> Lazy<T> getLazy(Key<T> key) {
        return ProviderLazy.m1699a(this.f758b.getScopeUnawareInjector().getProvider((Key) key), this);
    }

    public final Object mo189a() {
        return this.f757a.enterScope();
    }

    public final void mo190a(Object obj) {
        SingletonScope.m1338a((InjectorThreadStack) obj);
    }

    public final Context mo191b() {
        return this.f757a.f648b.f643a;
    }

    protected final <T> void mo160a(Class<T> cls, T t) {
        throw new IllegalStateException("injectComponent should only be called on ContextScope");
    }

    @Deprecated
    public <T> AssistedProvider<T> getOnDemandAssistedProviderForStaticDi(Class<? extends AssistedProvider<T>> cls) {
        InjectorThreadStack enterScope = this.f757a.enterScope();
        try {
            AssistedProvider<T> onDemandAssistedProviderForStaticDi = this.f758b.getOnDemandAssistedProviderForStaticDi(cls);
            return onDemandAssistedProviderForStaticDi;
        } finally {
            SingletonScope.m1338a(enterScope);
        }
    }

    public final ViewerContextManager mo192d() {
        return C0091xcd74b2f8.m2509a(this);
    }

    public final boolean mo193e() {
        return false;
    }
}
