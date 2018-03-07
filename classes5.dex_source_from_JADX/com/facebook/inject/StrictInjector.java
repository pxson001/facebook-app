package com.facebook.inject;

import android.content.Context;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.collect.Sets;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import java.util.Queue;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Provider;

/* compiled from: default_option_text */
public class StrictInjector extends DelegatingInjector implements ScopeUnawareInjector {
    private final FbInjector f5164a;
    private final Class<? extends Module> f5165b;
    private final ModuleVerificationConfiguration f5166c;
    @GuardedBy("this")
    private FbInjector f5167d;
    @GuardedBy("this")
    private Set<Key<?>> f5168e;
    @GuardedBy("this")
    private Set<Key<?>> f5169f;
    @GuardedBy("this")
    private Set<Key<?>> f5170g;
    @GuardedBy("this")
    private Set<Class<? extends Annotation>> f5171h;

    /* compiled from: default_option_text */
    class StrictScopeAwareInjector extends StrictInjector implements ScopeAwareInjector {
        private ScopeAwareInjector f5172a;

        private StrictScopeAwareInjector(ScopeAwareInjector scopeAwareInjector, ModuleVerificationConfiguration moduleVerificationConfiguration, Class<? extends Module> cls, @Nullable Set<Key<?>> set, @Nullable Set<Key<?>> set2, @Nullable Set<Key<?>> set3, @Nullable Set<Class<? extends Annotation>> set4) {
            super((FbInjector) scopeAwareInjector, moduleVerificationConfiguration, cls, set, set2, set3, set4);
            this.f5172a = scopeAwareInjector;
        }

        public final Object mo622a() {
            return this.f5172a.a();
        }

        public final void m10038a(Object obj) {
            this.f5172a.a(obj);
        }

        public final Context mo623b() {
            return this.f5172a.b();
        }

        public final boolean m10041e() {
            return this.f5172a.e();
        }

        public final ViewerContextManager m10040d() {
            return this.f5172a.d();
        }
    }

    private StrictInjector(FbInjector fbInjector, ModuleVerificationConfiguration moduleVerificationConfiguration, Class<? extends Module> cls, @Nullable Set<Key<?>> set, @Nullable Set<Key<?>> set2, @Nullable Set<Key<?>> set3, @Nullable Set<Class<? extends Annotation>> set4) {
        super(fbInjector);
        this.f5164a = fbInjector;
        this.f5166c = moduleVerificationConfiguration;
        this.f5165b = cls;
        this.f5168e = set;
        this.f5169f = set2;
        this.f5170g = set3;
        this.f5171h = set4;
    }

    public StrictInjector(FbInjector fbInjector, ModuleVerificationConfiguration moduleVerificationConfiguration, Class<? extends Module> cls) {
        this(fbInjector, moduleVerificationConfiguration, cls, null, null, null, null);
    }

    private synchronized Set<Key<?>> mo622a() {
        Set<Key<?>> set;
        if (this.f5168e != null) {
            set = this.f5168e;
        } else {
            mo623b();
            set = this.f5168e;
        }
        return set;
    }

    private synchronized void mo623b() {
        Builder builder = ImmutableSet.builder();
        Builder builder2 = ImmutableSet.builder();
        Builder builder3 = ImmutableSet.builder();
        Builder builder4 = ImmutableSet.builder();
        if (this.f5165b == UnknownModule.class) {
            this.f5168e = builder.b();
            this.f5169f = builder2.b();
            this.f5170g = builder3.b();
            this.f5171h = builder4.b();
        } else {
            for (Key c : ((BinderImpl) getBinders().get(this.f5165b)).e()) {
                builder.c(c);
            }
            for (BinderImpl binderImpl : m10033c()) {
                for (Binding b : binderImpl.a()) {
                    builder.c(b.b());
                }
                for (ComponentBinding a : binderImpl.b()) {
                    builder2.c(a.m10000a());
                }
                for (Key key : binderImpl.c()) {
                    builder3.c(key);
                    builder.c(FbInjector.a(key.a().a(), key.b()));
                }
                builder4.b(binderImpl.h().keySet());
            }
            this.f5168e = builder.b();
            this.f5169f = builder2.b();
            this.f5170g = builder3.b();
            this.f5171h = builder4.b();
        }
    }

    private Set<Binder> m10033c() {
        Set<Binder> a = Sets.a();
        Queue b = Lists.b();
        BinderImpl binderImpl = (BinderImpl) getBinders().get(this.f5165b);
        if (binderImpl == null) {
            return a;
        }
        Set set;
        b.add(this.f5165b);
        if (binderImpl.h == null) {
            set = RegularImmutableSet.a;
        } else {
            set = binderImpl.h;
        }
        b.addAll(set);
        while (true) {
            Class cls = (Class) b.poll();
            if (cls != null) {
                binderImpl = (BinderImpl) getBinders().get(cls);
                if (binderImpl == null) {
                    throw new IllegalStateException("Module was not installed: " + this.f5165b);
                } else if (!a.contains(binderImpl)) {
                    a.add(binderImpl);
                }
            } else {
                a.add(getBinders().get(BundledAndroidModule.class));
                return a;
            }
        }
    }

    private boolean m10034c(Key<?> key) {
        return mo622a().contains(key);
    }

    private void m10035d(Key<?> key) {
        if (this.f5166c.a && !m10034c(key)) {
            this.f5166c.d();
            ProvisioningException provisioningException = new ProvisioningException("Module " + this.f5165b.getName() + " used undeclared binding " + key);
        }
    }

    public FbInjector getModuleInjector(Class<? extends Module> cls) {
        return this.f5164a.getModuleInjector(cls);
    }

    public <T> T getInstance(Key<T> key) {
        m10035d(key);
        return this.f5164a.getInstance(key);
    }

    public <T> Provider<T> getProvider(Key<T> key) {
        m10035d(key);
        return this.f5164a.getProvider(key);
    }

    public <T> Lazy<T> getLazy(Key<T> key) {
        m10035d(key);
        return this.f5164a.getLazy(key);
    }

    public synchronized FbInjector getApplicationInjector() {
        FbInjector fbInjector;
        if (this.f5167d != null) {
            fbInjector = this.f5167d;
        } else {
            FbInjector applicationInjector = this.f5164a.getApplicationInjector();
            if (applicationInjector == this.f5164a) {
                this.f5167d = this;
            } else {
                this.f5167d = new StrictInjector(applicationInjector, this.f5166c, this.f5165b, this.f5168e, this.f5169f, this.f5170g, this.f5171h);
            }
            fbInjector = this.f5167d;
        }
        return fbInjector;
    }

    public synchronized ScopeUnawareInjector getScopeUnawareInjector() {
        return new StrictInjector((FbInjector) this.f5164a.getScopeUnawareInjector(), this.f5166c, this.f5165b, this.f5168e, this.f5169f, this.f5170g, this.f5171h);
    }

    public synchronized ScopeAwareInjector getScopeAwareInjector() {
        return new StrictScopeAwareInjector(this.f5164a.getScopeAwareInjector(), this.f5166c, this.f5165b, this.f5168e, this.f5169f, this.f5170g, this.f5171h);
    }

    public final <T> void m10036a(Class<T> cls, T t) {
        this.f5164a.a(cls, t);
    }
}
