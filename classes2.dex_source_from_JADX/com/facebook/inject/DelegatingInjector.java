package com.facebook.inject;

import com.google.inject.Key;
import java.util.Map;

/* compiled from: your carrier */
public abstract class DelegatingInjector extends AbstractInjector {
    private final FbInjector f621a;

    protected abstract <T> void mo160a(Class<T> cls, T t);

    protected DelegatingInjector(FbInjector fbInjector) {
        this.f621a = fbInjector;
    }

    public final boolean mo161a(Key<?> key) {
        return this.f621a.mo161a((Key) key);
    }

    public Map<Class<? extends Module>, Binder> getBinders() {
        return this.f621a.getBinders();
    }

    public FbInjector getApplicationInjector() {
        return this.f621a.getApplicationInjector();
    }

    public ScopeUnawareInjector getScopeUnawareInjector() {
        return this.f621a.getScopeUnawareInjector();
    }

    public ScopeAwareInjector getScopeAwareInjector() {
        return this.f621a.getScopeAwareInjector();
    }

    public int getProcessIdentifier() {
        return this.f621a.getProcessIdentifier();
    }

    public InjectorThreadStack getInjectorThreadStack() {
        return this.f621a.getInjectorThreadStack();
    }

    public <T> AssistedProvider<T> getOnDemandAssistedProviderForStaticDi(Class<? extends AssistedProvider<T>> cls) {
        return this.f621a.getOnDemandAssistedProviderForStaticDi(cls);
    }
}
