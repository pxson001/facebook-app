package com.facebook.search.bootstrap.sync;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build.VERSION;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.common.userinteraction.UserInteractionController;
import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.qe.api.QeAccessor;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.bootstrap.db.DbBootstrapPerformanceLogger;
import com.facebook.search.bootstrap.db.data.BootstrapDatabaseSupplier;
import com.facebook.search.bootstrap.db.data.BootstrapDbInsertHelper;
import com.facebook.search.bootstrap.db.data.BootstrapDbProperties;
import com.facebook.search.bootstrap.db.data.BootstrapDbPropertyUtil;
import com.facebook.search.bootstrap.model.BootstrapEntities;
import com.facebook.search.bootstrap.network.BootstrapEntitiesNetworkFetcher;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.prefs.GraphSearchPrefKeys;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: ex_tag_text_length */
public class BootstrapEntitiesLoader {
    private static volatile BootstrapEntitiesLoader f15812r;
    private final ExecutorService f15813a;
    private final ExecutorService f15814b;
    private final Provider<TriState> f15815c;
    private final Provider<Boolean> f15816d;
    public final GraphSearchErrorReporter f15817e;
    private final BootstrapEntitiesNetworkFetcher f15818f;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<BootstrapDbInsertHelper> f15819g = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<BootstrapDbPropertyUtil> f15820h = UltralightRuntime.b;
    public final DbBootstrapPerformanceLogger f15821i;
    public final FbSharedPreferences f15822j;
    private final Clock f15823k;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<BootstrapDatabaseSupplier> f15824l = UltralightRuntime.b;
    public final DefaultUserInteractionController f15825m;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<QeAccessor> f15826n = UltralightRuntime.b;
    private final LoggedInUserSessionManager f15827o;
    public GraphSearchError f15828p;
    @GuardedBy("this")
    private ListenableFuture<BootstrapEntities> f15829q;

    /* compiled from: ex_tag_text_length */
    class C11171 implements Runnable {
        final /* synthetic */ BootstrapEntitiesLoader f15806a;

        C11171(BootstrapEntitiesLoader bootstrapEntitiesLoader) {
            this.f15806a = bootstrapEntitiesLoader;
        }

        public void run() {
            if (BootstrapEntitiesLoader.m23457g(this.f15806a)) {
                BootstrapEntitiesLoader.m23453a(this.f15806a, 0);
            }
        }
    }

    /* compiled from: ex_tag_text_length */
    class C11193 implements FutureCallback<BootstrapEntities> {
        final /* synthetic */ BootstrapEntitiesLoader f15811a;

