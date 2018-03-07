package com.facebook.auth.userscope;

import android.content.Context;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.AssistedProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.DelegatingInjector;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import com.facebook.inject.Scope;
import com.facebook.inject.ScopeAwareInjector;
import com.facebook.inject.ScopeWithInit;
import com.google.common.collect.Maps;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Provider;

@ThreadSafe
/* compiled from: window_end */
public class UserScope implements Scope, ScopeWithInit {
    public static final Object f724a = new Object();
    private static final Class<?> f725b = UserScope.class;
    public static final Object f726c = new Object();
    private final Object f727d = new Object();
    @GuardedBy("mLock")
    private final Map<String, ConcurrentMap<Object, Object>> f728e = Maps.m838c();
    @GuardedBy("mLock")
    private final Map<String, ConcurrentMap<Object, Object>> f729f = Maps.m838c();
    public FbInjector f730g;
    public ContextScope f731h;
    private Clock f732i;
    private EmptyViewerContextManager f733j;
    @GuardedBy("mLock")
    private long f734k = -1;

    /* compiled from: window_end */
    public class UserScopeAwareInjector extends DelegatingInjector implements ScopeAwareInjector {
        final /* synthetic */ UserScope f5034a;
        private final FbInjector f5035b;
        private final ViewerContext f5036c;
        private final Context f5037d;

        public UserScopeAwareInjector(UserScope userScope, ViewerContext viewerContext) {
            this.f5034a = userScope;
            super(userScope.f730g);
            this.f5035b = userScope.f730g;
            this.f5036c = viewerContext;
            this.f5037d = userScope.f731h.f643a;
        }

        public <T> T getInstance(Key<T> key) {
            InjectorThreadStack a = UserScope.m1451a(this.f5034a, this);
            try {
                T instance = this.f5035b.getScopeUnawareInjector().getInstance((Key) key);
                return instance;
            } finally {
                UserScope.m1452a(a);
            }
        }

        public <T> Provider<T> getProvider(Key<T> key) {
            return new 1(this, this.f5035b.getScopeUnawareInjector().getProvider((Key) key));
        }

        public final Context mo191b() {
            return this.f5037d;
        }

        public <T> Lazy<T> getLazy(Key<T> key) {
            return ProviderLazy.m1699a(this.f5035b.getScopeUnawareInjector().getProvider((Key) key), this);
        }

        @Deprecated
        public ScopeAwareInjector getScopeAwareInjector() {
            return this;
        }

        protected final <T> void mo160a(Class<T> cls, T t) {
            throw new IllegalStateException("injectComponent should only be called on ContextScope");
        }

        @Deprecated
        public <T> AssistedProvider<T> getOnDemandAssistedProviderForStaticDi(Class<? extends AssistedProvider<T>> cls) {
            InjectorThreadStack a = UserScope.m1451a(this.f5034a, this);
            try {
                AssistedProvider<T> onDemandAssistedProviderForStaticDi = this.f5035b.getOnDemandAssistedProviderForStaticDi(cls);
                return onDemandAssistedProviderForStaticDi;
            } finally {
                UserScope.m1452a(a);
            }
        }

        public final Object mo189a() {
            return UserScope.m1451a(this.f5034a, this);
        }

        public final void mo190a(Object obj) {
            UserScope.m1452a((InjectorThreadStack) obj);
        }

        public final ViewerContextManager mo192d() {
            return new ViewerContextManagerForUserScope(LoggedInUserSessionManager.m2511a((InjectorLike) this), this.f5036c);
        }

        public final boolean mo193e() {
            return false;
        }
    }

    public final InjectorThreadStack m1455a(UserScopeInfo userScopeInfo) {
        ConcurrentMap concurrentMap = userScopeInfo.f5033c;
        UserScopeAwareInjector userScopeAwareInjector = (UserScopeAwareInjector) concurrentMap.get(f726c);
        if (userScopeAwareInjector == null) {
            UserScopeAwareInjector userScopeAwareInjector2 = new UserScopeAwareInjector(this, userScopeInfo.f5032b.mo217d());
            userScopeAwareInjector = (UserScopeAwareInjector) concurrentMap.putIfAbsent(f726c, userScopeAwareInjector2);
            if (userScopeAwareInjector == null) {
                userScopeAwareInjector = userScopeAwareInjector2;
            }
        }
        return m1451a(this, userScopeAwareInjector);
    }

    public final <T> Provider<T> mo194a(Provider<T> provider) {
        return new UserScopedProvider(this, provider);
    }

    public Class<? extends Annotation> annotationType() {
        return UserScoped.class;
    }

