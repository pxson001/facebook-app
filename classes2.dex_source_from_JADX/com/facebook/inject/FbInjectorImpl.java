package com.facebook.inject;

import android.content.Context;
import android.os.Looper;
import com.facebook.auth.module.C0091xcd74b2f8;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.process.PrivateProcessName;
import com.facebook.inject.ProvisioningDebugStack.StackType;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.inject.Key;
import com.google.inject.util.Providers;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: zeroGetOptinContent */
public class FbInjectorImpl extends AbstractInjector implements ScopeUnawareInjector {
    public final Context f599a;
    private final Map<Key, Binding> f600b;
    private final Map<Key, ComponentBinding> f601c;
    public final ContextScopeAwareInjector f602d;
    private final ModuleVerificationConfiguration f603e;
    private final ConcurrentMap<Class<? extends AssistedProvider<?>>, AssistedProviderProvider<?>> f604f;
    private final Map<Class<? extends Module>, Binder> f605g;
    private final List<Class<? extends LibraryModule>> f606h;
    private final boolean f607i;
    private final boolean f608j;
    private final int f609k;
    private boolean f610l;
    private final InjectorThreadStack f611m;
    private final ThreadLocal<InjectorThreadStack> f612n = new C00401(this);
    private final MyScopeAwareInjector f613o = new MyScopeAwareInjector(this, this);

    /* compiled from: zeroGetOptinContent */
    class C00401 extends ThreadLocal<InjectorThreadStack> {
        final /* synthetic */ FbInjectorImpl f618a;

        C00401(FbInjectorImpl fbInjectorImpl) {
            this.f618a = fbInjectorImpl;
        }

        protected Object initialValue() {
            return new InjectorThreadStack(this.f618a.f599a);
        }
    }

    /* compiled from: zeroGetOptinContent */
    class MyScopeAwareInjector extends DelegatingInjector implements ScopeAwareInjector {
        final /* synthetic */ FbInjectorImpl f619a;
        private final FbInjectorImpl f620b;

        public MyScopeAwareInjector(FbInjectorImpl fbInjectorImpl, FbInjectorImpl fbInjectorImpl2) {
            this.f619a = fbInjectorImpl;
            super(fbInjectorImpl2);
            this.f620b = fbInjectorImpl2;
        }

        public <T> T getInstance(Key<T> key) {
            return this.f620b.getInstance((Key) key);
        }

        public <T> Provider<T> getProvider(Key<T> key) {
            return this.f620b.getProvider((Key) key);
        }

        public <T> Lazy<T> getLazy(Key<T> key) {
            return this.f620b.getLazy((Key) key);
        }

        protected final <T> void mo160a(Class<T> cls, T t) {
            throw new IllegalStateException("injectComponent should only be called on ContextScope");
        }

        public final Object mo189a() {
            return null;
        }

        public final void mo190a(@Nullable Object obj) {
        }

        public final Context mo191b() {
            return this.f619a.f602d.mo191b();
        }

        public final ViewerContextManager mo192d() {
            return C0091xcd74b2f8.m2509a(this);
        }

        public final boolean mo193e() {
            return true;
        }
    }

    FbInjectorImpl(Context context, List<? extends Module> list, ModuleVerificationConfiguration moduleVerificationConfiguration, @Nullable PrivateProcessName privateProcessName, boolean z) {
        boolean z2 = true;
        TracerDetour.a("FbInjectorImpl.init", -1758012818);
        try {
            this.f599a = context;
            this.f603e = moduleVerificationConfiguration;
            this.f607i = BuildConstants.e();
            this.f608j = this.f603e.m1272b();
            if (privateProcessName == null) {
                this.f609k = 0;
            } else {
                String c = privateProcessName.c();
                try {
                    this.f609k = m1268c();
                } catch (Throwable e) {
                    throw new IllegalArgumentException("Failed to get injector process id for process name: " + c, e);
                }
            }
            if (context != context.getApplicationContext()) {
                z2 = false;
            }
            Preconditions.checkArgument(z2);
            FbInjectorInitializer fbInjectorInitializer = new FbInjectorInitializer(this, context, list, this.f607i, this.f603e);
            Result a = fbInjectorInitializer.m1294a();
            this.f600b = a.f737c;
            this.f601c = a.f738d;
            this.f602d = new ContextScopeAwareInjector(this, context);
            this.f611m = new InjectorThreadStack(this.f599a);
            this.f604f = Maps.m843e();
            if (z) {
                this.f605g = a.f735a;
                this.f606h = a.f739e;
            } else {
                this.f605g = ImmutableBiMap.m976a();
                this.f606h = ImmutableList.of();
            }
            this.f610l = true;
            fbInjectorInitializer.m1295b();
        } finally {
            TracerDetour.a(-1924266900);
        }
    }

