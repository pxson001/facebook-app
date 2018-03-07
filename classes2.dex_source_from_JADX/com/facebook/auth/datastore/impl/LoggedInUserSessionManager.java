package com.facebook.auth.datastore.impl;

import android.content.Context;
import com.facebook.auth.credentials.FacebookCredentials;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.llemployee.LowLevelEmployeeInfo;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.light.LightSharedPreferencesFactoryMethodAutoProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.user.model.User;
import com.facebook.user.model.UserBuilder;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: version/ */
public class LoggedInUserSessionManager {
    private static final Class<?> f1284a = LoggedInUserSessionManager.class;
    private static volatile LoggedInUserSessionManager f1285l;
    private final FbSharedPreferences f1286b;
    private final AuthDataStorage f1287c;
    private final AbstractFbErrorReporter f1288d;
    private final UserDataStorage f1289e;
    private final Context f1290f;
    @GuardedBy("this")
    private boolean f1291g;
    @GuardedBy("this")
    private User f1292h;
    @GuardedBy("this")
    private boolean f1293i;
    @GuardedBy("this")
    private boolean f1294j;
    @GuardedBy("this")
    private ViewerContext f1295k;

    public static com.facebook.auth.datastore.impl.LoggedInUserSessionManager m2511a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f1285l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.auth.datastore.impl.LoggedInUserSessionManager.class;
        monitor-enter(r1);
        r0 = f1285l;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m2512b(r0);	 Catch:{ all -> 0x0035 }
        f1285l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1285l;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.auth.datastore.impl.LoggedInUserSessionManager.a(com.facebook.inject.InjectorLike):com.facebook.auth.datastore.impl.LoggedInUserSessionManager");
    }

    private static LoggedInUserSessionManager m2512b(InjectorLike injectorLike) {
        return new LoggedInUserSessionManager(FbSharedPreferencesImpl.m1826a(injectorLike), AuthDataStorage.m2534a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), new UserDataStorage(LightSharedPreferencesFactoryMethodAutoProvider.m2543a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3078), IdBasedLazy.m1808a(injectorLike, 3600)), (Context) injectorLike.getInstance(Context.class, ForAppContext.class));
    }

    @Inject
    public LoggedInUserSessionManager(FbSharedPreferences fbSharedPreferences, AuthDataStorage authDataStorage, AbstractFbErrorReporter abstractFbErrorReporter, UserDataStorage userDataStorage, @ForAppContext Context context) {
        this.f1286b = fbSharedPreferences;
        this.f1287c = authDataStorage;
        this.f1288d = abstractFbErrorReporter;
        this.f1289e = userDataStorage;
        this.f1290f = context;
    }

    public final synchronized boolean m2522b() {
        boolean z;
        z = (m2514m() == null || m2517a() == null) ? false : true;
        return z;
    }

    public final synchronized boolean m2525d() {
        return this.f1291g;
    }

    public final synchronized boolean m2526e() {
        boolean z;
        ViewerContext a = m2517a();
        if (a == null) {
            z = false;
        } else {
            z = this.f1289e.m2882b(a.m1525a());
        }
        return z;
    }

    public final synchronized User m2523c() {
        User user;
        if (m2529h()) {
            user = null;
        } else {
            user = m2514m();
        }
        return user;
    }

    public final synchronized void m2524c(User user) {
        this.f1289e.m2881a(user);
        this.f1292h = user;
        m2513d(this.f1292h);
        try {
            LowLevelEmployeeInfo.a(this.f1290f, user.m5823F());
        } catch (Throwable e) {
            BLog.a(f1284a, e, "could not set employee flag", new Object[0]);
        }
    }

    public final synchronized void m2519a(User user) {
        if (this.f1292h != null) {
            UserBuilder a = new UserBuilder().m5768a(user);
            if (a.m5806u() == TriState.UNSET) {
                a.m5764a(this.f1292h.m5822E());
            }
            if (a.m5783c().isEmpty()) {
                a.m5771a(this.f1292h.m5849p());
            }
            if (a.m5788e().isEmpty()) {
                a.m5778b(this.f1292h.m5851r());
            }
            if (this.f1292h.m5823F()) {
                a.m5772a(true);
            }
            if (this.f1292h.m5824G()) {
                a.m5779b(true);
            }
            if (this.f1292h.ad()) {
                a.m5798k(true);
            }
            if (this.f1292h.ai()) {
                a.m5802n(true);
            }
            if (this.f1292h.ae()) {
                a.m5800l(true);
            }
            if (a.m5757N() == 0 || a.m5758O() == 0) {
                if (a.m5756M() == 0) {
                    a.m5762a(this.f1292h.aa(), this.f1292h.ab(), this.f1292h.ac());
                } else {
                    a.m5761a(this.f1292h.ab(), this.f1292h.ac());
                }
            }
            if (a.m5759S() == TriState.UNSET) {
                a.m5775b(this.f1292h.af());
            }
            user = a.aa();
        }
        m2524c(user);
    }

    public final synchronized void m2520a(String str) {
        this.f1289e.m2883c(str);
    }

    public final synchronized void m2527f() {
        m2528g();
        m2516o();
    }

    public final synchronized void m2528g() {
        this.f1292h = null;
    }

    private synchronized User m2514m() {
        User user = null;
        synchronized (this) {
            if (this.f1292h != null) {
                user = this.f1292h;
            } else {
                ViewerContext a = m2517a();
                if (a != null) {
                    this.f1292h = this.f1289e.m2880a(a.m1525a());
                    if (this.f1292h != null) {
                        if (a.m1525a() == null || a.m1525a().equals(this.f1292h.m5840d()) || this.f1293i) {
                            m2513d(this.f1292h);
                            user = this.f1292h;
                        } else {
                            this.f1288d.m2340a(getClass().getSimpleName(), "User ID in credential does not match me user. current user ID " + a.m1525a() + ", me user ID " + this.f1292h.m5840d());
                            m2515n();
                            this.f1293i = true;
                        }
                    }
                }
            }
        }
        return user;
    }

    public final synchronized void m2521a(String str, String str2) {
        if (!this.f1291g) {
            this.f1295k = null;
            this.f1287c.m2541a(str, str2);
        }
    }

    private synchronized void m2515n() {
        this.f1294j = true;
    }

    public final synchronized boolean m2529h() {
        return this.f1294j;
    }

    public final synchronized boolean m2530i() {
        return this.f1293i;
    }

    public final synchronized void m2518a(FacebookCredentials facebookCredentials) {
        this.f1287c.m2540a(facebookCredentials);
        this.f1295k = null;
        this.f1292h = null;
        this.f1294j = false;
    }

    public final synchronized ViewerContext m2517a() {
        ViewerContext viewerContext;
        if (this.f1294j) {
            viewerContext = null;
        } else {
            if (this.f1295k == null) {
                this.f1295k = this.f1287c.m2539a();
            }
            viewerContext = this.f1295k;
        }
        return viewerContext;
    }

    private synchronized void m2516o() {
        m2515n();
        this.f1295k = null;
        this.f1287c.m2542b();
    }

    public final synchronized void m2531j() {
        this.f1291g = true;
    }

    public final synchronized void m2532k() {
        this.f1291g = false;
    }

    public final void m2533l() {
        this.f1286b.edit().putBoolean(AuthPrefKeys.f2955j, true).commit();
    }

    private synchronized void m2513d(User user) {
        this.f1288d.mo344c(user.m5840d());
        this.f1288d.mo345c("partial_user", Boolean.toString(user.ad()));
    }
}