    public final void mo195a(FbInjector fbInjector) {
        this.f730g = fbInjector;
        this.f731h = (ContextScope) fbInjector.getInstance(ContextScope.class);
        this.f732i = SystemClockMethodAutoProvider.m1498a(fbInjector);
        this.f733j = new EmptyViewerContextManager();
    }

    public final void m1457a() {
        synchronized (this.f727d) {
            for (Map values : this.f728e.values()) {
                for (Object next : values.values()) {
                    if (next instanceof IHaveUserData) {
                        ((IHaveUserData) next).clearUserData();
                    }
                }
            }
            this.f729f.putAll(this.f728e);
            this.f734k = this.f732i.mo211a();
            this.f728e.clear();
        }
    }

    public Context getContext() {
        return this.f730g.getInjectorThreadStack().m1473d();
    }

    public final UserScopeInfo m1454a(Context context) {
        ViewerContextManager b;
        ConcurrentMap concurrentMap;
        m1453b();
        ScopeAwareInjector scopeAwareInjector = this.f730g.getScopeAwareInjector();
        if (scopeAwareInjector.mo193e()) {
            b = ViewerContextManagerProvider.m2496b(FbInjector.get(context));
        } else {
            b = scopeAwareInjector.mo192d();
        }
        ViewerContext d = b.mo217d();
        if (d == null) {
            d = b.mo216c();
            synchronized (this.f727d) {
                String a;
                if (d == null) {
                    BLog.a(f725b, "Called user scoped provider with no viewer. ViewerContextManager was created with no ViewerContext. Using EmptyViewerContextManager to return fake logged in instance.");
                    a = this.f733j.mo217d().m1525a();
                    concurrentMap = (ConcurrentMap) this.f728e.get(a);
                    if (concurrentMap == null) {
                        concurrentMap = Maps.m843e();
                        this.f728e.put(a, concurrentMap);
                    }
                    b = this.f733j;
                } else {
                    String a2 = d.m1525a();
                    if (this.f729f.containsKey(a2)) {
                        concurrentMap = (ConcurrentMap) this.f729f.get(a2);
                    } else if (this.f728e.containsKey(a2)) {
                        concurrentMap = (ConcurrentMap) this.f728e.get(a2);
                    } else {
                        BLog.a(f725b, "Called user scoped provider with no viewer. ViewerContextManager was created with no ViewerContext. Using EmptyViewerContextManager to return fake logged in instance.");
                        a = this.f733j.mo217d().m1525a();
                        concurrentMap = (ConcurrentMap) this.f728e.get(a);
                        if (concurrentMap == null) {
                            concurrentMap = Maps.m843e();
                            this.f728e.put(a, concurrentMap);
                        }
                        b = this.f733j;
                    }
                }
            }
        } else {
            String a3 = d.m1525a();
            synchronized (this.f727d) {
                concurrentMap = (ConcurrentMap) this.f728e.get(a3);
                if (concurrentMap == null) {
                    concurrentMap = Maps.m843e();
                    this.f728e.put(a3, concurrentMap);
                }
            }
        }
        return UserScopeInfo.m8950a(b, concurrentMap);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1453b() {
        /*
        r8 = this;
        r4 = -1;
        r1 = r8.f727d;
        monitor-enter(r1);
        r2 = r8.f734k;	 Catch:{ all -> 0x0027 }
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = r8.f732i;	 Catch:{ all -> 0x0027 }
        r2 = r0.mo211a();	 Catch:{ all -> 0x0027 }
        r4 = r8.f734k;	 Catch:{ all -> 0x0027 }
        r6 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r4 = r4 + r6;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x0025;
    L_0x001c:
        r0 = r8.f729f;	 Catch:{ all -> 0x0027 }
        r0.clear();	 Catch:{ all -> 0x0027 }
        r2 = -1;
        r8.f734k = r2;	 Catch:{ all -> 0x0027 }
    L_0x0025:
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        goto L_0x000c;
    L_0x0027:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.auth.userscope.UserScope.b():void");
    }

    public static InjectorThreadStack m1451a(UserScope userScope, UserScopeAwareInjector userScopeAwareInjector) {
        InjectorThreadStack injectorThreadStack = userScope.f730g.getInjectorThreadStack();
        injectorThreadStack.m1468a();
        injectorThreadStack.m1470a((ScopeAwareInjector) userScopeAwareInjector);
        return injectorThreadStack;
    }

    public static void m1452a(InjectorThreadStack injectorThreadStack) {
        injectorThreadStack.m1472c();
        injectorThreadStack.m1471b();
    }
}