    public FbInjector getModuleInjector(Class<? extends Module> cls) {
        if (this.f607i || this.f608j) {
            return new StrictInjector(this, this.f603e, cls);
        }
        return this;
    }

    public <T> T getInstance(Key<T> key) {
        return getProvider((Key) key).get();
    }

    public <T> Provider<T> getProvider(Key<T> key) {
        m1267b();
        if (this.f607i || this.f608j) {
            ProvisioningDebugStack.a(StackType.PROVIDER_GET, key);
        }
        try {
            Provider<T> c;
            Binding binding = (Binding) this.f600b.get(key);
            if (binding != null) {
                c = binding.m1389c();
            } else if (this.f608j) {
                c = Providers.a(null);
            } else {
                throw new ProvisioningException("No provider bound for " + key);
            }
            if (this.f607i || this.f608j) {
                ProvisioningDebugStack.a();
            }
            return c;
        } catch (Throwable th) {
            if (this.f607i || this.f608j) {
                ProvisioningDebugStack.a();
            }
        }
    }

    protected final <T> void mo160a(Class<T> cls, T t) {
        TracerDetour.a("FbInjectorImpl.injectComponent", 880282074);
        try {
            m1267b();
            Key a = Key.m1365a((Class) cls);
            if (this.f607i || this.f608j) {
                ProvisioningDebugStack.a(StackType.INJECT_COMPONENT, a);
            }
            try {
                if (((ComponentBinding) this.f601c.get(a)) == null) {
                    throw new ProvisioningException("No provider bound for " + a);
                }
                TracerDetour.a(11517862);
            } finally {
                if (this.f607i || this.f608j) {
                    ProvisioningDebugStack.a();
                }
            }
        } catch (Throwable th) {
            TracerDetour.a(564924794);
        }
    }

    public final boolean mo161a(Key<?> key) {
        return this.f600b.containsKey(key);
    }

    public Map<Class<? extends Module>, Binder> getBinders() {
        return this.f605g;
    }

    public InjectorThreadStack getInjectorThreadStack() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return this.f611m;
        }
        return (InjectorThreadStack) this.f612n.get();
    }

    public <T> Lazy<T> getLazy(Key<T> key) {
        return ProviderLazy.m1699a(getProvider((Key) key), getScopeAwareInjector());
    }

    @Deprecated
    public ScopeAwareInjector getScopeAwareInjector() {
        ScopeAwareInjector a = m1265a();
        return a != null ? a : this.f613o;
    }

    @Nullable
    private ScopeAwareInjector m1265a() {
        m1267b();
        return getInjectorThreadStack().m1474e();
    }

    public ScopeUnawareInjector getScopeUnawareInjector() {
        return this;
    }

    public FbInjector getApplicationInjector() {
        return this.f602d;
    }

    private void m1267b() {
        if (!this.f610l) {
            throw new RuntimeException("Called injector during binding");
        }
    }

    public int getProcessIdentifier() {
        return this.f609k;
    }

    public <T> AssistedProvider<T> getOnDemandAssistedProviderForStaticDi(Class<? extends AssistedProvider<T>> cls) {
        AssistedProviderProvider a = m1264a((Class) cls);
        BasicScopeAwareInjector scopeAwareInjector = getScopeAwareInjector();
        Object a2 = scopeAwareInjector.mo189a();
        try {
            AssistedProvider<T> a3 = a.m2224a();
            return a3;
        } finally {
            scopeAwareInjector.mo190a(a2);
        }
    }

    private <T> AssistedProviderProvider<T> m1264a(Class<? extends AssistedProvider<?>> cls) {
        AssistedProviderProvider<T> assistedProviderProvider = (AssistedProviderProvider) this.f604f.get(cls);
        if (assistedProviderProvider != null) {
            return assistedProviderProvider;
        }
        AbstractProvider assistedProviderProvider2 = new AssistedProviderProvider(cls);
        assistedProviderProvider2.mInjector = (FbInjector) getScopeUnawareInjector();
        assistedProviderProvider = (AssistedProviderProvider) this.f604f.putIfAbsent(cls, assistedProviderProvider2);
        if (assistedProviderProvider == null) {
            return assistedProviderProvider2;
        }
        return assistedProviderProvider;
    }

    private static int m1268c() {
        return 0;
    }

    public static <T> T m1266a(InjectorLike injectorLike, int i) {
        if (i < 4552) {
            return FbInjectorImplHead.m2467a(injectorLike, i);
        }
        return FbInjectorImplTail.m4968a(injectorLike, i - 4552);
    }
}