        C11193(BootstrapEntitiesLoader bootstrapEntitiesLoader) {
            this.f15811a = bootstrapEntitiesLoader;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onSuccess(java.lang.Object r7) {
            /*
            r6 = this;
            r7 = (com.facebook.search.bootstrap.model.BootstrapEntities) r7;
            r0 = r6.f15811a;
            r0 = r0.f15821i;
            r1 = "time_to_write_bootstrap_entities";
            r0.m23359a(r1);
            r0 = r6.f15811a;	 Catch:{ Exception -> 0x0082 }
            r1 = 0;
            com.facebook.search.bootstrap.sync.BootstrapEntitiesLoader.m23452a(r0, r1);	 Catch:{ Exception -> 0x0082 }
            r0 = r6.f15811a;	 Catch:{ Exception -> 0x0082 }
            r1 = " ";
            r2 = 0;
            com.facebook.search.bootstrap.sync.BootstrapEntitiesLoader.m23454a(r0, r1, r2);	 Catch:{ Exception -> 0x0082 }
            r0 = r6.f15811a;	 Catch:{ Exception -> 0x0082 }
            r0 = r0.f15825m;	 Catch:{ Exception -> 0x0082 }
            r0.c();	 Catch:{ Exception -> 0x0082 }
            r0 = r7.m23435b();	 Catch:{ Exception -> 0x0082 }
            if (r0 == 0) goto L_0x0074;
        L_0x0026:
            r0 = r6.f15811a;	 Catch:{ Exception -> 0x0082 }
            r0 = r0.f15819g;	 Catch:{ Exception -> 0x0082 }
            r0 = r0.get();	 Catch:{ Exception -> 0x0082 }
            r0 = (com.facebook.search.bootstrap.db.data.BootstrapDbInsertHelper) r0;	 Catch:{ Exception -> 0x0082 }
            r0.m23409b(r7);	 Catch:{ Exception -> 0x0082 }
        L_0x0033:
            r0 = r6.f15811a;
            com.facebook.search.bootstrap.sync.BootstrapEntitiesLoader.m23458h(r0);
            r0 = r6.f15811a;
            r0 = r0.f15821i;
            r1 = "time_to_write_bootstrap_entities";
            r0.m23365b(r1);
            r0 = r6.f15811a;
            r0 = r0.f15822j;
            r0 = r0.edit();
            r1 = com.facebook.search.prefs.GraphSearchPrefKeys.f15919d;
            r2 = r6.f15811a;
            r2 = com.facebook.search.bootstrap.sync.BootstrapEntitiesLoader.m23459i(r2);
            r0.a(r1, r2);
            r2 = r7.m23434a();
            r4 = 0;
            r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r1 <= 0) goto L_0x0067;
        L_0x005e:
            r1 = com.facebook.search.prefs.GraphSearchPrefKeys.f15917b;
            r2 = r7.m23434a();
            r0.a(r1, r2);
        L_0x0067:
            r0.commit();
            r0 = r6.f15811a;
            r0 = r0.f15821i;
            r1 = "time_to_load_bootstrap_entities";
            r0.m23368c(r1);
        L_0x0073:
            return;
        L_0x0074:
            r0 = r6.f15811a;	 Catch:{  }
            r0 = r0.f15819g;	 Catch:{  }
            r0 = r0.get();	 Catch:{  }
            r0 = (com.facebook.search.bootstrap.db.data.BootstrapDbInsertHelper) r0;	 Catch:{  }
            r0.m23407a(r7);	 Catch:{  }
            goto L_0x0033;
        L_0x0082:
            r0 = move-exception;
            r1 = r6.f15811a;	 Catch:{ all -> 0x00a6 }
            r2 = com.facebook.search.common.errors.GraphSearchError.INSERT_DB_BOOTSTRAP_ENTITY_FAIL;	 Catch:{ all -> 0x00a6 }
            r1.f15828p = r2;	 Catch:{ all -> 0x00a6 }
            r1 = r6.f15811a;	 Catch:{ all -> 0x00a6 }
            r1 = r1.f15817e;	 Catch:{ all -> 0x00a6 }
            r2 = com.facebook.search.common.errors.GraphSearchError.INSERT_DB_BOOTSTRAP_ENTITY_FAIL;	 Catch:{ all -> 0x00a6 }
            r1.a(r2, r0);	 Catch:{ all -> 0x00a6 }
            r1 = r6.f15811a;	 Catch:{ all -> 0x00a6 }
            r1 = r1.f15821i;	 Catch:{ all -> 0x00a6 }
            r2 = r7.m23435b();	 Catch:{ all -> 0x00a6 }
            r3 = "time_to_write_bootstrap_entities";
            r1.m23362a(r2, r0, r3);	 Catch:{ all -> 0x00a6 }
            r0 = r6.f15811a;
            com.facebook.search.bootstrap.sync.BootstrapEntitiesLoader.m23458h(r0);
            goto L_0x0073;
        L_0x00a6:
            r0 = move-exception;
            r1 = r6.f15811a;
            com.facebook.search.bootstrap.sync.BootstrapEntitiesLoader.m23458h(r1);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.bootstrap.sync.BootstrapEntitiesLoader.3.onSuccess(java.lang.Object):void");
        }

        public void onFailure(Throwable th) {
            this.f15811a.f15828p = GraphSearchError.FETCH_DB_BOOTSTRAP_ENTITY_PRE_FAIL;
            this.f15811a.f15817e.a(GraphSearchError.FETCH_DB_BOOTSTRAP_ENTITY_FAIL, th);
            BootstrapEntitiesLoader.m23458h(this.f15811a);
            this.f15811a.f15821i.m23370d("time_to_load_bootstrap_entities");
        }
    }

    /* compiled from: ex_tag_text_length */
    public enum BootstrapEntitySource {
        PROFILE_VIEW,
        FRIENDSHIP_STATUS_CHANGE
    }

    public static com.facebook.search.bootstrap.sync.BootstrapEntitiesLoader m23450a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15812r;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.bootstrap.sync.BootstrapEntitiesLoader.class;
        monitor-enter(r1);
        r0 = f15812r;	 Catch:{ all -> 0x003a }
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
        r0 = m23456b(r0);	 Catch:{ all -> 0x0035 }
        f15812r = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15812r;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.bootstrap.sync.BootstrapEntitiesLoader.a(com.facebook.inject.InjectorLike):com.facebook.search.bootstrap.sync.BootstrapEntitiesLoader");
    }

    private static BootstrapEntitiesLoader m23456b(InjectorLike injectorLike) {
        BootstrapEntitiesLoader bootstrapEntitiesLoader = new BootstrapEntitiesLoader((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 772), IdBasedProvider.a(injectorLike, 4324), GraphSearchErrorReporter.a(injectorLike), BootstrapEntitiesNetworkFetcher.m23444b(injectorLike), DbBootstrapPerformanceLogger.m23345a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), DefaultUserInteractionController.a(injectorLike), LoggedInUserSessionManager.a(injectorLike));
        com.facebook.inject.Lazy b = IdBasedSingletonScopeProvider.b(injectorLike, 10466);
        com.facebook.inject.Lazy a = IdBasedLazy.a(injectorLike, 10467);
        com.facebook.inject.Lazy b2 = IdBasedSingletonScopeProvider.b(injectorLike, 10462);
        com.facebook.inject.Lazy b3 = IdBasedSingletonScopeProvider.b(injectorLike, 3219);
        bootstrapEntitiesLoader.f15819g = b;
        bootstrapEntitiesLoader.f15820h = a;
        bootstrapEntitiesLoader.f15824l = b2;
        bootstrapEntitiesLoader.f15826n = b3;
        return bootstrapEntitiesLoader;
    }

