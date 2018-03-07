package com.facebook.inject;

import android.annotation.SuppressLint;
import android.content.Context;
import com.facebook.inject.binder.ScopedBindingBuilderImpl;
import com.google.inject.Key;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: x-fb-sim-hni */
public class BundledAndroidModule extends AbstractLibraryModule {
    private final SingletonScope f650a;
    private final ContextScope f651b;
    private final Context f652c;
    public FbInjector f653d;

    /* compiled from: x-fb-sim-hni */
    class ContextProvider extends AbstractProvider<Context> {
        final /* synthetic */ BundledAndroidModule f678a;

        public ContextProvider(BundledAndroidModule bundledAndroidModule) {
            this.f678a = bundledAndroidModule;
        }

        public Object get() {
            Context d = this.f678a.f653d.getInjectorThreadStack().m1473d();
            if (d == null) {
                throw new RuntimeException();
            } else if (d == d.getApplicationContext() || !ScopeSet.m1499a().m1502a((byte) 1)) {
                return d;
            } else {
                throw new ProvisioningException("Should not call getContext in singleton creation. Can lead to memory leaks.");
            }
        }
    }

    @SuppressLint({"ExplicitComplexProvider"})
    /* compiled from: x-fb-sim-hni */
    class AppContextProvider extends AbstractProvider<Context> {
        final /* synthetic */ BundledAndroidModule f687a;

        public AppContextProvider(BundledAndroidModule bundledAndroidModule) {
            this.f687a = bundledAndroidModule;
        }

        public Object get() {
            Context d = this.f687a.f653d.getInjectorThreadStack().m1473d();
            if (d != null) {
                return d.getApplicationContext();
            }
            throw new RuntimeException();
        }
    }

    protected BundledAndroidModule(SingletonScope singletonScope, ContextScope contextScope, Context context) {
        this.f650a = singletonScope;
        this.f651b = contextScope;
        this.f652c = context;
    }

    public final void m1341a(FbInjector fbInjector) {
        this.f653d = fbInjector;
        fbInjector.getInjectorThreadStack().m1469a(this.f652c);
    }

    protected void configure() {
        bindScope(Singleton.class, this.f650a);
        bind(SingletonScope.class).mo199a(this.f650a);
        bindScope(ContextScoped.class, this.f651b);
        bind(ContextScope.class).mo199a(this.f651b);
        bind(Context.class).mo198a(new ContextProvider(this));
        ScopedBindingBuilderImpl bind = bind(Context.class);
        bind.f676a.f671b = Key.m1364a(bind.f676a.f671b.f664b, ForAppContext.class);
        bind.mo198a(new AppContextProvider(this));
    }
}
