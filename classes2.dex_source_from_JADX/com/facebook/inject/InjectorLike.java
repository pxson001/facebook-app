package com.facebook.inject;

import java.util.Map;

/* compiled from: zero_http */
public interface InjectorLike extends Injector {
    @Deprecated
    FbInjector getApplicationInjector();

    @Deprecated
    Map<Class<? extends Module>, Binder> getBinders();

    @Deprecated
    InjectorThreadStack getInjectorThreadStack();

    @Deprecated
    FbInjector getModuleInjector(Class<? extends Module> cls);

    @Deprecated
    <T> AssistedProvider<T> getOnDemandAssistedProviderForStaticDi(Class<? extends AssistedProvider<T>> cls);

    @Deprecated
    int getProcessIdentifier();

    @Deprecated
    ScopeAwareInjector getScopeAwareInjector();

    @Deprecated
    ScopeUnawareInjector getScopeUnawareInjector();
}