    @Inject
    public BootstrapEntitiesLoader(ExecutorService executorService, ExecutorService executorService2, Provider<TriState> provider, Provider<Boolean> provider2, GraphSearchErrorReporter graphSearchErrorReporter, BootstrapEntitiesNetworkFetcher bootstrapEntitiesNetworkFetcher, DbBootstrapPerformanceLogger dbBootstrapPerformanceLogger, FbSharedPreferences fbSharedPreferences, Clock clock, UserInteractionController userInteractionController, LoggedInUserSessionManager loggedInUserSessionManager) {
        this.f15813a = executorService;
        this.f15814b = executorService2;
        this.f15815c = provider;
        this.f15816d = provider2;
        this.f15817e = graphSearchErrorReporter;
        this.f15818f = bootstrapEntitiesNetworkFetcher;
        this.f15821i = dbBootstrapPerformanceLogger;
        this.f15822j = fbSharedPreferences;
        this.f15823k = clock;
        this.f15825m = userInteractionController;
        this.f15827o = loggedInUserSessionManager;
        this.f15828p = GraphSearchError.NO_ERROR;
        this.f15821i.m23361a(m23468c());
    }

    public final void m23465a() {
        if (m23468c()) {
            long l = m23461l();
            if (this.f15823k.a() - l >= ((long) ((QeAccessor) this.f15826n.get()).a(ExperimentsForSearchAbTestModule.bo, 24)) * 3600000) {
                m23453a(this, l);
                return;
            } else {
                ExecutorDetour.a(this.f15814b, new C11171(this), -1578062611);
                return;
            }
        }
        m23453a(this, 0);
    }

    public final void m23467b() {
        m23453a(this, m23461l());
    }

    public final synchronized void m23466a(ImmutableList<Long> immutableList, final BootstrapEntitySource bootstrapEntitySource) {
        if (this.f15829q == null && !((Boolean) this.f15816d.get()).booleanValue()) {
            int n = 20 - m23463n(this);
            if (n > 0) {
                List<String> arrayList = new ArrayList();
                int size = immutableList.size();
                int i = 0;
                while (i < size) {
                    int i2;
                    Long l = (Long) immutableList.get(i);
                    if (!m23455a(l)) {
                        arrayList.add(String.valueOf(l));
                        i2 = n - 1;
                        if (i2 == 0) {
                            break;
                        }
                    } else {
                        i2 = n;
                    }
                    i++;
                    n = i2;
                }
                if (!arrayList.isEmpty()) {
                    StringBuffer stringBuffer = new StringBuffer();
                    final StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer.append(bootstrapEntitySource.name());
                    stringBuffer.append("-");
                    for (String append : arrayList) {
                        stringBuffer2.append(append);
                        stringBuffer2.append(" ");
                    }
                    this.f15829q = this.f15818f.m23446a((List) arrayList);
                    final String append2 = stringBuffer.toString() + stringBuffer2.toString();
                    Futures.a(this.f15829q, new FutureCallback<BootstrapEntities>(this) {
                        final /* synthetic */ BootstrapEntitiesLoader f15810d;

                        public void onSuccess(Object obj) {
                            BootstrapEntities bootstrapEntities = (BootstrapEntities) obj;
                            this.f15810d.f15821i.m23372e(append2);
                            try {
                                this.f15810d.f15825m.c();
                                int a = ((BootstrapDbInsertHelper) this.f15810d.f15819g.get()).m23406a(bootstrapEntities.m23436c());
                                this.f15810d.f15821i.m23360a(append2, ImmutableBiMap.b("source", bootstrapEntitySource.name() + (a > 0 ? "" : "-AlreadyExists")));
                                if (a > 0) {
                                    BootstrapEntitiesLoader.m23452a(this.f15810d, a + BootstrapEntitiesLoader.m23463n(this.f15810d));
                                    BootstrapEntitiesLoader.m23454a(this.f15810d, stringBuffer2.toString(), true);
                                }
                            } catch (SQLiteException e) {
                                this.f15810d.f15821i.m23373f(append2);
                            }
                            BootstrapEntitiesLoader.m23458h(this.f15810d);
                        }

                        public void onFailure(Throwable th) {
                            this.f15810d.f15817e.a(GraphSearchError.FETCH_DB_BOOTSTRAP_ENTITY_FAIL, th);
                            BootstrapEntitiesLoader.m23458h(this.f15810d);
                            this.f15810d.f15821i.m23373f(append2);
                        }
                    }, this.f15814b);
                }
            }
        }
    }

