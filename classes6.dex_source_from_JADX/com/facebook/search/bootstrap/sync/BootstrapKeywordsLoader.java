package com.facebook.search.bootstrap.sync;

import android.database.sqlite.SQLiteDatabase;
import android.os.Build.VERSION;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.common.userinteraction.UserInteractionController;
import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.bootstrap.db.DbBootstrapPerformanceLogger;
import com.facebook.search.bootstrap.db.data.BootstrapDatabaseSupplier;
import com.facebook.search.bootstrap.db.data.BootstrapDbInsertHelper;
import com.facebook.search.bootstrap.db.data.BootstrapDbProperties;
import com.facebook.search.bootstrap.db.data.BootstrapDbPropertyUtil;
import com.facebook.search.bootstrap.model.BootstrapKeywords;
import com.facebook.search.bootstrap.network.BootstrapKeywordsNetworkFetcher;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.prefs.GraphSearchPrefKeys;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User;
import com.facebook.user.model.UserFbidIdentifier;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: ex_tag_screen */
public class BootstrapKeywordsLoader {
    private static volatile BootstrapKeywordsLoader f15832r;
    private final ExecutorService f15833a;
    private final ExecutorService f15834b;
    private final Provider<Boolean> f15835c;
    public final GraphSearchErrorReporter f15836d;
    private final BootstrapKeywordsNetworkFetcher f15837e;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<BootstrapDbInsertHelper> f15838f = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<BootstrapDbPropertyUtil> f15839g = UltralightRuntime.b;
    public final DbBootstrapPerformanceLogger f15840h;
    public final FbSharedPreferences f15841i;
    public final Clock f15842j;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<BootstrapDatabaseSupplier> f15843k = UltralightRuntime.b;
    public final DefaultUserInteractionController f15844l;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<QeAccessor> f15845m = UltralightRuntime.b;
    private final LoggedInUserSessionManager f15846n;
    @Inject
    private GatekeeperStoreImpl f15847o;
    public GraphSearchError f15848p;
    @GuardedBy("this")
    private ListenableFuture<BootstrapKeywords> f15849q;

    /* compiled from: ex_tag_screen */
    class C11201 implements Runnable {
        final /* synthetic */ BootstrapKeywordsLoader f15830a;

        C11201(BootstrapKeywordsLoader bootstrapKeywordsLoader) {
            this.f15830a = bootstrapKeywordsLoader;
        }

        public void run() {
            if (BootstrapKeywordsLoader.m23479i(this.f15830a)) {
                BootstrapKeywordsLoader.m23473a(this.f15830a, 0);
            }
        }
    }

    /* compiled from: ex_tag_screen */
    class C11212 implements FutureCallback<BootstrapKeywords> {
        final /* synthetic */ BootstrapKeywordsLoader f15831a;

        C11212(BootstrapKeywordsLoader bootstrapKeywordsLoader) {
            this.f15831a = bootstrapKeywordsLoader;
        }

        public void onSuccess(Object obj) {
            BootstrapKeywords bootstrapKeywords = (BootstrapKeywords) obj;
            this.f15831a.f15840h.m23359a("time_to_write_bootstrap_keywords");
            try {
                this.f15831a.f15844l.c();
                ((BootstrapDbInsertHelper) this.f15831a.f15838f.get()).m23408a(bootstrapKeywords);
                this.f15831a.f15840h.m23365b("time_to_write_bootstrap_keywords");
                Editor edit = this.f15831a.f15841i.edit();
                edit.a(GraphSearchPrefKeys.f15919d, BootstrapKeywordsLoader.m23477e(this.f15831a));
                edit.a(GraphSearchPrefKeys.f15918c, this.f15831a.f15842j.a());
                edit.commit();
                this.f15831a.f15840h.m23368c("time_to_load_bootstrap_keywords");
            } catch (Exception e) {
                this.f15831a.f15848p = GraphSearchError.INSERT_DB_BOOTSTRAP_KEYWORD_FAIL;
                this.f15831a.f15836d.a(GraphSearchError.INSERT_DB_BOOTSTRAP_KEYWORD_FAIL, e);
                this.f15831a.f15840h.m23362a(false, e, "time_to_write_bootstrap_keywords");
            } finally {
                BootstrapKeywordsLoader.m23475c(this.f15831a);
            }
        }

        public void onFailure(Throwable th) {
            this.f15831a.f15848p = GraphSearchError.FETCH_DB_BOOTSTRAP_KEYWORD_PRE_FAIL;
            this.f15831a.f15836d.a(GraphSearchError.FETCH_DB_BOOTSTRAP_KEYWORD_FAIL, th);
            BootstrapKeywordsLoader.m23475c(this.f15831a);
            this.f15831a.f15840h.m23370d("time_to_load_bootstrap_keywords");
        }
    }

