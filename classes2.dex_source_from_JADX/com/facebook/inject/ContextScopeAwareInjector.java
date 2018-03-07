package com.facebook.inject;

import android.app.Activity;
import android.content.Context;
import com.facebook.auth.module.C0091xcd74b2f8;
import com.facebook.auth.module.C0221xc6799c06;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.util.ContextUtils;
import com.google.inject.Key;
import javax.inject.Provider;

/* compiled from: wifip2p */
public class ContextScopeAwareInjector extends DelegatingInjector implements ScopeAwareInjector {
    private final Context f740a;
    private final FbInjector f741b;

    public final /* synthetic */ Object mo189a() {
        return m1465c();
    }

    public ContextScopeAwareInjector(FbInjector fbInjector, Context context) {
        super(fbInjector);
        this.f741b = fbInjector;
        this.f740a = context;
    }

    public <T> T getInstance(Key<T> key) {
        InjectorThreadStack c = m1465c();
        try {
            T instance = this.f741b.getScopeUnawareInjector().getInstance((Key) key);
            return instance;
        } finally {
            m1460a(c);
        }
    }

    public <T> Provider<T> getProvider(Key<T> key) {
        final Provider provider = this.f741b.getScopeUnawareInjector().getProvider((Key) key);
        return new Provider<T>(this) {
            final /* synthetic */ ContextScopeAwareInjector f15285b;

            public T get() {
                InjectorThreadStack c = this.f15285b.m1465c();
                try {
                    T t = provider.get();
                    return t;
                } finally {
                    ContextScopeAwareInjector.m1460a(c);
                }
            }
        };
    }

    public <T> Lazy<T> getLazy(Key<T> key) {
        return ProviderLazy.m1699a(this.f741b.getScopeUnawareInjector().getProvider((Key) key), this);
    }

    public final Context mo191b() {
        return this.f740a;
    }

    @Deprecated
    public ScopeAwareInjector getScopeAwareInjector() {
        return this;
    }

    protected final <T> void mo160a(Class<T> cls, T t) {
        InjectorThreadStack c = m1465c();
        try {
            this.f741b.mo160a((Class) cls, (Object) t);
        } finally {
            m1460a(c);
        }
    }

    @Deprecated
    public <T> AssistedProvider<T> getOnDemandAssistedProviderForStaticDi(Class<? extends AssistedProvider<T>> cls) {
        InjectorThreadStack c = m1465c();
        try {
            AssistedProvider<T> onDemandAssistedProviderForStaticDi = this.f741b.getOnDemandAssistedProviderForStaticDi(cls);
            return onDemandAssistedProviderForStaticDi;
        } finally {
            m1460a(c);
        }
    }

    public final InjectorThreadStack m1465c() {
        InjectorThreadStack injectorThreadStack = getInjectorThreadStack();
        injectorThreadStack.m1469a(this.f740a);
        injectorThreadStack.m1470a((ScopeAwareInjector) this);
        return injectorThreadStack;
    }

    public final void mo190a(Object obj) {
        m1460a((InjectorThreadStack) obj);
    }

    public final ViewerContextManager mo192d() {
        if (((Activity) ContextUtils.m2500a(this.f740a, Activity.class)) != null) {
            return C0221xc6799c06.m6537a(this);
        }
        return C0091xcd74b2f8.m2509a(this);
    }

    public final boolean mo193e() {
        return false;
    }

    private static void m1460a(InjectorThreadStack injectorThreadStack) {
        injectorThreadStack.m1472c();
        injectorThreadStack.m1471b();
    }
}