    public static boolean m23457g(BootstrapEntitiesLoader bootstrapEntitiesLoader) {
        boolean z;
        if (bootstrapEntitiesLoader.f15822j.a(GraphSearchPrefKeys.f15922g, false)) {
            z = false;
        } else {
            z = true;
        }
        if (z || bootstrapEntitiesLoader.m23462m()) {
            return true;
        }
        return false;
    }

    public static synchronized void m23453a(BootstrapEntitiesLoader bootstrapEntitiesLoader, long j) {
        synchronized (bootstrapEntitiesLoader) {
            if (bootstrapEntitiesLoader.f15829q == null && !((Boolean) bootstrapEntitiesLoader.f15816d.get()).booleanValue()) {
                if (j == 0) {
                    try {
                        bootstrapEntitiesLoader.f15821i.m23357a(-1, "time_to_load_bootstrap_entities");
                    } catch (Throwable e) {
                        bootstrapEntitiesLoader.f15828p = GraphSearchError.FETCH_DB_BOOTSTRAP_ENTITY_PRE_FAIL;
                        bootstrapEntitiesLoader.f15817e.a(GraphSearchError.FETCH_DB_BOOTSTRAP_ENTITY_PRE_FAIL, e);
                    }
                } else {
                    bootstrapEntitiesLoader.f15821i.m23357a(bootstrapEntitiesLoader.f15823k.a() - j, "time_to_load_bootstrap_entities");
                }
                bootstrapEntitiesLoader.f15829q = bootstrapEntitiesLoader.f15818f.m23445a(j);
                Futures.a(bootstrapEntitiesLoader.f15829q, new C11193(bootstrapEntitiesLoader), bootstrapEntitiesLoader.f15813a);
            }
        }
    }

    public static synchronized void m23458h(BootstrapEntitiesLoader bootstrapEntitiesLoader) {
        synchronized (bootstrapEntitiesLoader) {
            bootstrapEntitiesLoader.f15829q = null;
        }
    }

    public final boolean m23468c() {
        return m23460j() && m23461l() > 0;
    }

    public static String m23459i(BootstrapEntitiesLoader bootstrapEntitiesLoader) {
        User c = bootstrapEntitiesLoader.f15827o.c();
        if (c != null) {
            return c.n().a();
        }
        return null;
    }

    private boolean m23460j() {
        String i = m23459i(this);
        return i != null && i.equals(this.f15822j.a(GraphSearchPrefKeys.f15919d, ""));
    }

    private long m23461l() {
        return this.f15822j.a(GraphSearchPrefKeys.f15917b, 0);
    }

    public final long m23469d() {
        return m23460j() ? this.f15823k.a() - m23461l() : this.f15823k.a();
    }

    private boolean m23462m() {
        SQLiteDatabase a = ((BootstrapDatabaseSupplier) this.f15824l.get()).a();
        SQLiteDetour.a(a, -1974825853);
        try {
            int a2 = ((BootstrapDbPropertyUtil) this.f15820h.get()).a(BootstrapDbProperties.f15666a, -1);
            return (a2 == -1 || VERSION.SDK_INT < 21 || a2 == VERSION.SDK_INT) ? false : true;
        } finally {
            SQLiteDetour.b(a, 393035783);
        }
    }

    public static int m23463n(BootstrapEntitiesLoader bootstrapEntitiesLoader) {
        return bootstrapEntitiesLoader.f15822j.a(GraphSearchPrefKeys.f15923h, 0);
    }

    public static void m23452a(BootstrapEntitiesLoader bootstrapEntitiesLoader, int i) {
        bootstrapEntitiesLoader.f15822j.edit().a(GraphSearchPrefKeys.f15923h, i).commit();
    }

    private String m23464o() {
        return this.f15822j.a(GraphSearchPrefKeys.f15924i, " ");
    }

    private boolean m23455a(Long l) {
        return m23464o().contains(" " + String.valueOf(l) + " ");
    }

    public static void m23454a(BootstrapEntitiesLoader bootstrapEntitiesLoader, String str, boolean z) {
        Editor edit = bootstrapEntitiesLoader.f15822j.edit();
        PrefKey prefKey = GraphSearchPrefKeys.f15924i;
        if (z) {
            str = bootstrapEntitiesLoader.m23464o() + str;
        }
        edit.a(prefKey, str).commit();
    }
}