    public static com.facebook.search.bootstrap.sync.BootstrapKeywordsLoader m23470a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f15832r;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.bootstrap.sync.BootstrapKeywordsLoader.class;
        monitor-enter(r1);
        r0 = f15832r;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m23474b(r0);	 Catch:{ all -> 0x0035 }
        f15832r = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15832r;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.bootstrap.sync.BootstrapKeywordsLoader.a(com.facebook.inject.InjectorLike):com.facebook.search.bootstrap.sync.BootstrapKeywordsLoader");
    }

    private static BootstrapKeywordsLoader m23474b(InjectorLike injectorLike) {
        BootstrapKeywordsLoader bootstrapKeywordsLoader = new BootstrapKeywordsLoader((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 772), IdBasedProvider.a(injectorLike, 4324), GraphSearchErrorReporter.a(injectorLike), BootstrapKeywordsNetworkFetcher.m23448b(injectorLike), DbBootstrapPerformanceLogger.m23345a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), DefaultUserInteractionController.a(injectorLike), LoggedInUserSessionManager.a(injectorLike));
        bootstrapKeywordsLoader.m23472a(IdBasedSingletonScopeProvider.b(injectorLike, 10466), IdBasedLazy.a(injectorLike, 10467), IdBasedSingletonScopeProvider.b(injectorLike, 10462), IdBasedSingletonScopeProvider.b(injectorLike, 3219), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
        return bootstrapKeywordsLoader;
    }

    @Inject
    public BootstrapKeywordsLoader(ExecutorService executorService, ExecutorService executorService2, Provider<TriState> provider, Provider<Boolean> provider2, GraphSearchErrorReporter graphSearchErrorReporter, BootstrapKeywordsNetworkFetcher bootstrapKeywordsNetworkFetcher, DbBootstrapPerformanceLogger dbBootstrapPerformanceLogger, FbSharedPreferences fbSharedPreferences, Clock clock, UserInteractionController userInteractionController, LoggedInUserSessionManager loggedInUserSessionManager) {
        this.f15833a = executorService;
        this.f15834b = executorService2;
        this.f15835c = provider2;
        this.f15836d = graphSearchErrorReporter;
        this.f15837e = bootstrapKeywordsNetworkFetcher;
        this.f15840h = dbBootstrapPerformanceLogger;
        this.f15841i = fbSharedPreferences;
        this.f15842j = clock;
        this.f15844l = userInteractionController;
        this.f15846n = loggedInUserSessionManager;
        this.f15848p = GraphSearchError.NO_ERROR;
        this.f15840h.m23361a(m23476d());
    }

    public final void m23480a() {
        if (!this.f15847o.a(SearchAbTestGatekeepers.p, false)) {
            return;
        }
        if (m23476d()) {
            long h = m23478h();
            if (this.f15842j.a() - h >= ((long) ((QeAccessor) this.f15845m.get()).a(ExperimentsForSearchAbTestModule.bp, 24)) * 3600000) {
                m23473a(this, h);
                return;
            } else {
                ExecutorDetour.a(this.f15834b, new C11201(this), 34313038);
                return;
            }
        }
        m23473a(this, 0);
    }

    public static synchronized void m23473a(BootstrapKeywordsLoader bootstrapKeywordsLoader, long j) {
        synchronized (bootstrapKeywordsLoader) {
            if (bootstrapKeywordsLoader.f15849q == null && !((Boolean) bootstrapKeywordsLoader.f15835c.get()).booleanValue()) {
                if (j == 0) {
                    try {
                        bootstrapKeywordsLoader.f15840h.m23357a(-1, "time_to_load_bootstrap_keywords");
                    } catch (Throwable e) {
                        bootstrapKeywordsLoader.f15848p = GraphSearchError.FETCH_DB_BOOTSTRAP_KEYWORD_PRE_FAIL;
                        bootstrapKeywordsLoader.f15836d.a(GraphSearchError.FETCH_DB_BOOTSTRAP_KEYWORD_PRE_FAIL, e);
                    }
                } else {
                    bootstrapKeywordsLoader.f15840h.m23357a(bootstrapKeywordsLoader.f15842j.a() - j, "time_to_load_bootstrap_keywords");
                }
                bootstrapKeywordsLoader.f15849q = bootstrapKeywordsLoader.f15837e.m23449a();
                Futures.a(bootstrapKeywordsLoader.f15849q, new C11212(bootstrapKeywordsLoader), bootstrapKeywordsLoader.f15833a);
            }
        }
    }

    private void m23472a(com.facebook.inject.Lazy<BootstrapDbInsertHelper> lazy, com.facebook.inject.Lazy<BootstrapDbPropertyUtil> lazy2, com.facebook.inject.Lazy<BootstrapDatabaseSupplier> lazy3, com.facebook.inject.Lazy<QeAccessor> lazy4, GatekeeperStore gatekeeperStore) {
        this.f15838f = lazy;
        this.f15839g = lazy2;
        this.f15843k = lazy3;
        this.f15845m = lazy4;
        this.f15847o = gatekeeperStore;
    }

    public static synchronized void m23475c(BootstrapKeywordsLoader bootstrapKeywordsLoader) {
        synchronized (bootstrapKeywordsLoader) {
            bootstrapKeywordsLoader.f15849q = null;
        }
    }

    public static String m23477e(BootstrapKeywordsLoader bootstrapKeywordsLoader) {
        User c = bootstrapKeywordsLoader.f15846n.c();
        if (c == null) {
            return null;
        }
        UserFbidIdentifier n = c.n();
        if (n != null) {
            return n.a();
        }
        return null;
    }

    private boolean m23476d() {
        String e = m23477e(this);
        Object obj = (e == null || !e.equals(this.f15841i.a(GraphSearchPrefKeys.f15919d, ""))) ? null : 1;
        return obj != null && m23478h() > 0;
    }

    private long m23478h() {
        return this.f15841i.a(GraphSearchPrefKeys.f15918c, 0);
    }

    public static boolean m23479i(BootstrapKeywordsLoader bootstrapKeywordsLoader) {
        SQLiteDatabase a = ((BootstrapDatabaseSupplier) bootstrapKeywordsLoader.f15843k.get()).a();
        SQLiteDetour.a(a, -621002477);
        try {
            int a2 = ((BootstrapDbPropertyUtil) bootstrapKeywordsLoader.f15839g.get()).a(BootstrapDbProperties.f15666a, -1);
            return (a2 == -1 || VERSION.SDK_INT < 21 || a2 == VERSION.SDK_INT) ? false : true;
        } finally {
            SQLiteDetour.b(a, 1316447839);
        }
    }
}
